package com.juri.XNXGAMES.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juri.XNXGAMES.DTO.PostDTO;
import com.juri.XNXGAMES.service.BoardService;
import com.juri.XNXGAMES.service.PostService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/board/post/*")
@AllArgsConstructor
public class PostController {

	BoardService boardService;
	PostService postService;
	
	@PostMapping("/register")
	public void register(@RequestBody PostDTO postDTO) {
		String type = postDTO.getBoardType();
		String subType = postDTO.getBoardSubType();
		
		System.out.println(type + " " + subType);
		
		Long boardId = boardService.searchBoard(type, subType);
		postService.putPost(boardId, postDTO);
	}
	
}
