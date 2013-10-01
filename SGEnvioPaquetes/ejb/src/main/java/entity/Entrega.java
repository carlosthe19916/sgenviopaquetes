package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the entrega database table.
 * 
 */
@Entity
@NamedQuery(name="Entrega.findAll", query="SELECT e FROM Entrega e")
public class Entrega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer identrega;

	private String consignatario;

	@Column(name="dni_consignatario")
	private String dniConsignatario;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_entrega")
	private Date fechaEntrega;

	@Column(name="hora_entrega")
	private String horaEntrega;

	//bi-directional many-to-one association to OrdenServico
	@ManyToOne
	@JoinColumn(name="id_orden_servicio")
	private OrdenServico ordenServico;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="id_personal_responsable")
	private Personal personal;

	//bi-directional many-to-one association to EntregaDomicilio
	@OneToMany(mappedBy="entrega")
	private List<EntregaDomicilio> entregaDomicilios;

	public Entrega() {
	}

	public Integer getIdentrega() {
		return this.identrega;
	}

	public void setIdentrega(Integer identrega) {
		this.identrega = identrega;
	}

	public String getConsignatario() {
		return this.consignatario;
	}

	public void setConsignatario(String consignatario) {
		this.consignatario = consignatario;
	}

	public String getDniConsignatario() {
		return this.dniConsignatario;
	}

	public void setDniConsignatario(String dniConsignatario) {
		this.dniConsignatario = dniConsignatario;
	}

	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getHoraEntrega() {
		return this.horaEntrega;
	}

	public void setHoraEntrega(String horaEntrega) {
		this.horaEntrega = horaEntrega;
	}

	public OrdenServico getOrdenServico() {
		return this.ordenServico;
	}

	public void setOrdenServico(OrdenServico ordenServico) {
		this.ordenServico = ordenServico;
	}

	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public List<EntregaDomicilio> getEntregaDomicilios() {
		return this.entregaDomicilios;
	}

	public void setEntregaDomicilios(List<EntregaDomicilio> entregaDomicilios) {
		this.entregaDomicilios = entregaDomicilios;
	}

	public EntregaDomicilio addEntregaDomicilio(EntregaDomicilio entregaDomicilio) {
		getEntregaDomicilios().add(entregaDomicilio);
		entregaDomicilio.setEntrega(this);

		return entregaDomicilio;
	}

	public EntregaDomicilio removeEntregaDomicilio(EntregaDomicilio entregaDomicilio) {
		getEntregaDomicilios().remove(entregaDomicilio);
		entregaDomicilio.setEntrega(null);

		return entregaDomicilio;
	}

}