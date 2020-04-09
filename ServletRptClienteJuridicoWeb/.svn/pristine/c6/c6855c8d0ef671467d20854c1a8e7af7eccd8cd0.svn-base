package ec.com.bancoInternacional.servlet.report;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.server.seguridad.Credencial;
import ec.com.bancoInternacional.services.domain.ActEconomicaInfo;
import ec.com.bancoInternacional.services.domain.CantonInfo;
import ec.com.bancoInternacional.services.domain.Catalogo;
import ec.com.bancoInternacional.services.domain.CcliCatalogo;
import ec.com.bancoInternacional.services.domain.DatosJuridicoDto;
import ec.com.bancoInternacional.services.domain.EstadoCiudadModeloCatalogo;
import ec.com.bancoInternacional.services.domain.Ncodig;
import ec.com.bancoInternacional.services.domain.PaisInfo;
import ec.com.bancoInternacional.services.exception.PooledTrxException;
import ec.com.bancoInternacional.services.impl.ServiceFacadeInterface;
import ec.com.bancoInternacional.services.impl.ServiciosProxy;
import ec.com.bancoInternacional.services.mapping.DatosEnvioCorreo;
import ec.com.bancoInternacional.services.util.ConsultaNcodigParametro;
import ec.com.bancoInternacional.services.util.NcodigClaveParametro;
import ec.com.bancoInternacional.view.services.report.RptClienteJuridicoVinculacionService;
import ec.com.bancoInternacional.view.util.CatalogoUtil;
import ec.com.bancoInternacional.view.util.Constantes;
import ec.com.bancoInternacional.view.util.HelperImprimir;
import ec.com.bancoInternacional.view.util.Util;

/**
 * Servlet implementation class rptVinculacion
 */
@WebServlet("/rptVinculacion")
public class RptVinculacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RptVinculacion.class);

	@EJB
	ServiceFacadeInterface serviciosProxy;

	// Mapa para todos los catalogos
	public static Map<String, Object> commonCatalogsMap;
	public static boolean banderaCatalogo = false;
	private String ipUsuario = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RptVinculacion() {
		super();
		
		if(!banderaCatalogo){
			commonCatalogsMap = new LinkedHashMap<String, Object>();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Cargar IP local
		ipUsuario = getIpCliente(request);
		//commonCatalogsMap.put(Constantes.IP_LOCAL, getIpCliente(request));
		// cargar la información de GWT cliente Jurídico		
		
		String user = request.getParameter("usuario");
		String usuario = Util.desencriptarString(user);
				
		// Cargar catalogos
		logger.info("Inicia Carga Catalogos");
		logger.info(ipUsuario);
		logger.info(usuario);
		
		if(!banderaCatalogo){
			cargarCatalogosMap();
		}
				
		HelperImprimir helper = new HelperImprimir(commonCatalogsMap, serviciosProxy);

		logger.info("Finaliza Carga Catalogos");
		logger.info(ipUsuario);
		logger.info(usuario);

		// cargar objetos iniciales enviador en la url
		logger.info("Cargar objetos iniciales enviados en la URL");
		logger.info(ipUsuario);
		logger.info(usuario);
		
		String identificacion = request.getParameter("documentoIdentificacion");
		String tipoImpresion = request.getParameter("tipoImpresion");
		String codigoIbs = request.getParameter("codigoIbs");
		DatosJuridicoDto datosJuridicoDto = new DatosJuridicoDto();
		String estadoDeEnvioContrato = "";
		DatosEnvioCorreo datosEnvioCorreo = new DatosEnvioCorreo();

		try {
			// cargar objetos iniciales enviador en la url
			logger.info("Cargar data para el ReporteCliente Juridico");
			logger.info(ipUsuario);
			logger.info(usuario);
			
			datosJuridicoDto = serviciosProxy.recuperarReporteClienteJuridico(identificacion);
//			datosJuridicoDto.getObjFormularioFatca().setCujfa1Out(factaPregunta1);
//			datosJuridicoDto.getObjFormularioFatca().setCujfa2Out(new BigDecimal(factaPorcentaje));
//			datosJuridicoDto.getObjFormularioFatca().setCujfa3Out(factaPregunta2);
			
			/**
			 * Estado que tendria el envio de contrato.
			 */
			BigDecimal Ibs = new BigDecimal(codigoIbs);
			BigDecimal numeroDeCuenta = BigDecimal.ZERO;
			datosEnvioCorreo = serviciosProxy.consultaEstadoEnvioContratroEmail(Ibs, numeroDeCuenta);
			estadoDeEnvioContrato = datosEnvioCorreo.getEstadoCorreo();
		} catch (PooledTrxException e1) {
			e1.printStackTrace();
		}
		
		logger.info("Cargar credenciales");
		logger.info(ipUsuario);
		logger.info(usuario);
		
		Util util = new Util();
		Credencial credencial = new Credencial();
		try {
			credencial = util.CargarCredenciales(serviciosProxy, usuario, request.getSession());
		} catch (PooledTrxException e) {
			e.printStackTrace();
		}

		logger.info("Cargar reporte");
		logger.info(ipUsuario);
		logger.info(usuario);
		
		RptClienteJuridicoVinculacionService rptClienteJuridicoVinculacion = new RptClienteJuridicoVinculacionService();
		rptClienteJuridicoVinculacion.imprimirReporteVinculacion(usuario, request, response, helper, datosJuridicoDto, credencial, tipoImpresion, codigoIbs, estadoDeEnvioContrato,
				serviciosProxy, ipUsuario, datosEnvioCorreo);
	}

	/*
	 * Cargar catalogos
	 */
	public void cargarCatalogosMap() {
		
		if (this.serviciosProxy == null) {
			this.serviciosProxy = new ServiciosProxy();
		}
		
		logger.debug("Inicia Construccion de Mapa General de Catalogos");
		
		try {
			// Catalogo de Paises
			commonCatalogsMap.put(Constantes.COUNTRIES_CATALOG_KEY, this.getCountryCatalog());

			// Catalogo de Tipos de identificacion
			commonCatalogsMap.put(Constantes.ID_TYPE_CATALOG_KEY, this.getIdTypeCatalog());

			// Catalogo Codigos de provincias del ecuador de clientes
			commonCatalogsMap.put(Constantes.COD_PROVINCIA_CATALOG_KEY, this.getCodProvinciaCatalog());

			// Catalogo de cantones
			commonCatalogsMap.put(Constantes.CANTONES_CATALOG_KEY, this.getCantonesCatalog());

			// Catalogo parroquias del ecuador de clientes
			commonCatalogsMap.put(Constantes.PARROQUIAS_CATALOG_KEY, serviciosProxy.recuperarParroquiasCatalog());

			// Catalogo OPERADORAS CELULARES del ecuador de clientes
			commonCatalogsMap.put(Constantes.OPERADORA_CELULAR_CATALOG_KEY, this.getOperadoraCelularCatalog());

			// Catalogo Propósito relación Laboral
			commonCatalogsMap.put(Constantes.PROPOSITO_RELACION_COMERCIAL_CATALOG_KEY,
					serviciosProxy.recuperarPropositoRelacionComercialCatalog());

			// Catalogo Clasificacion
			commonCatalogsMap.put(Constantes.CLASIFICACION_CATALOG_KEY, serviciosProxy.recuperarClasificacionCatalog());

			// Mapa de Actividades Económicas
			commonCatalogsMap.put(Constantes.ACTIVIDAD_ECONOMICA_MAP_KEY, this.getActividadesEconomicas());

			// Catalogo Informacion adicional
			commonCatalogsMap.put(Constantes.INST_FINANCIERAS_CATALOG_KEY, this.recuperarInstFinancieras());

			// Catalogo Cargos de clientes
			/*commonCatalogsMap.put(Constantes.CARGOS_CATALOG_KEY, this.getCargosCatalog());*/
			commonCatalogsMap.put(Constantes.CARGOS_DEPENDIENTES_CATALOG_KEY, this.getCargoDependientesCatalog());
			commonCatalogsMap.put(Constantes.CARGOS_INDEPENDIENTES_CATALOG_KEY, this.getCargoIndependientesCatalog());

			// Catalogo Nacionalidad
			commonCatalogsMap.put(Constantes.NACIONALIDAD_KEY, serviciosProxy.recuperarPaisNacionalidadCatalog());
			
			// Catalogo Tipo Identificacion Reporte Certificacion
			commonCatalogsMap.put(Constantes.TIPO_IDENTIFICACION_RC_KEY, this.getTipoIdentificacionReporteCertificacionCatalog());
			
			// Catalogo Pais Reporte Certificacion
			commonCatalogsMap.put(Constantes.PAIS_RC_KEY, this.getPaisReporteCertificacionCatalog());
			
			// Catalogo Departamento Reporte Certificacion
			commonCatalogsMap.put(Constantes.DEPARTAMENTO_RC_KEY, this.getDepartamentoReporteCertificacionCatalog());
			
			// Catalogo Ciudad Reporte Certificacion
			commonCatalogsMap.put(Constantes.CIUDAD_RC_KEY, this.getCiudadReporteCertificacionCatalog());
						

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		
		banderaCatalogo = true;
	}

	private List<Ncodig> getIdTypeCatalog() {
		List<Ncodig> tIdCatalog = null;
		try {
			tIdCatalog = (List<Ncodig>) serviciosProxy.recuperarCatalogo(
					new ConsultaNcodigParametro(Constantes.TIDN_CATALOG_TABLE, Constantes.TIDN_LEVEL,
							Constantes.TIDN_1_LEVEL, Constantes.TIDN_2_LEVEL, Constantes.TIDN_3_LEVEL, " "),
					CatalogoUtil.catalogComposedKey());

		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalog;
	}

	private List<PaisInfo> getCountryCatalog() {
		List<PaisInfo> countries = null;
		List<CcliCatalogo> ccliCatalogs;
		try {
			ccliCatalogs = (List<CcliCatalogo>) serviciosProxy.recuperarCatalogoPorTabla(Constantes.PAIS_CATALOG_TABLE);
			countries = (List<PaisInfo>) serviciosProxy.recuperarCatalogoPaises(ccliCatalogs);
		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return countries;
	}

	private List<Ncodig> getCodProvinciaCatalog() {
		List<Ncodig> tIdCatalog = null;
		try {
			tIdCatalog = (List<Ncodig>) serviciosProxy.recuperarCatalogo(
					new ConsultaNcodigParametro(Constantes.COD_PROVINCIA_TABLA, Constantes.COD_PROVINCIA_NIVEL, "", "",
							"", ""),
					new NcodigClaveParametro(true, true, true, true, 1));

		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalog;
	}

	private List<CantonInfo> getCantonesCatalog() {
		List<CantonInfo> cantones = null;
		try {
			cantones = (List<CantonInfo>) serviciosProxy.recuperarCantonesLocal();
		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return cantones;
	}

	private List<Ncodig> getOperadoraCelularCatalog() {
		List<Ncodig> tIdCatalog = null;
		try {
			tIdCatalog = (List<Ncodig>) serviciosProxy.recuperarCatalogo(
					new ConsultaNcodigParametro(Constantes.OPERADORA_TABLA, Constantes.OPERADORA_NIVEL, "", "", "", ""),
					new NcodigClaveParametro(true, true, true, true, 1));

		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalog;
	}

	private Map<ActEconomicaInfo, List<ActEconomicaInfo>> getActividadesEconomicas() {
		Map<ActEconomicaInfo, List<ActEconomicaInfo>> tIdCatalog = null;
		try {
			tIdCatalog = serviciosProxy.recuperarActEconomicaCliente();

		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalog;
	}

	private List<Catalogo> recuperarInstFinancieras() {
		List<Catalogo> listaCargos = null;
		try {
			listaCargos = (List<Catalogo>) serviciosProxy.recuperarCatalogoCnofc(Constantes.INST_FINANCIERAS);
		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return listaCargos;
	}

	/**
	 * 
	 * <b> Obtien al ip del cliente</b>
	 * 
	 * @return
	 */
	protected String getIpCliente(HttpServletRequest request) {
		String remoteAddr = "";

		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
		}

		return remoteAddr;

	}
	private List<Ncodig> getCargoDependientesCatalog() {
		List<Ncodig> tIdCatalog = null;
		try {
			tIdCatalog = (List<Ncodig>) serviciosProxy
					.recuperarCatalogo(
							new ConsultaNcodigParametro(Constantes.CARGO_DEPENDIENTE_TABLA, Constantes.CARGO_DEPENDIENTE_NIVEL,
									Constantes.CARGO_DEPENDIENTE_NIVEL_1, Constantes.CARGO_DEPENDIENTE_NIVEL_2, Constantes.CARGO_DEPENDIENTE_NIVEL_3, ""),
							new NcodigClaveParametro(true, true, true, true, 1));

		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalog;
	}
	
	private List<Ncodig> getCargoIndependientesCatalog() {
		List<Ncodig> tIdCatalog = null;
		try {
			tIdCatalog = (List<Ncodig>) serviciosProxy
					.recuperarCatalogo(
							new ConsultaNcodigParametro(Constantes.CARGO_INDEPENDIENTE_TABLA, Constantes.CARGO_INDEPENDIENTE_NIVEL,
									Constantes.CARGO_INDEPENDIENTE_NIVEL_1, Constantes.CARGO_INDEPENDIENTE_NIVEL_2, Constantes.CARGO_INDEPENDIENTE_NIVEL_3, ""),
							new NcodigClaveParametro(true, true, true, true, 1));

		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalog;
	}
	
	private List<Ncodig> getTipoIdentificacionReporteCertificacionCatalog() {
		List<Ncodig> tIdCatalog = null;
		try {
			tIdCatalog = (List<Ncodig>) serviciosProxy.recuperarCatalogo(
					new ConsultaNcodigParametro(Constantes.TIPO_IDENTIFICACION_RCERTIFICACION_TABLA , Constantes.TIPO_IDENTIFICACION_RCERTIFICACION_NIVEL ,
							Constantes.TIPO_IDENTIFICACION_RCERTIFICACION_COD1 , Constantes.TIPO_IDENTIFICACION_RCERTIFICACION_COD2 , "", ""),
					new NcodigClaveParametro(true, true, true, true, 1));

		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalog;
	}
	
	private List<Ncodig> getPaisReporteCertificacionCatalog() {
		List<Ncodig> tIdCatalog = null;
		try {
			tIdCatalog = (List<Ncodig>) serviciosProxy.recuperarCatalogo(
					new ConsultaNcodigParametro(Constantes.PAIS_REPORTE_CERTIFICACION_TABLA , Constantes.PAIS_REPORTE_CERTIFICACION__NIVEL_UNO , "", "", "", ""),
					new NcodigClaveParametro(true, true, true, true, 1));
			
		} catch (PooledTrxException e) {
			logger.error(e);
		}
		return tIdCatalog;
	}
	
	private List<EstadoCiudadModeloCatalogo> getDepartamentoReporteCertificacionCatalog() {
		List<EstadoCiudadModeloCatalogo> tIdCatalog = null;
		tIdCatalog = (List<EstadoCiudadModeloCatalogo>) serviciosProxy.obtenerCiudadEcuadorReporteCertificacionCatalogo(Constantes.PAIS_REPORTE_CERTIFICACION_TABLA, Constantes.PAIS_REPORTE_CERTIFICACION__NIVEL_DOS);
		return tIdCatalog;
	}
	
	private List<EstadoCiudadModeloCatalogo> getCiudadReporteCertificacionCatalog() {
		List<EstadoCiudadModeloCatalogo> tIdCatalog = null;
		tIdCatalog = (List<EstadoCiudadModeloCatalogo>) serviciosProxy.obtenerCiudadEcuadorReporteCertificacionCatalogo(Constantes.PAIS_REPORTE_CERTIFICACION_TABLA, Constantes.PAIS_REPORTE_CERTIFICACION__NIVEL_TRES);
		
		return tIdCatalog;
	}
	

}
