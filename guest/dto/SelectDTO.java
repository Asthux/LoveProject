package loveproject.guest.dto;

public class SelectDTO {
	private String name;
    private String age;
    private String gender;
    private String height;
    private String area;
    private String drink;
    private String mbti;
    private String smoking;
    private String bloodType;
    
    public SelectDTO () {
    	
    }
    public SelectDTO (String name, String age, String height, String area) {
    	this.name = name;
    	this.age = age;
    	this.height = height;
    	this.area = area;
    }
    public SelectDTO (String name,
    		String age,String height,
    		String area, String gender, String drink, String mbti, String smoking,
    		String bloodType) {
       
        this.name = name;       
        this.height = height;
        this.gender = gender;
        this.age = age;
        this.area = area;
        this.drink = drink;
        this.mbti = mbti;
        this.smoking = smoking;
        this.bloodType = bloodType;
     
    }
    
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getMbti() {
		return mbti;
	}
	public void setMbti(String mbti) {
		this.mbti = mbti;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
