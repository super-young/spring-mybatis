package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.service.UserService;

@Controller
public class TestController {
	
	@Autowired
	private UserService service;
	@RequestMapping("/")
	@ResponseBody
	public String get()
	{
		return service.getById().getName();
	}
}
