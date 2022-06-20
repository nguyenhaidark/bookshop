package com.example.bookshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Contact")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String urlImage;
	@Column
	private boolean status;
	@Column
	private String createdDate;
	@Column
	private String updatedDate;
}
