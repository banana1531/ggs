package com.ggs.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class TeampredictDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	public MembersDAO getMemberId(String id) {
		return session.selectOne("members.myinfo",id);
	}

	public MembersDAO getMemberPoint(int ppoint) {
		return session.selectOne("members.myinfo",ppoint);
	}
}
