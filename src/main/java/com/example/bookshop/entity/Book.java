package com.example.bookshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private String urlImage;
	@Column
	private String listImage;
	@Column
	private double price;
	@Column
	private int quantity;
	@Column
	private boolean status;
	@Column
	private String createdDate;
	@Column
	private String updatedDate;
	@ManyToMany(mappedBy = "books")
	private List<Category> categories = new ArrayList<>();
	@ManyToMany(mappedBy = "books")
	private List<Author> authors = new ArrayList<>();
	@ManyToMany(mappedBy = "books")
	private List<Bill> bils = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
}
