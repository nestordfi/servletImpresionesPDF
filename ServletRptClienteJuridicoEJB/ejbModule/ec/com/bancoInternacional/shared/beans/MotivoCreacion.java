package ec.com.bancoInternacional.shared.beans;

public class MotivoCreacion extends ListHelper {
	private boolean envioCallcenter = true;
	private boolean activacionCliente = false;
	
	public MotivoCreacion(){
		super();
	}
	
	public MotivoCreacion(String trama){
		super();
		if(trama != null){
			String[] vfila = trama.split("[|]");

			if(vfila.length>0)
				this.id = vfila[0].trim();

			if(vfila.length>5)
				this.value = vfila[5].trim();
			
			if(vfila.length>9)
				this.envioCallcenter = vfila[9].trim().equalsIgnoreCase("S");
			
			if(vfila.length>10)
				this.activacionCliente = vfila[10].trim().equalsIgnoreCase("S");
		}
	}//MotivoCreacion
	
	/**
	 * @return the envioCallcenter
	 */
	public boolean isEnvioCallcenter() {
		return envioCallcenter;
	}
	/**
	 * @param envioCallcenter the envioCallcenter to set
	 */
	public void setEnvioCallcenter(boolean envioCallcenter) {
		this.envioCallcenter = envioCallcenter;
	}
	/**
	 * @return the activacionCliente
	 */
	public boolean isActivacionCliente() {
		return activacionCliente;
	}
	/**
	 * @param activacionCliente the activacionCliente to set
	 */
	public void setActivacionCliente(boolean activacionCliente) {
		this.activacionCliente = activacionCliente;
	}
}//fin de la clase