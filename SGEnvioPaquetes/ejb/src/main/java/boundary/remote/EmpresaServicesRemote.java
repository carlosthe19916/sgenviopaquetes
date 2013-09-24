package boundary.remote;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import entity.Empresa;
@Remote
public interface EmpresaServicesRemote {
	public Empresa create(Empresa oPersonanatural);

	public Empresa find(Integer id);

	public void delete(Empresa oPersonanatural);

	public Empresa update(Empresa oPersonanatural);

	public Collection<Empresa> findByNamedQuery(String queryName);

	public Collection<Empresa> findByNamedQuery(String queryName, int resultLimit);

	public List<Empresa> findByNamedQuery(String Personanatural, Map<String, Object> parameters);

	public List<Empresa> findByNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultLimit);
}
