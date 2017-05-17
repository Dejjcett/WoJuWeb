package entity;

public class User {
	private int id;
	private String username;
	private char degree;
	private String picture;
	private String major;
	private String favoriate;
	//还需要对参加的活动和发布的活动进行标识
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public char getDegree() {
		return degree;
	}
	public void setDegree(char degree) {
		this.degree = degree;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getFavoriate() {
		return favoriate;
	}
	public void setFavoriate(String favoriate) {
		this.favoriate = favoriate;
	}
	
}
