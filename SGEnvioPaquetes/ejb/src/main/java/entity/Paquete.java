package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the paquete database table.
 * 
 */
@Entity
@Table(name="paquete")
@NamedQuery(name="Paquete.findAll", query="SELECT p FROM Paquete p")
public class Paquete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idpaquete;

	private Integer cantidad;

	@Column(length=50)
	private String descripcion;

	private double importe;

	//bi-directional many-to-one association to CodigoSeguridad
	@OneToMany(mappedBy="paquete")
	private List<CodigoSeguridad> codigoSeguridads;

	//bi-directional many-to-one association to OrdenServico
	@ManyToOne
	@JoinColumn(name="id_orden")
	private OrdenServico ordenServico;

	public Paquete() {
	}

	public Integer getIdpaquete() {
		return this.idpaquete;
	}

	public void setIdpaquete(Integer idpaquete) {
		this.idpaquete = idpaquete;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getImporte() {
		return this.importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public List<CodigoSeguridad> getCodigoSeguridads() {
		return this.codigoSeguridads;
	}

	public void setCodigoSeguridads(List<CodigoSeguridad> codigoSeguridads) {
		this.codigoSeguridads = codigoSeguridads;
	}

	public CodigoSeguridad addCodigoSeguridad(CodigoSeguridad codigoSeguridad) {
		getCodigoSeguridads().add(codigoSeguridad);
		codigoSeguridad.setPaquete(this);

		return codigoSeguridad;
	}

	public CodigoSeguridad removeCodigoSeguridad(CodigoSeguridad codigoSeguridad) {
		getCodigoSeguridads().remove(codigoSeguridad);
		codigoSeguridad.setPaquete(null);

		return codigoSeguridad;
	}

	public OrdenServico getOrdenServico() {
		return this.ordenServico;
	}

	public void setOrdenServico(OrdenServico ordenServico) {
		this.ordenServico = ordenServico;
	}

}