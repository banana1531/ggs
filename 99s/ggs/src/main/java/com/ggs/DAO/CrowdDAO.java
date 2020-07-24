package com.ggs.DAO;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.AudienceHistoryDTO;

@Repository
public class CrowdDAO {
	@Autowired
	private SqlSessionTemplate session;
	
	//선수 bmi 리스트
	public ArrayList<AudienceHistoryDTO> historyList(AudienceHistoryDTO ahDTO) {
		System.out.println("CrowdDAO의 historyList 진입");
		return (ArrayList)session.selectList("crowd.historyList", ahDTO);
	}
	
	
}
