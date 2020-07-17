package com.ggs.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.DeclarationDTO;
import com.ggs.DTO.DeclarationDetailDTO;
import com.ggs.DTO.DeclarationListDTO;
import com.ggs.DTO.BoardDTO;

@Repository
public class DeclarationDAO {
		
	@Autowired
	private SqlSessionTemplate session;

	//현재 미처리된 신고된 글 가져오기
	public List<DeclarationListDTO> getList() {
		return session.selectList("declaration.getList");
	}

	//신고접수글 상세 내용 가져오기
	public DeclarationDetailDTO getDetail(DeclarationDTO dto) {
		int no = dto.getWriteno();
		if(dto.getBoardname().equals("freeboard"))
			return session.selectOne("declaration.getDetailFreeboard", no);
		else 
			return session.selectOne("declaration.getDetailInforerrorboard", no);
	}
	
	//신고접수 테이블 업데이트 하기
	public int updateOutput(BoardDTO dto) {
		return session.update("declaration.updateOutput", dto);		
	}
	
	//신고처리 완료 목록 가져오기
	public List<DeclarationListDTO> getdonDecList() {
		return session.selectList("declaration.getdonDecList");
	}

	//신고처리 목록 검색해서 가져오기
	public List<DeclarationListDTO> decSearch(String option, String name) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(option, option);
		if(option.equals("title")||option.equals("content"))name="%"+name+"%";
		map.put("name", name);
		System.out.println("option="+option+"name="+name);
		
		return session.selectList("declaration.decSearch", map);
	}

	//금일 접수건수
	public int todayCnt() {
		return session.selectOne("declaration.todayCnt");
	}

	//미처리건수
	public int toDocnt() {
		return session.selectOne("declaration.toDocnt");
	}

	//주간 누적 접수건수
	public Object weekCnt() {
		return session.selectOne("declaration.weekCnt");
	}

	//주간단위 접수건 가져오기
	public List weeklyCnt() {
		return session.selectList("declaration.weeklyCnt");
	}

	//주간별 평균 처리 시간
	public List avgTime() {
		return session.selectList("declaration.avgTime");
	}

}
