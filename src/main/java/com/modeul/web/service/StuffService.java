package com.modeul.web.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.modeul.web.entity.Image;
import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;

public interface StuffService{
	
	int regStuff(
		String title, 
		String place, 
		String numPeople, 
		LocalDateTime deadline, 
		String price, 
		String url, 
		String content, 
		Image image,
		MultipartFile file) throws Exception;

	List<StuffView> getViewList();

	List<StuffView> getViewList(Integer categoryId);

	Stuff getById(Long id);
	
	void regStuff(Stuff stuff);
	
}