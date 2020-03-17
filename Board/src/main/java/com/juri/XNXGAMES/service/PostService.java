package com.juri.XNXGAMES.service;

import java.util.List;

import com.juri.XNXGAMES.DTO.BoardCriteriaDTO;
import com.juri.XNXGAMES.DTO.PostGetDTO;
import com.juri.XNXGAMES.DTO.PostGetListDTO;
import com.juri.XNXGAMES.DTO.PostPutDTO;
import com.juri.XNXGAMES.domain.entity.PostEntity;

public interface PostService {

	public void insertPost(Long boardId, PostPutDTO postDTO);
	public void updatePost(PostPutDTO postDTO);
	public List<PostGetListDTO> getPostList(Long boardId, BoardCriteriaDTO boardCriDTO);
	public PostGetDTO getPost(Long postId);
	public void deletePost(Long postId);
	public int getAmountPost(Long boardId);
	
}
