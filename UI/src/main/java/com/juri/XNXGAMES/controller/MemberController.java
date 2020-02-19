package com.juri.XNXGAMES.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.juri.XNXGAMES.domain.entity.MemberEntity;
import com.juri.XNXGAMES.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/*")
@AllArgsConstructor
public class MemberController {

	private MemberService memberService;
	
	@GetMapping("/")
	public String home() {
		return "member/home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("/login/error")
	public String login(RedirectAttributes rttr) {
		rttr.addFlashAttribute("result", "error");
		
		return "redirect:/login";
	}
	
	@GetMapping("/logout/success")
	public String logout() {
		return "redirect:/";
	}
	
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("/join/idCheck")
	public @ResponseBody String idCheck(@RequestBody String memberId) {
		return memberService.checkIdPossible(memberId);
	}
	
	@PostMapping("/join")
	public String execJoin(MemberEntity memberEntity) {
		memberService.join(memberEntity);
		
		return "member/joinSuccess";
	}
	
	@GetMapping("/denied")
	public String denied() {
		return "member/denied";
	}
	
	@GetMapping("/member/info")
	public String memberInfo() {
		return "member/memberInfo";
	}
	
}
