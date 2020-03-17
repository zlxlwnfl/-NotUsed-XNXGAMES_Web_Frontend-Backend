package com.juri.XNXGAMES.domain.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.juri.XNXGAMES.domain.entity.MemberPostEntity;

public interface MemberPostRepository extends JpaRepository<MemberPostEntity, Long> {
	
	Optional<MemberPostEntity> findByMemberId(String memberId);
	
}
