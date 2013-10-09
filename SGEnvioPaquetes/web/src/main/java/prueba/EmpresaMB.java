package prueba;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entity.Empresa;
import entity.Rol;
import boundary.local.EmpresaServicesLocal;
import boundary.local.RolServicesLocal;
import boundary.remote.RolServicesRemote;

@ManagedBean
@ViewScoped
public class EmpresaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	EmpresaServicesLocal empresaServicesLocal;

	@EJB
	RolServicesLocal rolServicesLocal;

	List<Rol> items;
	Rol itemSelected;

	@PostConstruct
	public void cargarComb() {
		itemSelected = new Rol();
		items=(List<Rol>) rolServicesLocal.findByNamedQuery(Rol.ALL);
	}

	public List<Rol> getItems() {
		return items;
	}

	public void setItems(List<Rol> items) {
		this.items = items;
	}

	public Rol getItemSelected() {
		return itemSelected;
	}

	public void setItemSelected(Rol itemSelected) {
		this.itemSelected = itemSelected;
	}

	private Empresa empresa;

	public EmpresaMB() {
		this.empresa = new Empresa();
	}

	public void crearEmpresa() {
		empresaServicesLocal.create(empresa);
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
