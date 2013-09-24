package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ruta database table.
 * 
 */
@Entity
@Table(name="ruta")
@NamedQuery(name="Ruta.findAll", query="SELECT r FROM Ruta r")
public class Ruta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idruta;

	//bi-directional many-to-one association to HorarioSalida
	@OneToMany(mappedBy="ruta")
	private List<HorarioSalida> horarioSalidas;

	//bi-directional many-to-one association to Ubigeo
	@ManyToOne
	@JoinColumn(name="id_origen")
	private Ubigeo ubigeo1;

	//bi-directional many-to-one association to Ubigeo
	@ManyToOne
	@JoinColumn(name="id_destino")
	private Ubigeo ubigeo2;

	//bi-directional many-to-one association to TarifaRuta
	@OneToMany(mappedBy="ruta")
	private List<TarifaRuta> tarifaRutas;

	public Ruta() {
	}

	public Integer getIdruta() {
		return this.idruta;
	}

	public void setIdruta(Integer idruta) {
		this.idruta = idruta;
	}

	public List<HorarioSalida> getHorarioSalidas() {
		return this.horarioSalidas;
	}

	public void setHorarioSalidas(List<HorarioSalida> horarioSalidas) {
		this.horarioSalidas = horarioSalidas;
	}

	public HorarioSalida addHorarioSalida(HorarioSalida horarioSalida) {
		getHorarioSalidas().add(horarioSalida);
		horarioSalida.setRuta(this);

		return horarioSalida;
	}

	public HorarioSalida removeHorarioSalida(HorarioSalida horarioSalida) {
		getHorarioSalidas().remove(horarioSalida);
		horarioSalida.setRuta(null);

		return horarioSalida;
	}

	public Ubigeo getUbigeo1() {
		return this.ubigeo1;
	}

	public void setUbigeo1(Ubigeo ubigeo1) {
		this.ubigeo1 = ubigeo1;
	}

	public Ubigeo getUbigeo2() {
		return this.ubigeo2;
	}

	public void setUbigeo2(Ubigeo ubigeo2) {
		this.ubigeo2 = ubigeo2;
	}

	public List<TarifaRuta> getTarifaRutas() {
		return this.tarifaRutas;
	}

	public void setTarifaRutas(List<TarifaRuta> tarifaRutas) {
		this.tarifaRutas = tarifaRutas;
	}

	public TarifaRuta addTarifaRuta(TarifaRuta tarifaRuta) {
		getTarifaRutas().add(tarifaRuta);
		tarifaRuta.setRuta(this);

		return tarifaRuta;
	}

	public TarifaRuta removeTarifaRuta(TarifaRuta tarifaRuta) {
		getTarifaRutas().remove(tarifaRuta);
		tarifaRuta.setRuta(null);

		return tarifaRuta;
	}

}