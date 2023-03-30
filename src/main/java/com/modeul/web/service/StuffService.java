package com.modeul.web.service;

import java.util.List;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;

public interface StuffService{
	
	int regStuff();
	List<StuffView> getViewList();
	Stuff getById();
	
}