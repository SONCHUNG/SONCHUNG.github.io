package com.modeul.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.modeul.web.entity.Category;
import com.modeul.web.entity.Image;

@Mapper
public interface ImageRepository{
	Image findById(Long stuffId);
	void insert(Image image);
}