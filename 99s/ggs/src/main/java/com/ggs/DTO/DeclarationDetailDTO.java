package com.ggs.DTO;

import java.util.Date;

public class DeclarationDetailDTO {
	private String 	boardname;  //게시판 이름
	private int 	fno;		//글번호
	private String 	id;			//신고자
	private Date 	inputdate;	//신고일자
	private String 	reason;		//신고사유
	private String 	details;	//신고사유 상세
	private String 	writer;		//글작성자			
	private String 	title;		//글제목
	private String 	content;	//글내용
	private Date 	writedate;	//글작성일
	private int 	views;		//조회수
	private int 	invisible;	//노출/비노출
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getInputdate() {
		return inputdate;
	}
	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getInvisible() {
		return invisible;
	}
	public void setInvisible(int invisible) {
		this.invisible = invisible;
	}
	@Override
	public String toString() {
		return "DeclarationDetailDTO [boardname=" + boardname + ", fno=" + fno + ", id=" + id + ", inputdate="
				+ inputdate + ", reason=" + reason + ", details=" + details + ", writer=" + writer + ", title=" + title
				+ ", content=" + content + ", writedate=" + writedate + ", views=" + views + ", invisible=" + invisible
				+ "]";
	}
	
	
	
}
