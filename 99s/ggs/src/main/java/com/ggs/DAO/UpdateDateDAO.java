package com.ggs.DAO;

import java.util.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateDateDAO {
	
	@Autowired
	private SqlSessionTemplate session;

	//데이터 업데이트 최근일자 확인하기
	public Date checkDate() {
		return session.selectOne("updateDate.checkDate");
	}
	
	//데이터 업데이트 일자 추가
	public int insertUpdateDate() {
		return session.insert("updateDate.insertUpdateDate");
	}
	
	
	
}
