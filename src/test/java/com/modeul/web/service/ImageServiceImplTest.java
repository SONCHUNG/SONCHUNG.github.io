package com.modeul.web.service;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.modeul.web.entity.Image;
import com.modeul.web.repository.ImageRepository;

@SpringBootTest
@AutoConfigureMybatis
public class ImageServiceImplTest {

    @Autowired
    ImageRepository repository;

    @Test
    void testInsert() {
            Image image = new Image();
            // image.setStuffId(200);
            image.setName("testFileName");
    
            repository.insert(image);
    }
}
