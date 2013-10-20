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
		
		return null;
	}

	@Override
	public Servicio find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Servicio oServicio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Servicio update(Servicio oServicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Servicio> findByNamedQuery(String queryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Servicio> findByNamedQuery(String queryName,
			int resultLimit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Servicio> findByNamedQuery(String Personanatural,
			Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Servicio> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters, int resultLimit) {
		// TODO Auto-generated method stub
		return null;
	}

}
