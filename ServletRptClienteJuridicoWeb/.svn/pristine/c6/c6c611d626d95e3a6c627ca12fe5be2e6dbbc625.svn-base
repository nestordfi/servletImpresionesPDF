package ec.com.bancoInternacional.view.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import ec.com.bancoInternacional.services.domain.ActEconomicaInfo;
import ec.com.bancoInternacional.services.domain.ActEconomicaInfoPK;
import ec.com.bancoInternacional.services.domain.CantonInfo;
import ec.com.bancoInternacional.services.domain.PaisInfo;
import ec.com.bancoInternacional.services.util.NcodigClaveParametro;
import ec.com.bancoInternacional.view.domain.CatalogoModeloVO;
import ec.com.bancoInternacional.view.domain.NacionalidadCatalogoVO;

/**
 * Autor: Sandro Guevara Objetivo: Utilitario de Catalogos Ncodig, para
 * construccion de objetos comunes de parametros de consulta Fecha: 08-05-2018
 * Nro. Req: 1605 Version: 1.0
 */
public class CatalogoUtil {
	public static NcodigClaveParametro catalogComposedKey() {
		return new NcodigClaveParametro(true, true, true, false, 1);
	}

	public static PaisInfo obtenerPaisPorNombreId(final List<PaisInfo> paises, final String id,
			final String nombrePais) {
		if (id == null || "".equals(id) && "".equals(nombrePais)) {
			return new PaisInfo();
		}

		PaisInfo returnPais = null;
		Predicate paisPredicate = new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				PaisInfo pais = (PaisInfo) arg0;
				boolean found = true;
				try {
					found = pais.getId().equals(id.trim())
							|| pais.getValue().toUpperCase().equals(nombrePais.trim().toUpperCase());
				} catch (Exception e) {
					found = false;
				}
				return found;
			}
		};
		try {
			returnPais = (PaisInfo) CollectionUtils.find(paises, paisPredicate);
		} catch (Exception exc) {

		} finally {
			paisPredicate = null;
		}
		return returnPais;
	}

	/*
	 * Busca cantones en la lista enviada como parametro
	 */
	public static CantonInfo obtenerCantonPorNombreId(final List<CantonInfo> cantones, final String id,
			final String nombreCanton) {
		if (id == null || "".equals(id) && "".equals(nombreCanton)) {
			return new CantonInfo();
		}

		CantonInfo retorna = null;
		Predicate cantonPredicate = new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				CantonInfo canton = (CantonInfo) arg0;
				boolean found = true;
				try {
					found = canton.getId().equals(id.trim())
							|| canton.getValue().toUpperCase().equals(nombreCanton.trim().toUpperCase());
				} catch (Exception e) {
					found = false;
				}
				return found;
			}
		};
		try {
			retorna = (CantonInfo) CollectionUtils.find(cantones, cantonPredicate);
		} catch (Exception exc) {

		} finally {
			cantonPredicate = null;
		}
		return retorna;
	}

	/*
	 * Busca provincias en la lista enviada como parametro
	 */
	public static CatalogoModeloVO obtenerCatalogoModeloVOPorNombreId(final List<CatalogoModeloVO> lista,
			final String id, final String nombre) {
		if (id == null || "".equals(id) && "".equals(nombre)) {
			return new CatalogoModeloVO();
		}

		CatalogoModeloVO retorna = null;
		Predicate itemPredicate = new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				CatalogoModeloVO itemBuscar = (CatalogoModeloVO) arg0;
				boolean found = true;
				try {
					found = itemBuscar.getId().equals(id.trim())
							|| itemBuscar.getName().toUpperCase().equals(nombre.trim().toUpperCase());
				} catch (Exception e) {
					found = false;
				}
				return found;
			}
		};
		try {
			retorna = (CatalogoModeloVO) CollectionUtils.find(lista, itemPredicate);
		} catch (Exception exc) {

		} finally {
			itemPredicate = null;
		}
		return retorna;
	}

	public static CatalogoModeloVO recuperarCatalogoModeloVO(final List<CatalogoModeloVO> lista, final String id) {
		if ("".equals(id)) {
			return new CatalogoModeloVO();
		}

		CatalogoModeloVO retorna = null;
		Predicate predicado = new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				CatalogoModeloVO item = (CatalogoModeloVO) arg0;
				boolean found = true;
				try {
					found = item.getId().equals(id.trim());
				} catch (Exception e) {
					found = false;
				}
				return found;
			}
		};
		try {
			retorna = (CatalogoModeloVO) CollectionUtils.find(lista, predicado);
		} catch (Exception exc) {

		} finally {
			predicado = null;
		}
		return retorna;
	}

	/*
	 * Busca provincias en la lista enviada como parametro
	 */
	public static NacionalidadCatalogoVO obtenerNacionalidadCatalogoVOPorNombreId(
			final List<NacionalidadCatalogoVO> lista, final String id, final String nombre) {
		if (id == null || "".equals(id) && "".equals(nombre)) {
			return new NacionalidadCatalogoVO();
		}

		NacionalidadCatalogoVO retorna = null;
		Predicate itemPredicate = new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				CatalogoModeloVO itemBuscar = (CatalogoModeloVO) arg0;
				boolean found = true;
				try {
					found = itemBuscar.getId().equals(id.trim())
							|| itemBuscar.getName().toUpperCase().equals(nombre.trim().toUpperCase());
				} catch (Exception e) {
					found = false;
				}
				return found;
			}
		};
		try {
			retorna = (NacionalidadCatalogoVO) CollectionUtils.find(lista, itemPredicate);
		} catch (Exception exc) {

		} finally {
			itemPredicate = null;
		}
		return retorna;
	}

	/*
	 * Buscar actividad económica por ID en el nivel 6
	 */
	public static boolean existeActEconomicaPorIdNivel6(Map<ActEconomicaInfoPK, List<ActEconomicaInfo>> lstActEconomicas,
			String idActEconomica) throws Exception {

		Iterator it = lstActEconomicas.entrySet().iterator();
		ActEconomicaInfo pk = new ActEconomicaInfo();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			pk = new ActEconomicaInfo();
			pk = (ActEconomicaInfo) e.getKey();

			for (ActEconomicaInfo item : lstActEconomicas.get(pk)) {
				if (item.getId().getCcicc6().equals(idActEconomica)) {
					return true;
				}
			}
		}

		return false;
	}

}
