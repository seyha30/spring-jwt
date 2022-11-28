package com.service;

import java.util.List;

import com.domain.Role;
import com.domain.User;

/**
 * @author sseyha
 * @date Nov 28, 2022 9:41:32 PM
 */
public interface UserService {

	User saveUser(User user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String rolename);

	User getUser(String username);

	List<User> getUsers();

}
