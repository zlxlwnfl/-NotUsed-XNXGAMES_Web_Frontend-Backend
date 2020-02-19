package com.juri.XNXGAMES.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juri.XNXGAMES.domain.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

	
	
}
