package com.modeul.web.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;
import com.modeul.web.repository.StuffRepository;

@Service
public class StuffServiceImpl implements StuffService{

	@Autowired
	StuffRepository repository;
	
	@Override
	public int regStuff(String title, String place, String numPeople, LocalDateTime deadline, String price, String url, String content) {
		// TODO Auto-generated method stub
		return repository.insert(title, place, numPeople, deadline, price, url, content);
	}
	@Override
	public List<StuffView> getViewList() {
		// TODO Auto-generated method stub
		List<StuffView> list = repository.findViewAll();

		return list;
	}

	@Override
	public List<StuffView> getViewList(Integer categoryId) {
		// TODO Auto-generated method stub
		List<StuffView> list = repository.findViewAll(categoryId);
		return list;
	}

	@Override
	public Stuff getById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}


	
}