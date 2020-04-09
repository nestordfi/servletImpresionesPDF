package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

public class CredencialLight {

    private int bthUbr;
    private String bthNom;
    private String usuario;
    private String fecha;
    private String hora;
    private String usuarioCifrado;
    private boolean seguridadIBS = true;
    
    public CredencialLight(int bthUbr, String bthNom, String usuario, String fecha, String hora, String usuarioCifrado, boolean seguridadIBS) {
        super();
        this.bthUbr = bthUbr;
        this.bthNom = bthNom;
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.usuarioCifrado = usuarioCifrado;
        this.seguridadIBS = seguridadIBS;
    }
    public int getBthUbr() {
        return bthUbr;
    }
    public void setBthUbr(int bthUbr) {
        this.bthUbr = bthUbr;
    }
    public String getBthNom() {
        return bthNom;
    }
    public void setBthNom(String bthNom) {
        this.bthNom = bthNom;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
	public String getUsuarioCifrado() {
		return usuarioCifrado;
	}
	public void setUsuarioCifrado(String usuarioCifrado) {
		this.usuarioCifrado = usuarioCifrado;
	}
	public boolean isSeguridadIBS() {
		return seguridadIBS;
	}
	public void setSeguridadIBS(boolean seguridadIBS) {
		this.seguridadIBS = seguridadIBS;
	}	
}
