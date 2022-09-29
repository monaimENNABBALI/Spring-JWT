package jwtspringsec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jwtspringsec.dao.UserApp;
import jwtspringsec.service.AccountService;

@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	@PostMapping("/register")
	public UserApp register(@RequestBody RegisterForm registeruser) {
		if(!registeruser.getPassword().equals(registeruser.getRepassword())) {
			throw new RuntimeException("you must confirm your password");
		}
		UserApp MyUser=accountService.findUserByUsername(registeruser.getUsername());
		if(MyUser!=null) {
			throw new RuntimeException("this user already exists");
		}
		UserApp user=new UserApp();
		user.setUsername(registeruser.getUsername());
		user.setPassword(registeruser.getPassword());
		accountService.save(user);
		accountService.addRoleToUser(registeruser.getUsername(),"USER");
		return user;
	}
}
