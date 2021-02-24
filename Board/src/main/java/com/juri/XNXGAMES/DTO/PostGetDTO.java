package com.juri.XNXGAMES.DTO;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostGetDTO {
	
	private Long postId;
	private String postType;
	private String writerId;
	private int commentCount;
	private String regdate;
	private String title;
	private String content;
	private int hits;
	private int heartCount;
	private List<String> gameTagList;
	
}