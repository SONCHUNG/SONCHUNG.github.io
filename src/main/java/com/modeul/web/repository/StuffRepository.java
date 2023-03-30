package com.modeul.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;

@Mapper
public interface StuffRepository{
	int insert();
	List<StuffView> findViewAll();
	Stuff findById();
}