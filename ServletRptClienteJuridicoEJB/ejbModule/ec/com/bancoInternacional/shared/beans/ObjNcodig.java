package ec.com.bancoInternacional.shared.beans;

public class ObjNcodig extends ListHelper {
	private String idExt = "";
	private String[] ncCod = null;
	private String[] ncVal = null;
	private String[] ncDat = null;

	public ObjNcodig(){
		super();
	}
	
	
	/*** Construye el objeto ObjNcodig en base a la trama de la consulta CATAYUNCG del ncodig.
	 * @param trama campos separados por pipe (|)
	 * @param isNcCod true indica que se recuperan los valores de NCCOD 1,2,3,4 en un arreglo
	 * @param isNcVal true indica que se recuperan los valores de NCVAL 1,2,3 en un arreglo
	 * @param isNcDat true indica que se recuperan los valores de NCDAT 1,2,3 en un arreglo
	 * @param keyExt true indica que el objeto se construye con una clave compuesta
	 * @param cClave posiciones en la trama donde se encuentran las claves parciales a ser concatenadas
	 */
	public ObjNcodig(String trama, boolean isNcCod, boolean isNcVal, boolean isNcDat, boolean keyExt, int ... cClave){
		super();
		if(trama != null){
			String[] vfila = trama.split("[|]");
			if(cClave.length==0){
				if(vfila.length>0)
					this.id = vfila[0].trim();
			}else{
				for(int cc:cClave){
					if(vfila.length>cc)
						this.id = this.id.concat(vfila[cc].trim());
				}

				if(keyExt){
					for(int i=0;i<=cClave[0];i++){
						if(vfila.length>i)
							this.idExt = this.idExt.concat(vfila[i].trim());
					}
				}
			}

			if(vfila.length>5){
				this.value = vfila[5].trim();
			}
			
			if(isNcCod){
				ncCod = new String[4];
				if(vfila.length>1)
					this.ncCod[0] = vfila[1].trim();
				if(vfila.length>2)
					this.ncCod[1] = vfila[2].trim();
				if(vfila.length>3)
					this.ncCod[2] = vfila[3].trim();
				if(vfila.length>4)
					this.ncCod[3] = vfila[4].trim();
			}
			
			if(isNcVal){
				ncVal = new String[3];
				if(vfila.length>6)
					this.ncVal[0] = vfila[6].trim();
				if(vfila.length>7)
					this.ncVal[1] = vfila[7].trim();
				if(vfila.length>8)
					this.ncVal[2] = vfila[8].trim();
			}
			
			if(isNcDat){
				ncDat = new String[3];
				if(vfila.length>9)
					this.ncDat[0] = vfila[9].trim();
				if(vfila.length>10)
					this.ncDat[1] = vfila[10].trim();
				if(vfila.length>11)
					this.ncDat[2] = vfila[11].trim();
			}

		}
	}//ObjNcodig

	public String getIdExt() {
		return idExt;
	}

	public void setIdExt(String idExt) {
		this.idExt = idExt;
	}


	public String[] getNcCod() {
		return ncCod;
	}


	public String[] getNcVal() {
		return ncVal;
	}


	public String[] getNcDat() {
		return ncDat;
	}
	
}//fin de la clase
