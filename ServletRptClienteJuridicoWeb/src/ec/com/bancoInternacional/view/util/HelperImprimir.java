package ec.com.bancoInternacional.view.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.services.domain.ActEconomicaInfo;
import ec.com.bancoInternacional.services.domain.ActEconomicaInfoPK;
import ec.com.bancoInternacional.services.domain.CantonInfo;
import ec.com.bancoInternacional.services.domain.Catalogo;
import ec.com.bancoInternacional.services.domain.EstadoCiudadModeloCatalogo;
import ec.com.bancoInternacional.services.domain.Ncodig;
import ec.com.bancoInternacional.services.domain.PaisInfo;
import ec.com.bancoInternacional.services.impl.ServiceFacadeInterface;
import ec.com.bancoInternacional.view.domain.CatalogoModeloVO;
import ec.com.bancoInternacional.view.domain.NacionalidadCatalogoVO;
import ec.com.bancoInternacional.view.mapping.CatalogoMapper;

/**
 * Autor: Sandro Guevara Objetivo: Controlador helper Rep. impresión Fecha:
 * 08-05-2018 Nro. Req: 1605 Version: 1.0
 */
public class HelperImprimir implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HelperImprimir.class);

	private ServiceFacadeInterface clientService;

	// Utilitario de diccionario para captura de errorres y presentacion
	// de etiquetas
	// public ClienteBusquedasDiccionarioUtil diccionarioUtil;

	public Map<String, Map<String, String>> dataCountries = null;
	private List<CatalogoModeloVO> idTypeList;
	public List<CatalogoModeloVO> countriesCO;
	public List<CatalogoModeloVO> purposeCatalog;
	public List<CatalogoModeloVO> productCatalog;
	public List<CatalogoModeloVO> sexoCatalog;
	public List<CatalogoModeloVO> profesionesCatalog;
	public List<CatalogoModeloVO> clasificacionCatalog;
	public List<NacionalidadCatalogoVO> nacionalidadCatalog;
	public List<CatalogoModeloVO> estadoCivilCatalog;
	public List<CatalogoModeloVO> nivelEducacionCatalog;
	public List<CatalogoModeloVO> lstParroquias;
	public List<Ncodig> fuenteParroquiasCatalogList;
	private List<CatalogoModeloVO> lstOperadoras;

	public List<PaisInfo> countryCatalogList;
	public List<CantonInfo> lstCanton;
	public List<CatalogoModeloVO> relacionLaboralList;
	public List<CatalogoModeloVO> tipoDomicilioList;
	public List<CatalogoModeloVO> condicionViviendaList;
	public List<CatalogoModeloVO> fuenteIngresoList;
	public List<CatalogoModeloVO> tipoOficinaList;
	public List<CatalogoModeloVO> cargosList;
	public List<CatalogoModeloVO> lstCodProvincia;
	public List<CatalogoModeloVO> lstPais;
	public List<CatalogoModeloVO> lstInstFinancieras;
	public List<CatalogoModeloVO> lstCargosIndependientes;
	public List<CatalogoModeloVO> lstCargosDependientes;
	public List<CatalogoModeloVO> lstPaisReporteCertificacion;
	public List<EstadoCiudadModeloCatalogo> lstDepartamentoReporteCertificacion;
	public List<CatalogoModeloVO> lstTipoIdentificacionReporteCertificacion;
	public List<EstadoCiudadModeloCatalogo> lstCiudadEcuadorReporteCertificacion;


	public Map<ActEconomicaInfoPK, List<ActEconomicaInfo>> lstActEconomicas;

	private CatalogoMapper catalogoMapper;
	private Map<String, Object> commonCatalogsMap;

	public HelperImprimir() {
		super();
	}

	public HelperImprimir(Map<String, Object> commonCatalogsMap, ServiceFacadeInterface clientService) {

		this.commonCatalogsMap = commonCatalogsMap;
		
		lstCiudadEcuadorReporteCertificacion = new ArrayList<>();
		lstPaisReporteCertificacion = new ArrayList<CatalogoModeloVO>();
		lstDepartamentoReporteCertificacion = new ArrayList<EstadoCiudadModeloCatalogo>();
		lstTipoIdentificacionReporteCertificacion = new ArrayList<CatalogoModeloVO>();
		
		catalogoMapper = new CatalogoMapper();
		dataCountries = new HashMap<String, Map<String, String>>();
		countriesCO = new ArrayList<CatalogoModeloVO>();
		purposeCatalog = new ArrayList<CatalogoModeloVO>();
		lstOperadoras = new ArrayList<CatalogoModeloVO>();

		sexoCatalog = new ArrayList<CatalogoModeloVO>();

		clasificacionCatalog = new ArrayList<CatalogoModeloVO>();
		estadoCivilCatalog = new ArrayList<CatalogoModeloVO>();

		lstParroquias = new ArrayList<CatalogoModeloVO>();
		relacionLaboralList = new ArrayList<CatalogoModeloVO>();

		cargosList = new ArrayList<CatalogoModeloVO>();
		lstCodProvincia = new ArrayList<CatalogoModeloVO>();
		lstPais = new ArrayList<CatalogoModeloVO>();

		nacionalidadCatalog = new ArrayList<NacionalidadCatalogoVO>();
		fuenteParroquiasCatalogList = new ArrayList<Ncodig>();
		countryCatalogList = new ArrayList<PaisInfo>();
		lstCanton = new ArrayList<CantonInfo>();
		
		lstCargosIndependientes = new ArrayList<CatalogoModeloVO>();
		lstCargosDependientes = new ArrayList<CatalogoModeloVO>();
		
		this.clientService = clientService;

		try {
			inicializaComponentes();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocurrio un error al generar el reporte(Helper)..." + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private void inicializaComponentes() throws Exception {
		
		//Catalogos pais, departamento y ciudad(ecuatoriana) para reporte de certificacion 
		setLstCiudadEcuadorReporteCertificacion((List<EstadoCiudadModeloCatalogo>) commonCatalogsMap.get(Constantes.CIUDAD_RC_KEY));
		setLstPaisReporteCertificacion(catalogoMapper.convertNcodigPaisReporteCertificacion((List<Ncodig>) commonCatalogsMap.get(Constantes.PAIS_RC_KEY)));
		setLstDepartamentoReporteCertificacion((List<EstadoCiudadModeloCatalogo>) commonCatalogsMap.get(Constantes.DEPARTAMENTO_RC_KEY));
		setLstTipoIdentificacionReporteCertificacion(catalogoMapper.convertNcodigTipoIdentificacionReporteCertificacion((List<Ncodig>) commonCatalogsMap.get(Constantes.TIPO_IDENTIFICACION_RC_KEY)));
		setLstOperadoras(catalogoMapper.convertNcodigToCatalogIdExtObject((List<Ncodig>) commonCatalogsMap.get(Constantes.OPERADORA_CELULAR_CATALOG_KEY)));

		// Compruebo que el mapa general de catalogos y el bean de
		// aplicacion nosean nulos
		if (commonCatalogsMap == null) {
			logger.error(Constantes.CATALOG_MAP_ERROR);
			return;
		}

		// Recupero catalogo de tipo de identificaciones del Mapa de Catalogos
		// de Bean de aplicacion
		List<Ncodig> idTypeListFuente = (List<Ncodig>) commonCatalogsMap.get(Constantes.ID_TYPE_CATALOG_KEY);
		setIdTypeList(catalogoMapper.convertNcodigCatalogToTypeId(idTypeListFuente));

		// Recupero la lista de Catalogos de paises del Mapa de Catalogos
		// del Bean de aplicacion
		setCountryCatalogList((List<PaisInfo>) commonCatalogsMap.get(Constantes.COUNTRIES_CATALOG_KEY));
		if (countryCatalogList != null) {
			setCountriesCO(catalogoMapper.convertCountryInfoToCatalogObject(getCountryCatalogList()));
		}

		lstCanton = (List<CantonInfo>) commonCatalogsMap.get(Constantes.CANTONES_CATALOG_KEY);

		// Catalogo Clasificacion del Bean de aplicacion
		List<Ncodig> fuenteClasificacionCatalogList = (List<Ncodig>) commonCatalogsMap
				.get(Constantes.CLASIFICACION_CATALOG_KEY);
		if (fuenteClasificacionCatalogList != null) {
			setClasificacionCatalog(catalogoMapper.convertNcodigToCatalogIdCod0Object(fuenteClasificacionCatalogList));
		}

		// Catalogo Nacionalidad del Bean de aplicacion
		List<Ncodig> fuenteNacionaidadCatalogList = (List<Ncodig>) getCommonCatalogsMap()
				.get(Constantes.NACIONALIDAD_KEY);
		if (fuenteNacionaidadCatalogList != null) {
			setNacionalidadCatalog(
					catalogoMapper.convertNcodigToCatalogNacionalidadesObject(fuenteNacionaidadCatalogList));
		}

		// Catalogo estado civil del Bean de aplicacion
		List<Ncodig> fuenteEstadoCivilCatalogList = (List<Ncodig>) commonCatalogsMap.get(Constantes.ESTADO_CIVIL_KEY);

		lstParroquias = new ArrayList<CatalogoModeloVO>();
		// Catalogo parroquia del Bean de aplicacion
		fuenteParroquiasCatalogList = (List<Ncodig>) commonCatalogsMap.get(Constantes.PARROQUIAS_CATALOG_KEY);
		for (Ncodig item : fuenteParroquiasCatalogList) {
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(item.getValue());
			webCatalog.setId(item.getId());
		}

		// de Catalogos de Cargos del Bean de aplicacion
		/*List<Catalogo> fuenteCargosCatalogList = null;
		fuenteCargosCatalogList = (List<Catalogo>) commonCatalogsMap.get(Constantes.CARGOS_CATALOG_KEY);
		cargosList = catalogoMapper.convertCnofcToCatalogObject(fuenteCargosCatalogList);*/
		// Catalogos de Cargos del Bean de aplicacion
		lstCargosDependientes = new ArrayList<CatalogoModeloVO>();
		List<Ncodig> fuenteCargosDependientesCatalogList = (List<Ncodig>) commonCatalogsMap
				.get(Constantes.CARGOS_DEPENDIENTES_CATALOG_KEY);
		if (fuenteCargosDependientesCatalogList != null) {
			lstCargosDependientes = catalogoMapper.convertNcodigToCatalogCargosObject(fuenteCargosDependientesCatalogList);
		}
		
		lstCargosIndependientes = new ArrayList<CatalogoModeloVO>();
		List<Ncodig> fuenteCargosIndependientesCatalogList = (List<Ncodig>) commonCatalogsMap
				.get(Constantes.CARGOS_INDEPENDIENTES_CATALOG_KEY);
		if (fuenteCargosIndependientesCatalogList != null) {
			lstCargosIndependientes = catalogoMapper.convertNcodigToCatalogCargosObject(fuenteCargosIndependientesCatalogList);
		}

		// Catalogo Codigos de provicnias
		lstCodProvincia = new ArrayList<CatalogoModeloVO>();
		List<Ncodig> fuenteCodProvinciaCatalogList = (List<Ncodig>) commonCatalogsMap
				.get(Constantes.COD_PROVINCIA_CATALOG_KEY);

		if (fuenteCodProvinciaCatalogList != null) {
			lstCodProvincia = catalogoMapper.convertCodigoProvinciaInfoToCatalogObject(fuenteCodProvinciaCatalogList);
		}

		// Lista de Catalogos de paises
		lstPais = new ArrayList<CatalogoModeloVO>();
		countryCatalogList = (List<PaisInfo>) commonCatalogsMap.get(Constantes.COUNTRIES_CATALOG_KEY);
		lstPais = catalogoMapper.convertCountryInfoToCatalogObject(countryCatalogList);

		lstActEconomicas = (Map<ActEconomicaInfoPK, List<ActEconomicaInfo>>) getCommonCatalogsMap()
				.get(Constantes.ACTIVIDAD_ECONOMICA_MAP_KEY);

		// Catalogo Instituciones financieras
		lstInstFinancieras = new ArrayList<CatalogoModeloVO>();
		List<Catalogo> fuenteInstFinanciera = new ArrayList<Catalogo>();
		fuenteInstFinanciera = (List<Catalogo>) commonCatalogsMap.get(Constantes.INST_FINANCIERAS_CATALOG_KEY);
		lstInstFinancieras = catalogoMapper.convertCnofcToCatalogObject(fuenteInstFinanciera);
					
		// Catalogo TipoOficina del Bean de aplicacion
		List<Ncodig> fuenteRelacionComercialCatalogList = (List<Ncodig>) commonCatalogsMap
		.get(Constantes.PROPOSITO_RELACION_COMERCIAL_CATALOG_KEY);
		purposeCatalog = catalogoMapper.convertNcodigToCatalogObject(fuenteRelacionComercialCatalogList);

	}
	
	
	public String obtenerNombreTipoIdentificacionReporteCertificacion(String codigo){
		for (CatalogoModeloVO tid : lstTipoIdentificacionReporteCertificacion) {
			if (null != codigo) {
				if (codigo.equals(tid.getId())) {
					return tid.getName();
				}
			}
		}
		return codigo;
	}
	
	public String obtenerNombreDepartamentoReporteCertificacion(String codigo, String codigoPais){
		if (Constantes.PAIS_ECUADOR.equalsIgnoreCase(codigoPais)) {
			for (CatalogoModeloVO catalogoModeloVO : lstCodProvincia) {
				if (codigo.equalsIgnoreCase(catalogoModeloVO.getId())) {
					return catalogoModeloVO.getName();
				}
			}
		}else{
			for (EstadoCiudadModeloCatalogo dep : lstDepartamentoReporteCertificacion) {
				if (null != codigo) {
					if (codigo.equals(dep.getId())) {
						return dep.getNombre();
					}
				}
			}			
		}
		return codigo;
	}
	
	public String obtenerNombreCiudadReporteCertificacion(String codigo, String codigoPais){
		if (Constantes.PAIS_ECUADOR.equalsIgnoreCase(codigoPais)) {
			for (CantonInfo canton : lstCanton) {
				if (codigo.equalsIgnoreCase(canton.getId())) {
					return canton.getValue();
				}
			}
		}else{
			for (EstadoCiudadModeloCatalogo ciudad : lstCiudadEcuadorReporteCertificacion) {
				if (null != codigo) {
					if (codigo.equals(ciudad.getId())) {
						return ciudad.getNombre();
					}
				}
			}			
		}
		return codigo;
	}
	
	public String obtenerNombrePaisReporteCertificacion(String codigo){
		for (CatalogoModeloVO pais : lstPaisReporteCertificacion) {
			if (null != codigo) {
				if (codigo.equals(pais.getId())) {
					return pais.getName();
				}
			}
		}
		return codigo;
	}

	public String obtenerPropositoComercial(String purposeType) {
		if (purposeType == null || purposeType.equals(""))
			return "";

		if (purposeType != null && !purposeType.isEmpty()) {
			for (CatalogoModeloVO purpose : getPurposeCatalog()) {
				if (purpose.getId().equals(purposeType))
					return purpose.getName();
			}
		}
		return "";
	}

	public String obtenerProductoVinculacion(String productType) {
		if (productType == null || productType.equals(""))
			return "";

		if (productType != null && !productType.isEmpty()) {
			for (CatalogoModeloVO producto : getProductCatalog()) {
				if (producto.getId().equals(productType))
					return producto.getName();
			}
		}
		return "";
	}

	public String obtenerProfesion(String professionCode) {
		if (professionCode == null || professionCode.equals(""))
			return "";

		if (professionCode != null && !professionCode.isEmpty()) {
			for (CatalogoModeloVO profesion : getProfesionesCatalog()) {
				if (profesion.getId().equals(professionCode))
					return profesion.getName();
			}
		}
		return "";
	}

	public String obtenerNivelEducacion(String educationCode) {
		if (educationCode == null || educationCode.equals(""))
			return "";

		if (educationCode != null && !educationCode.isEmpty()) {
			for (CatalogoModeloVO educacion : getNivelEducacionCatalog()) {
				if (educacion.getId().equals(educationCode))
					return educacion.getName();
			}
		}
		return "";
	}

	public String obtenerClasificacion(String clasificacionCode) {
		if (clasificacionCode == null || clasificacionCode.equals(""))
			return "";

		if (clasificacionCode != null && !clasificacionCode.isEmpty()) {
			for (CatalogoModeloVO clasificacion : getClasificacionCatalog()) {
				if (clasificacion.getId().equals(clasificacionCode))
					return clasificacion.getName();
			}
		}
		return "";
	}
	
	public String obtenerOperadora(String operadora) {
		
		if (operadora == null || operadora.equals(""))
			return "";
		
		if (operadora != null && !operadora.isEmpty()) {
			for (CatalogoModeloVO opera : getLstOperadoras()) {
				String operadoraTresDigitos = opera.getId().substring(0, 3);
				if (opera.getId().equals(operadora) || operadoraTresDigitos.equals(operadora))
					return opera.getName();
			}
		}
		return operadora;
	}

	public String obtenerCodigoInternacionalPorPais(String codigoPais) {
		if (codigoPais == null || codigoPais.equals(""))
			return "";

		if (codigoPais != null && !codigoPais.isEmpty()) {
			for (PaisInfo item : getCountryCatalogList()) {
				if (item.getId().equals(codigoPais))
					return item.getPrefix();
			}
		}
		return "";
	}
	
	public String obtenerNacionalidad(String nationality) {
		if (nationality == null || nationality.equals(""))
			return "";

		if (nationality != null && !nationality.isEmpty()) {
			for (NacionalidadCatalogoVO nacionalidad : getNacionalidadCatalog()) {
				if (nacionalidad.getId().equals(nationality))
					return nacionalidad.getName();
			}
		}
		return "";
	}
	
	public String obtenerNacionalidadPorPais(String codigoPais) {
		if (codigoPais == null || codigoPais.equals(""))
			return "";

		if (codigoPais != null && !codigoPais.isEmpty()) {
			for (NacionalidadCatalogoVO nacionalidad : getNacionalidadCatalog()) {
				if (nacionalidad.getCodigoPais().equals(codigoPais))
					return nacionalidad.getId();
			}
		}
		return codigoPais;
	}

	public String obtenerPaisPorNacionalidad(String nationality) {
		if (nationality == null || nationality.equals(""))
			return "";

		if (nationality != null && !nationality.isEmpty()) {
			for (NacionalidadCatalogoVO nacionalidad : getNacionalidadCatalog()) {
				if (nacionalidad.getId().equals(nationality)) {
					return obtenerPais(nacionalidad.getCodigoPais());
				}
			}
		}

		return "";
	}

	public String obtenerEstadoCivil(String civilStatusCode) {
		if (civilStatusCode == null || civilStatusCode.equals(""))
			return "";

		if (Constantes.ESTADO_CIVIL_CASADO.equals(civilStatusCode))
			return "Casado";
		if (Constantes.ESTADO_CIVIL_COHABITANDO.equals(civilStatusCode))
			return "Cohabitando";
		if (Constantes.ESTADO_CIVIL_VIUDO.equals(civilStatusCode))
			return "Viudo";
		if (Constantes.ESTADO_CIVIL_DIVORCIADO.equals(civilStatusCode))
			return "Divorciado";
		return "Soltero";
	}

	public String obtenerGenero(String genterCode) {
		if (genterCode == null || genterCode.equals(""))
			return "";

		if (Constantes.GENERO_MASCULINO.equals(genterCode))
			return "Masculino";
		if (Constantes.GENERO_FEMENINO.equals(genterCode))
			return "Femenino";
		return "";
	}

	public String obtenerNombreLlevaContabilidad(String codigoLlevaContabilidad) {
		if (codigoLlevaContabilidad == null || codigoLlevaContabilidad.equals(""))
			return "";

		if (codigoLlevaContabilidad != null && !codigoLlevaContabilidad.isEmpty()) {
			if ("N".equals(codigoLlevaContabilidad))
				return "No";
			else {
				return "Si";
			}
		}
		return "";
	}

	public String obtenerParroquia(String codigoParroquia) {
		if (codigoParroquia == null || codigoParroquia.equals(""))
			return "";

		if (codigoParroquia != null && !codigoParroquia.isEmpty()) {
			for (CatalogoModeloVO parroquia : lstParroquias) {
				if (parroquia.getId().equals(codigoParroquia))
					return parroquia.getName();
			}
		}
		return null;
	}

	public String obtenerRelacionLaboral(String codigoRelacionLaboral) {
		if (codigoRelacionLaboral == null || codigoRelacionLaboral.equals(""))
			return "";

		if (codigoRelacionLaboral != null && !codigoRelacionLaboral.isEmpty()) {
			for (CatalogoModeloVO relacionLaboral : relacionLaboralList) {
				if (relacionLaboral.getId().equals(codigoRelacionLaboral))
					return relacionLaboral.getName();
			}
		}
		return "";
	}

	public String obtenerTipoDomicilio(String codigoTipoDomicilio) {
		if (codigoTipoDomicilio == null || codigoTipoDomicilio.equals(""))
			return "";

		if (codigoTipoDomicilio != null && !codigoTipoDomicilio.isEmpty()) {
			for (CatalogoModeloVO tipoDomicilio : tipoDomicilioList) {
				if (tipoDomicilio.getId().equals(codigoTipoDomicilio))
					return tipoDomicilio.getName();
			}
		}
		return null;
	}

	public String obtenerCondicionVivienda(String codigocondicion) {
		if (codigocondicion == null || codigocondicion.equals(""))
			return "";

		if (codigocondicion != null && !codigocondicion.isEmpty()) {
			for (CatalogoModeloVO condicion : condicionViviendaList) {
				if (condicion.getId().equals(codigocondicion))
					return condicion.getName();
			}
		}
		return null;
	}

	public String obtenerFuenteIngresos(String fuenteIngresosCode) {
		if (fuenteIngresosCode == null || fuenteIngresosCode.equals(""))
			return "";

		if (fuenteIngresosCode != null && !fuenteIngresosCode.isEmpty()) {
			for (CatalogoModeloVO cargo : fuenteIngresoList) {
				if (cargo.getId().equals(fuenteIngresosCode))
					return cargo.getName();
			}
		}
		return "";
	}

	public String obtenerTipoOficina(String codigoTipoOficina) {
		if (codigoTipoOficina == null || codigoTipoOficina.equals(""))
			return "";

		if (codigoTipoOficina != null && !codigoTipoOficina.isEmpty()) {
			for (CatalogoModeloVO tipoOficina : tipoOficinaList) {
				if (tipoOficina.getId().equals(codigoTipoOficina))
					return tipoOficina.getName();
			}
		}
		return null;
	}

	/*public String obtenerCargo(String cargoCode) {
		if (cargoCode == null || cargoCode.equals(""))
			return "";

		if (cargoCode != null && !cargoCode.isEmpty()) {
			for (CatalogoModeloVO cargo : cargosList) {
				if (cargo.getId().equals(cargoCode))
					return cargo.getName();
			}
		}
		return "";
	}*/
	
	/**
	 * Obtiene el nombre del cargo de los catalogos de cargos dependientes e independientes
	 * 
	 * @param cargoCode
	 * @return
	 */
	public String obtenerCargo(String cargoCode) {
		if (cargoCode == null || cargoCode.equals(""))
			return "";
		
		return (!this.obtenerNombreCargoDependiente(cargoCode).equals("") ?
				this.obtenerNombreCargoDependiente(cargoCode) : 
					this.obtenerNombreCargoIndependiente(cargoCode)
					);
	}
	
	/**
	 * Retorna el nombre del cargo dependiente
	 * 
	 * @param cargoCode
	 * @return
	 */
	public String obtenerNombreCargoDependiente(String cargoCode){
		if(!cargoCode.equals("") && cargoCode != null){
			for (CatalogoModeloVO cargo : lstCargosDependientes) {
				if (cargo.getId().equals(cargoCode))
					return cargo.getName();
			}
		}
		
		return "";
	}
	
	/**
	 * Retorna el nombre del cargo independiente
	 * 
	 * @param cargoCode
	 * @return
	 */
	public String obtenerNombreCargoIndependiente(String cargoCode){
		if(!cargoCode.equals("") && cargoCode != null){
			for (CatalogoModeloVO cargo : lstCargosIndependientes) {
				if (cargo.getId().equals(cargoCode))
					return cargo.getName();
			}
		}
		
		return "";
	}

	public String obtenerProvincia(String codigo) {
		if (codigo == null || codigo.equals(""))
			return "";

		if (codigo != null && !codigo.isEmpty()) {
			for (CatalogoModeloVO catalogo : lstCodProvincia) {
				if (catalogo.getId().trim().equals(codigo))
					return catalogo.getName().trim();
			}
		}
		return null;
	}

	public String obtenerPais(String codigoPais) {
		if (codigoPais == null || codigoPais.isEmpty())
			return "";

		if (codigoPais != null && !codigoPais.isEmpty()) {
			for (CatalogoModeloVO paisInfo : lstPais) {
				if (paisInfo.getId().equals(codigoPais))
					return paisInfo.getName();
			}
		}
		return null;
	}

	public String obtenerInstitucionesFinancieras(String codigo) {
		if (codigo == null || codigo.isEmpty())
			return "";

		for (CatalogoModeloVO item : lstInstFinancieras) {
			if (item.getId().equals(codigo))
				return item.getName();
		}

		return null;
	}

	public String obtenerTransferenciaExterior(String valor) {
		if (valor == null || valor.equals(""))
			return "";

		if ("S".equals(valor))
			return "Si";
		return "No";
	}

	public String obtenerTelefono(String codigo, String provincia, String numero) {
		StringBuilder telefono = new StringBuilder();
		return telefono.append(codigo).append(provincia).append(numero).toString();
	}

	/*
	 * Recuperar la descripción de una actividad económica pasando el key
	 */
	public String recuperarDescripcionActEconomicaPorKey(String idActEconomica) throws Exception {
		String retorna = "";

		try {
			Iterator it = lstActEconomicas.entrySet().iterator();
			ActEconomicaInfo pk = new ActEconomicaInfo();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				pk = new ActEconomicaInfo();
				pk = (ActEconomicaInfo) e.getKey();

				for (ActEconomicaInfo item : lstActEconomicas.get(pk)) {
					if (!item.getId().getCciniv().trim().equals("6"))
						continue;

					if (item == null || (item != null && item.getId() == null)
							|| (item != null && item.getId() != null && item.getId().getCcicc6().isEmpty()))
						continue;

					if (item.getId().getCcicc6().equals(idActEconomica)) {
						retorna = item.getCcides().trim();

						return retorna;
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			retorna = "";
		}
		return retorna;
	}

	/*
	 * Concatenar teléfonos
	 */
	public String concatenarTelefono(BigDecimal telefono, String operadora, BigDecimal celular) throws Exception {
		String retorna = "";
		if (telefono != null && telefono.compareTo(new BigDecimal("0")) != 0) {
			retorna += UtilitarioComun.strBigDecimalSinDecimales(telefono);
		}
		if (operadora != null && !"".equals(operadora)) {
			retorna += "(" + operadora + ")";
		}
		if (celular != null && celular.compareTo(new BigDecimal("0")) != 0) {
			retorna += UtilitarioComun.strBigDecimalSinDecimales(celular);
		}
		return retorna;
	}

	/*
	 * Recuperar valores de parametrizaciones que se encuentran en el
	 * valores(ejm links qeu se encuentran en los 3 valores por tamaño) Lista de
	 * NCodig busca en el codigo 2 el filtro y retorna lso valores concatenados
	 * 
	 */
	public String recuperalParametrosValor(List<Ncodig> lista, String codigo2) throws Exception {
		if (lista == null || codigo2 == null)
			return "";

		String retorna = "";
		for (Ncodig item : lista) {
			if (item.getId().trim().equals(codigo2.trim())) {
				retorna = item.getNcDat()[0].trim() + item.getNcDat()[1].trim() + item.getNcDat()[2].trim();
				break;
			}
		}

		return retorna;
	}

	public Map<String, Map<String, String>> getDataCountries() {
		return dataCountries;
	}

	public void setDataCountries(Map<String, Map<String, String>> dataCountries) {
		this.dataCountries = dataCountries;
	}

	public List<CatalogoModeloVO> getCountriesCO() {
		return countriesCO;
	}

	public void setCountriesCO(List<CatalogoModeloVO> countriesCO) {
		this.countriesCO = countriesCO;
	}

	public List<CatalogoModeloVO> getPurposeCatalog() {
		return purposeCatalog;
	}

	public void setPurposeCatalog(List<CatalogoModeloVO> purposeCatalog) {
		this.purposeCatalog = purposeCatalog;
	}

	public List<CatalogoModeloVO> getProductCatalog() {
		return productCatalog;
	}

	public void setProductCatalog(List<CatalogoModeloVO> productCatalog) {
		this.productCatalog = productCatalog;
	}

	public List<CatalogoModeloVO> getSexoCatalog() {
		return sexoCatalog;
	}

	public void setSexoCatalog(List<CatalogoModeloVO> sexoCatalog) {
		this.sexoCatalog = sexoCatalog;
	}

	public List<CatalogoModeloVO> getProfesionesCatalog() {
		return profesionesCatalog;
	}

	public void setProfesionesCatalog(List<CatalogoModeloVO> profesionesCatalog) {
		this.profesionesCatalog = profesionesCatalog;
	}

	public List<CatalogoModeloVO> getClasificacionCatalog() {
		return clasificacionCatalog;
	}

	public void setClasificacionCatalog(List<CatalogoModeloVO> clasificacionCatalog) {
		this.clasificacionCatalog = clasificacionCatalog;
	}

	public List<NacionalidadCatalogoVO> getNacionalidadCatalog() {
		return nacionalidadCatalog;
	}

	public void setNacionalidadCatalog(List<NacionalidadCatalogoVO> nacionalidadCatalog) {
		this.nacionalidadCatalog = nacionalidadCatalog;
	}

	public List<CatalogoModeloVO> getEstadoCivilCatalog() {
		return estadoCivilCatalog;
	}

	public void setEstadoCivilCatalog(List<CatalogoModeloVO> estadoCivilCatalog) {
		this.estadoCivilCatalog = estadoCivilCatalog;
	}

	public List<CatalogoModeloVO> getNivelEducacionCatalog() {
		return nivelEducacionCatalog;
	}

	public void setNivelEducacionCatalog(List<CatalogoModeloVO> nivelEducacionCatalog) {
		this.nivelEducacionCatalog = nivelEducacionCatalog;
	}

	public Map<ActEconomicaInfoPK, List<ActEconomicaInfo>> getLstActEconomicas() {
		return lstActEconomicas;
	}

	public void setLstActEconomicas(Map<ActEconomicaInfoPK, List<ActEconomicaInfo>> lstActEconomicas) {
		this.lstActEconomicas = lstActEconomicas;
	}

	public Map<String, Object> getCommonCatalogsMap() {
		return commonCatalogsMap;
	}

	public void setCommonCatalogsMap(Map<String, Object> commonCatalogsMap) {
		this.commonCatalogsMap = commonCatalogsMap;
	}

	public List<CatalogoModeloVO> getIdTypeList() {
		return idTypeList;
	}

	public void setIdTypeList(List<CatalogoModeloVO> idTypeList) {
		this.idTypeList = idTypeList;
	}

	public List<PaisInfo> getCountryCatalogList() {
		return countryCatalogList;
	}

	public void setCountryCatalogList(List<PaisInfo> countryCatalogList) {
		this.countryCatalogList = countryCatalogList;
	}

	public List<CatalogoModeloVO> getLstPaisReporteCertificacion() {
		return lstPaisReporteCertificacion;
	}

	public void setLstPaisReporteCertificacion(List<CatalogoModeloVO> lstPaisReporteCertificacion) {
		this.lstPaisReporteCertificacion = lstPaisReporteCertificacion;
	}

	public List<CatalogoModeloVO> getLstTipoIdentificacionReporteCertificacion() {
		return lstTipoIdentificacionReporteCertificacion;
	}

	public void setLstTipoIdentificacionReporteCertificacion(
			List<CatalogoModeloVO> lstTipoIdentificacionReporteCertificacion) {
		this.lstTipoIdentificacionReporteCertificacion = lstTipoIdentificacionReporteCertificacion;
	}

	public List<EstadoCiudadModeloCatalogo> getLstCiudadEcuadorReporteCertificacion() {
		return lstCiudadEcuadorReporteCertificacion;
	}

	public void setLstCiudadEcuadorReporteCertificacion(List<EstadoCiudadModeloCatalogo> lstCiudadEcuadorReporteCertificacion) {
		this.lstCiudadEcuadorReporteCertificacion = lstCiudadEcuadorReporteCertificacion;
	}

	public List<EstadoCiudadModeloCatalogo> getLstDepartamentoReporteCertificacion() {
		return lstDepartamentoReporteCertificacion;
	}

	public void setLstDepartamentoReporteCertificacion(
			List<EstadoCiudadModeloCatalogo> lstDepartamentoReporteCertificacion) {
		this.lstDepartamentoReporteCertificacion = lstDepartamentoReporteCertificacion;
	}

	public List<CatalogoModeloVO> getLstOperadoras() {
		return lstOperadoras;
	}

	public void setLstOperadoras(List<CatalogoModeloVO> lstOperadoras) {
		this.lstOperadoras = lstOperadoras;
	}

}