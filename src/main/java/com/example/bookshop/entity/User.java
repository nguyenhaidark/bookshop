package com.example.bookshop.entity;

import java.util.ArrayList;
import java.util.List;

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

import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private String userName;
	@Column
	private String passWord;
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
	private List<Role> roles = new ArrayList<>();
	@OneToMany(mappedBy = "user")
	private List<Bill> bills = new ArrayList<>();
}
