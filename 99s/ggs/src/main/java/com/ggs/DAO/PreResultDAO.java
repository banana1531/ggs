package com.ggs.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.PreResultDTO;

@Repository
public class PreResultDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	
	public List<PreResultDTO> getMyPreList(String uid) {
		return session.selectList("preresult.mypredict", uid);
	}
	
	public  List<PreResultDTO> predict(PreResultDTO dto) {
		return session.selectList("preresult.predictcountview",dto);
	}
	
}
