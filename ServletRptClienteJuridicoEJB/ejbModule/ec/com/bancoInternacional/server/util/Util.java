package ec.com.bancoInternacional.server.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ec.com.bancoInternacional.server.config.LoadInitInfo;
import ec.com.bancoInternacional.shared.beans.ListHelper;

public class Util {
	
	/** El df4. */
	private static DecimalFormat df4 = null;
	
	/** El df2. */
	private static DecimalFormat df2 = null;

	/** El df6. */
	private static DecimalFormat df6 = null;
	
	/** El df8. */
	private static DecimalFormat df8 = null;
	
	private static SimpleDateFormat sdf8 = null;
	
	private static SimpleDateFormat sdfIso = null;
	
	private static DecimalFormat df2d = null;
	
	private static DecimalFormatSymbols dfs;
	
	static{
		df2 = new DecimalFormat("00");
		df4 = new DecimalFormat("0000");
		df6 = new DecimalFormat("000000");
		df8 = new DecimalFormat("00000000");
		sdf8 = new SimpleDateFormat("yyyyMMdd");
		sdfIso = new SimpleDateFormat("yyyy-MM-dd");
		dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		dfs.setGroupingSeparator(',');
		df2d = new DecimalFormat("#0.00",dfs);
	}

	/**
	 * Date web.
	 * 
	 * @param date el date
	 * 
	 * @return the string
	 */
	public static String dateWeb(String date) {
		if(date.trim().length() < 8)
			return "";
		return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
	}

	/**
	 * Date web.
	 * 
	 * @param date el date
	 * @param tipo el tipo
	 * 
	 * @return the string
	 */
	public static String dateWeb(String date, int tipo) {
		if(tipo==0)
			return dateWeb(date);
		if(tipo==1)//pasa de ddmmaaa a aaaa-mm-dd
		return date.substring(4,8) + "-" + date.substring(2,4) + "-" + date.substring(0,2);
		else
			return "";
	}

	/**
	 * Date web.
	 * 
	 * @param aaaa el aaaa
	 * @param mm el mm
	 * @param dd el dd
	 * 
	 * @return the string
	 */
	public static String dateWeb(BigDecimal aaaa, BigDecimal mm, BigDecimal dd) {
		String strFecha = "";
		strFecha = df4.format(aaaa.longValue()) + "-"
				+ df2.format(mm.longValue()) + "-" + df2.format(dd.longValue());
		return strFecha;
	}

	/**
	 * Date web.
	 * 
	 * @param ddmmaa el ddmmaa
	 * 
	 * @return the string
	 */
	public static String dateWeb(BigDecimal ddmmaa) {
		String strFecha = "";
		int anioRD = 0;
		strFecha = df6.format(ddmmaa.longValue());
		anioRD = Integer.parseInt(strFecha.substring(4));
		strFecha = String.valueOf(anioRD+((anioRD>70 && anioRD<100)?1900:2000))+"-"+strFecha.substring(2,4)+"-"+strFecha.substring(0,2);
		return strFecha;
	}
	
	/**
	 * Time web.
	 * 
	 * @param hhmm el hhmm
	 * 
	 * @return the string
	 */
	public static String timeWeb(BigDecimal hhmm) {
		String strHora = "00:00";
		
		if(null!=hhmm){
			strHora = String.valueOf(hhmm.longValue());
			if(strHora.length()>2){
				int h = Integer.parseInt(strHora.substring(0, 2));
				if(h>24){
					if(strHora.length()>3)
						strHora = "0".concat(strHora.substring(0, 3));
					else
						strHora = "0".concat(strHora);
				}else{
					if(strHora.length()>4){
						strHora = strHora.substring(0, 4);
					}else{
						strHora = df4.format(hhmm.longValue());
					}
				}
			}else
				strHora = df4.format(hhmm.longValue());
			
			strHora = strHora.substring(0,2)+":"+strHora.substring(2,4);	
		}
		
		return strHora;
	}
	
	/**
	 * Valida y completa el formato de una fecha
	 * @param String date
	 * @return String fecha formateada aaaaMMdd
	 */
	public static String dateWeb8(String date){
		String fecha = null;
		int aMin = 50;//años 2000
		int aMax = 100;//años 1900

		if(null!=date){
			date = date.replaceAll("[\\D]", "");
			if(date.length()>0){
				date = df8.format(Integer.parseInt(date));

				int a = Integer.parseInt(date.substring(0, 4));
				int m = Integer.parseInt(date.substring(4, 6));
				int d = Integer.parseInt(date.substring(6));

				if(m>12){//fecha puede ser ddMMaaaa
					a = Integer.parseInt(date.substring(4));
					m = Integer.parseInt(date.substring(2, 4));
					d = Integer.parseInt(date.substring(0, 2));
				}

				if(m>0&&d>0){
					if(a<=aMin)
						a+=2000;

					if(a>aMin&&a<aMax)
						a+=1900;

					fecha = String.valueOf(a).concat(df2.format(m)).concat(df2.format(d));
				}
			}
		}

		return fecha;
	}//dateWeb8
	
	
	/**
	 * Retorna el valor en milisegundos de una fecha aaaaMMdd
	 * @param date
	 * @return String fecha en milisegundos
	 */
	public static String dateWebT(String date){
		String fecha = null;

		if(null!=date){
			fecha = dateWeb8(date);//valida formato
			
			if(null!=fecha){
				int a = Integer.parseInt(fecha.substring(0, 4));
				int m = Integer.parseInt(fecha.substring(4, 6));
				int d = Integer.parseInt(fecha.substring(6));
				Calendar cal = Calendar.getInstance();
				cal.set(a,m-1,d);
				fecha = String.valueOf(cal.getTimeInMillis());
				cal=null;
			}
		}

		return fecha;
	}//dateWebT
	
	
	/**
	 * Retorna una fecha formateada de su valor en milisegundos recibido como string
	 * @param date
	 * @return String fecha formato aaaaMMdd
	 */
	public static String dateWebT8(String date){
		String fecha = null;

		if(null!=date){
			Date aDate = new Date(Long.parseLong(date));
			fecha = sdf8.format(aDate);
			aDate = null;
		}

		return fecha;
	}//dateWebT8
	
	/**
	 * Retorna una fecha formateada de su valor en milisegundos recibido como string
	 * @param date
	 * @return String fecha formato aaaa-MM-dd
	 */
	public static String dateWebTIso(String date){
		String fecha = null;

		if(null!=date){
			Date aDate = new Date(Long.parseLong(date));
			fecha = sdfIso.format(aDate);
			aDate = null;
		}

		return fecha;
	}//dateWebTIso
	
	/**
	 * Retorna el valor en milisegundos de una fecha aaaa,MM,dd
	 * @param BigDecimal aaaa, BigDecimal mm, BigDecimal dd
	 * @return String fecha en milisegundos
	 */
	public static String dateWebT(BigDecimal aaaa, BigDecimal mm, BigDecimal dd){
		String fecha = null;
		
		if(null!=aaaa && null!=mm && null!=dd){
			
			long a=0,m=0,d=0;
			
			if(null!=aaaa)
				a = aaaa.longValue();
			if(null!=mm)
				m = mm.longValue();
			if(null!=dd)
				d = dd.longValue();

			if(a>0 && m>0 && d>0)
				fecha=dateWebT(df4.format(a).concat(df2.format(m)).concat(df2.format(d)));
		}
		return fecha;
	}//dateWebT
	
	/**
	 * Retornar valor asociado con un id.
	 * 
	 * @param idLista con se identifica en los catálogos
	 * @param id el id buscado en la lista
	 * 
	 * @return the string
	 */
	public static String retornarValor(String idLista, String id) {
		String valor = null;
		List<ListHelper> lista = null;
		
		lista = LoadInitInfo.catalogos.getObjCatalogos().get(idLista);
		
		if (lista!=null) {
			for (ListHelper dato : lista) {
				if (dato.getId().equals(id)) {
					valor = dato.getValue();
					dato =  null;
					break;
				}
				dato =  null;
			}
		}
		
		lista = null;
		
		return valor;
	}//retornarValor
	
	/**
	 * Únicamente se permiten letras, números, ñ, Ñ y espacios; otros caracteres son eliminados
	 * incluyendo vocales con tilde. 
	 * @param texto
	 * @return String solo con caracteres permitidos.
	 */
	public static String validaCaracteres(String texto){
		String res = "";
		if(null!=texto && texto.length()>0)
			res = texto.replaceAll("[^a-zA-Z0-9ñÑ ]", "");
		
		return res;
	}//validaCaracteres
	
	/**
	 * Formatea una cadena numerica a un entero con dos decimales
	 * @param valor
	 * @return String número formateado
	 */
	public static String strDecimal2(String valor){
		double numero = 0;
		try{
			numero = Double.parseDouble(valor);
		}catch(Throwable e){;}
		
		return df2d.format(numero); 
	}
	
	/**
	 * Formatea un número decimal a un entero con dos decimales
	 * @param valor
	 * @return String número formateado
	 */
	public static String strDecimal2(double valor){
		return df2d.format(valor); 
	}
	
	/**
	 * Formatea un número BigDecimal a un entero con dos decimales
	 * @param valor
	 * @return String número formateado
	 */
	public static String strDecimal2(BigDecimal valor){
		if(null!=valor)
			return df2d.format(valor.doubleValue());
		return df2d.format(0);
	}
	
	/**
	 * Remplaza los caracteres distintos de números
	 * @param strNum
	 * @return String solo números
	 */
	public static String strNumero(String strNum){
		strNum = (strNum!=null)?strNum.replaceAll("(\\D)",""):"";
		return strNum;
	}//strNumeros
	
	public static String tipoTitulo (String texto){
		if(null == texto)
			return null;		
		String[] vtxt = texto.split("[ ]");
		String salida = "";
		for(String palabra : vtxt)
			if(palabra.length()>0){
				palabra = palabra.toLowerCase();
				salida = salida.concat(palabra.substring(0,1).toUpperCase()).concat(palabra.substring(1)).concat(" ");
			}
		
		vtxt = null;
		
		return salida.trim();
	}//tipoTitulo
	
	/**
	 * Rellenar vacios.
	 * 
	 * @param valor el valor
	 * @param tamano el tamano
	 * @param caracter el caracter
	 * 
	 * @return the string
	 */
	public static String rellenarVacios(String valor, int tamano, String caracter) {
		return rellenarVacios(valor,tamano,caracter, "R");
	}

	/**
	 * Rellenar vacios.
	 * 
	 * @param valor el valor
	 * @param tamano el tamano
	 * @param caracter el caracter
	 * @param orientacion el orientacion
	 * 
	 * @return the string
	 */
	public static String rellenarVacios(String valor, int tamano, String caracter, String orientacion) {
		String retorno = null;
		if (null==valor || valor.equals("noAplica")){
			retorno = "";
		} else {
			retorno = (valor.length()>tamano)?valor.substring(0, tamano):valor;
		}
		if(orientacion.equals("R") || orientacion.equals("L")) {
			for(int i=retorno.length(); i<tamano; i++) {
				if(retorno.length()<tamano) {
					if (orientacion.equals("R")) {
						retorno = retorno.concat(caracter);
					} else {
						retorno = caracter.concat(retorno);
					}
				} else {
					break;
				}
			}
		} else {
			throw new IllegalArgumentException("El valor de la orientacion debe ser R(Right) o L(Left).");
		}
		return retorno;
	}
	
	public static BigDecimal longToBD(String numero){
		BigDecimal bd = null;
		
		if(null != numero){
			numero = numero.replaceAll("\\D", "");
			
			if(numero.length()>0){
				bd = BigDecimal.valueOf(Long.parseLong(numero));
			}
		}
		
		numero = null;
		
		return bd;
	}//longToBD
	
	public static BigDecimal long11ToBD(String numero){
		BigDecimal bd = null;
		if(null != numero){
			if(numero.length()>11)
				numero = numero.substring(0, 11);
			
			bd = Util.longToBD(numero);
			
			if(null == bd){
				bd = BigDecimal.valueOf(0);
			}
			
		}else{
			bd = BigDecimal.valueOf(0);
		}
		return bd;
	}//long11ToBD

}//fin de la clase