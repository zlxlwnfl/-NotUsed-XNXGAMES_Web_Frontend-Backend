package com.juri.XNXGAMES.service;

import com.juri.XNXGAMES.domain.entity.CommentEntity;
import com.juri.XNXGAMES.domain.entity.PostEntity;

public interface CommentService {

	public void putComment(Long postId);
	public CommentEntity getComment(Long commentId);
	
}
