package com.juri.XNXGAMES.exception;

import org.springframework.util.Assert;

import com.juri.XNXGAMES.DTO.PostGetDTO;

public class PostAssert extends Assert {

	public static void isBoardId(Long boardId) throws BoardSearchFailException {
		throw new BoardSearchFailException();
	}
	
	public static void isPost(PostGetDTO post) throws PostSearchFailException {
		throw new PostSearchFailException();
	}
	
}
