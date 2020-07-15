package com.ggs.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VisitCountDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	/*private static VisitCountDAO visitcountDAO = null;
	
	private VisitCountDAO() {};*/
	
	/*public static VisitCountDAO getInstance() {
		visitcountDAO = new VisitCountDAO();
		return visitcountDAO;
	}*/
	
	public void insertVisitor() {
		System.out.println("VisitCountDAO.insertVisitor()");
		int k = session.insert("visit.insert");
		System.out.println("result="+k);
	}
}
