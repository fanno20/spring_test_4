package com.hsh.member;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAOImpl memberDAOImpl;
	
	@Override
	public void memberLogin(MemberDTO memberDTO,HttpServletRequest request) {
		//DAO의 로그인메서드 호출
		memberDTO = memberDAOImpl.login(memberDTO);
		if(memberDTO != null){
			HttpSession session =request.getSession();
			session.setAttribute("member", memberDTO);
			System.out.println(((MemberDTO)session.getAttribute("member")).getName());
		}
	}

	@Override
	//로그인메서드
	public void memberJoin(MemberDTO memberDTO) {
		//DAO의 회원가입 메서드 호출
		int result = memberDAOImpl.join(memberDTO);
		
	}

	
	
	
}


