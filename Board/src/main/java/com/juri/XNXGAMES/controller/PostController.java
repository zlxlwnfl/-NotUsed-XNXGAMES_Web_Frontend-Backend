package com.juri.XNXGAMES.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.juri.XNXGAMES.DTO.BoardCriteriaDTO;
import com.juri.XNXGAMES.DTO.PostGetDTO;
import com.juri.XNXGAMES.DTO.PostGetListDTO;
import com.juri.XNXGAMES.DTO.PostPutDTO;
import com.juri.XNXGAMES.domain.entity.PostEntity;
import com.juri.XNXGAMES.service.BoardService;
import com.juri.XNXGAMES.service.PostService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/board/post/*")
@AllArgsConstructor
public class PostController {

	BoardService boardService;
	PostService postService;
	
	@PostMapping("/")
	public void insertPost(@RequestBody PostPutDTO postDTO) {
		String boardType = postDTO.getBoardType();
		String boardSubType = postDTO.getBoardSubType();
		
		Long boardId = boardService.searchBoard(boardType, boardSubType);
		postService.insertPost(boardId, postDTO);
	}
	
	@PutMapping("/")
	public void updatePost(@RequestBody PostPutDTO postDTO) {
		postService.updatePost(postDTO);
	}
	
	@GetMapping("/list")
	public List<PostGetListDTO> getPostList(@RequestBody BoardCriteriaDTO boardCriDTO) {
		System.out.println(boardCriDTO.getBoardType() + " " + boardCriDTO.getBoardSubType());
		
		Long boardId = boardService.searchBoard(boardCriDTO.getBoardType(), 
												boardCriDTO.getBoardSubType());
		
		return postService.getPostList(boardId, boardCriDTO);
	}
	
	@GetMapping("/")
	public PostGetDTO getPost(Long postId) {
		return postService.getPost(postId);
	}
	
	@DeleteMapping("/")
	public void deletePost(Long postId) {
		postService.deletePost(postId);
	}
	
	@GetMapping("/amount")
	public int getAmountPost(@RequestParam String boardType,
							 @RequestParam String boardSubType) {
		Long boardId = boardService.searchBoard(boardType, boardSubType);
		
		return postService.getAmountPost(boardId);
	}
	
}
