package dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import logger.Log;
import dao.*;
import entity.Empresa;
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class EmpresaDAO extends AbstractDAO<Empresa>{

	public EmpresaDAO() {
		super(Empresa.class);
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
