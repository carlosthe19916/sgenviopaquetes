package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sucursal database table.
 * 
 */
@Entity
@Table(name="sucursal")
@NamedQuery(name="Sucursal.findAll", query="SELECT s FROM Sucursal s")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idsucursal;

	@Column(length=150)
	private String denominacion;

	@Column(length=200)
	private String direccion;

	@Column(length=10)
	private String movil;

	@Column(length=10)
	private String movil2;

	@Column(length=200)
	private String representante;

	@Column(name="ruc_representante", length=11)
	private String rucRepresentante;

	@Column(length=12)
	private String telefono;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="sucursal")
	private List<Personal> personals;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="sucursal")
	private List<Servicio> servicios;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;

	//bi-directional many-to-one association to Ubigeo
	@ManyToOne
	@JoinColumn(name="id_ubigeo")
	private Ubigeo ubigeo;

	public Sucursal() {
	}

	public Integer getIdsucursal() {
		return this.idsucursal;
	}

	public void setIdsucursal(Integer idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getDenominacion() {
		return this.denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMovil() {
		return this.movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getMovil2() {
		return this.movil2;
	}

	public void setMovil2(String movil2) {
		this.movil2 = movil2;
	}

	public String getRepresentante() {
		return this.representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getRucRepresentante() {
		return this.rucRepresentante;
	}

	public void setRucRepresentante(String rucRepresentante) {
		this.rucRepresentante = rucRepresentante;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Personal> getPersonals() {
		return this.personals;
	}

	public void setPersonals(List<Personal> personals) {
		this.personals = personals;
	}

	public Personal addPersonal(Personal personal) {
		getPersonals().add(personal);
		personal.setSucursal(this);

		return personal;
	}

	public Personal removePersonal(Personal personal) {
		getPersonals().remove(personal);
		personal.setSucursal(null);

		return personal;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setSucursal(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setSucursal(null);

		return servicio;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Ubigeo getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}

}