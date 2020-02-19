package com.juri.XNXGAMES.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String value;
}