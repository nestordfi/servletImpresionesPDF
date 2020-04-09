package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

/**
 * Autor:		Carlos Carrera
 * Objetivo:	Clase de dominio para Informacion adicional de pais
 * Representa NCODIG, para niveles 3, 4
 * "CCLI", "4", "CCAT", "PAIS", "AF", "PRFI"
 * Catalogos de NCODIG, que se recuperan mediante el programa de servicio PRCONSNCODI de cs0052 
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
 */
public class PaisInfo extends Catalogo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//PRFI LEVEL Prefijo telefono internacional
	private String prefix;
	//ALRI LEVEL Alto riesgo
	private boolean highRisk;
	//FATC LEVEL FATCA
	private boolean isFatca;
	//NCDAT1 Prefijo universal ex. ECU
	private String worldId;
	
	public PaisInfo() {
	}
	public PaisInfo(String prefix, boolean highRisk, boolean isFatca, String worldId) {
		super();
		this.prefix = prefix;
		this.highRisk = highRisk;
		this.isFatca = isFatca;
		this.worldId = worldId;
	}
	
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public boolean isHighRisk() {
		return highRisk;
	}
	public void setHighRisk(boolean highRisk) {
		this.highRisk = highRisk;
	}
	public boolean isFatca() {
		return isFatca;
	}
	public void setFatca(boolean isFatca) {
		this.isFatca = isFatca;
	}
	public String getWorldId() {
		return worldId;
	}
	public void setWorldId(String worldId) {
		this.worldId = worldId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (highRisk ? 1231 : 1237);
		result = prime * result + (isFatca ? 1231 : 1237);
		result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
		result = prime * result + ((worldId == null) ? 0 : worldId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaisInfo other = (PaisInfo) obj;
		if (highRisk != other.highRisk)
			return false;
		if (isFatca != other.isFatca)
			return false;
		if (prefix == null) {
			if (other.prefix != null)
				return false;
		} else if (!prefix.equals(other.prefix))
			return false;
		if (worldId == null) {
			if (other.worldId != null)
				return false;
		} else if (!worldId.equals(other.worldId))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return super.toString()+" PaisInfo [prefix=" + prefix + ", highRisk=" + highRisk + ", isFatca=" + isFatca + ", worldId=" + worldId
				+ "]";
	}
}
