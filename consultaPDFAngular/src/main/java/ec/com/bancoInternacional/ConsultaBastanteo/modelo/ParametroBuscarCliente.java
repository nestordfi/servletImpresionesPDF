package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.math.BigDecimal;
import java.util.Objects;



/**
 * ParametroBuscarCliente
 */

public class ParametroBuscarCliente {
	private String nombreCorto = null;

	private BigDecimal nroIbs = null;

	private String id = null;

	private String grupoMaster = null;
	
	
	
	public ParametroBuscarCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParametroBuscarCliente(String nombreCorto, BigDecimal nroIbs, String id, String grupoMaster) {
		super();
		this.nombreCorto = nombreCorto;
		this.nroIbs = nroIbs;
		this.id = id;
		this.grupoMaster = grupoMaster;
	}

	public ParametroBuscarCliente nombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
		return this;
	}

	/**
	 * Get nombreCorto
	 * 
	 * @return nombreCorto
	 **/

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public ParametroBuscarCliente nroIbs(BigDecimal nroIbs) {
		this.nroIbs = nroIbs;
		return this;
	}

	/**
	 * Get nroIbs
	 * 
	 * @return nroIbs
	 **/

	public BigDecimal getNroIbs() {
		return nroIbs;
	}

	public void setNroIbs(BigDecimal nroIbs) {
		this.nroIbs = nroIbs;
	}

	public ParametroBuscarCliente id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ParametroBuscarCliente grupoMaster(String grupoMaster) {
		this.grupoMaster = grupoMaster;
		return this;
	}

	/**
	 * Get grupoMaster
	 * 
	 * @return grupoMaster
	 **/

	public String getGrupoMaster() {
		return grupoMaster;
	}

	public void setGrupoMaster(String grupoMaster) {
		this.grupoMaster = grupoMaster;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ParametroBuscarCliente parametroBuscarCliente = (ParametroBuscarCliente) o;
		return Objects.equals(this.nombreCorto, parametroBuscarCliente.nombreCorto)
				&& Objects.equals(this.nroIbs, parametroBuscarCliente.nroIbs)
				&& Objects.equals(this.id, parametroBuscarCliente.id)
				&& Objects.equals(this.grupoMaster, parametroBuscarCliente.grupoMaster);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreCorto, nroIbs, id, grupoMaster);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ParametroBuscarCliente {\n");

		sb.append("    nombreCorto: ").append(toIndentedString(nombreCorto)).append("\n");
		sb.append("    nroIbs: ").append(toIndentedString(nroIbs)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    grupoMaster: ").append(toIndentedString(grupoMaster)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
