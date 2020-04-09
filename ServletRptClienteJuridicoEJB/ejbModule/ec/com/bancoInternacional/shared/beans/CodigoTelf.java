package ec.com.bancoInternacional.shared.beans;

public class CodigoTelf extends ListHelper {
	
	public CodigoTelf(){
		super();
	}
	
	public CodigoTelf(String trama){
		super();
		if(trama != null){
			String[] vfila = trama.split("[|]");
			if(vfila.length>6){
				this.id = vfila[6].trim();
				this.value = this.id;
			}
		}
	}//CodigoTelf

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof CodigoTelf){
			return this.id.equals(((CodigoTelf)obj).getId());
		}else
			return false;
	}//equals

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
}//fin de la clase