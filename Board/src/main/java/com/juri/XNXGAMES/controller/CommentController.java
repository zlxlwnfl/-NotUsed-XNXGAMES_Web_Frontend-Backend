package com.juri.XNXGAMES.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juri.XNXGAMES.DTO.CommentGetListDTO;
import com.juri.XNXGAMES.DTO.CommentPutDTO;
import com.juri.XNXGAMES.service.CommentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/board/comment/*")
@AllArgsConstructor
public class CommentController {

	CommentService commentService;
	
	@PostMapping("/")
	public ResponseEntity<Void> insertComment(@RequestBody CommentPutDTO commentDTO) {
		commentService.insertComment(commentDTO);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<Void> modifyComment(@RequestBody CommentPutDTO commentDTO) {
		commentService.modifyComment(commentDTO);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<List<CommentGetListDTO>> getCommentList(@PathVariable("postId") Long postId) {
		List<CommentGetListDTO> list = commentService.getCommentList(postId);
		
		if(list.isEmpty()) 	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else				return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<Void> deleteComment(@PathVariable("postId") Long commentId) {
		commentService.deleteComment(commentId);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
