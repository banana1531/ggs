package com.ggs.DAO;

import java.util.ArrayList;
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
	//playerRecord 중복데이터 체크 -투수
	public int precordChk(ArrayList<String> list1) {
		return session.selectOne("graph.precordChk", list1);
	}
	//playerRecord 중복데이터 체크 -타자
		public int precordChkJ(ArrayList<String> list1) {
			return session.selectOne("graph.precordChkJ", list1);
		}
	//playerRecord insert -투수
	public void prInsert(ArrayList<String> list1) {
		session.insert("graph.prInsert", list1);
	}
	//playerRecord insert -타자
	public void prInsertJ(ArrayList<String> list1) {
		session.insert("graph.prInsertJ", list1);
	}
}
