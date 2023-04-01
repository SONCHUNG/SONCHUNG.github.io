package com.modeul.web.service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.modeul.web.entity.Image;
import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;
import com.modeul.web.repository.StuffRepository;

@Service
public class StuffServiceImpl implements StuffService{

	@Autowired
	StuffRepository repository;
	
	@Override
	public int regStuff(String title, 
						String place, 
						String numPeople, 
						LocalDateTime deadline, 
						String price, 
						String url, 
						String content,
						Image image, 
						MultipartFile file) throws Exception {

		String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\stuff";
		UUID uuid = UUID.randomUUID();
		String fileName = uuid + "_" + file.getOriginalFilename();
		File saveFile = new File(projectPath, fileName);
		file.transferTo(saveFile);
		


		return repository.insert(title, place, numPeople, deadline, price, url, content);
	}
	@Override
	public List<StuffView> getViewList() {
		List<StuffView> list = repository.findViewAll();

		return list;
	}

	@Override
	public List<StuffView> getViewList(Integer categoryId) {
		List<StuffView> list = repository.findViewAll(categoryId);
		return list;
	}

	@Override
	public Stuff getById(Long id) {
		return repository.findById(id);
	}
	@Override
	public void regStuff2(Stuff stuff) {
		repository.insert2(stuff);
	}


	
}