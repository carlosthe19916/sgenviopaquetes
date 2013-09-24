package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the historial database table.
 * 
 */
@Entity
@Table(name="historial")
@NamedQuery(name="Historial.findAll", query="SELECT h FROM Historial h")
public class Historial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idhistorial;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(length=10)
	private String hora;

	@Column(name="ip_acceso", length=20)
	private String ipAcceso;

	@Column(length=30)
	private String operacion;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="idpersonal")
	private Personal personal;

	public Historial() {
	}

	public Integer getIdhistorial() {
		return this.idhistorial;
	}

	public void setIdhistorial(Integer idhistorial) {
		this.idhistorial = idhistorial;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getIpAcceso() {
		return this.ipAcceso;
	}

	public void setIpAcceso(String ipAcceso) {
		this.ipAcceso = ipAcceso;
	}

	public String getOperacion() {
		return this.operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

}