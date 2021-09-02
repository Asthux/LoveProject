package loveproject.guest.guestmodify.Service;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import loveproject.commonService.CommonService;
import loveproject.guest.dao.GuestDAO;
import loveproject.guest.dto.GuestDTO;

public class ModifyService {
	public void cancelProc(Parent modifyForm) {
		CommonService.WindowClose(modifyForm);
		
	}

	public void modifyService(Parent modifyForm) {
		try {
			PasswordField pwText = (PasswordField)modifyForm.lookup("#password");
	        PasswordField pwTextConfirm = (PasswordField)modifyForm.lookup("#passwordCheck");

	        TextField nameText = (TextField)modifyForm.lookup("#nameText");
	        TextField phoneText = (TextField)modifyForm.lookup("#phoneText");
	        TextField heightText = (TextField)modifyForm.lookup("#heightText");
	        

	        
	        String phone = phoneText.getText();
	        String name = nameText.getText();
	        String height = heightText.getText();
	        
	        String pw = pwText.getText();
	        String confirm = pwTextConfirm.getText();

	        RadioButton manRadio = (RadioButton)modifyForm.lookup("#manRadio");
	        RadioButton womanRadio = (RadioButton)modifyForm.lookup("#womanRadio");

	        String gender = "";
	        if(manRadio.isSelected())
	            gender += "남";
	        else if(womanRadio.isSelected())
	            gender += "여";

	        RadioButton smokingRadio = (RadioButton)modifyForm.lookup("#smokingRadio");
	        RadioButton nonSmokingRadio = (RadioButton)modifyForm.lookup("#smokingRadio");

	        String smoking = "";
	        if (smokingRadio.isSelected())
	            smoking += "흡연";
	        else if(nonSmokingRadio.isSelected())
	            smoking += "비흡연";

	        RadioButton blood_a = (RadioButton)modifyForm.lookup("#blood_a");
	        RadioButton blood_b = (RadioButton)modifyForm.lookup("#blood_b");
	        RadioButton blood_ab = (RadioButton)modifyForm.lookup("#blood_ab");
	        RadioButton blood_o = (RadioButton)modifyForm.lookup("#blood_o");

	        String bloodType = "";
	        if (blood_a.isSelected())
	            bloodType += "A형";
	        else if (blood_ab.isSelected())
	            bloodType += "AB형";
	        else if (blood_b.isSelected())
	            bloodType += "B형";
	        else if (blood_o.isSelected())
	            bloodType += "O형";

	        RadioButton mbti_i = (RadioButton)modifyForm.lookup("#mbti_i");
	        RadioButton mbti_e = (RadioButton)modifyForm.lookup("#mbti_e");
	        RadioButton mbti_n = (RadioButton)modifyForm.lookup("#mbti_n");
	        RadioButton mbti_s = (RadioButton)modifyForm.lookup("#mbti_s");
	        RadioButton mbti_f = (RadioButton)modifyForm.lookup("#mbti_f");
	        RadioButton mbti_t = (RadioButton)modifyForm.lookup("#mbti_t");
	        RadioButton mbti_p = (RadioButton)modifyForm.lookup("#mbti_p");
	        RadioButton mbti_j = (RadioButton)modifyForm.lookup("#mbti_j");

	        String mbti = "";
	        if (mbti_i.isSelected())
	            mbti += "I";
	        else if (mbti_e.isSelected())
	            mbti += "E";

	        if (mbti_n.isSelected())
	            mbti += "N";
	        else if (mbti_s.isSelected())
	            mbti += "S";

	        if (mbti_f.isSelected())
	            mbti += "F";
	        else if (mbti_t.isSelected())
	            mbti += "T";

	        if (mbti_p.isSelected())
	            mbti += "P";
	        else if (mbti_j.isSelected())
	            mbti += "J";
	        ComboBox<String> areaCombo = (ComboBox<String>)modifyForm.lookup("#areaCombo");
	        String area = "";
	        if(areaCombo.getValue() != null) {
	            area = areaCombo.getValue();
	        }

	        ComboBox<String> ageCombo = (ComboBox<String>)modifyForm.lookup("#ageCombo");
	        String age = "";
	        if(ageCombo.getValue() != null) {
	            age = ageCombo.getValue();
	        }

	        ComboBox<String> drinkCombo = (ComboBox<String>)modifyForm.lookup("#drinkCombo");
	        String drink = "";
	        if(drinkCombo.getValue() != null) {
	            drink = drinkCombo.getValue();
	        }
			Label id = (Label)modifyForm.lookup("#idDB");
			
		    if(pw==confirm) {
	    		GuestDTO dto = new GuestDTO();
	    		GuestDAO dao = new GuestDAO();
    			dto.setPw(pw);
		    	dto.setAge(age);
			    dto.setArea(area);
			    dto.setGender(gender);
			    dto.setMbti(mbti);
			    dto.setBloodType(bloodType);
			    dto.setHeight(height);
			    dto.setDrink(drink);
			    dto.setSmoking(smoking);
			    dto.setName(name);
			    dto.setPhone(phone);
			    dto.setId(id.getText());
			    dao.modify(dto);
			    CommonService.Msg("수정완료");
    		}else {
    			CommonService.Msg("비밀번호를 확인해주세요");
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	  
	}
}
