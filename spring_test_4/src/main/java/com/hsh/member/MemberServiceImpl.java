package com.hsh.member;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAOImpl memberDAOImpl;
	
	//로그인메서드
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

	//회원가입
	@Override
	public void memberJoin(MemberDTO memberDTO) {
		//DAO의 회원가입 메서드 호출
		int result = memberDAOImpl.join(memberDTO);
		
	}

	//회원정보수정
	@Override
	public void memberUpdate(MemberDTO memberDTO, HttpServletRequest request) {
		// DAO의 정보수정 메서드 호출
		memberDTO = memberDAOImpl.updte(memberDTO);
		// 수정성공 할 경우
		if(memberDTO != null){
			//세션의 로그인 정보 수정
			HttpSession session = request.getSession();
			session.setAttribute("member", memberDTO);
		}
	}

	//회원탈퇴
	@Override
	public void memberDelete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//로그인정보 세션에서 가져옴
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		//회원탈퇴 성공 시
		if(memberDAOImpl.delete(memberDTO) == null){
			//세션의 로그인 정보 지움
			session.invalidate();
		}
	}

	
	
	
}


