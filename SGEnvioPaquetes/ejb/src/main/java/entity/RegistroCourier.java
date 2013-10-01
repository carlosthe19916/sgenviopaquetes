package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the registro_courier database table.
 * 
 */
@Entity
@Table(name="registro_courier")
@NamedQuery(name="RegistroCourier.findAll", query="SELECT r FROM RegistroCourier r")
public class RegistroCourier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idregistro_courier")
	private Integer idregistroCourier;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String hora;

	@Column(name="tipo_registro")
	private String tipoRegistro;

	//bi-directional many-to-one association to Carga
	@ManyToOne
	@JoinColumn(name="id_carga")
	private Carga carga;

	public RegistroCourier() {
	}

	public Integer getIdregistroCourier() {
		return this.idregistroCourier;
	}

	public void setIdregistroCourier(Integer idregistroCourier) {
		this.idregistroCourier = idregistroCourier;
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

	public String getTipoRegistro() {
		return this.tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public Carga getCarga() {
		return this.carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}

}