package com.juri.XNXGAMES.DTO;

import lombok.Data;

@Data
public class CommentPutDTO {

	private Long postId;
	private Long commentId;
	private String writerId;
	private String content;
	
}
