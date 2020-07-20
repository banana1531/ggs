package com.ggs.DTO;

import java.sql.Timestamp;

public class DeclarationListDTO {
	
	private String 		boardname;	//게시판 이름
	private int 		fno;		//게시판 글 등록번호
	private String 		uid;		//신고자
	private Timestamp 	inputdate;	//신고일
	private String 		reason;		//사유
	private String 		writer;		//글 작성자
	private String 		title;		//글제목
	private int 		totalcnt;   //전체 글 숫자			
	private int 		start;		//시작 글 숫자
	
	
	
	public int getTotalcnt() {
		return totalcnt;
	}
	public void setTotalcnt(int totalcnt) {
		this.totalcnt = totalcnt;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Timestamp getInputdate() {
		return inputdate;
	}
	public void setInputdate(Timestamp inputdate) {
		this.inputdate = inputdate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "DeclarationListDTO [boardname=" + boardname + ", fno=" + fno + ", uid=" + uid + ", inputdate="
				+ inputdate + ", reason=" + reason + ", writer=" + writer + ", title=" + title + ", totalcnt="
				+ totalcnt + ", start=" + start + "]";
	}
	
	
	
}
