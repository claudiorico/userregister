package br.com.hcpsensor.dao;

import java.util.List;

import br.com.hcpsensor.model.MasterData;

public interface CrudSensorData {
	boolean inserirSensor(MasterData m);
	List<MasterData> getTodos();
	Double getOpt(String obj);
	List<Object[]> getObjtemp();
}
