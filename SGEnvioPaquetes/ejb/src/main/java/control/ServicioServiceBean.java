package control;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.impl.ServicioDAO;
import entity.Servicio;
import boundary.local.ServicioServicesLocal;
import boundary.remote.ServicioServicesRemote;

@Stateless
@Local(ServicioServicesLocal.class)
@Remote(ServicioServicesRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ServicioServiceBean implements ServicioServicesLocal {

	@EJB
	private ServicioDAO oServicioDAO;
	
	
	@Override
	public Servicio create(Servicio oServicio) {
		oServicioDAO.create(oServicio);
		return null;
	}

	@Override
	public Servicio find(Integer id) {
		
		return oServicioDAO.find(id);
	}

	@Override
	public void delete(Servicio oServicio) {
		oServicioDAO.delete(oServicio);
		
	}

	@Override
	public Servicio update(Servicio oServicio) {
		oServicioDAO.update(oServicio);
		return null;
	}

	@Override
	public Collection<Servicio> findByNamedQuery(String queryName) {
		oServicioDAO.findByNamedQuery(queryName);
		return null;
	}

	@Override
	public Collection<Servicio> findByNamedQuery(String queryName,
			int resultLimit) {
		oServicioDAO.findByNamedQuery(queryName,resultLimit);
		return null;
	}

	@Override
	public List<Servicio> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters) {
		oServicioDAO.findByNamedQuery(namedQueryName,parameters);
		return null;
	}

	@Override
	public List<Servicio> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters, int resultLimit) {
		oServicioDAO.findByNamedQuery(namedQueryName,parameters,resultLimit);
		return null;
	}

}
