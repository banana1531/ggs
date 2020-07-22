package com.ggs.DAO;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.FreeboardDTO;
import com.ggs.DTO.ReplyDTO;

@Repository
public class FreeBoardDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	
	//최근 등록된 글 가져오기 - 자유게시판, 정보오류 게시판
	public List<BoardDTO> getBoardList(){
			
		return session.selectList("FreeBoard.getRecentList");
	}
	
	//최근 내가 쓴글 5개 가져오기
	public List<BoardDTO> getMyArticle(String uid) {			
		List<BoardDTO> list = session.selectList("memberMapper.board",uid);
		System.out.println(list.toString());
		return list;
	}
	
	//게시판 글 노출/비노출 업데이트 하기
	public int updateBoard(BoardDTO dto) {
		if(dto.getBoardname().equals("freeboard"))
			return session.update("FreeBoard.updateFreeboard", dto);
		else 
			return session.update("FreeBoard.updateinforerrorboard", dto);	
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
	
	public int freeboardPage() {
		return (Integer)session.selectOne("freeboard.freeboardPage");
	}
	
	public ArrayList<FreeboardDTO> freeboardList(FreeboardDTO fbDTO) {
		return (ArrayList)session.selectList("freeboard.freeboardList", fbDTO);
	}
	
	
	
	
}
