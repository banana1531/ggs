package com.ggs.DAO;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.ReplyDTO;


@Repository
public class ColumnDAO {

	//자동주입
	@Autowired
	SqlSessionTemplate session;
	
	public ArrayList<ReplyDTO> cBoardReply(ReplyDTO rDTO) {
		return (ArrayList)session.selectList("column.cBoardReply", rDTO);
	}

	//댓글추가
	public void replyAdd(ReplyDTO rDTO) {
		System.out.println("columnDAO replyAdd 왔니");
		session.insert("column.replyAdd", rDTO);
	}

	public int replyPage(int writeno) {
		return (Integer)session.selectOne("column.replyPage", writeno);
	}
	
	public ArrayList<BoardDTO> cBoardSearch(BoardDTO bDTO) {
		return (ArrayList)session.selectList("column.cBoardSearch", bDTO);
	}

	public int searchPage(BoardDTO bDTO) {
		return (Integer)session.selectOne("column.searchPage", bDTO);
	}
	
	public void hit(BoardDTO bDTO) {
		session.update("column.hit", bDTO);
	}
	
	public void cBoardDelete(int writeno) {
		session.update("column.cBoardDelete", writeno);
	}
	
	public void cBoardUpdate(BoardDTO bDTO) {
		session.update("column.cBoardUpdate", bDTO);
	}
	
	public ArrayList<BoardDTO> cBoardDetail(int writeno) {
		return (ArrayList)session.selectList("column.cBoardDetail", writeno);
	}
	
	//글쓰기
	public void cBoardWrite(BoardDTO bDTO) {
		System.out.println("columnDAO의 cBoardWrite() ="+bDTO);
		session.insert("column.cBoardWrite", bDTO);
	}
	
	public int cBoardPage() {
		return (Integer)session.selectOne("column.cBoardPage");
	}

	public ArrayList<BoardDTO> cBoardList(BoardDTO bDTO) {
		return (ArrayList)session.selectList("column.cBoardList", bDTO);
	}
	
	
	

	
	
}