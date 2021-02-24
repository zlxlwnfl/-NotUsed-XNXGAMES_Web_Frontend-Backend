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
@Table(name = "memberPost")
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class MemberPostEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10, nullable = false)
	private String memberId;
	
	@Column(nullable = false)
	private Long postId;

	@Builder
	public MemberPostEntity(String memberId, Long postId) {
		super();
		this.memberId = memberId;
		this.postId = postId;
	}
	
}
