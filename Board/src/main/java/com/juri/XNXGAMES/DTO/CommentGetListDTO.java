package com.juri.XNXGAMES.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentGetListDTO {

	private final Long commentId;
	private final String writerId;
	private final String regdate;
	private final String content;
	private final int heartCount;
	
}
