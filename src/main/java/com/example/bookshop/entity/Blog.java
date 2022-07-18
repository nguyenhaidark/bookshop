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
@Table(name = "Blog")
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String content;
	@Column
	private String fileName;
	@Column
	private boolean status;
	@Column
	private String createdDate;
	@Column
	private String updatedDate;
	
}
