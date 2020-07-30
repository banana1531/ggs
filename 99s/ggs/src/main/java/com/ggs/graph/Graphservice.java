package com.ggs.graph;

import java.util.ArrayList;

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
		System.out.println("pidto="+pidto);
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
	
	//playerRecord 중복데이터 체크 -투수
	public int precordChk(ArrayList<String> list1) {
		int cntr = gDAO.precordChk(list1);
		return cntr;
	}
	//playerRecord 중복데이터 체크 -타자
	public int precordChkJ(ArrayList<String> list1) {
		int cntr = gDAO.precordChkJ(list1);
		return cntr;
	}
	//playerRecord insert-투수
	public void prInsert(ArrayList<String> list1) {
		gDAO.prInsert(list1);
	}
	//playerRecord insert-타자
		public void prInsertJ(ArrayList<String> list1) {
			gDAO.prInsertJ(list1);
		}
	

}
