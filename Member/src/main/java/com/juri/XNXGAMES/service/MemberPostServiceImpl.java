package com.juri.XNXGAMES.service;

import java.util.Optional;

import com.juri.XNXGAMES.domain.BoardToMemberPostMessage;
import com.juri.XNXGAMES.domain.entity.MemberPostEntity;
import com.juri.XNXGAMES.domain.repository.MemberPostRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberPostServiceImpl implements MemberPostService {

	MemberPostRepository memberPostRepository;
	
	@Override
	public void insertMemberPost(BoardToMemberPostMessage message) {
		MemberPostEntity memberPost = MemberPostEntity.builder()
				.memberId(message.getMemberId())
				.postId(message.getPostId())
				.build();
		
		memberPostRepository.save(memberPost);
	}

	@Override
	public void deleteMemberPost(BoardToMemberPostMessage message) {
		String memberId = message.getMemberId();
		
		 Optional<MemberPostEntity> memberPost = memberPostRepository.findByMemberId(memberId);
		 if(!memberPost.isPresent()) return;
		
		 memberPostRepository.delete(memberPost.get());
	}
	
}
