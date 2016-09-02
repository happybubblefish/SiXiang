package com.lin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lin.model.Kind;

@Repository
public interface KindRepository extends JpaRepository<Kind, Long> {

}
