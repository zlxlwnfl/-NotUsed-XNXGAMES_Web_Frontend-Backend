package com.juri.XNXGAMES.controller;

import java.util.HashMap;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juri.XNXGAMES.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	@GetMapping("/list")
	public String list(String type, String subType, Model model) {
		model.addAttribute("type", type);
		model.addAttribute("subType", subType);
		
		return "board/list";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/write")
	public String write(String type, String subType, Model model) {
		model.addAttribute("type", type);
		model.addAttribute("subType", subType);
		
		return "board/write";
	}
	
}
