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
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
	
	CommentRepository commentRepository;

	@Override
	public void insertComment(CommentPutDTO commentDTO) {
		CommentEntity comment = new CommentEntity();
		
		comment.setPostId(commentDTO.getPostId());
		comment.setWriterId(commentDTO.getWriterId());
		comment.setContent(commentDTO.getContent());
		
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
			
			CommentGetListDTO dto = new CommentGetListDTO();
			dto.setCommentId(comment.getId());
			dto.setWriterId(comment.getWriterId());
			
			dto.setRegdate(format.format(comment.getRegdate()));
			
			dto.setContent(comment.getContent());
			dto.setHeartCount(comment.getHeartCount());
			
			returnList.add(dto);
			
		}
		
		return returnList;
	}

	@Override
	public void deleteComment(Long commentId) {
		commentRepository.deleteById(commentId);
	}

}
