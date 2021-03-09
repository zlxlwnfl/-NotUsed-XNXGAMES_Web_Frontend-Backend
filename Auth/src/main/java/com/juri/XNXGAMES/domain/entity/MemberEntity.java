package com.juri.XNXGAMES.domain.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import lombok.Data;

@Entity
@Table(name = "USER_ENTITY")
@Data
public class MemberEntity {
	
	@Id
	@Column(name = "ID")
	@Access(AccessType.PROPERTY)
	protected String id;
	
	@Nationalized
	@Column(name = "USERNAME")
	protected String username;

}
