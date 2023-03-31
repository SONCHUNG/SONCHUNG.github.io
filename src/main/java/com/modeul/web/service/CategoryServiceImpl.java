package com.modeul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modeul.web.entity.Category;
import com.modeul.web.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository repository;

	@Override
	public List<Category> getList() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public String getNameById(Long id) {
		// TODO Auto-generated method stub
		return repository.findNameById(id).getName();
	}
	
}