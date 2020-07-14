package com.ggs.DAO;

import java.util.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class VisitCountDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	private static VisitCountDAO visitcountDAO = null;
	
	private VisitCountDAO() {};
	
	
	public static VisitCountDAO getInstance() {
		visitcountDAO = new VisitCountDAO();
		return visitcountDAO;
	}
	
	public void insertVisitor(Date date) {
		System.out.println("VisitCountDAO.insertVisitor()");
		session.insert("visit.insert", date);
	}
}
