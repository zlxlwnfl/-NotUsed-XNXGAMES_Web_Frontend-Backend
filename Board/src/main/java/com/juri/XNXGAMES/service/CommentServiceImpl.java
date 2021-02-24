package com.juri.XNXGAMES.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.juri.XNXGAMES.DTO.CommentGetListDTO;
import com.juri.XNXGAMES.DTO.CommentPutDTO;
import com.juri.XNXGAMES.domain.entity.CommentEntity;
import com.juri.XNXGAMES.domain.repository.CommentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
	
	CommentRepository commentRepository;

	@Override
	public void insertComment(CommentPutDTO commentDTO) {
		CommentEntity comment = CommentEntity.builder()
				.postId(commentDTO.getPostId())
				.writerId(commentDTO.getWriterId())
				.content(commentDTO.getContent())
				.build();
		
		commentRepository.save(comment);
	}
	
	@Override
	public void modifyComment(CommentPutDTO commentDTO) {
		Long commentId = commentDTO.getCommentId();
		String content = commentDTO.getContent();
		
		commentRepository.updateById(commentId, content);
	}

	@Override
	public List<CommentGetListDTO> getCommentList(Long postId) {
		List<CommentEntity> list = commentRepository.findByPostIdOrderByRegdateDesc(postId);
		
		List<CommentGetListDTO> returnList = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(CommentEntity comment : list) {
			CommentGetListDTO dto = CommentGetListDTO.builder()
					.commentId(comment.getId())
					.writerId(comment.getWriterId())
					.regdate(format.format(comment.getRegdate()))
					.content(comment.getContent())
					.heartCount(comment.getHeartCount())
					.build();
			
			returnList.add(dto);
		}
		
		return returnList;
	}

	@Override
	public void deleteComment(Long commentId) {
		commentRepository.deleteById(commentId);
	}

}
