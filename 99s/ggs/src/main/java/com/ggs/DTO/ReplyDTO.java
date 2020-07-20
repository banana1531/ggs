package com.ggs.DTO;

import java.util.Date;

//댓글 테이블 DTO
public class ReplyDTO {

	private int repno;
	private int wno;
	private String boardname;
	private String id;
	private Date writedate;
	private String content;
	private int isvisible;
	
	public int getRepno() {
		return repno;
	}
	public void setRepno(int repno) {
		this.repno = repno;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsvisible() {
		return isvisible;
	}
	public void setIsvisible(int isvisible) {
		this.isvisible = isvisible;
	}
	
	private int start;
	private int end;
	
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "ReplyDTO [repno=" + repno + ", wno=" + wno + ", boardname=" + boardname + ", id=" + id + ", writedate="
				+ writedate + ", content=" + content + ", isvisible=" + isvisible + "]";
	}

}
