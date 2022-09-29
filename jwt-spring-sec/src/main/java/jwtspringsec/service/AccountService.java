package jwtspringsec.service;


import jwtspringsec.dao.RoleApp;
import jwtspringsec.dao.UserApp;

public interface AccountService {
	public UserApp save(UserApp user);
	public RoleApp saveRole(RoleApp role);
	
	public void addRoleToUser(String username,String roleName);
	public UserApp findUserByUsername(String username);
}
