package com.ggs.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.DeclarationDAO;
import com.ggs.DAO.FreeBoardDAO;
import com.ggs.DTO.DeclarationListDTO;
import com.ggs.DTO.FreeBoardDTO;

@Service
public class AdminService {

	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	@Autowired
	private DeclarationDAO declarationDAO;
	
	//최근 등록글 가져오기
	public List<FreeBoardDTO> getBoardList(){
		return freeBoardDAO.getBoardList();
	}
	
	//신고 접수 목록 가져오기
	public List<DeclarationListDTO> getDeclList() {
		return declarationDAO.getList();
	}
	
		
}
