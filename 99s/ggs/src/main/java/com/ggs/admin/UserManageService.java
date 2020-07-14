package com.ggs.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.LonginRecordDAO;
import com.ggs.DAO.MembersDAO;
import com.ggs.DTO.MembersDTO;
import com.ggs.DTO.WeeklyCountDTO;

@Service
public class UserManageService {

	@Autowired
	private MembersDAO membersDAO;

	@Autowired
	private LonginRecordDAO loginRecordDAO;
	
	
	//회원 목록 가져오기
	public List<MembersDTO> getMembersList() {
		return membersDAO.getMembersList();		
	}
	
	//회원 접속자, 주간 접속자, 전체 가입자 수 가져오기 가져오기
	public String weeklyLogin() {
		//주간단위 접속자수
		List list = loginRecordDAO.weeklyLogin();
		String result = "[";
		WeeklyCountDTO dto = new WeeklyCountDTO();
		for(int i=list.size();i>0;i--) {
			dto = (WeeklyCountDTO)list.get(i-1);
			result += "['"+dto.getWeekNum()+"week',"+dto.getCnt()+"],";
		}
		result=result.substring(0, result.length()-1)+"]";
		System.out.println("result="+result);
		
		//전체 가입자수		
		return result;
	}
	
	//가입자수 가져오기
	public int totalCnt() {
		return membersDAO.totalCnt();
	}
	
	//금일 접속자수 가져오기
	public Object todayLogin() {
		return loginRecordDAO.todayLogin();
	}
	
}