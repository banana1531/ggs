package com.ggs.DTO;

import java.util.Date;

public class TeamRecordDTO {

	private int 	gno;			//경기기록번호
	private Date 	gdate; 			//일자
	private String 	gtime;			//경기시간
	private String 	ateamname;		//a팀번호
	private String 	ascore;			//a팀점수
	private String 	bteamname;		//b팀번호
	private String 	bscore;			//b팀점수
	private String 	stadium;		//경기장
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public Date getGdate() {
		return gdate;
	}
	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}
	public String getGtime() {
		return gtime;
	}
	public void setGtime(String gtime) {
		this.gtime = gtime;
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
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	@Override
	public String toString() {
		return "TeamRecordDTO [gno=" + gno + ", gdate=" + gdate + ", gtime=" + gtime + ", ateamname=" + ateamname
				+ ", ascore=" + ascore + ", bteamname=" + bteamname + ", bscore=" + bscore + ", stadium=" + stadium
				+ "]";
	}
	
	
	
}
