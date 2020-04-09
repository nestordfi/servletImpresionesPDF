package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

public class CantonInfo extends Catalogo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigoProvincia;	
	private String prefijoTlfProvincia;	
	private String provincia;
	
	public CantonInfo() {
		super();
	}

	public CantonInfo(String codigoProvincia, String prefijoTlfProvincia, String provincia) {
		super();
		this.codigoProvincia = codigoProvincia;
		this.prefijoTlfProvincia = prefijoTlfProvincia;
		this.provincia = provincia;
	}

	public String getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public String getPrefijoTlfProvincia() {
		return prefijoTlfProvincia;
	}

	public void setPrefijoTlfProvincia(String prefijoTlfProvincia) {
		this.prefijoTlfProvincia = prefijoTlfProvincia;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
}
