package com.hsh.member;

import javax.servlet.http.HttpServletRequest;

public interface MemberService {

	//회원가입
	public void memberJoin(MemberDTO memberDTO);
	//로그인...
	public void memberLogin(MemberDTO memberDTO,HttpServletRequest request);
	
}






