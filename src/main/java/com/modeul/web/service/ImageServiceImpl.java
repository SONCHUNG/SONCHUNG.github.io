package com.modeul.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modeul.web.entity.Image;
import com.modeul.web.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{
    
    @Autowired
    ImageRepository repository;

    public String getNameById(Long id){
        return "";
    }


    @Override
    public void insert(Image image) {
        // TODO Auto-generated method stub
        repository.insert(image);
    }
}
