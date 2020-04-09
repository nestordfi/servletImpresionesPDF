package ec.com.bancoInternacional.services.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.ejb.Stateless;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;

import com.ibm.connector.as400.ConnAS;

import ec.com.bancoInternacional.config.Application;
import ec.com.bancoInternacional.cs0052.CIUEDSDATA;
import ec.com.bancoInternacional.cs0052.NCOEDSDATA;
import ec.com.bancoInternacional.cs0052.PCLIDSINP;
import ec.com.bancoInternacional.cs0052.PRCONSCIIU;
import ec.com.bancoInternacional.cs0052.PRCONSNCODI;
import ec.com.bancoInternacional.cs0122.ELICUBLK;
import ec.com.bancoInternacional.cs0122.GETOFICINA;
import ec.com.bancoInternacional.we0038.CATAYUCNF;
import ec.com.bancoInternacional.we0038.CATAYUNCG;
import ec.com.bancoInternacional.we0038.CNFINPDATA;
import ec.com.bancoInternacional.we0038.NCGINPDATOS;
import ec.com.bancoInternacional.services.domain.ActEconomicaInfo;
import ec.com.bancoInternacional.services.domain.ActEconomicaInfoPK;
import ec.com.bancoInternacional.services.domain.CantonInfo;
import ec.com.bancoInternacional.services.domain.Catalogo;
import ec.com.bancoInternacional.services.domain.CcliCatalogo;
import ec.com.bancoInternacional.services.domain.EstadoCiudadModeloCatalogo;
import ec.com.bancoInternacional.services.domain.Ncodig;
import ec.com.bancoInternacional.services.domain.OficinaInfo;
import ec.com.bancoInternacional.services.domain.PaisInfo;
import ec.com.bancoInternacional.services.exception.PooledTrxException;
import ec.com.bancoInternacional.services.ibm.pool.PooledTrx;
import ec.com.bancoInternacional.services.mapping.CcliCatalogoMapper;
import ec.com.bancoInternacional.services.mapping.NcodigMapper;
import ec.com.bancoInternacional.services.util.CatalogoNcodigUtil;
import ec.com.bancoInternacional.services.util.ClientActEconimicaParameter;
import ec.com.bancoInternacional.services.util.Constantes;
import ec.com.bancoInternacional.services.util.ConsultaNcodigParametro;
import ec.com.bancoInternacional.services.util.NcodigClaveParametro;

/**
 * Autor: Sandro Guevara
 * Objetivo: Clase concreta que implementa los servicios de Catalogos
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */
@Stateless
public class CatalogoServiceImpl extends PooledTrx implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(CatalogoServiceImpl.class);

	private NcodigMapper ncodigMapper;
	private CcliCatalogoMapper ccliCatalogoMapper;
	private CatalogoNcodigUtil catalogoUtil;
	//private MasivasMapper mapper;

	public CatalogoServiceImpl() {
		super();
		ncodigMapper = new NcodigMapper();
		ccliCatalogoMapper = new CcliCatalogoMapper();
		catalogoUtil = new CatalogoNcodigUtil();		
	}

	/**
	 * Obtiene una coleccion de tipo CcliCatalog, filtrando por parametros de
	 * nivel, ncod1 y ncod2
	 * 
	 * @param parameters
	 *            objeto que contiene parametros de consulta
	 * @return List<CcliCatalog>
	 */
	
	public List<CcliCatalogo> recuperarCatalogoPorTablaYNivel(final Collection<CcliCatalogo> catalogs,
			final ConsultaNcodigParametro parameter) throws PooledTrxException {
		List<CcliCatalogo> filteredCatalogs = new ArrayList<CcliCatalogo>((List<CcliCatalogo>) catalogs);
		Predicate catalogPredicate = null;
		try {
			catalogPredicate = new Predicate() {
				@Override
				public boolean evaluate(Object ncodig) {
					CcliCatalogo cli = (CcliCatalogo) ncodig;
					return cli.getNcnivl().compareTo(new BigDecimal(parameter.getNivel())) == 0
							&& (parameter.getCod1().equals(cli.getNccod1()))
							&& (parameter.getCod2().equals(cli.getNccod2()));
				}
			};
			CollectionUtils.filter(filteredCatalogs, catalogPredicate);
		} catch (Exception e) {
			logger.error(e);
			throw new PooledTrxException(e.getMessage());
		} finally {
			catalogPredicate = null;
		}

		return filteredCatalogs;
	}
	
	/**
	 * Retorna una coleccion de tipo NcodigCatalog filtrando por parametros
	 * 
	 * @param ncodigParams
	 *            ConsultaNcodigParameter parametros, de tabla nivl1...nivl4
	 * @param levels
	 *            NcodigBeanParameter campo para obtener claves compuestas de
	 *            ncodig
	 */

	public List<Ncodig> recuperarCatalogo(final Object ncodigParams, final Object levels) throws PooledTrxException {

		String[] data = null;
		List<Ncodig> catalogos = new ArrayList<Ncodig>();
		try {
			data = this.consultaNcodig((ConsultaNcodigParametro) ncodigParams);
			for (String row : data) {
				if (row != null) {
					catalogos.add(ncodigMapper.mapStreamToNcodig(row, (NcodigClaveParametro) levels));
				}
			}
		} catch (Exception ex) {
			logger.error(ex);
			throw new PooledTrxException(ex.getMessage());
		} finally {
			data = null;
		}
		return catalogos;

	}

	/**
	 * Obtiene una coleccion de tipo CcliCatalog, para los catalogos nuevos CCLI
	 * a partir del programa de servicio PRCONSNCODI
	 * 
	 * @param table,
	 *            tabla para filtar de NCODIG
	 * @return List<CcliCatalog>
	 */

	public List<CcliCatalogo> recuperarCatalogoPorTabla(final String table) throws PooledTrxException {
		logger.debug("Inicia proceso recuperarCatalogoPorTabla");
		
		List<CcliCatalogo> catalogs = null;
		PRCONSNCODI ncodi = null;
		NCOEDSDATA[] ncodsout = null;
		try {
			ncodi = new PRCONSNCODI();

			ncodi.setCODTBINP(table);

			invokeTrx(ncodi);
			ncodsout = ncodi.getNCODSOUT();
			if (ncodi.getTRXMSGOUT() != null) {
				String[] trxoerror = ncodi.getTRXMSGOUT().getTRXOERROR();
			}

			catalogs = ccliCatalogoMapper.mappingNcoesdataToCcliCatalog(ncodsout);
		} catch (Exception e) {
			logger.error(e);
			
			throw new PooledTrxException(e.getMessage());
		} finally {
			ncodi = null;
			ncodsout = null;
			
			logger.debug("Finaliza proceso recuperarCatalogoPorTabla");
		}
		return catalogs;
	}

	
	/**
	 * Obtiene una coleccion de tipo CountryInfo, filtrando de la coleccion de
	 * CCLI
	 * 
	 * @param catalogs
	 *            Coleccion de catalogos de tipo CCLI
	 * @return List<CountryInfo>
	 * @throws PooledTrxException
	 */
	
	public List<PaisInfo> recuperarCatalogoPaises(final Collection<CcliCatalogo> catalogs) throws PooledTrxException {
		logger.debug("Inicia proceso recuperarCatalogoPaises");
		
		List<CcliCatalogo> countryCatalogsNivel3 = null;
		List<CcliCatalogo> countryCatalogsNivel4 = null;
		List<PaisInfo> countryList = null;
		ConsultaNcodigParametro parentParameter = new ConsultaNcodigParametro(Constantes.CCLI_TABLA_CATALOGO,
				Constantes.CCLI_NIVEL, Constantes.CCLI_NIVEL_1, Constantes.PAIS_NIVEL_2, "", "");
		ConsultaNcodigParametro childParameter = new ConsultaNcodigParametro(Constantes.CCLI_TABLA_CATALOGO,
				Constantes.CCLI_NIVEL_HIJO, Constantes.CCLI_NIVEL_1, Constantes.PAIS_NIVEL_2, "", "");
		try {
			countryCatalogsNivel3 = (List<CcliCatalogo>) recuperarCatalogoPorTablaYNivel(catalogs, parentParameter);
			countryCatalogsNivel4 = (List<CcliCatalogo>) recuperarCatalogoPorTablaYNivel(catalogs, childParameter);
			countryList = new ArrayList<PaisInfo>();
			for (CcliCatalogo cat : countryCatalogsNivel3) {
				PaisInfo cinfo = new PaisInfo();
				cinfo.setId(cat.getNccod3());
				cinfo.setValue(cat.getNcdesc());
				cinfo.setWorldId(cat.getNccod4());
				for (CcliCatalogo cat3 : countryCatalogsNivel4) {
					if (cat.getNccod3().equals(cat3.getNccod3())) {
						if (Constantes.PAIS_RIESGO_CATALOGO.equals(cat3.getNccod4())) {
							cinfo.setHighRisk(cat3.getNcdat1() != null && Constantes.BOOLEAN_VERDADERO_FLAG2.equals(cat3.getNcdat1()) ? true : false);
						} else if (Constantes.PAIS_CATALOGO_FATCA.equals(cat3.getNccod4())) {
							cinfo.setFatca(cat3.getNcdat1() != null && Constantes.BOOLEAN_VERDADERO_FLAG2.equals(cat3.getNcdat1()) ? true : false);
						} else if (Constantes.PAIS_PREFIJO_CATALOGO.equals(cat3.getNccod4())) {
							cinfo.setPrefix(cat3.getNcdat1());
						}
					}
				}
				countryList.add(cinfo);
			}

		} catch (Exception e) {
			logger.error(e);
			throw new PooledTrxException(e.getMessage());
		} finally {
			countryCatalogsNivel3 = null;
			countryCatalogsNivel4 = null;
			parentParameter = null;
			childParameter = null;
			
			logger.debug("Finaliza proceso recuperarCatalogoPaises");
		}
		return countryList;
	}

	/**
	 * Consulta la estructura CATAYUNCG para consulta de catalogos NCODIG
	 * 
	 * @param parameterObject:
	 *            Objeto que encapsula los parametros de busqueda
	 * @return arreglo de String con informacion de NCODIG
	 * @throws PooledTrxException
	 */
	private String[] consultaNcodig(final ConsultaNcodigParametro parameterObject) throws PooledTrxException {
		logger.debug("Inicia proceso consultaNcodig");
		
		String[] resp = null;
		CATAYUNCG ncodig = null;

		NCGINPDATOS ngcInpDatos = null;
		String[] ncgDetalle = null;

		try {
			ncodig = new CATAYUNCG();
			ngcInpDatos = ncodig.getCANDATAINP();
			ncodigMapper.mapNcodigParameterToNgcImpDatos(parameterObject, ngcInpDatos);
			invokeTrx(ncodig);
			if (ncodig.getReturnValue() != 0) {
				String errorMessage = catalogoUtil.buildErrorMessage(parameterObject,
						catalogoUtil.getStrErrores(ncodig.getTRXMSGOUT().getTRXOERROR()));
				// TODO: if logger.debug is enabled
				logger.error(errorMessage);
				throw new PooledTrxException(errorMessage);
			}
			ncgDetalle = ncodig.getCANDATAOUT().getNCGDETALLE();
			if (ncgDetalle == null) {
				throw new PooledTrxException("No data");
			}
			resp = ncodigMapper.mapNcgDetalleToArray(ncgDetalle);
		} catch (Exception e) {
			logger.error(e);
			
			throw new PooledTrxException(e.getMessage());
		} finally {
			ngcInpDatos = null;
			ncodig = null;
			ncgDetalle = null;
			
			logger.debug("Finaliza proceso consultaNcodig");
		}
		return resp;
	}

	private List<Ncodig> getNcodigList(ConsultaNcodigParametro consultaNcodigParameter,
			NcodigClaveParametro ncodigBeanParameter) throws PooledTrxException {
		String[] data = null;
		try {
			data = this.consultaNcodig((ConsultaNcodigParametro) consultaNcodigParameter);
		} catch (PooledTrxException e) {
			e.printStackTrace();
		}
		List<Ncodig> catalogs = new ArrayList<Ncodig>();
		for (String row : data) {
			if (row != null) {
				catalogs.add(ncodigMapper.mapStreamToNcodig(row, (NcodigClaveParametro) ncodigBeanParameter));
			}
		}
		return catalogs;
	}

	public List<CantonInfo> recuperarCantonesLocal() throws PooledTrxException {

		List<Ncodig> ctgProvincias = this.getNcodigList(new ConsultaNcodigParametro(Constantes.CANTON_TABLA_CATALOGO,
				Constantes.CANTON_NIVEL_1, "", "", "", " "), new NcodigClaveParametro(true, true, true, true, 2));

		List<Ncodig> ctgCantones = this.getNcodigList(new ConsultaNcodigParametro(Constantes.CANTON_TABLA_CATALOGO,
				Constantes.CANTON_NIVEL_2, "", "", "", " "), new NcodigClaveParametro(true, true, true, true, 2));

		List<CantonInfo> lstCantones = new ArrayList<CantonInfo>();
		CantonInfo itemCatgInfo = null;
		for (Ncodig itemProvincia : ctgProvincias) {
			if (itemProvincia != null) {
				for (Ncodig itemCanton : ctgCantones) {
					if (itemCanton != null) {
						if (itemProvincia.getIdExt().equals(itemCanton.getIdExt().substring(0, 2))) {
							itemCatgInfo = new CantonInfo();
							itemCatgInfo.setId(itemCanton.getIdExt());
							itemCatgInfo.setValue(itemCanton.getValue());
							itemCatgInfo.setCodigoProvincia(itemProvincia.getIdExt());
							itemCatgInfo.setProvincia(itemProvincia.getValue());

							lstCantones.add(itemCatgInfo);
						}
					}
				}
			}

		}

		return lstCantones;
	}
	/**
	 * Crea una coleccion de objetos de tipo ActEconomicaInfo, invocando al
	 * programa de Servicio PRCONSCIIU
	 * 
	 * @return Map<ActEconomicaInfoPK, List<ActEconomicaInfo>>
	 */

	public Map<ActEconomicaInfo, List<ActEconomicaInfo>> recuperarActEconomicaCliente() throws PooledTrxException {
		logger.debug("Inicia proceso recuperarActEconomicaCliente");
		
		PRCONSCIIU prconsciiu = new PRCONSCIIU();
		PCLIDSINP pclidsinp = new PCLIDSINP();
		CIUEDSDATA[] encontrados = null;
		List<ActEconomicaInfo> lstActEconomicaInfo = new ArrayList<ActEconomicaInfo>();
		Map<ActEconomicaInfo, List<ActEconomicaInfo>> mapActEconomicaInfo = null;

		ClientActEconimicaParameter actEconomicaParameter = new ClientActEconimicaParameter();
		actEconomicaParameter.setIpadress("");
		actEconomicaParameter.setIpcanal("");
		actEconomicaParameter.setIpcodibs(new BigDecimal("0"));
		actEconomicaParameter.setIpcodidn("");
		actEconomicaParameter.setIpusrbin("");

		pclidsinp = ccliCatalogoMapper.mapActEcomicaParameterToCliImpData(actEconomicaParameter);
		prconsciiu.setCLIDSINP(pclidsinp);
		try {
			invokeTrx(prconsciiu);

			if (prconsciiu.getReturnValue() == 0) {
				encontrados = prconsciiu.getCIUDSOUT();

				for (CIUEDSDATA itemEncontrados : encontrados) {
					ActEconomicaInfo itemActEconomicaInfo = new ActEconomicaInfo();
					ActEconomicaInfoPK pk = new ActEconomicaInfoPK();

					pk.setCcicc1(itemEncontrados.getCCICC1());
					pk.setCcicc2(itemEncontrados.getCCICC2());
					pk.setCcicc3(itemEncontrados.getCCICC3());
					pk.setCcicc4(itemEncontrados.getCCICC4());
					pk.setCcicc5(itemEncontrados.getCCICC5());
					pk.setCcicc6(itemEncontrados.getCCICC6());
					pk.setCciniv(itemEncontrados.getCCINIV());
					itemActEconomicaInfo.setId(pk);
					itemActEconomicaInfo.setCcicac(itemEncontrados.getCCICAC());
					itemActEconomicaInfo.setCcicin(itemEncontrados.getCCICIN());
					itemActEconomicaInfo.setCcides(itemEncontrados.getCCIDES());
					itemActEconomicaInfo.setCciest(itemEncontrados.getCCIEST());
					itemActEconomicaInfo.setCcifec(itemEncontrados.getCCIFEC());
					itemActEconomicaInfo.setCcihor(itemEncontrados.getCCIHOR());
					itemActEconomicaInfo.setCciter(itemEncontrados.getCCITER());
					itemActEconomicaInfo.setCciusr(itemEncontrados.getCCIUSR());

					lstActEconomicaInfo.add(itemActEconomicaInfo);
				}

				mapActEconomicaInfo = cargarEstructuraMapa(lstActEconomicaInfo);
			}
		} catch (Exception e) {
			logger.error(e);
			
			throw new PooledTrxException(e.getMessage());
		} finally {
			prconsciiu = null;
			pclidsinp = null;
			encontrados = null;
			
			logger.debug("Finaliza proceso recuperarActEconomicaCliente");
		}

		return mapActEconomicaInfo;
	}
	
	/*
	 * cargar a una estructura por mapas <key padre, lst hijos>
	 */
	public Map<ActEconomicaInfo, List<ActEconomicaInfo>> cargarEstructuraMapa(List<ActEconomicaInfo> lstActEconomicaInfo){
		Map<ActEconomicaInfo, List<ActEconomicaInfo>> mapActEconomicaInfo =  new LinkedHashMap<ActEconomicaInfo, List<ActEconomicaInfo>>();
		for (ActEconomicaInfo itemPadres : lstActEconomicaInfo) {
			if (esPadreNivel1a5(itemPadres)) {
				try {
					mapActEconomicaInfo.put(itemPadres, obtenerNodosHijos(lstActEconomicaInfo, itemPadres));
				} catch (Exception error) {
					error.printStackTrace();
				}
			} else if (esPadreNivel6(itemPadres)) {
				mapActEconomicaInfo.put(itemPadres, null);
			}

		}
		return mapActEconomicaInfo;
	}

	private boolean esPadreNivel6(ActEconomicaInfo itemPadres) {
		return itemPadres != null && itemPadres.getId().getCciniv() != null
				&& !"".equals(itemPadres.getId().getCciniv().trim())
				&& (Integer.valueOf(itemPadres.getId().getCciniv()) == 6);
	}

	private boolean esPadreNivel1a5(ActEconomicaInfo itemPadres) {
		return itemPadres != null && itemPadres.getId().getCciniv() != null
				&& !"".equals(itemPadres.getId().getCciniv().trim())
				&& (Integer.valueOf(itemPadres.getId().getCciniv()) >= 1
						&& Integer.valueOf(itemPadres.getId().getCciniv()) <= 5);
	}

	public List<ActEconomicaInfo> obtenerNodosHijos(List<ActEconomicaInfo> lista, ActEconomicaInfo padre) {
		List<ActEconomicaInfo> retorna = new ArrayList<ActEconomicaInfo>();

		switch (Integer.valueOf(padre.getId().getCciniv())) {
		case 1:
			cargarActividadEconimicaNivel2(lista, padre, retorna);
			break;
		case 2:
			cargarActividadEconimicaNivel3(lista, padre, retorna);
			break;
		case 3:
			cargarActividadEconimicaNivel4(lista, padre, retorna);
			break;
		case 4:
			cargarActividadEconimicaNivel5(lista, padre, retorna);
			break;
		case 5:
			cargarActividadEconimicaNivel6(lista, padre, retorna);
			break;
		}

		return retorna;
	}

	private void cargarActividadEconimicaNivel6(List<ActEconomicaInfo> lista, ActEconomicaInfo padre,
			List<ActEconomicaInfo> retorna) {
		for (ActEconomicaInfo item : lista) {
			if (item.getId().getCciniv().equals(Constantes.ACT_ECONOMICA_NIVEL6)
					&& item.getId().getCcicc5().equals(padre.getId().getCcicc5())) {
				retorna.add(item);
			}
		}
	}

	private void cargarActividadEconimicaNivel5(List<ActEconomicaInfo> lista, ActEconomicaInfo padre,
			List<ActEconomicaInfo> retorna) {
		for (ActEconomicaInfo item : lista) {
			if (item.getId().getCciniv().equals(Constantes.ACT_ECONOMICA_NIVEL5)
					&& item.getId().getCcicc4().equals(padre.getId().getCcicc4())) {
				retorna.add(item);
			}
		}
	}

	private void cargarActividadEconimicaNivel4(List<ActEconomicaInfo> lista, ActEconomicaInfo padre,
			List<ActEconomicaInfo> retorna) {
		for (ActEconomicaInfo item : lista) {
			if (item.getId().getCciniv().equals(Constantes.ACT_ECONOMICA_NIVEL4)
					&& item.getId().getCcicc3().equals(padre.getId().getCcicc3())) {
				retorna.add(item);
			}
		}
	}

	private void cargarActividadEconimicaNivel3(List<ActEconomicaInfo> lista, ActEconomicaInfo padre,
			List<ActEconomicaInfo> retorna) {
		for (ActEconomicaInfo item : lista) {
			if (item.getId().getCciniv().equals(Constantes.ACT_ECONOMICA_NIVEL3)
					&& item.getId().getCcicc2().equals(padre.getId().getCcicc2())) {
				retorna.add(item);
			}
		}
	}

	private void cargarActividadEconimicaNivel2(List<ActEconomicaInfo> lista, ActEconomicaInfo padre,
			List<ActEconomicaInfo> retorna) {
		for (ActEconomicaInfo item : lista) {
			if (item.getId().getCciniv().equals(Constantes.ACT_ECONOMICA_NIVEL2)
					&& item.getId().getCcicc1().equals(padre.getId().getCcicc1())) {
				retorna.add(item);
			}
		}
	}
	public List<Catalogo> recuperarCatalogoCnofc(String codigo) throws PooledTrxException {
		logger.debug("Inicia proceso recuperarCatalogoCnofc");
		
		List<Catalogo> lista = new ArrayList<Catalogo>();

		String[] resp = null;

		CATAYUCNF cnofc = new CATAYUCNF();
		CNFINPDATA cnfInpData = cnofc.getCACDATAINP();

		cnfInpData.setCNFCODIGO(codigo);
		cnofc.setCACDATAINP(cnfInpData);

		try {
			invokeTrx(cnofc);

			if (cnofc.getReturnValue() == 0) {
				String[] cnfDetalle = cnofc.getCACDATAOUT().getCNFDETALLE();
				if (cnfDetalle != null) {
					Vector<String> vCat = new Vector<String>();
					String[] cat = cnfDetalle;

					for (String item : cat)
						if (item != null && item.trim().length() > 0)
							vCat.addElement(item.trim());
						else
							break;
					int catSize = vCat.size();
					if (catSize > 0) {
						String[] aux = new String[catSize];
						resp = vCat.toArray(aux);
						aux = null;
					}
					vCat = null;
				}
			}
		} catch (Exception e) {
			logger.error(e);
		} finally {
			cnfInpData = null;
			cnofc = null;
			
			logger.debug("Finaliza proceso recuperarCatalogoCnofc");
		}

		lista = ncodigMapper.getObjCnofc(resp);
		return lista;
	}
	
	public List<Ncodig> recuperarPropositoRelacionComercialCatalog() throws PooledTrxException{
		List<Ncodig> tIdCatalog = null;
//		List<Ncodig> lstRetorna = new ArrayList<Ncodig>();
		
		try {			
			tIdCatalog = this.getNcodigList(new ConsultaNcodigParametro(
					Constantes.RELACION_COMERCIAL_TABLA, 
					Constantes.RELACION_COMERCIAL_NIVEL, 
					Constantes.RELACION_COMERCIAL_COD1, 
					Constantes.RELACION_COMERCIAL_COD2, "", ""),
					new NcodigClaveParametro(true, true, true, true, 2));
//			
//			for(Ncodig item : tIdCatalog){
//				if(item.getNcVal()[2].equals(Constantes.RELACION_COMERCIAL_NCVAL3)){
//					lstRetorna.add(item);
//				}
//			}
		
		} catch (Exception e) {
			logger.error(e);
			throw new PooledTrxException(e.getMessage());
		} 
//		return lstRetorna;
		return tIdCatalog;
	}
	
	public List<Ncodig> recuperarServicioVinculacionCatalog() throws PooledTrxException{
		List<Ncodig> tIdCatalog = null;
		
		try {			
			tIdCatalog = this.getNcodigList(new ConsultaNcodigParametro(Constantes.SERVICIO_VINCULACION_TABLA, Constantes.SERVICIO_VINCULACION_NIVEL, "", "", "", ""),
					new NcodigClaveParametro(true, true, true, true, 2));

		} catch (Exception e) {
			logger.error(e);
			throw new PooledTrxException(e.getMessage());
		} 
		return tIdCatalog;
	}
	
	public List<Ncodig> recuperarParroquiasCatalog() throws PooledTrxException{
		List<Ncodig> parroquiasCatalog = null;
		List<Ncodig> tIdCatalog = null;

		try {
			// primero las provincias
			tIdCatalog = this.getNcodigList(new ConsultaNcodigParametro(Constantes.PARROQUIA_TABLA, Constantes.PROVINCIA_NIVEL, "", "", "", ""),
					new NcodigClaveParametro(true, true, true, true, 2));
			if (tIdCatalog != null) {
				parroquiasCatalog = new ArrayList<Ncodig>();
				for (Ncodig item : tIdCatalog) {
					if (item.getIdExt() != null) {
						tIdCatalog = new ArrayList<Ncodig>();
						
						tIdCatalog = this.getNcodigList(
								new ConsultaNcodigParametro(Constantes.PARROQUIA_TABLA, Constantes.PARROQUIA_NIVEL, item.getIdExt(), "", "", ""),
								new NcodigClaveParametro(false, false, false, true, 3));
						
						parroquiasCatalog.addAll(tIdCatalog);
					}
				}
			}

		} catch (Exception e) {
			logger.error(e);
			throw new PooledTrxException(e.getMessage());
		} 

		return parroquiasCatalog;
	}
	
	public List<Ncodig> recuperarSexoCatalog() throws PooledTrxException{
		List<Ncodig> tIdCatalog = null;
		
		try {			
			tIdCatalog = this.getNcodigList(new ConsultaNcodigParametro(Constantes.SEXO_TABLA, Constantes.SEXO_NIVEL, "", "", "", ""),
					new NcodigClaveParametro(true, true, true, true, 2));

		} catch (Exception e) {
			logger.error(e);
			throw new PooledTrxException(e.getMessage());
		} 
		return tIdCatalog;
	}
	
	public List<Ncodig> recuperarProfesionesCatalog() throws PooledTrxException{
		List<Ncodig> tIdCatalog = null;
		
		try {			
			tIdCatalog = this.getNcodigList(new ConsultaNcodigParametro(Constantes.PROFESION_TABLA, Constantes.PROFESION_NIVEL, "", "", "", ""),
					new NcodigClaveParametro(true, true, true, true, 2));

		} catch (Exception e) {
			logger.error(e);
			throw new PooledTrxException(e.getMessage());
		} 
		return tIdCatalog;
	}
	
	public List<Ncodig> recuperarClasificacionCatalog() throws PooledTrxException{
		List<Ncodig> tIdCatalog = null;
		
		try {			
			tIdCatalog = this.getNcodigList(new ConsultaNcodigParametro(Constantes.CLASIFICACION_TABLA, Constantes.CLASIFICACION_NIVEL, Constantes.CLASIFICACION_COD1, "", "", ""),
					new NcodigClaveParametro(true, true, true, true, 2));

		} catch (Exception e) {
			logger.error(e);
			throw new PooledTrxException(e.getMessage());
		} 
		return tIdCatalog;
	}
	
	public List<Ncodig> recuperarPaisNacionalidadCatalog() throws PooledTrxException{
		List<Ncodig> tIdCatalog = null;
		
		try {			
			tIdCatalog = this.getNcodigList(new ConsultaNcodigParametro(Constantes.NACIONALIDAD_TABLA, Constantes.NACIONALIDAD_NIVEL, Constantes.NACIONALIDAD_COD1, Constantes.NACIONALIDAD_COD2, "", ""),
					new NcodigClaveParametro(true, true, true, true, 2));

		} catch (Exception e) {
			logger.error(e);
			throw new PooledTrxException(e.getMessage());
		} 
		return tIdCatalog;
	}
	
	public List<Ncodig> recuperarEstadoCivilCatalog() throws PooledTrxException{
		List<Ncodig> tIdCatalog = null;

		try {
			tIdCatalog = this.getNcodigList(new ConsultaNcodigParametro(Constantes.EST_CIVIL_TABLA, Constantes.EST_CIVIL_NIVEL, "", "", "", ""),
					new NcodigClaveParametro(true, true, true, true, 2));

		} catch (PooledTrxException e) {
			e.printStackTrace();
		}

		return tIdCatalog;
	}
	/**
	 * Obtiene la data de parametrizacion para Codigo de Extranjeria, de los catalogos tabla CCLI PCDE
	 * @throws PooledTrxException
	 */
	public Map<String, CcliCatalogo> obtenerParametrizacionPCDE() throws PooledTrxException{
		List<CcliCatalogo >parametrizacionCompleta=(List<CcliCatalogo>) this.recuperarCatalogoPorTabla("CCLI");
		ConsultaNcodigParametro parentParameter = new ConsultaNcodigParametro(Constantes.CCLI_TABLA_CATALOGO,
				Constantes.CCLI_NIVEL, Constantes.CCLI_NIVEL_1, Constantes.CCLI_NIVEL_PCDE, "", "");
		List<CcliCatalogo> parametrosCatalogoNivel3= (List<CcliCatalogo>) this.recuperarCatalogoPorTablaYNivel(parametrizacionCompleta, parentParameter);
		HashMap<String, CcliCatalogo> parametrizacion = new HashMap<String, CcliCatalogo>();
		for(CcliCatalogo cat:parametrosCatalogoNivel3){
			parametrizacion.put(cat.getNccod3(), cat);
		}
		return parametrizacion;
	}
	
	public List<EstadoCiudadModeloCatalogo> obtenerCiudadEcuadorReporteCertificacionCatalogo(String paisConstanteTabla, String nivelConstanteTabla){
		List<EstadoCiudadModeloCatalogo> listaCiudadEcuador = new ArrayList<>();
		Connection conn = null;
		try {
			String usuario = "";
			String clave = "";
			
			List<String> listaParametros = ConnAS.listaParametros;
			
			if (listaParametros != null && listaParametros.size() > 0) {			
				usuario = listaParametros.get(0);
				clave = listaParametros.get(1);
			}else{
				logger.error("ERROR AL MOMENTO DE CARGAR PARAMETROS PARA OBTENERBASTANTEOHISTORICO - USUARIO Y CLAVE");
			}
			
			final String ISERIES = Application.getString("app.i5Series.srv");
			final String USER = usuario;
			final String PASS = clave;
			final String DRIVER = Application.getString("ds.driver");
			final String URL = Application.getString("ds.url");

			Class.forName(DRIVER);
			conn = DriverManager.getConnection(MessageFormat.format(URL, ISERIES), USER, PASS);
			
			PreparedStatement ps = null;
			String sql = "SELECT * FROM NCODIG WHERE NCTABL= ? AND NCNIVL= ? ";
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, paisConstanteTabla);
			ps.setString(2, nivelConstanteTabla);
			
			ResultSet resultSet = ps.executeQuery();
			   
			while (resultSet.next()) {
				listaCiudadEcuador.add(new EstadoCiudadModeloCatalogo("",
						(String) resultSet.getString("NCCOD1"),
						(String) resultSet.getString("NCCOD2"),
						(String) resultSet.getString("NCCOD3"),
						(String) resultSet.getString("NCDESC")));
			}
			
			return listaCiudadEcuador;
		} catch (Exception e) {
			logger.error("ERROR AL OBTENER CATALOGO CIUDAD - ECUADOR - REPORTE CERTIFICACION");
			e.printStackTrace();
			return listaCiudadEcuador;
		}
	}
}
