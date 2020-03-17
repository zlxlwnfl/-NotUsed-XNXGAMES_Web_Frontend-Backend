package com.juri.XNXGAMES.domain.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "memberComment")
@Data
public class MemberCommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10, nullable = false)
	private String memberId;
	
	@Column(nullable = false)
	private Long commentId;
	
}
