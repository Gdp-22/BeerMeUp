package it.beermeup.model;

public class Address {
	
	private int id = 0;
	private int user_id = 0;
	private String street = "";
	private String num = "";
	private String cap = "";
	private String city = "";
	private String nation = "";
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return user_id;
	}
	
	public void setUserId(int user_id) {
		this.user_id = user_id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getCap() {
		return cap;
	}
	
	public void setCap(String cap) {
		this.cap = cap;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getNation() {
		return nation;
	}
	
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", user_id=" + user_id + ", street=" + street + ", num=" + num + ", cap="
				+ cap + ", city=" + city + ", nation=" + nation + "]";
	}
}
