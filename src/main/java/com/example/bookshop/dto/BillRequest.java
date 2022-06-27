package com.example.bookshop.dto;

import java.util.List;

import lombok.Data;

@Data
public class BillRequest {
	private long id;
	private double totalPrice;
	private boolean status;
	private List<String> books;
	private String user;
}
