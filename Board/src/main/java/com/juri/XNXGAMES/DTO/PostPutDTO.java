package com.juri.XNXGAMES.DTO;

import java.util.List;

import lombok.Data;

@Data
public class PostPutDTO {

	private String boardType;
	private String boardSubType;
	private Long postId;
	private String title;
	private String content;
	private String writerId;
	private String postType;
	private List<String> gameTagList;
	
}
