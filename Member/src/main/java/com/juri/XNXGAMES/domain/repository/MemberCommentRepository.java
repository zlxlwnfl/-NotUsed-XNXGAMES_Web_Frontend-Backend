package com.juri.XNXGAMES.domain.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.juri.XNXGAMES.domain.entity.MemberCommentEntity;

public interface MemberCommentRepository extends JpaRepository<MemberCommentEntity, Long> {
	
	Optional<MemberCommentEntity> findByMemberId(String memberId);
	
}
