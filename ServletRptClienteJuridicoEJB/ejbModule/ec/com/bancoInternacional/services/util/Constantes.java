package ec.com.bancoInternacional.services.util;

/**
 * Autor: Sandro Guevara
 * Objetivo:	Clase de constantes comunes de negocio
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */
public final class Constantes {
	// Constantes booleanos
	public final static String CONST_BOOLEANOS_S = "S";
	public final static String TIDN_TABLA_CATALOGO = "TSRI";
	public final static String TIDN_NIVEL = "3";
	public final static String TIDN_NIVEL_1 = "GENA";
	public final static String TIDN_NIVEL_2 = "TIDN";
	public final static String TIDN_NIVEL_3 = "12";

	// Parametros para catalogos de tipo de persona
	public final static String DIVA_TABLA_CATALOGO = "DIVA";
	public final static String DIVA_NIVEL = "2";
	public final static String DIVA_NIVEL_2 = "02";
	public final static String DIVA_NIVEL_3 = "02";

	// Parametros para catalogos de paises y CCLI
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

	// Common constants
	public final static String BOOLEAN_VERDADERO_FLAG = "SI";
	public final static String BOOLEAN_VERDADERO_FLAG2 = "S";
	public final static String BOOLEAN_FALSO_FLAG = "NO";
	public final static String BOOLEAN_FALSO_FLAG2 = "N";

	// Parametros para catalogos de cantones
	public final static String CANTON_TABLA_CATALOGO = "TCIU";
	public final static String CANTON_NIVEL_1 = "1";
	public final static String CANTON_NIVEL_2 = "2";

	// Constantes para consulta de programa de Clientes, cada atributo
	// representa un valor en el mapa con la información de Cliente
	// Codigo de error, respuesta de programa CONCLIENTE
	public final static String ERROR_CODE = "ERRORCD";
	// Respuesta de error, respuesta de programa CONCLIENTE
	public final static String ERROR_DESC = "ERRDSC";
	// Cedula clave
	public final static String CEDULA = "CEDULA";
	// TIPO
	public final static String TIPO = "TIPO";
	// Oficial principal
	public final static String CUSOFC = "CUSOFC";
	// Oficial Secundario
	public final static String CUSOF2 = "CUSOF2";

	// Identificacion de cliente
	public static final String CUSIDN = "CUSIDN";
	// Nombre Completo de Cliente
	public static final String CUSNA1 = "CUSNA1";
	// Codigo ibs del cliente
	public static final String CUSCUN = "CUSCUN";
	// Codigo de motivo de creacion
	public static final String COCMOT = "COCMOT";
	// Descripcion motivo
	public static final String COCMAC = "COCMAC";
	// riesgo cliente
	public static final String RIESGO = "RIESGO";
	// Primer apellido del cliente
	public static final String CUSLN1 = "CUSLN1";

	// Segundo apellido del cliente
	public static final String CUSLN2 = "CUSLN2";
	// Nombres del cliente
	public static final String CUSFNA = "CUSFNA";
	// Sexo
	public static final String CUSSEX = "CUSSEX";
	// Nacionalidad
	public static final String CUSCCS = "CUSCCS";
	// Pais de origen
	public static final String CUSCOB = "CUSCOB";
	// Fecha nacimiento conyugue
	public static final String CUIBCYMDC = "CUIBCYMDC";
	// Usuarios
	public static final String CUIFAC = "CUIFAC";
	// Usuario creador
	public static final String CUIUSR = "CUIUSR";
	// Usuario Creador
	public static final String USUCREADOR = "USUCREADOR";
	// Usuario Ciudad
	public static final String USUARIOCIUDAD = "USUARIOCIUDAD";
	// Constantes para horas de contacto del cliente
	public static final String CUIHTD = "CUIHTD";
	public static final String CUIHTH = "CUIHTH";
	public static final String CUIHDD = "CUIHDD";
	public static final String CUIHDH = "CUIHDH";

	// Campos SBS
	public final static String CUIPRC = "CUIPRC";
	public final static String CUIDOM = "CUIDOM";
	public final static String CUSBDYMD = "CUSBDYMD";
	// Tipo de Vivienda
	public final static String CUIVIV = "CUIVIV";
	// Estado civil
	public final static String CUSMST = "CUSMST";
	// Relacion de bienes
	public final static String CUIDI1 = "CUIDI1";
	// Direcciones
	public final static String DIRECCION_CLIENTE_TRABAJO = "CUMMAND2";

	public final static String DIRECCION_EXTRANJERO_RESIDENCIA = "DirExtRes";
	public static final String DIRECCION_EXTRANJERO_TELEFONO = "DirExtTel";
	public static final String DIRECCION_EXTRANJERO_CORRESPONDENCIA = "DirExtCor";
	public static final String ERROR_PARAMETRIZACION = "Existe un error con la parametrizacion de Codigo de Extranjeria";
	public static final String ERROR_EJECUCION = "Existe un error en la ejecucion del Proceso de Codigo de Extranjeria";

	public final static String RELACION_COMERCIAL_TABLA = "CCLI";
	public final static String RELACION_COMERCIAL_NIVEL = "3";
	public final static String RELACION_COMERCIAL_COD1 = "CCAT";
	public final static String RELACION_COMERCIAL_COD2 = "TPRO";
	public final static String RELACION_COMERCIAL_NCVAL3 = "1";

	public final static String SERVICIO_VINCULACION_TABLA = "PROR";
	public final static String SERVICIO_VINCULACION_NIVEL = "1";

	public final static String PARROQUIA_TABLA = "TCIU";
	public final static String PROVINCIA_NIVEL = "1";
	public final static String PARROQUIA_NIVEL = "4";

	public final static String SEXO_TABLA = "SEXO";
	public final static String SEXO_NIVEL = "1";

	public final static String PROFESION_TABLA = "PROF";
	public final static String PROFESION_NIVEL = "1";

	public final static String CLASIFICACION_TABLA = "TSRI";
	public final static String CLASIFICACION_NIVEL = "2";
	public final static String CLASIFICACION_COD1 = "TCTY";

	public final static String NACIONALIDAD_TABLA = "CCLI";
	public final static String NACIONALIDAD_NIVEL = "3";
	public final static String NACIONALIDAD_COD1 = "CCAT";
	public final static String NACIONALIDAD_COD2 = "PAIS";

	public final static String EST_CIVIL_TABLA = "ESTC";
	public final static String EST_CIVIL_NIVEL = "1";
	// Parametrizacion de Codigo de Extranjeria
	public static final String CCLI_NIVEL_PCDE = "PCDE";
	public static final String CCLI_PCDE_HORA = "HORA";
	public static final String CCLI_PCDE_UBICACION_ARCHIVO_ENTRADA = "UBIE";
	public static final String CCLI_PCDE_UBICACION_ARCHIVO_SALIDA = "UBIR";
	public static final String CCLI_PCDE_UBICACION_MAIL = "MAIL";
	public static final String CCLI_PCDE_UBICACION_CARACTERES_SEPARACION = "CARA";
	public static final String CCLI_PCDE_UBICACION_CODIGO_PROCESO = "COPR";

	// Clientes informacion adicional
	public static final String CONCLIE_ADI_CLATIP = "CLATIP";
	public static final String CONCLIE_ADI_CLASEC = "CLASEC";
	public static final String CONCLIE_ADI_CLATDO = "CLATDO";
	public static final String CONCLIE_ADI_CLAREF = "CLAREF";
	public static final String CONCLIE_ADI_CLAUSC = "CLAUSC";
	public static final String CONCLIE_ADI_CLAHOC = "CLAHOC";
	public static final String CONCLIE_ADI_CLAFEC = "CLAFEC";
	public static final String CONCLIE_ADI_CLAPRC = "CLAPRC";
	public static final String CONCLIE_ADI_CLAUSM = "CLAUSM";
	public static final String CONCLIE_ADI_CLAHOM = "CLAHOM";
	public static final String CONCLIE_ADI_CLAFEM = "CLAFEM";
	public static final String CONCLIE_ADI_CLAPRM = "CLAPRM";

	// Codigo Extranjeria adicional
	public static final String CONCLIE_ADI_CUEIDN = "CUEIDN";
	public static final String CONCLIE_ADI_CUESTS = "CUESTS";
	public static final String CONCLIE_ADI_CUECUN = "CUECUN";
	public static final String CONCLIE_ADI_CUEINP = "CUEINP";
	public static final String CONCLIE_ADI_CUEOUT = "CUEOUT";
	public static final String CONCLIE_ADI_CUEUSC = "CUEUSC";
	public static final String CONCLIE_ADI_CUEHOC = "CUEHOC";
	public static final String CONCLIE_ADI_CUEFEC = "CUEFEC";
	public static final String CONCLIE_ADI_CUEPRC = "CUEPRC";
	public static final String CONCLIE_ADI_CUEUSM = "CUEUSM";
	public static final String CONCLIE_ADI_CUEHOM = "CUEHOM";
	public static final String CONCLIE_ADI_CUEFEM = "CUEFEM";
	public static final String CONCLIE_ADI_CUEPRM = "CUEPRM";

	// codigos tipo persona
	public final static String PERSONA_NATURAL = "2";
	public final static String PERSONA_JURIDICA = "1";

	// bloqueo/desbloqueo de cliente
	public final static String PERSONA_NATURAL_BLOQUEO = "NAT";
	public final static String PERSONA_JURIDICA_BLOQUEO = "JUR";

	public final static String ACT_ECONOMICA_NIVEL1 = "1";
	public final static String ACT_ECONOMICA_NIVEL2 = "2";
	public final static String ACT_ECONOMICA_NIVEL3 = "3";
	public final static String ACT_ECONOMICA_NIVEL4 = "4";
	public final static String ACT_ECONOMICA_NIVEL5 = "5";
	public final static String ACT_ECONOMICA_NIVEL6 = "6";
	
	//Codigos internacional
	public final static String CODIGO_INTERNACIONAL_ECUADOR= "+593";
	public final static String CODIGO_PEP_SI= "S";
	public final static String CODIGO_PEP_NO= "N";
	
	public final static String CODIGO_OPERADORA_CLARO = "POR";
	public final static String CODIGO_OPERADORA_MOVISTAR = "MOV";
	public final static String CODIGO_OPERADORA_CNT = "ALE";
	
	public final static String CODIGO_OPERADORA_CLARO_COD = "PORT";
	public final static String CODIGO_OPERADORA_MOVISTAR_COD = "MOVI";
	public final static String CODIGO_OPERADORA_CNT_COD = "ALEG";
	
	public final static String CODIGO_NOTIFICACION_SI= "SI";
	public final static String CODIGO_NOTIFICACION_NO= "NO";
	
	public final static String CODIGO_NOTIFICACION_FATCA_SI= "S";
	public final static String CODIGO_NOTIFICACION_FATC_NO= "N";
	public final static String FORMATO_FECHA_CONVERTIR_CON_DIA_SEMANA="EEEEE dd MMMMM yyyy";
	public final static String FORMATO_FECHA_CONVERTIR_SIN_DIA_SEMANA="d 'de' MMMM 'del' yyyy";
	public final static String ADJUNTAR_IMAGENES_SI = "SI";
	public final static String ADJUNTAR_IMAGENES_NO = "NO";
	public final static String IMPRESION = "IMPRESION";
	public final static String REIMPRESION = "REIMPRESION";
	public final static String MENSAJE_ENVIO_CORREO_ERROR = "<b>NO</b> fue <b>enviado</b> al correo electrónico:";
	public final static String MENSAJE_ENVIO_CORREO_CORRECTO = "fue <b>enviado</b> al correo electrónico:";
	public final static String NOTIFICACION_ENVIADA = "E";
	public final static String NOTIFICACION_NO_ENVIADA = "X";
	public final static String NOTIFICACION_PENDIENTE = "P";
	public final static String NOMBRE_PROCESO = "CS0020";
	public final static String MENSAJE_NOTIFICACION_NO_TIENE_ESTADO = "Cliente no tiene estado Notificaci&oacute;n";
	public final static String MENSAJE_NOTIFICACION_PROCESO_ESPERA = "Su Solicitud esta siendo procesada...";
	public final static String ENVIO_EXITOSO = "ENVIO EXITOSO";
	public final static String ENVIO_NO_EXITOSO = "<span style='color:red'>ENVIO <b>NO</b> EXITOSO</span>";
	public final static String COLOR_TEXTO = "rgb(42, 111, 202)";
	public final static String MENSAJE_ADVERTENCIA = "<span style='color:red'><b>&#161;Advertencia&#33; </b></span>";
	public final static String SIN_CORREOS_REPRESENTANTES = "No existen correos registrados";
	public final static String MENSAJE_NO_ENVIO_CORREO_POR_FALTA_CORREO = "<b>NO</b> fue <b>enviado</b>:";
	
	//Reporte Certificacion - Normativa CRS
	public static final String PAIS_ECUADOR = "EC";
	public static final String CERTIFICACION_TIPO_BENEFICIARIO = "BEN";
	public static final String CERTIFICACION_TIPO_EMPRESA = "EMP";
	public final static String CERTIFICACION_DECLARA_IMPUESTOS_EXT_SI="SI";
	public final static String CERTIFICACION_DECLARA_IMPUESTOS_EXT_NO="NO";
	public static final String CODIGO_ACCESO_KEY = "codigoAcceso";
	
	//Envio de correo
	public final static String CODIGO_CORREO_PARA_NOTIFICACION_UNO = "1";
	public final static String CODIGO_CORREO_PARA_NOTIFICACION_DOS = "2";

}