package com.example.bookshop.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.bookshop.dto.BillRequest;
import com.example.bookshop.entity.Bill;
import com.example.bookshop.entity.Book;
import com.example.bookshop.myfunction.GetDateNow;
import com.example.bookshop.repository.BillRepository;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.repository.UserRepository;
import com.example.bookshop.service.BillService;

@Service
public class BillImpl implements BillService{

	@Autowired
	BillRepository billRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Bill> getBills(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Bill> bill = billRepository.findAll(pageable);
		List<Bill> bills = new ArrayList<>();
		bills= bill.getContent();
		return bills;
	}

	@Override
	public Bill getBillById(Long id) {
		List<String> list= new ArrayList<>();
		Bill bill = billRepository.findById(id).get();
		for (Book item : bill.getBooks()) {
			list.add(item.getName());
		}
		LinkedHashSet<String> hashSet = new LinkedHashSet<>(list);
        
        ArrayList<String> list2 = new ArrayList<>(hashSet);
        List<Book> books = new ArrayList<>();
        for (String item : list2) {
        	books.add(bookRepository.findByName(item));
		}
        for (Book book : books) {
        	for (String cout : list) {
        		if (book.getName().equals(cout)) {
    				book.setQuantity(Collections.frequency(list,cout));
    			}	
			}
		}
        Bill billRes = new Bill(bill.getId(),bill.getTotalPrice(),bill.isStatus(),bill.getCreatedDate(),
				bill.getUpdatedDate(),books); 
		return billRes;
	}

	@Override
	public Bill addBill(BillRequest billRequest) {
		double toTal=0;
		List<String> strBook = billRequest.getBooks();
		List<Book> books = new ArrayList<>();
		for (String item : strBook) {
			books.add((Book) bookRepository.findByName(item.toString()));
		}
		for (Book book : books) {
			toTal=toTal+ book.getSaleprice();	
		}
		Bill bill = new Bill();
		bill.setTotalPrice(toTal);
		bill.setStatus(billRequest.isStatus());
		bill.setBooks(books);
		bill.setCreatedDate(GetDateNow.getDate());
		bill.setUpdatedDate("undefined");
		bill.setUser(userRepository.getByUsername(billRequest.getUser()));
		return billRepository.save(bill);
	}

	@Override
	public Bill updateBill(BillRequest billRequest) {
		Bill exBill = billRepository.findById(billRequest.getId()).orElse(null);
		exBill.setUpdatedDate(GetDateNow.getDate());
		exBill.setStatus(billRequest.isStatus());
		return billRepository.save(exBill);
	}

	@Override
	public void deleteBill(Long id) {
		billRepository.deleteById(id);
	}

}
