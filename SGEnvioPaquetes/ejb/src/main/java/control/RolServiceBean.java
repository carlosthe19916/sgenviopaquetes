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

import dao.impl.RolDAO;
import entity.Rol;
import boundary.local.RolServicesLocal;
import boundary.remote.RolServicesRemote;

@Stateless
@Local(RolServicesLocal.class)
@Remote(RolServicesRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RolServiceBean implements RolServicesLocal {

	@EJB
	private RolDAO oRolDAO;
	
	@Override
	public Rol create(Rol oPersonanatural) {
		oRolDAO.create(oPersonanatural);
		return oPersonanatural;
	}

	@Override
	public Rol find(Integer id) {
		return oRolDAO.find(id);
	}

	@Override
	public void delete(Rol oPersonanatural) {
		oRolDAO.delete(oPersonanatural);
	}

	@Override
	public Rol update(Rol oPersonanatural) {
		return oRolDAO.update(oPersonanatural);
	}

	@Override
	public Collection<Rol> findByNamedQuery(String queryName) {		
		return oRolDAO.findByNamedQuery(queryName);
	}

	@Override
	public Collection<Rol> findByNamedQuery(String queryName, int resultLimit) {		
		return oRolDAO.findByNamedQuery(queryName,resultLimit);
	}

	@Override
	public List<Rol> findByNamedQuery(String Personanatural,Map<String, Object> parameters) {
		return oRolDAO.findByNamedQuery(Personanatural,parameters);
	}

	@Override
	public List<Rol> findByNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultLimit) {
		return oRolDAO.findByNamedQuery(namedQueryName,parameters,resultLimit);
	}

}
