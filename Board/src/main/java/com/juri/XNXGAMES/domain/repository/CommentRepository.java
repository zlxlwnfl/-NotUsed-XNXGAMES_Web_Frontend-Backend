package com.juri.XNXGAMES.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.juri.XNXGAMES.domain.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

	public List<CommentEntity> findByPostIdOrderByRegdateDesc(Long postId);
	
	@Modifying
	@Transactional
	@Query("UPDATE CommentEntity " +
			"SET content = :content WHERE id = :id")
	public void updateById(@Param("id")Long commentId, @Param("content") String content);
	
}
