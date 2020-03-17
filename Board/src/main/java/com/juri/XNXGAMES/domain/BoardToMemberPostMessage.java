package com.juri.XNXGAMES.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardToMemberPostMessage implements Serializable {

	private String type; // create, delete
	private String memberId;
	private Long postId;
	
}
