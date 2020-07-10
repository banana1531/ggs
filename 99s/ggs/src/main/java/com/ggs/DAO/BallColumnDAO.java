package com.ggs.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BallColumnDAO extends SqlSessionDaoSupport {

	@Autowired
	private SqlSessionTemplate session;
}
