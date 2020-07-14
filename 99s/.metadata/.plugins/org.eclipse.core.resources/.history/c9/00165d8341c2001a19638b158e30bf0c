package com.ggs.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.DeclarationListDTO;

@Repository
public class DeclarationDAO {
		
	@Autowired
	private SqlSessionTemplate session;

	public List<DeclarationListDTO> getList() {
		
		return session.selectList("declaration.getList");
	}
			
}
