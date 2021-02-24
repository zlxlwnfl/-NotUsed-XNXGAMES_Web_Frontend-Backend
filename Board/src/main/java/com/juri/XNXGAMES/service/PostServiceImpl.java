package com.juri.XNXGAMES.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.juri.XNXGAMES.DTO.BoardCriteriaDTO;
import com.juri.XNXGAMES.DTO.PostGetDTO;
import com.juri.XNXGAMES.DTO.PostGetListDTO;
import com.juri.XNXGAMES.DTO.PostPutDTO;
import com.juri.XNXGAMES.controller.EventDispatcher;
import com.juri.XNXGAMES.domain.BoardToMemberPostMessage;
import com.juri.XNXGAMES.domain.entity.PostEntity;
import com.juri.XNXGAMES.domain.repository.PostRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
	
	PostRepository postRepository;
	EventDispatcher eventDispatcher;

	@Override
	public void insertPost(Long boardId, PostPutDTO postDTO) {
		PostEntity post = PostEntity.builder()
				.type(postDTO.getPostType())
				.boardId(boardId)
				.writerId(postDTO.getWriterId())
				.title(postDTO.getTitle())
				.content(postDTO.getContent())
				.gameTagList(postDTO.getGameTagList())
				.build();
		
		PostEntity savedPost = postRepository.save(post);
		
		eventDispatcher.boardToMemberPostSend(
				new BoardToMemberPostMessage(
						"create", postDTO.getWriterId(), savedPost.getId()
						));
	}
	
	@Override
	public void updatePost(PostPutDTO postDTO) {
		Long postId = postDTO.getPostId();
		String title = postDTO.getTitle();
		String content = postDTO.getContent();
		
		postRepository.updateById(postId, title, content);
	}

	@Override
	public List<PostGetListDTO> getPostList(Long boardId, BoardCriteriaDTO boardCriDTO) {
		Pageable boardPaging = PageRequest.of(boardCriDTO.getCurrentPageNum() - 1,
												boardCriDTO.getAmountData());
		
		List<PostEntity> list = postRepository.findByBoardIdOrderByRegdateDesc(boardId, boardPaging);
		
		
		List<PostGetListDTO> returnList = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("MM-dd");
		
		for(PostEntity p : list) {
			PostGetListDTO dto = PostGetListDTO.builder()
					.postId(p.getId())
					.postType(p.getType())
					.writerId(p.getWriterId())
					.commentCount(p.getCommentCount())
					.regdate(format.format(p.getRegdate()))
					.title(p.getTitle())
					.hits(p.getHits())
					.heartCount(p.getHeartCount())
					.build();
			
			returnList.add(dto);
		}
		
		return returnList;
	}

	@Override
	public PostGetDTO getPost(Long postId) {
		PostEntity post = postRepository.findById(postId).get();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		PostGetDTO dto = PostGetDTO.builder()
				.postId(post.getId())
				.postType(post.getType())
				.writerId(post.getWriterId())
				.commentCount(post.getCommentCount())
				.regdate(format.format(post.getRegdate()))
				.title(post.getTitle())
				.content(post.getContent())
				.hits(post.getHits())
				.heartCount(post.getHeartCount())
				.gameTagList(post.getGameTagList())
				.build();
		
		return dto;
	}

	@Override
	public void deletePost(Long postId) {
		postRepository.deleteById(postId);
		
		eventDispatcher.boardToMemberPostSend(
				new BoardToMemberPostMessage(
						"delete", "", postId
						));
	}

	@Override
	public int getAmountPost(Long boardId) {
		return postRepository.findCountByBoardId(boardId);
	}

}
