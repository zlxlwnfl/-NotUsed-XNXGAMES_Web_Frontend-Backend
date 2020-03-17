package com.juri.XNXGAMES.service;

import com.juri.XNXGAMES.domain.BoardToMemberPostMessage;
import com.juri.XNXGAMES.domain.entity.MemberPostEntity;
import com.juri.XNXGAMES.domain.repository.MemberPostRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberPostServiceImpl implements MemberPostService {

	MemberPostRepository memberPostRepository;
	
	@Override
	public void insertMemberPost(BoardToMemberPostMessage message) {
		MemberPostEntity memberPost = new MemberPostEntity().builder()
				.memberId(message.getMemberId())
				.postId(message.getPostId())
				.build();
		
		memberPostRepository.save(memberPost);
	}

	@Override
	public void deleteMemberPost(BoardToMemberPostMessage message) {
		String memberId = message.getMemberId();
		
		MemberPostEntity memberPost = memberPostRepository.findByMemberId(memberId).get();
		memberPostRepository.delete(memberPost);
	}
	
}
