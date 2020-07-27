package com.ggs.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.DeclarationDAO;
import com.ggs.DAO.FreeBoardDAO;
import com.ggs.DAO.LonginRecordDAO;
import com.ggs.DAO.MembersDAO;
import com.ggs.DTO.DeclarationDTO;
import com.ggs.DTO.DeclarationDetailDTO;
import com.ggs.DTO.DeclarationListDTO;
import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.MembersDTO;

@Service
public class AdminService {

	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	//최근 등록글 가져오기
	public List<BoardDTO> getBoardList(){
		return freeBoardDAO.getBoardList();
	}
	
}
