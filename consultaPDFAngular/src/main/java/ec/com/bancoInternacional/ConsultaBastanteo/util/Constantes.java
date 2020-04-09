package ec.com.bancoInternacional.ConsultaBastanteo.util;

public class Constantes {
	//Constantes Varios
		public final static String RUC_TIPO_ID="R";
		public final static String PASAPORTE_TIPO_ID="B";
		public final static String PASAPORTE_TIPO_ID_P="P";
		
	
	// Parametros para catalogo tipo de identificacion "TSRI", "3", "GENA", "TIDN", "12", "   
		public final static String TIDN_CATALOG_TABLE="TSRI";
		public final static String TIDN_LEVEL="3";
		public final static String TIDN_1_LEVEL="GENA";
		public final static String TIDN_2_LEVEL="TIDN";
		public final static String TIDN_3_LEVEL="12";
		// Parametros para maximo porcentaje accionista   
		public final static String PCJ_ACC_CATALOG_TABLE="CCLI";
		public final static String PCJ_ACC_LEVEL="3";
		public final static String PCJ_ACC_1_LEVEL="CCAT";
		public final static String PCJ_ACC_2_LEVEL="VLID";
		public final static String PCJ_ACC_3_LEVEL="VLFT";
		// Parametros para catalogo concepto "'CCLI'", "3", "CCAT", "BLEG", "CDOC", "   
		public final static String CONCEPT_CATALOG_TABLE="CCLI";
		public final static String CONCEPT_LEVEL="3";
		public final static String CONCEPT_1_LEVEL="BLEG";
		public final static String CONCEPT_2_LEVEL="CDOC";
		//Parametros para catalogo cargos de responsable "GPER", "1"
		public final static String CARGOS_CATALOG_TABLE="GPER";
		public final static String CARGOS_CATALOG_LEVEL="1";
		public final static String CARGOS_CATALOG_TABLE_REP_LEGAL="CCLI";
		public final static String CARGOS_CATALOG_CODIGO_UNO_REP_LEGAL="CCAT";
		public final static String CARGOS_CATALOG_CODIGO_DOS_REP_LEGAL="CARG";
		public final static String CARGOS_CATALOG_CODIGO_TRES__INDEPENDIENTE_REP_LEGAL="CIND";
		public final static String CARGOS_CATALOG_CODIGO_TRES__DEPENDIENTE_REP_LEGAL="CDEP";
		public final static String CARGOS_CATALOG_LEVEL_REP_LEGAL="4";
		//Parametros para catalogo - CANTONES
		public final static String CANTONES_CATALOG_KEY="CANTONES_CATALOG";
		//Parametros para catalogo - PROVINCIA
		public final static String COD_PROVINCIA_CATALOG_KEY="CODIGOS_PROVINCIA_CATALOG";
		public final static String COD_PROVINCIA_TABLA = "TCIU";
		public final static String COD_PROVINCIA_NIVEL = "1";
		//Parametros para catalogo - NACIONALIDAD
		public final static String NACIONALIDAD_KEY="NACIONALIDAD_CATALOG";
		// Parametros para catalogo - TIPO DE PERSONA	
		public final static String PERSON_TYPE_CATALOG_KEY="PERSON_TYPE_CATALOG";
		// Parametros para catalogo - Agencia
		public final static String PCJ_ACC_CATALOG="PCJ_ACC_CATALOG";
		// Parametros para catalogo - Agencia
		public final static String CLASIFICACION_CATALOG="CLASIFICACION_CATALOG";
		// Parametros para catalogo - Agencia
		public final static String FUNCIONARIOS_CATALOG="FUNCIONARIOS_CATALOG";
		// Parametros para maximo porcentaje Accionistas
		public final static String AGENCIA_CATALOG="AGENCIA_CATALOG";
		// Parametros para catalogo - CONCEPTO DOCUMENTOS EXAMINADOS
		public final static String FUNCIONARIOS_RESPONSABLES_CATALOG="FUNCIONARIOS_RESPONSABLES_CATALOG";
		public final static String CONCEPT_CATALOG_KEY="CONCEPT_CATALOG";
		// Parametros para catalogo - canal
		public final static String INFO_ADICIONAL_CANAL_NIVEL = "4";
		public final static String INFO_ADICIONAL_BANCA_COD1 = "CCAT";
		public final static String INFO_ADICIONAL_BANCA_COD2 = "TBCA";
		public final static String INFO_ADICIONAL_BANCA_TABLA = "CCLI";
		public final static String INFO_ADICIONAL_CANAL_CATALOG_KEY="INFO_ADICIONAL_CANAL_CATALOG";
		// Parametros para catalogo - Cargos
		public final static String CARGOS_RESPONSABLE_CATALOG_KEY="CARGOS_RESPONSABLE_CATALOG_KEY";
		public final static String CARGO_TABLA = "CCLI";
		public final static String CARGO_NIVEL = "4";
		public final static String CARGO_COD1 = "CCAT";
		public final static String CARGO_COD2 = "CARG";
		public final static String CARGO_DEPENDIENTE_COD3 = "CDEP";
		public final static String CARGO_INDEPENDIENTE_COD3 = "CIND";
		//Parametros para catalogos de tipo de persona
		public final static String DIVA_CATALOG_TABLE="DIVA";
		public final static String DIVA_LEVEL="2";
		public final static String DIVA_1_LEVEL="02";
		public final static String DIVA_2_LEVEL="02";
		public final static String CODIGO_CARGOS="6";
		public final static String CLIENT_MASTER_GROUP=" ";
		//Parametros para catalogos de tipo de persona
		public final static String CLASIFICACION_CATALOG_TABLE="TSRI";
		public final static String CLASIFICACION_LEVEL="2";
		public final static String CLASIFICACION_1_CODIGO="TCTY";
		//Catalogos pais
		public final static String COUNTRIES_CATALOG_KEY="COUNTRIES_CATALOG";	
		//Catalogos cargo
		public final static String CARGOS_CATALOG_KEY="CARGOS_CATALOG";
		//Catalogos tipo de id
		public final static String ID_TYPE_CATALOG_KEY="ID_TYPE_CATALOG";
		//CCLI PAISES
		public final static String PAIS_CATALOG_TABLE="CCLI";
		public final static String CCLI_TABLA_CATALOGO = "CCLI";
		public final static String CCLI_NIVEL = "3";
		public final static String CCLI_NIVEL_HIJO = "4";
		public final static String CCLI_NIVEL_1 = "CCAT";
		public final static String PAIS_NIVEL_2 = "PAIS";
		public final static String PAIS_PARAMETRO_PADRE = "PARENT_PARAMETER";
		public final static String PAIS_PARAMETRO_HIJO = "CHILD_PARAMETER";
		public final static String PAIS_PARAMETRO_OBJETO = "BEAN_PARAMETER";
		public final static String PAIS_CATALOGO_FATCA = "FATC";
		public final static String PAIS_RIESGO_CATALOGO = "ALRI";
		public final static String PAIS_PREFIJO_CATALOGO = "PRFI";
		public final static String NIVEL_CARGOS_AS400 = "4";
		public final static String TABLA_CARGOS_AS400 = "CCLI";
		// Common constants
		public final static String BOOLEAN_VERDADERO_FLAG = "SI";
		public final static String BOOLEAN_VERDADERO_FLAG2 = "S";
		// catologo - cantones
		public final static String CANTON_TABLA_CATALOGO = "TCIU";
		public final static String CANTON_NIVEL_1 = "1";
		public final static String CANTON_NIVEL_2 = "2";
		//catalogo - nacionalidad
		public final static String NACIONALIDAD_TABLA = "CCLI";
		public final static String NACIONALIDAD_NIVEL = "3";
		public final static String NACIONALIDAD_COD1 = "CCAT";
		public final static String NACIONALIDAD_COD2 = "PAIS";
		
		//Constantes utiles
		public final static int lineaUsuarioEncriptado = 2;
		public final static int lineaContrasenaEncriptado = 3;
		
		//Constantes Mensaje Error
		public final static String MENSAJE_ERROR_LOG4J_PROYECTO = "ConsultaBastanteoBI ERROR:";
		public final static String MENSAJE_INFO_LOG4J_PROYECTO = "ConsultaBastanteoBI INFO:";
		public final static String NO_ATURIZACION_VIA_HEADER = "NO SE HE REALIZADO CORRECTA LA AUTORIZACION AL SERVICIO";
		
		
}
