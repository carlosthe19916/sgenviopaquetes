package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name = "rol",schema="dbo")
@NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
@NamedQueries({ @NamedQuery(name = Rol.ALL, query = "Select s From Rol s") })
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public final static String ALL = "entity.Rol.ALL";

	@Id
	private Integer idrol;

	private String modulo;

	//bi-directional many-to-one association to UsuarioPersonal
	@ManyToOne
	@JoinColumn(name="id_usuario_personal")
	private UsuarioPersonal usuarioPersonal;

	public Rol() {
	}

	public Integer getIdrol() {
		return this.idrol;
	}

	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	public String getModulo() {
		return this.modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public UsuarioPersonal getUsuarioPersonal() {
		return this.usuarioPersonal;
	}

	public void setUsuarioPersonal(UsuarioPersonal usuarioPersonal) {
		this.usuarioPersonal = usuarioPersonal;
	}

}