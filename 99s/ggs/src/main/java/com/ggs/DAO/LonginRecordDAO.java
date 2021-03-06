package com.ggs.DAO;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LonginRecordDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	
	//최근 5주 주단위 접속자수  가져오기
	public List weeklyLogin() {
		return session.selectList("loginCount.weekly");
	}

	//주단위 가입자수 가져오기
	public List weeklyJoin() {
		return session.selectList("loginCount.weeklyjoin");
	}
	
}
