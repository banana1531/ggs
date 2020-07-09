package com.ggs.DTO;

import java.sql.Date;

//승부예측 테이블DTO
public class PreResultDTO {
	
	private int 	ino;		//관리번호
	private String 	id;			//회원아이디
	private int 	gno;		//게임관리번호
	private String 	predict;	//예측값
	private int 	ppoint;		//포인트 증감
	private Date 	gdate;		//경기일자
	private String 	bteamname;	//홈팀번호
	private String 	bscore;		//홈팀점수
	private String 	ateamname;	//어웨이팀번호
	private String 	ascore;		//홈팀점수
		
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getPredict() {
		return predict;
	}
	public void setPredict(String predict) {
		this.predict = predict;
	}
	public int getPpoint() {
		return ppoint;
	}
	public void setPpoint(int ppoint) {
		this.ppoint = ppoint;
	}
	public Date getGdate() {
		return gdate;
	}
	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}
	public String getBteamname() {
		return bteamname;
	}
	public void setBteamname(String bteamname) {
		this.bteamname = bteamname;
	}
	public String getBscore() {
		return bscore;
	}
	public void setBscore(String bscore) {
		this.bscore = bscore;
	}
	public String getAteamname() {
		return ateamname;
	}
	public void setAteamname(String ateamname) {
		this.ateamname = ateamname;
	}
	public String getAscore() {
		return ascore;
	}
	public void setAscore(String ascore) {
		this.ascore = ascore;
	}
	@Override
	public String toString() {
		return "PreResultDTO [ino=" + ino + ", id=" + id + ", gno=" + gno + ", predict=" + predict + ", ppoint="
				+ ppoint + ", gdate=" + gdate + ", bteamname=" + bteamname + ", bscore=" + bscore + ", ateamname="
				+ ateamname + ", ascore=" + ascore + "]";
	}
	
	
}
