package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.util.Objects;

/**
 * ObjCliente
 */
public class ObjCliente   {
  private String id = null;

  private String nroIbs = null;

  private String tipo = null;

  private String value = null;

  private String nombreCorto = null;

  private String transaccion = null;

  public ObjCliente id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ObjCliente nroIbs(String nroIbs) {
    this.nroIbs = nroIbs;
    return this;
  }

  /**
   * Get nroIbs
   * @return nroIbs
  **/
  public String getNroIbs() {
    return nroIbs;
  }

  public void setNroIbs(String nroIbs) {
    this.nroIbs = nroIbs;
  }

  public ObjCliente tipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Get tipo
   * @return tipo
  **/
  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public ObjCliente value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public ObjCliente nombreCorto(String nombreCorto) {
    this.nombreCorto = nombreCorto;
    return this;
  }

  /**
   * Get nombreCorto
   * @return nombreCorto
  **/
  public String getNombreCorto() {
    return nombreCorto;
  }

  public void setNombreCorto(String nombreCorto) {
    this.nombreCorto = nombreCorto;
  }

  public ObjCliente transaccion(String transaccion) {
    this.transaccion = transaccion;
    return this;
  }

  /**
   * Get transaccion
   * @return transaccion
  **/
  public String getTransaccion() {
    return transaccion;
  }

  public void setTransaccion(String transaccion) {
    this.transaccion = transaccion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjCliente objCliente = (ObjCliente) o;
    return Objects.equals(this.id, objCliente.id) &&
        Objects.equals(this.nroIbs, objCliente.nroIbs) &&
        Objects.equals(this.tipo, objCliente.tipo) &&
        Objects.equals(this.value, objCliente.value) &&
        Objects.equals(this.nombreCorto, objCliente.nombreCorto) &&
        Objects.equals(this.transaccion, objCliente.transaccion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nroIbs, tipo, value, nombreCorto, transaccion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjCliente {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nroIbs: ").append(toIndentedString(nroIbs)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    nombreCorto: ").append(toIndentedString(nombreCorto)).append("\n");
    sb.append("    transaccion: ").append(toIndentedString(transaccion)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
