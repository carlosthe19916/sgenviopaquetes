package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import logger.Log;
import dao.AbstractDAO;
import entity.Servicio;

public class ServicioDAO extends AbstractDAO<Servicio>{

	public ServicioDAO() {
		super(Servicio.class);
		
	}
	
	@PersistenceContext(unitName = "EnvioPaquetesPU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	protected Log getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

}
