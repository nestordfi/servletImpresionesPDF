package ec.com.bancoInternacional.services.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.bancoInternacional.server.ClientesServiceImpl;
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

/**
 * Autor: Sandro Guevara Objetivo: Clase Proxy de Servicios de masivas Fecha:
 * 08-05-2018 Nro. Req: 1605 Version: 1.0
 */
@Stateless
public class ServiciosProxy implements ServiceFacadeInterface, Serializable {
	private static final long serialVersionUID = -7467022083628090630L;

	@EJB
	CatalogoServiceImpl serviciosCatalogos;

	@EJB
	ServiceImpl serviceImpl;
	
	@EJB
	ClientesServiceImpl clientesServiceImpl;

	public ServiciosProxy() {
		serviceImpl = new ServiceImpl();
		serviciosCatalogos = new CatalogoServiceImpl();

	}

	// Servicios de Catalogos
	@Override
	public Collection<Ncodig> recuperarCatalogo(Object ncodigParams, Object levels) throws PooledTrxException {
		return serviciosCatalogos.recuperarCatalogo(ncodigParams, levels);
	}
	
	@Override
	public Collection<CcliCatalogo> recuperarCatalogoPorTablaYNivel(Collection<CcliCatalogo> catalogs,
			ConsultaNcodigParametro parameter) throws PooledTrxException {
		return serviciosCatalogos.recuperarCatalogoPorTablaYNivel(catalogs, parameter);
	}

	@Override
	public Credencial getCntrlBth(Credencial credencial) throws PooledTrxException {
		return serviceImpl.getCntrlBth(credencial);
	}
	
	@Override
	public Collection<CcliCatalogo> recuperarCatalogoPorTabla(String table) throws PooledTrxException {
		return serviciosCatalogos.recuperarCatalogoPorTabla(table);
	}
	
	@Override
	public Collection<PaisInfo> recuperarCatalogoPaises(Collection<CcliCatalogo> catalogs) throws PooledTrxException {
		return serviciosCatalogos.recuperarCatalogoPaises(catalogs);
	}
	
	@Override
	public Collection<CantonInfo> recuperarCantonesLocal() throws PooledTrxException {
		return serviciosCatalogos.recuperarCantonesLocal();
	}
	
	@Override
	public Collection<Ncodig> recuperarParroquiasCatalog() throws PooledTrxException {
		return serviciosCatalogos.recuperarParroquiasCatalog();
	}
	
	@Override
	public Collection<Ncodig> recuperarPropositoRelacionComercialCatalog() throws PooledTrxException {
		return serviciosCatalogos.recuperarPropositoRelacionComercialCatalog();
	}
	
	@Override
	public Collection<Ncodig> recuperarClasificacionCatalog() throws PooledTrxException {
		return serviciosCatalogos.recuperarClasificacionCatalog();
	}
	
	@Override
	public Map<ActEconomicaInfo, List<ActEconomicaInfo>> recuperarActEconomicaCliente() throws PooledTrxException {
		return serviciosCatalogos.recuperarActEconomicaCliente();
	}

	@Override
	public DatosJuridicoDto recuperarReporteClienteJuridico(String identificacion) throws PooledTrxException {
		return serviceImpl.recuperarReporteClienteJuridico(identificacion);
	}

	@Override
	public Map<String, String> consultarClienteJuridico(String id, String tipo, String user)
			throws IllegalArgumentException {
		return clientesServiceImpl.consultarClienteJuridico(id, tipo, user);
	}
	
	@Override
	public Collection<Catalogo> recuperarCatalogoCnofc(String codigo) throws PooledTrxException {
		return serviciosCatalogos.recuperarCatalogoCnofc(codigo);
	}
	
	@Override
	public Collection<Ncodig> recuperarPaisNacionalidadCatalog() throws PooledTrxException {
		return serviciosCatalogos.recuperarPaisNacionalidadCatalog();
	}
	
	@Override
	public DatosEnvioCorreo consultaEstadoEnvioContratroEmail(BigDecimal Ibs, BigDecimal numeroDeCuenta) throws PooledTrxException {
		return serviceImpl.consultaEstadoEnvioContratroEmail(Ibs, numeroDeCuenta);
	}
	
	@Override
	public void actualizarEstadoEnvioContratroEmail(String codigoIbs, String estadoEnvioCorreo,
			String mensajeEnvioCorreo, String correosRepresentantesLegales, String usuario) throws PooledTrxException {
		serviceImpl.actualizarEstadoEnvioContratroEmail(codigoIbs, estadoEnvioCorreo, mensajeEnvioCorreo, correosRepresentantesLegales, usuario);
	}

	@Override
	public List<EstadoCiudadModeloCatalogo> obtenerCiudadEcuadorReporteCertificacionCatalogo(String paisConstanteTabla,
			String nivelConstanteTabla) {
		return serviciosCatalogos.obtenerCiudadEcuadorReporteCertificacionCatalogo(paisConstanteTabla, nivelConstanteTabla);
	}

}
