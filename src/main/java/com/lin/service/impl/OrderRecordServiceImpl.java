package com.lin.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.model.OrderRecord;
import com.lin.repository.OrderRecordRepository;
import com.lin.service.OrderRecordService;

@Service
@Transactional
public class OrderRecordServiceImpl implements OrderRecordService {

	@Autowired
	private OrderRecordRepository orderRecordRepository;
	
	@Override
	public OrderRecord save(OrderRecord order) {
		return orderRecordRepository.save(order);
	}
}
