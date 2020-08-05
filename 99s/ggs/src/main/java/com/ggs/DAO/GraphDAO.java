package com.ggs.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.PlayerInfoDTO;


@Repository
public class GraphDAO {
	@Autowired
	private SqlSessionTemplate session;
	
	//선수 bmi 리스트
	public ArrayList<PlayerInfoDTO> bmiList(PlayerInfoDTO pidto) {
		System.out.println("DAO-bmiList!");
		return (ArrayList)session.selectList("graph.bmiList", pidto);
	}
	
	//팀별 비만 분포
	public ArrayList<PlayerInfoDTO> tBmi(PlayerInfoDTO pidto) {
		System.out.println("DAO-tBmi!");
		//정상범위
		return (ArrayList)session.selectList("graph.tBmi", pidto);
	}

	public ArrayList<PlayerInfoDTO> tBmi2(PlayerInfoDTO pidto) {
		//비만범위
		return (ArrayList)session.selectList("graph.tBmi2", pidto);
	}
	
	public ArrayList<PlayerInfoDTO> tBmi3(PlayerInfoDTO pidto) {
		//고도비만범위
		return (ArrayList)session.selectList("graph.tBmi3", pidto);
	}
	
}
