package ec.com.bancoInternacional.server.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.config.Application;
import ec.com.bancoInternacional.services.ibm.pool.PooledTrx;
import ec.com.bancoInternacional.shared.beans.ObjCliente;
import ec.com.bancoInternacional.we0038.ACLIINPDATA;
import ec.com.bancoInternacional.we0038.AYUDCUMST;
import ec.com.bancoInternacional.we0038.CUMSTDATA1;

public class BuscaClienteServiceImpl extends PooledTrx {
	private static final long serialVersionUID = -769914770451011454L;

	private static final Logger logger = Logger.getLogger(BuscaClienteServiceImpl.class);
	private static final int REG_PAG = 500;
	private static int BUSCA_MAX = 50;

	static {
		try {
			BUSCA_MAX = Integer.parseInt(Application.getString("app.busca.max"));
		} catch (Exception e) {
			;
		}
	}

	public void buscaClientePorNombre(String nombreCorto) {
		buscaClientePorNombre(nombreCorto, 0, " ", " ");
	}

	public void buscaClientePorNombreGM(String nombreCorto) {
		buscaClientePorNombre(nombreCorto, 0, " ", "GM");
	}

	public List<ObjCliente> buscaClientePorIbsLocal(long nroIbs) {
		return buscaClientePorNombre(" ", nroIbs, " ", " ");
	}

	private List<ObjCliente> buscaClientePorNombre(String nombreCorto, long nroIbs, String id, String grupoMaster) {
		List<ObjCliente> clientesEncontrados = new ArrayList<ObjCliente>();
		int nBusca = 0;
		/*
		 * //PCH06062012 AS400 as400 = ConnectionAS.getConexion();
		 * 
		 * if(as400 == null){ logger.debug(
		 * "no se pudo obtener la conexion AS400"); }
		 */
		AYUDCUMST ayudcumst = new AYUDCUMST();

		ACLIINPDATA acliInpData = ayudcumst.getACLIDATAINP();

		acliInpData.setCLINOMCORTOI(nombreCorto);
		// 3 indica búsqueda por nombre largo
		acliInpData.setCLIADEATRASI("3");
		acliInpData.setCLICODIGOI(BigDecimal.valueOf(nroIbs));
		acliInpData.setCLIIDENTIFI(id);
		acliInpData.setCLIMGROUP(grupoMaster);
		acliInpData.setCLIFCLIENTE("C");
		// página única, establecido por Yolanda Jácome 2014-05-14
		acliInpData.setCLINUMPAGINA(BigDecimal.valueOf(1));

		// ConnAS.conectaAS400(ayudcumst);//PCH06062012
		try {
			invokeTrx(ayudcumst);
		} catch (Exception e) {
			logger.error(e);
		}

		if (ayudcumst.getReturnValue() == 0) {
			CUMSTDATA1[] encontrados = ayudcumst.getACLIDATAOUT().getDATACUMST();
			List<ObjCliente> aux = getObjClientes(encontrados);

			if (aux.size() > 0) {
				clientesEncontrados.addAll(aux);
				nBusca += aux.size();
			}

			int len = aux.size();

			while (len == REG_PAG && nBusca < BUSCA_MAX) {
				ObjCliente last = (ObjCliente) aux.get(aux.size() - 1);
				aux = new ArrayList<ObjCliente>();

				acliInpData.setCLICODIGOI(BigDecimal.valueOf(Long.valueOf(last.getNroIbs())));
				acliInpData.setCLIIDENTIFI(last.getId());
				acliInpData.setCLINOMSITUAR(last.getNombreCorto());

				// ayudcumst.invoke();//PCH06062012
				try {
					invokeTrx(ayudcumst);
				} catch (Exception e) {
					logger.error(e);
				}

				logger.debug("continua... ".concat(last.getId()));

				if (ayudcumst.getReturnValue() == 0) {
					encontrados = ayudcumst.getACLIDATAOUT().getDATACUMST();
					aux = getObjClientes(encontrados);

					if (aux.size() > 0) {
						clientesEncontrados.addAll(aux);
						nBusca += aux.size();
					} else
						break;
				} else {
					logger.debug(nombreCorto.concat(": ")
							.concat(getStrErrores(ayudcumst.getACLIDESERROR().getERRERRORES())));
					break;
				}
			} // while

		} else
			logger.debug(nombreCorto + ": " + getStrErrores(ayudcumst.getACLIDESERROR().getERRERRORES()));

		// setClientesEncontrados(clientesEncontrados);

		acliInpData = null;
		ayudcumst = null;

		return clientesEncontrados;

	}// buscaClientePorNombre

	private List<ObjCliente> getObjClientes(CUMSTDATA1[] encontrados) {
		List<ObjCliente> lista = new ArrayList<ObjCliente>();

		if (encontrados != null)
			for (CUMSTDATA1 elemento : encontrados) {
				if (elemento != null && elemento.getCLICODIGOO().intValue() != 0) {
					ObjCliente objCliente = new ObjCliente();
					objCliente.setId(elemento.getCLIIDENTIFO());
					objCliente.setNroIbs(elemento.getCLICODIGOO().toString());
					objCliente.setTipo(elemento.getCLITIPCLIEN());
					objCliente.setValue(elemento.getCLINOMLARGOO());
					objCliente.setNombreCorto(elemento.getCLINOMBRECORTO());

					lista.add(objCliente);
				} else
					break;
			}

		return lista;
	}// getObjClientes

	private String getStrErrores(String[] verrores) {
		String errores = "";
		for (String msg : verrores)
			if (msg != null && msg.trim().length() > 0)
				errores = errores.concat(msg);
			else
				break;
		return errores;
	}// getStrErrores

}// fin de la clase