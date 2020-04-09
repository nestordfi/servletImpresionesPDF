package ec.com.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import ec.com.bancoInternacional.services.util.Util;

public class UtilTest {

	@Test
	public void testSubstring() {
		String texto="22587559";
		String esperado="2";
		
		String resultado = Util.substring(texto, 0, 1);
		Assert.assertEquals(esperado, resultado);
	}
	
	@Test
	public void testSubstringNull() {
		String texto=null;
		String esperado="";
		
		String resultado = Util.substring(texto, 0, 1);
		Assert.assertEquals(esperado, resultado);
	}
	
	@Test
	public void testSubstringVacio() {
		String texto="";
		String esperado="";
		
		String resultado = Util.substring(texto, 0, 1);
		Assert.assertEquals(esperado, resultado);
	}

}
