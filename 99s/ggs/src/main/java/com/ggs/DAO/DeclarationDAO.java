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

}
