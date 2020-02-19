package com.juri.XNXGAMES.domain.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "post")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
	
}
