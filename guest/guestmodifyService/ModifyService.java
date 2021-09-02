package loveproject.guest.guestmodifyService;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
	        
	        ComboBox<String> mbtiCombo = (ComboBox<String>)modifyForm.lookup("#mbtiCombo");
	        String mbti = "";
	        if(mbtiCombo.getValue() != null) {
	            mbti = mbtiCombo.getValue();
	        }
	        ComboBox<String> smokeCombo = (ComboBox<String>)modifyForm.lookup("#smokeCombo");
	        String smoke = "";
	        if(smokeCombo.getValue() != null) {
	            smoke = smokeCombo.getValue();
	        }
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
			Label id = (Label)modifyForm.lookup("#id");
			String ids = "";
			ids=id.getText();
			
		    if(pw.equals(confirm)) {
	    		GuestDAO dao = new GuestDAO();
	    		GuestDTO check = dao.selectId(ids);
	    		if(check == null) {
	    		GuestDTO dto = new GuestDTO();
    			dto.setPw(pw);
		    	dto.setAge(age);
			    dto.setArea(area);
			    dto.setMbti(mbti);
			    dto.setHeight(height);
			    dto.setDrink(drink);
			    dto.setSmoking(smoke);
			    dto.setName(name);
			    dto.setPhone(phone);
			    dto.setId(ids);
			    dao.modify(dto);
			    CommonService.Msg("수정완료");
			    CommonService.WindowClose(modifyForm);
    		}else {
    			CommonService.Msg("비밀번호를 확인해주세요");
    		}
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	  
	}
}
