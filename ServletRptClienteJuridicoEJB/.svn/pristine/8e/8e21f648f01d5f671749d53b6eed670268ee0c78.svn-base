package ec.com.bancoInternacional.server;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.config.Application;
import ec.com.bancoInternacional.cs0012.CONCLIADIC;
import ec.com.bancoInternacional.cs0012.CONCLIDECL;
import ec.com.bancoInternacional.cs0012.CONCLIENTE;
import ec.com.bancoInternacional.cs0012.CONCLIPRIN;
import ec.com.bancoInternacional.cs0012.CONVALUSUARIO;
import ec.com.bancoInternacional.cs0012.VALCPBCUM;
import ec.com.bancoInternacional.cs0012.VALSPBCUR;
import ec.com.bancoInternacional.cs0012.__INP_RCOCCL;
import ec.com.bancoInternacional.cs0012.__INP_RCUINF;
import ec.com.bancoInternacional.cs0012.__INP_RCUMAD;
import ec.com.bancoInternacional.cs0012.__INP_RCUMADC;
import ec.com.bancoInternacional.cs0012.__INP_RCUMST;
import ec.com.bancoInternacional.cs0012.__INP_RDIMST;
import ec.com.bancoInternacional.cs0012.__INP_RLIDTL;
import ec.com.bancoInternacional.cs0012.__INP_RLIMST;
import ec.com.bancoInternacional.cs0012.__INP_RLITXT;
import ec.com.bancoInternacional.cs0012.__INP_RRIESGO;
import ec.com.bancoInternacional.cs0012.__INP_RSPINS;
import ec.com.bancoInternacional.cs0014.GETLIDAD;
import ec.com.bancoInternacional.cs0014.LIDEDSDATA;
import ec.com.bancoInternacional.server.util.BuscaClienteServiceImpl;
import ec.com.bancoInternacional.server.util.Util;
import ec.com.bancoInternacional.services.ibm.pool.PooledTrx;
import ec.com.bancoInternacional.shared.beans.ObjCliente;
import ec.com.bancoInternacional.we0038.CATAYUNCG;

@Stateless
public class ClientesServiceImpl extends PooledTrx {
	private static Logger logger = Logger.getLogger(ClientesServiceImpl.class);

	private String[] errordesc;
	private String usuario = "";
	private String descErrorListas = "";
	private String descErrorListasSancionadas = "";

	private static final int N_ACCIONISTAS = 6;
	private static int PORCENTAJE_OBS_AC = 0;

	static {
		try {
			// porcentaje sobre el cual se piden datos del beneficiario del
			// accionista
			PORCENTAJE_OBS_AC = Integer.parseInt(Application.getString("app.por.ben"));
		} catch (Exception e) {
			;
		}
	}

	// método para consultar un cliente jurídico
	public Map<String, String> consultarClienteJuridico(String id, String tipo, String user) throws IllegalArgumentException {
		Map<String, String> items = new HashMap<String, String>();
		String anio = "";
		String mes = "";
		String dia = "";
		boolean indicador;
		setUsuario(user);
		indicador = true;

		// Primero se valida la clave del IBS
		if (indicador) {
			if (!validarListas(id, tipo).equals("0")) {
				// código de error para validación de listas negras
				items.put("ERRCODLN", "-1");
				// descripción del error para validación de listas negras
				items.put("ERRDSCLN", getDescErrorListas());
			}
			if (!validarListasSancionadas(id, tipo).equals("0")) {
				// código de error para validación de listas sancionadas
				items.put("ERRCODLS", "-1");
				// descripción del error para validación de listas sancionadas
				items.put("ERRDSCLS", getDescErrorListasSancionadas());
			}

			int contReg = 0;
			CONCLIENTE concliente = new CONCLIENTE();
			CONCLIADIC concliadic = new CONCLIADIC();
			CONCLIDECL conclidecl = new CONCLIDECL();
			CONCLIPRIN concliprin = new CONCLIPRIN();
			GETLIDAD getlidad = new GETLIDAD();

			concliente.getCONCDATAINP().setCLINUMIDENTIF(id);
			// concliente.setCONTIPCLIENTE(tipo);
			concliente.getCONCDATAINP().setCO1TIPCLIENTE(tipo);
			concliadic.getCLADATAINP().setCONIDENTIFICA(id);
			conclidecl.getCLDDATAINP().setCONIDENTIFICA(id);
			concliprin.getCLPDATAINP().setCONIDENTIFICA(id);
			concliente.getCONCDATAINP().setCLICTACLIENTE(" ");
			getlidad.setIDINP(id);

			try {
				invokeTrx(concliente);
			} catch (Exception e) {
				logger.error(e);
			}

			try {
				invokeTrx(concliprin);
			} catch (Exception e) {
				logger.error(e);
			}

			try {
				invokeTrx(concliadic);
			} catch (Exception e) {
				logger.error(e);
			}

			try {
				invokeTrx(conclidecl);
			} catch (Exception e) {
				logger.error(e);
			}

			try {
				invokeTrx(getlidad);
			} catch (Exception e) {
				logger.error(e);
			}

			int retVal = concliente.getReturnValue();
			Exception expcb = concliente.retrieveProgramCallException();

			if (null != expcb) {
				logger.error("id:" + id + "; exception AS/400:" + expcb);
			}

			logger.debug("Respuesta consulta PJ: " + retVal);
			// elemento que representa el código de error para consulta de
			// personas jurídicas
			items.put("ERRCOD", String.valueOf(retVal));

			if (retVal != 0) {

				items.put("ERRCOD", "-1");
				items.put("ERRDSC", String.valueOf(retVal) + concliente.getCLIDESERROR());
			} else {
				// MG20110328
				// para clientes nuevos
				items.put("RUC", id);
				items.put("TIPO", tipo);

				__INP_RCUMST cumst = concliente.getCLICDATAOUT().getCUMSTDATAOU();

				items.put("CUSIDN", cumst.getCUSIDN());
				items.put("CUSNA1", cumst.getCUSNA1());

				items.put("CUSCUN", cumst.getCUSCUN().toString());

				__INP_RCOCCL coccl = concliadic.getCLACOCCLOUT();

				items.put("COCMOT", coccl.getCOCMOT());
				items.put("COCMAC", coccl.getCOCMAC());

				__INP_RRIESGO riesgo = concliente.getRIESGODATAOU();

				items.put("RIESGO", riesgo.getRIECAL());

				items.put("CUSNA1", cumst.getCUSNA1()); // Razón social
				items.put("CUSFNA", cumst.getCUSFNA());
				items.put("CUSCCS", cumst.getCUSCCS());
				items.put("CUSCOB", cumst.getCUSCOB());// pais origen

				// MG20110131
				items.put("CUSCCL", cumst.getCUSCCL());
				items.put("CUSGEC", cumst.getCUSGEC());
				items.put("CUSINL", cumst.getCUSINL());
				items.put("CUSLGT", cumst.getCUSLGT());
				items.put("CUSSTS", cumst.getCUSSTS());
				items.put("CUSILV", cumst.getCUSILV().toString());

				// MG20110208
				items.put("CUSRLV", cumst.getCUSRLV());
				items.put("CUSLIF", cumst.getCUSLIF());
				items.put("CUSATM", cumst.getCUSATM());
				items.put("CUSTAX", cumst.getCUSTAX());
				items.put("CUSIDM", cumst.getCUSIDM().toString());
				items.put("CUSIDD", cumst.getCUSIDD().toString());
				items.put("CUSIDY", cumst.getCUSIDY().toString());
				items.put("CUSLDM", cumst.getCUSLDM().toString());
				items.put("CUSLDD", cumst.getCUSLDD().toString());
				items.put("CUSLDY", cumst.getCUSLDY().toString());
				items.put("CUSMAM", cumst.getCUSMAM().toString());
				items.put("CUSMAD", cumst.getCUSMAD().toString());
				items.put("CUSMAY", cumst.getCUSMAY().toString());
				items.put("CUSRBY", cumst.getCUSRBY());
				items.put("CUSPHN", cumst.getCUSPHN().toString());
				items.put("CUSPH1", cumst.getCUSPH1().toString());
				items.put("CUSIDF", cumst.getCUSIDF());
				items.put("CUSTID", cumst.getCUSTID());
				items.put("CUSPID", cumst.getCUSPID());
				items.put("CUSFAX", cumst.getCUSFAX().toString());
				items.put("CUSNST", cumst.getCUSNST().toString());
				items.put("CUSNSH", cumst.getCUSNSH().toString());

				// MG20120302
				// para fines de impresión en perfiles se envía el usuario
				// creador
				// con el cual también se obtendrá el respectivo gerente
				// items.put("USUCREADOR", getCredencial().getUsuario());

				// ciudad del usuario para impresión de bienvenida
				// items.put("USUARIOCIUDAD",
				// getCredencial().getUsuarioCiudad());

				// MG20110218
				items.put("CUSRBN", isNumeric(cumst.getCUSRBN()));

				// fecha constitución
				String CUSBDYMD = Util.dateWebT(cumst.getCUSBDY(), cumst.getCUSBDM(), cumst.getCUSBDD());

				items.put("CUSBDYMD", CUSBDYMD);

				__INP_RCUINF cuinf = concliente.getCLICDATAOUT().getCUINFDATAOU();

				// Direcciones de correo
				items.put("CUIMAI", cuinf.getCUIMAI());

				// usuario creador
				items.put("CUIUSR", cuinf.getCUIUSR());

				items.put("CUSNA2", cumst.getCUSNA2());
				items.put("CUSNA3", cumst.getCUSNA3());
				items.put("CUSNA4", cumst.getCUSNA4());
				items.put("CUSSTE", cumst.getCUSSTE());
				items.put("CUSCTY", cumst.getCUSCTY());
				items.put("CUSCTR", cumst.getCUSCTR());
				items.put("CUSHPN", cumst.getCUSHPN().toString());

				int cont = 1;

				// MG20110408
				for (int m = 0; m < 10; m++) {
					items.put("CUMMA1D".concat(String.valueOf(m)), "");
					items.put("CUMMAND".concat(String.valueOf(m)), "");
					items.put("CUMMA2D".concat(String.valueOf(m)), "");
					items.put("CUMMA3D".concat(String.valueOf(m)), "");
					items.put("CUMMA4D".concat(String.valueOf(m)), "");
					items.put("CUMSTED".concat(String.valueOf(m)), "");
					items.put("CUMCTYD".concat(String.valueOf(m)), "");
					items.put("CUMCTRD".concat(String.valueOf(m)), "");
					items.put("CUMHPND".concat(String.valueOf(m)), "");
					items.put("CUMZPCD".concat(String.valueOf(m)), "");
					items.put("CUMTIDD".concat(String.valueOf(m)), "");
				}

				__INP_RCUMAD[] cumad = concliente.getCLICDATAOUT().getCUMADDATAOU().getCUMADDETALLE();

				int lenCumad = cumad.length;
				__INP_RCUMAD aCumad = null;
				String aCUMRTP = null;
				String aCUMMAN = null;

				for (int i = 0; (cumad[i].getCUMCUN().longValue() > 0 && i < lenCumad); i++) {
					aCumad = cumad[i];
					aCUMRTP = aCumad.getCUMRTP();
					aCUMMAN = aCumad.getCUMMAN();

					// Direcciones
					if ("1".equals(aCUMRTP) && aCUMMAN.matches("\\d")) {
						items.put("CUMMA1D".concat(String.valueOf(cont)), aCumad.getCUMMA1());
						items.put("CUMMA2D".concat(String.valueOf(cont)), aCumad.getCUMMA2());
						items.put("CUMMA3D".concat(String.valueOf(cont)), aCumad.getCUMMA3());
						items.put("CUMMA4D".concat(String.valueOf(cont)), aCumad.getCUMMA4());
						items.put("CUMSTED".concat(String.valueOf(cont)), aCumad.getCUMSTE());
						items.put("CUMCTYD".concat(String.valueOf(cont)), aCumad.getCUMCTY());
						items.put("CUMCTRD".concat(String.valueOf(cont)), aCumad.getCUMCTR());
						items.put("CUMHPND".concat(String.valueOf(cont)), aCumad.getCUMHPN().toString());
						items.put("CUMZPCD".concat(String.valueOf(cont)), aCumad.getCUMZPC()); // celular

						cont++;
						contReg++;
					}

					// M652
					// Dirección extranjero residencia y teléfono
					if ("1".equals(aCUMRTP) && "A".equals(aCUMMAN)) {
						items.put("DirExtRes", aCumad.getCUMMA2().trim().concat(aCumad.getCUMMA3().trim()));
						long deTel = aCumad.getCUMHPN().longValue();
						if (deTel > 0) {
							items.put("DirExtTel", String.valueOf(deTel));
						} else {
							items.put("DirExtTel", "");
						}
					}
					// Dirección extranjero correspondencia
					if ("1".equals(aCUMRTP) && "B".equals(aCUMMAN)) {
						items.put("DirExtCor", aCumad.getCUMMA2().trim().concat(aCumad.getCUMMA3().trim()));
					}
					// M652
				}

				items.put("REGS", String.valueOf(contReg));

				items.put("NumDirJ", String.valueOf(lenCumad));

				for (int i = 0; (cumad[i].getCUMCUN().intValue() > 0 && i < lenCumad); i++) {
					aCumad = cumad[i];
					aCUMRTP = aCumad.getCUMRTP();
					aCUMMAN = aCumad.getCUMMAN();

					if ("1".equals(aCUMRTP) && "7".equals(aCUMMAN)) {
						items.put("CUMMA2D7", aCumad.getCUMMA2());
					}
				}

				// Representantes legales
				// MG20121030
				String strCUMZPC = "";
				for (int i = 0; (cumad[i].getCUMCUN().intValue() > 0 && i < lenCumad); i++) {
					aCumad = cumad[i];
					aCUMRTP = aCumad.getCUMRTP();
					aCUMMAN = aCumad.getCUMMAN();

					if ("2".equals(aCUMRTP) && "1".equals(aCUMMAN)) {
						items.put("CUMCTRRL1", aCumad.getCUMCTR()); // pais de
																	// nacimiento
						items.put("CUMSTERL1", aCumad.getCUMSTE());
						items.put("CUMCTYRL1", aCumad.getCUMCTY());// ciudad de
																	// nacimiento
						strCUMZPC = Util.dateWebT(aCumad.getCUMZPC());
						items.put("CUMZPCRL1", strCUMZPC);// fecha nacimiento
						items.put("CUMMA2RL1", aCumad.getCUMMA2());// calle
																	// principal
																	// y número
						items.put("CUMMA3RL1", aCumad.getCUMMA3());// calle
																	// secundaria
						items.put("CUMMA4RL1", aCumad.getCUMMA4());// barrio,
																	// piso,
																	// departamento
						items.put("CUMBMSRL1", aCumad.getCUMBMS());// estado
																	// civil
					}
					// si tiene cónyuge
					if ("9".equals(aCUMRTP) && "1".equals(aCUMMAN)) {
						items.put("CUMMA1RLC1", aCumad.getCUMMA1());// apellidos
																	// y nombres
						items.put("CUMBNIRLC1", aCumad.getCUMBNI());// identificación
						strCUMZPC = Util.dateWebT(aCumad.getCUMZPC());
						items.put("CUMZPCRLC1", strCUMZPC);// fecha nacimiento
					}

					if ("2".equals(aCUMRTP) && "2".equals(aCUMMAN)) {
						items.put("CUMCTRRL2", aCumad.getCUMCTR()); // pais de
																	// nacimiento
						items.put("CUMSTERL2", aCumad.getCUMSTE());
						items.put("CUMCTYRL2", aCumad.getCUMCTY());// ciudad de
																	// nacimiento
						strCUMZPC = Util.dateWebT(aCumad.getCUMZPC());
						items.put("CUMZPCRL2", strCUMZPC);// fecha nacimiento
						items.put("CUMMA2RL2", aCumad.getCUMMA2());// calle
																	// principal
																	// y número
						items.put("CUMMA3RL2", aCumad.getCUMMA3());// calle
																	// secundaria
						items.put("CUMMA4RL2", aCumad.getCUMMA4());// barrio,
																	// piso,
																	// departamento
						items.put("CUMBMSRL2", aCumad.getCUMBMS());// estado
																	// civil
					}
					// si tiene cónyuge
					if ("9".equals(aCUMRTP) && "2".equals(aCUMMAN)) {
						items.put("CUMMA1RLC2", aCumad.getCUMMA1());// apellidos
																	// y nombres
						items.put("CUMBNIRLC2", aCumad.getCUMBNI());// identificación
						strCUMZPC = Util.dateWebT(aCumad.getCUMZPC());
						items.put("CUMZPCRLC2", strCUMZPC);// fecha nacimiento
					}

					if ("2".equals(aCUMRTP) && "3".equals(aCUMMAN)) {
						items.put("CUMCTRRL3", aCumad.getCUMCTR()); // pais de
																	// nacimiento
																	// - salome
																	// flores
						items.put("CUMSTERL3", aCumad.getCUMSTE());
						items.put("CUMCTYRL3", aCumad.getCUMCTY());// ciudad de
																	// nacimiento
						strCUMZPC = Util.dateWebT(aCumad.getCUMZPC());
						items.put("CUMZPCRL3", strCUMZPC);// fecha nacimiento
						items.put("CUMMA2RL3", aCumad.getCUMMA2());// calle
																	// principal
																	// y número
						items.put("CUMMA3RL3", aCumad.getCUMMA3());// calle
																	// secundaria
						items.put("CUMMA4RL3", aCumad.getCUMMA4());// barrio,
																	// piso,
																	// departamento
						items.put("CUMBMSRL3", aCumad.getCUMBMS());// estado
																	// civil
					}
					// si tiene cónyuge
					if ("9".equals(aCUMRTP) && "3".equals(aCUMMAN)) {
						items.put("CUMMA1RLC3", aCumad.getCUMMA1());// apellidos
																	// y nombres
						items.put("CUMBNIRLC3", aCumad.getCUMBNI());// identificación
						strCUMZPC = Util.dateWebT(aCumad.getCUMZPC());
						items.put("CUMZPCRLC3", strCUMZPC);// fecha nacimiento
					}

					if ("2".equals(aCUMRTP) && "4".equals(aCUMMAN)) {
						items.put("CUMCTRRL4", aCumad.getCUMCTR()); // pais de
																	// nacimiento
																	// - salome
																	// flores
						items.put("CUMSTERL4", aCumad.getCUMSTE());
						items.put("CUMCTYRL4", aCumad.getCUMCTY());// ciudad de
																	// nacimiento
						strCUMZPC = Util.dateWebT(aCumad.getCUMZPC());
						items.put("CUMZPCRL4", strCUMZPC);// fecha nacimiento
						items.put("CUMMA2RL4", aCumad.getCUMMA2());// calle
																	// principal
																	// y número
						items.put("CUMMA3RL4", aCumad.getCUMMA3());// calle
																	// secundaria
						items.put("CUMMA4RL4", aCumad.getCUMMA4());// barrio,
																	// piso,
																	// departamento
						items.put("CUMBMSRL4", aCumad.getCUMBMS());// estado
																	// civil
					}
					// si tiene cónyuge
					if ("9".equals(aCUMRTP) && "4".equals(aCUMMAN)) {
						items.put("CUMMA1RLC4", aCumad.getCUMMA1());// apellidos
																	// y nombres
						items.put("CUMBNIRLC4", aCumad.getCUMBNI());// identificación
						strCUMZPC = Util.dateWebT(aCumad.getCUMZPC());
						items.put("CUMZPCRLC4", strCUMZPC);// fecha nacimiento
					}
				}

				// Información adicional
				items.put("CUSRSL", cumst.getCUSRSL());
				items.put("CUSTYP", cumst.getCUSTYP());
				items.put("CUSGRP", cumst.getCUSGRP().toString());

				String unNombre = "";
				BuscaClienteServiceImpl buscaCli = new BuscaClienteServiceImpl();

				List<ObjCliente> res = buscaCli.buscaClientePorIbsLocal(cumst.getCUSGRP().longValue());

				if (res.size() > 0) {
					unNombre = res.get(0).getNombreCorto();
					items.put("CUSGRPDESC", unNombre);
				} else
					items.put("CUSGRPDESC", "");

				if (cumst.getCUSRBN().length() == 0) {
					items.put("CUSRBNDESC", "");
				} else {
					List<ObjCliente> res1 = buscaCli
							.buscaClientePorIbsLocal(Long.parseLong(isNumeric(cumst.getCUSRBN())));
					if (res1.size() > 0) {
						unNombre = res1.get(0).getNombreCorto();
						items.put("CUSRBNDESC", unNombre);
					} else
						items.put("CUSRBNDESC", "");
				}

				items.put("CUSSTF", cumst.getCUSSTF());
				// Empresa cliente relacionado
				items.put("CUSOFC", cumst.getCUSOFC());
				items.put("CUSOF2", cumst.getCUSOF2());
				items.put("CUSUC3", cumst.getCUSUC3());
				items.put("CUSUC5", cumst.getCUSUC5());
				items.put("CUICOG", cuinf.getCUICOG());
				items.put("CUIEST", cuinf.getCUIEST());
				items.put("CUIFAC", cuinf.getCUIFAC());

				__INP_RCUMADC[] cumadc = concliprin.getCLPCUMADCOUT().getCUMADCDETALLE();
				int lCumadc = cumadc.length;
				__INP_RCUMADC aCumadc = null;

				// Referencias
				items.put("contre", String.valueOf(0));
				items.put("NumInfo", String.valueOf(lCumadc));
				for (int i = 0; i < lCumadc; i++) {
					aCumadc = cumadc[i];
					// PCH 29072015
					if (aCumadc.getCUDREG().toString().equals("TCT")) {
						items.put("CUDLUGTC", aCumadc.getCUDLUG());
						items.put("CUDACTTC", aCumadc.getCUDACT());
						continue;
					}
					// PCH 29072015
					items.put("CUDREGP".concat(String.valueOf(i)), aCumadc.getCUDREG());
					items.put("CUDLUGP".concat(String.valueOf(i)), aCumadc.getCUDLUG());
					items.put("CUDCUEP".concat(String.valueOf(i)), aCumadc.getCUDCUE());
					items.put("CUDTE1P".concat(String.valueOf(i)), aCumadc.getCUDTE1().toString());
					items.put("CUDCARP".concat(String.valueOf(i)), aCumadc.getCUDCAR());
					items.put("CUDTE2P".concat(String.valueOf(i)), aCumadc.getCUDTE2().toString());
					items.put("CUDTRYP".concat(String.valueOf(i)), aCumadc.getCUDTRY().toString());

					if (aCumadc.getCUDREG().length() != 0) {
						items.put("contre", String.valueOf(i));
					} else {
						break;
					}
				}

				// PCH 03072015
				if (items.get("CUDACTTC") == null) {
					String dTct = "REJ";
					items.put("CUDACTTC", dTct);
					// items.put("CUDLUGTC", "RESTO DE CLIENTES");
					items.put("CUDLUGTC", Util.retornarValor("tipoContribuyente", dTct));
				}
				// PCH 03072015

				items.put("CUSUC1", cumst.getCUSUC1()); // Sectorización
				items.put("CUSUC2", cumst.getCUSUC2()); // Subsectorización

				Map<String, Map<String, String>> desc = consultarDesc("SECT", cumst.getCUSUC1().trim());
				Map<String, String> desco = (Map<String, String>) desc.get("VALORESOI");
				String desCUSUC2 = desco.get(cumst.getCUSUC2());
				if (null == desCUSUC2)
					items.put("CUSUC2DESC", "");
				else
					items.put("CUSUC2DESC", desCUSUC2);

				String strCUSUC4 = cumst.getCUSUC4();
				items.put("CUSUC4", strCUSUC4);

				if (null != strCUSUC4)
					strCUSUC4 = Util.retornarValor("tipoEntidad", strCUSUC4);
				if (null == strCUSUC4)
					strCUSUC4 = "";

				items.put("CUSUC4Des", strCUSUC4);

				items.put("CUSINC", cumst.getCUSINC());
				items.put("CUSBUC", cumst.getCUSBUC());

				Map<String, Map<String, String>> desc1 = consultarDesc("TACT", cumst.getCUSINC());
				Map<String, String> desc1o = (Map<String, String>) desc1.get("VALORESOI");

				String desCUSBUC = desc1o.get(cumst.getCUSBUC());

				if (null == desCUSBUC)
					items.put("CUSBUCDESC", "");
				else
					items.put("CUSBUCDESC", desCUSBUC);

				items.put("CUSCAI", cumst.getCUSCAI().toString());
				items.put("CUSCAS", cumst.getCUSCAS().toString());
				items.put("CUSNSH", cumst.getCUSNSH().toString());
				items.put("CUITFC", cuinf.getCUITFC().toString());
				items.put("CUIDI3", cuinf.getCUIDI3().toString());
				items.put("CUIDI4", cuinf.getCUIDI4().toString());
				items.put("CUIBCY", cuinf.getCUIBCY().toString());

				// campo para pasar
				items.put("CUIDI2", cuinf.getCUIDI2());

				// Representates Legales
				cont = 0;
				items.put("contrl", String.valueOf(0));

				String LIDIEYMD = null;// Fecha Nombramiento RL
				String LIDFEYMD = null;// Fecha Vencimiento Nombramiento RL
				String LIDFEDYMD = null;// Fecha Documento

				__INP_RLIDTL[] lidtl = conclidecl.getCLDLIDTLOUT().getLIDTLDETALLE();
				__INP_RLIDTL aLidtl = null;
				String aLIDTIP = null;

				int lenLidtl = lidtl.length;
				for (int i = 0; (i < lenLidtl && lidtl[i].getLIDCUN().intValue() > 0); i++) {// LIDTL
					aLidtl = lidtl[i];
					aLIDTIP = aLidtl.getLIDTIP();

					if ("1".equals(aLIDTIP)) {
						items.put("LIDTIPR".concat(String.valueOf(i)), aLIDTIP);
						items.put("LIDIDRR".concat(String.valueOf(i)), aLidtl.getLIDIDR());// LIDIDR
																							// Id.
																							// representante
																							// legal
						items.put("LIDNMER".concat(String.valueOf(i)), aLidtl.getLIDNME());
						items.put("LIDNOTR".concat(String.valueOf(i)), aLidtl.getLIDNOT());

						LIDIEYMD = Util.dateWebT(aLidtl.getLIDIEY(), aLidtl.getLIDIEM(), aLidtl.getLIDIED());

						LIDFEYMD = Util.dateWebT(aLidtl.getLIDFEY(), aLidtl.getLIDFEM(), aLidtl.getLIDFED());

						if (null == LIDIEYMD)
							LIDIEYMD = "0";

						if (null == LIDFEYMD)
							LIDFEYMD = "0";

						// si fecha de nombramiento mayor que vencimiento, la
						// reemplaza
						if (Long.parseLong(LIDIEYMD) > Long.parseLong(LIDFEYMD))
							LIDFEYMD = LIDIEYMD;

						// solo se usa la fecha de vencimiento de nombramiento
						items.put("LIDFEYMDR".concat(String.valueOf(i)), LIDFEYMD);

						items.put("LIDTTRR".concat(String.valueOf(i)), aLidtl.getLIDTTR().toString());
						items.put("LIDEMAR".concat(String.valueOf(i)), aLidtl.getLIDEMA());
						items.put("contrl", String.valueOf(i));
						cont++;
					}
				} // LIDTL

				items.put("NumInfoRL", String.valueOf(lenLidtl));

				// Compañias Relacionadas
				cont = 0;
				items.put("contpc", String.valueOf(0));
				items.put("contcr", String.valueOf(0));

				for (int i = 0; (cumad[i].getCUMCUN().intValue() > 0 && i < lenCumad); i++) {
					aCumad = cumad[i];
					aCUMRTP = aCumad.getCUMRTP();

					if ("7".equals(aCUMRTP)) {
						if (aCumad.getCUMMA1().equals("---"))
							items.put("CUMMA2PM", aCumad.getCUMMA2());
						else {
							items.put("CUMRTPP".concat(String.valueOf(i)), aCUMRTP);
							items.put("CUMBNIP".concat(String.valueOf(i)), aCumad.getCUMBNI());
							items.put("CUMMA1P".concat(String.valueOf(i)), aCumad.getCUMMA1());
							items.put("CUMMA2P".concat(String.valueOf(i)), aCumad.getCUMMA2());
							items.put("CUMINCP".concat(String.valueOf(i)), aCumad.getCUMINC());
							items.put("CUMHPNP".concat(String.valueOf(i)), aCumad.getCUMHPN().toString());
							items.put("CUMMA2P".concat(String.valueOf(i)), aCumad.getCUMMA2());

							items.put("CUMTIDP".concat(String.valueOf(i)), aCumad.getCUMTID());
							items.put("CUMPOBP".concat(String.valueOf(i)), aCumad.getCUMPOB());
							items.put("contpc", String.valueOf(i));
							cont++;
						}
					}
					if ("4".equals(aCUMRTP)) {
						items.put("CUMRTPC".concat(String.valueOf(i)), aCumad.getCUMRTP());
						items.put("CUMBNIC".concat(String.valueOf(i)), aCumad.getCUMBNI());
						items.put("CUMMA1C".concat(String.valueOf(i)), aCumad.getCUMMA1());
						items.put("CUMMA2C".concat(String.valueOf(i)), aCumad.getCUMMA2());
						items.put("CUMINCC".concat(String.valueOf(i)), aCumad.getCUMINC());
						items.put("CUMHPNC".concat(String.valueOf(i)), aCumad.getCUMHPN().toString());
						items.put("contcr", String.valueOf(i));

					}
				}

				items.put("NumInfoCR", String.valueOf(lenCumad));
				items.put("NumInfoCR1", String.valueOf(lenCumad));

				// Documentos presentados
				int contDimst = 0;
				String nDimst = null;
				String desDimst = null;
				String auxYMD = null;
				__INP_RDIMST[] dimst = concliprin.getCLPDIMSTOUT().getDIMSTDETALLE();

				for (__INP_RDIMST aDimst : dimst) {
					desDimst = aDimst.getDCIDES();
					if (0 == desDimst.trim().length())
						break;
					// registro tipo documento
					if ("C".equals(aDimst.getDCIACT().trim())) {
						nDimst = String.valueOf(contDimst);

						items.put("DCIDES".concat(nDimst), desDimst);
						items.put("DCISTA".concat(nDimst), aDimst.getDCISTA());
						items.put("DCIFRE".concat(nDimst), aDimst.getDCIFRE());
						items.put("DCITDO".concat(nDimst), aDimst.getDCITDO());

						auxYMD = Util.dateWebT(aDimst.getDCIEYY(), aDimst.getDCIEMM(), aDimst.getDCIEDD());
						items.put("DCIEYMD".concat(nDimst), auxYMD);

						auxYMD = Util.dateWebT(aDimst.getDCIRYY(), aDimst.getDCIRMM(), aDimst.getDCIRDD());
						items.put("DCIRYMD".concat(nDimst), auxYMD);

						auxYMD = Util.dateWebT(aDimst.getDCILRY(), aDimst.getDCILRM(), aDimst.getDCILRD());
						items.put("DCILRYMD".concat(nDimst), auxYMD);

						items.put("DCICOM".concat(nDimst), aDimst.getDCICOM());
						// tabla de acuerdo al tipo de persona
						items.put("DCITNU".concat(nDimst), aDimst.getDCITNU().toString());

						contDimst++;
					}
				}

				items.put("NumDocs", String.valueOf(contDimst));

				concliprin = null;// liberando recursos

				__INP_RLIMST limst = conclidecl.getCLDLIMSTOUT();

				// Bastanteo Legal
				items.put("LIMCEY", limst.getLIMCEY().toString());
				mes = limst.getLIMCEM().toString();
				dia = limst.getLIMCED().toString();
				if (mes.length() == 1)
					mes = "0" + mes;
				if (dia.length() == 1)
					dia = "0" + dia;
				items.put("LIMCEM", mes);
				items.put("LIMCED", dia);
				items.put("LIMDUR", limst.getLIMDUR().toString());
				items.put("LIMMEY", limst.getLIMMEY().toString());
				mes = limst.getLIMMEM().toString();
				dia = limst.getLIMMED().toString();
				if (mes.length() == 1)
					mes = "0" + mes;
				if (dia.length() == 1)
					dia = "0" + dia;
				items.put("LIMMEM", mes);
				items.put("LIMMED", dia);
				items.put("LIMFEY", limst.getLIMFEY().toString());
				mes = limst.getLIMFEM().toString();
				dia = limst.getLIMFED().toString();
				if (mes.length() == 1)
					mes = "0" + mes;
				if (dia.length() == 1)
					dia = "0" + dia;
				items.put("LIMFEM", mes);
				items.put("LIMFED", dia);
				items.put("LIMCSU", limst.getLIMCSU().toString());
				items.put("LIMCPA", limst.getLIMCPA().toString());
				items.put("LIMAUA", limst.getLIMAUA().toString());

				LIDEDSDATA[] lidad = getlidad.getLIDEDSOUT();
				LIDEDSDATA aLidad = null;
				String idAC = null;

				for (int i = 0; (i < lenLidtl && lidtl[i].getLIDCUN().intValue() > 0); i++) {
					String strLIDSEQ = null;
					aLidtl = lidtl[i];
					aLIDTIP = aLidtl.getLIDTIP();

					// Accionistas
					if ("2".equals(aLIDTIP)) {
						strLIDSEQ = aLidtl.getLIDSEQ().toString();
						idAC = aLidtl.getLIDIDR();
						items.put("LIDSEQA".concat(strLIDSEQ), strLIDSEQ);
						items.put("LIDNMEA".concat(strLIDSEQ), aLidtl.getLIDNME());
						items.put("LIDIDRA".concat(strLIDSEQ), idAC);
						items.put("LIDNACA".concat(strLIDSEQ), aLidtl.getLIDNAC().toString());
						items.put("LIDTTRA".concat(strLIDSEQ), aLidtl.getLIDTTR().toString());

						// MG20121101
						items.put("LIDNOTA".concat(strLIDSEQ), aLidtl.getLIDNOT());

						// M652
						aLidad = getInfoAdicionalAC(idAC, lidad);

						if (null != aLidad) {
							// id Principal beneficiario
							items.put("DADIDB".concat(strLIDSEQ), aLidad.getDADIDB());
							// Nombre Principal Beneficiario
							items.put("DADNOM".concat(strLIDSEQ), aLidad.getDADNOM());
							// Direccion extranjero AC
							items.put("DADDIR".concat(strLIDSEQ), aLidad.getDADDIR());
							// Direccion extranjero correspondencia AC
							items.put("DADCOR".concat(strLIDSEQ), aLidad.getDADCOR());
							// teléfono extranjero AC
							items.put("DADTLF".concat(strLIDSEQ), aLidad.getDADTLF().toString());
							// Nacionalidad Accionista
							items.put("DADNAC".concat(strLIDSEQ), aLidad.getDADNAC());
							// Nacionalidad Beneficiario
							items.put("DADNAB".concat(strLIDSEQ), aLidad.getDADNAB());

						}
						// M652
					}

					// Documentos examinados
					if ("3".equals(aLIDTIP)) {
						strLIDSEQ = aLidtl.getLIDSEQ().toString();
						items.put("LIDSEQD".concat(strLIDSEQ), strLIDSEQ);
						items.put("LIDNMED".concat(strLIDSEQ), aLidtl.getLIDNME());

						LIDFEDYMD = Util.dateWebT(aLidtl.getLIDFEY(), aLidtl.getLIDFEM(), aLidtl.getLIDFED());

						items.put("LIDFEDYMD".concat(strLIDSEQ), LIDFEDYMD);

						items.put("LIDNOTD".concat(strLIDSEQ), aLidtl.getLIDNOT());
					}
					strLIDSEQ = null;
				}

				__INP_RSPINS[] spins = concliadic.getCLASPINSOUT().getSPINSDETALLE();
				__INP_RSPINS aSpins = null;
				String aSPITYP = null;

				String aux = "";
				cont = 0;
				for (int i = 0; i < 16; i++) {
					aSpins = spins[i];
					aSPITYP = aSpins.getSPITYP();

					if ("8".equals(aSPITYP)) {
						aux = aux.concat(aSpins.getSPIDSC()).concat("\r");
						items.put("SPIDSC", aux);
						cont++;
					}
				}
				items.put("NumLineas", String.valueOf(cont).toString());

				// Instrucciones especiales
				aux = "";
				cont = 0;
				for (int i = 0; i < 16; i++) {
					aSpins = spins[i];
					aSPITYP = aSpins.getSPITYP();

					if ("8".equals(aSPITYP)) {
						items.put("SPIDSC".concat(String.valueOf(i)), aSpins.getSPIDSC().trim().concat("\r"));
						cont++;
					}
				}
				items.put("NumLineas", String.valueOf(cont).toString());

				// Perfil del Cliente
				anio = cumst.getCUSIDY().toString();
				mes = cumst.getCUSIDM().toString();
				dia = cumst.getCUSIDD().toString();

				if (cumst.getCUSIDY().intValue() > 50) {
					if (anio.length() == 2) {
						anio = "19" + anio;
					} else {
						anio = "190" + anio;
					}
				} else {
					if (anio.length() == 2) {
						anio = "20" + anio;
					} else {
						anio = "200" + anio;
					}
				}

				if (mes.length() == 1)
					mes = "0" + mes;
				if (dia.length() == 1)
					dia = "0" + dia;

				concliente = null;// liberando recursos

				items.put("CUSIDY", anio);
				items.put("CUSIDM", mes);
				items.put("CUSIDD", dia);

				items.put("COCUSU", coccl.getCOCUSU());
				// Principal cliente
				items.put("COCPCN", coccl.getCOCPCN());// nombre principal
														// cliente
				items.put("COCPCI", coccl.getCOCPCI());// cédula principal
														// cliente
				items.put("COCPC2", coccl.getCOCPC2());// dirección principal
														// cliente
				items.put("COCPCM", coccl.getCOCPCM());// mail principal cliente

				// Principal proveedor
				items.put("COCPPN", coccl.getCOCPPN());// nombre principal
														// proveedor
				items.put("COCPPI", coccl.getCOCPPI());// cédula principal
														// proveedor
				items.put("COCPP2", coccl.getCOCPP2());// dirección principal
														// proveedor
				items.put("COCPPM", coccl.getCOCPPM());// mail principal
														// proveedor

				items.put("COCECO", coccl.getCOCECO());
				items.put("COCCLI", coccl.getCOCCLI());
				items.put("COCVMS", coccl.getCOCVMS().toString());
				items.put("COCVRT", coccl.getCOCVRT().toString());
				items.put("COCREX", coccl.getCOCREX());
				items.put("COCRVA", coccl.getCOCRVA().toString());
				items.put("COCRPO", coccl.getCOCRPO());
				items.put("COCEEX", coccl.getCOCEEX());
				items.put("COCEVA", coccl.getCOCEVA().toString());
				items.put("COCEPD", coccl.getCOCEPD());
				items.put("COCCTL", coccl.getCOCCTL());
				items.put("COCNOE", coccl.getCOCNOE());
				items.put("COCPIE", coccl.getCOCPIE());

				String strCOCNOL = coccl.getCOCNOL();
				items.put("COCNOL", strCOCNOL);// código otra institución local

				if (null != strCOCNOL)
					strCOCNOL = Util.retornarValor("institucionFinanciera", strCOCNOL);
				if (null == strCOCNOL)
					strCOCNOL = "";

				items.put("COCNOLDes", strCOCNOL);// nombre otra institución
													// local

				items.put("COCCTE", coccl.getCOCCTE());
				items.put("COCVOL", coccl.getCOCVOL());

				// Propiedades del cliente
				// inmueble/vehículo/ninguna
				items.put("COCIN1", coccl.getCOCIN1());
				items.put("COCIN2", coccl.getCOCIN2());
				items.put("COCIN3", coccl.getCOCIN3());
				items.put("COCTS1", coccl.getCOCTS1());
				items.put("COCTS2", coccl.getCOCTS2());
				items.put("COCTS3", coccl.getCOCTS3());
				items.put("COCUB1", coccl.getCOCUB1());
				items.put("COCUB2", coccl.getCOCUB2());
				items.put("COCUB3", coccl.getCOCUB3());
				items.put("COCHI1", coccl.getCOCHI1());
				items.put("COCHI2", coccl.getCOCHI2());
				items.put("COCHI3", coccl.getCOCHI3());
				items.put("COCAV1", coccl.getCOCAV1());
				items.put("COCAV2", coccl.getCOCAV2());
				items.put("COCAV3", coccl.getCOCAV3());

				items.put("COCVH1", coccl.getCOCVH1());
				items.put("COCVH2", coccl.getCOCVH2());
				items.put("COCVH3", coccl.getCOCVH3());
				items.put("COCTV1", coccl.getCOCTV1());
				items.put("COCTV2", coccl.getCOCTV2());
				items.put("COCTV3", coccl.getCOCTV3());
				items.put("COCPL1", coccl.getCOCPL1());
				items.put("COCPL2", coccl.getCOCPL2());
				items.put("COCPL3", coccl.getCOCPL3());
				items.put("COCAA1", coccl.getCOCAA1().toString());
				items.put("COCAA2", coccl.getCOCAA2().toString());
				items.put("COCAA3", coccl.getCOCAA3().toString());
				items.put("COCPR1", coccl.getCOCPR1());
				items.put("COCPR2", coccl.getCOCPR2());
				items.put("COCPR3", coccl.getCOCPR3());
				items.put("COCAC1", coccl.getCOCAC1().toString());
				items.put("COCAC2", coccl.getCOCAC2().toString());
				items.put("COCAC3", coccl.getCOCAC3().toString());

				concliadic = null;// liberando recursos

				__INP_RLITXT[] litxt = conclidecl.getCLDLITXTOUT().getLITXTDETALLE();
				int lLitxt = conclidecl.getCLDLITXTOUT().getLITXTDETALLE().length;
				__INP_RLITXT aLitxt = null;
				String aLITTIP = null;

				// OBJETO SOCIAL
				aux = "";
				for (int i = 0; i < lLitxt; i++) {
					aLitxt = litxt[i];
					aLITTIP = aLitxt.getLITTIP();

					if ("1".equals(aLITTIP)) {
						aux = aux.concat(aLitxt.getLITTXT());
					}
				}

				if (aux.length() > 0) {
					items.put("LITTXT", aux);
				}

				// RESUMEN DE ESTATUS
				aux = "";
				for (int i = 0; i < lLitxt; i++) {
					aLitxt = litxt[i];
					aLITTIP = aLitxt.getLITTIP();

					if ("2".equals(aLITTIP)) {
						aux = aux.concat(aLitxt.getLITTXT());
					}
				}

				if (aux.length() > 0) {
					items.put("LITTXT1", aux);
				}

				// MEMORANDO LEGAL
				aux = "";
				for (int i = 0; i < lLitxt; i++) {
					aLitxt = litxt[i];
					aLITTIP = aLitxt.getLITTIP();

					if ("4".equals(aLITTIP)) {
						aux = aux.concat(aLitxt.getLITTXT());
					}
				}

				if (aux.length() > 0) {
					items.put("LITTXT2", aux);
				}

				conclidecl = null;// liberando recursos

				// ConnectionAS.desconectar(as400);//PCH06062012

				// libera recursos
				cumst = null;
				coccl = null;
				riesgo = null;
				cuinf = null;
				cumad = null;
				aCumad = null;
				cumadc = null;
				aCumadc = null;
				lidtl = null;
				aLidtl = null;
				dimst = null;
				limst = null;
				spins = null;
				aSpins = null;
				litxt = null;
				aLitxt = null;

			}

		} else {
			items.put("ERRCOD", "-1");
			items.put("ERRDSC", "La clave de IBS no es válida");
		}

		Runtime rt = Runtime.getRuntime();
		logger.debug("CJ ***** total: " + rt.totalMemory() + "; ***** free: " + rt.freeMemory() + ";");
		return items;
	}// consultarClienteJuridico

	public String[] getErrordesc() {
		return errordesc;
	}

	public void setErrordesc(String[] errordesc) {
		this.errordesc = errordesc;
	}

	public Object verificarData(Object data) {
		if (data == null)
			data = " ";
		return data;
	}

	public Object verificarData2(Object data) {
		if ("".equals(data))
			data = 0;
		if (data == null)
			data = 0;

		return data;
	}

	public String completarData(String dato, int len) {
		if (dato == null)
			dato = "         ";
		String blanks = "                                                  ";
		int longitud = 0;
		String data = "";
		longitud = dato.length();
		if (longitud <= len) {
			data = dato + blanks.substring(0, len - longitud);
		} else {
			data = dato.substring(0, len);
		}
		return data;
	}// completarData

	public String completarData2(String dato, int len) {
		if (dato == null)
			dato = "000000000";
		String zeroes = "0000000000000000000000000000";
		int longitud = 0;
		String data = "";
		longitud = dato.length();
		if (longitud <= len) {
			data = dato + zeroes.substring(0, len - longitud);
		} else {
			data = "000000000";
		}
		return data;
	}// completarData2

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Map<String, String> consultarConyuge(String identificacion) throws IllegalArgumentException {
		Map<String, String> items = new HashMap<String, String>();
		CONCLIENTE concliente1 = new CONCLIENTE();

		concliente1.getCONCDATAINP().setCLINUMIDENTIF(completarData2(identificacion, 15));
		concliente1.getCONCDATAINP().setCO1TIPCLIENTE("2");
		concliente1.getCONCDATAINP().setCLICTACLIENTE(" ");

		try {
			invokeTrx(concliente1);
		} catch (Exception e) {
			logger.error(e);
		}

		logger.debug("Respuesta consulta conyuge: " + concliente1.getReturnValue());

		items.put("ERRCOD", String.valueOf(concliente1.getReturnValue()));

		if (concliente1.getReturnValue() != 0) {
			items.put("ERRCOD", "-1");
			items.put("ERRDSC", String.valueOf(concliente1.getReturnValue()) + concliente1.getCLIDESERROR());
		} else {
			// validamos si el conyuge es cliente del Banco
			if (!concliente1.getCLICDATAOUT().getCUMSTDATAOU().getCUSCUN().toString().trim().equals("0")) {
				items.put("ERRCOD", "0");
				items.put("ERRDSC", "El c&oacute;nyuge es cliente del Banco");
				items.put("CUSLN1", concliente1.getCLICDATAOUT().getCUMSTDATAOU().getCUSLN1());
				items.put("CUSLN2", concliente1.getCLICDATAOUT().getCUMSTDATAOU().getCUSLN2());
				items.put("CUSFNA", concliente1.getCLICDATAOUT().getCUMSTDATAOU().getCUSFNA());
				items.put("CUSSTE", concliente1.getCLICDATAOUT().getCUMSTDATAOU().getCUSSTE());
				items.put("CUSCTY", concliente1.getCLICDATAOUT().getCUMSTDATAOU().getCUSCTY());
				items.put("CUSCTR", concliente1.getCLICDATAOUT().getCUMSTDATAOU().getCUSCTR());
				items.put("CUSHPN", concliente1.getCLICDATAOUT().getCUMSTDATAOU().getCUSHPN().toString());
				items.put("CUSCCS", concliente1.getCLICDATAOUT().getCUMSTDATAOU().getCUSCCS());

				String CUSBDYMD = Util.dateWebT(concliente1.getCLICDATAOUT().getCUMSTDATAOU().getCUSBDY(),
						concliente1.getCLICDATAOUT().getCUMSTDATAOU().getCUSBDM(),
						concliente1.getCLICDATAOUT().getCUMSTDATAOU().getCUSBDD());

				items.put("CUSBDYMD", CUSBDYMD);

			} else {
				items.put("ERRCOD", "-1");
				items.put("ERRDSC", "El c&oacute;nyuge no es cliente del Banco");
			}
		}

		concliente1 = null;// liberando recursos

		return items;
	}// consultarConyuge

	public Map<String, Map<String, String>> consultarDesc(String tabla, String cod) {
		Map<String, Map<String, String>> combos = new HashMap<String, Map<String, String>>();
		Map<String, String> valorese = new HashMap<String, String>();
		Map<String, String> valoresei = new HashMap<String, String>();
		CATAYUNCG catayuncg = new CATAYUNCG();

		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(2));
		catayuncg.getCANDATAINP().setNCGTABLA(tabla.trim());
		catayuncg.getCANDATAINP().setNCGCODIGO1(cod.trim());

		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata13 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata13.length - 1; j++) {

				if (ncgoutdata13[j].length() != 0) {
					String[] data = ncgoutdata13[j].split("[|]");
					valorese.put(data[5].trim(), data[1].trim());
					valoresei.put(data[1].trim(), data[5].trim());
				}
			}
		}

		catayuncg = null;// liberando recursos

		combos.put("VALORESO", valorese);
		combos.put("VALORESOI", valoresei);

		return combos;

	}// consultarDesc

	// MG20120615
	public String consultarCodigoCiudad(String tabla, String codProvincia, String descCiudad) {

		CATAYUNCG catayuncg = new CATAYUNCG();

		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(3)); // nivel 3
		catayuncg.getCANDATAINP().setNCGTABLA(tabla.trim());
		catayuncg.getCANDATAINP().setNCGCODIGO1(codProvincia.trim());

		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		String[] ncgoutdata = catayuncg.getCANDATAOUT().getNCGDETALLE();
		for (int j = 0; j <= ncgoutdata.length - 1; j++) {
			if (!ncgoutdata[j].equals("")) {
				String[] data = ncgoutdata[j].split("[|]");
				if (descCiudad.equals(data[5].trim())) {
					catayuncg = null;// liberando recursos
					return data[1];
				}
			}
		}

		catayuncg = null;// liberando recursos

		return "";

	}// consultarCodigoCiudad
		// MG20120615

	// verificar si es tipo numerico
	public String isNumeric(String campo) {
		if (null != campo) {
			campo = campo.trim();
		} else {
			campo = "0";
		}

		try {
			Integer.parseInt(campo);
			return campo;
		} catch (NumberFormatException nfe) {
			return "0";
		}
	}// isNumeric

	public String getDescErrorListas() {
		return descErrorListas;
	}

	public void setDescErrorListas(String descErrorListas) {
		this.descErrorListas = descErrorListas;
	}

	public String getDescErrorListasSancionadas() {
		return descErrorListasSancionadas;
	}

	public void setDescErrorListasSancionadas(String descErrorListasSancionadas) {
		this.descErrorListasSancionadas = descErrorListasSancionadas;
	}

	// MG20120608
	public String rellenarVacios(String valor, int tamano, String caracter, String orientacion) {
		String retorno = null;
		if (null == valor || valor.equals("noAplica")) {
			retorno = "";
		} else {
			retorno = (valor.length() > tamano) ? valor.substring(0, tamano) : valor;
		}
		if (orientacion.equals("R") || orientacion.equals("L")) {
			for (int i = retorno.length(); i < tamano; i++) {
				if (retorno.length() < tamano) {
					if (orientacion.equals("R")) {
						retorno = retorno.concat(caracter);
					} else {
						retorno = caracter.concat(retorno);
					}
				} else {
					break;
				}
			}
		} else {
			throw new IllegalArgumentException("El valor de la orientacion debe ser R(Right) o L(Left).");
		}
		return retorno;
	}// rellenarVacios
		// MG20120608

	// divide la cadena en un arreglo de 2 posiciones para CUMMA2, CUMMA3
	private String[] arreglo2(String texto) {
		String[] arr = new String[2];

		if (texto != null && texto.trim().length() > 35) {
			texto = texto.trim();
			arr[0] = texto.substring(0, 35);
			arr[1] = texto.substring(35);
		} else {
			arr[0] = texto.trim();
			arr[1] = "";
		}

		return arr;
	}// arreglo2

	private LIDEDSDATA getInfoAdicionalAC(String idAC, LIDEDSDATA[] lidad) {
		LIDEDSDATA aLidad = null;
		int lenLidad = lidad.length;
		String aIdAC = null;

		idAC = idAC.trim();

		for (int i = 0; i < lenLidad; i++) {
			aLidad = lidad[i];
			if (null != aLidad) {
				aIdAC = aLidad.getDADIDR();
				if (null != aIdAC)
					aIdAC = aIdAC.trim();
				if (idAC.equals(aIdAC)) {
					break;
				}
			} else {
				break;
			}
		}

		return aLidad;
	}// getInfoAdicionalAC

	// Validar clave de IBS
	public int validarClaveIBS(String user, String pwd) {
		CONVALUSUARIO convalusuario = new CONVALUSUARIO();

		convalusuario.setBTHUSUARIO(user);

		try {
			invokeTrx(convalusuario);
		} catch (Exception e) {
			logger.error(e);
		}

		if (convalusuario.getBTHDATOS().getUSUBTHPSW().equals(pwd)) {
			convalusuario = null;// liberando recursos
			return 0;
		} else {
			convalusuario = null;// liberando recursos
			return -1;
		}
	}// validarClaveIBS

	// Validar listas negras y clientes no gratos
	public String validarListas(String id, String tipo) {
		VALCPBCUM valcpbcum = new VALCPBCUM();
		String desError = "0";

		valcpbcum.setCTAIDENTIFICA(id);

		try {
			invokeTrx(valcpbcum);
		} catch (Exception e) {
			logger.error(e);
		}

		logger.debug("Respuesta consulta Listas Negras: " + valcpbcum.getReturnValue());

		if (valcpbcum.getReturnValue() != 0) {
			setDescErrorListas(valcpbcum.getCLIDESERROR());
			desError = valcpbcum.getCLIDESERROR();
			valcpbcum = null;
			return desError;
		}

		valcpbcum = null;
		return desError;
	}// validarListas

	// Sancionados por la SBS
	public String validarListasSancionadas(String id, String tipo) {
		VALSPBCUR valspbcur = new VALSPBCUR();
		String desError = "0";

		valspbcur.setCTAIDENTIFICA(id);

		try {
			invokeTrx(valspbcur);
		} catch (Exception e) {
			logger.error(e);
		}

		logger.debug("Respuesta consulta Listas Sancionadas: " + valspbcur.getReturnValue());

		if (valspbcur.getReturnValue() != 0) {
			setDescErrorListasSancionadas(valspbcur.getCLIDESERROR());
			desError = valspbcur.getCLIDESERROR();
			valspbcur = null;
			return desError;
		}

		valspbcur = null;
		return desError;
	}// validarListasSancionadas

}// fin de la clase
