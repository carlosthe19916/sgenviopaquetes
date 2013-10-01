package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the personal database table.
 * 
 */
@Entity
@NamedQuery(name="Personal.findAll", query="SELECT p FROM Personal p")
public class Personal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idpersonal;

	@Column(name="documento_acreditante")
	private Integer documentoAcreditante;

	//bi-directional many-to-one association to Carga
	@OneToMany(mappedBy="personal1")
	private List<Carga> cargas1;

	//bi-directional many-to-one association to Carga
	@OneToMany(mappedBy="personal2")
	private List<Carga> cargas2;

	//bi-directional many-to-one association to Carga
	@OneToMany(mappedBy="personal3")
	private List<Carga> cargas3;

	//bi-directional many-to-one association to Entrega
	@OneToMany(mappedBy="personal")
	private List<Entrega> entregas;

	//bi-directional many-to-one association to Historial
	@OneToMany(mappedBy="personal")
	private List<Historial> historials;

	//bi-directional many-to-one association to OrdenServico
	@OneToMany(mappedBy="personal")
	private List<OrdenServico> ordenServicos;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="id_cargo")
	private Cargo cargo;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="id_sucursal")
	private Sucursal sucursal;

	//bi-directional many-to-one association to UsuarioPersonal
	@OneToMany(mappedBy="personal")
	private List<UsuarioPersonal> usuarioPersonals;

	public Personal() {
	}

	public Integer getIdpersonal() {
		return this.idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public Integer getDocumentoAcreditante() {
		return this.documentoAcreditante;
	}

	public void setDocumentoAcreditante(Integer documentoAcreditante) {
		this.documentoAcreditante = documentoAcreditante;
	}

	public List<Carga> getCargas1() {
		return this.cargas1;
	}

	public void setCargas1(List<Carga> cargas1) {
		this.cargas1 = cargas1;
	}

	public Carga addCargas1(Carga cargas1) {
		getCargas1().add(cargas1);
		cargas1.setPersonal1(this);

		return cargas1;
	}

	public Carga removeCargas1(Carga cargas1) {
		getCargas1().remove(cargas1);
		cargas1.setPersonal1(null);

		return cargas1;
	}

	public List<Carga> getCargas2() {
		return this.cargas2;
	}

	public void setCargas2(List<Carga> cargas2) {
		this.cargas2 = cargas2;
	}

	public Carga addCargas2(Carga cargas2) {
		getCargas2().add(cargas2);
		cargas2.setPersonal2(this);

		return cargas2;
	}

	public Carga removeCargas2(Carga cargas2) {
		getCargas2().remove(cargas2);
		cargas2.setPersonal2(null);

		return cargas2;
	}

	public List<Carga> getCargas3() {
		return this.cargas3;
	}

	public void setCargas3(List<Carga> cargas3) {
		this.cargas3 = cargas3;
	}

	public Carga addCargas3(Carga cargas3) {
		getCargas3().add(cargas3);
		cargas3.setPersonal3(this);

		return cargas3;
	}

	public Carga removeCargas3(Carga cargas3) {
		getCargas3().remove(cargas3);
		cargas3.setPersonal3(null);

		return cargas3;
	}

	public List<Entrega> getEntregas() {
		return this.entregas;
	}

	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}

	public Entrega addEntrega(Entrega entrega) {
		getEntregas().add(entrega);
		entrega.setPersonal(this);

		return entrega;
	}

	public Entrega removeEntrega(Entrega entrega) {
		getEntregas().remove(entrega);
		entrega.setPersonal(null);

		return entrega;
	}

	public List<Historial> getHistorials() {
		return this.historials;
	}

	public void setHistorials(List<Historial> historials) {
		this.historials = historials;
	}

	public Historial addHistorial(Historial historial) {
		getHistorials().add(historial);
		historial.setPersonal(this);

		return historial;
	}

	public Historial removeHistorial(Historial historial) {
		getHistorials().remove(historial);
		historial.setPersonal(null);

		return historial;
	}

	public List<OrdenServico> getOrdenServicos() {
		return this.ordenServicos;
	}

	public void setOrdenServicos(List<OrdenServico> ordenServicos) {
		this.ordenServicos = ordenServicos;
	}

	public OrdenServico addOrdenServico(OrdenServico ordenServico) {
		getOrdenServicos().add(ordenServico);
		ordenServico.setPersonal(this);

		return ordenServico;
	}

	public OrdenServico removeOrdenServico(OrdenServico ordenServico) {
		getOrdenServicos().remove(ordenServico);
		ordenServico.setPersonal(null);

		return ordenServico;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public List<UsuarioPersonal> getUsuarioPersonals() {
		return this.usuarioPersonals;
	}

	public void setUsuarioPersonals(List<UsuarioPersonal> usuarioPersonals) {
		this.usuarioPersonals = usuarioPersonals;
	}

	public UsuarioPersonal addUsuarioPersonal(UsuarioPersonal usuarioPersonal) {
		getUsuarioPersonals().add(usuarioPersonal);
		usuarioPersonal.setPersonal(this);

		return usuarioPersonal;
	}

	public UsuarioPersonal removeUsuarioPersonal(UsuarioPersonal usuarioPersonal) {
		getUsuarioPersonals().remove(usuarioPersonal);
		usuarioPersonal.setPersonal(null);

		return usuarioPersonal;
	}

}