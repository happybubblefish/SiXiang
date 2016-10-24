package com.lin.service;

import java.util.List;

import com.lin.model.Authority;

public interface AuthorityService {
	List<Authority> findByName(String name);
	Authority save(Authority authority);
}
