package ec.com.bancoInternacional.ConsultaBastanteo.service.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.ejb.Stateless;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;

import com.ibm.connector.as400.ConnAS;

import ec.com.bancoInternacional.ConsultaBastanteo.excepcion.ClienteNoEncontradoException;
import ec.com.bancoInternacional.ConsultaBastanteo.excepcion.PooledTrxException;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.BLHIS;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.CantonInfo;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.CcliCatalogo;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Cliente;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ConsultaNcodigParametro;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ErrorValidacion;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.FuncionarioResponsable;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.InfoAgencia;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.InfoFuncionario;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Ncodig;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.NcodigClaveParametro;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ObjCliente;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.PaisInfo;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ParametroBuscarCliente;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ValidacionInfoAgencia;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ValidacionInfoFuncionariosPorAgencia;
import ec.com.bancoInternacional.ConsultaBastanteo.service.ConsultaBastanteoFacade;
import ec.com.bancoInternacional.ConsultaBastanteo.service.mapper.ConsultaBastanteoServiceMapper;
import ec.com.bancoInternacional.ConsultaBastanteo.util.ApplicationManager;
import ec.com.bancoInternacional.ConsultaBastanteo.util.Constantes;
import ec.com.bancoInternacional.ConsultaBastanteo.util.FormatoUtil;
import ec.com.bancoInternacional.cs0012.CONVALBANCO;
import ec.com.bancoInternacional.cs0012.CONVALUSUARIO;
import ec.com.bancoInternacional.cs0012.CTRBTHOUDATA;
import ec.com.bancoInternacional.cs0012.CTRCNTOUDATA;
import ec.com.bancoInternacional.cs0012.VALUSERS;
import ec.com.bancoInternacional.cs0052.NCOEDSDATA;
import ec.com.bancoInternacional.cs0052.PRCONSNCODI;
import ec.com.bancoInternacional.cs0052.PRGETDATAGE;
import ec.com.bancoInternacional.cs0052.PRGETNOMAGE;
import ec.com.bancoInternacional.cs0058.LISTDATA;
import ec.com.bancoInternacional.cs0058.PRLEEFUNC;
import ec.com.bancoInternacional.server.seguridad.Credencial;
import ec.com.bancoInternacional.we0038.ACLIINPDATA;
import ec.com.bancoInternacional.we0038.AYUDCUMST;
import ec.com.bancoInternacional.we0038.CATAYUNCG;
import ec.com.bancoInternacional.we0038.CUMSTDATA1;
import ec.com.bancoInternacional.we0038.NCGINPDATOS;
import ec.com.bancointernacional.ApplicationSecurity;
import ec.com.bancointernacional.seguridad.as400.util.PooledTrx;

@Stateless
public class ConsultaBastanteoAs400Impl extends PooledTrx implements ConsultaBastanteoFacade {
	
	private static final Logger logger = Logger.getLogger(ConsultaBastanteoFacade.class);
	private ConsultaBastanteoServiceMapper servicioMapper = new ConsultaBastanteoServiceMapper();
	private static final int REG_PAG = 500;
	private static int BUSCA_MAX = 50;
	
	public Credencial getCntrlBth(Credencial credencial) throws PooledTrxException {
		CONVALUSUARIO convalusuario = new CONVALUSUARIO();
		CONVALBANCO convalbanco = new CONVALBANCO();

		String usuario = credencial.getUsuario();

		convalusuario.setBTHUSUARIO(usuario);
		convalbanco.setCNTCODBANCO("01");

		try {
			invokeTrx(convalbanco);
		} catch (Exception e) {
			logger.error("invoke convalbanco");
			logger.error(e);
		}
		try {
			invokeTrx(convalusuario);
		} catch (Exception e) {
			logger.error("invoke convalusuario");
			logger.error(e);
		}

		int retVal = convalusuario.getReturnValue();
		String desError = convalusuario.getBTHDESERROR();

		if (retVal == 0) {
			if (desError != null) {

				logger.debug("ingresa sin errores a armar el obj credencial");

				CTRBTHOUDATA datosUsr = convalusuario.getBTHDATOS();

				CTRCNTOUDATA datosBnk = convalbanco.getCNTDATOS();
				boolean seguridadIbs = datosBnk.getBNKCNTSEC().equalsIgnoreCase("Y");
				BigDecimal anioRD = datosBnk.getBNKCNTRDY();
				anioRD = BigDecimal.valueOf(
						anioRD.longValue() + ((anioRD.longValue() > 70 && anioRD.longValue() < 100) ? 1900 : 2000));

				String rundate = FormatoUtil.dateWeb(anioRD, datosBnk.getBNKCNTRDM(), datosBnk.getBNKCNTRDD());
				boolean permisoNext = getPermisoModuloNext(credencial);

				credencial = new Credencial(credencial.getSession(), usuario, credencial.getFecha(),
						credencial.getHora(), credencial.getFechaHoraConexion(), datosUsr.getUSUBTHAUT(),
						datosUsr.getUSUBTHPSW(), datosUsr.getUSUBTHCAC(), datosUsr.getUSUBTHCHL(),
						datosUsr.getUSUBTHUBK(), datosUsr.getUSUBTHUBR().intValue(), datosUsr.getUSUBTHINL().intValue(),
						datosUsr.getUSUBTHACL().intValue(), datosUsr.getUSUBTHNOM(), datosUsr.getUSUBTHCAR(),
						seguridadIbs, rundate, datosUsr.getUSUNOMCIU(), datosUsr.getUSUCODOFI(),
						datosUsr.getUSUBTHNGE(), datosUsr.getUSUBTHCGE(), datosUsr.getUSUBTHCOM(), permisoNext);

				datosUsr = null;
				datosBnk = null;
			} else {
				credencial = null;
				logger.error("desError: " + desError);
			}
		} else {
			credencial = null;
			logger.error("retVal: " + retVal + " - desError: " + desError);
		}

		convalusuario = null;
		convalbanco = null;
		usuario = null;

		return credencial;
	}
	
	private boolean getPermisoModuloNext(Credencial credencial) throws PooledTrxException {
		boolean permiso = false;
		String app = ApplicationManager.getString("app.dir");
		String menu = ApplicationManager.getString(app + ".menu");
		String opc = ApplicationManager.getString(app + ".opc");

		if (!(menu.startsWith("!") && menu.endsWith("!")) && !(opc.startsWith("!") && opc.endsWith("!"))) {
			VALUSERS valusers = new VALUSERS();

			valusers.setUSECODUSU(credencial.getUsuario());
			valusers.setUSECODMNU(menu);
			valusers.setUSENUMOPC(opc);

			try {
				invokeTrx(valusers);
			} catch (Exception e) {
				logger.error(e);
			}

			permiso = (valusers.getReturnValue() == 0);

			valusers = null;
		}

		return permiso;

	}

	@Override
	public Cliente consultaBastanteoPorIdentificacion(String id, String tipoIdentificacion) throws ClienteNoEncontradoException {
		Cliente cliente = new Cliente();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		StringBuilder sql = new StringBuilder();
		ConsultaBastanteoServiceMapper mapperService = new ConsultaBastanteoServiceMapper();
		String esquema = ApplicationSecurity.getString("ds.esquema");
		sql.append("SELECT * FROM "+esquema+".BLHIS WHERE HISIDN = ? AND HISTID = ? AND HISEST = 'A' ORDER BY HISFEC DESC FETCH FIRST 1 ROWS ONLY");
		try {
			String usuario = "";
			String clave = "";

			List<String> listaParametros = ConnAS.listaParametros;

			if (listaParametros != null && listaParametros.size() > 0) {
				usuario = listaParametros.get(0);
				clave = listaParametros.get(1);
			} else {
				logger.error(
						"ERROR AL MOMENTO DE CARGAR PARAMETROS PARA CONSULTA DE BASTANTEO: LISTA NULL O VAC�A ConnAS.listaParametros");
			}

			final String ISERIES = ApplicationSecurity.getString("ds.ip");
			final String USER = usuario;
			final String PASS = clave;
			final String DRIVER = ApplicationSecurity.getString("ds.driver");
			final String URL = ApplicationSecurity.getString("ds.url");

			Class.forName(DRIVER);
			conn = DriverManager.getConnection(MessageFormat.format(URL, ISERIES), USER, PASS);
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, id); // IDENTIFICACION DEL BASTANTEO
			ps.setString(2, tipoIdentificacion); // TIPO IDENTIFICACION DEL BASTANTEO
			resultSet = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constantes.MENSAJE_ERROR_LOG4J_PROYECTO.concat(" ERROR AL CONSULTAR BASTANTEO METODO: consultaBastanteoPorIdentificacion"));
			return new Cliente();
		}
			List<BLHIS> listaBastanteos = mapperService.mapearResultSetHaciaBlhis(resultSet);
			if (listaBastanteos.size() == 0 || listaBastanteos == null) {
				throw new ClienteNoEncontradoException("NO SE HAN ENCONTRADO RESULTADOS");
			}
			try {
				cliente = Cliente.jsonToCliente(listaBastanteos.get(0).getHISDAT());
			} catch (Exception e) {
				logger.error(Constantes.MENSAJE_ERROR_LOG4J_PROYECTO.concat(" ERROR AL PARSEAR JSON A OBJECTO CLIENTE"));
				e.printStackTrace();
				
			}
			return cliente;
	}
	
	public List<ObjCliente> buscaClientePorNombre(ParametroBuscarCliente parametroBuscarCliente) throws InterruptedException, ExecutionException {

		List<ObjCliente> clientesEncontrados = new ArrayList<ObjCliente>();
		int nBusca = 0;
		AYUDCUMST ayudcumst = new AYUDCUMST();
		
		ACLIINPDATA acliInpData = ayudcumst.getACLIDATAINP(); 

		acliInpData.setCLINOMCORTOI(parametroBuscarCliente.getNombreCorto());
		//3 indica búsqueda por nombre largo
		acliInpData.setCLIADEATRASI("3");
		acliInpData.setCLICODIGOI(parametroBuscarCliente.getNroIbs());
		acliInpData.setCLIIDENTIFI(parametroBuscarCliente.getId());
		acliInpData.setCLIMGROUP(parametroBuscarCliente.getGrupoMaster());
		acliInpData.setCLIFCLIENTE("C");
		//página única, establecido por Yolanda Jácome 2014-05-14
		acliInpData.setCLINUMPAGINA(BigDecimal.valueOf(1));
		
//		ConnAS.conectaAS400(ayudcumst);//PCH06062012
		invokeTrx(ayudcumst);

		if(ayudcumst.getReturnValue()==0){
			CUMSTDATA1[] encontrados = ayudcumst.getACLIDATAOUT().getDATACUMST();
			List<ObjCliente> aux = getObjClientes(encontrados);

			if(aux.size()>0){
				clientesEncontrados.addAll(aux);
				nBusca += aux.size();
			}
			
			int len = aux.size();

			while(len==REG_PAG && nBusca<BUSCA_MAX){
				ObjCliente last = (ObjCliente)aux.get(aux.size()-1);
				aux = new ArrayList<ObjCliente>();
				
				acliInpData.setCLICODIGOI(BigDecimal.valueOf(Long.valueOf(last.getNroIbs())));
				acliInpData.setCLIIDENTIFI(last.getId());
				acliInpData.setCLINOMSITUAR(last.getNombreCorto());

				//ayudcumst.invoke();//PCH06062012
				invokeTrx(ayudcumst);
				
				logger.debug("continua... ".concat(last.getId()));

				if(ayudcumst.getReturnValue()==0){
					encontrados = ayudcumst.getACLIDATAOUT().getDATACUMST();
					aux = getObjClientes(encontrados);

					if(aux.size()>0){
						clientesEncontrados.addAll(aux);
						nBusca += aux.size();
					}else
						break;
				}else{
					logger.debug(parametroBuscarCliente.getNombreCorto().concat(": ").concat(getStrErrores(ayudcumst.getACLIDESERROR().getERRERRORES())));
					break;
				}
			}//while

		}else
			logger.debug(parametroBuscarCliente.getNombreCorto()+": "+ getStrErrores(ayudcumst.getACLIDESERROR().getERRERRORES()));
		acliInpData = null;
		ayudcumst = null;
		
		return clientesEncontrados;
	}
	
	private List<ObjCliente> getObjClientes(CUMSTDATA1[] encontrados){
		List<ObjCliente> lista = new ArrayList<ObjCliente>();

		if(encontrados != null)
			for(CUMSTDATA1 elemento: encontrados){
				if(elemento!=null && elemento.getCLICODIGOO().intValue()!=0){
					ObjCliente objCliente = new ObjCliente();
					objCliente.setId(elemento.getCLIIDENTIFO());
					objCliente.setNroIbs(elemento.getCLICODIGOO().toString());
					objCliente.setTipo(elemento.getCLITIPCLIEN());
					objCliente.setValue(elemento.getCLINOMLARGOO());
					objCliente.setNombreCorto(elemento.getCLINOMBRECORTO());

					lista.add(objCliente);
				}else
					break;
			}

		return lista;
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
	 * Obtiene una coleccion de tipo CountryInfo, filtrando de la coleccion de
	 * CCLI
	 * 
	 * @param catalogs
	 *            Coleccion de catalogos de tipo CCLI
	 * @return List<CountryInfo>
	 * @throws PooledTrxException
	 */

	public List<PaisInfo> recuperarCatalogoPaises(final Collection<CcliCatalogo> catalogs) throws PooledTrxException {
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
							cinfo.setHighRisk(cat3.getNcdat1() != null
									&& Constantes.BOOLEAN_VERDADERO_FLAG2.equals(cat3.getNcdat1()) ? true : false);
						} else if (Constantes.PAIS_CATALOGO_FATCA.equals(cat3.getNccod4())) {
							cinfo.setFatca(cat3.getNcdat1() != null
									&& Constantes.BOOLEAN_VERDADERO_FLAG2.equals(cat3.getNcdat1()) ? true : false);
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
		}
		return countryList;
	}

	/**
	 * Retorna una coleccion de tipo NcodigCatalog filtrando por parametros,
	 * solo para catalogo de concepto de documento
	 * 
	 * @param ncodigParams
	 *            ConsultaNcodigParameter parametros, de tabla nivl1...nivl4
	 * @param levels
	 *            NcodigBeanParameter campo para obtener claves compuestas de
	 *            ncodig
	 */
	@Override
	public List<Ncodig> recuperarCatalogoConcepto(final Object ncodigParams, final Object levels)
			throws PooledTrxException {

		String[] data = null;
		List<Ncodig> catalogos = new ArrayList<Ncodig>();
		try {
			data = this.consultaNcodig((ConsultaNcodigParametro) ncodigParams);
			for (String row : data) {
				if (row != null) {
					catalogos.add(servicioMapper.mapStreamCatalogConceptoToNcodig(row, (NcodigClaveParametro) levels));
				}
			}
		} catch (Exception ex) {
			logger.error(ex);
			ex.printStackTrace();
			throw new PooledTrxException(ex.getMessage());
		} finally {
			data = null;
		}
		return catalogos;

	}

	/**
	 * ConsultaDb2 la estructura CATAYUNCG para consulta de catalogos NCODIG
	 * 
	 * @param parameterObject:
	 *            Objeto que encapsula los parametros de busqueda
	 * @return arreglo de String con informacion de NCODIG
	 * @throws PooledTrxException
	 */
	private String[] consultaNcodig(final ConsultaNcodigParametro parameterObject) throws PooledTrxException {
		String[] resp = null;
		CATAYUNCG ncodig = null;

		NCGINPDATOS ngcInpDatos = null;
		String[] ncgDetalle = null;

		try {
			ncodig = new CATAYUNCG();
			ngcInpDatos = ncodig.getCANDATAINP();
			servicioMapper.mapNcodigParameterToNgcImpDatos(parameterObject, ngcInpDatos);
			invokeTrx(ncodig);
			if (ncodig.getReturnValue() != 0) {
				String errorMessage = this.buildErrorMessage(parameterObject,
						this.getStrErrores(ncodig.getTRXMSGOUT().getTRXOERROR()));
				logger.error(errorMessage);
				throw new PooledTrxException(errorMessage);
			}
			ncgDetalle = ncodig.getCANDATAOUT().getNCGDETALLE();
			if (ncgDetalle == null) {
				throw new PooledTrxException("No data");
			}
			resp = servicioMapper.mapNcgDetalleToArray(ncgDetalle);
		} catch (Exception e) {
			logger.error(e);
			throw new PooledTrxException(e.getMessage());
		} finally {
			ngcInpDatos = null;
			ncodig = null;
			ncgDetalle = null;
		}
		return resp;
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

	public List<FuncionarioResponsable> obtenerFuncionariosResponsable() {
		List<FuncionarioResponsable> lista = new ArrayList<>();
		PRLEEFUNC prLeeFunc = new PRLEEFUNC();
		try {
			invokeTrx(prLeeFunc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (prLeeFunc.getReturnValue() == 0) {
			for (LISTDATA data : prLeeFunc.getLISTOUTDAT()) {
				if (!"".equals(data.getBINFUN()) && !"".equals(data.getNOMFUN()) && !"".equals(data.getCARFUN())) {
					FuncionarioResponsable funcionario = new FuncionarioResponsable();
					funcionario.setId(data.getBINFUN());
					funcionario.setNombre(data.getNOMFUN());
					funcionario.setCargo(data.getCARFUN());
					funcionario.setAgencia(data.getOFIFUN());
					lista.add(funcionario);
				}
			}
			return lista;
		}
		return new ArrayList<FuncionarioResponsable>();
	}
	
	public List<Ncodig> recuperarPaisNacionalidadCatalog() throws PooledTrxException{
		List<Ncodig> tIdCatalog = null;
		
		try {			
			tIdCatalog = this.getNcodigList(
					new ConsultaNcodigParametro(
							Constantes.NACIONALIDAD_TABLA,
							Constantes.NACIONALIDAD_NIVEL,
							Constantes.NACIONALIDAD_COD1,
							Constantes.NACIONALIDAD_COD2,
							"",
							""),
					new NcodigClaveParametro(true, true, true, true, 2));

		} catch (Exception e) {
			logger.error(e);
			throw new PooledTrxException(e.getMessage());
		} 
		return tIdCatalog;
	}
	
	/*
	 * cargar agencias sin filtro
	 */
	public ValidacionInfoAgencia cargarAgencias() throws PooledTrxException{
		
		ValidacionInfoAgencia valInfo = new ValidacionInfoAgencia();
		
		PRGETNOMAGE getDatosAgencias = new PRGETNOMAGE();
		try {
			invokeTrx(getDatosAgencias);
			
			valInfo.setStatus(getDatosAgencias.getReturnValue());
						
			if(valInfo.getStatus() == 0) {
				//carga data
				List<InfoAgencia> lstData = new ArrayList<InfoAgencia>();
				servicioMapper.mapeoDATAGEToInfoAgencia(getDatosAgencias, lstData);
				valInfo.setInfoAgencia(lstData);
				
				//carga de errores
				ErrorValidacion error = new ErrorValidacion();
				error.setCode(getDatosAgencias.getDATERROUT().getMSGOCODERRO());
				error.setDetails(getDatosAgencias.getDATERROUT().getMSGODESERRO());
				error.setType(getDatosAgencias.getDATERROUT().getMSGOCODSEPA());
				
				valInfo.setError(error);
			}
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			throw new PooledTrxException(e.getMessage());
		} finally {
			getDatosAgencias = null;
		}
		return valInfo;
	}

	@Override
	/**
	 * Obtiene una coleccion de tipo CcliCatalog, para los catalogos nuevos CCLI
	 * a partir del programa de servicio PRCONSNCODI
	 * 
	 * @param table,
	 *            tabla para filtar de NCODIG
	 * @return List<CcliCatalog>
	 */
	
	public List<CcliCatalogo> recuperarCatalogoPorTabla(final String table) throws PooledTrxException {
		List<CcliCatalogo> catalogs = null;
		PRCONSNCODI ncodi = null;
		NCOEDSDATA[] ncodsout = null;
		try {
			ncodi = new PRCONSNCODI();
			ncodi.setCODTBINP(table);
			logger.error("*****************************recuperarCatalogoPorTabla******************************"+table);
			invokeTrx(ncodi);
			ncodsout = ncodi.getNCODSOUT();
			catalogs = servicioMapper.mappingNcoesdataToCcliCatalog(ncodsout);
		} catch (Exception e) {
			logger.error(e);
			throw new PooledTrxException(e.getMessage());
		} finally {
			ncodi = null;
			ncodsout = null;
		}
		return catalogs;
	}

	@Override
	public List<Ncodig> recuperarCatalogo(final Object ncodigParams, final Object levels) throws PooledTrxException {

		String[] data = null;
		List<Ncodig> catalogos = new ArrayList<Ncodig>();
		try {
			data = this.consultaNcodig((ConsultaNcodigParametro) ncodigParams);
			for (String row : data) {
				if (row != null) {
					catalogos.add(servicioMapper.mapStreamToNcodig(row, (NcodigClaveParametro) levels));
				}
			}
		} catch (Exception ex) {
			logger.error(ex);
			ex.printStackTrace();
			throw new PooledTrxException(ex.getMessage());
		} finally {
			data = null;
		}
		return catalogos;
	}

	@Override
	/*
	 * Recuperar todos los funcionarios por agencia
	 * @param agencia Agencia
	 * @return ValidacionInfoFuncionariosPorAgencia Funcionarios
	 */
	public ValidacionInfoFuncionariosPorAgencia recuperarFuncionariosPorAgencias(BigDecimal agencia) throws PooledTrxException{
		Collection<ErrorValidacion> errores = new ArrayList<>();
		ValidacionInfoFuncionariosPorAgencia valInfo = new ValidacionInfoFuncionariosPorAgencia();
		
		PRGETDATAGE getDatAge = new PRGETDATAGE();
		getDatAge.setDATAGEINP(agencia);		
		try {
			
			invokeTrx(getDatAge);
			valInfo.setStatus(getDatAge.getReturnValue());
						
			if(valInfo.getStatus() == 0) {
				//carga data
				List<InfoFuncionario> lstData = new ArrayList<InfoFuncionario>();
				servicioMapper.mapeoDATOFIOUTToInfoFuncionario(getDatAge, lstData);

				List<InfoFuncionario> lstDataCarga = new ArrayList<InfoFuncionario>();
				lstDataCarga.addAll(lstData);
				
				for(InfoFuncionario item : lstData){
					if(item == null)
						break;
					
					InfoFuncionario auxFuncionario = servicioMapper.buscarFuncionario(lstDataCarga, item.getCodJefeAgencia());
					if(auxFuncionario != null && !auxFuncionario.getNombreFuncionario().isEmpty())
						item.setNombreJefeAgencia(auxFuncionario.getNombreFuncionario());
				}
				valInfo.setData(lstData);
				
				//craga de errores
				ErrorValidacion error = new ErrorValidacion();
				error.setCode(getDatAge.getDATMSGOUT().getMSGOCODERRO());
				error.setDetails(getDatAge.getDATMSGOUT().getMSGODESERRO());
				error.setType(getDatAge.getDATMSGOUT().getMSGOCODSEPA());
				
				errores.add(error);
				valInfo.setErrors((List<ErrorValidacion>) errores);
			}
		} catch (Exception e) {
			logger.error(e);
			throw new PooledTrxException(e.getMessage());
		} finally {
			errores = null;
			getDatAge = null;
		}
		return valInfo;
	}
	
	private String getStrErrores(final String[] trxoerror) {
		return "";
	}
	
	private String buildErrorMessage(final ConsultaNcodigParametro parameterObject, final String errors) {

		StringBuilder errorMessage = new StringBuilder(parameterObject.getTabla());
		errorMessage.append(";");
		errorMessage.append(parameterObject.getNivel());
		errorMessage.append(";");
		errorMessage.append(parameterObject.getCod1());
		errorMessage.append(";");
		errorMessage.append(parameterObject.getCod2());
		errorMessage.append(";");
		errorMessage.append(parameterObject.getCod3());
		errorMessage.append(";");
		errorMessage.append(parameterObject.getCod4());
		errorMessage.append(":");
		errorMessage.append(errors);
		return errorMessage.toString();
	}
	
	private List<Ncodig> getNcodigList(
			ConsultaNcodigParametro consultaNcodigParameter,
			NcodigClaveParametro ncodigBeanParameter
			) throws PooledTrxException {
		String[] data = null;
		try {
			data = this.consultaNcodig((ConsultaNcodigParametro) consultaNcodigParameter);
		} catch (PooledTrxException e) {
			e.printStackTrace();
		}
		List<Ncodig> catalogs = new ArrayList<Ncodig>();
		for (String row : data) {
			if (row != null) {
				catalogs.add(servicioMapper.mapStreamToNcodig(row, (NcodigClaveParametro) ncodigBeanParameter));
			}
		}
		return catalogs;
	}
}
