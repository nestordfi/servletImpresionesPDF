package ec.com.bancoInternacional.ConsultaBastanteo.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class FormatoUtil {
	private static DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance();
	private static DecimalFormat primerFormatoNumero = new DecimalFormat("###0.00");
	
	private static DecimalFormat df4 = new DecimalFormat("0000");
	private static DecimalFormat df2 = new DecimalFormat("00");
	
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
	
	public static String eliminarCerosDeLaIzquierdaEnPasaporte(String pasaporte) {
		if(StringUtils.isBlank(pasaporte)) {
			return null;
		}
		return pasaporte.replaceFirst("^0+(?!$)", "");
	}
	
	public static Double convertirTextoPrimerFormatoNumeroHaciaDecimal(String numeroEnTexto) {
		
		Double numero = new Double(0.0);
		
		if(null == numeroEnTexto || numeroEnTexto.isEmpty()) {
			return numero;
		}
		
		decimalFormatSymbols.setDecimalSeparator('.');
		primerFormatoNumero.setDecimalFormatSymbols(decimalFormatSymbols);

		try {
			numero = primerFormatoNumero.parse(numeroEnTexto).doubleValue();
		} catch (ParseException e) {
			numero = new Double(0.0);
			e.printStackTrace();
		}
		
		return numero;
		
	}
	
	public static String obtenerFechaToString(Date date) {  
		if (date == null) {
			return "";
		}
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
         return dateFormat.format(date);  
	}
}
