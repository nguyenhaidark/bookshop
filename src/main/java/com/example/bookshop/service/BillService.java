package com.example.bookshop.service;

import java.util.List;

import com.example.bookshop.dto.BillRequest;
import com.example.bookshop.entity.Bill;

public interface BillService {
	List<Bill> getBills(int pageNo, int pageSize, String sortBy, String sortDir);

	Bill getBillById(Long id);

	Bill addBill(BillRequest billRequest);

	Bill updateBill(BillRequest billRequest);

	void deleteBill(Long id);
}
