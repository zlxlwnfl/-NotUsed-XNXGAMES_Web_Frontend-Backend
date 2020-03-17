package com.juri.XNXGAMES.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PostGetDTO {
	
	private Long id;
	private String postType;
	private Long boardId;
	private String writerId;
	private int commentCount;
	private String regdate;
	private String title;
	private String content;
	private int hits;
	private int heartCount;
	private List<String> gameTagList;
	
}