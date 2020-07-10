package com.ggs.DTO;

import java.sql.Date;
import java.sql.Timestamp;

//자유게시판 테이블  DTO
public class FreeBoardDTO {
	
	private int 	writeno; 		//글 관리번호
	private String 	id; 		//글쓴이
	private String 	title;		//제목
	private String 	content;	//내용
	private Timestamp 	writedate;	//작성일
	private int 	views;		//조회수
	private int 	isvisible;	//노출,비노출
	
	public int getWno() {
		return writeno;
	}
	public void setWno(int wno) {
		this.writeno = wno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp wdate) {
		this.writedate = wdate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getIsvisible() {
		return isvisible;
	}
	public void setIsvisible(int isvisible) {
		this.isvisible = isvisible;
	}
	@Override
	public String toString() {
		return "freeBoardDTO [wno=" + writeno + ", id=" + id + ", title=" + title + ", content=" + content + ", wdate="
				+ writedate + ", views=" + views + ", isvisible=" + isvisible + "]";
	}
	
	
}