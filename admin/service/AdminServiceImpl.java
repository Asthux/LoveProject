package loveproject.admin.service;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import loveproject.admin.AdminContoller;
import loveproject.admin.menu.GuestContoller;
import loveproject.admin.menu.MatchingContoller;
import loveproject.admin.menu.ResultContoller;
import loveproject.commonService.CommonService;

public class AdminServiceImpl implements AdminService{

private AdminContoller ctrl;
	
	public void setContoller(AdminContoller ctrl) {
		this.ctrl = ctrl;
	}

	@Override
	public void cancelProc(Parent form) { // 취소
		CommonService.WindowClose(form);
	}

	@Override
	public void guestManagement(Parent form) { // 회원관리
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/admin/menu/Guest.fxml"));
		try {
			Parent guestForm = loader.load();
			
			GuestContoller guest = loader.getController();
			guest.setGuestForm(guestForm);
			
			Stage guestStage = new Stage();
			guestStage.setTitle("Guest");
			guestStage.setScene(new Scene(guestForm));
			guestStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void resultManagement(Parent form) { // 통계
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/admin/menu/Result.fxml"));
		try {
			Parent resultForm = loader.load();
			
			ResultContoller result = loader.getController();
			result.setResultForm(resultForm);
			
			Stage resultStage = new Stage();
			resultStage.setTitle("ResultManagement");
			resultStage.setScene(new Scene(resultForm));
			resultStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void matchingManagement(Parent form) { // 매칭관리
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/admin/menu/Matching.fxml"));
		try {
			Parent matchingForm = loader.load();
			
			MatchingContoller matching = loader.getController();
			matching.setMatchingForm(matchingForm);
			
			Stage matchingStage = new Stage();
			matchingStage.setTitle("MatchingManagement");
			matchingStage.setScene(new Scene(matchingForm));
			matchingStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
