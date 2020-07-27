package com.ggs.DTO;

//팀정보 테이블 DTO
public class TeamInfoDTO {
	
	private String teamName; 	//팀이름
	private String tel;			//전화/팩스번호
	private String homepage;	//홈페이지
	private String birth;		//창단년도
	private String location;	//위치		
	private String towner;		//구단주
	private String ceo;			//대표이사
	private String head;		//단장
	private String director;	//감독		
	private String history;		//우승기록
	private String stadium;		//경기장
	private int win;			//승수
	private int draw;			//무승부
	private int lose;			//패수
	private int score;			//승점
	private int loss;			//패점
	private float rate;			//승률
	
	
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTowner() {
		return towner;
	}
	public void setTowner(String towner) {
		this.towner = towner;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLoss() {
		return loss;
	}
	public void setLoss(int loss) {
		this.loss = loss;
	}
	@Override
	public String toString() {
		return "TeamInfoDTO [teamName=" + teamName + ", tel=" + tel + ", homepage=" + homepage + ", birth=" + birth
				+ ", location=" + location + ", towner=" + towner + ", ceo=" + ceo + ", head=" + head + ", director="
				+ director + ", history=" + history + ", stadium=" + stadium + ", win=" + win + ", draw=" + draw
				+ ", lose=" + lose + ", score=" + score + ", loss=" + loss + "]";
	}
	
}
