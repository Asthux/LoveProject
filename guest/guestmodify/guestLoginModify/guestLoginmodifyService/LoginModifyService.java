package loveproject.guest.guestmodify.guestLoginModify.guestLoginmodifyService;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import loveproject.commonService.CommonService;
import loveproject.guest.guestmodify.ModifyController;
import loveproject.login.dao.LoginDAO;
import loveproject.register.dto.MemberDTO;

public class LoginModifyService {

	public void cancelProc(Parent loginmodifyForm) {
		CommonService.WindowClose(loginmodifyForm);
		
	}
	
	public void modifyOpenForm(Parent loginmodifyForm) {
		TextField idText = (TextField) loginmodifyForm.lookup("#idText");
		String id = idText.getText();		
		PasswordField pwText = (PasswordField)loginmodifyForm.lookup("#pwText");

		LoginDAO dao = new LoginDAO();
		MemberDTO dto = dao.selectId(idText.getText());
		if(dto != null && dto.getPw().equals(pwText.getText())) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/guest/guestmodify/modifyForm.fxml"));
			try {
				Parent modifyForm = loader.load();
					
				Label id1 = (Label)modifyForm.lookup("#id");
				Label gender = (Label)modifyForm.lookup("#gender");
				Label blood = (Label)modifyForm.lookup("#blood");
				PasswordField pw1 = (PasswordField)modifyForm.lookup("#password");
		        PasswordField pw2 = (PasswordField)modifyForm.lookup("#passwordCheck");
		        TextField nameText = (TextField)modifyForm.lookup("#nameText");
		        TextField phoneText = (TextField)modifyForm.lookup("#phoneText");
		        TextField heightText = (TextField)modifyForm.lookup("#heightText");
		        id1.setText(dto.getId());
		        pw1.setText(dto.getPw());
		        pw2.setText(dto.getPw());
		        nameText.setText(dto.getName());
		        phoneText.setText(dto.getPhone());
		        heightText.setText(dto.getHeight());
		        gender.setText(dto.getGender());
		        blood.setText(dto.getBloodType());
		        
		        ComboBox<String> smokeCombo = (ComboBox<String>)modifyForm.lookup("#smokeCombo");
	            
				if(smokeCombo != null) {
					smokeCombo.getItems().addAll("??????", "?????????");
					smokeCombo.setValue(dto.getSmoking());
				}
				
				ComboBox<String> mbtiCombo = (ComboBox<String>)modifyForm.lookup("#mbtiCombo");
	            
				if(mbtiCombo != null) {
					mbtiCombo.getItems().addAll("ISTJ","ISFJ","INFJ","INTJ","ISTP","ISFP","INFP","INTP","ESTP","ESFP","ENFP","ENTP","ESTJ","ESFJ","ENFJ","ENTJ");
					mbtiCombo.setValue(dto.getMbti());
				}
		        
				ComboBox<String> areaCombo = (ComboBox<String>)modifyForm.lookup("#areaCombo");
		            
				if(areaCombo != null) {
		               areaCombo.getItems().addAll("?????????","?????????","?????????","?????????","?????????","?????????","?????????","?????????","?????????","?????????","????????????","?????????","????????????","?????????","?????????","?????????","?????????","?????????","?????????","????????????","?????????","?????????","?????????","??????","?????????");
		          areaCombo.setValue(dto.getArea());
				}

		        ComboBox<String> ageCombo = (ComboBox<String>)modifyForm.lookup("#ageCombo");
		           if(ageCombo != null) {
		               ageCombo.getItems().addAll("20???","21???","22???","23???","24???","25???","26???","27???","28???","29???","30???","31???","32???","33???","34???","35???","36??? ??????");
		               ageCombo.setValue(dto.getAge());
		           }

		         ComboBox<String> drinkCombo = (ComboBox<String>)modifyForm.lookup("#drinkCombo");
		            if (drinkCombo != null){
		                drinkCombo.getItems().addAll("?????? ??????", "??????~1???","1???~1??????","1??????~2???","2???~2??????","2??????~3???","3??? ??????");
		            drinkCombo.setValue(dto.getDrink());
		            
		            
		            }
			
			         ModifyController modifyCtrl = loader.getController();
			         modifyCtrl.setModifyForm(modifyForm);
			         
					Stage Stage = new Stage();
					Stage.setScene(new Scene(modifyForm));
					Stage.setTitle("???????????????");
					Stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}	        
		
		} else {
			CommonService.Msg("??????????????? ???????????????");
		}
	}
}
