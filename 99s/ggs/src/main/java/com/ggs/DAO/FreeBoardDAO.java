package com.ggs.DAO;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.FreeboardDTO;
import com.ggs.DTO.ReplyDTO;

@Repository
public class FreeboardDAO {

	@Autowired
	SqlSessionTemplate session;
	
	public int freeboardPage() {
		return (Integer)session.selectOne("freeboard.freeboardPage");
	}

	public ArrayList<FreeboardDTO> freeboardList(FreeboardDTO fbDTO) {
		return (ArrayList)session.selectList("freeboard.freeboardList", fbDTO);
	}

	public void hit(FreeboardDTO fbDTO) {
		session.update("freeboard.hit", fbDTO);
	}

	public ArrayList<FreeboardDTO> freeboardDetail(int writeno) {
		return (ArrayList)session.selectList("freeboard.freeboardDetail",writeno);
	}

	public int ReplyPage(int writeno) {
		return (Integer)session.selectOne("freeboard.ReplyPage", writeno);
	}

	public ArrayList<ReplyDTO> freeboardReply(ReplyDTO rDTO) {
		return (ArrayList)session.selectList("freeboard.freeboardReply", rDTO);
	}

	public void replyAdd(ReplyDTO rDTO) {
		session.insert("freeboard.replyAdd", rDTO);
	}

	public int SearchPage(FreeboardDTO fbDTO) {
		return (Integer)session.selectOne("freeboard.SearchPage", fbDTO);
	}

	public ArrayList<FreeboardDTO> freeboardSearch(FreeboardDTO fbDTO) {
		return (ArrayList)session.selectList("freeboard.freeboardSearch", fbDTO);
	}

	public void freeboardWrite(FreeboardDTO fbDTO) {
		session.insert("freeboard.freeboardWrite", fbDTO);
	}

	public void freeboardUpdate(FreeboardDTO fbDTO) {
		session.update("freeboard.freeboardUpdate", fbDTO);
	}

	public void freeboardDelete(int writeno) {
		session.update("freeboard.freeboardDelete", writeno);
	}

}
