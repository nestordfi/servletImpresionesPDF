package ec.com.bancoInternacional.ConsultaBastanteo.modelo;


public class DocumentoExaminadoImpresion {

	private String conceptoDoc;
	private String notaria;
	private String fechaDoc;
	private String fechaInscripcionDoc;
	private String tipoDoc;
	private String indexDoc;
	public String getConceptoDoc() {
		return conceptoDoc;
	}
	public void setConceptoDoc(String conceptoDoc) {
		this.conceptoDoc = conceptoDoc;
	}
	public String getNotaria() {
		return notaria;
	}
	public void setNotaria(String notaria) {
		this.notaria = notaria;
	}
	public String getFechaDoc() {
		return fechaDoc;
	}
	public void setFechaDoc(String fechaDoc) {
		this.fechaDoc = fechaDoc;
	}
	public String getFechaInscripcionDoc() {
		return fechaInscripcionDoc;
	}
	public void setFechaInscripcionDoc(String fechaInscripcionDoc) {
		this.fechaInscripcionDoc = fechaInscripcionDoc;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getIndexDoc() {
		return indexDoc;
	}
	public void setIndexDoc(String indexDoc) {
		this.indexDoc = indexDoc;
	}
	
	@Override
	public String toString() {
		return "DocumentoExaminadoImpresion [conceptoDoc=" + conceptoDoc + ", notaria=" + notaria + ", fechaDoc="
				+ fechaDoc + ", fechaInscripcionDoc=" + fechaInscripcionDoc + ", tipoDoc=" + tipoDoc + ", indexDoc="
				+ indexDoc + "]";
	}
	
}
