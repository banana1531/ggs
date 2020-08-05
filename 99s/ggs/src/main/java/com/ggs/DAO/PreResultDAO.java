package com.ggs.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.PreResultDTO;
import com.ggs.DTO.TeamRecordDTO;

@Repository
public class PreResultDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public List<PreResultDTO> getMyPreList(PreResultDTO dto) {
		System.out.println("dto="+dto);
		return session.selectList("preresult.mypredict", dto);
	}
	
	/*public List<PreResultDTO> getMyPreList(String id) {
		return session.selectList("preresult.mypredict", id);
	}*/
	
	public  PreResultDTO predict(TeamRecordDTO dto) {
		System.out.println("predict()");
		return session.selectOne("preresult.predictcountview",dto);
	}
	
	
	//각 경기별 지급 포인트량 계산
	public int totalPoint(PreResultDTO dto) {
		return session.selectOne("preresult.totalPoint", dto);
	}
	
	//각 경기별 맞춘회원 명단 가져오기
	public List<PreResultDTO> correctList(PreResultDTO dto) {
		return session.selectList("preresult.correctList",dto);
	}
	
	//멤버별로 포인트 지급하기
	public int updatePPoint(PreResultDTO dto2) {
		return session.update("preresult.updatePPoint", dto2);
	}
	
	//경기 결과 가져오기
	public List<PreResultDTO> getList() {
		return session.selectList("preresult.getList");
	}
	
}
