package com.juri.XNXGAMES.domain.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.juri.XNXGAMES.domain.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

	public List<PostEntity> findByBoardIdOrderByRegdateDesc(Long boardId, Pageable boardPaging);
	
	@Query("SELECT COUNT(id) FROM PostEntity WHERE boardId = :boardId")
	public int findCountByBoardId(@Param("boardId") Long boardId);
	
	@Modifying
	@Transactional
	@Query("UPDATE PostEntity " +
			"SET title = :title, content = :content WHERE id = :id")
	public void updateById(@Param("id") Long postId, @Param("title") String title, @Param("content") String content);
	
}
