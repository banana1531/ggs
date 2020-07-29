package com.ggs.DAO;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.AhFiveDTO;

@Repository
public class CrowdDAO {
	@Autowired
	private SqlSessionTemplate session;


	//선수 bmi 리스트
	public ArrayList<AhFiveDTO> historyList(AhFiveDTO afDTO) {
		System.out.println("CrowdDAO의 historyList 진입"+afDTO);
		return (ArrayList)session.selectList("crowd.historyList", afDTO);
	}

	public ArrayList<AhFiveDTO> historyListFoot(AhFiveDTO afDTO) {
		System.out.println("CrowdDAO의 historyListFoot 진입"+afDTO);
		return (ArrayList)session.selectList("crowd.historyListFoot", afDTO);
	}


	
	
}
