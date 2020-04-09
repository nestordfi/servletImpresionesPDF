package ec.com.bancoInternacional.ConsultaBastanteo.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ec.com.bancoInternacional.ConsultaBastanteo.modelo.CatalogoModeloVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ClasificacionCatalog;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Cliente;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.FuncionarioResponsable;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.NacionalidadCatalogoVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.RepresentantesLegalesSeccionVO;
import ec.com.bancointernacional.ApplicationSecurity;
import ec.com.bancointernacional.services.common.BaseAESCipher;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.AccionistasSeccionVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.CantonCatalogoVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Cargo;

public class GeneralUtil {

	public String obtenerNombrePorCodigoModeloVO(String codigo, List<CatalogoModeloVO> lista) {
		for (CatalogoModeloVO catalogoModeloVO : lista) {
			if (codigo.equals(catalogoModeloVO.getId())) {
				return catalogoModeloVO.getName();
			}
		}
		return "";
	}
	
	public String obtenerNombreClasificacion(String codigo, List<ClasificacionCatalog> lista) {
		for (ClasificacionCatalog clasificacionCatalog : lista) {
			if (codigo.equals(clasificacionCatalog.getId())) {
				return clasificacionCatalog.getNombre();
			}
		}
		return "";
	}

	public String obtenerNombrePorCodigoCantonVO(String codigo, List<CantonCatalogoVO> lista) {
		for (CantonCatalogoVO canton : lista) {
			if (codigo.equals(canton.getId())) {
				return canton.getName();
			}
		}
		return "";
	}

	public FuncionarioResponsable obtenerFuncionarioResponsablePorId(String codigo,
			List<FuncionarioResponsable> lista) {
		for (FuncionarioResponsable fun : lista) {
			if (codigo.equals(fun.getId())) {
				return fun;
			}
		}
		FuncionarioResponsable fun = new FuncionarioResponsable();
		fun.setAgencia(new BigDecimal(0));
		fun.setCargo("");
		fun.setId("");
		fun.setNombre("");
		return fun;
	}

	public static void filtrarAccionistasVisibleOcultosPorPorcentajeMinimo(Cliente cliente, String maximoPorcentaje) {

		List<AccionistasSeccionVO> listaAccionistaVisible = new ArrayList<>();
		List<AccionistasSeccionVO> listaAccionistaOcultos = new ArrayList<>();
		// cliente.getAccionistas().size()
		for (AccionistasSeccionVO accionista : cliente.getAccionistas()) {
			Double porcentaje = accionista.getPorcentajeAcciones();
			if (porcentaje >= Double.parseDouble(maximoPorcentaje)) {
				listaAccionistaVisible.add(accionista);
			} else {
				listaAccionistaOcultos.add(accionista);
			}
		}

		cliente.setAccionistas(listaAccionistaVisible);
		cliente.setAccionistasOcultos(listaAccionistaOcultos);

		listaAccionistaOcultos = null;
		listaAccionistaVisible = null;

	}

	public static List<RepresentantesLegalesSeccionVO> ordenarPorNombreAlfabeticamenteRepresentantes(Cliente cliente) {
		List<String> nombres = new ArrayList<String>();
		for (RepresentantesLegalesSeccionVO representante : cliente.getRepresentantesLegales()) {
			if (null != representante.getTxtNombreApellidoRep()) {
				nombres.add(representante.getTxtNombreApellidoRep());
			}
		}
		Collections.sort(nombres);
		List<RepresentantesLegalesSeccionVO> listaOrdenada = new ArrayList<>();
		List<RepresentantesLegalesSeccionVO> listaAuxiliar = cliente.getRepresentantesLegales();
		for (int i = 0; i < nombres.size(); i++) {
			for (int j = 0; j < listaAuxiliar.size(); j++) {
				if (nombres.get(i).equals(listaAuxiliar.get(j).getTxtNombreApellidoRep())) {
					listaOrdenada.add(listaAuxiliar.get(j));
					listaAuxiliar.remove(cliente.getRepresentantesLegales().get(j));
					break;
				}
			}
		}
		if (0 != listaAuxiliar.size()) {
			listaOrdenada.addAll(listaAuxiliar);
		}
		return listaOrdenada;
	}

	public static List<AccionistasSeccionVO> ordenarPorPorcentajeAccionistas(Cliente cliente) {
		List<Double> porcentajes = new ArrayList<Double>();
		for (AccionistasSeccionVO accionista : cliente.getAccionistas()) {
			porcentajes.add(accionista.getPorcentajeAcciones());
		}
		Collections.sort(porcentajes, Collections.reverseOrder());
		List<AccionistasSeccionVO> listaOrdenada = new ArrayList<>();
		List<AccionistasSeccionVO> listaAuxiliar = cliente.getAccionistas();
		for (int i = 0; i < porcentajes.size(); i++) {
			for (AccionistasSeccionVO accionistasSeccionVO : listaAuxiliar) {
				if (porcentajes.get(i) == accionistasSeccionVO.getPorcentajeAcciones()) {
					listaOrdenada.add(accionistasSeccionVO);
					listaAuxiliar.remove(accionistasSeccionVO);
					break;
				}
			}
		}
		if (0 != listaAuxiliar.size()) {
			listaOrdenada.addAll(listaAuxiliar);
		}
		return listaOrdenada;
	}

	public String obtenerNombrePorCodigoCargo(String codigo, List<Cargo> lista) {
		for (Cargo cargo : lista) {
			if (codigo.equals(cargo.getId())) {
				return cargo.getValue();
			}
		}
		return "";
	}
	
	public String obtenerNombrePorCodigoNacionalidadCatalogoVO(String codigo,List<NacionalidadCatalogoVO> lista){
		for (NacionalidadCatalogoVO nac : lista) {
			if (codigo.equals(nac.getId())) {
				return nac.getName();			
			}
		}
		return "";
	}
	
	public String obtenerNombreAccionista(AccionistasSeccionVO accionista){
		String nombre = "";
		if (!StringUtils.isBlank(accionista.getTxtRazonSocialAccionistas())) {
			nombre = accionista.getTxtRazonSocialAccionistas();
			return nombre;
		}
		if (!StringUtils.isBlank(accionista.getTxtPrimerNombreAccionistas())) {
			nombre = accionista.getTxtPrimerNombreAccionistas();
		}
		if (!StringUtils.isBlank(accionista.getTxtSegundoNombreAccionistas())) {
			nombre = nombre + " " + accionista.getTxtSegundoNombreAccionistas();
		}
		if (!StringUtils.isBlank(accionista.getTxtPrimerApellidoAccionistas())) {
			nombre = nombre + " " + accionista.getTxtPrimerApellidoAccionistas();
		}
		if (!StringUtils.isBlank(accionista.getTxtSegundoApellidoAccionistas())) {
			nombre = nombre + " " + accionista.getTxtSegundoApellidoAccionistas();
		}
		return nombre != null? nombre.trim() : "";
	}
	
	/*
	 * Desencriptador cadena
	 */
	public static String desencriptarString(String usr) {
		String keyPath = ApplicationSecurity.getString("path.archivos.as400")
				+ ApplicationSecurity.getString("archivo.as400.key");
		String seedPath = ApplicationSecurity.getString("path.archivos.as400")
				+ ApplicationSecurity.getString("archivo.as400.seed");
		BaseAESCipher aesCipher = new BaseAESCipher(keyPath, seedPath);

		return aesCipher.decryptValue(usr);
	}
}
