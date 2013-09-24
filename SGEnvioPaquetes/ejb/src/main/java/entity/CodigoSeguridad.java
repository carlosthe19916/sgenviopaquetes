package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the codigo_seguridad database table.
 * 
 */
@Entity
@Table(name="codigo_seguridad")
@NamedQuery(name="CodigoSeguridad.findAll", query="SELECT c FROM CodigoSeguridad c")
public class CodigoSeguridad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idcodigo_seguridad", unique=true, nullable=false)
	private Integer idcodigoSeguridad;

	@Column(name="codigo_asignado_cliente", length=30)
	private String codigoAsignadoCliente;

	@Column(name="codigo_barras")
	private byte[] codigoBarras;

	//bi-directional many-to-one association to Paquete
	@ManyToOne
	@JoinColumn(name="id_paquete")
	private Paquete paquete;

	public CodigoSeguridad() {
	}

	public Integer getIdcodigoSeguridad() {
		return this.idcodigoSeguridad;
	}

	public void setIdcodigoSeguridad(Integer idcodigoSeguridad) {
		this.idcodigoSeguridad = idcodigoSeguridad;
	}

	public String getCodigoAsignadoCliente() {
		return this.codigoAsignadoCliente;
	}

	public void setCodigoAsignadoCliente(String codigoAsignadoCliente) {
		this.codigoAsignadoCliente = codigoAsignadoCliente;
	}

	public byte[] getCodigoBarras() {
		return this.codigoBarras;
	}

	public void setCodigoBarras(byte[] codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Paquete getPaquete() {
		return this.paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

}