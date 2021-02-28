package com.juri.XNXGAMES.service;

import org.springframework.stereotype.Service;

import com.juri.XNXGAMES.DTO.BoardToMemberPostMessage;

public interface MemberPostService {
	
	public void insertMemberPost(BoardToMemberPostMessage message);
	public void deleteMemberPost(BoardToMemberPostMessage message);
	
}
