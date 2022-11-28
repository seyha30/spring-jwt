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
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String rolename) {
		User user = userRepo.findByUserName(username);
		Role role = roleRepo.findByName(rolename);
		user.getRoles().add(role);
	}

	@Override
	public User getUser(String username) {
		return null;
	}

	@Override
	public List<User> getUsers() {
		return null;
	}

}
