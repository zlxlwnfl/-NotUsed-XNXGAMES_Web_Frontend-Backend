package com.juri.XNXGAMES.service;

import java.util.List;

public interface BoardService {

	public Long searchBoard(String type, String subType);
	public List<Long> getBoard(Long boardId);
	
}
