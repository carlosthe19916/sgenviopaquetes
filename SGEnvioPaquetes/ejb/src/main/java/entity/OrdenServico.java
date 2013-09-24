package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orden_servico database table.
 * 
 */
@Entity
@Table(name="orden_servico")
@NamedQuery(name="OrdenServico.findAll", query="SELECT o FROM OrdenServico o")
public class OrdenServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idorden;

	@Column(name="estado_envio", length=32)
	private String estadoEnvio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_recojo")
	private Date fechaRecojo;

	@Column(name="hora_recojo", length=10)
	private String horaRecojo;

	@Column(name="nro_comprobante", length=12)
	private String nroComprobante;

	@Column(name="pero_neto")
	private double peroNeto;

	@Column(name="tipo_comprobante", length=15)
	private String tipoComprobante;

	//bi-directional many-to-one association to DetalleCarga
	@OneToMany(mappedBy="ordenServico")
	private List<DetalleCarga> detalleCargas;

	//bi-directional many-to-one association to Entrega
	@OneToMany(mappedBy="ordenServico")
	private List<Entrega> entregas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_remitente")
	private Cliente cliente1;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cosignatario")
	private Cliente cliente2;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="id_personal_responsable")
	private Personal personal;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="id_servicio")
	private Servicio servicio;

	//bi-directional many-to-one association to TarifaPeso
	@ManyToOne
	@JoinColumn(name="id_tarifa_peso")
	private TarifaPeso tarifaPeso;

	//bi-directional many-to-one association to TarifaRuta
	@ManyToOne
	@JoinColumn(name="id_tarifa_lugar")
	private TarifaRuta tarifaRuta;

	//bi-directional many-to-one association to Paquete
	@OneToMany(mappedBy="ordenServico")
	private List<Paquete> paquetes;

	public OrdenServico() {
	}

	public Integer getIdorden() {
		return this.idorden;
	}

	public void setIdorden(Integer idorden) {
		this.idorden = idorden;
	}

	public String getEstadoEnvio() {
		return this.estadoEnvio;
	}

	public void setEstadoEnvio(String estadoEnvio) {
		this.estadoEnvio = estadoEnvio;
	}

	public Date getFechaRecojo() {
		return this.fechaRecojo;
	}

	public void setFechaRecojo(Date fechaRecojo) {
		this.fechaRecojo = fechaRecojo;
	}

	public String getHoraRecojo() {
		return this.horaRecojo;
	}

	public void setHoraRecojo(String horaRecojo) {
		this.horaRecojo = horaRecojo;
	}

	public String getNroComprobante() {
		return this.nroComprobante;
	}

	public void setNroComprobante(String nroComprobante) {
		this.nroComprobante = nroComprobante;
	}

	public double getPeroNeto() {
		return this.peroNeto;
	}

	public void setPeroNeto(double peroNeto) {
		this.peroNeto = peroNeto;
	}

	public String getTipoComprobante() {
		return this.tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public List<DetalleCarga> getDetalleCargas() {
		return this.detalleCargas;
	}

	public void setDetalleCargas(List<DetalleCarga> detalleCargas) {
		this.detalleCargas = detalleCargas;
	}

	public DetalleCarga addDetalleCarga(DetalleCarga detalleCarga) {
		getDetalleCargas().add(detalleCarga);
		detalleCarga.setOrdenServico(this);

		return detalleCarga;
	}

	public DetalleCarga removeDetalleCarga(DetalleCarga detalleCarga) {
		getDetalleCargas().remove(detalleCarga);
		detalleCarga.setOrdenServico(null);

		return detalleCarga;
	}

	public List<Entrega> getEntregas() {
		return this.entregas;
	}

	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}

	public Entrega addEntrega(Entrega entrega) {
		getEntregas().add(entrega);
		entrega.setOrdenServico(this);

		return entrega;
	}

	public Entrega removeEntrega(Entrega entrega) {
		getEntregas().remove(entrega);
		entrega.setOrdenServico(null);

		return entrega;
	}

	public Cliente getCliente1() {
		return this.cliente1;
	}

	public void setCliente1(Cliente cliente1) {
		this.cliente1 = cliente1;
	}

	public Cliente getCliente2() {
		return this.cliente2;
	}

	public void setCliente2(Cliente cliente2) {
		this.cliente2 = cliente2;
	}

	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public TarifaPeso getTarifaPeso() {
		return this.tarifaPeso;
	}

	public void setTarifaPeso(TarifaPeso tarifaPeso) {
		this.tarifaPeso = tarifaPeso;
	}

	public TarifaRuta getTarifaRuta() {
		return this.tarifaRuta;
	}

	public void setTarifaRuta(TarifaRuta tarifaRuta) {
		this.tarifaRuta = tarifaRuta;
	}

	public List<Paquete> getPaquetes() {
		return this.paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public Paquete addPaquete(Paquete paquete) {
		getPaquetes().add(paquete);
		paquete.setOrdenServico(this);

		return paquete;
	}

	public Paquete removePaquete(Paquete paquete) {
		getPaquetes().remove(paquete);
		paquete.setOrdenServico(null);

		return paquete;
	}

}