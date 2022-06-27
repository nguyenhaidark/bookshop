package com.example.bookshop.dto;

import java.util.List;

import lombok.Data;

@Data
public class BookRequest {
	private long id;
	private String name;
	private double price;
	private double saleprice;
	private int quantity;
	private boolean status;
	private String createdDate;
	private String updatedDate;
	private List<String> categories;
	private List<String> authors;
	private String publisher;

}
