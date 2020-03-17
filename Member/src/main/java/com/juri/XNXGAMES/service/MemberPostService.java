package com.juri.XNXGAMES.service;

import org.springframework.stereotype.Service;
import com.juri.XNXGAMES.domain.BoardToMemberPostMessage;

@Service
public interface MemberPostService {
	
	public void insertMemberPost(BoardToMemberPostMessage message);
	public void deleteMemberPost(BoardToMemberPostMessage message);
	
}
