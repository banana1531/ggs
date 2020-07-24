package com.ggs.admin;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.LonginRecordDAO;
import com.ggs.DAO.MembersDAO;
import com.ggs.DTO.MemberStaticDTO;
import com.ggs.DTO.MembersDTO;
import com.ggs.DTO.WeeklyCountDTO;

@Service
public class UserManageService {

	@Autowired
	private MembersDAO membersDAO;

	@Autowired
	private LonginRecordDAO loginRecordDAO;
	
	
	//회원 목록 가져오기
	public List<MembersDTO> getMembersList(String pageNo) {
		int temp = Integer.parseInt(pageNo);
		int start = (temp-1)*10;
		MembersDTO dto = new MembersDTO();
		dto.setStart(start);
		return membersDAO.getMembersList(dto);		
	}
	
	//회원 접속자, 주간 접속자, 전체 가입자 수 가져오기 가져오기
	public String weeklyLogin() {
		//주간단위 접속자수
		List list = loginRecordDAO.weeklyLogin();		
		String result = "[";
		WeeklyCountDTO dto = new WeeklyCountDTO();
		int nowWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
		int week = nowWeek-4;
		boolean re = false;
		while (week <= nowWeek) {
			for (int i = list.size(); i > 0; i--) {
				dto = (WeeklyCountDTO) list.get(i - 1);
				if (week == dto.getWeekNum()) {
					result += "['" + dto.getWeekNum() + "week'," + dto.getCnt() + "],";
					re = true;
					break;
				}
			}
			if (!re)
				result += "['" + week + "week'," + 0 + "],";
			week++;
			re = false;
		}
		result=result.substring(0, result.length()-1)+"]";			
		System.out.println("result="+result);
		//전체 가입자수		
		return result;
	}
		
	//회원 검색 하기
	public List<MembersDTO> memberSearch(String search, String option) {
		MembersDTO dto = new MembersDTO();
		System.out.println("option="+option);
		if(option.equals("id"))	dto.setId(search);
		else if(option.equals("name")) dto.setName(search);
		else if(option.equals("email")) dto.setEmail(search);
		return membersDAO.memberSearch(dto);
	}
	
	//회원 정보 상세 보기
	public MembersDTO getMemberDetail(String id) {
		return membersDAO.getMyInfo(id);		
	}

	//회원 권한 수정
	public void updateGrant(MembersDTO dto) {
		System.out.println("UserManageService.updateGrant");
		membersDAO.updateGrant(dto);	
	}
	
	//접속,가입자수 통계 자료 가져오기
	public MemberStaticDTO memberSummary() {
		return membersDAO.memberSummary();
	}

	public String weeklyJoin() {
		//주간단위 가입자수
		List list = loginRecordDAO.weeklyJoin();		
		String result = "[";
		WeeklyCountDTO dto = new WeeklyCountDTO();
		int nowWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
		int week = nowWeek-4;
		boolean re = false;
		while (week <= nowWeek) {
			for (int i = list.size(); i > 0; i--) {
				dto = (WeeklyCountDTO) list.get(i - 1);
				if (week == dto.getWeekNum()) {
					result += "['" + dto.getWeekNum() + "week'," + dto.getCnt() + "],";
					re = true;
					break;
				}
			}
			if (!re)
				result += "['" + week + "week'," + 0 + "],";
			week++;
			re = false;
		}
		result=result.substring(0, result.length()-1)+"]";			
		System.out.println("result="+result);
		//전체 가입자수		
		return result;
	}
	
}
