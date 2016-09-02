package com.lin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lin.model.OrderRecord;

@Repository
public interface OrderRecordRepository extends JpaRepository<OrderRecord, Long> {

}
