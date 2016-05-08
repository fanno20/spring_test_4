package com.hsh.member;

import javax.servlet.http.HttpServletRequest;

public interface MemberService {

	//회원가입
	public void memberJoin(MemberDTO memberDTO);
	//로그인...
	public void memberLogin(MemberDTO memberDTO,HttpServletRequest request);
	//정보수정
	public void memberUpdate(MemberDTO memberDTO,HttpServletRequest request);
	//회원탈퇴
	public void memberDelete(HttpServletRequest request);
}






