package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ruta database table.
 * 
 */
@Entity
@NamedQuery(name="Ruta.findAll", query="SELECT r FROM Ruta r")
public class Ruta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idruta;

	private Boolean estado;

	private double tarifa;

	//bi-directional many-to-one association to HorarioSalida
	@OneToMany(mappedBy="ruta")
	private List<HorarioSalida> horarioSalidas;

	//bi-directional many-to-one association to OrdenServico
	@OneToMany(mappedBy="ruta")
	private List<OrdenServico> ordenServicos;

	//bi-directional many-to-one association to Ubigeo
	@ManyToOne
	@JoinColumn(name="id_origen")
	private Ubigeo ubigeo1;

	//bi-directional many-to-one association to Ubigeo
	@ManyToOne
	@JoinColumn(name="id_destino")
	private Ubigeo ubigeo2;

	public Ruta() {
	}

	public Integer getIdruta() {
		return this.idruta;
	}

	public void setIdruta(Integer idruta) {
		this.idruta = idruta;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public double getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
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

	public List<OrdenServico> getOrdenServicos() {
		return this.ordenServicos;
	}

	public void setOrdenServicos(List<OrdenServico> ordenServicos) {
		this.ordenServicos = ordenServicos;
	}

	public OrdenServico addOrdenServico(OrdenServico ordenServico) {
		getOrdenServicos().add(ordenServico);
		ordenServico.setRuta(this);

		return ordenServico;
	}

	public OrdenServico removeOrdenServico(OrdenServico ordenServico) {
		getOrdenServicos().remove(ordenServico);
		ordenServico.setRuta(null);

		return ordenServico;
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

}