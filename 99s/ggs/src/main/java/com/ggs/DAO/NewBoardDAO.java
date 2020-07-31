package com.ggs.DAO;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.FreeboardDTO;

@Repository
public class NewBoardDAO {

	@Autowired
	SqlSessionTemplate session;
	
	public int nbPage() {
		return (Integer)session.selectOne("newboard.nbPage");
	}

	public ArrayList<FreeboardDTO> nbList(FreeboardDTO fbDTO) {
		return (ArrayList)session.selectList("newboard.nbList", fbDTO);
	}

	public FreeboardDTO nbDetail(int writeno) {
		return (FreeboardDTO)session.selectOne("newboard.nbDetail", writeno);
	}

	public void nbwrite(FreeboardDTO fbDTO) {
		session.insert("newboard.nbWrite", fbDTO);
	}

	public void nbupdate(FreeboardDTO fbDTO) {
		session.update("newboard.nbupdate", fbDTO);
	}

	public void nbdelete(int writeno) {
		session.update("newboard.nbdelete", writeno);
	}

	public int SearchPage(FreeboardDTO fbDTO) {
		return (Integer)session.selectOne("newboard.SearchPage", fbDTO);
	}

	public ArrayList<FreeboardDTO> Search(FreeboardDTO fbDTO) {
		return (ArrayList)session.selectList("newboard.Search", fbDTO);
	}

	public void hits(int writeno) {
		session.update("newboard.hits", writeno);
	}

}
