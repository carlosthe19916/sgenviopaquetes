package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_carga database table.
 * 
 */
@Entity
@Table(name="detalle_carga")
@NamedQuery(name="DetalleCarga.findAll", query="SELECT d FROM DetalleCarga d")
public class DetalleCarga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddetallecarga;

	//bi-directional many-to-one association to Carga
	@ManyToOne
	@JoinColumn(name="id_carga")
	private Carga carga;

	//bi-directional many-to-one association to OrdenServico
	@ManyToOne
	@JoinColumn(name="id_orden_servicio")
	private OrdenServico ordenServico;

	public DetalleCarga() {
	}

	public Integer getIddetallecarga() {
		return this.iddetallecarga;
	}

	public void setIddetallecarga(Integer iddetallecarga) {
		this.iddetallecarga = iddetallecarga;
	}

	public Carga getCarga() {
		return this.carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}

	public OrdenServico getOrdenServico() {
		return this.ordenServico;
	}

	public void setOrdenServico(OrdenServico ordenServico) {
		this.ordenServico = ordenServico;
	}

}