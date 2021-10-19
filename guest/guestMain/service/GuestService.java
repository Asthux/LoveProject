package loveproject.guest.guestMain.service;

import java.io.IOException;

import loveproject.commonService.CommonService;
import loveproject.guest.guestMatching.MatchingController;
import loveproject.guest.guestmodify.guestLoginModify.LoginModifyController;
import loveproject.guest.guestReview.ReviewController;
import loveproject.guest.guestMatching.profile.list.ListController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class GuestService {
	
private String id;
	
	public void setId(String id) {
		this.id = id;
	}
	public void reviewOpenForm() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/guest/guestReview/reviewForm.fxml"));
		try {
			Parent reviewForm = loader.load();
			Stage Stage = new Stage();
			Stage.setScene(new Scene(reviewForm));
			Stage.setTitle("후기");
			Stage.show();
			ReviewController reviewCtrl = loader.getController();
			reviewCtrl.setReviewForm(reviewForm);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public void matchingOpenForm(){
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/guest/guestMatching/MatchingForm.fxml"));
    	try {
			Parent idealForm = loader.load();
			ComboBox<String> areaCombo = (ComboBox<String>)idealForm.lookup("#areaCombo");
            if(areaCombo != null) {
                areaCombo.getItems().addAll("서울","인천","경기","대전","대구","부산","강원","광주","울산","경남","경북","전남","전북","제주");
            }

	        ComboBox<String> ageCombo = (ComboBox<String>)idealForm.lookup("#ageCombo");
            if(ageCombo != null) {
            	ageCombo.getItems().addAll("20세","21세","22세","23세","24세","25세","26세","27세","28세","29세","30세","31세","32세","33세","34세","35세","36세 이상");
            }

	        ComboBox<String> drinkCombo = (ComboBox<String>)idealForm.lookup("#drinkCombo");
            if(drinkCombo != null) {
            	drinkCombo.getItems().addAll("반병 미만", "반병~1병","1병~1병반","1병반~2병","2병~2병반","2병반~3병","3병 이상");
            }
			MatchingController idealCtrl = loader.getController();
			idealCtrl.setIdealForm(idealForm);
			
			Stage Stage = new Stage();
			Stage.setScene(new Scene(idealForm));
			Stage.setTitle("조건 선택");
			Stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
   
   
    public void cancelProc(Parent Form) {
    	CommonService.WindowClose(Form);
    }
    public void modifyLoginOpenForm() {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/guest/guestmodify/guestLoginModify/loginModifyForm.fxml"));
		try {
			Parent loginModifyForm = loader.load();
			
			LoginModifyController lmodifyCtrl = loader.getController();
			lmodifyCtrl.setLoginModifyForm(loginModifyForm);
	           
    	Stage Stage = new Stage();
		Stage.setScene(new Scene(loginModifyForm));
		Stage.setTitle("프로필수정 로그인");
		Stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void matchingService(String loginid) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/guest/guestMatching/profile/list/ListForm.fxml"));
		Parent listForm;
		
		try {
			listForm = loader.load();
			
			ListController listCtrl = loader.getController();
			listCtrl.setListForm(listForm);
			listCtrl.setLoginId(loginid);
			
			Stage listStage = new Stage();
			listStage.setScene(new Scene(listForm));
			listStage.setTitle("Profile");
			listStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
