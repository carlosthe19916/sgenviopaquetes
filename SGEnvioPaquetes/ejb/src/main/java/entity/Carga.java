package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carga database table.
 * 
 */
@Entity
@NamedQuery(name="Carga.findAll", query="SELECT c FROM Carga c")
public class Carga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcarga;

	//bi-directional many-to-one association to HorarioSalida
	@ManyToOne
	@JoinColumn(name="id_horario")
	private HorarioSalida horarioSalida;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="id_conductor")
	private Personal personal1;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="id_copiloto")
	private Personal personal2;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="id_personal_responsable")
	private Personal personal3;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="id_vehiculo")
	private Vehiculo vehiculo;

	//bi-directional many-to-one association to DetalleCarga
	@OneToMany(mappedBy="carga")
	private List<DetalleCarga> detalleCargas;

	//bi-directional many-to-one association to RegistroCourier
	@OneToMany(mappedBy="carga")
	private List<RegistroCourier> registroCouriers;

	public Carga() {
	}

	public Integer getIdcarga() {
		return this.idcarga;
	}

	public void setIdcarga(Integer idcarga) {
		this.idcarga = idcarga;
	}

	public HorarioSalida getHorarioSalida() {
		return this.horarioSalida;
	}

	public void setHorarioSalida(HorarioSalida horarioSalida) {
		this.horarioSalida = horarioSalida;
	}

	public Personal getPersonal1() {
		return this.personal1;
	}

	public void setPersonal1(Personal personal1) {
		this.personal1 = personal1;
	}

	public Personal getPersonal2() {
		return this.personal2;
	}

	public void setPersonal2(Personal personal2) {
		this.personal2 = personal2;
	}

	public Personal getPersonal3() {
		return this.personal3;
	}

	public void setPersonal3(Personal personal3) {
		this.personal3 = personal3;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<DetalleCarga> getDetalleCargas() {
		return this.detalleCargas;
	}

	public void setDetalleCargas(List<DetalleCarga> detalleCargas) {
		this.detalleCargas = detalleCargas;
	}

	public DetalleCarga addDetalleCarga(DetalleCarga detalleCarga) {
		getDetalleCargas().add(detalleCarga);
		detalleCarga.setCarga(this);

		return detalleCarga;
	}

	public DetalleCarga removeDetalleCarga(DetalleCarga detalleCarga) {
		getDetalleCargas().remove(detalleCarga);
		detalleCarga.setCarga(null);

		return detalleCarga;
	}

	public List<RegistroCourier> getRegistroCouriers() {
		return this.registroCouriers;
	}

	public void setRegistroCouriers(List<RegistroCourier> registroCouriers) {
		this.registroCouriers = registroCouriers;
	}

	public RegistroCourier addRegistroCourier(RegistroCourier registroCourier) {
		getRegistroCouriers().add(registroCourier);
		registroCourier.setCarga(this);

		return registroCourier;
	}

	public RegistroCourier removeRegistroCourier(RegistroCourier registroCourier) {
		getRegistroCouriers().remove(registroCourier);
		registroCourier.setCarga(null);

		return registroCourier;
	}

}