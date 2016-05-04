package com.hsh.member;

public interface MemberDAO {
	
	//회원가입
	public int join(MemberDTO memberDTO);

	//로그인
	public MemberDTO login(MemberDTO memberDTO);
	
}



