package com.ggs.graph;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.GraphDAO;
import com.ggs.DTO.PlayerInfoDTO;


@Service
public class Graphservice {
	@Autowired
	GraphDAO gDAO;
	
	//선수 bmi리스트
	public ArrayList<PlayerInfoDTO> bmiList(PlayerInfoDTO pidto) {
		System.out.println("service-bmiList!");
		//리스트 보여주기 
		ArrayList<PlayerInfoDTO> list=gDAO.bmiList(pidto);
		System.out.println(list);
		return list;
	}
	//팀별 비만 분포
	public ArrayList<PlayerInfoDTO> tBmi(PlayerInfoDTO pidto) {
		System.out.println("service-tBmi!");
		//정상범위
		ArrayList<PlayerInfoDTO> list2 = gDAO.tBmi(pidto);
		return list2;
	}

	public ArrayList<PlayerInfoDTO> tBmi2(PlayerInfoDTO pidto) {
		// 비만범위
		ArrayList<PlayerInfoDTO> list4 = gDAO.tBmi2(pidto);
		return list4;
	}

	public ArrayList<PlayerInfoDTO> tBmi3(PlayerInfoDTO pidto) {
		// 고도비만 범위
		ArrayList<PlayerInfoDTO> list6 = gDAO.tBmi3(pidto);
		return list6;
	}
	

}
