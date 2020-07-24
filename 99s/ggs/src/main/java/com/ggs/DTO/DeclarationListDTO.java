package com.ggs.DTO;

import java.sql.Timestamp;

public class DeclarationListDTO {
	
	private int			wNo;		//등록관리번호
	private String 		boardname;	//게시판 이름
	private int 		fno;		//게시판 글 등록번호
	private String 		uid;		//신고자
	private Timestamp 	inputdate;	//신고일
	private String 		reason;		//사유
	private String 		writer;		//글 작성자
	private Timestamp	writedate;	//글 작성일
	private String 		title;		//글제목
	private int 		totalcnt;   //전체 글 숫자			
	private int 		start;		//시작 글 숫자
	private Timestamp   outputdate;	//처리일자
		
	
	
	
	public Timestamp getOutputdate() {
		return outputdate;
	}
	public void setOutputdate(Timestamp outputdate) {
		this.outputdate = outputdate;
	}
	public int getwNo() {
		return wNo;
	}
	public void setwNo(int wNo) {
		this.wNo = wNo;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
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
		return "DeclarationListDTO [wNo=" + wNo + ", boardname=" + boardname + ", fno=" + fno + ", uid=" + uid
				+ ", inputdate=" + inputdate + ", reason=" + reason + ", writer=" + writer + ", writedate=" + writedate
				+ ", title=" + title + ", totalcnt=" + totalcnt + ", start=" + start + ", outputdate=" + outputdate
				+ "]";
	}
	
	
	
}
