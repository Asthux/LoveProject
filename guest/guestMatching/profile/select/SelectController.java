package loveproject.guest.guestMatching.profile.select;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import loveproject.guest.guestMatching.profile.select.service.SelectService;

public class SelectController implements Initializable{
	
	private Parent selectForm;
	private SelectService selectSvc;
	private String loginid;
	private String id;
	
	public void setSelectForm(Parent selectForm) {
		this.selectForm = selectForm;
	}
	public void setLoginId(String loginid) {
		this.loginid = loginid;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		selectSvc = new SelectService();
	}
	
	// 프로필 정보를 가져오는 기능
	public void getinfoProc() {
		selectSvc.getinfoProc(selectForm, id);
	}
		
	// 매칭 요청
	public void matchingProc() {
		selectSvc.matchingProc(loginid, id);
	}
	
	// 매칭 취소를 눌렀을 때의 기능
	public void cencel() {
		selectSvc.cencel(loginid, id);
	}

}
