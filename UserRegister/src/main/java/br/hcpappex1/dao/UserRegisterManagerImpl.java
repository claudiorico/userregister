package br.hcpappex1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.hcpappex1.model.UserRegister;

@Repository
public class UserRegisterManagerImpl implements UserRegisterManager {
	
	@PersistenceContext
	EntityManager manager;

	@Override
	public boolean insertRegister(UserRegister newdata) {
		// TODO Auto-generated method stub
		boolean datainsert = false;
		if(newdata != null){
			manager.persist(newdata);
			datainsert = true;
		}
		return datainsert;
	}

	@Override
	public boolean deleteRegister(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyRegister(UserRegister changedata) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserRegister> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
