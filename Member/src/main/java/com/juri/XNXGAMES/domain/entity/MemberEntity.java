package com.juri.XNXGAMES.domain.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10, nullable = false)
	private String memberId;
	
	@Column(length = 15, nullable = false)
	private String password;
	
	@Column(length = 10, nullable = true)
	private String nickname;
	
	@Column(length = 8, nullable = false)
	private String birth;
	
	@Column(length = 1, nullable = false)
	private String sex;
	
}
