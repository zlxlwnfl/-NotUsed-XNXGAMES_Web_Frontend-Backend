package com.juri.XNXGAMES.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juri.XNXGAMES.domain.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
