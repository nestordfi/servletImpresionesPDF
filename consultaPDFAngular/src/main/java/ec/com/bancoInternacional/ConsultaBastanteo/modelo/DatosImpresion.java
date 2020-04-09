package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class DatosImpresion {

	private List<RepresentanteLegalImpresion> listaRepresentantesLegal = new ArrayList<>();
	private List<AccionistaImpresion> listaAccionista = new ArrayList<>();
	private List<LimitacionImpresion> listaLimitacion = new ArrayList<>();
	private List<DocumentoExaminadoImpresion> listaDocumento = new ArrayList<>();
	private List<ObsevacionImpresion> listaObservaciones= new ArrayList<>();
	
	public List<ObsevacionImpresion> getListaObservaciones() {
		return listaObservaciones;
	}
	public void setListaObservaciones(List<ObsevacionImpresion> listaObservaciones) {
		this.listaObservaciones = listaObservaciones;
	}
	public List<DocumentoExaminadoImpresion> getListaDocumento() {
		return listaDocumento;
	}
	public void setListaDocumento(List<DocumentoExaminadoImpresion> listaDocumento) {
		this.listaDocumento = listaDocumento;
	}
	public List<LimitacionImpresion> getListaLimitacion() {
		return listaLimitacion;
	}
	public void setListaLimitacion(List<LimitacionImpresion> listaLimitacion) {
		this.listaLimitacion = listaLimitacion;
	}
	public List<AccionistaImpresion> getListaAccionista() {
		return listaAccionista;
	}
	public void setListaAccionista(List<AccionistaImpresion> listaAccionista) {
		this.listaAccionista = listaAccionista;
	}
	public List<RepresentanteLegalImpresion> getListaRepresentantesLegal() {
		return listaRepresentantesLegal;
	}
	public void setListaRepresentantesLegal(List<RepresentanteLegalImpresion> listaRepresentantesLegal) {
		this.listaRepresentantesLegal = listaRepresentantesLegal;
	}
	public JRDataSource getRepds()   
    {       
        return new JRBeanCollectionDataSource(listaRepresentantesLegal,false);   
    } 
	public JRDataSource getAccds()   
    {       
        return new JRBeanCollectionDataSource(listaAccionista,false);   
    } 
	public JRDataSource getLimds()   
    {       
        return new JRBeanCollectionDataSource(listaLimitacion,false);   
    } 
	public JRDataSource getDocds()   
	{       
		return new JRBeanCollectionDataSource(listaDocumento,false);   
	} 
	public JRDataSource getObsds()   
	{       
		return new JRBeanCollectionDataSource(listaObservaciones,false);   
	} 
}
