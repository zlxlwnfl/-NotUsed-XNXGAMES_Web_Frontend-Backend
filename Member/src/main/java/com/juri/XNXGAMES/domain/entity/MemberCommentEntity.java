package com.juri.XNXGAMES.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "memberComment")
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class MemberCommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10, nullable = false)
	private String memberId;
	
	@Column(nullable = false)
	private Long commentId;

	@Builder
	public MemberCommentEntity(String memberId, Long commentId) {
		super();
		this.memberId = memberId;
		this.commentId = commentId;
	}
	
}
