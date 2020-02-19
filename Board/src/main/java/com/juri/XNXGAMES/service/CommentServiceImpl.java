package com.juri.XNXGAMES.service;

import org.springframework.stereotype.Service;

import com.juri.XNXGAMES.domain.entity.CommentEntity;
import com.juri.XNXGAMES.domain.repository.CommentRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
	
	CommentRepository commentRepository;

	@Override
	public void putComment(Long postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CommentEntity getComment(Long commentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
