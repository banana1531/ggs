package com.ggs.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.MembersDAO;
import com.ggs.DTO.MembersDTO;

@Service
public class MyInfoService {

	@Autowired
	private MembersDAO membersDAO;

	//비밀번호 수정하기
	public int updatePw(String id, String newPw) {
		MembersDTO memberDTO = new MembersDTO();
		memberDTO.setPw(newPw);
		memberDTO.setId(id);
		return membersDAO.updatePw(memberDTO);
	}

	//비밀번호 확인하기
	public boolean checkPw(String id, String newPw) {
		
		String oldPw = membersDAO.getPw(id);
		System.out.println("oldPw="+oldPw);
		System.out.println("newPw="+newPw);
		
		return oldPw.equals(newPw);
	}
		
	//내정보 수정하기
	public int updateMyInfo(MembersDTO member) {
		return membersDAO.updateMyInfo(member);
	}

}
