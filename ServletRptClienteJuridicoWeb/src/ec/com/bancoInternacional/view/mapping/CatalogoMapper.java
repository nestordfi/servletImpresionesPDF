package ec.com.bancoInternacional.view.mapping;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import ec.com.bancoInternacional.services.domain.CantonInfo;
import ec.com.bancoInternacional.services.domain.Catalogo;
import ec.com.bancoInternacional.services.domain.PaisInfo;
import ec.com.bancoInternacional.services.util.Constantes;
import ec.com.bancoInternacional.services.domain.Ncodig;
import ec.com.bancoInternacional.view.domain.CantonCatalogoVO;
import ec.com.bancoInternacional.view.domain.CatalogoModeloVO;
import ec.com.bancoInternacional.view.domain.NacionalidadCatalogoVO;

/**
 * Autor: Sandro Guevara
 * Objetivo: Mapper para transformar objetos de entrada y salida de catalogos
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */
public class CatalogoMapper implements Serializable {
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;

	public List<CatalogoModeloVO> convertNcodigToCatalogObject(List<Ncodig> catalogsNcodig){		
		List<CatalogoModeloVO>catalogs=new LinkedList<CatalogoModeloVO>();
		for(Ncodig nc:catalogsNcodig){
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getId());
			catalogs.add(webCatalog);
		}	
		return catalogs;	
	}
	
	public List<CatalogoModeloVO> convertNcodigToCatalogRelacionLaboralObject(List<Ncodig> catalogsNcodig){		
		List<CatalogoModeloVO>catalogs=new LinkedList<CatalogoModeloVO>();
		for(Ncodig nc:catalogsNcodig){
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getNcCod()[1]);
			catalogs.add(webCatalog);
		}	
		return catalogs;	
	}
	
	public List<CatalogoModeloVO> convertCountryInfoToCatalogObject(final List<PaisInfo>countries){
		List<CatalogoModeloVO> catalogs=new LinkedList<CatalogoModeloVO>();
		for(PaisInfo cinfo:countries){
			CatalogoModeloVO cat =new CatalogoModeloVO();
			cat.setId(cinfo.getId());
			cat.setName(cinfo.getValue());
			catalogs.add(cat);
		}
		return catalogs;
	}
	
	public List<NacionalidadCatalogoVO> convertNcodigToCatalogNacionalidadesObject(List<Ncodig> catalogsNcodig){		
		List<NacionalidadCatalogoVO>catalogs=new LinkedList<NacionalidadCatalogoVO>();
		for(Ncodig nc:catalogsNcodig){
			NacionalidadCatalogoVO webCatalog = new NacionalidadCatalogoVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getNcDat()[0]);
			webCatalog.setCodigoPais(nc.getId());
			catalogs.add(webCatalog);
		}	
		return catalogs;	
	}

	public List<CantonCatalogoVO> convertCantonInfoToCatalogObject(final List<CantonInfo>cantones){
		List<CantonCatalogoVO> catalogs=new LinkedList<CantonCatalogoVO>();
		CantonCatalogoVO cat=null;
		for(CantonInfo cinfo:cantones){
			cat =new CantonCatalogoVO();
			cat.setId(cinfo.getId());
			cat.setName(cinfo.getValue());
			cat.setProvinceName(cinfo.getProvincia());
			catalogs.add(cat);
		}
		return catalogs;
	}
	
	public List<CatalogoModeloVO> convertCodigoProvinciaInfoToCatalogObject(List<Ncodig> provincias){
		List<CatalogoModeloVO> catalogs=new LinkedList<CatalogoModeloVO>();
		CatalogoModeloVO cat=null;
		for(Ncodig cinfo:provincias){
			cat =new CatalogoModeloVO();
			cat.setId(cinfo.getIdExt());
			cat.setName(cinfo.getValue());
			catalogs.add(cat);
		}
		return catalogs;
	}
	
	public List<CatalogoModeloVO> convertNcodigCatalogToTypeId(List<Ncodig> catalogsNcodig){
		List<CatalogoModeloVO>catalogs=new LinkedList<CatalogoModeloVO>();
		for(Ncodig nc:catalogsNcodig){
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getNcDat()[0]);
			catalogs.add(webCatalog);
		}	
		return catalogs;	
	}
	
	public List<CatalogoModeloVO> convertCnofcToCatalogObject(List<Catalogo> ctgCargos){
		List<CatalogoModeloVO> catalogs = new LinkedList<CatalogoModeloVO>();
		
		if(ctgCargos == null)
			return catalogs;
					
		for(Catalogo nc:ctgCargos){
			if(nc == null)
				continue;
			
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getId());
			catalogs.add(webCatalog);
		}	
		return catalogs;	
	}
	
	public List<CatalogoModeloVO> convertNcodigToCatalogIdCod3Object(List<Ncodig> catalogsNcodig){		
		List<CatalogoModeloVO>catalogs=new LinkedList<CatalogoModeloVO>();
		for(Ncodig nc:catalogsNcodig){
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getNcCod()[2]);
			catalogs.add(webCatalog);
		}	
		return catalogs;	
	}
	
	public List<CatalogoModeloVO> convertNcodigToCatalogIdCod2Object(List<Ncodig> catalogsNcodig){		
		List<CatalogoModeloVO>catalogs=new LinkedList<CatalogoModeloVO>();
		for(Ncodig nc:catalogsNcodig){
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getNcCod()[1]);
			catalogs.add(webCatalog);
		}	
		return catalogs;	
	}

	public List<CatalogoModeloVO> convertNcodigToCatalogIdExtObject(List<Ncodig> catalogsNcodig){		
		List<CatalogoModeloVO>catalogs=new LinkedList<CatalogoModeloVO>();
		for(Ncodig nc:catalogsNcodig){
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getIdExt());
			catalogs.add(webCatalog);
		}	
		return catalogs;	
	}
	
	public List<CatalogoModeloVO> convertNcodigToCatalogIdCod0Object(List<Ncodig> catalogsNcodig){		
		List<CatalogoModeloVO>catalogs=new LinkedList<CatalogoModeloVO>();
		for(Ncodig nc:catalogsNcodig){
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getNcCod()[0]);
			catalogs.add(webCatalog);
		}	
		return catalogs;	
	}
		
	public List<CatalogoModeloVO> convertNcodigCatalogToTypeIdExt(List<Ncodig> catalogsNcodig) {
		List<CatalogoModeloVO> catalogs = new LinkedList<CatalogoModeloVO>();
		for (Ncodig nc : catalogsNcodig) {
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue().trim());
			webCatalog.setId(nc.getIdExt());
			catalogs.add(webCatalog);
		}
		return catalogs;
	}

	public List<CatalogoModeloVO> convertNcodigCondicionCatalogToTypeIdExt(List<Ncodig> catalogsNcodig){		
		List<CatalogoModeloVO>catalogs=new LinkedList<CatalogoModeloVO>();
		for(Ncodig nc:catalogsNcodig){
			if(Constantes.CONST_BOOLEANOS_S.equals(nc.getNcDat()[0].trim())){
				CatalogoModeloVO webCatalog = new CatalogoModeloVO();
				webCatalog.setName(nc.getValue().trim());
				webCatalog.setId(nc.getIdExt());
				catalogs.add(webCatalog);
			}
		}	
		return catalogs;	
	}
	
	public List<CatalogoModeloVO> convertNcodigToCatalogCargosObject(List<Ncodig> catalogsNcodig){		
		List<CatalogoModeloVO>catalogs=new LinkedList<CatalogoModeloVO>();
		for(Ncodig nc:catalogsNcodig){
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getNcCod()[2]);
			catalogs.add(webCatalog);
		}	
		return catalogs;	
	}
	
	public List<CatalogoModeloVO> convertNcodigTipoIdentificacionReporteCertificacion(List<Ncodig> catalogsNcodig){
		List<CatalogoModeloVO>catalogs=new LinkedList<CatalogoModeloVO>();
		if (catalogsNcodig == null) {
			return catalogs;
		}
		for(Ncodig nc:catalogsNcodig){
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getNcCod()[1]);
			catalogs.add(webCatalog);
		}	
		return catalogs;	
	}
	
	public List<CatalogoModeloVO> convertNcodigPaisReporteCertificacion(List<Ncodig> catalogsNcodig){
		List<CatalogoModeloVO>catalogs=new LinkedList<CatalogoModeloVO>();
		if (catalogsNcodig == null) {
			return catalogs;
		}
		for(Ncodig nc:catalogsNcodig){
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getIdExt());
			catalogs.add(webCatalog);
		}	
		return catalogs;	
	}
	
	public List<CatalogoModeloVO> convertNcodigDepartamentoReporteCertificacion(List<Ncodig> catalogsNcodig){
		List<CatalogoModeloVO>catalogs=new LinkedList<CatalogoModeloVO>();
		if (catalogsNcodig == null) {
			return catalogs;
		}
		for(Ncodig nc:catalogsNcodig){
			CatalogoModeloVO webCatalog = new CatalogoModeloVO();
			webCatalog.setName(nc.getValue());
			webCatalog.setId(nc.getIdExt());
			catalogs.add(webCatalog);
		}	
		return catalogs;	
	}
	

}
