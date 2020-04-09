package ec.com.bancoInternacional.services.domain;

import java.io.Serializable;

public class ListHelper implements Serializable {
	private static final long serialVersionUID = -4725243419215601648L;

	protected String id = "";
	protected String value = "";
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}//finde la clase