package com.juri.XNXGAMES.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentGetListDTO {

	private Long commentId;
	private String writerId;
	private String regdate;
	private String content;
	private int heartCount;
	
}
