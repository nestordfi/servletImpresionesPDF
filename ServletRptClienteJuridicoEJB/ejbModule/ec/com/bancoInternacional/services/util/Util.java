package ec.com.bancoInternacional.services.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ec.com.bancoInternacional.cs0133.DETERRO;

/**
 * Autor: Sandro Guevara
 * Objetivo:	Clase que encapsula utilitario de numeros
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */
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
		int aMin = 50;//a�os 2000
		int aMax = 100;//a�os 1900

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
	 * �nicamente se permiten letras, n�meros, �, � y espacios; otros caracteres son eliminados
	 * incluyendo vocales con tilde. 
	 * @param texto
	 * @return String solo con caracteres permitidos.
	 */
	public static String validaCaracteres(String texto){
		String res = "";
		if(null!=texto && texto.length()>0)
			res = texto.replaceAll("[^a-zA-Z0-9�� ]", "");
		
		return res;
	}//validaCaracteres
	
	/**
	 * Formatea una cadena numerica a un entero con dos decimales
	 * @param valor
	 * @return String n�mero formateado
	 */
	public static String strDecimal2(String valor){
		double numero = 0;
		try{
			numero = Double.parseDouble(valor);
		}catch(Throwable e){;}
		
		return df2d.format(numero); 
	}
	
	/**
	 * Formatea un n�mero decimal a un entero con dos decimales
	 * @param valor
	 * @return String n�mero formateado
	 */
	public static String strDecimal2(double valor){
		return df2d.format(valor); 
	}
	
	/**
	 * Formatea un n�mero BigDecimal a un entero con dos decimales
	 * @param valor
	 * @return String n�mero formateado
	 */
	public static String strDecimal2(BigDecimal valor){
		if(null!=valor)
			return df2d.format(valor.doubleValue());
		return df2d.format(0);
	}
	
	/**
	 * Remplaza los caracteres distintos de n�meros
	 * @param strNum
	 * @return String solo n�meros
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
	}
	
	/**
	 * Retorna una cadena con los mensajes de error al actualizar el estado del envio de correo.
	 * 
	 * @param codigoError <Codigo de error perteneciente a la lista>
	 * @param deterros <Lista de errores>
	 * 
	 * @return
	 */
	public static String mostrarMensajesDeErroEnElReenvioCorreo(BigDecimal codigoError, DETERRO[] deterros){
		String mensajeDeError = "";
		
		for( DETERRO datosDeError: deterros){
			if(datosDeError == null || datosDeError.equals("")){
				break;
			}
			
			if(datosDeError.getDETCODERRO() != null && !datosDeError.getDETCODERRO().equals("")){
				if(datosDeError.getDETCODERRO().equals(codigoError)){
					String mensajeUnitario = "Error: " + datosDeError.getDETCODERRO().toString() + 
							" Mensaje: " + datosDeError.getDETMENERRO(); 
					mensajeDeError = mensajeDeError + mensajeUnitario + ",";  
				}
			}
		}
		
		return mensajeDeError;
	}
	
	public static String substring(String texto, int inicio, int fin){
		if (null==texto){
			texto="";
		}
		if (texto.equals("")){
			return texto;
		}
		else{
			try {
				return texto.substring(inicio, fin);
			} catch (Exception e) {
				e.printStackTrace();
				return texto;
			}
		}
	}
	
	
	private static SimpleDateFormat primerFormatoFecha = new SimpleDateFormat("yyyyMMdd");
	
	public static String obtenerFechaToString(Date date) {  
	        if (date == null) {
	               return "";
	        }
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
	    return dateFormat.format(date);  
	  }

	public static Date convertirTextoHaciaPrimerFormatoFecha(String fechaEnTexto) {
        if(
                      ("".equals(fechaEnTexto) || null == fechaEnTexto) ||
                      8 != fechaEnTexto.length()
                      ) {
               return null;
        }
        Date date = null;
        try {
               date = primerFormatoFecha.parse(fechaEnTexto);//TODO probar error de parse
        } catch (ParseException e) {
               e.printStackTrace();
        }
        return date;
  }


}