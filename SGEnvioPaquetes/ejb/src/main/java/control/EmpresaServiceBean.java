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

import dao.impl.EmpresaDAO;
import entity.Empresa;
import boundary.local.EmpresaServicesLocal;
import boundary.remote.EmpresaServicesRemote;

@Stateless
@Local(EmpresaServicesLocal.class)
@Remote(EmpresaServicesRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class EmpresaServiceBean implements EmpresaServicesLocal {

	@EJB
	private EmpresaDAO oEmpresaDAO;
	
	@Override
	public Empresa create(Empresa oPersonanatural) {
		oEmpresaDAO.create(oPersonanatural);
		return oPersonanatural;
	}

	@Override
	public Empresa find(Integer id) {
		return oEmpresaDAO.find(id);
	}

	@Override
	public void delete(Empresa oPersonanatural) {
		oEmpresaDAO.delete(oPersonanatural);
	}

	@Override
	public Empresa update(Empresa oPersonanatural) {
		return oEmpresaDAO.update(oPersonanatural);
	}

	@Override
	public Collection<Empresa> findByNamedQuery(String queryName) {		
		return oEmpresaDAO.findByNamedQuery(queryName);
	}

	@Override
	public Collection<Empresa> findByNamedQuery(String queryName, int resultLimit) {		
		return oEmpresaDAO.findByNamedQuery(queryName,resultLimit);
	}

	@Override
	public List<Empresa> findByNamedQuery(String Personanatural,Map<String, Object> parameters) {
		return oEmpresaDAO.findByNamedQuery(Personanatural,parameters);
	}

	@Override
	public List<Empresa> findByNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultLimit) {
		return oEmpresaDAO.findByNamedQuery(namedQueryName,parameters,resultLimit);
	}

}
