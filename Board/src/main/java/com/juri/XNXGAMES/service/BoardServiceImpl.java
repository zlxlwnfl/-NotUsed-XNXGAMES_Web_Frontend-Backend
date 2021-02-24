package com.juri.XNXGAMES.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.juri.XNXGAMES.domain.repository.BoardRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	BoardRepository boardRepository;

	@Override
	public Long searchBoard(String type, String subType) {
		return boardRepository.findByTypeAndSubType(type, subType).orElse(null).getId();
	}

	@Override
	public List<Long> getBoard(Long boardId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
