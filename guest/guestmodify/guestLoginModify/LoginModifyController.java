package loveproject.guest.guestLoginmodify;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import loveproject.guest.guestLoginmodify.guestLoginmodifyService.LoginModifyService;

public class LoginModifyController implements Initializable {

	private Parent loginmodifyForm;
	private LoginModifyService loginmodifySvc;
	public void setLoginModifyForm(Parent loginmodifyForm) {
		this.loginmodifyForm = loginmodifyForm;
	}
	public Parent getLoginModifyForm() {
		return loginmodifyForm;
	}
	
	public void cancelProc() {
		loginmodifySvc.cancelProc(loginmodifyForm);
	}
	public void loginProc(){
		
		loginmodifySvc.modifyOpenForm(loginmodifyForm);
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginmodifySvc = new LoginModifyService();
		
	}
}
