package ec.com.bancoInternacional.services.mapping;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.we0038.NCGINPDATOS;
import ec.com.bancoInternacional.services.domain.Catalogo;
import ec.com.bancoInternacional.services.domain.Ncodig;
import ec.com.bancoInternacional.services.util.ConsultaNcodigParametro;
import ec.com.bancoInternacional.services.util.NcodigClaveParametro;

/**
 * Autor: Sandro Guevara
 * Objetivo: Clase que mapea estructuras AS/400 NCODIG a objetos de Catalogos
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */
public class NcodigMapper  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(NcodigMapper.class);
		
public  NCGINPDATOS mapNcodigParameterToNgcImpDatos(ConsultaNcodigParametro parameterObject, NCGINPDATOS ngcInpDatos){
	ngcInpDatos.setNCGTABLA(parameterObject.getTabla());
	ngcInpDatos.setNCGNIVEL(BigDecimal.valueOf(Long.parseLong(parameterObject.getNivel())));
	ngcInpDatos.setNCGCODIGO1(parameterObject.getCod1());
	ngcInpDatos.setNCGCODIGO2(parameterObject.getCod2());
	ngcInpDatos.setNCGCODIGO3(parameterObject.getCod3());
	ngcInpDatos.setNCGCODIGO4(parameterObject.getCod4());

	logger.debug(ngcInpDatos.toString());
	
	return ngcInpDatos;
	
}

public  String[] mapNcgDetalleToArray(String[] ncgDetalle){
	String[] resp = null;
	Vector<String> vCat = new Vector<String>();
	for (String item : ncgDetalle)
		if (item != null && item.trim().length() > 0) {
			vCat.addElement(item.trim());
		} else {
			break;
		}
	int sizeCat = vCat.size();
	if (sizeCat > 0) {
		String[] aux = new String[sizeCat];
		resp = vCat.toArray(aux);
		aux = null;
	}
	vCat = null;
	return resp;
}

public  Ncodig mapStreamToNcodig(String trama,NcodigClaveParametro parameterObject){
	Ncodig ncodig=new Ncodig();
	String id = "";
	String idExt = "";
	String value;
	if(trama != null){
		String[] vfila = trama.split("[|]");
		if(parameterObject.getcClaves().length==0){
			if(vfila.length>0){
				id = vfila[0].trim();
				ncodig.setId(id);
				}
		}else{
			for(int cc:parameterObject.getcClaves()){
				if(vfila.length>cc){
					id = id.concat(vfila[cc].trim());
					ncodig.setId(id);
				}
			}

			if(parameterObject.isKeyExt()){
				for(int i=0;i<=parameterObject.getcClaves()[0];i++){
					if(vfila.length>i)
						idExt = idExt.concat(vfila[i].trim());
						ncodig.setIdExt(idExt);
				}
			}
		}

		if(vfila.length>5){
			value = vfila[5].trim();
			ncodig.setValue(value);
		}
		
		if(parameterObject.isNcCod()){
			ncodig.setNcCod(new String[4]);
		
			if(vfila.length>1)
				ncodig.getNcCod()[0] = vfila[1].trim();
			if(vfila.length>2)
				ncodig.getNcCod()[1] = vfila[2].trim();
			if(vfila.length>3)
				ncodig.getNcCod()[2] = vfila[3].trim();
			if(vfila.length>4)
				ncodig.getNcCod()[3] = vfila[4].trim();
		}
		
		if(parameterObject.isNcVal()){
			ncodig.setNcVal( new String[3]);
			if(vfila.length>6)
				ncodig.getNcVal()[0] = vfila[6].trim();
			if(vfila.length>7)
				ncodig.getNcVal()[1] = vfila[7].trim();
			if(vfila.length>8)
				ncodig.getNcVal()[2] = vfila[8].trim();
		}
		
		if(parameterObject.isNcDat()){
			ncodig.setNcDat(new String[3]);
			if(vfila.length>9)
				ncodig.getNcDat()[0] = vfila[9].trim();
			if(vfila.length>10)
				ncodig.getNcDat()[1] = vfila[10].trim();
			if(vfila.length>11)
				ncodig.getNcDat()[2] = vfila[11].trim();
		}

	}
	return ncodig;
}

public List<Catalogo> getObjCnofc(String[] filas) {
	List<Catalogo> resp = new ArrayList<Catalogo>();
	if (filas != null)
		for (String item : filas)
			if (item != null && item.trim().length() > 0) {
				Catalogo aux = new Catalogo();

				String[] vfila = item.split("[|]");
				if (vfila.length > 0)
					aux.setId(vfila[0].trim());
				if (vfila.length > 1)
					aux.setValue(vfila[1].trim());

				resp.add(aux);
			} else
				break;
	return resp;
}

}
