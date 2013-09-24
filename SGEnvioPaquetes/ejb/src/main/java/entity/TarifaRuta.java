package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tarifa_ruta database table.
 * 
 */
@Entity
@Table(name="tarifa_ruta")
@NamedQuery(name="TarifaRuta.findAll", query="SELECT t FROM TarifaRuta t")
public class TarifaRuta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idtarifaruta;

	@Column(name="estado_servicio")
	private Boolean estadoServicio;

	private double tarifa;

	//bi-directional many-to-one association to OrdenServico
	@OneToMany(mappedBy="tarifaRuta")
	private List<OrdenServico> ordenServicos;

	//bi-directional many-to-one association to Ruta
	@ManyToOne
	@JoinColumn(name="id_ruta")
	private Ruta ruta;

	public TarifaRuta() {
	}

	public Integer getIdtarifaruta() {
		return this.idtarifaruta;
	}

	public void setIdtarifaruta(Integer idtarifaruta) {
		this.idtarifaruta = idtarifaruta;
	}

	public Boolean getEstadoServicio() {
		return this.estadoServicio;
	}

	public void setEstadoServicio(Boolean estadoServicio) {
		this.estadoServicio = estadoServicio;
	}

	public double getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public List<OrdenServico> getOrdenServicos() {
		return this.ordenServicos;
	}

	public void setOrdenServicos(List<OrdenServico> ordenServicos) {
		this.ordenServicos = ordenServicos;
	}

	public OrdenServico addOrdenServico(OrdenServico ordenServico) {
		getOrdenServicos().add(ordenServico);
		ordenServico.setTarifaRuta(this);

		return ordenServico;
	}

	public OrdenServico removeOrdenServico(OrdenServico ordenServico) {
		getOrdenServicos().remove(ordenServico);
		ordenServico.setTarifaRuta(null);

		return ordenServico;
	}

	public Ruta getRuta() {
		return this.ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

}