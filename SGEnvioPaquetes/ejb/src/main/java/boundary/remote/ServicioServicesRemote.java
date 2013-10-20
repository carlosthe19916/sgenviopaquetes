package boundary.remote;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import entity.Servicio;

@Remote
public interface ServicioServicesRemote {
	public Servicio create(Servicio oServicio);

	public Servicio find(Integer id);

	public void delete(Servicio oServicio);

	public Servicio update(Servicio oServicio);

	public Collection<Servicio> findByNamedQuery(String queryName);

	public Collection<Servicio> findByNamedQuery(String queryName, int resultLimit);

	public List<Servicio> findByNamedQuery(String Personanatural, Map<String, Object> parameters);

	public List<Servicio> findByNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultLimit);

}
