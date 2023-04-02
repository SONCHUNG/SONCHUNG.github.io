package com.modeul.web.service;

import com.modeul.web.entity.Image;

public interface ImageService {
    
    String getNameById(Long id);

    void insert(Image image);
}
