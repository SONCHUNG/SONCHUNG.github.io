package com.modeul.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member/stuff")
public class StuffController{
	
	
	@GetMapping("reg")
	public String stuffForm() {
		return "member/stuff/reg";
	}
	@PostMapping("reg")
	public String regStuff() {
		return "member/stuff/list";
	}
	@GetMapping("list")
	public String list() {
		
		return "member/stuff/list";
	}
	@GetMapping("detail")
	public String detail() {
		return "member/stuff/detail";
	}
}