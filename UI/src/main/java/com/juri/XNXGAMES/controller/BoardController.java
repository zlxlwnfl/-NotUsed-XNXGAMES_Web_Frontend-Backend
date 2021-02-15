package com.juri.XNXGAMES.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.juri.XNXGAMES.DTO.PostGetDTO;
import com.juri.XNXGAMES.domain.BoardType;
import com.juri.XNXGAMES.domain.Paging;
import com.juri.XNXGAMES.service.MemberService;
import com.juri.XNXGAMES.service.RpcService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private RpcService rpcService;

	@GetMapping("/list")
	public String list(BoardType boardType, Paging paging, Model model) {
		model.addAttribute("boardType", boardType);
		model.addAttribute("paging", paging);
		
		return "board/list";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/write")
	public String write(BoardType boardType, Paging paging, Model model) {
		model.addAttribute("boardType", boardType);
		model.addAttribute("paging", paging);
		
		return "board/write";
	}
	
	@GetMapping({"/read", "/modify"})
	public void readOrModify(BoardType boardType, Paging paging, String postId, Model model) {
		model.addAttribute("boardType", boardType);
		model.addAttribute("paging", paging);
		model.addAttribute("postId", postId);
		model.addAttribute("post", rpcService.getPost(postId));
		
		//
	}
	
}
