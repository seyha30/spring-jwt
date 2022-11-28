package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.User;

/**
 * @author sseyha
 * @date Nov 28, 2022 9:34:53 PM
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
