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
	private float avgScore;		//평균 득점
	private float avgLoss;		//평균 실점
	private int zeroScore;		//무득점
	private int zeroLoss;       //무실점
	private int maxScore;   	//최다득점
	private int maxLoss;		//최다실점
	
	
	
	public int getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	public int getMaxLoss() {
		return maxLoss;
	}
	public void setMaxLoss(int maxLoss) {
		this.maxLoss = maxLoss;
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
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(float avgScore) {
		this.avgScore = avgScore;
	}
	public float getAvgLoss() {
		return avgLoss;
	}
	public void setAvgLoss(float avgLoss) {
		this.avgLoss = avgLoss;
	}
	public int getZeroScore() {
		return zeroScore;
	}
	public void setZeroScore(int zeroScore) {
		this.zeroScore = zeroScore;
	}
	public int getZeroLoss() {
		return zeroLoss;
	}
	public void setZeroLoss(int zeroLoss) {
		this.zeroLoss = zeroLoss;
	}
	@Override
	public String toString() {
		return "TeamInfoDTO [teamName=" + teamName + ", tel=" + tel + ", homepage=" + homepage + ", birth=" + birth
				+ ", location=" + location + ", towner=" + towner + ", ceo=" + ceo + ", head=" + head + ", director="
				+ director + ", history=" + history + ", stadium=" + stadium + ", win=" + win + ", draw=" + draw
				+ ", lose=" + lose + ", score=" + score + ", loss=" + loss + ", rate=" + rate + ", avgScore=" + avgScore
				+ ", avgLoss=" + avgLoss + ", zeroScore=" + zeroScore + ", zeroLoss=" + zeroLoss + ", maxScore="
				+ maxScore + ", maxLoss=" + maxLoss + "]";
	}
	
	
	
	
}
