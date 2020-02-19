package com.juri.XNXGAMES.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.juri.XNXGAMES.domain.MemberRole;
import com.juri.XNXGAMES.domain.entity.MemberEntity;
import com.juri.XNXGAMES.domain.repository.MemberRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
	
	private MemberRepository memberRepository;
	
	// ID 중복체크
	public String checkIdPossible(String memberId) {
		boolean result = memberRepository.findByMemberId(memberId).isPresent();
		
		if(result == true) {
			return "false";
		}else {
			return "true";
		}
	}
	
	@Transactional
    public String join(MemberEntity memberEntity) {
		MemberRole role = new MemberRole();
		role.setValue("ROLE_MEMBER");
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberEntity.setPassword(passwordEncoder.encode(memberEntity.getPassword()));
        memberEntity.setRoles(Arrays.asList(role));

        return memberRepository.save(memberEntity).getMemberId();
    }

	@Override
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
		MemberEntity memberEntity = memberRepository.findByMemberId(memberId).get();

		if(memberEntity == null) {
			throw new UsernameNotFoundException("존재하지 않는 아이디입니다.");
		}
		
        return memberEntity;
	}

}
