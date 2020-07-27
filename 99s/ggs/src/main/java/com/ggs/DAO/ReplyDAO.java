package com.ggs.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.ReplyDTO;

@Repository
public class ReplyDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	//댓글 달기
	public int reply(ReplyDTO dto) {
		return session.insert("reply.reply", dto);
	}
	
	//댓글 가져오기
	public List<ReplyDTO> getReplyList(BoardDTO boardDTO) {
		return session.selectList("reply.getReplyList", boardDTO);
	}
}
