package com.ggs.admin;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.DeclarationDAO;
import com.ggs.DAO.FreeBoardDAO;
import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.DeclarationDTO;
import com.ggs.DTO.DeclarationDetailDTO;
import com.ggs.DTO.DeclarationListDTO;
import com.ggs.DTO.WeeklyCountDTO;

@Service
public class DecService {
	
	@Autowired
	private DeclarationDAO declarationDAO;
	
	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	// 신고 접수 목록 가져오기
	public List<DeclarationListDTO> getDeclList(String pageNo) {
		System.out.println("getDeclList");
		DeclarationListDTO dto = new DeclarationListDTO();
		int temp = Integer.parseInt(pageNo);
		if(temp==0) return declarationDAO.getRecList();
		int start= (temp-1)*10;
		dto.setStart(start);
		return declarationDAO.getList(dto);
	}

	// 신고글 상세 내용 가져오기
	public DeclarationDetailDTO getDetail(DeclarationDTO dto) {

		DeclarationDetailDTO re = declarationDAO.getDetail(dto);
		System.out.println(re);
		return re;
	}

	// 신고글 처리 결과 업데이트 하기
	public int updateBoard(BoardDTO dto) {
		if (freeBoardDAO.updateBoard(dto) > 0)
			return declarationDAO.updateOutput(dto);
		else
			return 0;
	}

	// 신고처리 완료된 목록 가져오기
	public List<DeclarationListDTO> getdonDecList(String pageNo) {
		DeclarationListDTO dto = new DeclarationListDTO();
		int temp = Integer.parseInt(pageNo);
		int start = (temp-1)*10;
		dto.setStart(start);
		return declarationDAO.getdonDecList(dto);
	}

	// 신고 처리 완료글 검색해서 가져오기
	public List<DeclarationListDTO> decSearch(String option, String name) {

		return declarationDAO.decSearch(option, name);
	}

	//금일 접수건수
	public int todayCnt() {
		return declarationDAO.todayCnt();
	}
	
	//미처리 건수
	public int toDoCnt() {
		return declarationDAO.toDocnt();
	}
	
	//주간 누적 접수건수
	public Object weekCnt() {
		return declarationDAO.weekCnt();
	}
	
	//주간 단위 접수건 수 가져오기
	public String weeklyCnt() {
		List list = declarationDAO.weeklyCnt();
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
				result += "['" + week + "week'," + calTime(dto.getCnt()) + "],";
			week++;
			re = false;
		}
		result=result.substring(0, result.length()-1)+"]";		
		return result;
	}
	
	//주간별 평균 처리 시간
	public String avgTime() {
		List list = declarationDAO.avgTime();
		String result = "[";
		WeeklyCountDTO dto = new WeeklyCountDTO();
		int nowWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
		int week = nowWeek-4;
		boolean re = false;
		while(week<=nowWeek) {
			for(int i=0;i<list.size();i++) {
				dto = (WeeklyCountDTO)list.get(i);
				if(week==dto.getWeekNum()) {
					result += "['"+dto.getWeekNum()+"week',"+calTime(dto.getCnt())+"],";
					re=true;
					break;
				}
			}
			if(!re) 
				result += "['"+week+"week',"+calTime(dto.getCnt())+"],";
			week++;
			re=false;
		}
		
		result=result.substring(0, result.length()-1)+"]";
		return result;
	}
	
	//초단위 시간을 flaot의 시간단위로 변화해주기
	private String calTime(int times) {		
		float hours = (float)(times/60);	
		String result =""+hours;
		return result;
	}
}
