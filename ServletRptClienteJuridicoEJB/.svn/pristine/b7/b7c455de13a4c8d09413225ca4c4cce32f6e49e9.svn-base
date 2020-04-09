package ec.com.bancoInternacional.server.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.config.Application;
import ec.com.bancoInternacional.services.ibm.pool.PooledTrx;
import ec.com.bancoInternacional.shared.beans.CodigoTelf;
import ec.com.bancoInternacional.shared.beans.ListHelper;
import ec.com.bancoInternacional.shared.beans.MotivoCreacion;
import ec.com.bancoInternacional.shared.beans.ObjCnofc;
import ec.com.bancoInternacional.shared.beans.ObjCombo;
import ec.com.bancoInternacional.shared.beans.ObjNcodig;
import ec.com.bancoInternacional.we0038.CATAYUCNF;
import ec.com.bancoInternacional.we0038.CATAYUNCG;
import ec.com.bancoInternacional.we0038.CNFINPDATA;
import ec.com.bancoInternacional.we0038.NCGINPDATOS;
import ec.com.bancoInternacional.we0038.RECMENSAJE;

public class Catalogos extends PooledTrx{
	private static final Logger logger = Logger.getLogger(Catalogos.class);
	private static Map<String,List<ListHelper>> objCatalogos = null;
	
	private static ObjCombo combos = null;
	private static Map<String, String> valoresai = null;
	
	static{
		objCatalogos = new HashMap<String, List<ListHelper>>();
		combos = new ObjCombo();
		valoresai = new HashMap<String, String>();
	}
	
	public void cargaCatalogos(){
		if(objCatalogos.size()==0){
			
			logger.debug("carga ncodig");
			//ncodig
			List<ListHelper> lista = null;
			lista = getObjNcodig(consultaNcodig("TIEM", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("tipoEmpresa", lista);//NCNIVL=1 and NCTABL = 'TIEM' and NCESTA = 'A'

			lista = null;
			lista = getObjNcodig(consultaNcodig("TACT", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0){
				objCatalogos.put("codigoIndustria", lista);//NCNIVL=1 and NCTABL = 'TACT' and NCESTA = 'A'
				consultaNcodigRelacionada("actividadEmpresa",lista,"TACT", "2", " ", " ", " ", " ", false,1);//SELECT NCCOD1, NCCOD2, NCDESC WHERE NCNIVL=2 and NCTABL = 'TACT' and NCESTA = 'A'
			}

			lista = null;
			lista = getObjNcodig(consultaNcodig("TCIU", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0){
				objCatalogos.put("provincia", lista);//NCNIVL=1 AND NCTABL = 'TCIU' AND NCESTA = 'A'
				consultaNcodigRelacionadaSubNivel("ciudad","parroquia",lista,"TCIU", "3", " ", " ", " ",true,1);//SELECT NCCOD1, NCCOD2, NCDESC WHERE NCNIVL=3 AND NCTABL = 'TCIU' AND NCESTA = 'A'
			}
			
			lista = null;
			lista = getObjNcodig(consultaNcodig("TCEC", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("cedExtranjera", lista);//NCNIVL=1 AND NCTABL = 'TCEC' AND NCESTA = 'A'
			
		
			lista = null;
			lista = getObjNcodig(consultaNcodig("TBAN", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("tipoBanca", lista);//NCNIVL=1 AND NCTABL = 'TBAN' AND NCESTA = 'A'

			lista = null;
			lista = getObjNcodig(consultaNcodig("TDBA", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("canalAtencion", lista);//NCNIVL=1 AND NCTABL = 'TDBA' AND NCESTA = 'A'

			lista = null;
			lista = getObjNcodig(consultaNcodig("REFE", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("tipoReferencia", lista);//NCNIVL=1 AND NCTABL = 'REFE' AND NCESTA = 'A'

			lista = null;
			lista = getObjNcodig(consultaNcodig("TPAR", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("parentesco", lista);//NCNIVL=1 and NCTABL = 'TPAR' and NCESTA = 'A'

			lista = null;
			lista = getObjNcodig(consultaNcodig("TLEC", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("lugarEnvioCorrespondencia", lista);//NCNIVL=1 AND NCTABL = 'TLEC' AND NCESTA = 'A'

			lista = null;
			lista = getObjNcodig(consultaNcodig("SIEG", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("estadoGrupoEconomico", lista);//NCNIVL=1 AND NCTABL = 'SIEG' AND NCESTA = 'A'

			lista = null;
			lista = getObjNcodig(consultaNcodig("FACT", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("factorIntegracion", lista);//NCNIVL=1 AND NCTABL = 'FACT' AND NCESTA = 'A'

			lista = null;
			lista = getObjNcodig(consultaNcodig("SIGR", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("codigoGrupoEconomico", lista);//NCNIVL=1 AND NCTABL = 'SIGR' AND NCESTA = 'A'

			lista = null;
			lista = getObjNcodig(consultaNcodig("TSUP", "2", "TB04", " ", " ", " "), false, false, false, false, 1);
			if(lista != null && lista.size()>0)
				objCatalogos.put("nacionalidad", lista);//NCTABL ='TSUP' AND NCNIVL=2 AND NCCOD1='TB04'
			//PCH 29/06/2015
			lista = null;
			lista = getObjNcodig(consultaNcodig("TSRI", "2", "TCTY", " ", " ", " "), false, false, false, false, 1);
			if(lista != null && lista.size()>0)
				objCatalogos.put("tipoContribuyente", lista);//NCTABL ='TSRI' AND NCNIVL=2 AND NCCOD1='TCTY'
			//PCH 29/06/2015
			//M625
			Set<String> codErrs = new HashSet<String>();
			
			//consulta paises fatca
			lista = null;
			lista = getObjNcodig(consultaNcodig("TCTR", "4", "01", " ", " ", " "), true, true, true, false, 1);
			
			List<ListHelper> aLista = new ArrayList<ListHelper>();
			ObjNcodig objNcodig = null;
			String[] anNcC = null;
			String ncc = null;
			
			for(ListHelper aLH: lista){
				objNcodig = (ObjNcodig)aLH;
				anNcC = objNcodig.getNcCod();
				ncc = anNcC[2];
				//natural
				if(null != ncc && "2".equals(ncc)){
					aLista.add(aLH);
					codErrs.add(objNcodig.getNcVal()[0]);
				}
			}
			
			if(aLista.size()>0)
				objCatalogos.put("fatcaPaisN", aLista);//NCTABL ='TCTR' AND NCNIVL=4 AND NCCOD1='01'and NCCOD3 = '01' and NCCOD4=2;

			aLista = new ArrayList<ListHelper>();
			objNcodig = null;
			
			for(ListHelper aLH: lista){
				objNcodig = (ObjNcodig)aLH;
				anNcC = objNcodig.getNcCod();
				ncc = anNcC[2];
				//jurídico
				if(null != ncc && "1".equals(ncc)){
					aLista.add(aLH);
					codErrs.add(objNcodig.getNcVal()[0]);
				}
			}
			
			if(aLista.size()>0)
				objCatalogos.put("fatcaPaisJ", aLista);//NCTABL ='TCTR' AND NCNIVL=4 AND NCCOD1='01'and NCCOD3 = '01' and NCCOD4=1;
			
			//consulta nacionalidades Fatca
			lista = null;
			lista = getObjNcodig(consultaNcodig("TCTR", "4", "02", " ", " ", " "), true, true, true, false, 1);
			
			aLista = new ArrayList<ListHelper>();
			objNcodig = null;
			
			for(ListHelper aLH: lista){
				objNcodig = (ObjNcodig)aLH;
				anNcC = objNcodig.getNcCod();
				ncc = anNcC[2];
				//natural
				if(null != ncc && "2".equals(ncc)){
					aLista.add(aLH);
					codErrs.add(objNcodig.getNcVal()[0]);
				}
			}
			
			if(aLista.size()>0)
				objCatalogos.put("fatcaNacionalidadN", aLista);//NCTABL ='TCTR' AND NCNIVL=4 AND NCCOD1='02'and NCCOD3 = '01' and NCCOD4=2;
			
			aLista = new ArrayList<ListHelper>();
			objNcodig = null;
			
			for(ListHelper aLH: lista){
				objNcodig = (ObjNcodig)aLH;
				anNcC = objNcodig.getNcCod();
				ncc = anNcC[2];
				//jurídico
				if(null != ncc && "1".equals(ncc)){
					aLista.add(aLH);
					codErrs.add(objNcodig.getNcVal()[0]);
				}
			}
			
			if(aLista.size()>0)
				objCatalogos.put("fatcaNacionalidadJ", aLista);//NCTABL ='TCTR' AND NCNIVL=4 AND NCCOD1='02'and NCCOD3 = '01' and NCCOD4=1;
			
			//descripciones de errores / mensajes
			lista = getDescErrorCTExt(codErrs);
			if(lista != null && lista.size()>0)
				objCatalogos.put("fatcaDesErr", lista);
						
			anNcC = null;
			ncc = null;
			aLista = null;
			codErrs = null;
			//M625

			lista = null;
			lista = getObjNcodig(consultaNcodig("TSUP", "2", "TB05", " ", " ", " "), false, false, false, false, 1);
			if(lista != null && lista.size()>0)
				objCatalogos.put("pais", lista);//NCTABL ='TSUP' AND NCNIVL=2 AND NCCOD1='TB05'
			
			lista = null;
			lista = getObjNcodig(consultaNcodig("TTVI", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("vivienda", lista);//NCNIVL=1 AND NCTABL = 'TTVI' and NCESTA = 'A'

			lista = null;
			lista = getObjNcodig(consultaNcodig("ESTC", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("estadoCivil", lista);//NCNIVL=1 AND NCTABL = 'ESTC'  and NCESTA = 'A'

			lista = null;
			lista = getObjNcodig(consultaNcodig("PROF", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("profesion", lista);//NCNIVL=1 AND NCTABL = 'PROF'  and NCESTA = 'A'

			lista = null;
			lista = getObjNcodig(consultaNcodig("SECT", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0){
				objCatalogos.put("sectorizacion", lista);//NCNIVL=1 AND NCTABL = 'SECT' AND NCESTA = 'A'
				consultaNcodigRelacionada("subSectorizacion",lista,"SECT", "2", " ", " ", " ", " ", false, 1);//SELECT NCCOD1, NCCOD2, NCDESC WHERE NCNIVL=2 AND NCTABL = 'SECT' AND NCESTA = 'A'
			}

			lista = null;
			lista = getMotivosCreacion(consultaNcodig("CCLI","3", "CCAT", "TPRO", " ", " "));
			if(lista != null && lista.size()>0)
				objCatalogos.put("motivoCreacionCliente", lista);//SELECT NCCOD1, NCDESC, NCDAT1, NCDAT2 WHERE NCNIVL=1 AND NCTABL = 'TPRO' AND NCESTA = 'A'

			lista = null;
			lista = getObjNcodig(consultaNcodig("TACT", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0){
				objCatalogos.put("actividadEconomica", lista);//NCNIVL=1 and NCTABL = 'TACT' and NCESTA = 'A'
				consultaNcodigRelacionada("lineaNegocio",lista,"TACT", "2", " ", " ", " ", " ", false, 1);//SELECT NCCOD1, NCCOD2, NCDESC WHERE NCNIVL=2 and NCTABL = 'TACT' and NCESTA = 'A'
			}

			lista = null;
			lista = getObjNcodig(consultaNcodig("CONJ", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("tipoEntidad", lista);//NCNIVL=1 AND NCTABL = 'CONJ' AND NCESTA = 'A'
			//ciudad.claveCompuesta

			lista = null;
			lista = getObjNcodig(consultaNcodig("TINE", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("tipoNivelEducacion", lista);//NCNIVL=1 AND NCTABL = 'TINE'

			lista = null;
			lista = getObjNcodig(consultaNcodig("TCEL", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("tipoOperadora", lista);//NCNIVL =1 and NCTABL='TCEL'
			
			//MG20121029
			lista = null;
			lista = getObjNcodig(consultaNcodig("PROR", "1", " ", " ", " ", " "), false, false, false, false);
			if(lista != null && lista.size()>0)
				objCatalogos.put("relacionComercial", lista);//NCNIVL =1 and NCTABL='PROR'
			//MG20121029

			lista = null;
			lista = getCodigoTelf(consultaNcodig("TCIU", "1", " ", " ", " ", " "));
			if(lista != null && lista.size()>0)
				objCatalogos.put("codigoTelf", lista);//SELECT DISTINCT(NCVAL1) WHERE NCNIVL =1 and NCTABL='TCIU'

			
			logger.debug("carga cnofc");
			//cnofc
			lista = null;
			lista = getObjCnofc(consultaCnofc("4"," "));
			if(lista != null && lista.size()>0)
				objCatalogos.put("fuentesIngreso", lista);//CNOCFL = '4'

			lista = null;
			lista = getObjCnofc(consultaCnofc("6"," "));
			if(lista != null && lista.size()>0)
				objCatalogos.put("cargo", lista);//CNOCFL = '6'

			/*
			lista = null;
			lista = getObjCnofc(consultaCnofc("C"," "));
			if(lista != null && lista.size()>0)
				objCatalogos.put("pais", lista);//CNOCFL = 'C'
			*/
			
			lista = null;
			lista = getObjCnofc(consultaCnofc(";"," "));
			if(lista != null && lista.size()>0)
				objCatalogos.put("relacionVinculacion", lista);//CNOCFL = ';'

			lista = null;
			lista = getObjCnofc(consultaCnofc("2"," "));
			if(lista != null && lista.size()>0)
				objCatalogos.put("referidoPor", lista);//CNOCFL = '2'

			lista = null;
			lista = getObjCnofc(consultaCnofc("O"," "));
			if(lista != null && lista.size()>0)
				objCatalogos.put("oficial", lista);//CNOCFL = 'O'

			lista = null;
			lista = getObjCnofc(consultaCnofc("5"," "));
			if(lista != null && lista.size()>0)
				objCatalogos.put("nivelRiesgo", lista);//CNOCFL = '5'

			lista = null;
			lista = getObjCnofc(consultaCnofc("3"," "));
			if(lista != null && lista.size()>0)
				objCatalogos.put("nivelEducacion", lista);//CNOCFL = '3'

			lista = null;
			lista = getObjCnofc(consultaCnofc("8"," "));
			if(lista != null && lista.size()>0)
				objCatalogos.put("institucionFinanciera", lista);//CNOCFL = '8'
			
			//M652
			//valores externalizados en application.properties
			lista = new ArrayList<ListHelper>();
			ListHelper elem = new ListHelper();
			//porcentaje sobre el cual se piden datos del beneficiario del accionista
			elem.setId("app.por.ben");
			elem.setValue(Application.getString("app.por.ben"));
			lista.add(elem);
			elem = new ListHelper();
			//dirección visualización db2 content manager
//			elem.setId("app.db2.conman");
//			elem.setValue(Application.getString("app.db2.conman"));
			lista.add(elem);
			objCatalogos.put("app.pro", lista);
			//M652
			
			elem = null;
			lista = null;
			
			logger.debug("catálogos cargados");
			
		}
		
	}//cargaCatalogos
	
	private void consultaNcodigRelacionada(String relacion,List<ListHelper> padres,String tabla, String nivel, String cod1, String cod2, String cod3, String cod4, boolean keyExt,int ... cClave){
		List<ListHelper> lista;
		String codigo1 = "";
		String strKey = "";
		
		for(ListHelper ListHelper: padres){
			lista = null;
			if(" ".equals(cod1))
				codigo1 = ListHelper.getId();
			else{
				codigo1 = cod1;
				cod2 = ListHelper.getId();
			}
			lista = getObjNcodig(consultaNcodig(tabla, nivel, codigo1, cod2, cod3, cod4), false, false, false, keyExt, cClave);
			if(lista != null && lista.size()>0){
				strKey = relacion.concat(codigo1);
				if(!" ".equals(cod2))
					strKey = strKey.concat(cod2);
				if(objCatalogos.containsKey(strKey))
					logger.debug("repetido:"+tabla+";"+strKey);
					
				objCatalogos.put(strKey, lista);
			}
		}
	}//consultaRelacionada
	
	private void consultaNcodigRelacionadaSubNivel(String relacion, String subRelacion,List<ListHelper> padres,String tabla, String nivel, String cod2,String cod3,String cod4, boolean keyExt,int ... cClave){
		List<ListHelper> lista;
		String cod1;
		for(ListHelper ListHelper: padres){
			lista = null;
			cod1 = ListHelper.getId();
			lista = getObjNcodig(consultaNcodig(tabla, nivel, cod1, cod2, cod3, cod4), false, false, false, false, cClave);
			if(lista != null && lista.size()>0){
				objCatalogos.put(relacion.concat(cod1), lista);
				consultaNcodigRelacionada(subRelacion,lista,"TCIU", "4", cod1, " ", " ", " ", keyExt, 3);//SELECT NCCOD4, NCDESC WHERE NCNIVL=4 AND NCTABL = 'TCIU' AND NCESTA = 'A'
			}
		}
	}//consultaRelacionadaSubNivel

	
	public String[] consultaNcodig(String tabla, String nivel,String cod1,String cod2,String cod3,String cod4){
		String[] resp = null;
		
		CATAYUNCG ncodig = new CATAYUNCG();
		
		NCGINPDATOS ngcInpDatos = ncodig.getCANDATAINP();
		
		ngcInpDatos.setNCGTABLA(tabla);
		ngcInpDatos.setNCGNIVEL(BigDecimal.valueOf(Long.parseLong(nivel)));
		ngcInpDatos.setNCGCODIGO1(cod1);
		ngcInpDatos.setNCGCODIGO2(cod2);
		ngcInpDatos.setNCGCODIGO3(cod3);
		ngcInpDatos.setNCGCODIGO4(cod4);
		
//		ConnAS.conectaAS400(ncodig);//PCH06062012
		try {
			invokeTrx(ncodig);
		} catch (Exception e) {
			logger.error(e);
		}
		
		if(ncodig.getReturnValue()==0){
			String[] ncgDetalle = ncodig.getCANDATAOUT().getNCGDETALLE();
			if(ncgDetalle!=null){
				Vector<String> vCat = new Vector<String>();
				String[] cat = ncgDetalle;

				for(String item:cat)
					if(item!=null && item.trim().length()>0)
						vCat.addElement(item.trim());
					else
						break;
				int sizeCat = vCat.size();
				if(sizeCat>0){
					String[] aux = new String[sizeCat];
					resp = vCat.toArray(aux);
					aux = null;
				}
				vCat = null;
			}
		}else{
			String errores = getStrErrores(ncodig.getTRXMSGOUT().getTRXOERROR());
			logger.debug(tabla+";"+nivel+";"+cod1+";"+cod2+";"+cod3+";"+cod4+": "+ errores);
		}
		
		ngcInpDatos = null;
		ncodig = null;
		
		return resp;
	}//consultaNcodig

	public String[] consultaCnofc(String cod, String ref){
		String[] resp = null;

		CATAYUCNF cnofc = new CATAYUCNF();
		
		CNFINPDATA cnfInpData = cnofc.getCACDATAINP();
		
		cnfInpData.setCNFCODIGO(cod);
		cnfInpData.setCNFCODREFE(ref);
		
//		ConnAS.conectaAS400(cnofc);//PCH06062012
		try {
			invokeTrx(cnofc);
		} catch (Exception e) {
			logger.error(e);
		}
		
		if(cnofc.getReturnValue()==0){
			String[] cnfDetalle = cnofc.getCACDATAOUT().getCNFDETALLE();
			if(cnfDetalle!=null){
				Vector<String> vCat = new Vector<String>();
				String[] cat = cnfDetalle;

				for(String item:cat)
					if(item!=null && item.trim().length()>0)
						vCat.addElement(item.trim());
					else
						break;
				int catSize = vCat.size(); 
				if(catSize>0){
					String[] aux = new String[catSize];
					resp = vCat.toArray(aux);
					aux = null;
				}
				vCat = null;
			}
		}else
			logger.debug(cod+";"+ref+": "+ getStrErrores(cnofc.getTRXMSGOUT().getTRXOERROR()));
		
		cnfInpData = null;
		cnofc = null;

		return resp;
	}//consultaCnofc

	/**
	 * @return the objCatalogos
	 */
	public Map<String, List<ListHelper>> getObjCatalogos() {
		return objCatalogos;
	}
	
	/**
	 * Recupera en una lista los objetos consultados del ncodig
	 * @param filas arreglo de strings resultado de la consulta en el ncodig
	 * @param isNcCod true indica que se recuperan los campos NCCOD
	 * @param isNcVal true indica que se recuperan los campos NCVAL
	 * @param isNcDat true indica que se recuperan los campos NCDAT
	 * @param keyExt true indica que la clave es compuesta
	 * @param cClave posiciones en la trama que forman la clave
	 * @return
	 */
	private List<ListHelper> getObjNcodig(String[] filas, boolean isNcCod, boolean isNcVal, boolean isNcDat, boolean keyExt, int ... cClave){
		List<ListHelper> resp = new ArrayList<ListHelper>();
		if(filas!=null)
			for(String item:filas)
				if(item!=null && item.trim().length()>0){
					ObjNcodig objNcodig = new ObjNcodig(item, isNcCod, isNcVal, isNcDat, keyExt, cClave);
					resp.add(objNcodig);
				}
		return resp;
	}//getObjNcodig
	
	private List<ListHelper> getObjCnofc(String[] filas){
		List<ListHelper> resp = new ArrayList<ListHelper>();
		if(filas!=null)
		for(String item:filas)
			if(item!=null && item.trim().length()>0){
				ObjCnofc objCnofc = new ObjCnofc(item);
				resp.add(objCnofc);
			}else
				break;
		return resp;
	}//getObjCnofc
	
	private String getStrErrores(String[] verrores){
		String errores = "";
		for(String msg: verrores)
			if(msg!=null && msg.trim().length()>0)
				errores = errores.concat(msg);
			else
				break;
		return errores;
	}//getStrErrores
	
	private List<ListHelper> getMotivosCreacion(String[] filas){
		List<ListHelper> resp = new ArrayList<ListHelper>();
		if(filas!=null)
		for(String item:filas)
			if(item!=null && item.trim().length()>0){
				MotivoCreacion motivoCreacion = new MotivoCreacion(item);
				resp.add(motivoCreacion);
			}else
				break;
		return resp;
	}//getMotivosCreacion
	
	private List<ListHelper> getCodigoTelf(String[] filas){
		List<ListHelper> resp = new ArrayList<ListHelper>();
		Set<CodigoTelf> codigoTelfs = new HashSet<CodigoTelf>();
		if(filas!=null)
		for(String item:filas)
			if(item!=null && item.trim().length()>0){
				CodigoTelf codigoTelf = new CodigoTelf(item);
				if(codigoTelfs.add(codigoTelf))
					resp.add(codigoTelf);
			}else
				break;
		
		codigoTelfs = null;
		
		return resp;
	}//getCodigoTelf
	
	private List<ListHelper> getDescErrorCTExt(Set<String> codErrores){
		List<ListHelper> datos = new ArrayList<ListHelper>();
		ListHelper dato = null;
		String desc = "";
		
		RECMENSAJE recmensaje = new RECMENSAJE();
		for(String codError: codErrores){
			recmensaje.setCODMENSINP(BigDecimal.valueOf(Long.parseLong(codError)));

			try {
				invokeTrx(recmensaje);
			} catch (Exception e) {
				logger.error(e);
			}

			if(null == recmensaje.retrieveProgramCallException() && recmensaje.getReturnValue()==0){
				desc = recmensaje.getDESMENSOUT();

				if(null != desc){
					desc = desc.trim();
					dato = new ListHelper();
					dato.setId(codError);
					dato.setValue(desc);
					datos.add(dato);
				}
			}
		}
		
		return datos;
		
	}//getDescError
	
	public void cargarCombos(){
		if(combos.getMapas().size()==0 || combos.getListas().size()==0){
		
		/*
		 * Map<String, Object> textos = new HashMap<String,Object>(); try {
		 * java.io.FileInputStream unURL = new
		 * java.io.FileInputStream(getThreadLocalRequest().getRealPath("/") +
		 * "package.properties");
		 * 
		 * Properties unPo = new Properties(); unPo.load(unURL);
		 * 
		 * Enumeration cod = unPo.propertyNames();
		 * 
		 * while (cod.hasMoreElements()) { String key = (String)
		 * cod.nextElement(); textos.put(key, unPo.getProperty(key)); }
		 * unURL.close(); }catch(Throwable e){
		 * System.out.println("No se puede leer archivo de configuracion");
		 * e.printStackTrace(); }
		 */

		// Objeto sesión para recuperar valores posteriormente desde el lado del
		// cliente
//		HttpSession sessionObj = getThreadLocalRequest().getSession();

		// NCODIG
		// TIEM 1 - Tipo de empresa por nombre
		// TACT 1 - Código de industria por nombre
		// TACT 2 - Actividad empresa por nombre
		// TCIU 1 - Provincias por nombre
		// TCIU 3 - Ciudades por nombre
		// TCEC 1 - Cédulas emitidas en el extrajero
		// TBAN 1 - Tipo de banca por nombre
		// TDBA 1 - Canal de atención por nombre
		// REFE 1 - Referencias bancarias
		// TPAR 1 - Tipos de parentezco
		// TLEC 1 - Lugar para envío de correspondencia
		// SIEG 1 - Estado del grupo económico
		// FACT 1 - Factor de integración por nombre
		// SIGR 1 - Código del grupo económico
		// TTVI 1 - Tipo de vivienda por nombre
		// ESTC 1 - Tipo de estado civil
		// PROF 1 - Profesión por nombre
		// SECT 1 - Tipo de sectorización
		// SECT 2 - Tipo de subsectorización
		// TPRO 1 - Motivo creación por parte del cliente
		// TACT 1 - Actividad económica por nombre
		// TACT 2 - Línea de negocio
		// CONJ 1 - Tipo de entidad por nombre
		// TINE 1 - Tipo nivel de educación
		// TCEL 1 - Operadora celular

		// CNOFC
		// 4 - Fuentes de ingresos
		// 6 - Cargos por nombre funcionarios
		// C - Paises por nombre
		// ; - Relación de vinculación por nombre
		// 2 - Referido por nombre
		// O - Oficina por nombres de funcionarios
		// 5 - Nivel de riesgo
		// 3 - Nivel de educación
		// 8 - Institución financiera

		// estado civil, motivo creación, canal atención, tipo banca, separación
		// bienes, provincias,
		// operadora celular, paises, nivel riesgo, nivel educación,
		// fuentes ingresos, sectorización, profesión
		Map<String, String> valores = new HashMap<String, String>();
		Map<String, String> valoresi = new HashMap<String, String>();
		
		//sectorización i (separado por repetidos)
		Map<String, String> valoresSECTi = new HashMap<String, String>();
		//profesión i (separado por repetidos)
		Map<String, String> valoresPROFi = new HashMap<String, String>();
		
		//tipo de banca
		Map<String, String> valorestb = new HashMap<String, String>();
		Map<String, String> valorestbi = new HashMap<String, String>();
		//canal de atención
		Map<String, String> valoresca = new HashMap<String, String>();
		Map<String, String> valorescai = new HashMap<String, String>();
		
		// Valores adicionales
		// tipo empleo, estado grupo económico, tipo entidad, cargos
		// representantes legales, relación vinculación
		Map<String, String> valoresa = new HashMap<String, String>();
		//relación vinculación i (separado por repetidos)
		Map<String, String> valoresaiRelVin = new HashMap<String, String>();

		// subsectorización, código de industria, y para descripción adicional
		Map<String, String> valorese = new HashMap<String, String>();
		Map<String, String> valoresei = new HashMap<String, String>();
		// oficiales
		Map<String, String> valoresof = new HashMap<String, String>();
		Map<String, String> valoresofi = new HashMap<String, String>();
		// Referencias para personas naturales
		Map<String, String> valoresn = new HashMap<String, String>();
		Map<String, String> valoresni = new HashMap<String, String>();
		// Referencias para personas jurídicas
		Map<String, String> valoresj = new HashMap<String, String>();
		Map<String, String> valoresji = new HashMap<String, String>();
		// Tipo de vivienda
		Map<String, String> valoresv = new HashMap<String, String>();
		Map<String, String> valoresvi = new HashMap<String, String>();
		// Estados de Documentos
		Map<String, String> valoresd = new HashMap<String, String>();
		Map<String, String> valoresdi = new HashMap<String, String>();

		Map<String, String> valoresriesgo = new HashMap<String, String>();
		Map<String, String> valoresriesgoi = new HashMap<String, String>();

		// Criterio para call center
		Map<String, String> valorescc = new HashMap<String, String>();
		// Criterio para activación
		Map<String, String> valoresac = new HashMap<String, String>();
		
		// subsectorización, código de industria, y para descripción adicional
		Map<String, String> valoresrc = new HashMap<String, String>();
		Map<String, String> valoresrci = new HashMap<String, String>();
		
		// MNT_1294_1 ER. catalogo nacionalidades
		Map<String, String> nacionalidades = new HashMap<String, String>();
		
		// Estado Civil
		List<String> listec = new ArrayList<String>();
		CATAYUNCG catayuncg = new CATAYUNCG();

		// valor trivial
		valores.put("", "");
		valoresi.put("", "");
		valoresa.put("", "");
		valoresai.put("", "");
		valoresSECTi.put("", "");
		valoresPROFi.put("", "");

		// estado civil
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("ESTC");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}
		
		String strKeyAi = "";
		
		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata = catayuncg.getCANDATAOUT().getNCGDETALLE();

			for (int j = 0; j <= ncgoutdata.length - 1; j++) {
				//if (!ncgoutdata[j].equals("")) {
				if(ncgoutdata[j].length() != 0) {
					String[] data = ncgoutdata[j].split("[|]");
					valores.put(data[5].trim(), data[0].trim());
					strKeyAi = data[0].trim();
					if(!valoresi.containsKey(strKeyAi))
					valoresi.put(strKeyAi, data[5].trim());
					else
						logger.debug("repetido valoresi ESTC:"+strKeyAi+";");

					listec.add(data[5].trim());
				}
			}
		} else {
			listec.add("");
		}

		// descripción de estado civil en la impresión

		// Motivo de creación
		List<String> listmc = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGTABLA("CCLI");
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(3));
		catayuncg.getCANDATAINP().setNCGCODIGO1("CCAT");
		catayuncg.getCANDATAINP().setNCGCODIGO2("TPRO");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata1 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata1.length - 1; j++) {
				//if (!ncgoutdata1[j].equals("")) {
				if(ncgoutdata1[j].length() != 0) {
					String[] data = ncgoutdata1[j].split("[|]");
					valores.put(data[5].trim(), data[2].trim());
					strKeyAi = data[2].trim();
					if(!valoresi.containsKey(strKeyAi))
					valoresi.put(strKeyAi, data[5].trim());
					else
						logger.debug("repetido valoresi TPRO:"+strKeyAi+";");
					listmc.add(data[5].trim());
					// MG20110425
					valorescc.put(data[5].trim(), data[9].trim());
					valoresac.put(data[5].trim(), data[10].trim());
				}
			}
		} else {
			listmc.add("");
		}

		// Tipo de vivienda
		List<String> listtp = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("TTVI");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata2 = catayuncg.getCANDATAOUT().getNCGDETALLE();

			for (int j = 0; j <= ncgoutdata2.length - 1; j++) {
				//if (!ncgoutdata2[j].equals("")) {
				if(ncgoutdata2[j].length() != 0) {
					String[] data = ncgoutdata2[j].split("[|]");
					valoresv.put(data[5].trim(), data[0].trim());
					valoresvi.put(data[0].trim(), data[5].trim());

					listtp.add(data[5].trim());
				}
			}
		} else {
			listtp.add("");
		}

		// descripción de vivienda en la impresión

		// Canal de atención
		List<String> listca = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("TDBA");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}
		
		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata3 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata3.length - 1; j++) {
				//if (!ncgoutdata3[j].equals("")) {
				if(ncgoutdata3[j].length() != 0) {
					String[] data = ncgoutdata3[j].split("[|]");
					valoresca.put(data[5].trim(), data[0].trim());
					valorescai.put(data[0].trim(), data[5].trim());
					listca.add(data[5].trim());
				}
			}
		} else {
			listca.add("");
		}

		// Tipo Banca
		List<String> listtb = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("TBAN");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata4 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata4.length - 1; j++) {
				//if (!ncgoutdata4[j].equals("")) {
				if(ncgoutdata4[j].length() != 0) {
					String[] data = ncgoutdata4[j].split("[|]");
					valorestb.put(data[5].trim(), data[0].trim());
					valorestbi.put(data[0].trim(), data[5].trim());
					listtb.add(data[5].trim());
				}
			}
		} else {
			listtb.add("");
		}

		// Tipo referencias
		// Personas Naturales
		List<String> listtr = new ArrayList<String>();
		List<String> listtrj = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGCODIGO1("");
		catayuncg.getCANDATAINP().setNCGTABLA("REFE");
		
//		ConnAS.conectaAS400(catayuncg);
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata5 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata5.length - 1; j++) {
				//if (!ncgoutdata5[j].equals("")) {
				if(ncgoutdata5[j].length() != 0) {
					String[] data = ncgoutdata5[j].split("[|]");
					// MG20110331
					if (data[9].trim().equals("0")) {// ambos
						valoresn.put(data[5].trim(), data[0].trim());
						valoresni.put(data[0].trim(), data[5].trim());
						valoresj.put(data[5].trim(), data[0].trim());
						valoresji.put(data[0].trim(), data[5].trim());
						listtr.add(data[5].trim());
						listtrj.add(data[5].trim());
					}
					if (data[9].trim().equals("1")) { // jurídicos
						valoresj.put(data[5].trim(), data[0].trim());
						valoresji.put(data[0].trim(), data[5].trim());
						listtrj.add(data[5].trim());
					}
					if (data[9].trim().equals("2")) { // naturales
						valoresn.put(data[5].trim(), data[0].trim());
						valoresni.put(data[0].trim(), data[5].trim());
						listtr.add(data[5].trim());
					}
					// valoresn.put(data[5].trim(),data[0].trim());
					// valoresni.put(data[0].trim(),data[5].trim());
					// listtr.add(data[5].trim());
				}
			}
		} else {
			listtr.add("");
		}

		// Tipo de empleo
		List<String> listte = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("TIEM");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata6 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata6.length - 1; j++) {
				//if (!ncgoutdata6[j].equals("")) {
				if(ncgoutdata6[j].length() != 0) {
					String[] data = ncgoutdata6[j].split("[|]");
					valoresa.put(data[5].trim(), data[0].trim());
					// valoresai.put(data[0].trim()+ "E",data[5].trim());
					strKeyAi = data[0].trim();
					if(!valoresai.containsKey(strKeyAi))
					valoresai.put(strKeyAi, data[5].trim());
					else
						logger.debug("repetido valoresai TIEM:"+strKeyAi+";");
					listte.add(data[5].trim());
				}
			}
		} else {
			listte.add("");
		}

		// Tipo de separación de bienes
		List<String> listsb = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("TRBI");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata7 = catayuncg.getCANDATAOUT().getNCGDETALLE();

			for (int j = 0; j <= ncgoutdata7.length - 1; j++) {
				//if (!ncgoutdata7[j].equals("")) {
				if(ncgoutdata7[j].length() != 0) {
					String[] data = ncgoutdata7[j].split("[|]");
					valores.put(data[5].trim(), data[0].trim());
					strKeyAi = data[0].trim();
					if(!valoresi.containsKey(strKeyAi))
					valoresi.put(strKeyAi, data[5].trim());
					else
						logger.debug("repetido valoresi TRBI:"+strKeyAi+";");

					listsb.add(data[5].trim());
				}
			}
		} else {
			listsb.add("");
		}

		// descripción de relación de bienes en la impresión

		// Estado documentos
		List<String> listed = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("ESTD");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata8 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata8.length - 1; j++) {
				//if (!ncgoutdata8[j].equals("")) {
				if(ncgoutdata8[j].length() != 0) {
					String[] data = ncgoutdata8[j].split("[|]");
					valoresd.put(data[5].trim(), data[0].trim());
					valoresdi.put(data[0].trim(), data[5].trim());
					listed.add(data[5].trim());
				}
			}
		} else {
			listed.add("");
		}

		// Provincias
		List<String> listpr = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("TCIU");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata9 = catayuncg.getCANDATAOUT().getNCGDETALLE();

			for (int j = 0; j <= ncgoutdata9.length - 1; j++) {
				//if (!ncgoutdata9[j].equals("")) {
				if(ncgoutdata9[j].length() != 0) {
					String[] data = ncgoutdata9[j].split("[|]");
					valores.put(data[5].trim(), data[0].trim());
					strKeyAi = data[0].trim();
					if(!valoresi.containsKey(strKeyAi))
					valoresi.put(strKeyAi, data[5].trim());
					else
						logger.debug("repetido valoresi TCIU:"+strKeyAi+";");

					listpr.add(data[5].trim());
				}
			}
		} else {
			listpr.add("");
		}
		
		
		/********/
		// CT20102014 
				List<String> listext = new ArrayList<String>();
				catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
				catayuncg.getCANDATAINP().setNCGTABLA("TCEC");
				
				try {
					invokeTrx(catayuncg);
				} catch (Exception e) {
					logger.error(e);
				}

				if (catayuncg.getReturnValue() == 0) {
					String[] ncgoutdata20 = catayuncg.getCANDATAOUT().getNCGDETALLE();

					for (int j = 0; j <= ncgoutdata20.length - 1; j++) {
						//if (!ncgoutdata9[j].equals("")) {
						if(ncgoutdata20[j].length() != 0) {
							String[] data = ncgoutdata20[j].split("[|]");
							valores.put(data[5].trim(), data[0].trim());
							strKeyAi = data[0].trim();
							if(!valoresi.containsKey(strKeyAi))
							valoresi.put(strKeyAi, data[5].trim());
							else
								logger.debug("repetido valoresi TCEC:"+strKeyAi+";");

							listpr.add(data[5].trim());
						}
					}
				} else {
					listpr.add("");
				}
		
		
		
		
		
		
		/*******/
		
		

		// descripción de provincia en la impresión

		// Sectorización
		List<String> listse = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("SECT");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata10 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata10.length - 1; j++) {
				if(ncgoutdata10[j].length() != 0) {
					String[] data = ncgoutdata10[j].split("[|]");
					valores.put(data[5].trim(), data[0].trim());
					strKeyAi = data[0].trim();
					if(!valoresSECTi.containsKey(strKeyAi))
						valoresSECTi.put(strKeyAi, data[5].trim());
					else
						logger.debug("repetido valoresi SECT:"+strKeyAi+";");
					listse.add(data[5].trim());
				}
			}
		} else {
			listse.add("");
		}

		// SubSectorización
		List<String> listss = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(2));
		catayuncg.getCANDATAINP().setNCGTABLA("SECT");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata16 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata16.length - 1; j++) {
				//if (!ncgoutdata16[j].equals("")) {
				if(ncgoutdata16[j].length() != 0) {
					String[] data = ncgoutdata16[j].split("[|]");
					valorese.put(data[5].trim(), data[0].trim());
					valoresei.put(data[0].trim(), data[5].trim());
					listss.add(data[5].trim());
				}
			}
		} else {
			listss.add("");
		}

		// Profesión
		List<String> listpf = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("PROF");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata11 = catayuncg.getCANDATAOUT().getNCGDETALLE();

			for (int j = 0; j <= ncgoutdata11.length - 1; j++) {
				//if (!ncgoutdata11[j].equals("")) {
				if(ncgoutdata11[j].length() != 0) {
					String[] data = ncgoutdata11[j].split("[|]");
					valores.put(data[5].trim(), data[0].trim());
					strKeyAi = data[0].trim();
					if(!valoresPROFi.containsKey(strKeyAi))
						valoresPROFi.put(strKeyAi, data[5].trim());
					else
						logger.debug("repetido valoresPROFi PROF:"+strKeyAi+";");

					listpf.add(data[5].trim());
				}
			}
		} else {
			listpf.add("");
		}
		
		//Propósito de la relación comercial
		//Nuevo campo pedido por la SBS
		//MG20121029
		List<String> listpc = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("PROR");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata16 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata16.length - 1; j++) {
				//if (!ncgoutdata16[j].equals("")) {
				if(ncgoutdata16[j].length() != 0) {
					String[] data = ncgoutdata16[j].split("[|]");
					valoresrc.put(data[5].trim(), data[0].trim());
					valoresrci.put(data[0].trim(), data[5].trim());
					listpc.add(data[5].trim());
				}
			}
		} else {
			listpc.add("");
		}

		// descripción de profesión en la impresión

		// Código de industria
		List<String> listci = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("TACT");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata12 = catayuncg.getCANDATAOUT().getNCGDETALLE();

			for (int j = 0; j <= ncgoutdata12.length - 1; j++) {
				//if(!ncgoutdata12[j].equals("")) {
				if(ncgoutdata12[j].length() != 0) {
					String[] data = ncgoutdata12[j].split("[|]");
					valorese.put(data[5].trim(), data[0].trim());
					valoresei.put(data[0].trim(), data[5].trim());

					listci.add(data[5].trim());
				}
			}
		} else {
			listci.add("");
		}

		// descripción de la línea de negocio en la impresión

		/*
		 * //actividad empresa List listae = new ArrayList();
		 * catayuncg.getCANDATAINP().setNCGNIVEL(new BigDecimal(2));
		 * catayuncg.getCANDATAINP().setNCGTABLA("TACT");
		 * 
		 * int k=0; do { try { catayuncg.getAS400Object().validateSignon(); }
		 * catch (AS400SecurityException e) { logger.error(e); break; } catch
		 * (IOException e) { logger.error(e); break; } catayuncg.invoke(); k++;
		 * } while (!catayuncg.getAS400Object().isConnected() && k<3);//si está
		 * desconectado o intenta hasta 3 veces
		 * 
		 * if(catayuncg.getReturnValue() == 0){ String[] ncgoutdata15 =
		 * catayuncg.getCANDATAOUT().getNCGDETALLE(); for(int j=0;j <=
		 * ncgoutdata15.length -1; j++){ if(!ncgoutdata15[j].equals("")){
		 * String[] data = ncgoutdata15[j].split("[|]");
		 * valorese.put(data[5].trim(),data[0].trim());
		 * valoresei.put(data[0].trim(),data[5].trim());
		 * listae.add(data[5].trim()); } } }else{ listae.add(""); }
		 */
		// Opción si/no
		List<String> listsn = new ArrayList<String>();
		listsn.add("SI");
		listsn.add("NO");

		// Prefijos telefónicos
//		Set<String> listct = new TreeSet<String>();
		List<String> listct =  new ArrayList<String>();

		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("TCIU");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata13 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			String strCod = "";
			for (int j = 0; j <= ncgoutdata13.length - 1; j++) {
				//if (!ncgoutdata13[j].equals("")) {
				if(ncgoutdata13[j].length() != 0) {
					String[] data = ncgoutdata13[j].split("[|]");
					strCod = "0".concat(data[6].trim());
					//evita repetidos
					if(!listct.contains(strCod))
						listct.add(strCod);
				}
			}
		} else {
			listct.add("");
		}
		
		//ordena la lista
		Collections.sort(listct);

		// Nacionalidad
		List<String> listna = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGCODIGO1("TB04");
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(2));
		catayuncg.getCANDATAINP().setNCGTABLA("TSUP");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}
		
		String strKeyNi = "";

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata14 = catayuncg.getCANDATAOUT().getNCGDETALLE();

			for (int j = 0; j <= ncgoutdata14.length - 1; j++) {
				//if (!ncgoutdata14[j].equals("")) {
				if(ncgoutdata14[j].length() != 0) {
					String[] data = ncgoutdata14[j].split("[|]");
					valoresn.put(data[5].trim(), data[1].trim());
					nacionalidades.put(data[1].trim(), data[5].trim());
					strKeyNi = data[1].trim();
					if(!valoresni.containsKey(strKeyNi))
					valoresni.put(strKeyNi, data[5].trim());
					else
						logger.debug("repetido valoresni TSUP:"+strKeyNi+";");
					
					listna.add(data[5].trim());

				}
			}
		} else {
			listna.add("");
		}

		// descripción de nacionalidad en la impresión

		// Paises
		List<String> listpa = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGCODIGO1("TB05");
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(2));
		catayuncg.getCANDATAINP().setNCGTABLA("TSUP");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata14 = catayuncg.getCANDATAOUT().getNCGDETALLE();

			for (int j = 0; j <= ncgoutdata14.length - 1; j++) {
				//if (!ncgoutdata14[j].equals("")) {
				if(ncgoutdata14[j].length() != 0) {
					String[] data = ncgoutdata14[j].split("[|]");
					valores.put(data[5].trim(), data[1].trim());
					strKeyAi = data[1].trim();
					if(!valoresi.containsKey(strKeyAi))
					valoresi.put(strKeyAi, data[5].trim());
					else
						logger.debug("repetido valoresi TSUP TB05:"+strKeyAi+";");

					listpa.add(data[5].trim());
				}
			}
		} else {
			listna.add("");
		}

		// de pais en la impresión

		// Riesgo
		catayuncg.getCANDATAINP().setNCGCODIGO1("RIECAL");
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("CALI");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata14 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata14.length - 1; j++) {
				//if (!ncgoutdata14[j].equals("")) {
				if(ncgoutdata14[j].length() != 0) {
					String[] data = ncgoutdata14[j].split("[|]");
					valoresriesgo.put(data[5].trim(), data[0].trim());
					valoresriesgoi.put(data[0].trim(), data[5].trim());
				}
			}
		}

		// Código Grupo Económico
		List<String> listce = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("SIGR");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata17 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata17.length - 1; j++) {
				//if (!ncgoutdata17[j].equals("")) {
				if(ncgoutdata17[j].length() != 0) {
					String[] data = ncgoutdata17[j].split("[|]");
					valoresn.put(data[5].trim(), data[0].trim());
					strKeyNi = data[0].trim();
					if(!valoresni.containsKey(strKeyNi))
					valoresni.put(strKeyNi, data[5].trim());
					else
						logger.debug("repetido valoresni SIGR:"+strKeyNi+";");
					
					listce.add(data[5].trim());
				}
			}
		} else {
			listce.add("");
		}

		// Estado Grupo Económico
		List<String> listeg = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("SIEG");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}
		
		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata18 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata18.length - 1; j++) {
				//if (!ncgoutdata18[j].equals("")) {
				if(ncgoutdata18[j].length() != 0) {
					String[] data = ncgoutdata18[j].split("[|]");
					valoresa.put(data[5].trim(), data[0].trim());
					strKeyAi = data[0].trim();
					if(!valoresai.containsKey(strKeyAi))
					valoresai.put(strKeyAi, data[5].trim());
					else
						logger.debug("repetido valoresai SIEG:"+strKeyAi+";");
					listeg.add(data[5].trim());
				}
			}
		} else {
			listeg.add("");
		}

		// Factor de integración
		List<String> listft = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("FACT");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata19 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata19.length - 1; j++) {
				//if (!ncgoutdata19[j].equals("")) {
				if(ncgoutdata19[j].length() != 0) {
					String[] data = ncgoutdata19[j].split("[|]");
					valoresn.put(data[5].trim(), data[0].trim());
					strKeyNi = data[0].trim();
					if(!valoresni.containsKey(strKeyNi))
					valoresni.put(strKeyNi, data[5].trim());
					else
						logger.debug("repetido valoresni FACT:"+strKeyNi+";");
					
					listft.add(data[5].trim());
				}
			}
		} else {
			listft.add("");
		}

		// Tipo de entidad
/*		List<String> listtn = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("CONJ");
		
		ConnAS.conectaAS400(catayuncg);//PCH06062012

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata20 = catayuncg.getCANDATAOUT().getNCGDETALLE();

			for (int j = 0; j <= ncgoutdata20.length - 1; j++) {
				//if (!ncgoutdata20[j].equals("")) {
				if(ncgoutdata20[j].length() != 0){
					String[] data = ncgoutdata20[j].split("[|]");
					valoresa.put(data[5].trim(), data[0].trim());
					strKeyAi = data[0].trim();
					if(!valoresai.containsKey(strKeyAi))
					valoresai.put(strKeyAi, data[5].trim());
					else
						logger.debug("repetido valoresai CONJ:"+strKeyAi+";");

					listtn.add(data[5].trim());
				}
			}
		} else {
			listtn.add("");
		}
*/
		// descripción de tipo de entidad en la impresión

		// Tipo de operadora de telefonía celular
		List<String> listoc = new ArrayList<String>();
		catayuncg.getCANDATAINP().setNCGNIVEL(BigDecimal.valueOf(1));
		catayuncg.getCANDATAINP().setNCGTABLA("TCEL");
		
//		ConnAS.conectaAS400(catayuncg);//PCH06062012
		try {
			invokeTrx(catayuncg);
		} catch (Exception e) {
			logger.error(e);
		}

		if (catayuncg.getReturnValue() == 0) {
			String[] ncgoutdata21 = catayuncg.getCANDATAOUT().getNCGDETALLE();
			for (int j = 0; j <= ncgoutdata21.length - 1; j++) {
				//if (!ncgoutdata21[j].equals("")) {
				if(ncgoutdata21[j].length() != 0) {
					String[] data = ncgoutdata21[j].split("[|]");
					valores.put(data[5].trim(), data[0].trim());
					valoresi
							.put(data[0].trim().substring(0, 3), data[5].trim());
					listoc.add(data[5].trim());
				}
			}
		}
		
		catayuncg = null;

		CATAYUCNF catayucnf = new CATAYUCNF();

		// Cargos de representantes legales
		List<String> listcg = new ArrayList<String>();

		//catayucnf.setConnectionData(as400);//PCH06062012

		catayucnf.getCACDATAINP().setCNFCODIGO("6");
		
//		ConnAS.conectaAS400(catayucnf);//PCH06062012
		try {
			invokeTrx(catayucnf);
		} catch (Exception e) {
			logger.error(e);
		}

		String[] ncfoutdata = catayucnf.getCACDATAOUT().getCNFDETALLE();

		for (int j = 0; j <= ncfoutdata.length - 1; j++) {
			//if (!ncfoutdata[j].equals("")) {
			if(ncfoutdata[j].length() != 0) {
				String[] data = ncfoutdata[j].split("[|]");
				valoresa.put(data[1].trim(), data[0].trim());
				strKeyAi = data[0].trim();
				if(!valoresai.containsKey(strKeyAi))
				valoresai.put(strKeyAi, data[1].trim());
				else
					logger.debug("repetido valoresai CNFC 6:"+strKeyAi+";");

				listcg.add(data[1].trim());
			}
		}

		// descripción de los cargos en la impresión

		// Ayuda para paises
		/*
		 * List listpa = new ArrayList();
		 * catayucnf.getCACDATAINP().setCNFCODIGO("C");
		 * 
		 * k=0; do { try { catayucnf.getAS400Object().validateSignon(); } catch
		 * (AS400SecurityException e) { logger.error(e); break; } catch
		 * (IOException e) { logger.error(e); break; } catayucnf.invoke(); k++;
		 * } while (!catayucnf.getAS400Object().isConnected() && k<3);//si está
		 * desconectado o intenta hasta 3 veces
		 * 
		 * String[] ncfoutdata2 = catayucnf.getCACDATAOUT().getCNFDETALLE();
		 * for(int j=0;j <= ncfoutdata2.length -1; j++){
		 * if(!ncfoutdata2[j].equals("")){ String[] data =
		 * ncfoutdata2[j].split("[|]");
		 * valores.put(data[1].trim(),data[0].trim());
		 * valoresi.put(data[0].trim(),data[1].trim());
		 * listpa.add(data[1].trim()); } }
		 */

		// Nivel riesgo
		List<String> listnv = new ArrayList<String>();
		catayucnf.getCACDATAINP().setCNFCODIGO("5");

//		ConnAS.conectaAS400(catayucnf);
		try {
			invokeTrx(catayucnf);
		} catch (Exception e) {
			logger.error(e);
		}
		
		String[] ncfoutdata3 = catayucnf.getCACDATAOUT().getCNFDETALLE();
		for (int j = 0; j <= ncfoutdata3.length - 1; j++) {
			//if (!ncfoutdata3[j].equals("")) {
			if(ncfoutdata3[j].length() != 0) {
				String[] data = ncfoutdata3[j].split("[|]");
				valores.put(data[1].trim(), data[0].trim());
				strKeyAi = data[0].trim();
				if(!valoresi.containsKey(strKeyAi))
				valoresi.put(strKeyAi, data[1].trim());
				else
					logger.debug("repetido valoresi CNF 5:"+strKeyAi+";");
				listnv.add(data[1].trim());
			}
		}

		// Oficiales
		List<String> listof = new ArrayList<String>();
		catayucnf.getCACDATAINP().setCNFCODIGO("O");
		
//		ConnAS.conectaAS400(catayucnf);//PCH06062012
		try {
			invokeTrx(catayucnf);
		} catch (Exception e) {
			logger.error(e);
		}
		
/*//PCH06062012
		k = 0;
		do {
			try {
				catayucnf.getAS400Object().validateSignon();
			} catch (AS400SecurityException e) {
				logger.error(e);
				break;
			} catch (IOException e) {
				logger.error(e);
				break;
			}
			catayucnf.invoke();
			k++;
		} while (!catayucnf.getAS400Object().isConnected() && k < 3);// si está
																		// desconectado
																		// o
																		// intenta
																		// hasta
																		// 3
																		// veces
*/
		String[] ncfoutdata4 = catayucnf.getCACDATAOUT().getCNFDETALLE();
		for (int j = 0; j <= ncfoutdata4.length - 1; j++) {
			//if (!ncfoutdata4[j].equals("")) {
			if(ncfoutdata4[j].length() != 0) {
				String[] data = ncfoutdata4[j].split("[|]");
				valoresof.put(data[1].trim(), data[0].trim());
				valoresofi.put(data[0].trim(), data[1].trim());
				listof.add(data[1].trim());
			}
		}

		// Nivel de educación
		List<String> listne = new ArrayList<String>();
		catayucnf.getCACDATAINP().setCNFCODIGO("3");
		
//		ConnAS.conectaAS400(catayucnf);//PCH06062012
		try {
			invokeTrx(catayucnf);
		} catch (Exception e) {
			logger.error(e);
		}

		String[] ncfoutdata5 = catayucnf.getCACDATAOUT().getCNFDETALLE();

		for (int j = 0; j <= ncfoutdata5.length - 1; j++) {
			//if (!ncfoutdata5[j].equals("")) {
			if(ncfoutdata5[j].length() != 0) {
				String[] data = ncfoutdata5[j].split("[|]");
				valores.put(data[1].trim(), data[0].trim());
				strKeyAi = data[0].trim();
				if(!valoresi.containsKey(strKeyAi))
				valoresi.put(strKeyAi, data[1].trim());
				else
					logger.debug("repetido valoresi CNF 3:"+strKeyAi+";");

				listne.add(data[1].trim());
			}
		}

		// descripción de nivel de eduación en la impresión

		// Fuente de ingresos
		List<String> listfi = new ArrayList<String>();
		catayucnf.getCACDATAINP().setCNFCODIGO("4");
		
//		ConnAS.conectaAS400(catayucnf);//PCH06062012
		try {
			invokeTrx(catayucnf);
		} catch (Exception e) {
			logger.error(e);
		}

		String[] ncfoutdata6 = catayucnf.getCACDATAOUT().getCNFDETALLE();

		for (int j = 0; j <= ncfoutdata6.length - 1; j++) {
			//if (!ncfoutdata6[j].equals("")) {
			if(ncfoutdata6[j].length() != 0) {
				String[] data = ncfoutdata6[j].split("[|]");
				valores.put(data[1].trim(), data[0].trim());
				strKeyAi = data[0].trim();
				if(!valoresi.containsKey(strKeyAi))
				valoresi.put(strKeyAi, data[1].trim());
				else
					logger.debug("repetido valoresi CNF 4:"+strKeyAi+";");

				listfi.add(data[1].trim());
			}
		}

		// descripción de fuente de ingresos en la impresión

		// Relación vinculación
/*		List<String> listrv = new ArrayList<String>();
		catayucnf.getCACDATAINP().setCNFCODIGO(";");
		
		ConnAS.conectaAS400(catayucnf);//PCH06062012

		String[] ncfoutdata7 = catayucnf.getCACDATAOUT().getCNFDETALLE();
		for (int j = 0; j <= ncfoutdata7.length - 1; j++) {
			//if (!ncfoutdata7[j].equals("")) {
			if(ncfoutdata7[j].length() != 0) {
				String[] data = ncfoutdata7[j].split("[|]");
				valoresa.put(data[1].trim(), data[0].trim());
				strKeyAi = data[0].trim();
				if(!valoresaiRelVin.containsKey(strKeyAi))
					valoresaiRelVin.put(strKeyAi, data[1].trim());
				else
					logger.debug("repetido valoresaiRelVin CNFC ;:"+strKeyAi+";");
				listrv.add(data[1].trim());
			}
		}
*/
		// Inst. Financiera
/*		List<String> listif = new ArrayList<String>();
		catayucnf.getCACDATAINP().setCNFCODIGO("8");
		
		ConnAS.conectaAS400(catayucnf);

		String[] ncfoutdata8 = catayucnf.getCACDATAOUT().getCNFDETALLE();

		for (int j = 0; j <= ncfoutdata8.length - 1; j++) {
			//if (!ncfoutdata8[j].equals("")) {
			if(ncfoutdata8[j].length() != 0) {
				String[] data = ncfoutdata8[j].split("[|]");
				valoresn.put(data[1].trim(), data[0].trim());
				valoresni.put(data[0].trim(), data[1].trim());

				listif.add(data[1].trim());
			}
		}
*/
		catayucnf = null;
		
		// descripción de institución financiera en la impresión

		// combos.put("TEXTOS", textos );
		
		Map<String,List<String>> mlistas = combos.getListas();

		mlistas.put("TCEL", listoc);
		mlistas.put("SIGR", listce);
		mlistas.put("SIEG", listeg);
		mlistas.put("FACT", listft);
		mlistas.put("SSEC", listss);
		mlistas.put("NACI", listna);
		mlistas.put("TACT", listci);
		mlistas.put("FUEN", listfi);
		mlistas.put("ESTC", listec);
		mlistas.put("TTVI", listtp);
		mlistas.put("TPRO", listmc);
		mlistas.put("TDBA", listca);
		mlistas.put("TBAN", listtb);
		mlistas.put("SINO", listsn);
		mlistas.put("REFE", listtr);
		mlistas.put("REFEJ", listtrj);
		mlistas.put("SECT", listse);
		mlistas.put("CARG", listcg);
		mlistas.put("ESTD", listed);
		mlistas.put("TIEM", listte);
		mlistas.put("TCIU", listct);
		mlistas.put("TRBI", listsb);
		mlistas.put("PAIS", listpa);
		mlistas.put("TCIUP", listpr);
		mlistas.put("TCEC", listext);
		mlistas.put("NIVE", listnv);
		mlistas.put("OFIC", listof);
		mlistas.put("EDUC", listne);
		mlistas.put("PROF", listpf);
		mlistas.put("PROR", listpc);
				
		Map<String,Map<String,String>> mMapas = combos.getMapas();

		mMapas.put("VALORES", valores);
		mMapas.put("VALORESI", valoresi);
		
		mMapas.put("VALORESSECTI", valoresSECTi);
		mMapas.put("VALORESPROFI", valoresPROFi);
		
		//MG20121029
		mMapas.put("VALORESPROR", valoresrc);
		mMapas.put("VALORESPRORI", valoresrci);
		
		mMapas.put("VALORESTB", valorestb);
		mMapas.put("VALORESTBI", valorestbi);
		
		mMapas.put("VALORESCA", valoresca);
		mMapas.put("VALORESCAI", valorescai);		

		mMapas.put("VALORESV", valoresv);
		mMapas.put("VALORESVI", valoresvi);

		mMapas.put("VALORESA", valoresa);
		mMapas.put("VALORESAI", valoresai);
		
		mMapas.put("VALORESAIRELVIN", valoresaiRelVin);

		mMapas.put("VALORESE", valorese);
		mMapas.put("VALORESEI", valoresei);

		mMapas.put("VALORESN", valoresn);
		mMapas.put("VALORESNI", valoresni);

		mMapas.put("VALORESJ", valoresj);
		mMapas.put("VALORESJI", valoresji);

		mMapas.put("VALORESCC", valorescc);
		mMapas.put("VALORESAC", valoresac);

		mMapas.put("VALORESD", valoresd);
		mMapas.put("VALORESDI", valoresdi);

		mMapas.put("VALORESRIESGO", valoresriesgo);
		mMapas.put("VALORESRIESGOI", valoresriesgoi);

		mMapas.put("VALORESOF", valoresof);
		mMapas.put("VALORESOFI", valoresofi);
		// MNT_1294_1 ER. carga nuevo catalogo nacionalidades
		mMapas.put("NACIONALIDADES", nacionalidades);

		// HttpSession sessionObj = getThreadLocalRequest().getSession();
		// sessionObj.setAttribute("valores", combos);
		// sessionObj.setAttribute("cargos", valoresai); // Para recuperar
														// descripción de cargos
														// en la impresión de
														// cliente jurídico

		logger.debug("combos cargados");
		
		//ConnectionAS.desconectar(as400);//PCH06062012
	}
//		return combos;
	}//cargarCombos

	/**
	 * @return the combos
	 */
	public static ObjCombo getCombos() {
		return combos;
	}

	/**
	 * @return the valoresai
	 */
	public static Map<String, String> getValoresai() {
		return valoresai;
	}
	
}//fin de la clase
