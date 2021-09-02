package loveproject.admin.dto;

import javafx.beans.property.StringProperty;

public class MatchingModel {
	private StringProperty name1;
	private StringProperty name2;
	private StringProperty day;
	private StringProperty accept;
	
	public MatchingModel(StringProperty name1, StringProperty name2, StringProperty day, StringProperty accept) {
		this.name1 = name1;
		this.name2 = name2;
		this.day = day;
		this.accept = accept;
	}

	public StringProperty getName1() {
		return name1;
	}

	public void setName1(StringProperty name1) {
		this.name1 = name1;
	}

	public StringProperty getName2() {
		return name2;
	}

	public void setName2(StringProperty name2) {
		this.name2 = name2;
	}

	public StringProperty getDay() {
		return day;
	}

	public void setDay(StringProperty day) {
		this.day = day;
	}

	public StringProperty getaccept() {
		return accept;
	}

	public void setaccept(StringProperty accept) {
		this.accept = accept;
	}
	
	
}
