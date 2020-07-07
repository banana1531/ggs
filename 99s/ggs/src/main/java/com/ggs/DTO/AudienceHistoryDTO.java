package com.ggs.DTO;

//역대관중 테이블 DTO
public class AudienceHistoryDTO {
	
	private int 	cno;        //관리번호
	private String 	teamName;	//팀이름
	private String 	years;		//년도
	private int 	totalaudi;	//전체관중
	private int 	avgaudi;	//평균관중
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public int getTotalaudi() {
		return totalaudi;
	}
	public void setTotalaudi(int totalaudi) {
		this.totalaudi = totalaudi;
	}
	public int getAvgaudi() {
		return avgaudi;
	}
	public void setAvgaudi(int avgaudi) {
		this.avgaudi = avgaudi;
	}
	@Override
	public String toString() {
		return "audienceHistoryDTO [cno=" + cno + ", teamName=" + teamName + ", years=" + years + ", totalaudi="
				+ totalaudi + ", avgaudi=" + avgaudi + "]";
	}
	
	
}
