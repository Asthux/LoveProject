package loveproject.admin.dto;

import javafx.beans.property.StringProperty;

public class GuestModel {
	private String id;
	private StringProperty name;
	private StringProperty age;
	private StringProperty gender;
	private StringProperty area;
	private StringProperty blackList;
	private StringProperty good;
	
	public GuestModel(String id, StringProperty name, StringProperty age, StringProperty gender, StringProperty area,
			StringProperty blackList, StringProperty good) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.area = area;
		this.blackList = blackList;
		this.good = good;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public StringProperty getName() {
		return name;
	}
	public void setName(StringProperty name) {
		this.name = name;
	}
	public StringProperty getAge() {
		return age;
	}
	public void setAge(StringProperty age) {
		this.age = age;
	}
	public StringProperty getGender() {
		return gender;
	}
	public void setGender(StringProperty gender) {
		this.gender = gender;
	}
	public StringProperty getArea() {
		return area;
	}
	public void setArea(StringProperty area) {
		this.area = area;
	}
	public StringProperty getBlackList() {
		return blackList;
	}
	public void setBlackList(StringProperty blackList) {
		this.blackList = blackList;
	}
	public StringProperty getGood() {
		return good;
	}
	public void setGood(StringProperty good) {
		this.good = good;
	}
	
	
	
	
	

}
