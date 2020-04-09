package ec.com.bancoInternacional.ConsultaBastanteo.modelo;



import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Autor: Nestor Franco Objetivo: Objeto general para manejar toda la
 * informacion de la vista Fecha: 16-07-2018 Nro. Req: 1 Version: 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(Cliente.class);
	
	// objeto unico para seccion identificacion
	private IdentificacionSeccionVO identificacionSeccionVO;
	
	// objeto unico para seccion basica
	private BasicaSeccionVO basicaSeccionVO;
	
	// lista para secciones de representantes legales
	private List<RepresentantesLegalesSeccionVO> representantesLegales = new ArrayList<>();
	
	// lista para secciones de accionistas
	private List<AccionistasSeccionVO> accionistas = new ArrayList<>();
	
	// lista para secciones de accionistas OCULTOS
	private List<AccionistasSeccionVO> accionistasOcultos = new ArrayList<>();
	
	// campo para el valor unico del radio de capital en seccion accionistas
	private String radCapitalAccionista;	
	
	// lista de objeto para subseccion Limitaciones
	private List<LimitacionSubSeccionVO> limitacionesRestricciones = new ArrayList<>();
	
	// lista para subseccion documentos Examinados
	private List<DocumentosExaminadosSubSeccionVO> documentosExaminados = new ArrayList<>();
	
	// lista para subseccion Observaciones
	private List<ObservacionSubSeccionVO> observaciones = new ArrayList<>();
	
	// objeto unico para subseccion responsable
	private ResponsableSubSeccionVO responsableSubSeccionVO;
	
	private Boolean clienteBloqueado = false;
	
	private List<Direccion> direcciones = new ArrayList<>();
	
	private Integer origenDatos = new Integer(0);
	
	private String estadoBusqueda = new String();
	
	public Cliente() {
		clienteBloqueado = false;
	}
	
	public String getEstadoBusqueda() {
		return estadoBusqueda == null ? new String() : estadoBusqueda;
	}

	public void setEstadoBusqueda(String mensajeBusquedaCliente) {
		this.estadoBusqueda = mensajeBusquedaCliente;
	}
	
	public LimitacionSubSeccionVO setearLim() {
		LimitacionSubSeccionVO lim = new LimitacionSubSeccionVO();
		lim.setTxtDescripcion("");
		return lim;
	}
	
	public ObservacionSubSeccionVO setearObj() {
		ObservacionSubSeccionVO obj = new ObservacionSubSeccionVO();
		obj.setTxtDescripcion("");
		return obj;
	}

	public DocumentosExaminadosSubSeccionVO setearDoc() {
		DocumentosExaminadosSubSeccionVO docEx = new DocumentosExaminadosSubSeccionVO();
		docEx.setCmbConceptoDoc("");
		docEx.setTxtNotaria("");
		docEx.setRadTipoDoc("");
		return docEx;
	}

	public AccionistasSeccionVO setearAcc() {
		AccionistasSeccionVO acc = new AccionistasSeccionVO();
		acc.setRadNaturalJuridicoAccionistas("");
		acc.setTxtIdentificacionAccionistas("");
		acc.setTxtRazonSocialAccionistas("");
		acc.setTxtPrimerNombreAccionistas("");
		acc.setTxtSegundoNombreAccionistas("");
		acc.setTxtPrimerApellidoAccionistas("");
		acc.setTxtSegundoApellidoAccionistas("");
		
		acc.setPorcentajeAcciones(0.0);
		
		acc.setTxtPorcentajeAccionistas("");
		
		acc.setMontoAcciones(0.0);
		
		acc.setTxtMontoAccionistas("");
		
		acc.setCmbNacionalidadAccionistas("");
		acc.setMaxLenghtIdentificacion(13);
		acc.setRegexIdentification("/[\\d]/");
		return acc;
	}

	/**
	 * Agrega Observaciones por default
	 */
	public void agregarObs() {
		observaciones.add(setearObj());
	}

	/**
	 * Elimina Observaciones con index
	 */
	public void removerObs(int i) {
		if (i >= 0 && i < observaciones.size()) {
			observaciones.remove(i);
		}
	}

	/**
	 * Agrega documentos existentes por default
	 */
	public void agregarDoct() {
		documentosExaminados.add(setearDoc());
	}

	/**
	 * Elimina documentos existentes con index
	 */
	public void removerDoc(int i) {
		if (i >= 0 && i < documentosExaminados.size()) {
			documentosExaminados.remove(i);
		}
	}

	/**
	 * Agrega limitaciones, restricciones, estatutarias por default
	 */
	public void agregarLimit() {
		limitacionesRestricciones.add(setearLim());
	}

	/**
	 * Elimina limitaciones, restricciones, estatutarias con index
	 */
	public void removerLimit(int i) {
		if (i >= 0 && i < limitacionesRestricciones.size()) {
			limitacionesRestricciones.remove(i);
		}
	}

	/**
	 * Elimina representante legal con index
	 */
	public void removerRep(int i) {
		if (i >= 0 && i < representantesLegales.size()) {
			representantesLegales.remove(i);
		}
	}

	/**
	 * Agrega accionista por default
	 */
	public void agregarAcc() {
		accionistas.add(setearAcc());
	}

	/**
	 * Elimina accionista con index
	 */
	public void removerAcc(int i) {
		if (i >= 0 && i < accionistas.size()) {
			accionistas.remove(i);
		}
	}
	
	public static String toJSON(Cliente cliente){
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(cliente);
			return json;
		} catch (JsonGenerationException e) {
			logger.error("Excepcion JsonGenerationException en metodo: Cliente.toJSON");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("Excepcion JsonMappingException en metodo: Cliente.toJSON");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("Excepcion IOException en metodo: Cliente.toJSON");
			e.printStackTrace();
		}
		return json;
	}
	
	public static Cliente jsonToCliente(String json) throws JsonParseException, JsonMappingException, IOException{
		com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(json, Cliente.class);
	}

	// **************************** GETTERS AND SETTERS

	public List<RepresentantesLegalesSeccionVO> getRepresentantesLegales() {
		return representantesLegales == null ? new ArrayList<RepresentantesLegalesSeccionVO>() : representantesLegales;
	}

	public ResponsableSubSeccionVO getResponsableSubSeccionVO() {
		responsableSubSeccionVO = responsableSubSeccionVO == null ? new ResponsableSubSeccionVO()
				: responsableSubSeccionVO;
		return responsableSubSeccionVO;
	}

	public void setResponsableSubSeccionVO(ResponsableSubSeccionVO responsableSubSeccionVO) {
		this.responsableSubSeccionVO = responsableSubSeccionVO;
	}

	public List<DocumentosExaminadosSubSeccionVO> getDocumentosExaminados() {
		documentosExaminados = documentosExaminados == null ? new ArrayList<DocumentosExaminadosSubSeccionVO>()
				: documentosExaminados;
		return documentosExaminados;
	}

	public void setDocumentosExaminados(List<DocumentosExaminadosSubSeccionVO> documentosExaminados) {
		this.documentosExaminados = documentosExaminados;
	}

	public List<AccionistasSeccionVO> getAccionistas() {
		accionistas = accionistas == null ? new ArrayList<AccionistasSeccionVO>() : accionistas;
		return accionistas;
	}

	public void setAccionistas(List<AccionistasSeccionVO> accionistas) {
		this.accionistas = accionistas;
	}

	public void setRepresentantesLegales(List<RepresentantesLegalesSeccionVO> representantesLegales) {
		this.representantesLegales = representantesLegales;
	}

	public BasicaSeccionVO getBasicaSeccionVO() {
		basicaSeccionVO = basicaSeccionVO == null ? new BasicaSeccionVO() : basicaSeccionVO;
		return basicaSeccionVO;
	}

	public void setBasicaSeccionVO(BasicaSeccionVO basicaSeccionVO) {
		this.basicaSeccionVO = basicaSeccionVO;
	}

	public IdentificacionSeccionVO getIdentificacionSeccionVO() {
		identificacionSeccionVO = identificacionSeccionVO == null ? new IdentificacionSeccionVO()
				: identificacionSeccionVO;
		return identificacionSeccionVO;
	}

	public void setIdentificacionSeccionVO(IdentificacionSeccionVO identificacionSeccionVO) {
		this.identificacionSeccionVO = identificacionSeccionVO;
	}

	public String getRadCapitalAccionista() {
		radCapitalAccionista = (radCapitalAccionista == null || radCapitalAccionista.isEmpty()) ? 
				"M" : 
					radCapitalAccionista;
		return radCapitalAccionista;
	}

	public void setRadCapitalAccionista(String radCapitalAccionista) {
		this.radCapitalAccionista = radCapitalAccionista;
	}

	public List<Direccion> getDirecciones() {
		direcciones = direcciones == null ? new ArrayList<Direccion>() : direcciones;
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public List<LimitacionSubSeccionVO> getLimitacionesRestricciones() {
		limitacionesRestricciones = limitacionesRestricciones == null ? new ArrayList<LimitacionSubSeccionVO>()
				: limitacionesRestricciones;
		return limitacionesRestricciones;
	}

	public void setLimitacionesRestricciones(List<LimitacionSubSeccionVO> limitacionesRestricciones) {
		this.limitacionesRestricciones = limitacionesRestricciones;
	}

	public List<ObservacionSubSeccionVO> getObservaciones() {
		observaciones = observaciones == null ? new ArrayList<ObservacionSubSeccionVO>() : observaciones;
		return observaciones;
	}

	public void setObservaciones(List<ObservacionSubSeccionVO> observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getOrigenDatos() {
		origenDatos = origenDatos == null ? new Integer(0) : origenDatos;
		return origenDatos;
	}

	public void setOrigenDatos(Integer origenDatos) {
		this.origenDatos = origenDatos;
	}

	public Boolean getClienteBloqueado() {
		return clienteBloqueado;
	}

	public void setClienteBloqueado(Boolean clienteBloqueado) {
		this.clienteBloqueado = clienteBloqueado;
	}
	
	public List<AccionistasSeccionVO> getAccionistasOcultos() {
		accionistasOcultos = accionistasOcultos == null ? new ArrayList<AccionistasSeccionVO>() : accionistasOcultos;
		return accionistasOcultos;
	}

	public void setAccionistasOcultos(List<AccionistasSeccionVO> accionistasOcultos) {
		this.accionistasOcultos = accionistasOcultos;
	}
	
}
