package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_cliente database table.
 * 
 */
@Entity
@Table(name="usuario_cliente")
@NamedQuery(name="UsuarioCliente.findAll", query="SELECT u FROM UsuarioCliente u")
public class UsuarioCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idusuario_cliente", unique=true, nullable=false)
	private Integer idusuarioCliente;

	@Column(name="clave_usuario", length=45)
	private String claveUsuario;

	@Column(name="nombre_usuario", length=30)
	private String nombreUsuario;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public UsuarioCliente() {
	}

	public Integer getIdusuarioCliente() {
		return this.idusuarioCliente;
	}

	public void setIdusuarioCliente(Integer idusuarioCliente) {
		this.idusuarioCliente = idusuarioCliente;
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

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}