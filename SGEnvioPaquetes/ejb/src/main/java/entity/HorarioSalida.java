package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the horario_salida database table.
 * 
 */
@Entity
@Table(name="horario_salida")
@NamedQuery(name="HorarioSalida.findAll", query="SELECT h FROM HorarioSalida h")
public class HorarioSalida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idhorario_salida", unique=true, nullable=false)
	private Integer idhorarioSalida;

	@Column(name="hora_llega", length=20)
	private String horaLlega;

	@Column(name="hora_salida", length=20)
	private String horaSalida;

	//bi-directional many-to-one association to Carga
	@OneToMany(mappedBy="horarioSalida")
	private List<Carga> cargas;

	//bi-directional many-to-one association to Ruta
	@ManyToOne
	@JoinColumn(name="id_ruta")
	private Ruta ruta;

	public HorarioSalida() {
	}

	public Integer getIdhorarioSalida() {
		return this.idhorarioSalida;
	}

	public void setIdhorarioSalida(Integer idhorarioSalida) {
		this.idhorarioSalida = idhorarioSalida;
	}

	public String getHoraLlega() {
		return this.horaLlega;
	}

	public void setHoraLlega(String horaLlega) {
		this.horaLlega = horaLlega;
	}

	public String getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public List<Carga> getCargas() {
		return this.cargas;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}

	public Carga addCarga(Carga carga) {
		getCargas().add(carga);
		carga.setHorarioSalida(this);

		return carga;
	}

	public Carga removeCarga(Carga carga) {
		getCargas().remove(carga);
		carga.setHorarioSalida(null);

		return carga;
	}

	public Ruta getRuta() {
		return this.ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

}