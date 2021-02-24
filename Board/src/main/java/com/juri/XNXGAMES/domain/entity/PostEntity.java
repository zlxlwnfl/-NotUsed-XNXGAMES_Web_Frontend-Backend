package com.juri.XNXGAMES.domain.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "post")
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class PostEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 10, nullable = false)
	private String type;
	
	@Column(nullable = false)
	private Long boardId;
	
	@Column(length = 10, nullable = false)
	private String writerId;
	
	@ColumnDefault("0")
	private int commentCount;
	
	@CreationTimestamp
	private Date regdate;
	
	@Column(length = 45, nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@ColumnDefault("0")
	private int hits;
	
	@ColumnDefault("0")
	private int heartCount;
	
	@Column(nullable = true)
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> gameTagList;

	@Builder
	public PostEntity(String type, Long boardId, String writerId, String title, String content) {
		super();
		this.type = type;
		this.boardId = boardId;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
	}
	
}
