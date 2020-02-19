package com.juri.XNXGAMES.service;

import java.util.List;

import com.juri.XNXGAMES.domain.entity.BoardEntity;
import com.juri.XNXGAMES.domain.entity.PostEntity;

public interface BoardService {

	public Long searchBoard(String type, String subType);
	public List<Long> getBoard(Long boardId);
	
}
