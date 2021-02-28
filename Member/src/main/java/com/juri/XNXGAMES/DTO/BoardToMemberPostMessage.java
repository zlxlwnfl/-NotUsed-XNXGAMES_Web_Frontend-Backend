package com.juri.XNXGAMES.DTO;

import java.io.Serializable;

import lombok.Data;

@Data
public class BoardToMemberPostMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String type; // create, delete
	private final String memberId;
	private final Long postId;
	
}
