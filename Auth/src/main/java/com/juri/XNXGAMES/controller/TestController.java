package com.juri.XNXGAMES.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/*")
public class TestController {

	@GetMapping("/test")
	public void test() {
		
	}
	
	@GetMapping("/testSuccess")
	public void testSuccess() {
		System.out.println("success");
	}
	
}
