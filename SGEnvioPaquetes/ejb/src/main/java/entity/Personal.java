package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the personal database table.
 * 
 */
@Entity
@Table(name="personal")
@NamedQuery(name="Personal.findAll", query="SELECT p FROM Personal p")
public class Personal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idpersonal;

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