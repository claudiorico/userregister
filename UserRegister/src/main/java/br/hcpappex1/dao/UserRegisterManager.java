package br.hcpappex1.dao;

import java.util.List;

import br.hcpappex1.model.UserRegister;

public interface UserRegisterManager {

	boolean insertRegister(UserRegister newdata);

	boolean deleteRegister(Long id);

	boolean modifyRegister(UserRegister changedata);

	List<UserRegister> getAll();

}
