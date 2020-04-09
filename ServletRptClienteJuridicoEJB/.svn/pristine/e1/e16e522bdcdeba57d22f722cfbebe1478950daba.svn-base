package ec.com.bancoInternacional.services.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import ec.com.bancoInternacional.server.seguridad.Credencial;
import ec.com.bancoInternacional.services.domain.ActEconomicaInfo;
import ec.com.bancoInternacional.services.domain.CantonInfo;
import ec.com.bancoInternacional.services.domain.Catalogo;
import ec.com.bancoInternacional.services.domain.CcliCatalogo;
import ec.com.bancoInternacional.services.domain.DatosJuridicoDto;
import ec.com.bancoInternacional.services.domain.EstadoCiudadModeloCatalogo;
import ec.com.bancoInternacional.services.domain.Ncodig;
import ec.com.bancoInternacional.services.domain.PaisInfo;
import ec.com.bancoInternacional.services.exception.PooledTrxException;
import ec.com.bancoInternacional.services.mapping.DatosEnvioCorreo;
import ec.com.bancoInternacional.services.util.ConsultaNcodigParametro;

@Local
public interface ServiceFacadeInterface {
	public Credencial getCntrlBth(Credencial credencial) throws PooledTrxException;

	// Servicios de Catalogos
	Collection<Ncodig> recuperarCatalogo(Object ncodigParams, Object levels) throws PooledTrxException;

	Collection<CcliCatalogo> recuperarCatalogoPorTablaYNivel(Collection<CcliCatalogo> catalogs,
			final ConsultaNcodigParametro parameters) throws PooledTrxException;

	Collection<CcliCatalogo> recuperarCatalogoPorTabla(String table) throws PooledTrxException;
	
	Collection<PaisInfo> recuperarCatalogoPaises(Collection<CcliCatalogo> catalogs) throws PooledTrxException;
	
	Collection<CantonInfo> recuperarCantonesLocal() throws PooledTrxException;
	
	Collection<Ncodig> recuperarParroquiasCatalog() throws PooledTrxException;
	
	Collection<Ncodig> recuperarPropositoRelacionComercialCatalog() throws PooledTrxException;
	
	Collection<Ncodig> recuperarClasificacionCatalog() throws PooledTrxException;
	
	Map<ActEconomicaInfo, List<ActEconomicaInfo>> recuperarActEconomicaCliente() throws PooledTrxException;
	
	DatosJuridicoDto recuperarReporteClienteJuridico(String identificacion) throws PooledTrxException;
	
	Map<String, String> consultarClienteJuridico(String id, String tipo, String user) throws IllegalArgumentException;
	
	Collection<Catalogo> recuperarCatalogoCnofc(String codigo) throws PooledTrxException;
	
	Collection<Ncodig> recuperarPaisNacionalidadCatalog() throws PooledTrxException;
	
	DatosEnvioCorreo consultaEstadoEnvioContratroEmail(BigDecimal Ibs, BigDecimal numeroDeCuenta) throws PooledTrxException;
	
	void actualizarEstadoEnvioContratroEmail(String codigoIbs, String estadoEnvioCorreo,
			String mensajeEnvioCorreo, String correosRepresentantesLegales, String usuario) throws PooledTrxException;
	
	List<EstadoCiudadModeloCatalogo> obtenerCiudadEcuadorReporteCertificacionCatalogo(String paisConstanteTabla, String nivelConstanteTabla);

}