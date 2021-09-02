package loveproject.guest.guestLoginmodifyService;

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
import loveproject.login.dto.LoginDTO;

public class LoginModifyService {

	public void cancelProc(Parent loginmodifyForm) {
		CommonService.WindowClose(loginmodifyForm);
		
	}
	
	public void modifyOpenForm(Parent loginmodifyForm) {
		TextField idText = (TextField) loginmodifyForm.lookup("#idText");
		String id = idText.getText();		
		PasswordField pwText = (PasswordField)loginmodifyForm.lookup("#pwText");

		LoginDAO dao = new LoginDAO();
		LoginDTO dto = dao.selectId(idText.getText());
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
					smokeCombo.getItems().addAll("흡연", "비흡연");
					smokeCombo.setValue(dto.getSmoking());
				}
				
				ComboBox<String> mbtiCombo = (ComboBox<String>)modifyForm.lookup("#mbtiCombo");
	            
				if(mbtiCombo != null) {
					mbtiCombo.getItems().addAll("ISTJ","ISFJ","INFJ","INTJ","ISTP","ISFP","INFP","INTP","ESTP","ESFP","ENFP","ENTP","ESTJ","ESFJ","ENFJ","ENTJ");
					mbtiCombo.setValue(dto.getMbti());
				}
		        
				ComboBox<String> areaCombo = (ComboBox<String>)modifyForm.lookup("#areaCombo");
		            
				if(areaCombo != null) {
		               areaCombo.getItems().addAll("강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","서대문구","마포구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구");
		          areaCombo.setValue(dto.getArea());
				}

		        ComboBox<String> ageCombo = (ComboBox<String>)modifyForm.lookup("#ageCombo");
		           if(ageCombo != null) {
		               ageCombo.getItems().addAll("20세","21세","22세","23세","24세","25세","26세","27세","28세","29세","30세","31세","32세","33세","34세","35세","36세 이상");
		               ageCombo.setValue(dto.getAge());
		           }

		         ComboBox<String> drinkCombo = (ComboBox<String>)modifyForm.lookup("#drinkCombo");
		            if (drinkCombo != null){
		                drinkCombo.getItems().addAll("반병 미만", "반병~1병","1병~1병반","1병반~2병","2병~2병반","2병반~3병","3병 이상");
		            drinkCombo.setValue(dto.getDrink());
		            
		            
		            }
			
			         ModifyController modifyCtrl = loader.getController();
			         modifyCtrl.setModifyForm(modifyForm);
			         
					Stage Stage = new Stage();
					Stage.setScene(new Scene(modifyForm));
					Stage.setTitle("프로필수정");
					Stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}	        
		
		} else {
			CommonService.Msg("회원정보가 틀렸습니다");
		}
	}
}
