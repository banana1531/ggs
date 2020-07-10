package com.ggs.team;

public class TeamDTO {

	private String teamName;
	private String tel;
	private String homepage;
	private String birth;
	private String location;
	private String owner;
	private String ceo;
	private String head;
	private String director;
	private String history;
	
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
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
	
	@Override
	public String toString() {
		return "TeamDTO [teamName=" + teamName + ", tel=" + tel + ", homepage=" + homepage + ", birth=" + birth
				+ ", location=" + location + ", owner=" + owner + ", ceo=" + ceo + ", head=" + head + ", director="
				+ director + ", history=" + history + "]";
	}
}
