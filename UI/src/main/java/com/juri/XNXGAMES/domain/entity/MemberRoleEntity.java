package com.juri.XNXGAMES.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class MemberRoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String value;

    @Builder
	public MemberRoleEntity(String value) {
		this.value = value;
	}

}