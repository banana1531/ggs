package com.ggs.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.ReplyDTO;

@Repository
public class ReplyDAO {

	@Inject
	SqlSessionTemplate session;
	
	//댓글 달기
	public int reply(ReplyDTO dto) {
		return session.insert("reply.reply", dto);
	}
	
	// 댓글 가져오기
	public List<ReplyDTO> getReplyList(BoardDTO boardDTO) {
		return session.selectList("reply.getReplyList", boardDTO);
	}

	//자유게시판 //댓글작성
	public void create(ReplyDTO rDTO) {
		session.insert("reply.insertReply", rDTO);
	}

	//자유게시판 //댓글목록
	public List<ReplyDTO> list(int wno) {
		return (List)session.selectList("reply.listReply", wno);
	}
	
	//정보오류게시판 //댓글목록
	public List<ReplyDTO> list2(int wno) {
		return (List)session.selectList("reply.listReply2", wno);
	}

	//정보오류게시판 //댓글작성
	public void create2(ReplyDTO rDTO) {
		session.insert("reply.insertReply2", rDTO);
	}

	//공지사항 //댓글목록
	public List<ReplyDTO> list3(int wno) {
		return (List)session.selectList("reply.listReply3", wno);
	}

	//공지사항 //댓글작성
	public void create3(ReplyDTO rDTO) {
		session.insert("reply.insertReply3", rDTO);
	}
	

	//지식정보게시판 //댓글목록
	public List<ReplyDTO> list4(int wno) {
		return (List)session.selectList("reply.listReply4", wno);
	}

	//지식정보게시판 //댓글작성
	public void create4(ReplyDTO rDTO) {
		session.insert("reply.insertReply4", rDTO);
	}
	
}
