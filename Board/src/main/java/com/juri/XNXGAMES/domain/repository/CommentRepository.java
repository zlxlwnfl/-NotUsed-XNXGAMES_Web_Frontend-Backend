package com.juri.XNXGAMES.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juri.XNXGAMES.domain.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

	
	
}
