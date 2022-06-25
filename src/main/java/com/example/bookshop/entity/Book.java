package com.example.bookshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String fileName;
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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Category_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<Author> authors = new ArrayList<>();

	@ManyToMany(mappedBy = "books")
	@JsonIgnore
	private List<Bill> bils = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "publisher_id")
	@JsonIgnore
	private Publisher publisher;

	public Book() {
		super();
	}

	public Book(String name, double price, int quantity, boolean status) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}

}