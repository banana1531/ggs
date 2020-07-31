package com.ggs.DTO;

public class MemberStaticDTO {
	
	private int today;			//금일 접속자수
	private int weeklylogin;	//금주 누적 접속자수
	private int weeklyjoin;		//금주 신규 가입자수
	private int totalmembers;	//전체 가입자수
	public int getToday() {
		return today;
	}
	public void setToday(int today) {
		this.today = today;
	}
	public int getWeeklylogin() {
		return weeklylogin;
	}
	public void setWeeklylogin(int weeklylogin) {
		this.weeklylogin = weeklylogin;
	}
	public int getWeeklyjoin() {
		return weeklyjoin;
	}
	public void setWeeklyjoin(int weeklyjoin) {
		this.weeklyjoin = weeklyjoin;
	}
	public int getTotalmembers() {
		return totalmembers;
	}
	public void setTotalmembers(int totalmembers) {
		this.totalmembers = totalmembers;
	}
	@Override
	public String toString() {
		return "MemberStaticDTO [today=" + today + ", weeklylogin=" + weeklylogin + ", weeklyjoin=" + weeklyjoin
				+ ", totalmembers=" + totalmembers + "]";
	}
	
	
	
}
