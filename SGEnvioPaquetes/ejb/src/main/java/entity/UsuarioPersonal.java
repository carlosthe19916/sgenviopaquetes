package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario_personal database table.
 * 
 */
@Entity
@Table(name="usuario_personal")
@NamedQuery(name="UsuarioPersonal.findAll", query="SELECT u FROM UsuarioPersonal u")
public class UsuarioPersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idusuario_personal")
	private Integer idusuarioPersonal;

	@Column(name="clave_usuario")
	private String claveUsuario;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	//bi-directional many-to-one association to Rol
	@OneToMany(mappedBy="usuarioPersonal")
	private List<Rol> rols;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="id_personal")
	private Personal personal;

	public UsuarioPersonal() {
	}

	public Integer getIdusuarioPersonal() {
		return this.idusuarioPersonal;
	}

	public void setIdusuarioPersonal(Integer idusuarioPersonal) {
		this.idusuarioPersonal = idusuarioPersonal;
	}

	public String getClaveUsuario() {
		return this.claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

	public Rol addRol(Rol rol) {
		getRols().add(rol);
		rol.setUsuarioPersonal(this);

		return rol;
	}

	public Rol removeRol(Rol rol) {
		getRols().remove(rol);
		rol.setUsuarioPersonal(null);

		return rol;
	}

	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

}