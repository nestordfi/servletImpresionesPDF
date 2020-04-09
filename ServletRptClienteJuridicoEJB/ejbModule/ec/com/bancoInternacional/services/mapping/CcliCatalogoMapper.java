package ec.com.bancoInternacional.services.mapping;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ec.com.bancoInternacional.cs0052.NCOEDSDATA;
import ec.com.bancoInternacional.cs0052.PCLIDSINP;
import ec.com.bancoInternacional.services.domain.CcliCatalogo;
import ec.com.bancoInternacional.services.util.ClientActEconimicaParameter;

/**
 * Autor: Sandro Guevara Objetivo: Clase que mapea una estructura AS/400
 * NCOEDSDATA a un objeto CcliCatalog Fecha: 08-05-2018 Nro. Req: 1605 Version:
 * 1.0
 */
public class CcliCatalogoMapper implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<CcliCatalogo> mappingNcoesdataToCcliCatalog(NCOEDSDATA[] data) {
		List<CcliCatalogo> ccliCatalogs = new ArrayList<CcliCatalogo>();
		for (NCOEDSDATA cn : data) {
			if (!"".equals(cn.getNCTABL()) && cn.getNCNIVL().compareTo(new BigDecimal(2)) > 0) {
				CcliCatalogo ccli = new CcliCatalogo();
				ccli.setNccod1(cn.getNCCOD1());
				ccli.setNccod2(cn.getNCCOD2());
				ccli.setNccod3(cn.getNCCOD3());
				ccli.setNccod4(cn.getNCCOD4());
				ccli.setNcdat1(cn.getNCDAT1());
				ccli.setNcdat2(cn.getNCDAT2());
				ccli.setNcdat3(cn.getNCDAT3());
				ccli.setNcdesc(cn.getNCDESC());
				ccli.setNcdisp(cn.getNCDISP());
				ccli.setNcesta(cn.getNCESTA());
				ccli.setNcfecr(cn.getNCFECR());
				ccli.setNcnive(cn.getNCNIVE());
				ccli.setNcnivl(cn.getNCNIVL());
				ccli.setNctabl(cn.getNCTABL());
				ccli.setNctime(cn.getNCTIME());
				ccli.setNcuser(cn.getNCUSER());
				ccli.setNcval1(cn.getNCVAL1());
				ccli.setNcval2(cn.getNCVAL2());
				ccli.setNcval3(cn.getNCVAL3());
				ccliCatalogs.add(ccli);
			}
		}
		return ccliCatalogs;
	}

	/**
	 * Mapea estructura de AS/400 PCLIDSINP a Client para resultados Actividades
	 * Económicas
	 * 
	 * @param ClientActEconimicaParameter
	 * @return PCLIDSINP
	 */
	public PCLIDSINP mapActEcomicaParameterToCliImpData(ClientActEconimicaParameter actEconomicaParameter) {
		PCLIDSINP pclidsinp = new PCLIDSINP();
		pclidsinp.setIPADRESS(actEconomicaParameter.getIpadress());
		pclidsinp.setIPCANAL(actEconomicaParameter.getIpcanal());
		pclidsinp.setIPCODIBS(actEconomicaParameter.getIpcodibs());
		pclidsinp.setIPCODIDN(actEconomicaParameter.getIpcodidn());
		pclidsinp.setIPUSRBIN(actEconomicaParameter.getIpusrbin());

		return pclidsinp;
	}
}
