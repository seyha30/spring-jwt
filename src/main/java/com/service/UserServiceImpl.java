package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domain.Role;
import com.domain.User;
import com.repo.RoleRepo;
import com.repo.UserRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author sseyha
 * @date Nov 28, 2022 9:47:02 PM
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepo userRepo;
	private final RoleRepo roleRepo;

	@Override
	public User saveUser(User user) {
		log.info("Saving new user {} to the database", user.getUserName());
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Saving new role {} to the database" , role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String rolename) {
		log.info("Saving new role {} to the user {}" , rolename,username);
		User user = userRepo.findByUserName(username);
		Role role = roleRepo.findByName(rolename);
		user.getRoles().add(role);
	}

	@Override
	public User getUser(String username) {
		log.info("Fetching user {}" ,username);
		
		return userRepo.findByUserName(username);
	}

	@Override
	public List<User> getUsers() {
		log.info("Fetching all users");
	
		return userRepo.findAll();
	}

}
