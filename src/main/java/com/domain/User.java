package com.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.sql.ast.tree.expression.Collation;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sseyha
 * @date Nov 28, 2022 9:21:46 PM
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String userName;
	private String password;
	@ManyToAny(fetch = FetchType.EAGER)
	private Collection<Role> roles = new ArrayList<>();
}
