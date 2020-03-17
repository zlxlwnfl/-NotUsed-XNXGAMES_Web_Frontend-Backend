package com.juri.XNXGAMES.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juri.XNXGAMES.DTO.CommentGetListDTO;
import com.juri.XNXGAMES.DTO.CommentPutDTO;
import com.juri.XNXGAMES.service.BoardService;
import com.juri.XNXGAMES.service.CommentService;
import com.juri.XNXGAMES.service.PostService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/board/comment/*")
@AllArgsConstructor
public class CommentController {

	CommentService commentService;
	
	@PostMapping("/insertComment")
	public void insertComment(@RequestBody CommentPutDTO commentDTO) {
		commentService.insertComment(commentDTO);
	}
	
	@PostMapping("/modifyComment")
	public void modifyComment(@RequestBody CommentPutDTO commentDTO) {
		commentService.modifyComment(commentDTO);
	}
	
	@PostMapping("/getCommentList")
	public List<CommentGetListDTO> getCommentList(Long postId) {
		return commentService.getCommentList(postId);
	}
	
	@PostMapping("/deleteComment")
	public void deleteComment(Long commentId) {
		commentService.deleteComment(commentId);
	}
	
}
