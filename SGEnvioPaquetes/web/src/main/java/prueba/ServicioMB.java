package prueba;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import boundary.local.ServicioServicesLocal;
import entity.Servicio;

@ManagedBean
@ViewScoped
public class ServicioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ServicioServicesLocal oServicioServicesLocal;

	public Servicio getServicio() {
		return servicio;
	}

	private List<Servicio> servicios;

	@PostConstruct
	public void cargarServicios() {
		servicios = (List<Servicio>) oServicioServicesLocal
				.findByNamedQuery("entity.Empresa.findAll");
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	private Servicio servicio;

	public ServicioMB() {
		servicio = new Servicio();
	}

	public List<Servicio> getServicios() {

		return servicios;
	}

}
