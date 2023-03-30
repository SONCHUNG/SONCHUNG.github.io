package com.modeul.web.service;

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
	public int regStuff() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StuffView> getViewList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stuff getById() {
		// TODO Auto-generated method stub
		return null;
	}
	
}