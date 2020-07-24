package com.ggs.DTO;

import java.util.Date;

//신고접수테이블 DTO	
public class DeclarationDTO {

	private int 	wno;		//관리번호
	private String 	boardname;	//게시판 이름
	private int 	writeno;	//글번호
	private String 	id;			//신고자
	private Date 	inputdate;	//신고일
	private String 	reason;		//신고 사유
	private String 	details;	//신고 사유 상세	
	private Date 	outputdate;	//처리일
	private int 	cnt;		//reason count변수
	
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getWno() {
		return wno;
	}
	public void setWno(int wno) {
		this.wno = wno;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	public int getWriteno() {
		return writeno;
	}
	public void setWriteno(int writeno) {
		this.writeno = writeno;
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
	public Date getOutputdate() {
		return outputdate;
	}
	public void setOutputdate(Date outputdate) {
		this.outputdate = outputdate;
	}
	@Override
	public String toString() {
		return "DeclarationDTO [wno=" + wno + ", boardname=" + boardname + ", writeno=" + writeno + ", id=" + id
				+ ", inputdate=" + inputdate + ", reason=" + reason + ", details=" + details + ", outputdate="
				+ outputdate + "]";
	}
	
	
	
}
