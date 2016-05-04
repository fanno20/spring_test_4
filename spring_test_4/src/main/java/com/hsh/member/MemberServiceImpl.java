package com.hsh.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAOImpl memberDAOImpl;
	
	@Override
	public void memberLogin(MemberDTO memberDTO) {
		//DAO의 회원가입 메서드 호출
		memberDTO = memberDAOImpl.login(memberDTO);
		if(memberDTO != null){
			/*HttpSession session =*/
			System.out.println(memberDTO.getName());
		}
	}

	@Override
	public void memberJoin(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		
	}

	//로그인메서드
	//DAO의 로그인메서드 호출
	
}


