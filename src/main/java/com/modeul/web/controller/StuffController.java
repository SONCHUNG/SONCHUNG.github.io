package com.modeul.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.modeul.web.entity.Category;
import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;
import com.modeul.web.service.CategoryService;
import com.modeul.web.service.StuffService;



@Controller
@RequestMapping("/member/stuff")
public class StuffController{
	
	@Autowired
	public StuffService service;
	@Autowired
	public CategoryService categoryService;

	@GetMapping("reg")
	public String stuffForm() {
		return "member/stuff/reg";
	}
	@PostMapping("reg")
	public String regStuff(
			@RequestParam(name="title") String title,
			@RequestParam(name="place") String place,
			@RequestParam(name="numPeople") String numPeople,
			@RequestParam(name="deadline") LocalDateTime deadline,
			@RequestParam(name="price") String price,
			@RequestParam(name="url") String url,
			@RequestParam(name="content") String content) {

		int isnert = service.regStuff(title, place, numPeople, deadline, price, url, content);

		return "redirect:list";
	}
	@GetMapping("list")
	public String list(
		@RequestParam(name = "c", required = false) Integer categoryId,
		Model model) {
		
		List<Category> categoryList = categoryService.getList();
		List<StuffView> list = service.getViewList(categoryId);

		model.addAttribute("categoryList", categoryList);
		model.addAttribute("list", list);

		return "member/stuff/list";
	}
	@GetMapping("detail")
	public String detail(Long id, Model model) {
		Stuff stuff = service.getById(id);
		String categoryName = categoryService.getNameById(stuff.getCategoryId());

		model.addAttribute("stuff", stuff);
		model.addAttribute("categoryName", categoryName);

		return "member/stuff/detail";
	}
}