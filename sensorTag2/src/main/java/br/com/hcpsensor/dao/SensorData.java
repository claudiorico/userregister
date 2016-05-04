package br.com.hcpsensor.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.stereotype.Repository;

import br.com.hcpsensor.model.MasterData;

@Repository
public class SensorData {

	private DataSource ds;
	private EntityManagerFactory emf;

	public SensorData() {

		try {
			InitialContext ctx = new InitialContext();
			this.ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");

			Map<String, DataSource> properties = new HashMap<String, DataSource>();
			properties.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, ds);
			this.emf = Persistence.createEntityManagerFactory("sensorTag2", properties);
		} catch (NamingException e) {

		}

	}

	@SuppressWarnings("unchecked")
	public List<Double> getObjtemp() {
		List<Double> result = new ArrayList<>();

		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createNamedQuery("SelecionaObjTemp");
			q.setMaxResults(500);
			result = q.getResultList();

		} catch (Exception e) {

		}

		em.close();

		return result;
	}

	public Double getOpt(String obj) {
		Double result = null;
		MasterData resultList = null;

		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createNamedQuery("SelecionaOpt");
			q.setMaxResults(500);
			resultList = (MasterData) q.getSingleResult();

			if (obj.compareTo("optical") == 0) {
				result = resultList.getC_tagoptical();
			} if((obj.compareTo("objtemp") == 0)){
				result = resultList.getC_tagobjtemp();
			} if ((obj.compareTo("ambtemp") == 0)){
				result = resultList.getC_tagambtemp();
			}
			
		} catch (Exception e) {

		}

		em.close();

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<MasterData> getTodos() {

		List<MasterData> result = null;

		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createNamedQuery("SelecionaTodos");
			q.setMaxResults(500);
			result = q.getResultList();

		} catch (Exception e) {

		}

		em.close();

		return result;

	}
	
	public boolean inserirSensor(MasterData sensor){
		boolean result = false;
		if (sensor != null) {
			EntityManager em = emf.createEntityManager();
			try {

				em.getTransaction().begin();
				em.persist(sensor);
				em.getTransaction().commit();
				result = true;

			} catch (Exception e) {
				System.out.println("ERROR: ao inserir sensor " + e.getMessage());
				result = false;
			}
			em.close();

		}

		return result;
	}

}
