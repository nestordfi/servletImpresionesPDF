<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		
		<!-- Librerias de javascript y jquery a utilizar -->
		<script src="./resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
		<script src="./resources/js/ajaxEnvioCorreo.js" type="text/javascript"></script>
		
		<!-- Cargar Css -->
		<link rel="stylesheet" type="text/css" href="./resources/css/paginaReloadEnvioCorreo.css"/>
	</head>
	<body class="fondoBody">
		<form id="contendioDatosEnvioCorreo">
			<!-- Imagen Gif -->
			<img id="cargarPantalla" class="centrarImagenEnPantalla" src="./resources/img/ajax-loader.gif"/>
		 	
		 	<!-- Datos que se usaran para recuperar en el ajax y ser enviado al servlet -->
			<input type="hidden" id="documentoIdentificacion" value = '<%=request.getParameter("documentoIdentificacion") %>' />
			<input type="hidden" id="factaPregunta1" value = '<%=request.getParameter("factaPregunta1")%>' />
			<input type="hidden" id="factaPorcentaje" value = '<%=request.getParameter("factaPorcentaje")%>' />
			<input type="hidden" id="factaPregunta2" value = '<%=request.getParameter("factaPregunta2")%>' />
			<input type="hidden" id="usuario" value = '<%=request.getParameter("usuario")%>' />
			<input type="hidden" id="tipoImpresion" value = '<%=request.getParameter("tipoImpresion")%>' />
			<input type="hidden" id="codigoIbs" value = '<%=request.getParameter("codigoIbs")%>' />
		</form>
		
		<div id="ajaxGetUserServletResponse" class="estiloLetraYtamanio widthAjaxGetUserServletResponse">
		 	<span></span>
		</div>
		
		<div id="errorEnCargarPdf" class="estiloLetraYtamanio">
		 	<span></span>
		</div>
	</body>
</html>