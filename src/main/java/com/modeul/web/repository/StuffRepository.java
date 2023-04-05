package com.modeul.web.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;

@Mapper
public interface StuffRepository{
	int insert(String title, String place, String numPeople, LocalDateTime deadline, String price, String url, String content);
	List<StuffView> findViewAll();
	List<StuffView> findViewAll(Integer categoryId);
	Stuff findById(Long id);
	void insert2(Stuff stuff);
	int imageUpload(String name, Long stuffId);
	List<Stuff> findById2(Long id);
}