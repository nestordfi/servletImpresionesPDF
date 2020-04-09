package ec.com.bancoInternacional.ConsultaBastanteo.dataManager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import ec.com.bancoInternacional.ConsultaBastanteo.modelo.AccionistaImpresion;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.AccionistasSeccionVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.CantonCatalogoVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Cargo;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.CatalogoModeloVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ClasificacionCatalog;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Cliente;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.DatosImpresion;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.DocumentoExaminadoImpresion;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.DocumentosExaminadosSubSeccionVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.FuncionarioResponsable;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.LimitacionImpresion;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.LimitacionSubSeccionVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.NacionalidadCatalogoVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Ncodig;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ObservacionSubSeccionVO;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ObsevacionImpresion;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.RepresentanteLegalImpresion;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.RepresentantesLegalesSeccionVO;
import ec.com.bancoInternacional.ConsultaBastanteo.singleton.CatalogosCache;
import ec.com.bancoInternacional.ConsultaBastanteo.util.ApplicationManager;
import ec.com.bancoInternacional.ConsultaBastanteo.util.Constantes;
import ec.com.bancoInternacional.ConsultaBastanteo.util.FormatoUtil;
import ec.com.bancoInternacional.ConsultaBastanteo.util.GeneralUtil;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReporteBastanteoHistoricoDM {
	
	private GeneralUtil generalUtil = new GeneralUtil();
	
	public byte[] obtenerPdf(CatalogosCache catalogosCache, Map<String, Object> parametros, Cliente cliente) throws JRException {

		JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(ApplicationManager.getString("app.contenido.reporte")+(ApplicationManager.getString("app.nombre.reporte.general")));
		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros,
				this.obtenerDataSourceReporte(catalogosCache, cliente));
		removeBlankPage(jasperPrint.getPages());
		byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
		return bytes;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> obtenerParametrosReporte(CatalogosCache catalogosCache, Cliente cliente) {

		Map<String, Object> parametros = new HashMap<>();

		// Ubicacion de imagenes en proyecto
		parametros.put("IMG_DIR", ApplicationManager.getString("app.contenido.reporte"));

		// Seccion Identificacion
		parametros.put("txtIdentificacion", cliente.getIdentificacionSeccionVO().getTxtIdentificacion().toUpperCase());
		parametros.put("cmbTipoIdentificacion", generalUtil.obtenerNombrePorCodigoModeloVO(
				cliente.getIdentificacionSeccionVO().getCmbTipoIdentificacion(),
				(List<CatalogoModeloVO>) catalogosCache.getCommonCatalogsMap().get(Constantes.ID_TYPE_CATALOG_KEY))
				.toUpperCase());
		parametros.put("txtRazonSocialBasica", cliente.getIdentificacionSeccionVO().getTxtRazonSocial().toUpperCase());
		parametros.put("txtCodigoCliente", cliente.getIdentificacionSeccionVO().getTxtCodigoCliente().toUpperCase());
		parametros.put("fechaActualizacion",
				FormatoUtil.obtenerFechaToString(cliente.getResponsableSubSeccionVO().getDteFechaActualizacion()));

		// Seccion Basica
		parametros.put("txtRazonSocialBasica", cliente.getBasicaSeccionVO().getTxtRazonSocial().toUpperCase());
		parametros.put("txtNombreComercialBasica", cliente.getBasicaSeccionVO().getTxtNombreComercial().toUpperCase());
		parametros.put("txtObjetoSocialBasica", cliente.getBasicaSeccionVO().getTxtObjetoSocial());
		parametros.put("cmbPaisConstitucionBasica", generalUtil.obtenerNombrePorCodigoModeloVO(
				cliente.getBasicaSeccionVO().getCmbPaisConstitucion(),
				(List<CatalogoModeloVO>) catalogosCache.getCommonCatalogsMap().get(Constantes.COUNTRIES_CATALOG_KEY))
				.toUpperCase());
		parametros.put("cmbCantonResidenciaBasica", generalUtil.obtenerNombrePorCodigoCantonVO(
				cliente.getBasicaSeccionVO().getCmbCantonResidencia(),
				(List<CantonCatalogoVO>) catalogosCache.getCommonCatalogsMap().get(Constantes.CANTONES_CATALOG_KEY))
				.toUpperCase());
		parametros.put("cmbProvinciaResidenciaBasica",
				generalUtil.obtenerNombrePorCodigoModeloVO(cliente.getBasicaSeccionVO().getCmbProvinciaResidencia(),
						(List<CatalogoModeloVO>) catalogosCache.getCommonCatalogsMap()
								.get(Constantes.COD_PROVINCIA_CATALOG_KEY))
						.toUpperCase());
		parametros.put("txtCapitalSuscritoBasica", cliente.getBasicaSeccionVO().getTxtCapitalSuscrito());
		parametros.put("dteFechaConstitucionBasica",
				FormatoUtil.obtenerFechaToString(cliente.getBasicaSeccionVO().getDteFechaConstitucion()));
		parametros.put("dteFechaVencimientoBasica",
				FormatoUtil.obtenerFechaToString(cliente.getBasicaSeccionVO().getDteFechaVencimiento()));
		parametros.put("txtDuracionBasica", cliente.getBasicaSeccionVO().getTxtDuracion());
		parametros.put("txtClasificacionBasica", generalUtil.obtenerNombreClasificacion(
				cliente.getBasicaSeccionVO().getTxtClasificacion(),
				(List<ClasificacionCatalog>) catalogosCache.getCommonCatalogsMap().get(Constantes.CLASIFICACION_CATALOG)));

		// Seccion Accionista Radio Estatico
		parametros.put("naturalJuridicoAccionistas", cliente.getRadCapitalAccionista());

		// Seccion Responsable
		parametros.put("dteFechaActualizacionResponsable",
				FormatoUtil.obtenerFechaToString(cliente.getResponsableSubSeccionVO().getDteFechaActualizacion()));
		parametros
				.put("cmbCargoResponsable",
						generalUtil.obtenerNombrePorCodigoModeloVO(
								cliente.getResponsableSubSeccionVO().getCmbCargoResponsable(),
								(List<CatalogoModeloVO>) catalogosCache.getCommonCatalogsMap()
										.get(Constantes.CARGOS_RESPONSABLE_CATALOG_KEY))
								.toUpperCase());
		String nombreResponsable = generalUtil.obtenerFuncionarioResponsablePorId(
				cliente.getResponsableSubSeccionVO().getCmbNombreResponsable() != null
						&& !"".equals(cliente.getResponsableSubSeccionVO().getCmbNombreResponsable())
								? cliente.getResponsableSubSeccionVO().getCmbNombreResponsable() : "",
				(List<FuncionarioResponsable>) catalogosCache.getCommonCatalogsMap()
						.get(Constantes.FUNCIONARIOS_RESPONSABLES_CATALOG))
				.getNombre().toUpperCase();
		parametros.put("cmbNombreResponsable", nombreResponsable);
		parametros.put("cmbEjecutivoPrincipal", generalUtil.obtenerNombrePorCodigoModeloVO(
				cliente.getResponsableSubSeccionVO().getCmbEjecutivoPrincipal(),
				(List<CatalogoModeloVO>) catalogosCache.getCommonCatalogsMap().get(Constantes.FUNCIONARIOS_CATALOG))
				.toUpperCase());

		// Subreportes
		parametros.put("subReporteRepresentante", ApplicationManager.getString("app.contenido.reporte")+ApplicationManager.getString("app.nombre.reporte.representante"));
		parametros.put("subReporteAccionista", ApplicationManager.getString("app.contenido.reporte")+ApplicationManager.getString("app.nombre.reporte.accionista"));
		parametros.put("subReporteLimitaciones", ApplicationManager.getString("app.contenido.reporte")+ApplicationManager.getString("app.nombre.reporte.limitaciones"));
		parametros.put("subReporteDocumentosExaminados",ApplicationManager.getString("app.contenido.reporte")+ApplicationManager.getString("app.nombre.reporte.documentos"));
		parametros.put("subReporteObservaciones", ApplicationManager.getString("app.contenido.reporte")+ApplicationManager.getString("app.nombre.reporte.observaciones"));

		return parametros;
	}

	@SuppressWarnings("unchecked")
	private JRDataSource obtenerDataSourceReporte(CatalogosCache catalogosCache, Cliente cliente) {
		// Cambios a Cliente antes de imprimir
		Cliente clienteAS400 = (Cliente) this.copyObject(cliente);

		GeneralUtil.filtrarAccionistasVisibleOcultosPorPorcentajeMinimo(clienteAS400,
				((List<Ncodig>) catalogosCache.getCommonCatalogsMap().get(Constantes.PCJ_ACC_CATALOG)).get(0)
						.getNcDat()[0]);

		clienteAS400.setRepresentantesLegales(GeneralUtil.ordenarPorNombreAlfabeticamenteRepresentantes(clienteAS400));
		clienteAS400.setAccionistas(GeneralUtil.ordenarPorPorcentajeAccionistas(clienteAS400));

		DatosImpresion dato = new DatosImpresion();
		List<DatosImpresion> datos = new ArrayList<>();
		dato.setListaRepresentantesLegal(this.obtenerRepresentantesDS(catalogosCache, clienteAS400));
		dato.setListaAccionista(this.obtenerAccionistaDS(catalogosCache, clienteAS400));
		dato.setListaDocumento(this.obtenerDocumentoDS(catalogosCache, clienteAS400));
		dato.setListaLimitacion(this.obtenerLimitacionDS(catalogosCache, clienteAS400));
		dato.setListaObservaciones(this.obtenerObservacionDS(catalogosCache, clienteAS400));
		datos.add(dato);
		clienteAS400 = null;
		return new JRBeanCollectionDataSource(datos, false);
	}

	public String getImageRealPath() {
		return this.getRealPath() + File.separator + "resources" + File.separator + "img" + File.separator;
	}

	private String getRealPath() {
		String webContentRoot = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
		return webContentRoot;
	}

	@SuppressWarnings("unchecked")
	private List<RepresentanteLegalImpresion> obtenerRepresentantesDS(CatalogosCache catalogosCache,Cliente cliente) {
		List<RepresentanteLegalImpresion> listaRep = new ArrayList<>();
		for (int i = 0; i < cliente.getRepresentantesLegales().size(); i++) {
			RepresentanteLegalImpresion representante = new RepresentanteLegalImpresion();
			RepresentantesLegalesSeccionVO rep = cliente.getRepresentantesLegales().get(i);
			representante.setCargoRep(generalUtil
					.obtenerNombrePorCodigoCargo(rep.getCmbCargoRep(),
							(List<Cargo>) catalogosCache.getCommonCatalogsMap().get(Constantes.CARGOS_CATALOG_KEY))
					.toUpperCase());
			representante.setFechaInscripcionRep(FormatoUtil.obtenerFechaToString(rep.getDteFechaInscripcionRep()));
			representante.setFechaVencimientoRep(FormatoUtil.obtenerFechaToString(rep.getDteFechaVencimientoRep()));
			representante.setIdentificacionRep(rep.getTxtIdentificacionRep().toUpperCase());
			representante.setIndexRep(i + 1 + "");
			representante.setNacionalidadRep(generalUtil.obtenerNombrePorCodigoNacionalidadCatalogoVO(
					rep.getCmbNacionalidadRep(), (List<NacionalidadCatalogoVO>) catalogosCache.getCommonCatalogsMap()
							.get(Constantes.NACIONALIDAD_KEY))
					.toUpperCase());
			representante.setNombreApellidoRep(rep.getTxtNombreApellidoRep().toUpperCase());
			representante.setTipoIdentificacionRep(generalUtil.obtenerNombrePorCodigoModeloVO(
					rep.getCmbTipoIdentificacionRep(), (List<CatalogoModeloVO>) catalogosCache.getCommonCatalogsMap()
							.get(Constantes.ID_TYPE_CATALOG_KEY)));
			listaRep.add(representante);
		}
		return listaRep;
	}

	@SuppressWarnings("unchecked")
	private List<AccionistaImpresion> obtenerAccionistaDS(CatalogosCache catalogosCache, Cliente cliente) {
		List<AccionistaImpresion> listaAcc = new ArrayList<>();
		for (int i = 0; i < cliente.getAccionistas().size(); i++) {
			AccionistaImpresion accionista = new AccionistaImpresion();
			AccionistasSeccionVO acc = cliente.getAccionistas().get(i);
			accionista.setIdentificacionAccionistas(acc.getTxtIdentificacionAccionistas().toUpperCase());
			accionista.setIndexAccionistas(i + 1 + "");
			accionista.setMontoAccionistas(acc.getTxtMontoAccionistas());
			accionista.setNacionalidadAccionistas(generalUtil.obtenerNombrePorCodigoNacionalidadCatalogoVO(
					acc.getCmbNacionalidadAccionistas(), (List<NacionalidadCatalogoVO>) catalogosCache
							.getCommonCatalogsMap().get(Constantes.NACIONALIDAD_KEY))
					.toUpperCase());
			accionista.setNaturalJuridicoAccionistas(acc.getRadNaturalJuridicoAccionistas());
			accionista.setNombreRazonSocialAccionistas(generalUtil.obtenerNombreAccionista(acc).toUpperCase());
			accionista.setPorcentajeAccionistas(acc.getTxtPorcentajeAccionistas());
			accionista.setTipoIdentificacionAccionistas(acc.getCmbTipoIdentificacion().equals(Constantes.PASAPORTE_TIPO_ID) ? Constantes.PASAPORTE_TIPO_ID_P : acc.getCmbTipoIdentificacion());
			listaAcc.add(accionista);
		}
		return listaAcc;
	}

	@SuppressWarnings("unchecked")
	private List<DocumentoExaminadoImpresion> obtenerDocumentoDS(CatalogosCache catalogosCache, Cliente cliente) {
		List<DocumentoExaminadoImpresion> listaDoc = new ArrayList<>();
		for (int i = 0; i < cliente.getDocumentosExaminados().size(); i++) {
			DocumentoExaminadoImpresion documento = new DocumentoExaminadoImpresion();
			DocumentosExaminadosSubSeccionVO doc = cliente.getDocumentosExaminados().get(i);
			documento.setConceptoDoc(generalUtil.obtenerNombrePorCodigoModeloVO(doc.getCmbConceptoDoc(),
					(List<CatalogoModeloVO>) catalogosCache.getCommonCatalogsMap().get(Constantes.CONCEPT_CATALOG_KEY))
					.toUpperCase());
			documento.setFechaDoc(FormatoUtil.obtenerFechaToString(doc.getDteFechaDoc()));
			documento.setFechaInscripcionDoc(FormatoUtil.obtenerFechaToString(doc.getDteFechaInscripcionDoc()));
			documento.setIndexDoc(i + 1 + "");
			documento.setNotaria(doc.getTxtNotaria().toUpperCase());
			documento.setTipoDoc(doc.getRadTipoDoc().toUpperCase());
			listaDoc.add(documento);
		}
		return listaDoc;
	}

	private List<LimitacionImpresion> obtenerLimitacionDS(CatalogosCache catalogosCache, Cliente cliente) {
		List<LimitacionImpresion> listaLim = new ArrayList<>();
		for (int i = 0; i < cliente.getLimitacionesRestricciones().size(); i++) {
			LimitacionImpresion limitacion = new LimitacionImpresion();
			LimitacionSubSeccionVO lim = cliente.getLimitacionesRestricciones().get(i);
			limitacion.setTxtDescripcionLim(lim.getTxtDescripcion());
			listaLim.add(limitacion);
		}
		return listaLim;
	}

	private List<ObsevacionImpresion> obtenerObservacionDS(CatalogosCache catalogosCache, Cliente cliente) {
		List<ObsevacionImpresion> listaObj = new ArrayList<>();
		for (int i = 0; i < cliente.getObservaciones().size(); i++) {
			ObsevacionImpresion observacion = new ObsevacionImpresion();
			ObservacionSubSeccionVO obj = cliente.getObservaciones().get(i);
			observacion.setTxtDescripcionObs(obj.getTxtDescripcion());
			listaObj.add(observacion);
		}
		return listaObj;
	}

	private Object copyObject(Object objSource) {
		Object objDest = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(objSource);
			oos.flush();
			oos.close();
			bos.close();
			byte[] byteData = bos.toByteArray();
			ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
			try {
				objDest = new ObjectInputStream(bais).readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objDest;
	}

	private void removeBlankPage(List<JRPrintPage> pages) {

		for (Iterator<JRPrintPage> i = pages.iterator(); i.hasNext();) {
			JRPrintPage page = i.next();
			if (page.getElements().size() == 0)
				i.remove();
		}
	}

}
