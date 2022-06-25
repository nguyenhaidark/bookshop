package com.example.bookshop.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "User", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private String address;
	@Column
	private boolean gender;
	@Column
	private boolean status;
	@Column
	private String createdDate;
	@Column
	private String updatedDate;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "User_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(mappedBy = "user")
	private List<Bill> bills = new ArrayList<>();

	public User() {
	}

	public User(String name, String username, String password, String phone, String email, String address,
			boolean gender, boolean status, String createdDate, String updatedDate) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

}
