package com.ggs.DAO;

import java.util.ArrayList;
import java.util.List;

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
		System.out.println("1CrowdDAO의 historyList 진입");
		return (ArrayList)session.selectList("crowd.historyList", afDTO);
	}

	public ArrayList<AhFiveDTO> historyListFoot(AhFiveDTO afDTO) {
		System.out.println("2CrowdDAO의 historyListFoot 진입");
		return (ArrayList)session.selectList("crowd.historyListFoot", afDTO);
	}

	public List crowdHistoryGraph(AhFiveDTO afDTO) {
		System.out.println("3CrowdDAO의 crowdHistoryGraph 진입");
		return session.selectList("crowd.crowdHistoryGraph", afDTO);
	}
	
	public List crowdHistoryGraph2(AhFiveDTO afDTO) {
		System.out.println("4CrowdDAO의 crowdHistoryGraph2 진입");
		return session.selectList("crowd.crowdHistoryGraph2", afDTO);
	}

}
