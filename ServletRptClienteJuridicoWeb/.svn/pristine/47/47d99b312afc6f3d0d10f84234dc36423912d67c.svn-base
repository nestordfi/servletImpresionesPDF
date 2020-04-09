package ec.com.bancoInternacional.view.services.report;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.lowagie.text.pdf.PdfReader;
import ec.com.bancoInternacional.server.seguridad.Credencial;
import ec.com.bancoInternacional.services.domain.Accionista;
import ec.com.bancoInternacional.services.domain.DatosJuridicoDto;
import ec.com.bancoInternacional.services.domain.RepresentanteLegal;
import ec.com.bancoInternacional.services.impl.ServiceFacadeInterface;
import ec.com.bancoInternacional.services.mapping.DatosEnvioCorreo;
import ec.com.bancoInternacional.services.util.Constantes;
import ec.com.bancoInternacional.servlet.report.Base;
import ec.com.bancoInternacional.view.domain.AccionistasDto;
import ec.com.bancoInternacional.view.domain.BeneficiarioDto;
import ec.com.bancoInternacional.view.domain.DataBeanRptJuridico;
import ec.com.bancoInternacional.view.domain.RepLegalesDto;
import ec.com.bancoInternacional.view.services.notificacion.EnvioCorreoPdf;
import ec.com.bancoInternacional.view.util.HelperImprimir;
import ec.com.bancoInternacional.view.util.Util;
import ec.com.bancoInternacional.view.util.UtilitarioComun;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class RptClienteJuridicoVinculacionService extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RptClienteJuridicoVinculacionService.class);
	static PdfReader archivoPdfTarifarioGeneral = null;
    static String banderaPdfTarifarioGeneral = null;

	public void imprimirReporteVinculacion(String usuario, HttpServletRequest request, HttpServletResponse response,
			HelperImprimir helper, DatosJuridicoDto datosJuridicoDto, Credencial credencial, String tipoImpresion, 
			String codigoIbs, String estadoDeEnvioContrato, ServiceFacadeInterface serviciosProxy, String ipUsuario, 
			DatosEnvioCorreo datosEnvioCorreo) 
					throws IOException {

		this.setExternalContext(request.getServletContext());
		this.setSession(request.getSession(true));
		List<PdfReader> reportes = new ArrayList<>();
		List<PdfReader> reportesCorreo = new ArrayList<>();
        
		try {
			/**
			 * Reporte vinculacion cliente juridico
			 */
			logger.info("Carga Reporte Vinculacion");
			logger.info(ipUsuario);
			logger.info(usuario);
			
			byte[] bytesVectorVinculacionClientes = getReportePDF(
					getString("app.vinculacion.ClienteJuridico.jasper.file.repVinculacionPersonaJuridico.name"),
					obtenerParametrosReporte(new HashMap<String, String>(), datosJuridicoDto, credencial, helper),
					cargaDataReporte(helper, datosJuridicoDto));

			PdfReader reporteVinculacion = new PdfReader(bytesVectorVinculacionClientes);
			reportes.add(reporteVinculacion);
			reportesCorreo.add(reporteVinculacion);
			
			agregarHojaEnBlancoReportesPdf(reportes);
			agregarHojaEnBlancoReportesPdf(reportesCorreo);
			
			
			agregarHojaEnBlancoReportesPdf(reportes);
			agregarHojaEnBlancoReportesPdf(reportesCorreo);

			/**
			 * Reporte de anexo 1
			 */
			logger.info("Carga Reporte Anexos1");
			logger.info(ipUsuario);
			logger.info(usuario);
			
			PdfReader reporteAnexo1 = new PdfReader(getReportePDF(
					getString(
							"app.vinculacion.ClienteJuridico.jasper.file.repVinculacionPersonaJuridicoAnexos.name"),
					obtenerParametrosAnexos(new HashMap<String, String>())));
			
			reportes.add(reporteAnexo1);
			reportesCorreo.add(reporteAnexo1);
			
			agregarHojaEnBlancoReportesPdf(reportes);
			agregarHojaEnBlancoReportesPdf(reportesCorreo);

			/**
			 * Reporte de anexo 2
			 */
			logger.info("Carga Reporte Anexo2");
			logger.info(ipUsuario);
			logger.info(usuario);
			
			PdfReader reporteAnexo2 = new PdfReader(getReportePDF(
					getString(
							"app.vinculacion.ClienteJuridico.jasper.file.repVinculacionPersonaJuridicoAnexo2.name"),
					null));
			
			reportes.add(reporteAnexo2);
			reportesCorreo.add(reporteAnexo2);
			
			agregarHojaEnBlancoReportesPdf(reportes);
			agregarHojaEnBlancoReportesPdf(reportesCorreo);
			
			/**
			 * Reporte Beneficiario Final este reporte se agrega despues del tarifario
			 */
			logger.info("Carga Reporte Beneficiario Final");
			logger.info(ipUsuario);
			logger.info(usuario);
			
			byte[] bytesVectorBeneficiarioFinal = getReportePDF(getString("app.beneficiario.final.jasper.file.rptBeneficiarioFinal.name"),
					obtenerParametrosReporteBeneficiarioFinal(new HashMap<String, String>(), datosJuridicoDto),
					cargaDataReporte(helper, datosJuridicoDto));
			agregarHojaEnBlancoReportesPdf(reportes);

			PdfReader reporteBeneficiarioFinal = new PdfReader(bytesVectorBeneficiarioFinal);
			
			/**
			 * Reporte Tarifario
			 */
			logger.info("Carga Reporte Tariafario de Clientes Intranet/Local");
			logger.info(ipUsuario);
			logger.info(usuario);

			if(archivoPdfTarifarioGeneral == null || banderaPdfTarifarioGeneral.equals("2")){
				String urlTarifario = getString("app.ip.address.reporte.tarifario")
						.concat(getString("app.ip.address.reporte.tarifario.path"));
				
				try{
					archivoPdfTarifarioGeneral = new PdfReader(Util.obtenerReporteIntranet(urlTarifario));
					banderaPdfTarifarioGeneral = "1";
				} catch (Exception errorPdfTarifarioGeneral) {
					logger.error("Error al obtener tarifario general de la intranet");
					logger.error(errorPdfTarifarioGeneral.getMessage());
					errorPdfTarifarioGeneral.printStackTrace();
					
					// Si por alguna razón se cae la conección al pdf tarifario,
					// tomarlo desde una ruta local configurada en el properties
					urlTarifario = getString("app.reporte.local.tarifario");
					archivoPdfTarifarioGeneral = new PdfReader(Util.readBytesFromFile(urlTarifario));
					banderaPdfTarifarioGeneral = "2";
				}
			}
			
			reportes.add(archivoPdfTarifarioGeneral);
			agregarHojaEnBlancoReportesPdf(reportes);
			
			reportesCorreo.add(archivoPdfTarifarioGeneral);
			agregarHojaEnBlancoReportesPdf(reportesCorreo);
			
			reportes.add(reporteBeneficiarioFinal);
			reportesCorreo.add(reporteBeneficiarioFinal);
			
			agregarHojaEnBlancoReportesPdf(reportes);
			agregarHojaEnBlancoReportesPdf(reportesCorreo);
			
			byte[] content = unionPdfs(reportes);
			byte[] contentCorreo = unionPdfs(reportesCorreo);

			enviarContrato(usuario, response, datosJuridicoDto, tipoImpresion, codigoIbs, estadoDeEnvioContrato,
					serviciosProxy, datosEnvioCorreo, content, contentCorreo);
			
		} catch (Exception e) {
			logger.error("Ocurrio un error al generar el reporte de vinculación:" + e.getMessage(), e);
			
			logger.error("Ocurrio un error al generar el reporte de vinculación:" + e.getMessage());
			logger.error(ipUsuario);
			logger.error(usuario);
			
			e.printStackTrace();
			
			response.getWriter().print(
					"<!DOCTYPE html><html><body>El reporte no se pudo generar, comuníquese con TI.</body></html>");
		} finally {
			reportes = null;
			
			logger.info("Finaliza Carga Reporte Cliente Juridico");
			logger.info(ipUsuario);
			logger.info(usuario);
		}
	}

	private void enviarContrato(String usuario, HttpServletResponse response, DatosJuridicoDto datosJuridicoDto,
			String tipoImpresion, String codigoIbs, String estadoDeEnvioContrato, ServiceFacadeInterface serviciosProxy,
			DatosEnvioCorreo datosEnvioCorreo, byte[] content, byte[] contentCorreo) throws IOException {
		
		String correoContacto = "";
		
		if (datosJuridicoDto.getObjInfContactoTelefono().getMctcenOut().trim().equals(Constantes.CODIGO_CORREO_PARA_NOTIFICACION_UNO)){
				correoContacto = datosJuridicoDto.getObjInfContactoTelefono().getCumma23Out();
		}else if (datosJuridicoDto.getObjInfContactoTelefono().getMctcenOut().trim().equals(Constantes.CODIGO_CORREO_PARA_NOTIFICACION_DOS)){
				correoContacto = datosJuridicoDto.getObjInfContactoTelefono().getMctde2Out();
			
		}
		
		String textoParaModaldeRespuesta = 
				obtenerTextoParaModaldeRespuesta(correoContacto);
		
		if(tipoImpresion.equals(Constantes.IMPRESION)){
			if (content != null) {
				/**
				 * Se envia el correo y se actualiza el estado del envio del correo, siempre y cuando
				 * el estado sea igual a P(Notificacion Pendiente de Envio), primero se verifica que 
				 * se tenga correos de representantes legales sino tiene se actualizara el estado a
				 * X = No Enviado
				 */
				if(!StringUtils.isBlank(correoContacto)){
					enviarCorreoEnOpcionImprimir(estadoDeEnvioContrato, correoContacto, contentCorreo,
							serviciosProxy, codigoIbs, usuario, datosJuridicoDto.getObjIdentificacion().getCusna1Out(),
							datosEnvioCorreo);
				} else {
					actualizarEstadoEnvioCorreo(false, serviciosProxy, codigoIbs, correoContacto, usuario);
					logger.error("Cliente no posee correo para envío de correo JURIDICO, identificacion " + datosJuridicoDto.getObjIdentificacion().getCusna1Out());
				}
				response.setContentType("application/pdf");
				response.setContentLength(content.length);
				response.getOutputStream().write(content);
				
			} else {
				response.setContentType("text/html");
				response.getWriter().print(
						"<!DOCTYPE html><html><body>El reporte no se pudo generar, comuníquese con TI.</body></html>");
			}
		} else {
			if(!correoContacto.equals("")){
				enviarCorreoEnOpcionReimpresion(serviciosProxy, codigoIbs, correoContacto, 
						usuario, response, datosJuridicoDto, contentCorreo, estadoDeEnvioContrato, datosEnvioCorreo,
						textoParaModaldeRespuesta);
			} else {
				logger.error("Cliente no posee correo para envío de correo JURIDICO, identificacion " + datosJuridicoDto.getObjIdentificacion().getCusna1Out());
				
				actualizarEstadoEnvioCorreo(false, serviciosProxy, codigoIbs, correoContacto, usuario);
				
				mostrarModalMensajesEnvioCorreo(false, response, 
						textoParaModaldeRespuesta,
						datosJuridicoDto, codigoIbs);
			}
		}
	}
	
	/**
	 * Metodo que enviara el correo en la opcion imprimir, la validaciones son las siguientes:
	 * 1.- Para enviar el correo se deberan pasar las siguientes validaciones:
	 * 	* El estado del envio de correo debe ser diferente de nulo o vacio.
	 * 	* El estado del envio del correo debe estar en estado P(Notificacion Pendiente de Envio).
	 * 	* Debe tener representantes legales
	 * 2.- Se realiza el proceso para enviar el correo(Retorna True o False).
	 * 3.- Se actualiza el estado.
	 * 
	 * @param estadoDeEnvioContrato 		<Estado del envio del correo>
	 * @param correoContacto 	<Cadena de representantes legales>
	 * @param contentCorreo					<Objeto que contendra los bytes de los archivos a enviar>
	 * @param serviciosProxy				<Instancia del objeto que permitira llamar al metodo de 
	 * 										actualizacion>
	 * @param codigoIbs						<Codigo Ibs>
	 * @param usuario						<Bind del usuario>
	 * @param datosEnvioCorreo 
	 */
	public void enviarCorreoEnOpcionImprimir(String estadoDeEnvioContrato, String correoContacto, 
			byte[] contentCorreo, ServiceFacadeInterface serviciosProxy, String codigoIbs, String usuario, 
			String nombreClienteJuridico, DatosEnvioCorreo datosEnvioCorreo){
		if(estadoDeEnvioContrato != null && !estadoDeEnvioContrato.equals("")){
			if(estadoDeEnvioContrato.equals(Constantes.NOTIFICACION_PENDIENTE)) {
				if(!correoContacto.equals("")){
					boolean finalizaProcesoSinErrorEnvioCorreo = EnvioCorreoPdf.enviarCorreoConPdf(
							correoContacto, 
							contentCorreo, 
							Constantes.ADJUNTAR_IMAGENES_SI,
							nombreClienteJuridico,
							datosEnvioCorreo);
					
					actualizarEstadoEnvioCorreo(finalizaProcesoSinErrorEnvioCorreo, serviciosProxy, 
							codigoIbs, correoContacto, usuario);
				} else {
					logger.info("Cliente no posee representantesLegales");
				}
			}
		}
	}
	
	/**
	 * Permite el envio del correo para la reimpresion de documentos donde contendra las siguiente
	 * validaciones:
	 * 1.- Primero se envia la notificacion del correo(Puede retornar True o False).
	 * 2.- Actualizamos el estado del envio del correo.
	 * 3.- Segun el booleano que retorne la variable finalizaProcesoSinErrorEnvioCorreo se
	 * mostrara el respectivo mensaje en el modal.
	 * 
	 * @param serviciosProxy						<Instancia del objeto que permitira llamar al metodo de 
	 * 												actualizacion>
	 * @param codigoIbs								<Codigo Ibs>
	 * @param correoContacto			<Cadena de representantes legales>
	 * @param usuario								<Bin del usuario>
	 * @param response								<Instancia del objeto response>
	 * @param datosJuridicoDto
	 * @param contentCorreo							<Objeto que contendra los bytes de los archivos a enviar>
	 * @param estadoDeEnvioContrato					<Estado que tendra en correo P(Pendiente Envio Correo),
	 * 												E(Notificacion Enviada), X(Notificacion No Enviada)> 
	 * @param datosEnvioCorreo 						<Objeto que contendra la informacion del asesor>
	 * @param textoParaModalRespuesta	<nombres y correo de representantes legales>
	 */
	public void enviarCorreoEnOpcionReimpresion(ServiceFacadeInterface serviciosProxy, String codigoIbs, 
			String correoContacto, String usuario, 
			HttpServletResponse response, DatosJuridicoDto datosJuridicoDto, byte[] contentCorreo, 
			String estadoDeEnvioContrato, DatosEnvioCorreo datosEnvioCorreo, 
			String textoParaModalRespuesta){
		
		logger.info("Inicia metodo reimpresionDocumentos");
		if(estadoDeEnvioContrato != null && !estadoDeEnvioContrato.equals("")){
			boolean finalizaProcesoSinErrorEnvioCorreo = EnvioCorreoPdf.enviarCorreoConPdf(
					correoContacto, 
					contentCorreo, 
					Constantes.ADJUNTAR_IMAGENES_SI,
					datosJuridicoDto.getObjIdentificacion().getCusna1Out(),
					datosEnvioCorreo);
			
			actualizarEstadoEnvioCorreo(finalizaProcesoSinErrorEnvioCorreo, serviciosProxy, 
					codigoIbs, correoContacto, usuario);
			
			mostrarModalMensajesEnvioCorreo(finalizaProcesoSinErrorEnvioCorreo, response, 
					textoParaModalRespuesta,
					datosJuridicoDto, codigoIbs);
		} else {
			cargarMensajeDeClienteNoexiste(response);
		}
		logger.info("Finaliza metodo reimpresionDocumentos");
	}
	
	/**
	 * Metodo que mostrara cargara el respectivo mensaje en la pantalla, dependen
	 * de si el envio del correo fue exitoso o no.
	 * 
	 * @param finalizaProcesoSinErrorEnvioCorreo	<Bandera de envio de correo puede ser True o False>
	 * @param response								<Instancia del objeto responde>		
	 * @param correosAenviar			<Cadena de representantes legales>
	 * @param datosJuridicoDto
	 * @param codigoIbs								<Codigo Ibs>
	 */
	public void mostrarModalMensajesEnvioCorreo(boolean finalizaProcesoSinErrorEnvioCorreo, 
			HttpServletResponse response, String correosAenviar, 
			DatosJuridicoDto datosJuridicoDto, String codigoIbs){
		if(finalizaProcesoSinErrorEnvioCorreo){
			cargarMensajeEnvioCorreo(response, correosAenviar,
					datosJuridicoDto, Constantes.MENSAJE_ENVIO_CORREO_CORRECTO, codigoIbs, Constantes.ENVIO_EXITOSO, "", "");
		} else {
			if(!correosAenviar.equals("")){
					cargarMensajeEnvioCorreo(response, correosAenviar,
							datosJuridicoDto, Constantes.MENSAJE_ENVIO_CORREO_ERROR, codigoIbs, Constantes.ENVIO_NO_EXITOSO, 
							Constantes.MENSAJE_ADVERTENCIA, "");
			} else {
				cargarMensajeEnvioCorreo(response, correosAenviar,
						datosJuridicoDto, Constantes.MENSAJE_NO_ENVIO_CORREO_POR_FALTA_CORREO, codigoIbs, Constantes.ENVIO_NO_EXITOSO, 
						Constantes.MENSAJE_ADVERTENCIA, Constantes.SIN_CORREOS_REPRESENTANTES);
			}
		}
	}
	
	/**
	 * Metodo que actualizar el estado del envio del correo donde se tendra las siguientes 
	 * validaciones:
	 * 1.- Se verificar la finalizacion del envio del correo(Puede ser True o False).
	 * 2.- Se actualiza el estado del envio de notificacion(Puede X = Notificacion No Enviada,
	 * o E = Notificacion Enviada).
	 * 
	 * @param finalizaProcesoSinErrorEnvioCorreo <Bandera que puede ser True o False>
	 * @param serviciosProxy <Instancia del Objeto donde se llama al metodo de actualizacion>
	 * @param codigoIbs <Codigo Ibs>
	 * @param correoContacto <Cadena de representantes legales>
	 * @param usuario <bin del usuario>
	 */
	public void actualizarEstadoEnvioCorreo(boolean finalizaProcesoSinErrorEnvioCorreo, ServiceFacadeInterface serviciosProxy, 
			String codigoIbs, String correoContacto, String usuario){
		logger.info("Inicia metodo actualizarEstadoEnvioCorreo");
		try{
			if(finalizaProcesoSinErrorEnvioCorreo){
				serviciosProxy.actualizarEstadoEnvioContratroEmail(codigoIbs, Constantes.NOTIFICACION_ENVIADA,
						"", correoContacto, usuario);
			} else {
				serviciosProxy.actualizarEstadoEnvioContratroEmail(codigoIbs, Constantes.NOTIFICACION_NO_ENVIADA,
						Constantes.MENSAJE_ENVIO_CORREO_ERROR, correoContacto, usuario);
			}
		} catch(Exception errorActualizarEstadoEnvioCorreo){
			logger.error("Ocurrio un error en el metodo actualizarEstadoEnvioCorreo: " + errorActualizarEstadoEnvioCorreo);
			errorActualizarEstadoEnvioCorreo.printStackTrace();
		}
		logger.info("Finaliza metodo actualizarEstadoEnvioCorreo");
	}
	
	/**
	 * Metodo que retornara la cadena de representantes legales.
	 * 
	 * @param listRepresentanteLegales <Lista de representantes legales>
	 * @return
	 */
	public String obtenerCorreosRepresentantesLegales(List<RepresentanteLegal> listRepresentanteLegales){
		String correosRepresentantesLegales = "";
		
		for(RepresentanteLegal representanteLegal : listRepresentanteLegales){
			if(representanteLegal != null){
				if(representanteLegal.getCumbn24Out() != null && !representanteLegal.getCumbn24Out().equals("")){
					if(representanteLegal.getLidema4out() != null && !representanteLegal.getLidema4out().equals("")){
						correosRepresentantesLegales = correosRepresentantesLegales + representanteLegal.getLidema4out() + ", ";
					}
				}
			}
		}
		
		return UtilitarioComun.eliminarCaracterEspecificoEnString(correosRepresentantesLegales, 0, 
				correosRepresentantesLegales.trim().length() - 1);
	}
	
	/**
	 * Metodo que permitira obtener los nombres y correos de los representantes legales.
	 * 
	 * @param listRepresentanteLegales
	 * @return
	 */
	public String obtenerTextoParaModaldeRespuesta(String correoContacto){
		String returnedString = "";
		
		returnedString = agregarSaltoLineaYNegritoACadena(correoContacto,"");
		
		return returnedString;
	}
	
	/**
	 * Obtendra el nombre de los representantes legales a presentar en el correo.
	 * 
	 * @param listRepresentanteLegales
	 * @return
	 */
	public String nombreRepresentantesLegales(List<RepresentanteLegal> listRepresentanteLegales){
		String nombreRepresentantesLegales = "";
		
		for(RepresentanteLegal representanteLegal : listRepresentanteLegales){
			if(representanteLegal != null){
				if(representanteLegal.getCumma14Out() != null && !representanteLegal.getCumma14Out().equals("")){
					nombreRepresentantesLegales = nombreRepresentantesLegales + representanteLegal.getCumma14Out() + ", ";
				}
			}
		}
		
		return UtilitarioComun.eliminarCaracterEspecificoEnString(nombreRepresentantesLegales, 0, 
				nombreRepresentantesLegales.trim().length() - 1);
	}
	
	/**
	 * Meotodo que permitira agregar la negrita a los nombres de los representantes legales y dar un salto de
	 * linea en cada correo del representante legal.
	 * 
	 * @param nombreAenviar
	 * @param correoAenviar
	 * @return
	 */
	private static String agregarSaltoLineaYNegritoACadena(String nombreAenviar, String correoAenviar){
		return "<span style='color: " + Constantes.COLOR_TEXTO + "; font-size: 14px !important'>" + correoAenviar + 
				"&nbsp;&nbsp;&nbsp;<b>" + nombreAenviar + "</b>" + "</span>";
	}
	
	/**
	 * Cargar el mensaje de exito cuando se envia el reporte por correo de forma exitosa.
	 * 
	 * @param response
	 * @param correosRepresentantesLegales 
	 * @param datosJuridicoDto 
	 * @param codigoIbs 
	 * @param mensajeEnvioCorreoError 
	 */
	public void cargarMensajeEnvioCorreo(HttpServletResponse response, String correosRepresentantesLegales, 
			DatosJuridicoDto datosJuridicoDto, String mensajeEnvioCorreo, String codigoIbs, 
			String tipoCreacionConEstilo, String mensajeAdvertencia, String mensajeSinCorreosRepresentantesLegales){
		logger.info("Inicia metodo cargarMensajeEnvioCorreoExitoso");
		response.setContentType("text/html");
		try {
			String cuerpoMensaje = (!mensajeSinCorreosRepresentantesLegales.equals("")) ? "<br/>" + mensajeSinCorreosRepresentantesLegales : 
				correosRepresentantesLegales;
			
			response.getWriter().print(
					"<!DOCTYPE html><html><body id='cuerpoMensaje'>"
					+ "Cliente <b>"+ codigoIbs +" "
					+ datosJuridicoDto.getObjIdentificacion().getCusna1Out() + "</b><br/>"
					+ tipoCreacionConEstilo + "<br/>"
					+ mensajeAdvertencia + "- El <b>Contrato de Vinculación</b> del Cliente "+ mensajeEnvioCorreo
					+ cuerpoMensaje +"."
					+ "</body></html>");
		} catch (Exception errorCargarMensajeEnvioCorreoExitoso) {
			logger.error("Ocurrio error en el metodo cargarMensajeEnvioCorreoExitoso" + errorCargarMensajeEnvioCorreoExitoso);
			errorCargarMensajeEnvioCorreoExitoso.printStackTrace();
		}
		logger.info("Finaliza metodo cargarMensajeEnvioCorreoExitoso");
	}

	private Map<String, Object> obtenerParametrosAnexos(Map<String, String> data) throws Exception {
		Map<String, Object> params = new HashMap<>();
		try {
			params.put("banInterCorreo", getString("app.etiqueta.jrxml.correo.banco.internacional"));
			params.put("banInterPostal", getString("app.etiqueta.jrxml.casilla.postal.banco.internacional"));
			params.put("superBancosCorreo", getString("app.etiqueta.jrxml.correo1.super.bancos") + "   "
					+ getString("app.etiqueta.jrxml.correo2.super.bancos"));
			params.put("superBancosCasilla", getString("app.etiqueta.jrxml.telefono.super.bancos"));
			params.put("superBancosPostal", getString("app.etiqueta.jrxml.casilla.postal.super.bancos"));

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocurrio un error al enviar parametros al imprimir reporte:" + e.getMessage());
			throw new Exception("Ocurrio un error al enviar parametros al imprimir reporte");
		}
		return params;
	}

	/**
	 * Retorna un string donde se concatena todos los representantesLegales separados
	 * por coma.
	 * 
	 * @param datosJuridicoDto
	 * @return
	 */
	public static String retornarStringRepresentantesLegales(DatosJuridicoDto datosJuridicoDto){
		List<RepresentanteLegal> listaRepresentanteLegales = datosJuridicoDto.getLstRepresentanteLegal();
		String cadenaRepresentantesLegales = "";
		for(RepresentanteLegal representanteLegal : listaRepresentanteLegales){
			if(!representanteLegal.getCumbn24Out().equals("") && representanteLegal.getCumbn24Out() != null){
				cadenaRepresentantesLegales = cadenaRepresentantesLegales + representanteLegal.getCumma14Out() + ", ";
			}
		}
		
		return UtilitarioComun.eliminarCaracterEspecificoEnString(cadenaRepresentantesLegales, 0, 
				cadenaRepresentantesLegales.trim().length() - 1);
	}
	
	/**
	 * Retorna un string donde se concatena todos los cargosRepresentantesLegales separados
	 * por coma.
	 * 
	 * @param datosJuridicoDto
	 * @return
	 */
	public static String retornarStringCargoRepresentantesLegales(DatosJuridicoDto datosJuridicoDto, HelperImprimir helper){
		List<RepresentanteLegal> listaRepresentanteLegales = datosJuridicoDto.getLstRepresentanteLegal();
		String cadenaCargosRepresentantesLegales = "";
		for(RepresentanteLegal representanteLegal : listaRepresentanteLegales){
			if(!representanteLegal.getCumbn24Out().equals("") && representanteLegal.getCumbn24Out() != null){
				cadenaCargosRepresentantesLegales = cadenaCargosRepresentantesLegales + helper.obtenerCargo(representanteLegal.getLidnot4Out()) + ", ";
			}
		}
		
		return UtilitarioComun.eliminarCaracterEspecificoEnString(cadenaCargosRepresentantesLegales, 0, 
				cadenaCargosRepresentantesLegales.trim().length() - 1);
	}
	
	private Map<String, Object> obtenerParametrosReporte(Map<String, String> data, DatosJuridicoDto datosJuridicoDto,
			Credencial credencial, HelperImprimir helper) throws Exception {
		Map<String, Object> params = new HashMap<>();
		try {
			// Cabecera
			params.put("IMG_DIR", getImageRealPath());
			params.put("cabecera_nombre_banco", getString("app.etiqueta.jrxml.banco.internacional"));
			params.put("cabecera_nombres_cliente", datosJuridicoDto.getObjIdentificacion().getCusna1Out());

			if (datosJuridicoDto.getLstRepresentanteLegal().size() > 0) {
				params.put("cabecera_nombres_representante", retornarStringRepresentantesLegales(datosJuridicoDto));
				params.put("cabecera_cargo_representante", retornarStringCargoRepresentantesLegales(datosJuridicoDto, helper));
			}
			
			// SECCIONES GENERALES
			// Sección identificación
			params.put("identificacion_tipo_identificacion", UtilitarioComun.obtenerTipoIdentificacion(datosJuridicoDto.getObjIdentificacion().getCusid1Out()));
			params.put("identificacion_identificacion", datosJuridicoDto.getObjIdentificacion().getCusid2Out());
			params.put("identificacion_razon_social", datosJuridicoDto.getObjIdentificacion().getCusna1Out());

			//Sección Información Básica
			params.put("infBasica_proposito", helper.obtenerPropositoComercial(datosJuridicoDto.getObjInfBasica().getCocmacOut()));
			params.put("infBasica_producto_vinculacion", datosJuridicoDto.getObjInfBasica().getCuiprdOut());
			params.put("infBasica_razonSocial", datosJuridicoDto.getObjIdentificacion().getCusna1Out());
			params.put("infBasica_nombreComercial", datosJuridicoDto.getObjInfBasica().getCusfnaOut());
			params.put("infBasica_objetoSocial", datosJuridicoDto.getObjInfBasica().getCujobjOut());
			params.put("infBasica_paisConstitucion", helper.obtenerPais(datosJuridicoDto.getObjInfBasica().getCuscobOut()));
			params.put("infBasica_fechaConstitucion", datosJuridicoDto.getObjInfBasica().getFechaConstitucion().compareTo(BigDecimal.ZERO) == 0 ? null : UtilitarioComun.convertSdf8ToSdfIso(datosJuridicoDto.getObjInfBasica().getFechaConstitucion()));
			params.put("infBasica_duracion", Util.calcularDuracion(datosJuridicoDto.getObjInfBasica().getLimdurOut()));
			params.put("infBasica_fechaVencimiento", datosJuridicoDto.getObjInfBasica().getLimmecOut().compareTo(BigDecimal.ZERO) == 0 ? null : UtilitarioComun.convertSdf8ToSdfIso(datosJuridicoDto.getObjInfBasica().getLimmecOut()));
			params.put("infBasica_capitalSuscrito", datosJuridicoDto.getObjInfBasica().getLimcsuOut());
			params.put("infBasica_capitalSocial", datosJuridicoDto.getObjInfBasica().getCuscaiOut());
			params.put("infBasica_fechaInscripcion", null); // No hay data
			params.put("infBasica_nroEmpleados", datosJuridicoDto.getObjInfBasica().getCuibcyOut());
			params.put("infBasica_codigoActEconomica", datosJuridicoDto.getObjInfBasica().getMctaepOut());
			params.put("infBasica_actEconimicaNx", datosJuridicoDto.getObjInfBasica().getMctaedOut()); //campo nuevo agregado a jar cs0135
			params.put("infBasica_clasificacion", helper.obtenerClasificacion(datosJuridicoDto.getObjInfBasica().getCudregOut()));
			params.put("infBasica_fechaCreacionCliente", 
					(datosJuridicoDto.getObjInfBasica().getCusbdfOut() != null && !datosJuridicoDto.getObjInfBasica().getCusbdfOut().equals("")) 
							? UtilitarioComun.convertStringDate(datosJuridicoDto.getObjInfBasica().getCusbdfOut()) : null);
//			params.put("infBasica_DeclaraImpuestosExterior", datosReporteCertificacion.getEmpresa().getDeclaraImpuestoExterior());
			
			//Sección Información Financiera
			params.put("infFinanciera_ingresosAnuales", datosJuridicoDto.getObjInfFinanciera().getCuidi4Out());
			params.put("infFinanciera_totalActivos", datosJuridicoDto.getObjInfFinanciera().getCuitfcOut());
			params.put("infFinanciera_totalPasivos", this.totalPasivo(datosJuridicoDto.getObjInfFinanciera().getCuidi3Out(), 
					datosJuridicoDto.getObjInfFinanciera().getCuitfcOut()));
			params.put("infFinanciera_patrimonio", datosJuridicoDto.getObjInfFinanciera().getCuidi3Out());
			
			//Cuestionario FATCA
			params.put("fatca_porcentaje", datosJuridicoDto.getObjFormularioFatca().getCujfa2Out());
			
			if(datosJuridicoDto.getObjFormularioFatca().getCujfa1Out().isEmpty()){				
				params.put("fatca_representacionSi", null);
				params.put("fatca_representacionNo", null);
			}else if(Constantes.CODIGO_NOTIFICACION_FATCA_SI.equals(datosJuridicoDto.getObjFormularioFatca().getCujfa1Out())){				
				params.put("fatca_representacionSi", "x");
				params.put("fatca_representacionNo", null);
			}else if(Constantes.CODIGO_NOTIFICACION_FATC_NO.equals(datosJuridicoDto.getObjFormularioFatca().getCujfa1Out())){
				params.put("fatca_representacionSi", null);
				params.put("fatca_representacionNo", "x");		
			}
			
			if(datosJuridicoDto.getObjFormularioFatca().getCujfa3Out().isEmpty()){				
				params.put("fatcaparticipacionSi", null);
				params.put("fatcaparticipacionNo", null);
			}else if(Constantes.CODIGO_NOTIFICACION_FATCA_SI.equals(datosJuridicoDto.getObjFormularioFatca().getCujfa3Out())){				
				params.put("fatcaparticipacionSi", "x");
				params.put("fatcaparticipacionNo", null);
			}else if(Constantes.CODIGO_NOTIFICACION_FATC_NO.equals(datosJuridicoDto.getObjFormularioFatca().getCujfa3Out())){
				params.put("fatcaparticipacionSi", null);
				params.put("fatcaparticipacionNo", "x");		
			}
			//Info contacto--ubicación			
			params.put("infContacto_ubicacion_pais", datosJuridicoDto.getObInfContactoUbicacion().getPaisDomicilio());
			params.put("infContacto_ubicacion_canton", datosJuridicoDto.getObInfContactoUbicacion().getCumpod21Out()); 
			params.put("infContacto_ubicacion_provincia", datosJuridicoDto.getObInfContactoUbicacion().getProvinciaDomicilio());
			params.put("infContacto_ubicacion_parroquia", datosJuridicoDto.getObInfContactoUbicacion().getCumpod31Out());
			params.put("infContacto_ubicacion_calle", datosJuridicoDto.getObInfContactoUbicacion().getCumma21Out());
			params.put("infContacto_ubicacion_nro", datosJuridicoDto.getObInfContactoUbicacion().getCumma22Out());
			params.put("infContacto_ubicacion_calleSecundaria", datosJuridicoDto.getObInfContactoUbicacion().getCumma31Out());
			params.put("infContacto_ubicacion_piso", datosJuridicoDto.getObInfContactoUbicacion().getCumma41Out());
			params.put("infContacto_ubicacion_departamento", datosJuridicoDto.getObInfContactoUbicacion().getCumma42Out());
			params.put("infContacto_ubicacion_barrio", datosJuridicoDto.getObInfContactoUbicacion().getCumma43Out());
			params.put("infContacto_ubicacion_referencia", datosJuridicoDto.getObInfContactoUbicacion().getClaref1Out());
					
			//Info contacto--persona de telefono
			
//			String codProv = "";
//			if(datosJuridicoDto.getObjInfContactoTelefono().getCumhp11Out() != null &&
//					datosJuridicoDto.getObjInfContactoTelefono().getCumhp11Out().length() > 2){
//				codProv = datosJuridicoDto.getObjInfContactoTelefono().getCumhp11Out().substring(2);
//			}
			
			params.put("infContacto_tlfContacto_tlf1", 
					String.format("%s   (%s)   %s", 
									"", 
									UtilitarioComun.formatearCodigoNumericoDos(datosJuridicoDto.getObjInfContactoTelefono().getCumhp11Out()), 
									datosJuridicoDto.getObjInfContactoTelefono().getCumhp12Out() == null ? "" : datosJuridicoDto.getObjInfContactoTelefono().getCumhp12Out()
									)
					);
			
//			if(datosJuridicoDto.getObjInfContactoTelefono().getCumhp21Out() != null &&
//					datosJuridicoDto.getObjInfContactoTelefono().getCumhp21Out().length() > 2){
//				codProv = datosJuridicoDto.getObjInfContactoTelefono().getCumhp21Out().substring(2);
//			}
			params.put("infContacto_tlfContacto_tlf2", 
					String.format("%s   (%s)   %s", 
							"", 
							UtilitarioComun.formatearCodigoNumericoDos(datosJuridicoDto.getObjInfContactoTelefono().getCumhp21Out()), 
							datosJuridicoDto.getObjInfContactoTelefono().getCumhp22Out() == null ? "" : datosJuridicoDto.getObjInfContactoTelefono().getCumhp22Out()
							)
					);
			params.put("infContacto_tlfContacto_cell1",  
					String.format("%s   %s   %s", 
							"", 
							datosJuridicoDto.getObjInfContactoTelefono().getCumzpc1Out() == null ? "" : datosJuridicoDto.getObjInfContactoTelefono().getCumzpc1Out(), 
							helper.obtenerOperadora(datosJuridicoDto.getObjInfContactoTelefono().getCumtid1Out() == null ? "" : datosJuridicoDto.getObjInfContactoTelefono().getCumtid1Out())
							)
					);
			params.put("infContacto_tlfContacto_cell2",   
					String.format("%s   %s   %s", 
							"", 
							datosJuridicoDto.getObjInfContactoTelefono().getCumzpc2Out() == null ? "" : datosJuridicoDto.getObjInfContactoTelefono().getCumzpc2Out(), 
							helper.obtenerOperadora(datosJuridicoDto.getObjInfContactoTelefono().getCumtid2Out() == null ? "" : datosJuridicoDto.getObjInfContactoTelefono().getCumtid2Out())
							)
					);
			
			if (datosJuridicoDto.getObjInfContactoTelefono().getMctcenOut().trim().equals("1")){
				params.put("infContacto_tlfContacto_notificacionCell1", "x");
				params.put("infContacto_tlfContacto_notificaionnCell2", null);
			}
			else {
				if (datosJuridicoDto.getObjInfContactoTelefono().getMctcenOut().trim().equals("2")){
					params.put("infContacto_tlfContacto_notificaionnCell2", "x");
					params.put("infContacto_tlfContacto_notificacionCell1", null);
				}
				else {
					params.put("infContacto_tlfContacto_notificacionCell1", null); 
					params.put("infContacto_tlfContacto_notificaionnCell2", null);
				}	
			}
			
			//Info contacto--persona de correos
			params.put("infContacto_correo_correo1", datosJuridicoDto.getObjInfContactoTelefono().getCumma23Out());
			params.put("infContacto_correo_correo2", datosJuridicoDto.getObjInfContactoTelefono().getMctde2Out());
			
			if (datosJuridicoDto.getObjInfContactoTelefono().getNotificacionFlagEstCta().equals("1")) {
				params.put("infContacto_correo_estadoCuenta1", "x");
				params.put("infContacto_correo_estadoCuenta2", "");
			}else{
				params.put("infContacto_correo_estadoCuenta2", "x");
				params.put("infContacto_correo_estadoCuenta1", "");
			}
			
			if (datosJuridicoDto.getObjInfContactoTelefono().getMctdenOut().trim().equals("1")){
				params.put("infContacto_correo_notificaionCorreo1", "x");
				params.put("infContacto_correo_notificaionCorreo2", null);
			}
			else {
				if (datosJuridicoDto.getObjInfContactoTelefono().getMctdenOut().trim().equals("2")){
					params.put("infContacto_correo_notificaionCorreo2", "x");
					params.put("infContacto_correo_notificaionCorreo1", null);
				}
				else {
					params.put("infContacto_correo_notificaionCorreo1", null); 
					params.put("infContacto_correo_notificaionCorreo2", null);
				}	
			}
			
			//Info referencia--persona contacto
			params.put("infReferencia_contacto_nombre", datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCumma16Out());
			params.put("infReferencia_contacto_cargo", helper.obtenerCargo(datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCuminc6Out()));
			
//			String codProv="";
//			if(datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCumhp16Out() != null &&
//					datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCumhp16Out().length() > 2){
//				codProv = datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCumhp16Out().substring(2);
//			}
			params.put("infReferencia_contacto_telefono",
					String.format("%s   (%s)   %s", 
							"", 
							UtilitarioComun.formatearCodigoNumericoDos(datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCumhp16Out() == null ? "" : datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCumhp16Out()), 
							datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCumhp26Out() == null ? "" : datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCumhp26Out()
							)
					);
			params.put("infReferencia_contacto_celular",
					String.format("%s   %s   %s", 
							"", 
							datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCumzpc6Out() == null ? "" : datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCumzpc6Out(), 
							helper.obtenerOperadora(datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCumtid6Out() == null ? "" : datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCumtid6Out())
							)
					);
			params.put("infReferencia_contacto_correo", datosJuridicoDto.getObjInfReferenciaPersonaContacto().getCumma26Out());
			
			
			//Info referencia--persona principal cliente
			params.put("infReferencia_clientes_nombre", datosJuridicoDto.getObjInfReferenciaPrincipalCliente().getCoccpnOut());
			params.put("infReferencia_clientes_canton", null); // No hay data
			params.put("infReferencia_clientes_telefono",
					String.format("%s   (%s)   %s", 
							"",
							UtilitarioComun.formatearCodigoNumericoDos(ec.com.bancoInternacional.services.util.Util.substring(datosJuridicoDto.getObjInfReferenciaPrincipalCliente().getCoccp2Out(), 0, 1)),
							ec.com.bancoInternacional.services.util.Util.substring(datosJuridicoDto.getObjInfReferenciaPrincipalCliente().getCoccp2Out(), 1, 
									datosJuridicoDto.getObjInfReferenciaPrincipalCliente().getCoccp2Out().length())));
							
			params.put("infReferencia_clientes_celular",   
					String.format("%s   %s   %s", 
							"", 
							datosJuridicoDto.getObjInfReferenciaPrincipalCliente().getCoccpmOut() == null ? "" :
								datosJuridicoDto.getObjInfReferenciaPrincipalCliente().getCoccpmOut(), 
							 helper.obtenerOperadora(datosJuridicoDto.getObjInfReferenciaPrincipalCliente().getCoccpiOut() == null ? "" :
									datosJuridicoDto.getObjInfReferenciaPrincipalCliente().getCoccpiOut()))
					);
			
			//Info referencia--persona principal proveedor
			params.put("infReferencia_proveedor_nombre", datosJuridicoDto.getObjInfReferenciaPersonaProveedor().getCocppnOut());
			params.put("infReferencia_proveedor_canton", null); // No hay data
			
			params.put("infReferencia_proveedor_telefono",
					String.format("%s   (%s)   %s", 
							"",
							UtilitarioComun.formatearCodigoNumericoDos(ec.com.bancoInternacional.services.util.Util.substring(datosJuridicoDto.getObjInfReferenciaPersonaProveedor().getCocpp2Out(), 0, 1)),
							ec.com.bancoInternacional.services.util.Util.substring(datosJuridicoDto.getObjInfReferenciaPersonaProveedor().getCocpp2Out(), 1, 
									datosJuridicoDto.getObjInfReferenciaPersonaProveedor().getCocpp2Out().length())));
							
			params.put("infReferencia_proveedor_celular",   
					String.format("%s   %s   %s", 
							"", 
							datosJuridicoDto.getObjInfReferenciaPersonaProveedor().getCocppmOut() == null ? "" :
								datosJuridicoDto.getObjInfReferenciaPersonaProveedor().getCocppmOut(),
								helper.obtenerOperadora(datosJuridicoDto.getObjInfReferenciaPersonaProveedor().getCocppiOut() == null ? "" :
									datosJuridicoDto.getObjInfReferenciaPersonaProveedor().getCocppiOut()))
					);
						
			//Info transacciones en el exterior
			params.put("infTranExterior_montoDepositoMensual", datosJuridicoDto.getObjInfTransaccionesExterior().getCocvmsOut());
			params.put("infTranExterior_montoRetiroMensual", datosJuridicoDto.getObjInfTransaccionesExterior().getCocvrtOut());
			
			//Info Adicional
			if(datosJuridicoDto.getObjInfTransaccionesExterior().getCocrexOut().isEmpty()){
				params.put("infTranExterior_recibiraSi", null);
				params.put("infTranExterior_recibiraNo", null);
			}else if(Constantes.CODIGO_NOTIFICACION_SI.equals(datosJuridicoDto.getObjInfTransaccionesExterior().getCocrexOut())){
				params.put("infTranExterior_recibiraSi", "x");
				params.put("infTranExterior_recibiraNo", null);
			}else if(Constantes.CODIGO_NOTIFICACION_NO.equals(datosJuridicoDto.getObjInfTransaccionesExterior().getCocrexOut())){
				params.put("infTranExterior_recibiraSi", null);
				params.put("infTranExterior_recibiraNo", "x");
			}					
			
			params.put("infTranExterior_montoAnualRecibira", datosJuridicoDto.getObjInfTransaccionesExterior().getCocevaOut());
			params.put("infTranExterior_paisOrigen", helper.obtenerPais(datosJuridicoDto.getObjInfTransaccionesExterior().getCocepdOut()));
			
			if(datosJuridicoDto.getObjInfTransaccionesExterior().getCoceexOut().isEmpty()){				
				params.put("infTranExterior_enviaraSi", null);
				params.put("infTranExterior_enviaraNo", null);
			}else if(Constantes.CODIGO_NOTIFICACION_SI.equals(datosJuridicoDto.getObjInfTransaccionesExterior().getCoceexOut())){				
				params.put("infTranExterior_enviaraSi", "x");
				params.put("infTranExterior_enviaraNo", null);
			}else if(Constantes.CODIGO_NOTIFICACION_NO.equals(datosJuridicoDto.getObjInfTransaccionesExterior().getCoceexOut())){
				params.put("infTranExterior_enviaraSi", null);
				params.put("infTranExterior_enviaraNo", "x");				
			}
			
			
			params.put("infTranExterior_montoAnualEnviara", datosJuridicoDto.getObjInfTransaccionesExterior().getCocrvaOut());
			params.put("infTranExterior_paisDestino", helper.obtenerPais(datosJuridicoDto.getObjInfTransaccionesExterior().getCocrpoOut()));
						
			if(datosJuridicoDto.getObjInfTransaccionesExterior().getCocctlOut().isEmpty()){				
				params.put("infAdicional_otroInstitucionSi", null);
				params.put("infAdicional_otroInstitucionNo", null);
			}else if(Constantes.CODIGO_NOTIFICACION_SI.equals(datosJuridicoDto.getObjInfTransaccionesExterior().getCocctlOut())){				
				params.put("infAdicional_otroInstitucionSi", "x");
				params.put("infAdicional_otroInstitucionNo", null);
			}else if(Constantes.CODIGO_NOTIFICACION_NO.equals(datosJuridicoDto.getObjInfTransaccionesExterior().getCocctlOut())){
				params.put("infAdicional_otroInstitucionSi", null);
				params.put("infAdicional_otroInstitucionNo", "x");			
			}
			
			params.put("infAdicional_institucion", helper.obtenerInstitucionesFinancieras(datosJuridicoDto.getObjInfTransaccionesExterior().getCocnolOut()));
			params.put("infAdicional_observaciones", datosJuridicoDto.getObjInfTransaccionesExterior().getObserOut());
			
			
			// Subreportes
			params.put("SUBREPORT_DIR", getString("app.reportes.ruta"));

			// texto del contrato
			params.put("textoCiudadSuscribeContrato", credencial.getUsuarioCiudad());
			params.put("textoNroCelular", datosJuridicoDto.getObjInfContactoTelefono().getCumzpc1Out());
			
			if(!datosJuridicoDto.getObjInfContactoTelefono().getCumtid1Out().equals("")
					&& datosJuridicoDto.getObjInfContactoTelefono().getCumtid1Out() != null){
				if (Constantes.CODIGO_OPERADORA_CLARO_COD
						.equals(datosJuridicoDto.getObjInfContactoTelefono().getCumtid1Out())) {
					params.put("textoOprClaro", "SI");
					params.put("textoOprMovistar", "NO");
					params.put("textoOprCnt", "NO");
				} else if (Constantes.CODIGO_OPERADORA_MOVISTAR_COD
						.equals(datosJuridicoDto.getObjInfContactoTelefono().getCumtid1Out())) {
					params.put("textoOprClaro", "NO");
					params.put("textoOprMovistar", "SI");
					params.put("textoOprCnt", "NO");
				}
				if (Constantes.CODIGO_OPERADORA_CNT_COD.equals(datosJuridicoDto.getObjInfContactoTelefono().getCumtid1Out())) {
					params.put("textoOprClaro", "NO");
					params.put("textoOprMovistar", "NO");
					params.put("textoOprCnt", "SI");
				}
			} else {
				params.put("textoOprClaro", "NO");
				params.put("textoOprMovistar", "NO");
				params.put("textoOprCnt", "NO");
			}

			params.put("textoCorreo", datosJuridicoDto.getObjInfContactoTelefono().getCumma23Out());
			params.put("textoAutorizacion1Si", "(X)");
			params.put("textoAutorizacion1No", "   ");
			params.put("textoAutorizacion2Si", "(X)");
			params.put("textoAutorizacion2No", "");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocurrio un error al enviar parametros al imprimir reporte:" + e.getMessage());
			throw new Exception("Ocurrio un error al enviar parametros al imprimir reporte");
		}
		return params;
	}	

	/**
	 * Retorna el totalPasivo calculado por el totalActivo - totalPatrimonio
	 * 
	 * @param totalPatrimonio
	 * @param totalActivo
	 * @return
	 */
	public BigDecimal totalPasivo(BigDecimal totalPatrimonio, BigDecimal totalActivo){
		int totalPasivos = (totalActivo != null 
				&& !(totalActivo.compareTo(BigDecimal.ZERO)==0)
				&& totalPatrimonio != null
				&& !(totalPatrimonio.compareTo(BigDecimal.ZERO)==0) ?
						totalActivo.intValue() - totalPatrimonio.intValue() : 0
						);
		if(totalPasivos < 0) totalPasivos = 0;
		
		BigDecimal totalPasivosBigDecimal = new BigDecimal(totalPasivos);
		
		return totalPasivosBigDecimal;
	}

	/*
	 * Carga parametros reporte beneficiario final
	 */
	private Map<String, Object> obtenerParametrosReporteBeneficiarioFinal(Map<String, String> data, DatosJuridicoDto datosJuridicoDto) throws Exception {
		Map<String, Object> params = new HashMap<>();
		try {
			// Cabecera
			params.put("IMG_DIR", getImageRealPath());
			params.put("razonSocial", datosJuridicoDto.getObjIdentificacion().getCusna1Out());
			params.put("ruc", datosJuridicoDto.getObjIdentificacion().getCusid2Out());
			/*String fechaSistema = datosJuridicoDto.getObjInfBasica().getCusbdfOut();
			params.put("fechaSistema", (fechaSistema != null && !fechaSistema.equals("") ? 
					UtilitarioComun.convertStringDate(fechaSistema): null));*/
			
			// Subreportes
			params.put("SUBREPORT_DIR", getString("app.reportes.ruta"));

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocurrio un error al enviar parametros al imprimir reporte:" + e.getMessage());
			throw new Exception("Ocurrio un error al enviar parametros al imprimir reporte");
		}
		return params;
	}

	public JRBeanCollectionDataSource cargaDataReporte(HelperImprimir helper, DatosJuridicoDto datosJuridicoDto)
			throws Exception {
		DataBeanRptJuridico dataBean = new DataBeanRptJuridico();

		List<RepLegalesDto> lstRepLegalesDto = new ArrayList<RepLegalesDto>();
		List<RepLegalesDto> lstRepLegalesExcluyendoElPrimero = new ArrayList<RepLegalesDto>();

		int contadorRegistros = 0;
		for (RepresentanteLegal item : datosJuridicoDto.getLstRepresentanteLegal()) {
			if ("".equals(item.getCumbn24Out().trim()))
				continue;

			RepLegalesDto aux = new RepLegalesDto();
			String identificacionRep = item.getCumbn24Out();
			if (ec.com.bancoInternacional.view.util.Constantes.PASAPORTE_TYPE_ID.equals(item.getCumbn14Out())) {
				identificacionRep = UtilitarioComun.eliminarCerosDeLaIzquierdaEnPasaporte(item.getCumbn24Out());
			}
			if (ec.com.bancoInternacional.view.util.Constantes.CEDULA_TYPE_ID.equals(item.getCumbn14Out())) {
				identificacionRep = UtilitarioComun.eliminarCerosDeLaDerechaEnCedula(item.getCumbn24Out());
			}
			aux.setTipoIdentificacion(UtilitarioComun.obtenerTipoIdentificacion(item.getCumbn14Out()));

			aux.setIdentificacion(identificacionRep);
			aux.setNombres(item.getCumma14Out().trim());
			aux.setCargo((!item.getLidnot4Out().equals("") && item.getLidnot4Out() != null) ? helper.obtenerCargo(item.getLidnot4Out()) : "");
			aux.setVencimientoNombramiento(UtilitarioComun.convertSdf8ToSdfIso(item.getLidfev4Out()));

			aux.setNacionalidad(helper.obtenerNacionalidadPorPais(item.getCumctr4Out()));

			aux.setFechaNacimiento(UtilitarioComun.convertSdf8ToSdfIso(item.getCumzpc4Out()));
			aux.setEstadoCivil(helper.obtenerEstadoCivil(item.getCumbms4Out()).toUpperCase());
			
			String codProv = "";
			if(item.getLidtt14Out() != null &&
					item.getLidtt14Out().length() > 2){
				codProv = item.getLidtt14Out().substring(2);
			}
			aux.setTelefono(
					String.format("%s   (%s)   %s", 
							helper.obtenerCodigoInternacionalPorPais(item.getCumctr4Out()), 
							codProv, 
							item.getLidtt24Out() == null ? "" : item.getLidtt24Out().trim()
							));

			aux.setCelular(null); // No hay data
//			aux.setCorreo(item.getLidema4out() == null ? "" : item.getLidema4out().trim());
			aux.setCorreo(item.getLidema4out());
			aux.setIdentificacionConyugue(item.getCumbni5Out());
			aux.setNombreConyugue(item.getCumma15Out().trim());
//			aux.setPais(helper.obtenerPais(item.getCumctr4Out()));
			aux.setPais(item.getCummld4Out());
			aux.setCanton(item.getCumpod24Out()); 
//			aux.setProvincia(helper.obtenerProvincia(item.getCumste4Out())); // No hay data
			aux.setProvincia(item.getCumpod14Out());
			aux.setTipoCasa(null); // No hay data
			aux.setTipoEdificio(null); // No hay data
			aux.setCalle(item.getCumma2c4Out());
			aux.setNumero(item.getCumma2n4Out());
			aux.setCalleSecundaria(item.getCumma34Out());
			aux.setPiso(item.getCumma4p4Out());
			aux.setDepartamento(item.getCumma4d4Out());
			aux.setBarrio(item.getCumma4b4Out());
			aux.setReferencia(item.getClaref4Out());
			aux.setParroquia(item.getCumpod34Out());
			lstRepLegalesDto.add(aux);
			if(contadorRegistros != 0){
				lstRepLegalesExcluyendoElPrimero.add(aux);
			}
			contadorRegistros++;
		}
		for (RepLegalesDto item : lstRepLegalesDto) {
			lstRepLegalesDto.get(lstRepLegalesDto.indexOf(item)).setCountRepLegales(lstRepLegalesDto.indexOf(item) + 1);
		}
		dataBean.setRepLegalesList(lstRepLegalesDto);
		dataBean.setRepLegalesListExcluyendoElPrimero(lstRepLegalesExcluyendoElPrimero);

		List<AccionistasDto> lstAccionistasDto = new ArrayList<AccionistasDto>();
		List<BeneficiarioDto> lstBeneficiarioDto = new ArrayList<BeneficiarioDto>();

		int count = 1;
		for (Accionista item : datosJuridicoDto.getLstAccionista()) {
			if ("".equals(item.getLidid27Out().trim()))
				continue;

			AccionistasDto auxAccionistas = new AccionistasDto();

			if (item.getLidtid7Out() != null && !item.getLidtid7Out().isEmpty()) {
				if (Constantes.PERSONA_NATURAL.equals(item.getLidtid7Out())) {
					auxAccionistas.setTipoNatural("x");
					auxAccionistas.setTipoJuridico(null);
				} else if (Constantes.PERSONA_JURIDICA.equals(item.getLidtid7Out())) {
					auxAccionistas.setTipoNatural(null);
					auxAccionistas.setTipoJuridico("x");
				} else {
					auxAccionistas.setTipoNatural(null);
					auxAccionistas.setTipoJuridico(null);
				}
			}

			auxAccionistas.setTipo(item.getLidid17Out());
			auxAccionistas.setIdentificacion(item.getLidid27Out());
			auxAccionistas.setNombre(item.getLidnme7Out());
			auxAccionistas.setPorcentaje(item.getLidttr7Out());
			auxAccionistas.setMonto(item.getLidnac7Out());
			auxAccionistas.setNacionalidad(helper.obtenerNacionalidad(item.getDadnac7Out()));

			if (item.getLidpep7Out() != null && !item.getLidpep7Out().isEmpty()) {
				if (Constantes.CODIGO_PEP_SI.equals(item.getLidpep7Out().trim())) {
					auxAccionistas.setPepSi("x");
					auxAccionistas.setPepNo(null);
					auxAccionistas.setPep(Constantes.BOOLEAN_VERDADERO_FLAG);
				} else if (Constantes.CODIGO_PEP_NO.equals(item.getLidpep7Out().trim())) {
					auxAccionistas.setPepSi(null);
					auxAccionistas.setPepNo("x");
					auxAccionistas.setPep(Constantes.BOOLEAN_FALSO_FLAG);
				} else {
					auxAccionistas.setPepSi(null);
					auxAccionistas.setPepNo(null);
				}
			}

			auxAccionistas.setCountAccionista(count);
			lstAccionistasDto.add(auxAccionistas);

			if(item.getBeneficiario() != null){
				BeneficiarioDto auxBeneficiario = new BeneficiarioDto();
				auxBeneficiario.setTipo(UtilitarioComun.obtenerTipoIdentificacion(item.getBeneficiario().getDadid17Out()));
				auxBeneficiario.setIdentificacion(UtilitarioComun.getClientIdNoType(item.getBeneficiario().getDadid17Out()+item.getBeneficiario().getDadid27Out()));
				auxBeneficiario.setNombres(item.getBeneficiario().getDadnom7Out());
				auxBeneficiario.setNacionalidad(helper.obtenerNacionalidad(item.getBeneficiario().getDadnab7Out()));
				
				auxBeneficiario.setCountBeneficiario(count);
	
				lstBeneficiarioDto.add(auxBeneficiario);
			}
			
			count++;
		}
		
		dataBean.setBeneficiariosList(lstBeneficiarioDto);		
		dataBean.setAccionistasList(lstAccionistasDto);

		List<DataBeanRptJuridico> dataBeanList = new ArrayList<DataBeanRptJuridico>();

		dataBeanList.add(dataBean);

		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);

		return beanColDataSource;
	}
	
	/**
	 * cargar mensaje de que se esta procesando la solicitud de reenvio de email
	 * cuando sea reimpresion
	 * @param response
	 */
	public void cargarMensajeDeEsperaRespuesta(HttpServletResponse response){
		logger.info("Inicia metodo cargarMensajeDeEsperaRespuesta");
		response.setContentType("text/html");
		try {
			response.getWriter().print(
					"<!DOCTYPE html><html><body id='cuerpoMensajeRecargar'>"
					+ Constantes.MENSAJE_NOTIFICACION_PROCESO_ESPERA
					+ "</body></html>");
		} catch (Exception errorCargarMensajeDeEsperaRespuesta) {
			logger.error("Ocurrio error en el metodo errorCargarMensajeDeEsperaRespuesta" + errorCargarMensajeDeEsperaRespuesta);
			errorCargarMensajeDeEsperaRespuesta.printStackTrace();
		}
		logger.info("Finaliza metodo cargarMensajeDeEsperaRespuesta");
	}
	
	/**
	 * 
	 * @param response
	 */
	public void cargarMensajeDeClienteNoexiste(HttpServletResponse response){
		logger.info("Inicia metodo cargarMensajeDeEsperaRespuesta");
		response.setContentType("text/html");
		try {
			response.getWriter().print(
					"<!DOCTYPE html><html><body id='cuerpoMensajeRecargar'>"
					+ Constantes.MENSAJE_NOTIFICACION_NO_TIENE_ESTADO
					+ "</body></html>");
		} catch (Exception errorCargarMensajeDeEsperaRespuesta) {
			logger.error("Ocurrio error en el metodo errorCargarMensajeDeEsperaRespuesta" + errorCargarMensajeDeEsperaRespuesta);
			errorCargarMensajeDeEsperaRespuesta.printStackTrace();
		}
		logger.info("Finaliza metodo cargarMensajeDeEsperaRespuesta");
	}
}
