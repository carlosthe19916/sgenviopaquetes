package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tarifa_peso database table.
 * 
 */
@Entity
@Table(name="tarifa_peso")
@NamedQuery(name="TarifaPeso.findAll", query="SELECT t FROM TarifaPeso t")
public class TarifaPeso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idtarifapeso;

	@Column(name="peso_max")
	private double pesoMax;

	@Column(name="peso_min")
	private double pesoMin;

	private double tarifa;

	@Column(name="tipo_rotulacion", length=30)
	private String tipoRotulacion;

	//bi-directional many-to-one association to OrdenServico
	@OneToMany(mappedBy="tarifaPeso")
	private List<OrdenServico> ordenServicos;

	public TarifaPeso() {
	}

	public Integer getIdtarifapeso() {
		return this.idtarifapeso;
	}

	public void setIdtarifapeso(Integer idtarifapeso) {
		this.idtarifapeso = idtarifapeso;
	}

	public double getPesoMax() {
		return this.pesoMax;
	}

	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}

	public double getPesoMin() {
		return this.pesoMin;
	}

	public void setPesoMin(double pesoMin) {
		this.pesoMin = pesoMin;
	}

	public double getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public String getTipoRotulacion() {
		return this.tipoRotulacion;
	}

	public void setTipoRotulacion(String tipoRotulacion) {
		this.tipoRotulacion = tipoRotulacion;
	}

	public List<OrdenServico> getOrdenServicos() {
		return this.ordenServicos;
	}

	public void setOrdenServicos(List<OrdenServico> ordenServicos) {
		this.ordenServicos = ordenServicos;
	}

	public OrdenServico addOrdenServico(OrdenServico ordenServico) {
		getOrdenServicos().add(ordenServico);
		ordenServico.setTarifaPeso(this);

		return ordenServico;
	}

	public OrdenServico removeOrdenServico(OrdenServico ordenServico) {
		getOrdenServicos().remove(ordenServico);
		ordenServico.setTarifaPeso(null);

		return ordenServico;
	}

}