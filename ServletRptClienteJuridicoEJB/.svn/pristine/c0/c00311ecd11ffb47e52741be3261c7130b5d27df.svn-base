package ec.com.bancoInternacional.services.mapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ec.com.bancoInternacional.cs0133.LSTCLIUPD;
import ec.com.bancoInternacional.cs0133.LSTFUNCIO;
import ec.com.bancoInternacional.cs0135.ACCIONDS;
import ec.com.bancoInternacional.cs0135.DATJURID;
import ec.com.bancoInternacional.cs0135.OBSERDATA;
import ec.com.bancoInternacional.cs0135.REPLEGDS;
import ec.com.bancoInternacional.services.domain.Accionista;
import ec.com.bancoInternacional.services.domain.BeneficiarioFinal;
import ec.com.bancoInternacional.services.domain.DatosJuridicoDto;
import ec.com.bancoInternacional.services.domain.FormularioFatca;
import ec.com.bancoInternacional.services.domain.Identificacion;
import ec.com.bancoInternacional.services.domain.InfBasica;
import ec.com.bancoInternacional.services.domain.InfContactoTelefonoCorreo;
import ec.com.bancoInternacional.services.domain.InfContactoUbicacion;
import ec.com.bancoInternacional.services.domain.InfFinanciera;
import ec.com.bancoInternacional.services.domain.InfReferenciaPersonaContacto;
import ec.com.bancoInternacional.services.domain.InfReferenciaPersonaProveedor;
import ec.com.bancoInternacional.services.domain.InfReferenciaPrincipalCliente;
import ec.com.bancoInternacional.services.domain.InfTransaccionesExterior;
import ec.com.bancoInternacional.services.domain.RepresentanteLegal;
import ec.com.bancoInternacional.services.util.Util;

public class ServicioMapper {
	public static DatosJuridicoDto mapperDATJURIDToDatosJuridicoDto(DATJURID info) {
		DatosJuridicoDto datos = new DatosJuridicoDto();

		Identificacion objIdentificacion = new Identificacion();		
		mapperIdentificacion(info, objIdentificacion);
		
		datos.setObjIdentificacion(objIdentificacion);
		
		InfBasica objInfBasica = new InfBasica();
		mapperInfBasica(info, objInfBasica);
		
		datos.setObjInfBasica(objInfBasica);
		
		InfFinanciera objInfFinanciera = new InfFinanciera();
		mapperInfFinanciera(info, objInfFinanciera);
		
		datos.setObjInfFinanciera(objInfFinanciera);
		
		FormularioFatca objFormularioFatca = new FormularioFatca();
		mapperFormularioFatca(info, objFormularioFatca);
		
		datos.setObjFormularioFatca(objFormularioFatca);
		
		InfContactoUbicacion obInfContactoUbicacion = new InfContactoUbicacion();
		mapperInfContactoUbicacion(info, obInfContactoUbicacion);
		
		datos.setObInfContactoUbicacion(obInfContactoUbicacion);
		
		InfContactoTelefonoCorreo objInfContactoTelefono = new InfContactoTelefonoCorreo();
		mapperInfContactoTelefono(info, objInfContactoTelefono);
		
		datos.setObjInfContactoTelefono(objInfContactoTelefono);
		
		InfReferenciaPersonaContacto objInfReferenciaPersonaContacto = new InfReferenciaPersonaContacto();
		mapperInfReferenciaPersonaContacto(info, objInfReferenciaPersonaContacto);
		
		datos.setObjInfReferenciaPersonaContacto(objInfReferenciaPersonaContacto);
		
		InfReferenciaPrincipalCliente objInfReferenciaPrincipalCliente = new InfReferenciaPrincipalCliente();
		mapperInfReferenciaPrincipalCliente(info, objInfReferenciaPrincipalCliente);
		
		datos.setObjInfReferenciaPrincipalCliente(objInfReferenciaPrincipalCliente);
		
		InfReferenciaPersonaProveedor objInfReferenciaPersonaProveedor  = new InfReferenciaPersonaProveedor();
		mapperInfReferenciaPersonaProveedor(info, objInfReferenciaPersonaProveedor);
		
		datos.setObjInfReferenciaPersonaProveedor(objInfReferenciaPersonaProveedor);
		
		InfTransaccionesExterior objInfTransaccionesExterior = new InfTransaccionesExterior();
		mapperInfTransaccionesExterior(info, objInfTransaccionesExterior);
		
		datos.setObjInfTransaccionesExterior(objInfTransaccionesExterior);

		List<RepresentanteLegal> lstRepresentanteLegal = new ArrayList<RepresentanteLegal>();
		for(REPLEGDS item : info.getREPLEGOUT()){
			if(item != null){
				if(!item.getCUMBN24OUT().equals("") && item.getCUMBN24OUT() != null){
					RepresentanteLegal aux = new RepresentanteLegal();
					mapperREPLEGOUTToRepresentanteLegal(item, aux);
					
					lstRepresentanteLegal.add(aux);	
				}
			}
		}
		
		datos.setLstRepresentanteLegal(lstRepresentanteLegal);
				
		List<Accionista> lstAccionista = new ArrayList<Accionista>();
				
		BigDecimal suma = BigDecimal.ZERO;
		suma = info.getLIMCSUOUT();
//		for(ACCIONDS item : info.getACCIONOUT()){
//			suma = suma.add(item.getLIDNAC7OUT());
//		}
		
		for(ACCIONDS item : info.getACCIONOUT()){
			if(item != null){
				Accionista aux = new Accionista();					
				mapperACCIONOUTToAccionista(item, aux);
				if(suma.compareTo(BigDecimal.ZERO) > 0 && aux.getLidnac7Out().compareTo(BigDecimal.ZERO) > 0){
					try{
						aux.setLidttr7Out((aux.getLidnac7Out().multiply(new BigDecimal(100))).divide(suma,2, BigDecimal.ROUND_HALF_UP));
					}catch(Exception er){}
				}
				lstAccionista.add(aux);
			}
		}
		
		datos.setLstAccionista(lstAccionista);

		return datos;
	}

	private static void mapperIdentificacion(DATJURID info, Identificacion objIdentificacion) {
		objIdentificacion.setCusid1Out(info.getCUSID1OUT());
		objIdentificacion.setCusid2Out(info.getCUSID2OUT());
		objIdentificacion.setCusna1Out(info.getCUSNA1OUT());
	}

	private static void mapperInfBasica(DATJURID info, InfBasica objInfBasica) {
		objInfBasica.setCocmacOut(info.getCOCMACOUT());
		objInfBasica.setCocmotOut(info.getCOCMOTOUT());
		objInfBasica.setCudregOut(info.getCUDACTOUT());//cambio de nombre en el campo
		//objInfBasica.setCudregOut(info.getCUDREGOUT());
		objInfBasica.setCuibcyOut(info.getCUIBCYOUT());
//		objInfBasica.setCusbucOut("prueba");
//		objInfBasica.setCuscaiOut(BigDecimal.ZERO);
		objInfBasica.setCuscobOut(info.getCUSCOBOUT());
		objInfBasica.setCusfnaOut(info.getMCTNOCOUT());
//		objInfBasica.setCusincOut("prueba");
		objInfBasica.setLimcecOut(info.getCUSBDFOUT());
		objInfBasica.setLimcsuOut(info.getLIMCSUOUT());
		objInfBasica.setLimdurOut(info.getLIMDUROUT());
		objInfBasica.setLimmecOut(info.getLIMMECOUT());
		objInfBasica.setCusbdfOut(info.getCUSBDFOUT().toString());//fecha en que se guardo el registro del cliente
		objInfBasica.setFechaConstitucion(info.getCUSFCOOUT());
		
		//NUEVO MAPEO CS0135
		objInfBasica.setCuiprdOut(info.getCUIPRDOUT()); //desc. Prod. o servicio vinculacion
		objInfBasica.setCujobjOut(info.getCUJOBJOUT());
		objInfBasica.setMctaepOut(info.getMCTAEPOUT());
		objInfBasica.setMctaedOut(info.getMCTAEDOUT());//descripcion actividad economica		
	}

	private static void mapperInfFinanciera(DATJURID info, InfFinanciera objInfFinanciera) {
		objInfFinanciera.setCuidi3Out(info.getCUIDI3OUT());
		objInfFinanciera.setCuidi4Out(info.getCUIDI4OUT());
		objInfFinanciera.setCuitfcOut(info.getCUITFCOUT());
	}

	private static void mapperFormularioFatca(DATJURID info, FormularioFatca objFormularioFatca) {			
		objFormularioFatca.setCujfa1Out(info.getCUJFA1OUT());
		objFormularioFatca.setCujfa2Out(info.getCUJFA2OUT());
		objFormularioFatca.setCujfa3Out(info.getCUJFA3OUT());
	}

	private static void mapperInfContactoUbicacion(DATJURID info, InfContactoUbicacion obInfContactoUbicacion) {
		obInfContactoUbicacion.setCumma21Out(info.getCUMMA2C1OUT());
		obInfContactoUbicacion.setCumma22Out(info.getCUMMA2N1OUT());
		obInfContactoUbicacion.setCumma31Out(info.getCUMMA31OUT());
		obInfContactoUbicacion.setCumma41Out(info.getCUMMA4P1OUT());
		obInfContactoUbicacion.setCumma42Out(info.getCUMMA4D1OUT());
		obInfContactoUbicacion.setCumma43Out(info.getCUMMA4B1OUT());
		obInfContactoUbicacion.setCussteOut(info.getCUMPOD11OUT());
		obInfContactoUbicacion.setClaref1Out(info.getCLAREF1OUT());
		//NUEVO MAPEO CS0135
		obInfContactoUbicacion.setCumpod21Out(info.getCUMPOD21OUT());//desc. Canton domicilio
		obInfContactoUbicacion.setCumpod31Out(info.getCUMPOD31OUT());//desc. PARROQUIA domicilio
		obInfContactoUbicacion.setPaisDomicilio(info.getCUMMLD1OUT());
		obInfContactoUbicacion.setProvinciaDomicilio(info.getCUMPOD11OUT());
	}

	private static void mapperInfContactoTelefono(DATJURID info, InfContactoTelefonoCorreo objInfContactoTelefonoCorreo) {
		objInfContactoTelefonoCorreo.setCumhp11Out(Util.substring(info.getMCTNTDOUT(), 0, 1));
		objInfContactoTelefonoCorreo.setCumhp12Out(info.getMCTNTDOUT());
		objInfContactoTelefonoCorreo.setCumhp21Out(Util.substring(info.getMCTNTTOUT(), 0, 1));
		objInfContactoTelefonoCorreo.setCumhp22Out(info.getMCTNTTOUT());
		objInfContactoTelefonoCorreo.setCumma23Out(info.getMCTDE1OUT());
		objInfContactoTelefonoCorreo.setCumtid1Out(info.getMCTOCPOUT());
		objInfContactoTelefonoCorreo.setCumtid2Out(info.getMCTOCTOUT());
		objInfContactoTelefonoCorreo.setCumzpc1Out(info.getMCTNCPOUT());
		objInfContactoTelefonoCorreo.setCumzpc2Out(info.getMCTNCTOUT());
		objInfContactoTelefonoCorreo.setMctcenOut(info.getMCTCENOUT());//celular notificacion empresa
		objInfContactoTelefonoCorreo.setMctdenOut(info.getMCTDENOUT());//correo notificacion empresa
		objInfContactoTelefonoCorreo.setMctde2Out(info.getMCTDE2OUT());//correo 2
		objInfContactoTelefonoCorreo.setNotificacionFlagEstCta(info.getFLAGESTCTA());//flag notificacion correo estados de cuenta
	}

	private static void mapperInfReferenciaPersonaContacto(DATJURID info,
			InfReferenciaPersonaContacto objInfReferenciaPersonaContacto) {
		objInfReferenciaPersonaContacto.setCumbni6Out("");
		objInfReferenciaPersonaContacto.setCumhp16Out(info.getCUMHP16OUT());
		objInfReferenciaPersonaContacto.setCumhp26Out(info.getCUMHP26OUT());
		objInfReferenciaPersonaContacto.setCuminc6Out(info.getCUMINC6OUT());
		objInfReferenciaPersonaContacto.setCumma16Out(info.getCUMMA16OUT());
		objInfReferenciaPersonaContacto.setCumma26Out(info.getCUMCOR6OUT());
		objInfReferenciaPersonaContacto.setCumtid6Out(info.getCUMTID6OUT());
		objInfReferenciaPersonaContacto.setCumzpc6Out(info.getCUMZPC6OUT());
	}

	private static void mapperInfReferenciaPrincipalCliente(DATJURID info,
			InfReferenciaPrincipalCliente objInfReferenciaPrincipalCliente) {
		objInfReferenciaPrincipalCliente.setCoccp2Out((null==info.getCUDTE11OUT() ? "": info.getCUDTE11OUT().toString()));//se envia telefono
		objInfReferenciaPrincipalCliente.setCoccpiOut(info.getCUDCAD1OUT());//se envia celular operadora
		objInfReferenciaPrincipalCliente.setCoccpmOut((null==info.getCUDTE21OUT() ? "" : info.getCUDTE21OUT().toString()));//se envia celular numero
		objInfReferenciaPrincipalCliente.setCoccpnOut(info.getCUDLUG1OUT());//cambio de nombre en el campo
		
//		objInfReferenciaPrincipalCliente.setCoccp2Out(info.getCOCCP2OUT());
//		objInfReferenciaPrincipalCliente.setCoccpiOut(info.getCOCCPIOUT());
//		objInfReferenciaPrincipalCliente.setCoccpmOut(info.getCOCCPMOUT());
//		objInfReferenciaPrincipalCliente.setCoccpnOut(info.getCOCCPNOUT());
	}

	private static void mapperInfReferenciaPersonaProveedor(DATJURID info,
			InfReferenciaPersonaProveedor objInfReferenciaPersonaProveedor) {
		objInfReferenciaPersonaProveedor.setCocpp2Out(null==info.getCUDTE12OUT() ? "" : info.getCUDTE12OUT().toString());//telefono 
//		objInfReferenciaPersonaProveedor.setCocpp2Out(info.getCOCP2OUT());
		objInfReferenciaPersonaProveedor.setCocppiOut(info.getCUDCAD2OUT());//operadora
		objInfReferenciaPersonaProveedor.setCocppmOut(null==info.getCUDTE22OUT() ? "" : info.getCUDTE22OUT().toString());//celular
		objInfReferenciaPersonaProveedor.setCocppnOut(info.getCUDLUG2OUT());//nombres
	}

	private static void mapperInfTransaccionesExterior(DATJURID info,
			InfTransaccionesExterior objInfTransaccionesExterior) {
		objInfTransaccionesExterior.setCoceexOut(info.getCOCEEXOUT());
		objInfTransaccionesExterior.setCocepdOut(info.getCOCEPDOUT());
		objInfTransaccionesExterior.setCocevaOut(info.getCOCEVAOUT());
		objInfTransaccionesExterior.setCocrexOut(info.getCOCREXOUT());
		objInfTransaccionesExterior.setCocrpoOut(info.getCOCRPOOUT());
		objInfTransaccionesExterior.setCocrvaOut(info.getCOCRVAOUT());
		objInfTransaccionesExterior.setCocvmsOut(info.getCOCVMSOUT());
		objInfTransaccionesExterior.setCocvrtOut(info.getCOCVRTOUT());
		
		objInfTransaccionesExterior.setCocctlOut(info.getCOCCTLOUT());
		objInfTransaccionesExterior.setCocnolOut(info.getCOCNOLOUT());
		String obs = "";
		for(OBSERDATA item : info.getOBSEROUT()){
			if(item != null){
				if(!"".equals(item.getSPIDSC1OUT().trim())){
					obs += item.getSPIDSC1OUT().trim()+"<br></br>";
				}
			}
		}
		objInfTransaccionesExterior.setObserOut(obs);
	}

	private static void mapperACCIONOUTToAccionista(ACCIONDS item, Accionista aux) {
		aux.setDadnac7Out(item.getDADNAC7OUT());
		aux.setLidid17Out(item.getLIDID17OUT());
		aux.setLidid27Out(item.getLIDID27OUT());
		aux.setLidnac7Out(item.getDADVAL7OUT());
		aux.setLidnme7Out(item.getLIDNME7OUT());
		aux.setLidpep7Out(item.getLIDPEP7OUT());
		aux.setLidtid7Out(item.getLIDTID7OUT());
		aux.setLidttr7Out(item.getLIDTTR7OUT());
		
		BeneficiarioFinal beneficiario = new BeneficiarioFinal();
		aux.setBeneficiario(mapperBeneficiarioFinal(item, beneficiario));
	}

	private static BeneficiarioFinal mapperBeneficiarioFinal(ACCIONDS item, BeneficiarioFinal beneficiario) {
		if((item.getDADID17OUT()== null || item.getDADID17OUT().isEmpty())
			&& (item.getDADID27OUT()== null || item.getDADID27OUT().isEmpty())
			&&(item.getDADNAB7OUT()== null || item.getDADNAB7OUT().isEmpty())
			&&(item.getDADNOM7OUT()== null || item.getDADNOM7OUT().isEmpty())
			){
			return null;
		}
		
		beneficiario.setDadid17Out(item.getDADID17OUT());
		beneficiario.setDadid27Out(item.getDADID27OUT());
		beneficiario.setDadnab7Out(item.getDADNAB7OUT());
		beneficiario.setDadnom7Out(item.getDADNOM7OUT());
		
		return beneficiario;
	}

	private static void mapperREPLEGOUTToRepresentanteLegal(REPLEGDS item, RepresentanteLegal aux) {
		aux.setCumbms4Out(item.getCUMBMS4OUT());
		aux.setCumbn14Out(item.getCUMBN14OUT());
		aux.setCumbn24Out(item.getCUMBN24OUT());
		aux.setCumbni5Out(item.getCUMBNI5OUT());
		aux.setCumctr4Out(item.getCUMCTD4OUT()); // Nacionalidad
		aux.setCumma14Out(item.getCUMMA14OUT());
		aux.setCumma15Out(item.getCUMMA15OUT());
		aux.setCumma24Out(item.getCUMMA2C4OUT());
		aux.setCumma25Out(item.getCUMMA2N4OUT());
		aux.setCumma34Out(item.getCUMMA34OUT());
		aux.setCumma44Out(item.getCUMMA4P4OUT());
		aux.setCumma45Out(item.getCUMMA4D4OUT());
		aux.setCumma46Out(item.getCUMMA4B4OUT());
		aux.setCumzpc4Out(item.getCUMZPC4OUT());
		aux.setLidfev4Out(item.getLIDFEV4OUT());
		aux.setLidnot4Out(item.getLIDNOT4OUT());
		aux.setLidtt14Out(item.getLIDTT14OUT());
		aux.setLidtt24Out(item.getLIDTT24OUT());
		aux.setCumste4Out(item.getCUMPOD14OUT());
		aux.setLidema4out(item.getLIDEMA4OUT());
		//nuevo mapeo cs0135
		aux.setCummld4Out((item.getCUMMLD4OUT())); //pais
		aux.setCumpod14Out((item.getCUMPOD14OUT())); //provincia
		aux.setCumpod24Out((item.getCUMPOD24OUT())); //canton
		aux.setCumpod34Out((item.getCUMPOD34OUT())); //parroquia
		aux.setCumma2c4Out((item.getCUMMA2C4OUT())); //calle principal
		aux.setCumma2n4Out((item.getCUMMA2N4OUT()));//numero calle principal
		aux.setCumma4b4Out((item.getCUMMA4B4OUT())); //barrio
		aux.setCumma4p4Out((item.getCUMMA4P4OUT())); //piso
		aux.setCumma4d4Out((item.getCUMMA4D4OUT())); //departamento
		aux.setClaref4Out((item.getCLAREF4OUT())); //referencia
	}
	
	public static LSTCLIUPD mapearDatosAlObjetoDeEnvioCorreo(LSTCLIUPD lstcliupd, BigDecimal codigoIbs, 
			String estadoEnvioCorreo, String mensajeEnvioCorreo, String correosRepresentantesLegales){
		lstcliupd.setNUMIBSUPD(codigoIbs);
		lstcliupd.setESTVINUPD(estadoEnvioCorreo);
		lstcliupd.setMEMVINUPD(mensajeEnvioCorreo);
		lstcliupd.setMILVINUPD(correosRepresentantesLegales);
			
		return lstcliupd;
	}
	
	/**
	 * Clase que mapeara los datos que se necesitaran para enviar el correo donde se hacen las siguiente validaciones:
	 * 1.- Se valida que si existe codigo de error el estado sera vacion caso contrario se valida que el estado
	 * sea diferente de nulo y vacio para asignar el valor respectivo.
	 * 2.- Se valida que el nombre de agencia sea diferente de nulo y vacio para asignar el valor respectivo.
	 * 3.- Se valida que el nombre de asesor sea diferente de nulo y vacio para asignar el valor respectivo.
	 * 4.- Se valida que el numero de telefono sea diferente de 0 para asignar el valor respectivo.
	 * 
	 * @param estadoEnvioCorreo
	 * @param datosAsesor
	 * @param codigoError
	 * @return
	 */
	public static DatosEnvioCorreo mapearDatosALaInformacionEnvioCorreo(String estadoEnvioCorreo, LSTFUNCIO datosAsesor, 
			BigDecimal codigoError){
		DatosEnvioCorreo datosEnvioCorreo = new DatosEnvioCorreo();
		
		if(codigoError.compareTo(BigDecimal.ZERO) == 0){
			datosEnvioCorreo.setEstadoCorreo((estadoEnvioCorreo != null && !estadoEnvioCorreo.equals("")) ? estadoEnvioCorreo : "");
		} else {
			datosEnvioCorreo.setEstadoCorreo("");
		}
		
		datosEnvioCorreo.setNombreAgencia((datosAsesor.getAGENCIFUN() != null && !datosAsesor.getAGENCIFUN().equals("")) ? 
				datosAsesor.getAGENCIFUN() : "");
		datosEnvioCorreo.setNombreAsesor((datosAsesor.getNOMBREFUN() != null && !datosAsesor.getNOMBREFUN().equals("")) ?
				datosAsesor.getNOMBREFUN() : "");
		datosEnvioCorreo.setNumeroTelefonoAsesor((datosAsesor.getTELEFOFUN() != null && 
				datosAsesor.getTELEFOFUN().compareTo(BigDecimal.ZERO) != 0) ? 
				datosAsesor.getTELEFOFUN() : BigDecimal.ZERO);
		
		return datosEnvioCorreo;
	}
}