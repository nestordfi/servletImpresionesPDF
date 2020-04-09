package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

public class Configuracion {
    
    private String loginUrl;
    
    private String servletClienteJuridicoGwt;
    
    private String cuentasUrl;
    
    private String clientesNaturalesUrl;
    
    private String informacionTributariaBeneficiarioFinalUrl;
    
    private String checklistUrl;
    
    private Integer sessionTimeOutMinutes;

    public Configuracion() {
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String logoutRedirectUrl) {
        this.loginUrl = logoutRedirectUrl;
    }

    public String getServletClienteJuridicoGwt() {
        return servletClienteJuridicoGwt;
    }

    public void setServletClienteJuridicoGwt(String servletClienteJuridicoGwt) {
        this.servletClienteJuridicoGwt = servletClienteJuridicoGwt;
    }

	public String getCuentasUrl() {
		return cuentasUrl;
	}

	public void setCuentasUrl(String cuentasUrl) {
		this.cuentasUrl = cuentasUrl;
	}

	public String getClientesNaturalesUrl() {
		return clientesNaturalesUrl;
	}

	public void setClientesNaturalesUrl(String clientesNaturalesUrl) {
		this.clientesNaturalesUrl = clientesNaturalesUrl;
	}

	public String getInformacionTributariaBeneficiarioFinalUrl() {
		return informacionTributariaBeneficiarioFinalUrl;
	}

	public void setInformacionTributariaBeneficiarioFinalUrl(String informacionTributariaBeneficiarioFinalUrl) {
		this.informacionTributariaBeneficiarioFinalUrl = informacionTributariaBeneficiarioFinalUrl;
	}

	public String getChecklistUrl() {
		return checklistUrl;
	}

	public void setChecklistUrl(String checklistUrl) {
		this.checklistUrl = checklistUrl;
	}

    public Integer getSessionTimeOutMinutes() {
        return sessionTimeOutMinutes;
    }

    public void setSessionTimeOutMinutes(Integer sessionTimeOutMinutes) {
        this.sessionTimeOutMinutes = sessionTimeOutMinutes;
    }

}
