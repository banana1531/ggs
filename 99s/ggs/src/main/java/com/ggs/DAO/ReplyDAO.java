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

	// 댓글 작성
	public void create(ReplyDTO rDTO) {
		session.insert("reply.insertReply", rDTO);
	}

	// 댓글 목록
	public List<ReplyDTO> list(int wno) {
		return (List)session.selectList("reply.listReply", wno);
	}
	
	//댓글 달기
	public int reply(ReplyDTO dto) {
		return session.insert("reply.reply", dto);
	}
	
	//댓글 가져오기
	public List<ReplyDTO> getReplyList(BoardDTO boardDTO) {
		return session.selectList("reply.getReplyList", boardDTO);
	}
}
