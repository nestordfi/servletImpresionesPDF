package ec.com.bancoInternacional.shared.beans;

public class ObjCnofc extends ListHelper {
	
	public ObjCnofc(){
		super();
	}
	
	public ObjCnofc(String trama){
		super();
		if(trama != null){
			String[] vfila = trama.split("[|]");
			if(vfila.length>0)
				this.id = vfila[0].trim();
			if(vfila.length>1)
				this.value = vfila[1].trim();
		}
	}
}//fin de la clase
