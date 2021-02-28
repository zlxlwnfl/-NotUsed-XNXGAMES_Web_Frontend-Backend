package com.juri.XNXGAMES.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentPutDTO {

	private final Long postId;
	private final Long commentId;
	private final String writerId;
	private final String content;
	
}
