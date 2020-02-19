package com.juri.XNXGAMES.service;

import java.util.List;

import com.juri.XNXGAMES.DTO.PostDTO;
import com.juri.XNXGAMES.domain.entity.PostEntity;

public interface PostService {

	public void putPost(Long boardId, PostDTO postDTO);
	public PostEntity getPost(Long postId);
	
}
