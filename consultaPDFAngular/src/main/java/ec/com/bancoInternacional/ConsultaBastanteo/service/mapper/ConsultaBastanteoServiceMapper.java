package ec.com.bancoInternacional.ConsultaBastanteo.service.mapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import ec.com.bancoInternacional.ConsultaBastanteo.modelo.BLHIS;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.CantonCatalogoVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.CantonInfo;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Cargo;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.CatalogoModeloVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.CcliCatalogo;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ClasificacionCatalog;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ConsultaNcodigParametro;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.InfoAgencia;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.InfoFuncionario;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.NacionalidadCatalogoVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Ncodig;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.NcodigClaveParametro;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.PaisInfo;
import ec.com.bancoInternacional.cs0052.DATAGENCIA;
import ec.com.bancoInternacional.cs0052.NCOEDSDATA;
import ec.com.bancoInternacional.cs0052.PRGETDATAGE;
import ec.com.bancoInternacional.cs0052.PRGETNOMAGE;
import ec.com.bancoInternacional.we0038.NCGINPDATOS;

public class ConsultaBastanteoServiceMapper {

	public List<BLHIS> mapearResultSetHaciaBlhis(ResultSet resultSet) {

		List<BLHIS> historicosBastanteoLegal = new ArrayList<BLHIS>();

		if (null == resultSet) {
			return historicosBastanteoLegal;
		}

		try {
			while (resultSet.next()) {

				BLHIS blhis = new BLHIS();
				blhis.setHISTID(resultSet.getString("HISTID"));
				blhis.setHISIDN(resultSet.getString("HISIDN"));
				blhis.setHISFEC(resultSet.getTimestamp("HISFEC"));
				blhis.setHISEST(resultSet.getString("HISEST"));
				blhis.setHISCAN(resultSet.getString("HISCAN"));
				blhis.setHISNIP(resultSet.getString("HISNIP"));
				blhis.setHISUSR(resultSet.getString("HISUSR"));
				blhis.setHISAGE(resultSet.getString("HISAGE"));
				blhis.setHISBRN(resultSet.getInt("HISBRN"));
				blhis.setHISRAZ(resultSet.getString("HISRAZ"));
				blhis.setHIRCUN(resultSet.getBigDecimal("HIRCUN"));
				blhis.setHISDAT(resultSet.getString("HISDAT"));
				historicosBastanteoLegal.add(blhis);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return historicosBastanteoLegal;

	}

	public Ncodig mapStreamCatalogConceptoToNcodig(String trama, NcodigClaveParametro parameterObject) {
		Ncodig ncodig = new Ncodig();
		String id = "";
		String idExt = "";
		String value;
		if (trama != null) {
			String[] vfila = trama.split("[|]");
			if (parameterObject.getcClaves().length == 0) {
				if (vfila.length > 0) {
					id = vfila[0].trim();
					ncodig.setId(id);
				}
			} else {
				for (int cc : parameterObject.getcClaves()) {
					if (vfila.length > cc) {
						id = id.concat(vfila[cc].trim());
						ncodig.setId(id);
					}
				}

				if (parameterObject.isKeyExt()) {
					for (int i = 0; i <= parameterObject.getcClaves()[0]; i++) {
						if (vfila.length > i)
							idExt = idExt.concat(vfila[i].trim());
						ncodig.setIdExt(idExt);
					}
				}
			}

			if (vfila.length > 5) {
				value = vfila[5];
				if (vfila.length > 9) {
					value = value + vfila[9];
				}
				ncodig.setValue(value);
			}

			if (parameterObject.isNcCod()) {
				ncodig.setNcCod(new String[4]);

				if (vfila.length > 1)
					ncodig.getNcCod()[0] = vfila[1].trim();
				if (vfila.length > 2)
					ncodig.getNcCod()[1] = vfila[2].trim();
				if (vfila.length > 3)
					ncodig.getNcCod()[2] = vfila[3].trim();
				if (vfila.length > 4)
					ncodig.getNcCod()[3] = vfila[4].trim();
			}

			if (parameterObject.isNcVal()) {
				ncodig.setNcVal(new String[3]);
				if (vfila.length > 6)
					ncodig.getNcVal()[0] = vfila[6].trim();
				if (vfila.length > 7)
					ncodig.getNcVal()[1] = vfila[7].trim();
				if (vfila.length > 8)
					ncodig.getNcVal()[2] = vfila[8].trim();
			}

			if (parameterObject.isNcDat()) {
				ncodig.setNcDat(new String[3]);
				if (vfila.length > 9)
					ncodig.getNcDat()[0] = vfila[9].trim();
				if (vfila.length > 10)
					ncodig.getNcDat()[1] = vfila[10].trim();
				if (vfila.length > 11)
					ncodig.getNcDat()[2] = vfila[11].trim();
			}

		}
		return ncodig;
	}

	public NCGINPDATOS mapNcodigParameterToNgcImpDatos(ConsultaNcodigParametro parameterObject,
			NCGINPDATOS ngcInpDatos) {
		ngcInpDatos.setNCGTABLA(parameterObject.getTabla());
		ngcInpDatos.setNCGNIVEL(BigDecimal.valueOf(Long.parseLong(parameterObject.getNivel())));
		ngcInpDatos.setNCGCODIGO1(parameterObject.getCod1());
		ngcInpDatos.setNCGCODIGO2(parameterObject.getCod2());
		ngcInpDatos.setNCGCODIGO3(parameterObject.getCod3());
		ngcInpDatos.setNCGCODIGO4(parameterObject.getCod4());

		return ngcInpDatos;

	}

	public String[] mapNcgDetalleToArray(String[] ncgDetalle) {
		String[] resp = null;
		Vector<String> vCat = new Vector<String>();
		for (String item : ncgDetalle)
			if (item != null && item.trim().length() > 0) {
				vCat.addElement(item.trim());
			} else {
				break;
			}
		int sizeCat = vCat.size();
		if (sizeCat > 0) {
			String[] aux = new String[sizeCat];
			resp = vCat.toArray(aux);
			aux = null;
		}
		vCat = null;
		return resp;
	}

	public Ncodig mapStreamToNcodig(String trama, NcodigClaveParametro parameterObject) {
		Ncodig ncodig = new Ncodig();
		String id = "";
		String idExt = "";
		String value;
		if (trama != null) {
			String[] vfila = trama.split("[|]");
			if (parameterObject.getcClaves().length == 0) {
				if (vfila.length > 0) {
					id = vfila[0].trim();
					ncodig.setId(id);
				}
			} else {
				for (int cc : parameterObject.getcClaves()) {
					if (vfila.length > cc) {
						id = id.concat(vfila[cc].trim());
						ncodig.setId(id);
					}
				}

				if (parameterObject.isKeyExt()) {
					for (int i = 0; i <= parameterObject.getcClaves()[0]; i++) {
						if (vfila.length > i)
							idExt = idExt.concat(vfila[i].trim());
						ncodig.setIdExt(idExt);
					}
				}
			}

			if (vfila.length > 5) {
				value = vfila[5].trim();
				ncodig.setValue(value);
			}

			if (parameterObject.isNcCod()) {
				ncodig.setNcCod(new String[4]);

				if (vfila.length > 1)
					ncodig.getNcCod()[0] = vfila[1].trim();
				if (vfila.length > 2)
					ncodig.getNcCod()[1] = vfila[2].trim();
				if (vfila.length > 3)
					ncodig.getNcCod()[2] = vfila[3].trim();
				if (vfila.length > 4)
					ncodig.getNcCod()[3] = vfila[4].trim();
			}

			if (parameterObject.isNcVal()) {
				ncodig.setNcVal(new String[3]);
				if (vfila.length > 6)
					ncodig.getNcVal()[0] = vfila[6].trim();
				if (vfila.length > 7)
					ncodig.getNcVal()[1] = vfila[7].trim();
				if (vfila.length > 8)
					ncodig.getNcVal()[2] = vfila[8].trim();
			}

			if (parameterObject.isNcDat()) {
				ncodig.setNcDat(new String[3]);
				if (vfila.length > 9)
					ncodig.getNcDat()[0] = vfila[9].trim();
				if (vfila.length > 10)
					ncodig.getNcDat()[1] = vfila[10].trim();
				if (vfila.length > 11)
					ncodig.getNcDat()[2] = vfila[11].trim();
			}

		}
		return ncodig;
	}

	/*
	 * mapeo de agencias
	 */
	public void mapeoDATAGEToInfoAgencia(PRGETNOMAGE getDatosAgencias, List<InfoAgencia> lstData) {
		InfoAgencia aux = null;
		for (DATAGENCIA item : getDatosAgencias.getDATAGEOUT()) {
			if (item == null)
				break;

			aux = new InfoAgencia();

			aux.setCodigoAgencia(item.getDATCAGEOUT());
			aux.setCodigoProvincia(item.getDATCPROOUT());
			aux.setNombreAgencia(item.getDATNAGEOUT());
			aux.setJefeAgencia(item.getDATJAGEOUT());

			lstData.add(aux);
		}
	}

	public List<CcliCatalogo> mappingNcoesdataToCcliCatalog(NCOEDSDATA[] data) {
		List<CcliCatalogo> ccliCatalogs = new ArrayList<CcliCatalogo>();
		for (NCOEDSDATA cn : data) {
			if (!"".equals(cn.getNCTABL()) && cn.getNCNIVL().compareTo(new BigDecimal(2)) > 0) {
				CcliCatalogo ccli = new CcliCatalogo();
				ccli.setNccod1(cn.getNCCOD1());
				ccli.setNccod2(cn.getNCCOD2());
				ccli.setNccod3(cn.getNCCOD3());
				ccli.setNccod4(cn.getNCCOD4());
				ccli.setNcdat1(cn.getNCDAT1());
				ccli.setNcdat2(cn.getNCDAT2());
				ccli.setNcdat3(cn.getNCDAT3());
				ccli.setNcdesc(cn.getNCDESC());
				ccli.setNcdisp(cn.getNCDISP());
				ccli.setNcesta(cn.getNCESTA());
				ccli.setNcfecr(cn.getNCFECR());
				ccli.setNcnive(cn.getNCNIVE());
				ccli.setNcnivl(cn.getNCNIVL());
				ccli.setNctabl(cn.getNCTABL());
				ccli.setNctime(cn.getNCTIME());
				ccli.setNcuser(cn.getNCUSER());
				ccli.setNcval1(cn.getNCVAL1());
				ccli.setNcval2(cn.getNCVAL2());
				ccli.setNcval3(cn.getNCVAL3());
				ccliCatalogs.add(ccli);
			}
		}
		return ccliCatalogs;
	}

	/*
	 * mapeo DATOFIOUT a InfoFuncionario
	 */
	public void mapeoDATOFIOUTToInfoFuncionario(PRGETDATAGE getDatAge, List<InfoFuncionario> lstAux) {
		InfoFuncionario aux = null;
		for (ec.com.bancoInternacional.cs0052.DATOFICIAL item : getDatAge.getDATOFIOUT()) {
			if (item == null)
				break;

			aux = new InfoFuncionario();
			aux.setAgencia(item.getDATAGENOUT());
			aux.setCodFuncionario(item.getDATCODIOUT());
			aux.setNombreFuncionario(item.getDATNOMBOUT());
			aux.setCodJefeAgencia(item.getDATJCODOUT());

			lstAux.add(aux);
		}
	}

	/*
	 * Busqueda por c�digo funcionario
	 * 
	 * @param List<InfoFuncionario> funcionarios
	 * 
	 * @param codFuncionario codFuncionario
	 * 
	 * @return InfoFuncionario InfoFuncionario
	 */
	public InfoFuncionario buscarFuncionario(List<InfoFuncionario> funcionarios, final String codFuncionario) {
		InfoFuncionario retorna = null;
		Predicate predicate = new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				InfoFuncionario funcionario = (InfoFuncionario) arg0;
				boolean found = true;
				try {
					found = funcionario.getCodFuncionario().equals(codFuncionario.trim());
				} catch (Exception e) {
					found = false;
				}
				return found;
			}
		};
		try {
			retorna = (InfoFuncionario) CollectionUtils.find(funcionarios, predicate);
		} catch (Exception exc) {

		} finally {
			predicate = null;
		}
		return retorna;
	}

	public List<CatalogoModeloVO> convertCountryInfoToCatalogObject(final List<PaisInfo> countries) {
		List<CatalogoModeloVO> catalogs = new LinkedList<CatalogoModeloVO>();
		for (PaisInfo cinfo : countries) {
			CatalogoModeloVO cat = new CatalogoModeloVO();
			cat.setId(cinfo.getId());
			cat.setName(cinfo.getValue());
			catalogs.add(cat);
		}
		if (catalogs != null && catalogs.size() > 0) {
			Collections.sort(catalogs, new Comparator<CatalogoModeloVO>() {
				@Override
				public int compare(CatalogoModeloVO o1, CatalogoModeloVO o2) {
					if (o1 != null && o2 != null) {
						return o1.getName().compareTo(o2.getName());
					}
					return 0;
				}
			});
		}
		return catalogs;
	}

	public List<Cargo> convertNcodigCatalogToCargo(List<Ncodig> catalogsNcodig) {
		List<Cargo> catalogs = new LinkedList<Cargo>();
		for (Ncodig nc : catalogsNcodig) {
			Cargo cargo = new Cargo();
			cargo.setValue(nc.getValue());
			cargo.setId(nc.getNcCod()[2]);
			catalogs.add(cargo);
		}
		return catalogs;
	}

	public List<CatalogoModeloVO> convertNcodigCatalogToTypeId(List<Ncodig> catalogsNcodig) {
		List<CatalogoModeloVO> catalogs = new LinkedList<CatalogoModeloVO>();
		for (Ncodig nc : catalogsNcodig) {
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getNcDat()[0]);
			catalogs.add(webCatalog);
		}
		return catalogs;
	}

	public List<NacionalidadCatalogoVO> convertNcodigToCatalogNacionalidadesObject(List<Ncodig> catalogsNcodig) {
		List<NacionalidadCatalogoVO> catalogs = new LinkedList<NacionalidadCatalogoVO>();

		for (Ncodig nc : catalogsNcodig) {
			NacionalidadCatalogoVO webCatalog = new NacionalidadCatalogoVO();
			webCatalog.setName(nc.getValue() + "-" + nc.getNcDat()[0]);
			webCatalog.setId(nc.getNcDat()[0]);
			webCatalog.setCodigoPais(nc.getId() + "-" + nc.getValue());
			catalogs.add(webCatalog);
		}
		if (catalogs != null && catalogs.size() > 0) {
			Collections.sort(catalogs, new Comparator<NacionalidadCatalogoVO>() {
				@Override
				public int compare(NacionalidadCatalogoVO o1, NacionalidadCatalogoVO o2) {
					if (o1 != null && o2 != null) {
						return o1.getName().compareTo(o2.getName());
					}
					return 0;
				}

			});
		}

		return catalogs;

	}

	public List<CantonCatalogoVO> convertCantonInfoToCatalogObject(final List<CantonInfo> cantones) {
		List<CantonCatalogoVO> catalogs = new LinkedList<CantonCatalogoVO>();
		CantonCatalogoVO cat = null;
		for (CantonInfo cinfo : cantones) {
			cat = new CantonCatalogoVO();
			cat.setId(cinfo.getId());
			cat.setName(cinfo.getValue());
			cat.setProvinceName(cinfo.getProvincia());
			catalogs.add(cat);
		}
		if (catalogs != null && catalogs.size() > 0) {
			Collections.sort(catalogs, new Comparator<CantonCatalogoVO>() {
				@Override
				public int compare(CantonCatalogoVO o1, CantonCatalogoVO o2) {
					if (o1 != null && o2 != null) {
						return o1.getName().compareTo(o2.getName());
					}
					return 0;
				}
			});
		}
		return catalogs;
	}

	public List<CatalogoModeloVO> convertCodigoProvinciaInfoToCatalogObject(List<Ncodig> provincias) {
		List<CatalogoModeloVO> catalogs = new LinkedList<CatalogoModeloVO>();
		CatalogoModeloVO cat = null;
		for (Ncodig cinfo : provincias) {
			cat = new CatalogoModeloVO();
			cat.setId(cinfo.getIdExt().trim() + cinfo.getNcVal()[0].trim());
			cat.setName(cinfo.getValue());
			catalogs.add(cat);
		}
		if (catalogs != null && catalogs.size() > 0) {
			Collections.sort(catalogs, new Comparator<CatalogoModeloVO>() {
				@Override
				public int compare(CatalogoModeloVO o1, CatalogoModeloVO o2) {
					if (o1 != null && o2 != null) {
						return o1.getName().compareTo(o2.getName());
					}
					return 0;
				}
			});
		}
		return catalogs;
	}

	public List<CatalogoModeloVO> convertNcodigCatalogToCatalogoModeloVOConcepto(List<Ncodig> catalogsNcodig) {
		List<CatalogoModeloVO> catalogs = new LinkedList<CatalogoModeloVO>();
		for (Ncodig nc : catalogsNcodig) {
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getId());
			catalogs.add(webCatalog);
		}
		return catalogs;
	}

	public List<CatalogoModeloVO> convertNcodigCatalogToCargoResponsableCatalogo(List<Ncodig> catalogsNcodig) {
		List<CatalogoModeloVO> catalogs = new LinkedList<CatalogoModeloVO>();
		for (Ncodig nc : catalogsNcodig) {
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getId());
			catalogs.add(webCatalog);
		}
		return catalogs;
	}

	public List<ClasificacionCatalog> convertNcodigToClafisicacionCatalog(List<Ncodig> clasificacionCatalog) {
		List<ClasificacionCatalog> catalogs = new LinkedList<ClasificacionCatalog>();
		ClasificacionCatalog cat = null;
		for (Ncodig cinfo : clasificacionCatalog) {
			cat = new ClasificacionCatalog();
			cat.setId(cinfo.getId());
			cat.setNombre(cinfo.getValue());
			if (cinfo.getNcDat() != null) {
				if (cinfo.getNcDat()[2].equals("S")) {
					cat.setHayMinimoDeAccionista(true);
				} else {
					cat.setHayMinimoDeAccionista(false);
				}
			}
			catalogs.add(cat);
		}
		if (catalogs != null && catalogs.size() > 0) {
			Collections.sort(catalogs, new Comparator<ClasificacionCatalog>() {
				@Override
				public int compare(ClasificacionCatalog o1, ClasificacionCatalog o2) {
					if (o1 != null && o2 != null) {
						return o1.getNombre().compareTo(o2.getNombre());
					}
					return 0;
				}
			});
		}
		return catalogs;
	}

	public List<CatalogoModeloVO> convertInfoFuncionarioToCatalogObject(List<InfoFuncionario> ctgFuncionarios) {
		List<CatalogoModeloVO> catalogs = new LinkedList<CatalogoModeloVO>();

		for (InfoFuncionario fun : ctgFuncionarios) {
			if (fun != null && fun.getCodFuncionario() != null && fun.getNombreFuncionario() != null
					&& !"".equals(fun.getCodFuncionario()) && !"".equals(fun.getNombreFuncionario())) {

				CatalogoModeloVO webCatalog = new CatalogoModeloVO();
				webCatalog.setId(fun.getCodFuncionario());
				webCatalog.setName(fun.getNombreFuncionario());
				catalogs.add(webCatalog);
			}
		}
		if (catalogs != null && catalogs.size() > 0) {
			Collections.sort(catalogs, new Comparator<CatalogoModeloVO>() {
				@Override
				public int compare(CatalogoModeloVO o1, CatalogoModeloVO o2) {
					if (o1 != null && o2 != null) {
						return o1.getName().compareTo(o2.getName());
					}
					return 0;
				}
			});
		}
		return catalogs;
	}
}
