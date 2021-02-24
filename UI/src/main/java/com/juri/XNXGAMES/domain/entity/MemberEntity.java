package com.juri.XNXGAMES.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.juri.XNXGAMES.domain.MemberRole;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@Data
@NoArgsConstructor
public class MemberEntity implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, length = 10, nullable = false)
	private String memberId;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@Column(length = 8, nullable = false)
	private String birthdate;
	
	@Column(length = 1, nullable = false)
	private String gender;
	
	@CreationTimestamp
	private Date regdate;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "MemberRole", joinColumns = @JoinColumn(name = "id"))
	@Enumerated(EnumType.STRING)
	private List<MemberRole> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for(MemberRole role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.name()));
		}

		return authorities;
	}

	@Override
	public String getUsername() {
		return this.getMemberId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}

