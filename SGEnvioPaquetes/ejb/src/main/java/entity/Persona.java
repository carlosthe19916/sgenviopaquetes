package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idpersona;

	@Column(name="apellido_materno", length=40)
	private String apellidoMaterno;

	@Column(name="apellido_paterno", length=40)
	private String apellidoPaterno;

	@Column(length=30)
	private String correo;

	@Column(length=150)
	private String direccion;

	@Column(length=8)
	private String dni;

	@Column(length=50)
	private String nombres;

	@Column(length=12)
	private String telefono;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="persona")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Conductor
	@OneToMany(mappedBy="persona")
	private List<Conductor> conductors;

	//bi-directional many-to-one association to Ubigeo
	@ManyToOne
	@JoinColumn(name="id_ubigeo")
	private Ubigeo ubigeo;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="persona")
	private List<Personal> personals;

	public Persona() {
	}

	public Integer getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setPersona(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setPersona(null);

		return cliente;
	}

	public List<Conductor> getConductors() {
		return this.conductors;
	}

	public void setConductors(List<Conductor> conductors) {
		this.conductors = conductors;
	}

	public Conductor addConductor(Conductor conductor) {
		getConductors().add(conductor);
		conductor.setPersona(this);

		return conductor;
	}

	public Conductor removeConductor(Conductor conductor) {
		getConductors().remove(conductor);
		conductor.setPersona(null);

		return conductor;
	}

	public Ubigeo getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}

	public List<Personal> getPersonals() {
		return this.personals;
	}

	public void setPersonals(List<Personal> personals) {
		this.personals = personals;
	}

	public Personal addPersonal(Personal personal) {
		getPersonals().add(personal);
		personal.setPersona(this);

		return personal;
	}

	public Personal removePersonal(Personal personal) {
		getPersonals().remove(personal);
		personal.setPersona(null);

		return personal;
	}

}