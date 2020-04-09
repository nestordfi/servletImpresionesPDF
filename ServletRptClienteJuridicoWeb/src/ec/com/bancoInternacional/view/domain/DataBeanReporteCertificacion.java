package ec.com.bancoInternacional.view.domain;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class DataBeanReporteCertificacion {
	private List<RepresentanteLegalFirma> representantes = new ArrayList<>();
	private List<ResidenciaFiscal> residencias = new ArrayList<>();
	public List<RepresentanteLegalFirma> getRepresentantes() {
		return representantes;
	}
	public void setRepresentantes(List<RepresentanteLegalFirma> representantes) {
		this.representantes = representantes;
	}
	public List<ResidenciaFiscal> getResidencias() {
		return residencias;
	}
	public void setResidencias(List<ResidenciaFiscal> residencias) {
		this.residencias = residencias;
	}
	
	public JRDataSource getDsresidencias()   
	{       
		return new JRBeanCollectionDataSource(residencias,false);   
	}
	
	public JRDataSource getDsrepresentantes()   
	{       
		return new JRBeanCollectionDataSource(representantes,false);   
	}
}
