package com.modeul.web.service;

import java.time.LocalDateTime;
import java.util.List;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;

public interface StuffService{
	
	int regStuff(String title, String place, String numPeople, LocalDateTime deadline, String price, String url, String content);
	List<StuffView> getViewList();
	List<StuffView> getViewList(Integer categoryId);
	Stuff getById(Long id);
	
}