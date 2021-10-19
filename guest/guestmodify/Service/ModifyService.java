package loveproject.guest.guestmodify.Service;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import loveproject.commonService.CommonService;
import loveproject.guest.dao.GuestDAO;
import loveproject.register.dto.MemberDTO;

public class ModifyService {
	public void cancelProc(Parent modifyForm) {
		CommonService.WindowClose(modifyForm);
		
	}

	public void modifyService(Parent modifyForm) {
		try {
			PasswordField pwText = (PasswordField)modifyForm.lookup("#pw");
	        PasswordField pwTextConfirm = (PasswordField)modifyForm.lookup("#confirmPw");

	        TextField nameText = (TextField)modifyForm.lookup("#name");
	        TextField heightText = (TextField)modifyForm.lookup("#height");

	        String name = nameText.getText();
	        String height = heightText.getText();
	        
	        String pw = pwText.getText();
	        String confirm = pwTextConfirm.getText();

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

			TextField mbtiText = (TextField)modifyForm.lookup("#mbti");
			String mbti = mbtiText.getText();

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
				MemberDTO dto = new MemberDTO();
	    		GuestDAO dao = new GuestDAO();
    			dto.setPw(pw);
		    	dto.setAge(age);
			    dto.setArea(area);
			    dto.setMbti(mbti);
			    dto.setBloodType(bloodType);
			    dto.setHeight(height);
			    dto.setDrink(drink);
			    dto.setSmoking(smoking);
			    dto.setName(name);
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
