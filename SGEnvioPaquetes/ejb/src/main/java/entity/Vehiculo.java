package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vehiculo database table.
 * 
 */
@Entity
@Table(name="vehiculo")
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idvehiculo;

	@Column(length=2147483647)
	private String descripcion;

	@Column(length=30)
	private String marca;

	@Column(length=30)
	private String modelo;

	@Column(name="nro_placa", length=8)
	private String nroPlaca;

	//bi-directional many-to-one association to Carga
	@OneToMany(mappedBy="vehiculo")
	private List<Carga> cargas;

	public Vehiculo() {
	}

	public Integer getIdvehiculo() {
		return this.idvehiculo;
	}

	public void setIdvehiculo(Integer idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNroPlaca() {
		return this.nroPlaca;
	}

	public void setNroPlaca(String nroPlaca) {
		this.nroPlaca = nroPlaca;
	}

	public List<Carga> getCargas() {
		return this.cargas;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}

	public Carga addCarga(Carga carga) {
		getCargas().add(carga);
		carga.setVehiculo(this);

		return carga;
	}

	public Carga removeCarga(Carga carga) {
		getCargas().remove(carga);
		carga.setVehiculo(null);

		return carga;
	}

}