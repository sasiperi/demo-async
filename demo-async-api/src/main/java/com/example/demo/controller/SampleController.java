package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DoStuffService;

@RestController
public class SampleController {
	
	@Autowired
	DoStuffService aService;
	
	@GetMapping("/doStuff")
	public String doStuff()
	{
		return aService.doStuff();
		
	}

}
