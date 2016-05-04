package com.hsh.test4;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsh.member.MemberDTO;
import com.hsh.member.MemberServiceImpl;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Inject
	MemberServiceImpl memberServiceImpl;
	
	@RequestMapping("/loginF.me")
	public void loginF(){}
	
	@RequestMapping("/login.me")
	public String login(MemberDTO memberDTO){ // < 안되면 @ModelAttribute 붙여서
		memberServiceImpl.memberLogin(memberDTO);
		return "redirect:/";
	}
	
	@RequestMapping("/joinF.me")
	public void joinF(){}

	@RequestMapping("/join.me")
	public void join(MemberDTO memberDTO){
		memberServiceImpl.memberJoin(memberDTO);
	}
	
}











