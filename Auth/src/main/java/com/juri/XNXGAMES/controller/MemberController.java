package com.juri.XNXGAMES.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juri.XNXGAMES.repository.MemberRepository;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/*")
@AllArgsConstructor
public class MemberController {
	
	private MemberRepository memberRepository;
	
	@PostMapping("/login")
	public void login(String id, String password) {
		
	}
	
	@PostMapping("/join")
	public void join(String id, String password) {
		
	}
	
	@GetMapping("/logout")
	public void logout(String id) {
		
	}

}
