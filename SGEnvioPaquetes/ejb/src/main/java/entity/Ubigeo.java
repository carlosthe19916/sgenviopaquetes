package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ubigeo database table.
 * 
 */
@Entity
@Table(name="ubigeo")
@NamedQuery(name="Ubigeo.findAll", query="SELECT u FROM Ubigeo u")
public class Ubigeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ubigeo", unique=true, nullable=false)
	private Integer idUbigeo;

	@Column(name="codigo_distrito", nullable=false)
	private Integer codigoDistrito;

	@Column(name="codigo_provincia", nullable=false)
	private Integer codigoProvincia;

	@Column(name="codigo_region", nullable=false)
	private Integer codigoRegion;

	@Column(name="nombre_distrito", nullable=false, length=50)
	private String nombreDistrito;

	@Column(name="nombre_provincia", nullable=false, length=50)
	private String nombreProvincia;

	@Column(name="nombre_region", nullable=false, length=50)
	private String nombreRegion;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="ubigeo")
	private List<Persona> personas;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="ubigeo1")
	private List<Ruta> rutas1;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="ubigeo2")
	private List<Ruta> rutas2;

	//bi-directional many-to-one association to Sucursal
	@OneToMany(mappedBy="ubigeo")
	private List<Sucursal> sucursals;

	public Ubigeo() {
	}

	public Integer getIdUbigeo() {
		return this.idUbigeo;
	}

	public void setIdUbigeo(Integer idUbigeo) {
		this.idUbigeo = idUbigeo;
	}

	public Integer getCodigoDistrito() {
		return this.codigoDistrito;
	}

	public void setCodigoDistrito(Integer codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}

	public Integer getCodigoProvincia() {
		return this.codigoProvincia;
	}

	public void setCodigoProvincia(Integer codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public Integer getCodigoRegion() {
		return this.codigoRegion;
	}

	public void setCodigoRegion(Integer codigoRegion) {
		this.codigoRegion = codigoRegion;
	}

	public String getNombreDistrito() {
		return this.nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

	public String getNombreProvincia() {
		return this.nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public String getNombreRegion() {
		return this.nombreRegion;
	}

	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setUbigeo(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setUbigeo(null);

		return persona;
	}

	public List<Ruta> getRutas1() {
		return this.rutas1;
	}

	public void setRutas1(List<Ruta> rutas1) {
		this.rutas1 = rutas1;
	}

	public Ruta addRutas1(Ruta rutas1) {
		getRutas1().add(rutas1);
		rutas1.setUbigeo1(this);

		return rutas1;
	}

	public Ruta removeRutas1(Ruta rutas1) {
		getRutas1().remove(rutas1);
		rutas1.setUbigeo1(null);

		return rutas1;
	}

	public List<Ruta> getRutas2() {
		return this.rutas2;
	}

	public void setRutas2(List<Ruta> rutas2) {
		this.rutas2 = rutas2;
	}

	public Ruta addRutas2(Ruta rutas2) {
		getRutas2().add(rutas2);
		rutas2.setUbigeo2(this);

		return rutas2;
	}

	public Ruta removeRutas2(Ruta rutas2) {
		getRutas2().remove(rutas2);
		rutas2.setUbigeo2(null);

		return rutas2;
	}

	public List<Sucursal> getSucursals() {
		return this.sucursals;
	}

	public void setSucursals(List<Sucursal> sucursals) {
		this.sucursals = sucursals;
	}

	public Sucursal addSucursal(Sucursal sucursal) {
		getSucursals().add(sucursal);
		sucursal.setUbigeo(this);

		return sucursal;
	}

	public Sucursal removeSucursal(Sucursal sucursal) {
		getSucursals().remove(sucursal);
		sucursal.setUbigeo(null);

		return sucursal;
	}

}