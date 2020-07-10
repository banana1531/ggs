package com.ggs.teamrecord;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.MembersDAO;
import com.ggs.DAO.TeamRecordDAO;
import com.ggs.DAO.TeampredictDAO;
import com.ggs.DTO.FreeBoardDTO;

@Service
public class TeampredictService {

	@Autowired
	private TeampredictDAO teampredictdao;
	
	@Autowired
	private MembersDAO memberDAO;
	
	@Autowired
	private TeamRecordDAO teamRecordDAO;
	
	//아이디와 포인트 가져오기
	public MembersDAO getMemberId(String id){
		return teampredictdao.getMemberId(id);
	}
	
	public MembersDAO getMemberPoint(String point){
		return teampredictdao.getMemberId(point);
	}		
	
	//경기리스트 가져오기
	public Object getMatchList() {

		return null;
	}
		

}

