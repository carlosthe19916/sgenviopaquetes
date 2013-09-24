package boundary.remote;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import entity.Rol;

@Remote
public interface RolServicesRemote {
	public Rol create(Rol oPersonanatural);

	public Rol find(Integer id);

	public void delete(Rol oPersonanatural);

	public Rol update(Rol oPersonanatural);

	public Collection<Rol> findByNamedQuery(String queryName);

	public Collection<Rol> findByNamedQuery(String queryName, int resultLimit);

	public List<Rol> findByNamedQuery(String Personanatural,
			Map<String, Object> parameters);

	public List<Rol> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters, int resultLimit);
}
