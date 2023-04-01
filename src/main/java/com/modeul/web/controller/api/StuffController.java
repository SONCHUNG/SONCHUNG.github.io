package com.modeul.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.modeul.web.entity.Category;
import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;
import com.modeul.web.service.CategoryService;
import com.modeul.web.service.StuffService;



@RestController("apiStuffController")
@RequestMapping("stuffs")
public class StuffController{
	
	@Autowired
	public StuffService service;
	@Autowired
	public CategoryService categoryService;

	@GetMapping("reg")
	public String stuffForm() {
		return "member/stuff/reg";
	}
	@PostMapping
	public String insert(@RequestBody Stuff stuff) {
			service.regStuff2(stuff);
		return "stuff insert";
		// return "redirect:list";
	}
	// @PostMapping
	// public String regStuff(
	// 		@RequestParam(name="title") String title,
	// 		@RequestParam(name="place") String place,
	// 		@RequestParam(name="numPeople") String numPeople,
	// 		@RequestParam(name="deadline") LocalDateTime deadline,
	// 		@RequestParam(name="price") String price,
	// 		@RequestParam(name="url") String url,
	// 		@RequestParam(name="content") String content
	// 		) {

	// 	return "redirect:list";
	// }
	@GetMapping
	public List<StuffView> getList(
		@RequestParam(name = "c", required = false) Integer categoryId, Model model) {
		
		// List<Category> categoryList = categoryService.getList();
		List<StuffView> list = service.getViewList(categoryId);

		// model.addAttribute("categoryList", categoryList);
		// model.addAttribute("list", list);

		// return "member/stuff/list";
		return list;
	}
	@GetMapping("category")
	public List<Category> getCategoryList(
		@RequestParam(name = "c", required = false) Integer categoryId, Model model) {
		
		List<Category> categoryList = categoryService.getList();

		// model.addAttribute("categoryList", categoryList);
		return categoryList;
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