package jwtspringsec;


import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jwtspringsec.dao.RoleApp;
import jwtspringsec.dao.TaskRepository;
import jwtspringsec.dao.UserApp;
import jwtspringsec.entities.Task;
import jwtspringsec.service.AccountService;

@SpringBootApplication
public class JwtSpringSecApplication implements CommandLineRunner {
	@Autowired
	private TaskRepository taskRepository;
//	private AccountService accountService;
//
//	@Autowired
//	public JwtSpringSecApplication(@Lazy AccountService accountService) {
//	    this.accountService = accountService;
//	}
	@Autowired
	private AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.save(new UserApp(null, "admin", "1234", null));
		accountService.save(new UserApp(null, "user", "1234", null));
		accountService.saveRole(new RoleApp(null,"ADMIN"));
		accountService.saveRole(new RoleApp(null,"USER"));
		accountService.addRoleToUser("admin","ADMIN");
		accountService.addRoleToUser("admin","USER");
		accountService.addRoleToUser("user","USER");
		Stream.of("T1","T2","T3").forEach(t->{
			taskRepository.save(new Task(null,t));
		});
		taskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
		});
	}
	
	
	

}
