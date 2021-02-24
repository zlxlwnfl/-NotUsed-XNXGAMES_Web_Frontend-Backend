package com.juri.XNXGAMES.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostGetListDTO {
	
	private Long postId;
	private String postType;
	private String writerId;
	private int commentCount;
	private String regdate;
	private String title;
	private int hits;
	private int heartCount;
	
}