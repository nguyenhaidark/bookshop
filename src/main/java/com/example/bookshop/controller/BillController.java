package com.example.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshop.dto.BillRequest;
import com.example.bookshop.entity.Bill;
import com.example.bookshop.myfunction.AppConstants;
import com.example.bookshop.service.impl.BillImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/bill")
public class BillController {

	@Autowired
	BillImpl billImpl;
	@PreAuthorize("hasRole('USER')or hasRole('MODERATOR')or hasRole('ADMIN')")
	@GetMapping("/get")
	public List<Bill> getAll(
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return billImpl.getBills(pageNo, pageSize, sortBy, sortDir);
	}
	
	@GetMapping("/findById")
	public Bill getById(@RequestParam Long id) {
		return billImpl.getBillById(id);
	}
	@PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
	@PostMapping("/add")
	public Bill addBill(@RequestBody BillRequest billRequest) {
		return billImpl.addBill(billRequest);
	}
	@PreAuthorize("hasRole('USER')or hasRole('MODERATOR')or hasRole('ADMIN')")
	@PutMapping("/update")
	public Bill updateBill(@RequestBody BillRequest billRequest) {
		return billImpl.updateBill(billRequest);
	}
	@PreAuthorize("hasRole('USER')or hasRole('MODERATOR')or hasRole('ADMIN')")
	@DeleteMapping("/delete")
	public void Bill(@RequestParam Long id) {
		billImpl.deleteBill(id);
	}
}