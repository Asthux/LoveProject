package loveproject.admin.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import loveproject.admin.AdminContoller;
import loveproject.admin.dao.AdminDAO;
import loveproject.admin.dto.AdminGuestDTO;
import loveproject.admin.menu.GuestManaContoller;
import loveproject.commonService.CommonService;

public class GuestManagementService {
	@FXML
    private ComboBox<String> ageCombo;

    @FXML
    private ComboBox<String> areaCombo;

    @FXML
    private ComboBox<String> genderCombo;

    @FXML
    private ComboBox<String> mbtiCombo;

    @FXML
    private ComboBox<String> bloodCombo;

    @FXML
    private ComboBox<String> drinkCombo;

    @FXML
    private ComboBox<String> smokingCombo;
    
    @FXML
    private Label idDB;
    
    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;
    
    @FXML
    private TextField heightField;
    
    @FXML
    private PasswordField pwCheck;

    @FXML
    private PasswordField pw;
    
    @FXML
    private TextArea selfintroField;
    
private AdminDAO dao = new AdminDAO();
private String id;


public void setId(String id) {
	this.id = id;
}


public void guest(Parent form) {
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/admin/menu/GuestManagement.fxml"));
	
	try {
		Parent guestManaForm = loader.load();
		
		AdminGuestDTO dto = dao.result(dao, id);
		
		ageCombo = (ComboBox<String>)guestManaForm.lookup("#ageCombo"); 
		if(ageCombo != null) {
			ageCombo.getItems().addAll("20세","21세","22세","23세","24세","25세","26세","27세","28세","29세","30세","31세","32세","33세","34세","35세","36세이상");
			ageCombo.setValue(dto.getAge()); 
		}
		
		areaCombo = (ComboBox<String>)guestManaForm.lookup("#areaCombo");
		if(areaCombo != null) {
			areaCombo.getItems().addAll("강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","서대문구","마포구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구");
			areaCombo.setValue(dto.getArea()); 
		}
		
		genderCombo = (ComboBox<String>)guestManaForm.lookup("#genderCombo");
		if(genderCombo != null) {
			genderCombo.getItems().addAll("남","여");
			genderCombo.setValue(dto.getGender());
		}
		
		mbtiCombo = (ComboBox<String>)guestManaForm.lookup("#mbtiCombo");
		if(mbtiCombo != null) {
			mbtiCombo.getItems().addAll("ISTJ","ISFJ","INFJ","INTJ","ISTP","ISFP","INFP","INTP","ESTP","ESFP","ENFP","ENTP","ESTJ","ESFJ","ENFJ","ENTJ");
			mbtiCombo.setValue(dto.getMbti()); 
		}
		
		bloodCombo = (ComboBox<String>)guestManaForm.lookup("#bloodCombo");
		if(bloodCombo != null) {
			bloodCombo.getItems().addAll("A","B","O", "AB");
			bloodCombo.setValue(dto.getBloodtype());
		}
		
		drinkCombo = (ComboBox<String>)guestManaForm.lookup("#drinkCombo");
		if(drinkCombo != null) {
			drinkCombo.getItems().addAll("음주안함","반병미만","반병~1병","1병~1병반", "1병반~2병", "2병~2병반", "3병이상");
			drinkCombo.setValue(dto.getDrink()); 
		}
		
		smokingCombo = (ComboBox<String>)guestManaForm.lookup("#smokingCombo");
		if(smokingCombo != null) {
			smokingCombo.getItems().addAll("흡연","비흡연");
			smokingCombo.setValue(dto.getSmoking());
		}
		
		idDB = (Label)guestManaForm.lookup("#idDB");
		if(idDB != null) {
			idDB.setText(id);
		}
		
		pwCheck = (PasswordField)guestManaForm.lookup("#pwCheck"); 
		pwCheck.setText(dto.getPw());
		pw = (PasswordField)guestManaForm.lookup("#pw");
		pw.setText(dto.getPw());
		
		nameField = (TextField)guestManaForm.lookup("#nameField");
		if(nameField != null) {
			nameField.setText(dto.getName());
		}

	    phoneField = (TextField)guestManaForm.lookup("#phoneField");
	    if(phoneField != null) {
	    	phoneField.setText(dto.getPhone());
	    }
	    
	    heightField = (TextField)guestManaForm.lookup("#heightField");
		if(heightField != null) {
			heightField.setText(dto.getHeight());
		}
	    
	    selfintroField = (TextArea)guestManaForm.lookup("#selfintroField");
	    if(selfintroField != null) {
	    	selfintroField.setText(dto.getSelfintro());
	    }
			
		GuestManaContoller guestMana = loader.getController();
		guestMana.setGuestManaForm(guestManaForm);
		
		Stage guestStage = new Stage();
		guestStage.setTitle("GuestManagement");
		guestStage.setScene(new Scene(guestManaForm));
		guestStage.show();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void reSelect(Parent guestManaForm) {

	try {
		ComboBox<String> age = (ComboBox<String>)guestManaForm.lookup("#ageCombo");
		ComboBox<String> area = (ComboBox<String>)guestManaForm.lookup("#areaCombo");
		ComboBox<String> gender = (ComboBox<String>)guestManaForm.lookup("#genderCombo");
		ComboBox<String> mbti = (ComboBox<String>)guestManaForm.lookup("#mbtiCombo");
		ComboBox<String> blood = (ComboBox<String>)guestManaForm.lookup("#bloodCombo");
		ComboBox<String> drink = (ComboBox<String>)guestManaForm.lookup("#drinkCombo");
		ComboBox<String> smoking = (ComboBox<String>)guestManaForm.lookup("#smokingCombo");
		TextField name = (TextField)guestManaForm.lookup("#nameField");
		TextField phone = (TextField)guestManaForm.lookup("#phoneField");
		TextField height = (TextField)guestManaForm.lookup("#heightField");
		PasswordField pwCheck = (PasswordField)guestManaForm.lookup("#pwCheck"); 
		PasswordField pw = (PasswordField)guestManaForm.lookup("#pw");
		TextArea intro = (TextArea)guestManaForm.lookup("#selfintroField");
		Label id = (Label)guestManaForm.lookup("#idDB");
		
	    if(pw.getText().equals(pwCheck.getText())) {
    		AdminGuestDTO dto = new AdminGuestDTO();
			dto.setPw(pw.getText());
	    	dto.setAge(age.getValue());
		    dto.setArea(area.getValue());
		    dto.setGender(gender.getValue());
		    dto.setMbti(mbti.getValue());
		    dto.setBloodtype(blood.getValue());
		    dto.setHeight(height.getText());
		    dto.setDrink(drink.getValue());
		    dto.setSmoking(smoking.getValue());
		    dto.setName(name.getText());
		    dto.setPhone(phone.getText());
		    dto.setSelfintro(intro.getText());
		    dto.setId(id.getText());
		    dao.reSelect(dto);
		    CommonService.Msg("수정완료");
		}else {
			CommonService.Msg("비밀번호를 확인해주세요");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
  
}

public void delete(Parent guestManaForm) {  // 탈퇴버튼 누르면 DB DELETE 넣기
	Label id = (Label)guestManaForm.lookup("#idDB");
	dao.delete(id.getText());
	CommonService.WindowClose(guestManaForm);
	AdminContoller ctrl = new AdminContoller();
	AdminServiceImpl svc = new AdminServiceImpl();
	Parent form = ctrl.getAdminForm();
	svc.guestManagement(form);
	CommonService.Msg("탈퇴되었습니다");
	
}

public void GuestManaCancle(Parent guestManaForm) {
		CommonService.WindowClose(guestManaForm);
		AdminContoller ctrl = new AdminContoller();
		AdminServiceImpl svc = new AdminServiceImpl();
		Parent form = ctrl.getAdminForm();
		svc.guestManagement(form);
	
}


}
