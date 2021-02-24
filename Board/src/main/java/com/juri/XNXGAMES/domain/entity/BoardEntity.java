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
@Table(name = "board")
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class BoardEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 10, nullable = false)
	private String type;
	
	@Column(length = 20, nullable = false)
	private String subType;

	@Builder
	public BoardEntity(String type, String subType) {
		super();
		this.type = type;
		this.subType = subType;
	}
	
}
