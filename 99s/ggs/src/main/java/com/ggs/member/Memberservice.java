package com.ggs.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.MembersDAO;
import com.ggs.DTO.MembersDTO;

@Service
public class Memberservice {
	@Autowired
	MembersDAO mDAO;
	
	//로그인처리
	public MembersDTO loginProc(MembersDTO mdto, HttpSession session) {
		System.out.println("Memberservice-loginloginProc()!");						
		
		MembersDTO result = mDAO.loginProc(mdto);
		
		//로그인 실패시
		if(result==null) {
			System.out.println("회원X");
		}else {
		//로그인 성공시 ->로그인한 유저의 정보를 세션에 저장
			System.out.println("회원O");
			session.setAttribute("UID",result.getId());
			session.setAttribute("UNAME",result.getName());
			session.setAttribute("UTEAM",result.getTeam());
			session.setAttribute("UEMAIL",result.getEmail());
			session.setAttribute("UBOARDM",result.getBoardM());
			session.setAttribute("UBOARDV",result.getBoardV());
			session.setAttribute("ULOGIN",result.getLogin());
			session.setAttribute("UPOINT",result.getPpoint());
			System.out.println("로그인 성공 "+session.getAttribute("UID")+"/"+session.getAttribute("UEMAIL"));
			
			//최종 로그인 시간 확인해서 1일이상 차이가 발생할 경우 db 업데이트
			if(mDAO.chkLastLogin(result.getId())>0) {
				mDAO.insertLoginDate(result.getId());
				System.out.println(result.getId()+"의 최종 로그인 일자가 기록되었습니다.");
			}
						
		}
		return result;	
	}

}