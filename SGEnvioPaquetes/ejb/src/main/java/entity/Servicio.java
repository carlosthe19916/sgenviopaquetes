package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
@Table(name="servicio")
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idservicio;

	@Column(length=60)
	private String denominacion;

	@Column(name="peso_max")
	private double pesoMax;

	@Column(name="tarifa_servicio")
	private double tarifaServicio;

	//bi-directional many-to-one association to OrdenServico
	@OneToMany(mappedBy="servicio")
	private List<OrdenServico> ordenServicos;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="id_sucursal")
	private Sucursal sucursal;

	public Servicio() {
	}

	public Integer getIdservicio() {
		return this.idservicio;
	}

	public void setIdservicio(Integer idservicio) {
		this.idservicio = idservicio;
	}

	public String getDenominacion() {
		return this.denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public double getPesoMax() {
		return this.pesoMax;
	}

	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}

	public double getTarifaServicio() {
		return this.tarifaServicio;
	}

	public void setTarifaServicio(double tarifaServicio) {
		this.tarifaServicio = tarifaServicio;
	}

	public List<OrdenServico> getOrdenServicos() {
		return this.ordenServicos;
	}

	public void setOrdenServicos(List<OrdenServico> ordenServicos) {
		this.ordenServicos = ordenServicos;
	}

	public OrdenServico addOrdenServico(OrdenServico ordenServico) {
		getOrdenServicos().add(ordenServico);
		ordenServico.setServicio(this);

		return ordenServico;
	}

	public OrdenServico removeOrdenServico(OrdenServico ordenServico) {
		getOrdenServicos().remove(ordenServico);
		ordenServico.setServicio(null);

		return ordenServico;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

}