package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the entrega_domicilio database table.
 * 
 */
@Entity
@Table(name="entrega_domicilio")
@NamedQuery(name="EntregaDomicilio.findAll", query="SELECT e FROM EntregaDomicilio e")
public class EntregaDomicilio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="identrega_domicilio", unique=true, nullable=false)
	private Integer identregaDomicilio;

	@Column(name="costo_envio")
	private double costoEnvio;

	@Column(name="direccion_entrega", length=200)
	private String direccionEntrega;

	@Column(name="estado_solicitud", length=15)
	private String estadoSolicitud;

	//bi-directional many-to-one association to Entrega
	@ManyToOne
	@JoinColumn(name="id_entrega")
	private Entrega entrega;

	public EntregaDomicilio() {
	}

	public Integer getIdentregaDomicilio() {
		return this.identregaDomicilio;
	}

	public void setIdentregaDomicilio(Integer identregaDomicilio) {
		this.identregaDomicilio = identregaDomicilio;
	}

	public double getCostoEnvio() {
		return this.costoEnvio;
	}

	public void setCostoEnvio(double costoEnvio) {
		this.costoEnvio = costoEnvio;
	}

	public String getDireccionEntrega() {
		return this.direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public String getEstadoSolicitud() {
		return this.estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	public Entrega getEntrega() {
		return this.entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

}