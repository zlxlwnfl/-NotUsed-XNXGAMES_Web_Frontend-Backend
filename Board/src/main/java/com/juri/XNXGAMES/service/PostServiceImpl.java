package com.juri.XNXGAMES.service;

import org.springframework.stereotype.Service;

import com.juri.XNXGAMES.DTO.PostDTO;
import com.juri.XNXGAMES.domain.entity.PostEntity;
import com.juri.XNXGAMES.domain.repository.PostRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
	
	PostRepository postRepository;

	@Override
	public void putPost(Long boardId, PostDTO postDTO) {
		PostEntity post = new PostEntity();
		post.setType(postDTO.getPostType());
		post.setBoardId(boardId);
		post.setWriterId(postDTO.getWriter());
		post.setTitle(postDTO.getTitle());
		post.setContent(postDTO.getContent());
		
		postRepository.save(post);
	}

	@Override
	public PostEntity getPost(Long postId) {
		// TODO Auto-generated method stub
		return null;
	}

}
