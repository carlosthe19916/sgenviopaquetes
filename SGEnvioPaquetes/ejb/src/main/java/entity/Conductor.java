package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the conductor database table.
 * 
 */
@Entity
@Table(name="conductor")
@NamedQuery(name="Conductor.findAll", query="SELECT c FROM Conductor c")
public class Conductor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idconductor;

	@Column(name="categoria_brevete", length=10)
	private String categoriaBrevete;

	//bi-directional many-to-one association to Carga
	@OneToMany(mappedBy="conductor1")
	private List<Carga> cargas1;

	//bi-directional many-to-one association to Carga
	@OneToMany(mappedBy="conductor2")
	private List<Carga> cargas2;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	public Conductor() {
	}

	public Integer getIdconductor() {
		return this.idconductor;
	}

	public void setIdconductor(Integer idconductor) {
		this.idconductor = idconductor;
	}

	public String getCategoriaBrevete() {
		return this.categoriaBrevete;
	}

	public void setCategoriaBrevete(String categoriaBrevete) {
		this.categoriaBrevete = categoriaBrevete;
	}

	public List<Carga> getCargas1() {
		return this.cargas1;
	}

	public void setCargas1(List<Carga> cargas1) {
		this.cargas1 = cargas1;
	}

	public Carga addCargas1(Carga cargas1) {
		getCargas1().add(cargas1);
		cargas1.setConductor1(this);

		return cargas1;
	}

	public Carga removeCargas1(Carga cargas1) {
		getCargas1().remove(cargas1);
		cargas1.setConductor1(null);

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
		cargas2.setConductor2(this);

		return cargas2;
	}

	public Carga removeCargas2(Carga cargas2) {
		getCargas2().remove(cargas2);
		cargas2.setConductor2(null);

		return cargas2;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}