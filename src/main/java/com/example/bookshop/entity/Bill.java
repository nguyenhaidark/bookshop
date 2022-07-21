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
@Table(name = "Bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private double totalPrice;
	@Column
	private boolean status;
	@Column
	private String createdDate;
	@Column
	private String updatedDate;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Bill_book",joinColumns = @JoinColumn(name = "bill_id"),inverseJoinColumns = @JoinColumn(name = "book_id"))
	private List<Book> books = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	public Bill(long id, double totalPrice, boolean status, String createdDate, String updatedDate, List<Book> books) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.books = books;
	}
	public Bill() {
		super();
	}
	
	
	
	
}
