package loveproject.guest.guestMatching.profile.dto;
/*
SQL> desc profile;
 Name                   Null?    Type
 ---------------------- -------- -----------------------
    private String id;			varchar(20)
    private String pw;			varchar(20)
    private String name;		varchar(20)
    private String age;			varchar(20)
    private String phone;		varchar(20)
    private String gender;		varchar(20)
    private String height;		varchar(20)
    private String area;		varchar(20)
    private String drink;		varchar(20)
    private String mbti;		varchar(20)
    private String smoking;		varchar(20)
    private String bloodType;	varchar(20)
    private String selfIntro;	varchar(50)
    private String profile;		varchar(100)

 */
public class ProfileDTO {
	private String id;
    private String pw;
    private String name;
    private String age;
    private String phone;
    private String gender;
    private String height;
    private String area;
    private String drink;
    private String mbti;
    private String smoking;
    private String bloodType;
    private String selfIntro;
    private String profile;
    private String blacklist;
    private String good;

    public ProfileDTO() {	}
    public ProfileDTO(String id, String name, String age, String height, String area) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
		this.area = area;
	}
    public ProfileDTO(String id, String pw, String name, String age, String phone,
    		String gender, String height, String area, String drink, String mbti,
    		String smoking, String bloodType, String selfIntro, String profile,
    		String blacklist, String good) {
    	this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.height = height;
        this.gender = gender;
        this.age = age;
        this.area = area;
        this.drink = drink;
        this.mbti = mbti;
        this.smoking = smoking;
        this.bloodType = bloodType;
        this.selfIntro = selfIntro;
        this.profile = profile;
        this.setBlacklist(blacklist);
        this.setGood(good);
    }

    public String getProfile() { return profile; }

    public void setProfile(String profile) { this.profile = profile; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeight() { return height; }

    public void setHeight(String height) { this.height = height; }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getSelfIntro() {
        return selfIntro;
    }

    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
    }
	public String getBlacklist() {
		return blacklist;
	}
	public void setBlacklist(String blacklist) {
		this.blacklist = blacklist;
	}
	public String getGood() {
		return good;
	}
	public void setGood(String good) {
		this.good = good;
	}
}
