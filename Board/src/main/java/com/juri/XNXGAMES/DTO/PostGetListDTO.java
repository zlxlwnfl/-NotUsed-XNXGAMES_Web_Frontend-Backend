package com.juri.XNXGAMES.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
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