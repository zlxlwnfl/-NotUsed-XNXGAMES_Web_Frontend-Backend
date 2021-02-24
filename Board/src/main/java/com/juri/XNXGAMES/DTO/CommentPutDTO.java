package com.juri.XNXGAMES.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentPutDTO {

	private Long postId;
	private Long commentId;
	private String writerId;
	private String content;
	
}
