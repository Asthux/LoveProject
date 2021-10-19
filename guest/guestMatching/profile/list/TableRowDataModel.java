package loveproject.guest.guestMatching.profile.list;

import javafx.beans.property.StringProperty;

public class TableRowDataModel {
	private String id;
	private StringProperty name; 
	private StringProperty age; 
	private StringProperty height; 
	private StringProperty address;
	public TableRowDataModel(String id, StringProperty name, StringProperty age, StringProperty height, StringProperty address) {
		this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.address = address;
    }
	
	public String getid() {
		return id;
	}
	public StringProperty nameProperty() {
        return name;
    }
	public StringProperty ageProperty() {
		return age;
	}
	public StringProperty heightProperty() {
		return height;
	}
	public StringProperty addressProperty() {
		return address;
	}
}
