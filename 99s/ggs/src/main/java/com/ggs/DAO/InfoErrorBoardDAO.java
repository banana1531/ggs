package com.ggs.DAO;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.FreeboardDTO;
import com.ggs.DTO.InfoErrorBoardDTO;
import com.ggs.DTO.ReplyDTO;

@Repository
public class InfoErrorBoardDAO {

	@Autowired
	SqlSessionTemplate session;

	public int InfoErrorBoardPage() {
		return (Integer)session.selectOne("InfoErrorBoard.InfoErrorBoardPage");
	}

	public ArrayList<InfoErrorBoardDTO> InfoErrorBoardList(InfoErrorBoardDTO ieDTO) {
		return (ArrayList)session.selectList("InfoErrorBoard.InfoErrorBoardList", ieDTO);
	}

	public void hit(InfoErrorBoardDTO ieDTO) {
		session.update("InfoErrorBoard.hit", ieDTO);
	}

	public ArrayList<InfoErrorBoardDTO> InfoErrorBoardDetail(int writeno) {
		return (ArrayList)session.selectList("InfoErrorBoard.InfoErrorBoardDetail",writeno);
	}

	public int ReplyPage(int writeno) {
		return (Integer)session.selectOne("InfoErrorBoard.ReplyPage", writeno);
	}

	public ArrayList<ReplyDTO> InfoErrorBoardReply(ReplyDTO rDTO) {
		return (ArrayList)session.selectList("InfoErrorBoard.InfoErrorBoardReply", rDTO);
	}

	public void replyAdd(ReplyDTO rDTO) {
		session.insert("InfoErrorBoard.replyAdd", rDTO);
	}

	public int SearchPage(InfoErrorBoardDTO ieDTO) {
		return (Integer)session.selectOne("InfoErrorBoard.SearchPage", ieDTO);
	}

	public ArrayList<InfoErrorBoardDTO> freeboardSearch(InfoErrorBoardDTO ieDTO) {
		return (ArrayList)session.selectList("InfoErrorBoard.freeboardSearch", ieDTO);
	}

	public void InfoErrorBoardWrite(InfoErrorBoardDTO ieDTO) {
		session.insert("InfoErrorBoard.InfoErrorBoardWrite", ieDTO);
	}

	public void InfoErrorBoardUpdate(InfoErrorBoardDTO ieDTO) {
		session.update("InfoErrorBoard.InfoErrorBoardUpdate", ieDTO);
	}

	public void InfoErrorBoardDelete(int writeno) {
		session.update("InfoErrorBoard.InfoErrorBoardDelete", writeno);
	}

	
}
