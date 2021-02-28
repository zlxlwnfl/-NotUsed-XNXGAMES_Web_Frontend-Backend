package com.juri.XNXGAMES.DTO;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostGetDTO {
	
	private final Long postId;
	private final String postType;
	private final String writerId;
	private final int commentCount;
	private final String regdate;
	private final String title;
	private final String content;
	private final int hits;
	private final int heartCount;
	private final List<String> gameTagList;
	
}