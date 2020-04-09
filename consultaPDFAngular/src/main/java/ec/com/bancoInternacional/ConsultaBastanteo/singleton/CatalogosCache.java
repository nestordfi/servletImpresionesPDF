package ec.com.bancoInternacional.ConsultaBastanteo.singleton;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.ConsultaBastanteo.service.impl.ConsultaBastanteoAs400Impl;
import ec.com.bancoInternacional.ConsultaBastanteo.service.mapper.ConsultaBastanteoServiceMapper;
import ec.com.bancoInternacional.ConsultaBastanteo.util.Constantes;
import ec.com.bancoInternacional.ConsultaBastanteo.excepcion.PooledTrxException;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.*;

@Singleton
@Startup
public class CatalogosCache {
	
	private static final Logger logger = Logger.getLogger(CatalogosCache.class);
	
	private ConsultaBastanteoAs400Impl servicio = new ConsultaBastanteoAs400Impl();
	
	private ConsultaBastanteoServiceMapper servicioMapper = new ConsultaBastanteoServiceMapper();
	
	// Mapa para todos los catalogos
	private Map<String, Object> commonCatalogsMap = new HashMap<>();
	
	private List<CcliCatalogo> ccliCatalogs = new ArrayList<>();
    
    @PostConstruct
    public void init() {
    	
    	logger.info("Inicia Construccion de Mapa General de Catalogos");
		logger.info("*********************Entro a cargar los catalogos************************************");
		
		try {
			// Recupero todo el objeto de CcliCatalogs para enviar hacia
			// Colecciones de Catalogos
			ccliCatalogs = (List<CcliCatalogo>) servicio.recuperarCatalogoPorTabla(Constantes.PAIS_CATALOG_TABLE);
			// Inicializo Mapa para todos los catalogos, <String,List>
			commonCatalogsMap = new LinkedHashMap<String, Object>();
			
			// Catalogo de Paises
			commonCatalogsMap.put(Constantes.COUNTRIES_CATALOG_KEY, servicioMapper.convertCountryInfoToCatalogObject(this.getCountryCatalog()));
			
			// Catalogo Cargos de clientes
			commonCatalogsMap.put(Constantes.CARGOS_CATALOG_KEY, servicioMapper.convertNcodigCatalogToCargo(this.getCargosRepLegalCatalog()));

			// Catalogo de Tipos de identificacion
			commonCatalogsMap.put(Constantes.ID_TYPE_CATALOG_KEY, servicioMapper.convertNcodigCatalogToTypeId(this.getIdTypeCatalog()));
			
			// Catalogo Nacionalidad
			commonCatalogsMap.put(Constantes.NACIONALIDAD_KEY, servicioMapper.convertNcodigToCatalogNacionalidadesObject(servicio.recuperarPaisNacionalidadCatalog()));
			
			// Catalogo de cantones
			commonCatalogsMap.put(Constantes.CANTONES_CATALOG_KEY, servicioMapper.convertCantonInfoToCatalogObject(this.getCantonesCatalog()));
			
			// Catalogo Codigos de provincias del ecuador 
			commonCatalogsMap.put(Constantes.COD_PROVINCIA_CATALOG_KEY, servicioMapper.convertCodigoProvinciaInfoToCatalogObject(this.getCodProvinciaCatalog()));
			
			// Catalogo para tipos de persona
			commonCatalogsMap.put(Constantes.PERSON_TYPE_CATALOG_KEY, servicioMapper.convertNcodigToCatalogNacionalidadesObject(this.getPersonTypeCatalog()));
			
			// Catalogo para concepto de documentos examinados
			commonCatalogsMap.put(Constantes.CONCEPT_CATALOG_KEY, servicioMapper.convertNcodigCatalogToCatalogoModeloVOConcepto(this.getConceptCatalog()));
			
			//Catalogo para canal
			commonCatalogsMap.put(Constantes.INFO_ADICIONAL_CANAL_CATALOG_KEY, this.recuperarCanalCatalog());
			
			//Catalogo para cargos responsable 
			commonCatalogsMap.put(Constantes.CARGOS_RESPONSABLE_CATALOG_KEY, servicioMapper.convertNcodigCatalogToCargoResponsableCatalogo(this.getCargosResponsbleCatalog()));
			
			// Catalogo Agencias
			commonCatalogsMap.put(Constantes.AGENCIA_CATALOG,servicio.cargarAgencias());
			
			// Catalogo Agencias
			commonCatalogsMap.put(Constantes.FUNCIONARIOS_RESPONSABLES_CATALOG,servicio.obtenerFuncionariosResponsable());
			
			//Maximo porcentaje Accionistas Visibles
			commonCatalogsMap.put(Constantes.PCJ_ACC_CATALOG, this.getMaximoPorcentajeAccionista());
			
			//Catalogo Clasificiacion
			commonCatalogsMap.put(Constantes.CLASIFICACION_CATALOG, servicioMapper.convertNcodigToClafisicacionCatalog(this.getClasificacionCatalog()));
			
			//Catalogo Funcionarios
			commonCatalogsMap.put(Constantes.FUNCIONARIOS_CATALOG, servicioMapper.convertInfoFuncionarioToCatalogObject(servicio.recuperarFuncionariosPorAgencias(new BigDecimal(0)).getData()));
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
    	
    }
    
    private List<Ncodig> recuperarCanalCatalog() {
		List<Ncodig> tIdCatalog = null;
		try {
			tIdCatalog = (List<Ncodig>) servicio.recuperarCatalogo(
					new ConsultaNcodigParametro(
							Constantes.INFO_ADICIONAL_BANCA_TABLA, 
							Constantes.INFO_ADICIONAL_CANAL_NIVEL , 
							Constantes.INFO_ADICIONAL_BANCA_COD1, 
							Constantes.INFO_ADICIONAL_BANCA_COD2, 
							"", 
							""
							),
					new NcodigClaveParametro(true, true, true, true, 2));

		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalog;
	}
	
	private List<Ncodig> getPersonTypeCatalog() {
		List<Ncodig> tIdCatalog = null;
		try {
			tIdCatalog = (List<Ncodig>) servicio.recuperarCatalogo(
					new ConsultaNcodigParametro(Constantes.DIVA_CATALOG_TABLE, Constantes.DIVA_LEVEL,
							Constantes.DIVA_1_LEVEL, Constantes.DIVA_2_LEVEL, " ", " "),
					this.catalogComposedKey());
		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalog;
	}
	
	private List<Ncodig> getClasificacionCatalog() {
		List<Ncodig> tIdCatalog = null;
		try {
			tIdCatalog = (List<Ncodig>) servicio.recuperarCatalogo(
					new ConsultaNcodigParametro(Constantes.CLASIFICACION_CATALOG_TABLE, Constantes.CLASIFICACION_LEVEL,
							Constantes.CLASIFICACION_1_CODIGO, "", " ", " "),
					this.catalogComposedKey());
		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalog;
	}
	
	private List<CantonInfo> getCantonesCatalog() {
		List<CantonInfo> cantones = null;
		try {
			cantones = (List<CantonInfo>) servicio.recuperarCantonesLocal();
		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return cantones;
	}
	
	private List<Ncodig> getCodProvinciaCatalog() {
		List<Ncodig> tIdCatalog = null;
		try {
			tIdCatalog = (List<Ncodig>) servicio.recuperarCatalogo(
					new ConsultaNcodigParametro(Constantes.COD_PROVINCIA_TABLA, Constantes.COD_PROVINCIA_NIVEL, "", "",
							"", ""),
					new NcodigClaveParametro(true, true, true, true, 1));

		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalog;
	}


	private List<PaisInfo> getCountryCatalog() {
		List<PaisInfo> countries = null;
		logger.error("*********************Entro a cargar los catalogo de Paises************************************");
		try {
			countries = (List<PaisInfo>) servicio.recuperarCatalogoPaises(ccliCatalogs);
			if (countries != null && countries.size() > 0) {
				for (PaisInfo item : countries) {
					logger.error("**********************" + item.toString()
							+ "********************************************");
				}
			}
		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return countries;
	}
	private List<Ncodig> getCargosResponsbleCatalog() {
		List<Ncodig> cargostCatalog = null;
		try {
			cargostCatalog = (List<Ncodig>) servicio.recuperarCatalogo(
					new ConsultaNcodigParametro(Constantes.CARGOS_CATALOG_TABLE, Constantes.CARGOS_CATALOG_LEVEL,
							"", "", "", ""),
					new NcodigClaveParametro(true, true, true, false, 0));

		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return cargostCatalog;
	}
	private List<Ncodig> getCargosRepLegalCatalog() {
		List<Ncodig> cargostCatalog = this.getCargosRepLegalDependienteCatalog();
		cargostCatalog.addAll(this.getCargosRepLegalIdenpendienteCatalog());
		return cargostCatalog;
	}
	
	
	private List<Ncodig> getCargosRepLegalDependienteCatalog() {
		List<Ncodig> cargostCatalog = null;
		try {
			cargostCatalog = (List<Ncodig>) servicio.recuperarCatalogo(
					new ConsultaNcodigParametro(
							Constantes.CARGOS_CATALOG_TABLE_REP_LEGAL,
							Constantes.CARGOS_CATALOG_LEVEL_REP_LEGAL,
							Constantes.CARGOS_CATALOG_CODIGO_UNO_REP_LEGAL,
							Constantes.CARGOS_CATALOG_CODIGO_DOS_REP_LEGAL,
							Constantes.CARGOS_CATALOG_CODIGO_TRES__DEPENDIENTE_REP_LEGAL,
							""
							),
					new NcodigClaveParametro(true, true, true, false, 0));
			
		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return cargostCatalog;
	}
	
	private List<Ncodig> getCargosRepLegalIdenpendienteCatalog() {
		List<Ncodig> cargostCatalog = null;
		try {
			cargostCatalog = (List<Ncodig>) servicio.recuperarCatalogo(
					new ConsultaNcodigParametro(Constantes.CARGOS_CATALOG_TABLE_REP_LEGAL, Constantes.CARGOS_CATALOG_LEVEL_REP_LEGAL,
							Constantes.CARGOS_CATALOG_CODIGO_UNO_REP_LEGAL, Constantes.CARGOS_CATALOG_CODIGO_DOS_REP_LEGAL, Constantes.CARGOS_CATALOG_CODIGO_TRES__INDEPENDIENTE_REP_LEGAL, ""),
					new NcodigClaveParametro(true, true, true, false, 0));
			
		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return cargostCatalog;
	}
	
	private List<Ncodig> getConceptCatalog() {
		List<Ncodig> conceptCatalog = null;
		try {
			conceptCatalog = (List<Ncodig>) servicio.recuperarCatalogoConcepto(
					new ConsultaNcodigParametro(
							Constantes.CONCEPT_CATALOG_TABLE,
							Constantes.CONCEPT_LEVEL,
							Constantes.CONCEPT_1_LEVEL,
							Constantes.CONCEPT_2_LEVEL,
							"",
							" "
							),
					new NcodigClaveParametro(true, true, true, false, 2));

		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return conceptCatalog;
	}

	private List<Ncodig> getIdTypeCatalog() {
		List<Ncodig> tIdCatalog = null;
		try {
			tIdCatalog = (List<Ncodig>) servicio.recuperarCatalogo(
					new ConsultaNcodigParametro(
							Constantes.TIDN_CATALOG_TABLE,
							Constantes.TIDN_LEVEL,
							Constantes.TIDN_1_LEVEL,
							Constantes.TIDN_2_LEVEL,
							Constantes.TIDN_3_LEVEL,
							" "),
					new NcodigClaveParametro(true, true, true, false, 1));

		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalog;
	}
	
	private List<Ncodig> getMaximoPorcentajeAccionista() {
		List<Ncodig> tIdCatalog = null;
		List<Ncodig> tIdCatalogAux = new ArrayList<>();
		try {
			tIdCatalog = (List<Ncodig>) servicio.recuperarCatalogo(
					new ConsultaNcodigParametro(Constantes.PCJ_ACC_CATALOG_TABLE, Constantes.PCJ_ACC_LEVEL,
							Constantes.PCJ_ACC_1_LEVEL, Constantes.PCJ_ACC_2_LEVEL, Constantes.PCJ_ACC_3_LEVEL, " "),
					new NcodigClaveParametro(true, true, true, false, 1));
			for (int i = 0; i < tIdCatalog.size(); i++) {
				if (Constantes.PCJ_ACC_3_LEVEL.equals(tIdCatalog.get(i).getNcCod()[1])) {
					tIdCatalogAux.add(tIdCatalog.get(i));
				}
			}

		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalogAux;
	}
	
	private NcodigClaveParametro catalogComposedKey() {
		return new NcodigClaveParametro(true, true, true, false, 1);
	}
	
	public Map<String, Object> getCommonCatalogsMap() {
		return commonCatalogsMap;
	}
	
	public void setCommonCatalogsMap(Map<String, Object> commonCatalogsMap) {
		this.commonCatalogsMap = commonCatalogsMap;
	}
}
