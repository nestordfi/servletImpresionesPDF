package ec.com.bancoInternacional.view.util;
/**
 * Autor:		Carlos Carrera
 * Objetivo:	Clase de Constantes comunes para aplicacion web
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
 */
public  final class Constantes {
// Parametros para catalogo tipo de identificacion "TSRI", "3", "GENA", "TIDN", "12", "   
public final static String TIDN_CATALOG_TABLE="TSRI";
public final static String TIDN_LEVEL="3";
public final static String TIDN_1_LEVEL="GENA";
public final static String TIDN_2_LEVEL="TIDN";
public final static String TIDN_3_LEVEL="12";

//Parametros de longitud para numero de celulares
public final static long LONGITUD_MAXIMA=999999999;
public final static long LONGITUD_MINIMA=900000000;

public final static long LONGITUD_DOMICILIO_MAXIMA=9999999;
public final static long LONGITUD_DOMICILIO_MINIMA=1000000;

public final static int LONGITUD_MAXIMA_TELEFONOS=20;

public static final int TAMANIO_TELEFONOS_FIJOS_ECUADOR = 7;

//Parametros para catalogos de tipo de persona
public final static String DIVA_CATALOG_TABLE="DIVA";
public final static String DIVA_LEVEL="2";
public final static String DIVA_1_LEVEL="02";
public final static String DIVA_2_LEVEL="02";

//Parametros para catalogos de paises
public final static String PAIS_CATALOG_TABLE="CCLI";
public final static String PAIS_LEVEL="3";
public final static String PAIS_CHILD_LEVEL="4";
public final static String PAIS_1_LEVEL="CCAT";
public final static String PAIS_2_LEVEL="PAIS";
public final static String PAIS_PARENT_PARAMETER="PARENT_PARAMETER";
public final static String PAIS_CHILD_PARAMETER="CHILD_PARAMETER";
public final static String PAIS_BEAN_PARAMETER="BEAN_PARAMETER";

//Constantes para Colecciones de Catalogos dentro del mapa general de Constantes
public final static String PERSON_TYPE_CATALOG_KEY="PERSON_TYPE_CATALOG";
public final static String ID_TYPE_CATALOG_KEY="ID_TYPE_CATALOG";
public final static String TIPO_IDENTIFICACION_RC_KEY="ESTADO_CIVIL_CATALOG";
public final static String PAIS_RC_KEY="PAIS_RC_KEY";
public final static String DEPARTAMENTO_RC_KEY="DEPARTAMENTO_RC_KEY";
public final static String CIUDAD_RC_KEY="CIUDAD_RC_KEY";
public final static String COUNTRIES_CATALOG_KEY="COUNTRIES_CATALOG";
public final static String CLIENT_METADATA_KEY="CLIENT_DICTIONARY";
public final static String CLIENT_MASTER_GROUP=" ";
public final static String CANTONES_CATALOG_KEY="CANTONES_CATALOG";
public final static String INFORMACION_LABORAL_CATALOG_KEY="INFORMACION_LABORAL_CATALOG";
public final static String ACTIVIDAD_ECONOMICA_MAP_KEY="ACTIVIDAD_ECONOMICA_MAP";
public final static String CARGOS_CATALOG_KEY="CARGOS_CATALOG";
public final static String OFICIALES_CATALOG_KEY="OFICIALES_CATALOG";
public final static String NIVEL_EDUCACION_KEY="NIVEL_EDUCACION_CATALOG";
public final static String RELACION_LABORAL_CATALOG_KEY="RELACION_LABORAL_CATALOG";
public final static String PARAMETROS_GENERALES_CATALOG_KEY="PARAMETROS_GENERALES_CATALOG";
public final static String PARAMETROS_GENERALES_TRAN_CATALOG_KEY="PARAMETROS_GENERALES_INFORMACION_TRANSACCIONAL_CATALOG";
public final static String TIPO_DOMICILIO_CATALOG_KEY="TIPO_DOMICILIO_CATALOG";
public final static String CONDICION_VIVIENDA_CATALOG_KEY="CONDICION_VIVIENDA_CATALOG";
public final static String TIPO_OFICINA_CATALOG_KEY="TIPO_OFICINA_CATALOG";
public final static String TIPO_TELEFONO_CATALOG_KEY="TIPO_TELEFONO_CATALOG";
public final static String CORREOS_INVALIDOS_CATALOG_KEY="CORREOS_INVALIDOS_CATALOG";
public final static String COD_PROVINCIA_CATALOG_KEY="CODIGOS_PROVINCIA_CATALOG";
public final static String OPERADORA_CELULAR_CATALOG_KEY="OPERADORA_CELULAR_CATALOG";
public final static String PARROQUIAS_CATALOG_KEY="PARROQUIAS_CATALOG";
public final static String PROPOSITO_RELACION_COMERCIAL_CATALOG_KEY="PROPOSITO_RELACION_LABORAL_CATALOG";
public final static String SERVICIO_VINCULACION_CATALOG_KEY="SERVICIO_VINCULACION_CATALOG";
public final static String ID_CARGO_DEPENDIENTE_CATALOG_KEY="FUENTE_INGRESO_DEPENDIENTE_CATALOG";
public final static String ID_CARGO_INDEPENDIENTE_CATALOG_KEY="FUENTE_INGRESO_INDEPENDIENTE_CATALOG";

public final static String IP_LOCAL="IP_LOCAL";

public final static String SEXO_CATALOG_KEY="SEXO_CATALOG";
public final static String PROFESIONES_CATALOG_KEY="PROFESIONES_CATALOG";
public final static String CLASIFICACION_CATALOG_KEY="CLASIFICACION_CATALOG";
public final static String NACIONALIDAD_KEY="NACIONALIDAD_CATALOG";
public final static String ESTADO_CIVIL_KEY="ESTADO_CIVIL_CATALOG";

//Constantes Instituciones financieras
public final static String INST_FINANCIERAS_CATALOG_KEY="INST_FINANCIERAS_CATALOG";
public final static String INST_FINANCIERAS = "8";

public final static String INFO_ADICIONAL_CLASIFICACION_CATALOG_KEY="INFO_ADICIONAL_CLASIFICACION_CATALOG";
public final static String INFO_ADICIONAL_SECTOR_CATALOG_KEY="INFO_ADICIONAL_SECTOR_CATALOG";
public final static String INFO_ADICIONAL_SUBSECTOR_CATALOG_KEY="INFO_ADICIONAL_SUBSECTOR_CATALOG";
public final static String INFO_ADICIONAL_BANCA_CATALOG_KEY="INFO_ADICIONAL_BANCA_CATALOG";
public final static String INFO_ADICIONAL_CANAL_CATALOG_KEY="INFO_ADICIONAL_CANAL_CATALOG";
public final static String INFO_CUPO_CATALOG_KEY = "INFO_CUPO_CATALOG";
public final static String INFO_PARAMETRO_NUM_MESES = "INFO_PARAMETRO_NUM_MESES";

public final static String INFO_ADICIONAL_CLASIFICACION_TABLA = "TSRI";
public final static String INFO_ADICIONAL_CLASIFICACION_NIVEL = "2";
public final static String INFO_ADICIONAL_CLASIFICACION_COD1 = "TCTY";

public final static String INFO_ADICIONAL_SECTOR_TABLA = "SECT";
public final static String INFO_ADICIONAL_SECTOR_NIVEL = "1";
public final static String INFO_ADICIONAL_SUBSECTOR_NIVEL = "2";

public final static String INFO_ADICIONAL_BANCA_TABLA = "CCLI";
public final static String INFO_ADICIONAL_BANCA_NIVEL = "3";
public final static String INFO_ADICIONAL_CANAL_NIVEL = "4";
public final static String INFO_ADICIONAL_BANCA_COD1 = "CCAT";
public final static String INFO_ADICIONAL_BANCA_COD2 = "TBCA";
public final static String INFO_ADICIONAL_DEFAULT_BANCA_COMERCIAL = "RED";
public final static String INFO_ADICIONAL_DEFAULT_CANAL_PERSONA_NATURAL = "NGE";
public final static String INFO_ADICIONAL_DEFAULT_CANAL_JURIDICO_COMERCIAL = "JUR";

public final static String ESTADO_CIVIL_SOLTERO="1";
public final static String ESTADO_CIVIL_CASADO="2";
public final static String ESTADO_CIVIL_DIVORCIADO="3";
public final static String ESTADO_CIVIL_VIUDO="4";
public final static String ESTADO_CIVIL_COHABITANDO="5";

public final static String GENERO_MASCULINO="M";
public final static String GENERO_FEMENINO="F";


public final static String RELACION_LABORAL_LEVEL="RELA";

//Constantes para Manejo de Errores
public final static String CATALOG_MAP_ERROR="No se puede recuperar el mapa de catalogos";
public final static String FAILED_TO_RETRIEVE_DATA_ERROR="No se puede obtener datos desde el servidor:";

public final static String ERROR_VALIDACION_LUGAR_DOMICILIO_PAICES_SANCIONADOS= "Lugar de Domicilio.- Existe coincidencia con listado de 'Países Sancionados'";
public final static String ERROR_VALIDACION_INGRESO_NUMERO_TRABAJO= "No se ha ingresado un número del trabajo";
public final static String ERROR_VALIDACION_INGRESO_PISO_DOMICILIO= "No se ha ingresado un piso del domicilio";
public final static String ERROR_VALIDACION_INGRESO_NUMERO_DOMICILIO= "No se ha ingresado un número del domicilio";
public final static String ERROR_VALIDACION_LUGAR_DOMICILIO_INGRESO_OBLIGATORIO= "Lugar de DomicilioBarrio, campo de ingreso obligatorio";
public final static String ERROR_VALIDACION_LUGAR_DOMICILIO_REFERENCIA_INGRESO_OBLIGATORIO= "Lugar de Domicilio.- Referencia, campo de ingreso obligatorio";
public final static String ERROR_VALIDACION_ANIO_EMPEZO_RESIDIR= "El campo actual Años en residencia actual debe ser calculado en función del Año en que se crea o actualiza el cliente - el año en que empezó a residir.";
public final static String ERROR_VALIDACION_VALOR_VIVIENDA_OBLIGATORIO= "Si 'Tipo de Vivienda' es PROPIA, el campo 'Valor de la vivienda' es obligatorio y > 0 ";
public final static String ERROR_VALIDACION_ESPACIOS_EN_BLANCO="No ingresar espacios en blanco";
public final static String ERROR_VALIDACION_LUGAR_TARABJO_PAISES_SANCIONADOS= "Lugar de Trabajo.- Existe coincidencia con listado de 'Países Sancionados'";
public final static String ERROR_VALIDACION_LUGAR_TRABAJO_BARRIO_INGRESO_OBLIGATORIO= "Lugar de Trabajo.- Barrio, campo de ingreso obligatorio";
public final static String ERROR_VALIDACION_LUGAR_TARABAJO_REFERENCIA_CAMPO_OBLIGATORIO= "Lugar de Trabajo.- Referencia, campo de ingreso obligatorio";
public final static String ERROR_VALIDACION_DIRECCION_EXTERIOR_CAMPO_OBLIGATORIO= "Dirección en el Exterior.- Campos Obligatorios";
public final static String ERROR_VALIDACION_CORREO_ELECTRONICO_ERROR_VALIDACION= "Correo electrónico.- Error de Validación correo personal";
public final static String ERROR_VALIDACION_CORREO_VALIDACIÓN_CORREO_TRABAJO= "Correo electrónico.- Error de Validación correo de trabajo";
public final static String ERROR_VALIDACION_TOTAL_ACTIVOS= "Total de activos debe ser mayor a 0";
public final static String ERROR_VALIDACION_TOTAL_PASIVOS= "Total de pasivos debe ser mayor o igual a 0";
public final static String ERROR_VALIDACION_EGRESOS_MAYOR_INGRESO= "Egresos.- Error de Validación total de ingresos debe ser mayor a egresos ";

//Constantes de comparacion de eventos ajax
public final static String RUC_TYPE_ID="R";
public final static String CEDULA_TYPE_ID="C";
public final static String PASAPORTE_TYPE_ID="B";
public final static String PERSONA_NATURAL="2";
public final static String PERSONA_JURIDICA="1";
public final static String PAIS_ECUADOR="EC";
public final static String COD_INTERNACIONALIZACION_ECUADOR="+593";

//Constantes información básica de los clientes
public final static String IDENTIFIER_COUNTRY_ECUADOR = "Ecuador";

//Constantes información laboral
public final static String ERROR_VALIDACION_INF_LABORAL_SALIDA_TRAB_ANTERIOR_INGRESO_ACTUAL="Fecha Salida Trabajo Anterior<=Fecha Ingreso Trabajo Actual";
public final static String ERROR_VALIDACION_INF_LABORAL_INGRESO_SALIDA_TRAB_ANTERIOR="Fecha Ingreso Trabajo Anterior<=Fecha Termino Trabajo Anterior";
public final static String ERROR_VALIDACION_INF_LABORAL_FECHA_INGRESO_FECHA_ACTUAL="La 'Fecha de Ingreso en el Empleo Actual', debe ser una Fecha no mayor a la Fecha Actual";
public final static String ERROR_VALIDACION_INFORMACION_LABORAL_ACT_ECONOMICA="Error de validación, debe seleccionar la Actividad económica hasta el nivel Nro. 6";
public final static String CODIGO_CARGOS="6";
public final static String CODIGO_OFICIALES="O";
public final static String CODIGO_NIVEL_EDUCACION="3";
public final static String CLIENTE_INFORMACION_LABORAL_CARGO_OPCION1 = "Socio";
public final static String CLIENTE_INFORMACION_LABORAL_CARGO_OPCION1_CODIGO = "SOC";
public final static String CLIENTE_INFORMACION_LABORAL_CARGO_OPCION2 = "Propietario";
public final static String CLIENTE_INFORMACION_LABORAL_CARGO_OPCION2_CODIGO = "PPI";
public final static String CLIENTE_INFORMACION_LABORAL_RELACION_LABORAL_INDEPENDIENTE = "I";
public final static String CLIENTE_INFORMACION_LABORAL_RELACION_LABORAL_SIN_ACTIVIDAD_ECONOMICA = "S";
public final static String CLIENTE_INFORMACION_LABORAL_RELACION_LABORAL_DEPENDIENTE = "D";
public static final String CLIENTE_INFORMACION_LABORAL_NOMBRE_RELACION_LABORAL_INDEPENDIENTE = "IND";
public static final String CLIENTE_INFORMACION_LABORAL_NOMBRE_RELACION_LABORAL_DEPENDIENTE = "DEP";
public static final String CLIENTE_INFORMACION_LABORAL_NOMBRE_RELACION_LABORAL_SIN_ACTIVIDAD_ECONOMICA = "SAE";

//Parametros para parámetros generales
public final static String CCLI_CATALOG_TABLE = "CCLI";
public final static String PARAMETROS_LEVEL_ONE = "1";
public final static String PARAMETROS_LEVEL = "2";
public final static String PARAMETROS_COD1 = "PARG";
public final static String PARAMETROS_COD2_MONTO_MINIMO = "MONI";
public final static String PARAMETROS_COD2_EGRESOS_MENSUALES = "EGRM";
public final static String PARAMETROS_COD2_FRACCION_BASICA_DESGRAVADA = "FRBA"; 
public final static String PARAMETRO_NUMERO_MESES_CLIENTE_DEBE_ACTUALIZAR = "NMES";

//Constantes información financiera
public final static String CLIENTE_INFORMACION_FINANCIERA_NO_OBLIGADO_LLEVAR_CONTABILIDAD = "N";

public final static String ERROR_VALIDACION_INFORMACION_FINANCIERA_NOT_NULL_REL_LABORAL = "Debe seleccionar su relacion laboral";
public final static String ERROR_VALIDACION_INFORMACION_FINANCIERA_ACT_ECONOMICA = "Debe seleccionar la Actividad económica hasta el nivel Nro. 6";
public final static String ERROR_VALIDACION_INFORMACION_FINANCIERA_INGRESOS_MENSUALES = "Los Ingresos Mensuales deben ser mayores a ";
public final static String ERROR_VALIDACION_INFORMACION_FINANCIERA_NUMERO_MAXIMO = "deben ser menor a 99999999999.99";
public final static String ERROR_VALIDACION_INFORMACION_FINANCIERA_NUMERO_MAXIMO_SIN = "debe ser menor a 99999999999.99";
public final static String ERROR_VALIDACION_INFORMACION_FINANCIERA_ACT_ECONOMICA_VACIO = "Debe seleccionar una actividad economica secundaria si el cliente posee otros ingresos";
//public final static String ERROR_VALIDACION_INFORMACION_FINANCIERA_MAYOR_CERO = "El valor debe ser mayor a cero.";
public final static String ERROR_VALIDACION_INFORMACION_FINANCIERA_EGRESOMENDUAL_MAYOR_INGRESOMENSUAL = "Los Egresos mensuales NO deben ser mayor que los Ingresos Mensuales";
public final static String ERROR_VALIDACION_INFORMACION_FINANCIERA_EGRESOMENDUAL_MAYOR_CERO = "Los Egresos mensuales deben ser mayor que 0";
public final static String ERROR_VALIDACION_INFORMACION_FINANCIERA_FRACCION_BASICA_DESGRAVADA = "El cliente cumple con la condición de que éste se encuentra obligado a llevar contabilidad.";
public final static String ERROR_VALIDACION_INFORMACION_FINANCIERA_OTROS_INGRESOS_MENSUALES = "Catálogo Actividad Económica. Si Otros Ingresos Mensuales es diferente de cero, entonces el campo es obligatorio";

//Constantes de identificación
public final static String ERROR_VALIDACION_IDENTIFICACION_FEMICION_FVENCIMIENTO = "La 'Fecha de Emisión (Pasaporte)', debe ser una fecha no mayor a la 'Fecha de Vencimiento del Pasaporte'";
public final static String ERROR_VALIDACION_IDENTIFICACION_FACTUAL_FEMICION = "La 'Fecha de Emisión (Pasaporte)', debe ser una fecha no mayor a la Fecha Actual (de creación del cliente)";
public final static String ERROR_VALIDACION_IDENTIFICACION_FPASAPORTE_VENCIDO = "La 'Fecha de Vencimiento (Pasaporte)', debe ser una fecha mayor a la Fecha Actual (de creación del cliente)";
public final static String ERROR_VALIDACION_IDENTIFICACION_FACTUAL_FINGRESO = "La 'Fecha de Ingreso a Ecuador', debe ser una fecha no mayor a la Fecha Actual (de creación del cliente)";


//Constantes Informacion de Contacto
public final static String TIPO_DOMICILIO_TABLA = "CCLI";
public final static String TIPO_DOMICILIO_NIVEL = "4";
public final static String TIPO_DOMICILIO_COD1 = "CCAT";
public final static String TIPO_DOMICILIO_COD2 = "TDOM";
public final static String TIPO_DOMICILIO_COD3 = "CLNA";
public final static String TIPO_DOMICILIO_EDIFICIO = "E";
public final static String CONDICION_VIVIENDA_TABLA = "TTVI";//OJO
public final static String CONDICION_VIVIENDA_NIVEL = "1";//OJO
public final static String TIPO_OFICINA_TABLA = "CCLI"; 
public final static String TIPO_OFICINA_NIVEL = "4"; 
public final static String TIPO_OFICINA_COD1 = "CCAT"; 
public final static String TIPO_OFICINA_COD2 = "TOFI"; 
public final static String TIPO_OFICINA_COD3 = "CLNA";

public final static String ERROR_VALIDACION_INFO_CONTACTOS_REQUERIDO_LUGAR_DOMICILIO = "Debe seleccionar Lugar de Domicilio";
public final static String ERROR_VALIDACION_INFO_CONTACTOS_REQUERIDO_LUGAR_TRABAJO = "Debe seleccionar Lugar de Trabajo";
public final static String ERROR_VALIDACION_INFO_CONTACTOS = "Errores de validación Sección Contactos";

//Constantes codigo de provincias
public final static String COD_PROVINCIA_TABLA = "TCIU";
public final static String COD_PROVINCIA_NIVEL = "1";

//Constantes Operadoras de celulares
public final static String OPERADORA_TABLA = "TCEL";
public final static String OPERADORA_NIVEL = "1";

public final static String TIPO_TELEFONO_TABLA = "CCLI"; 
public final static String TIPO_TELEFONO_NIVEL = "3"; 
public final static String TIPO_TELEFONO_COD1 = "CCAT"; 
public final static String TIPO_TELEFONO_COD2 = "TTEL";

public final static String NOTIFICACION_TELEFONO_PERSONAL = "1";

public final static String PARROQUIA_TABLA = "TCIU"; 
public final static String PARROQUIA_NIVEL = "4"; 

public final static String CORREOS_INVALIDOS_TABLA = "CCLI"; 
public final static String CORREOS_INVALIDOS_NIVEL = "3"; 
public final static String CORREOS_INVALIDOS_COD1 = "CCAT"; 
public final static String CORREOS_INVALIDOS_COD2 = "CELI";

public static final String INF_CONTACTO_CORREO_PERSONAL = "1";
public static final String INF_CONTACTO_CORREO_ESTADO_OMISION = "P";
public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

public final static String INF_CONTACTO_ANIO_MINIMO_EMPEZO_RESIDIR = "1900";
public final static String INF_CONTACTO_CONDICION_VIVIENDA_PROPIA = "P";
public final static String TIPO_TELEFONO_CONVENCIONAL = "C";

//Constantes de Faces.
public final static String FORM_PRINCIPAL = "tabPrincipal:clientMainForm:";

//Constantes para manejo de sesion
public final static String CODIGO_ACCESO="codigoAcceso";

public static final String START_SEPARATOR_CANTON_PROVINCIA = "(";
public static final String END_SEPARATOR_CANTON_PROVINCIA = ")";

//Constantes para información de referencia
public static final String TIPO_REFERENCIA = "PER";
public final static String ERROR_VALIDACION_INFORMACION_REFERENCIA_ESPACIOS = "Error de validación, Nombre de Referencia 1 - No es permitido solamente espacios o vacio.";

//Constantes para información transaccionales
public final static String TRAN_CCLI_CATALOG_TABLE = "CCLI";
public final static String TRAN_PARAMETROS_LEVEL = "2";
public final static String TRAN_PARAMETROS_COD1 = "INFT";
public final static String TRAN_PARAMETROS_COD2 = "MONT";

//cupos
public final static String CUPO_COD1 = "CUPO";
public final static String CUPO_LEVEL1 = "1";
public final static String CUPO_LEVEL2 = "2";
public final static String CUPO_LEVEL3 = "3";
public final static String CUPO_LEVEL4 = "4";

public static String DATE_WEB_FORMAT = "yyyy/MM/dd";

public final static String ERROR_VALIDACION_INFORMACION_TRAN_MONTO_DEPOSITO = "Error de validaci\u00F3n, Monto debe ser mayor o igual a par\u00E1metro de Estimado de Dep\u00F3sitos. ";
public final static String ERROR_VALIDACION_INFORMACION_TRAN_MONTO_GIROS = "Error de validaci\u00F3n, Monto debe ser mayor o igual a par\u00E1metro de Estimado de Giros. ";
public final static String ERROR_VALIDACION_INFORMACION_TRAN_EST_RECIBO_MAYOR_CERO = "Error de validaci\u00F3n, 'Estimado Monto Anual que Recibir\u00E1'. Si el campo 'Recibir\u00E1 Transferencias del Exterior' es 'SI', entonces el campo debe ser estrictamente mayor a cero.";
public final static String ERROR_VALIDACION_INFORMACION_TRAN_EST_ENVIO_MAYOR_CERO = "Error de validaci\u00F3n, 'Estimado Monto Anual que Enviar\u00E1'. Si el campo 'Enviará Transferencias al Exterior' es 'SI', entonces el campo debe ser estrictamente mayor a cero.";
public final static String ERROR_VALIDACION_INFORMACION_TRAN_PAIS_ORIGEN_PAICES_SANCIONADOS= "Pa\u00EDs origen.- Existe coincidencia con listado de 'Pa\u00EDses Sancionados'";
public final static String ERROR_VALIDACION_INFORMACION_TRAN_PAIS_DESTINO_PAICES_SANCIONADOS= "Pa\u00EDs Destino.- Existe coincidencia con listado de 'Pa\u00EDses Sancionados'";

//Constatntes seccion Inf. Adicional
public final static String INF_ADICIONAL_OTRA_INTS_FINANCIERA="OTR";
public final static String ERROR_INF_ADICIONAL_OTRA_INTS_FINANCIERA="Debe ingresar otra Institución Financiera";
public final static String ERROR_INF_ADICIONAL_EJEC_PRINCIPAL="Debe selecciona un Ejecutivo de Negocio Principal";
public final static String ERROR_INF_ADICIONAL_EJEC_SECUNDARIO="Debe selecciona un Ejecutivo de Negocio Secundario";
public final static String ERROR_SPINS_80="Cada línea de la observación debe ser menor a 80";

//Constantes de validaciones en general
public final static String VALIDACION_INFORMACION = "I";
public final static String VALIDACION_ERROR = "E";
public final static String CLASE_ERROR = "error-input";
public final static String CLASE_INFORMACION = "opcional-input";
public final static String CLASE_COMBO_HTML = "class-combo";

public final static String REP_IMPRESION_ACTUALIZACION_X = "x";
public final static String REP_VALOR_UNO = "1";
public final static String REP_VALOR_SI = "SI";
public final static String REP_VALOR_S = "S";
public final static String REP_VALOR_NO = "NO";

//Constantes cargo
public final static String CARGO_TABLA = "CCLI";
public final static String CARGO_NIVEL = "4";
public final static String CARGO_COD1 = "CCAT";
public final static String CARGO_COD2 = "CARG";
public final static String CARGO_DEPENDIENTE_COD3 = "CDEP";
public final static String CARGO_INDEPENDIENTE_COD3 = "CIND";

//Constantes fuente
public final static String FUENTE_INGRESO_TABLA="TCTH";
public final static String FUENTE_INGRESO_NIVEL="2";
public final static String FUENTE_INGRESO_COD1="FUEI";

public final static String MENSAJE_INFORMATIVO="I";
public final static String MENSAJE_ERROR="E";

public static final String NUEVO_CLIENTE_INDIVIDUAL="I";
public static final String AHORROS="AHO";

/*Cargos para relación laboral dependiente*/
public final static String CARGO_DEPENDIENTE_TABLA = "CCLI";
public final static String CARGO_DEPENDIENTE_NIVEL = "4";
public final static String CARGO_DEPENDIENTE_NIVEL_1 = "CCAT";
public final static String CARGO_DEPENDIENTE_NIVEL_2 = "CARG";
public final static String CARGO_DEPENDIENTE_NIVEL_3 = "CDEP";

/*Cargos para relación laboral independiente*/
public final static String CARGO_INDEPENDIENTE_TABLA = "CCLI";
public final static String CARGO_INDEPENDIENTE_NIVEL = "4";
public final static String CARGO_INDEPENDIENTE_NIVEL_1 = "CCAT";
public final static String CARGO_INDEPENDIENTE_NIVEL_2 = "CARG";
public final static String CARGO_INDEPENDIENTE_NIVEL_3 = "CIND";

public final static String CARGOS_DEPENDIENTES_CATALOG_KEY="CARGOS_DEPENDIENTES_CATALOG";
public final static String CARGOS_INDEPENDIENTES_CATALOG_KEY="CARGOS_INDEPENDIENTES_CATALOG";

public final static String TIPO_IDENTIFICACION_RCERTIFICACION_TABLA = "CCLI"; 
public final static String TIPO_IDENTIFICACION_RCERTIFICACION_NIVEL = "3"; 
public final static String TIPO_IDENTIFICACION_RCERTIFICACION_COD1 = "CCAT"; 
public final static String TIPO_IDENTIFICACION_RCERTIFICACION_COD2 = "TIDE";

public final static String PAIS_REPORTE_CERTIFICACION_TABLA = "PDCC";
public final static String PAIS_REPORTE_CERTIFICACION__NIVEL_UNO = "1";
public final static String PAIS_REPORTE_CERTIFICACION__NIVEL_DOS = "2";
public final static String PAIS_REPORTE_CERTIFICACION__NIVEL_TRES = "3";

public final static String NOMBRE_ARCHIVO_PDF="CONTRATO_VINCULACION.pdf";
public final static String ASUNTO_CORREO = "Envío de contrato de vinculación ";
public final static String ADJUNTAR_IMAGENES_SI = "SI";
public final static String ADJUNTAR_IMAGENES_NO = "NO";
public final static String IMPRESION = "IMPRESION";
public final static String REIMPRESION = "REIMPRESION";


//REPORTE ACTUALIZACIÓN
public final static String REPORTE_ACTUALIZACION_DETALLE = "detalle";
public final static String REPORTE_ACTUALIZACION_SUBCABECERA = "subcabecera";
public final static String REPORTE_ACTUALIZACION_CABECERA = "cabecera";
public final static String REPORTE_ACTUALIZACION_CONTENIDO_BASICO = "contenido.basico";
public final static String REPORTE_ACTUALIZACION_CONTENIDO_DIRECCION = "contenido.direccion";
public final static String REPORTE_ACTUALIZACION_CONTENIDO_REFERENCIA = "contenido.referencia";
public final static String REPORTE_ACTUALIZACION_CONTENIDO_CELULAR = "contenido.celular";
public final static String REPORTE_ACTUALIZACION_CONTENIDO_UBICACION_SIN_PARROQUIA = "contenido.ubicacionSinParroquia";
public final static String REPORTE_ACTUALIZACION_CONTENIDO_UBICACION = "contenido.ubicacion";
public final static String REPORTE_ACTUALIZACION_CONTENIDO_FECHA = "contenido.fecha";
public final static String REPORTE_ACTUALIZACION_DIRECC = "direcc";
public final static String REPORTE_ACTUALIZACION_REFERENCIA = "referencia";
public final static String REPORTE_ACTUALIZACION_CELULAR2 = "celular 2";
public final static String REPORTE_ACTUALIZACION_CELULAR1 = "celular 1";
public final static String REPORTE_ACTUALIZACION_CELULAR_NOTIFICACION = "notificaciones";
public final static String REPORTE_ACTUALIZACION_CELULAR_CONTACTO = "celular de contacto";
public final static String REPORTE_ACTUALIZACION_REPRESENTANTE = "representante";
public final static String REPORTE_ACTUALIZACION_UBICACION = "ubicaci";
public final static String REPORTE_ACTUALIZACION_FECHA = "fecha";
public final static String REPORTE_FECHA_VENCIMIENTO_NOMBRAMIENTO = "vencimiento de nombramiento";

}