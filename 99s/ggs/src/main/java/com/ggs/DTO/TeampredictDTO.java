package com.ggs.DTO;

import java.util.Date;

public class TeampredictDTO {

	private int gno;				//경기기록번호
	private Date gdate; 		//일자
	private String 	gtime;			//경기시간
	private String hteamname;		//홈팀번호
	private int hteamscore;		//홈팀점수
	private String ateamname;		//어웨이팀번호
	private int ateamscore;		//홈팀점수
	
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
	public String getHteamname() {
		return hteamname;
	}
	public void setHteamname(String hteamname) {
		this.hteamname = hteamname;
	}
	public int getHteamscore() {
		return hteamscore;
	}
	public void setHteamscore(int hteamscore) {
		this.hteamscore = hteamscore;
	}
	public String getAteamname() {
		return ateamname;
	}
	public void setAteamname(String ateamname) {
		this.ateamname = ateamname;
	}
	public int getAteamscore() {
		return ateamscore;
	}
	public void setAteamscore(int ateamscore) {
		this.ateamscore = ateamscore;
	}
	
	@Override
	public String toString() {
		return "TeamRecordDTO [gno=" + gno + ", gdate=" + gdate + ", hteamname=" + hteamname + ", hteamscore="
				+ hteamscore + ", ateamname=" + ateamname + ", ateamscore=" + ateamscore + "]";
	}
	
}
