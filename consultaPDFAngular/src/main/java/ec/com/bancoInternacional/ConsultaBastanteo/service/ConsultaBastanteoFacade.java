package ec.com.bancoInternacional.ConsultaBastanteo.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.ejb.Local;

import ec.com.bancoInternacional.ConsultaBastanteo.excepcion.ClienteNoEncontradoException;
import ec.com.bancoInternacional.ConsultaBastanteo.excepcion.PooledTrxException;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.CantonInfo;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.CcliCatalogo;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Cliente;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.FuncionarioResponsable;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Ncodig;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ObjCliente;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.PaisInfo;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ParametroBuscarCliente;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ValidacionInfoAgencia;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ValidacionInfoFuncionariosPorAgencia;
import ec.com.bancoInternacional.server.seguridad.Credencial;

/**
 * Interface SERVICE para el manejo de servicio utilizados para consulta de bastanteo
 * 
 * @author JCUASCOTA
 * @version 1.0.0 - 26/03/2015
 */
@Local
public interface ConsultaBastanteoFacade {

	/**
	 * Utilizado para obtener los datos de un cliente del bastanteo historico
	 * 
	 * @param codigo
	 * @return
	 * @throws ClienteNoEncontradoException 
	 */
	Cliente consultaBastanteoPorIdentificacion(String id, String tipoIdentificacion) throws ClienteNoEncontradoException;
	public List<ObjCliente> buscaClientePorNombre(ParametroBuscarCliente parametroBuscarCliente) throws InterruptedException, ExecutionException;
	public Credencial getCntrlBth(Credencial credencial) throws PooledTrxException;
	
	/*
	 * METODO PARA LA CARGA DE CATALOGOS:
	 */
	
	Collection<CcliCatalogo> recuperarCatalogoPorTabla(final String table) throws PooledTrxException;
	Collection<Ncodig> recuperarCatalogo(Object ncodigParams, Object levels) throws PooledTrxException;
	Collection<Ncodig> recuperarCatalogoConcepto(Object ncodigParams, Object levels) throws PooledTrxException;
	Collection<CantonInfo> recuperarCantonesLocal() throws PooledTrxException;
	List<FuncionarioResponsable> obtenerFuncionariosResponsable();
	ValidacionInfoAgencia cargarAgencias() throws PooledTrxException;
	Collection<Ncodig> recuperarPaisNacionalidadCatalog() throws PooledTrxException;
	Collection<PaisInfo> recuperarCatalogoPaises(Collection<CcliCatalogo> catalogs) throws PooledTrxException;
	ValidacionInfoFuncionariosPorAgencia recuperarFuncionariosPorAgencias(BigDecimal agencia) throws PooledTrxException;
}
