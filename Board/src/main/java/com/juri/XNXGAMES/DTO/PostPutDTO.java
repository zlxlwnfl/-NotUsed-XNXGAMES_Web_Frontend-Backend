package com.juri.XNXGAMES.DTO;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostPutDTO {

	private final String boardType;
	private final String boardSubType;
	private final Long postId;
	private final String title;
	private final String content;
	private final String writerId;
	private final String postType;
	private final List<String> gameTagList;
	
}
