package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idcliente;

	@Column(name="representante_legal", length=150)
	private String representanteLegal;

	@Column(length=11)
	private String ruc;

	@Column(name="tipo_cliente", length=15)
	private String tipoCliente;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	//bi-directional many-to-one association to OrdenServico
	@OneToMany(mappedBy="cliente1")
	private List<OrdenServico> ordenServicos1;

	//bi-directional many-to-one association to OrdenServico
	@OneToMany(mappedBy="cliente2")
	private List<OrdenServico> ordenServicos2;

	//bi-directional many-to-one association to UsuarioCliente
	@OneToMany(mappedBy="cliente")
	private List<UsuarioCliente> usuarioClientes;

	public Cliente() {
	}

	public Integer getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getRepresentanteLegal() {
		return this.representanteLegal;
	}

	public void setRepresentanteLegal(String representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<OrdenServico> getOrdenServicos1() {
		return this.ordenServicos1;
	}

	public void setOrdenServicos1(List<OrdenServico> ordenServicos1) {
		this.ordenServicos1 = ordenServicos1;
	}

	public OrdenServico addOrdenServicos1(OrdenServico ordenServicos1) {
		getOrdenServicos1().add(ordenServicos1);
		ordenServicos1.setCliente1(this);

		return ordenServicos1;
	}

	public OrdenServico removeOrdenServicos1(OrdenServico ordenServicos1) {
		getOrdenServicos1().remove(ordenServicos1);
		ordenServicos1.setCliente1(null);

		return ordenServicos1;
	}

	public List<OrdenServico> getOrdenServicos2() {
		return this.ordenServicos2;
	}

	public void setOrdenServicos2(List<OrdenServico> ordenServicos2) {
		this.ordenServicos2 = ordenServicos2;
	}

	public OrdenServico addOrdenServicos2(OrdenServico ordenServicos2) {
		getOrdenServicos2().add(ordenServicos2);
		ordenServicos2.setCliente2(this);

		return ordenServicos2;
	}

	public OrdenServico removeOrdenServicos2(OrdenServico ordenServicos2) {
		getOrdenServicos2().remove(ordenServicos2);
		ordenServicos2.setCliente2(null);

		return ordenServicos2;
	}

	public List<UsuarioCliente> getUsuarioClientes() {
		return this.usuarioClientes;
	}

	public void setUsuarioClientes(List<UsuarioCliente> usuarioClientes) {
		this.usuarioClientes = usuarioClientes;
	}

	public UsuarioCliente addUsuarioCliente(UsuarioCliente usuarioCliente) {
		getUsuarioClientes().add(usuarioCliente);
		usuarioCliente.setCliente(this);

		return usuarioCliente;
	}

	public UsuarioCliente removeUsuarioCliente(UsuarioCliente usuarioCliente) {
		getUsuarioClientes().remove(usuarioCliente);
		usuarioCliente.setCliente(null);

		return usuarioCliente;
	}

}