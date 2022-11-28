package com;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.domain.Role;
import com.domain.User;
import com.service.UserService;

@SpringBootApplication
public class SpringJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);
	}
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			
			userService.saveUser(new User(null,"John","John","123",new ArrayList<>()));
			userService.saveUser(new User(null,"John1","John1","123",new ArrayList<>()));
			userService.saveUser(new User(null,"John2","John2","123",new ArrayList<>()));
			userService.saveUser(new User(null,"John3","John3","123",new ArrayList<>()));
			userService.saveUser(new User(null,"John4","John4","123",new ArrayList<>()));
			userService.saveUser(new User(null,"John5","John5","123",new ArrayList<>()));
			userService.saveUser(new User(null,"John6","John6","123",new ArrayList<>()));
			
			userService.addRoleToUser("John", "ROLE_USER");
			userService.addRoleToUser("John", "ROLE_ADMIN");
			userService.addRoleToUser("John", "ROLE_MANAGER");
		};
	}

}
 