package com.hsh.test4;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String login(MemberDTO memberDTO,HttpServletRequest request){ // < 안되면 @ModelAttribute 붙여서
		memberServiceImpl.memberLogin(memberDTO,request);
		return "redirect:/";
	}
	
	@RequestMapping("/joinF.me")
	public void joinF(){}

	@RequestMapping("/join.me")
	public String join(MemberDTO memberDTO){
		memberServiceImpl.memberJoin(memberDTO);
		return "redirect:/";
	}
	
	@RequestMapping("/updateF.me")
	public void updateF(){}
	
	@RequestMapping("/update.me")
	public String update(MemberDTO memberDTO, HttpServletRequest request){
		memberServiceImpl.memberUpdate(memberDTO, request);
		return "redirect:/";
	}
	
	@RequestMapping("/logout.me")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("delete.me")
	public String delete(HttpServletRequest request){
		memberServiceImpl.memberDelete(request);
		return "redirect:/";
	}
}











