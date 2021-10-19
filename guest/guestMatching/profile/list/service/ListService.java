package loveproject.guest.guestMatching.profile.list.service;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import loveproject.commonService.CommonService;
import loveproject.guest.guestMatching.profile.select.SelectController;

public class ListService {
	
	private Parent listForm;
	
	public void setListForm(Parent listForm) {
		this.listForm = listForm;
	}
	
	
	// 프로필 선택시 SelectForm을 여는 기능
	public void selectOpenForm(String loginid, String id) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/guest/guestMatching/profile/select/SelectForm.fxml"));
		Parent selectForm;
		
		try {
			selectForm = loader.load();
			
			SelectController selectCtrl = loader.getController();
			selectCtrl.setSelectForm(selectForm);
			selectCtrl.setId(id);
			selectCtrl.setLoginId(loginid);
			selectCtrl.getinfoProc();
			
			Stage selectStage = new Stage();
			selectStage.setScene(new Scene(selectForm));
			selectStage.setTitle("Profile");
			selectStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 취소 기능
	public void cancelProc(Parent listForm) {
		CommonService.WindowClose(listForm);
	}
}
