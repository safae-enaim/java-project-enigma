package org.sid;


import org.sid.entities.AppUser;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class JwtSpringSecApplication implements CommandLineRunner {
	
	@Autowired
	private AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecApplication.class, args);
	}
	@Bean
public BCryptPasswordEncoder getBCPE() {
	return new BCryptPasswordEncoder();
}
	@Override
	public void run(String... args) throws Exception {
		accountService.saveUser(new AppUser(null,"admin","1111"));
		accountService.saveUser(new AppUser(null,"user","2222"));
		accountService.saveUser(new AppUser(null,"jade","3333"));
		accountService.saveUser(new AppUser(null,"safa","4444"));
	}
}
