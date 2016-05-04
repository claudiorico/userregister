package br.com.hcpsensor.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.hcpsensor.model.MasterData;

@Repository
public class CrudSensorDataImpl implements CrudSensorData {

	@PersistenceContext
	EntityManager manager;

	public boolean inserirSensor(MasterData sensor) {
		boolean result = false;
		if (sensor != null) {
			manager.persist(sensor);
		}

		return result;
	}

	@Override
	public List<MasterData> getTodos() {
		List<MasterData> result = null;
		try {
			Query q = manager.createNamedQuery("SelecionaTodos");
			result = q.getResultList();

		} catch (Exception e) {

		}
		return result;
	}

	@Override
	public Double getOpt(String obj) {
		Double result = null;
		List<MasterData> resultList = new ArrayList<MasterData>();

		try {
			Query q = manager.createNamedQuery("SelecionaOpt");
			resultList = q.getResultList();

			if (obj.compareTo("optical") == 0) {
				result = resultList.get(0).getC_tagoptical();
			}
			if ((obj.compareTo("objtemp") == 0)) {
				result = resultList.get(0).getC_tagobjtemp();
			}
			if ((obj.compareTo("ambtemp") == 0)) {
				result = resultList.get(0).getC_tagambtemp();
			}

		} catch (Exception e) {

		}

		return result;
	}

	@Override
	public List<Object[]> getObjtemp() {
		List<Object[]> results = null;
		
		try {
			Query q = manager.createNamedQuery("SelecionaObjTemp");
			q.setMaxResults(500);
			results = q.getResultList();

		} catch (Exception e) {

		}


		return results;
	}

}
