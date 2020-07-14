package com.ggs.member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.MembersDAO;
import com.ggs.DTO.MembersDTO;

@Service
public class Memberservice {
	@Autowired
	private MembersDAO mDAO;
	
	//로그인처리
	public MembersDTO loginProc(MembersDTO mdto, HttpSession session) {
		System.out.println("Memberservice-loginloginProc()!");
		HashMap map =new HashMap();
		map.put("id",mdto.getId());
		map.put("pw",mdto.getPw()); 						
		
		MembersDTO dto = mDAO.loginProc(map);
		
		//로그인 실패시
		if(dto==null) {
			System.out.println("회원X");
		}else {
		//로그인 성공시 ->로그인한 유저의 정보를 세션에 저장	
			System.out.println("회원O");
			session.setAttribute("UID",dto.getId());
			session.setAttribute("UNAME",dto.getName());
			session.setAttribute("UTEAM",dto.getTeam());
			session.setAttribute("UEMAIL",dto.getEmail());
			session.setAttribute("UBOARDM",dto.getBoardM());
			session.setAttribute("UBOARDV",dto.getBoardV());
			session.setAttribute("ULOGIN",dto.getLogin());
			System.out.println("로그인 성공 회원의 아이디는"+session.getAttribute("UID"));
		}
		return dto;	
	}


}
