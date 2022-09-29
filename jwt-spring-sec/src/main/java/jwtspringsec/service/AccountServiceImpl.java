package jwtspringsec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jwtspringsec.dao.RoleApp;
import jwtspringsec.dao.RoleRepository;
import jwtspringsec.dao.UserApp;
import jwtspringsec.dao.UserRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public UserApp save(UserApp user) {
		String hashPW=passwordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		return userRepository.save(user);
	}

	@Override
	public RoleApp saveRole(RoleApp role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		RoleApp role=roleRepository.findByRoleName(roleName);
		UserApp user=userRepository.findByUsername(username);
		user.getRoles().add(role);
		
	}

	@Override
	public UserApp findUserByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

}
