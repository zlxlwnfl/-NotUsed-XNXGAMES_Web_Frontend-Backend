package com.juri.XNXGAMES.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juri.XNXGAMES.DTO.BoardCriteriaDTO;
import com.juri.XNXGAMES.DTO.PostGetDTO;
import com.juri.XNXGAMES.DTO.PostGetListDTO;
import com.juri.XNXGAMES.DTO.PostPutDTO;
import com.juri.XNXGAMES.exception.BoardSearchFailException;
import com.juri.XNXGAMES.exception.PostAssert;
import com.juri.XNXGAMES.exception.PostSearchFailException;
import com.juri.XNXGAMES.service.BoardService;
import com.juri.XNXGAMES.service.PostService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/board/post/*")
@AllArgsConstructor
public class PostController {

	BoardService boardService;
	PostService postService;
	
	@PostMapping("/")
	public void insertPost(@RequestBody PostPutDTO postDTO) throws BoardSearchFailException {
		String boardType = postDTO.getBoardType();
		String boardSubType = postDTO.getBoardSubType();
		
		Long boardId = boardService.searchBoard(boardType, boardSubType);
		PostAssert.isBoardId(boardId);
		postService.insertPost(boardId, postDTO);
	}
	
	@PutMapping("/")
	public void updatePost(@RequestBody PostPutDTO postDTO) {
		postService.updatePost(postDTO);
	}
	
	@GetMapping("/list")
	public List<PostGetListDTO> getPostList(@RequestBody BoardCriteriaDTO boardCriDTO) throws BoardSearchFailException {
		System.out.println(boardCriDTO.getBoardType() + " " + boardCriDTO.getBoardSubType());
		
		Long boardId = boardService.searchBoard(boardCriDTO.getBoardType(), 
												boardCriDTO.getBoardSubType());
		PostAssert.isBoardId(boardId);
		
		return postService.getPostList(boardId, boardCriDTO);
	}
	
	@GetMapping("/{postId}")
	public PostGetDTO getPost(@PathVariable("postId") Long postId) throws PostSearchFailException {
		PostGetDTO post = postService.getPost(postId);
		PostAssert.isPost(post);
		
		return post;
	}
	
	@DeleteMapping("/{postId}")
	public void deletePost(@PathVariable("postId") Long postId) {
		postService.deletePost(postId);
	}
	
	@GetMapping("/amount/{boardType}/{boardSubType}")
	public int getAmountPost(@PathVariable("boardType") String boardType,
							 @PathVariable("boardSubType") String boardSubType) throws BoardSearchFailException {
		Long boardId = boardService.searchBoard(boardType, boardSubType);
		PostAssert.isBoardId(boardId);
		
		return postService.getAmountPost(boardId);
	}
	
	@ExceptionHandler(BoardSearchFailException.class)
	public ResponseEntity<String> boardSearchFailExceptionHandler() {
		log.error("BoardSearchFailException!");
		return new ResponseEntity<String>("게시판이 존재하지 않습니다.", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PostSearchFailException.class)
	public ResponseEntity<String> postSearchFailExceptionHandler() {
		log.error("PostSearchFailException!");
		return new ResponseEntity<String>("게시글이 존재하지 않습니다.", HttpStatus.BAD_REQUEST);
	}
	
}
