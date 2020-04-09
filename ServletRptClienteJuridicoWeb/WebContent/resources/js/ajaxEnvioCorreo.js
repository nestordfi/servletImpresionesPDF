/**
 * Ajax que se ejecutara autimaticamente cuando la pagina jsp este lista
 * y invocara el servlet del reporte clienteJuridico recuperando los
 * parametros que estan hidden en la pagina.
 */
$(document).ready(function() {
	var UrlFull = obtenerUrlServletReporteClienteJuridico();
	$.ajax({
		url : UrlFull,
		cache: false,
		data : {
			documentoIdentificacion:	$('#documentoIdentificacion').val(),
			factaPregunta1:				$('#factaPregunta1').val(),
			factaPorcentaje:			$('#factaPorcentaje').val(),
			factaPregunta2:				$('#factaPregunta2').val(),
			usuario:					$('#usuario').val(),
			tipoImpresion:				$('#tipoImpresion').val(),
			codigoIbs:					$('#codigoIbs').val()
			
		},
		success : function(responseText) {
			$('#cargarPantalla').hide(); 
			$('#ajaxGetUserServletResponse span').html(responseText);
		},
		error: function (request, status, error) {
			$('#cargarPantalla').hide();
			$('#errorEnCargarPdf span').html("Ocurrio un error en la obtenci&oacute;n del reporte.");
	    }
	});
});

/**
 * Funccion que retorna la url armada para invocar el servlet
 * 
 * @returns {String}
 */
function obtenerUrlServletReporteClienteJuridico(){
	
	var urlArmada = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port: '')
					+'/ServletContratosWeb/rptVinculacion';
	
	return urlArmada;
}