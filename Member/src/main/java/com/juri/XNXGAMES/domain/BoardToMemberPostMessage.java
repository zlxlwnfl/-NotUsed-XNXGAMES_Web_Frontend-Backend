package com.juri.XNXGAMES.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class BoardToMemberPostMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String type; // create, delete
	private String memberId;
	private Long postId;
	
}
