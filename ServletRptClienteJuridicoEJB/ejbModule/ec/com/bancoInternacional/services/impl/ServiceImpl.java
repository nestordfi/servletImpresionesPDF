package ec.com.bancoInternacional.services.impl;

import java.math.BigDecimal;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.config.Application;
import ec.com.bancoInternacional.cs0012.CONVALBANCO;
import ec.com.bancoInternacional.cs0012.CONVALUSUARIO;
import ec.com.bancoInternacional.cs0012.CTRBTHOUDATA;
import ec.com.bancoInternacional.cs0012.CTRCNTOUDATA;
import ec.com.bancoInternacional.cs0012.VALUSERS;
import ec.com.bancoInternacional.cs0133.CONNOTIF;
import ec.com.bancoInternacional.cs0133.DETERRO;
import ec.com.bancoInternacional.cs0133.LSTCLIUPD;
import ec.com.bancoInternacional.cs0133.UPDNOTIF;
import ec.com.bancoInternacional.cs0135.GETINFOJUR;
import ec.com.bancoInternacional.server.seguridad.Credencial;
import ec.com.bancoInternacional.services.domain.DatosJuridicoDto;
import ec.com.bancoInternacional.services.exception.PooledTrxException;
import ec.com.bancoInternacional.services.ibm.pool.PooledTrx;
import ec.com.bancoInternacional.services.mapping.DatosEnvioCorreo;
import ec.com.bancoInternacional.services.mapping.ServicioMapper;
import ec.com.bancoInternacional.services.util.Constantes;
import ec.com.bancoInternacional.services.util.Util;

/**
 * Autor: Carlos Carrera Objetivo: Clase concreta que implementa servicios de
 * clientes Fecha: 22-12-2017 Nro. Req: 1546 Version: 1.0
 */
@Stateless
public class ServiceImpl extends PooledTrx{
	private static final Logger logger = Logger.getLogger(ServiceImpl.class);

	
	public ServiceImpl() {
		super();
	}
	
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

				String rundate = Util.dateWeb(anioRD, datosBnk.getBNKCNTRDM(), datosBnk.getBNKCNTRDD());
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
		String app = Application.getString("app.dir.next");
		String menu = Application.getString(app + ".menu");
		String opc = Application.getString(app + ".opc");

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

	/*
	 * Call al servicio que recupera data para el reporte de vinculación de cliente jurídico
	 */
	public DatosJuridicoDto recuperarReporteClienteJuridico(String identificacion) throws PooledTrxException {

		DatosJuridicoDto datosJuridicoDto = new DatosJuridicoDto();
		GETINFOJUR getInfoJuridico = new GETINFOJUR();
		getInfoJuridico.setCONIDNINP(identificacion);
		
		logger.info("Parametros de entreda: " + getInfoJuridico.toString());
		
		try {
			invokeTrx(getInfoJuridico);
			
			if(getInfoJuridico.getReturnValue() == 0){
				logger.info("Proceso con exito");
				logger.info(getInfoJuridico.toString());
				
				datosJuridicoDto = ServicioMapper.mapperDATJURIDToDatosJuridicoDto(getInfoJuridico.getCONDATOUT());
			}else{
				logger.info("Proceso con errores");
				datosJuridicoDto.setError(getInfoJuridico.getCONERROUT() == null ? "" : getInfoJuridico.getCONERROUT().trim());
			}
		} catch (Exception ex) {
			logger.error(ex);
			ex.printStackTrace();
			throw new PooledTrxException(ex.getMessage());
		} finally {
			getInfoJuridico = null;
		}
		return datosJuridicoDto;

	}
	
	/**
	 * 
	 * @param Ibs
	 * @param numeroDeCuenta
	 * @return
	 * @throws PooledTrxException
	 */
	public DatosEnvioCorreo consultaEstadoEnvioContratroEmail(BigDecimal Ibs, BigDecimal numeroDeCuenta) throws PooledTrxException {
		logger.info("Inicia metodo consultaEstadoEnvioContratroEmail");
		
		DatosEnvioCorreo datosEnvioCorreo = new DatosEnvioCorreo();
		CONNOTIF connotif = new CONNOTIF(); 
		connotif.setCONIBSINP(Ibs);
		connotif.setCONCUEINP(numeroDeCuenta);
		
		try{
			logger.info("Inicia llamada al as400 metodo consultaEstadoEnvioContratroEmail");
			invokeTrx(connotif);
			logger.info("Finaliza llamada al as400 metodo consultaEstadoEnvioContratroEmail");
			
			BigDecimal codigoError = new BigDecimal(connotif.getReturnValue());
			DETERRO[] listaError = connotif.getCONERROUT();
			
			datosEnvioCorreo = ServicioMapper.mapearDatosALaInformacionEnvioCorreo(connotif.getCONENVOUT().trim(), 
					connotif.getCONFUNOUT(), codigoError);
			
			logger.info("Estado del envio del correo: " + connotif.getCONENVOUT());
			
			if(codigoError.compareTo(BigDecimal.ZERO) != 0){
				if(listaError != null && !listaError.equals("")) {
					logger.info("Se encontro el siguiente error devuelto por as400 consultaEstadoEnvioContratroEmail: " + 
						Util.mostrarMensajesDeErroEnElReenvioCorreo(codigoError, listaError));
				}
			}
		} catch (Exception errorConsultaEstadoEnvioContratroEmail) {
			logger.error("Ocurrio error en el metodo consultaEstadoEnvioContratroEmail: " + errorConsultaEstadoEnvioContratroEmail);
			errorConsultaEstadoEnvioContratroEmail.printStackTrace();
		}
		
		connotif = null;
		
		logger.info("Finaliza metodo consultaEstadoEnvioContratroEmail");
		
		return datosEnvioCorreo;
	}
	
	public void actualizarEstadoEnvioContratroEmail(String codigoIbs, String estadoEnvioCorreo, String mensajeEnvioCorreo, 
			String correoContacto, String usuario) throws PooledTrxException {
		logger.info("Inicia metodo actualizarEstadoEnvioContratroEmail");
		
		UPDNOTIF updnotif = new UPDNOTIF();
		LSTCLIUPD lstcliupd = new LSTCLIUPD();
		
		try{
			BigDecimal ibsCodigo = new BigDecimal(codigoIbs);
			updnotif.setUPDDATINP(ServicioMapper.mapearDatosAlObjetoDeEnvioCorreo(lstcliupd, ibsCodigo, estadoEnvioCorreo, 
					mensajeEnvioCorreo, correoContacto));
			updnotif.setUPDUSUINP(usuario);
			updnotif.setUPDPGMINP(Constantes.NOMBRE_PROCESO);
				
			logger.info("Inicia llamada al as400 metodo actualizarEstadoEnvioContratroEmail");
			invokeTrx(updnotif);
			logger.info("Finaliza llamada al as400 metodo actualizarEstadoEnvioContratroEmail");
			
			DETERRO[] listaError = updnotif.getUPDERROUT();
			BigDecimal codigoError = new BigDecimal(updnotif.getReturnValue());
			
			if(codigoError.compareTo(BigDecimal.ZERO) != 0){
				if(listaError != null && !listaError.equals("")) {
					logger.info("Se encontro el siguiente error devuelto por as400 actualizarEstadoEnvioContratroEmail: " + 
						Util.mostrarMensajesDeErroEnElReenvioCorreo(codigoError, listaError));
				}
			}
		} catch (Exception errorConsultaEstadoEnvioContratroEmail) {
			logger.error("Ocurrio error en el metodo consultaEstadoEnvioContratroEmail: " + errorConsultaEstadoEnvioContratroEmail);
			errorConsultaEstadoEnvioContratroEmail.printStackTrace();
		}
		
		updnotif = null;
		lstcliupd = null;
		
		logger.info("Finaliza metodo actualizarEstadoEnvioContratroEmail");
	}
}