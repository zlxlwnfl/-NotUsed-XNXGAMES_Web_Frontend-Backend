package com.juri.XNXGAMES.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juri.XNXGAMES.DTO.BoardCriteriaDTO;
import com.juri.XNXGAMES.DTO.PostGetDTO;
import com.juri.XNXGAMES.DTO.PostGetListDTO;
import com.juri.XNXGAMES.DTO.PostPutDTO;
import com.juri.XNXGAMES.service.BoardService;
import com.juri.XNXGAMES.service.PostService;

import lombok.AllArgsConstructor;

@RestController
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
	
	@GetMapping("/{postId}")
	public PostGetDTO getPost(@PathVariable("postId") Long postId) {
		return postService.getPost(postId);
	}
	
	@DeleteMapping("/{postId}")
	public void deletePost(@PathVariable("postId") Long postId) {
		postService.deletePost(postId);
	}
	
	@GetMapping("/amount/{boardType}/{boardSubType}")
	public int getAmountPost(@PathVariable("boardType") String boardType,
							 @PathVariable("boardSubType") String boardSubType) {
		Long boardId = boardService.searchBoard(boardType, boardSubType);
		
		return postService.getAmountPost(boardId);
	}
	
}
