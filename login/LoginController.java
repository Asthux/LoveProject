package loveproject.login;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import loveproject.login.dto.LoginDTO;
import loveproject.login.service.LoginServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
	 private Parent loginForm;
	    private LoginServiceImpl loginSvc;

	    public Parent getLoginForm() {
	        return loginForm;
	    }

	    public void setLoginForm(Parent loginForm) {
	        this.loginForm = loginForm;
	    }

	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
	        loginSvc = new LoginServiceImpl();
	    }


	    public void loginProc() throws IOException {
	        LoginDTO dto = loginSvc.loginProc(loginForm);
	        if (dto.getId().equals("admin")){
	            loginSvc.cancelProc(loginForm);
	            loginSvc.adminOpenForm();
	        }
	        if (dto != null && !dto.getId().equals("admin")){
	            loginSvc.cancelProc(loginForm);
	            loginSvc.guestOpenForm();
	        }
	    }

	    public void cancelProc(){
	        loginSvc.cancelProc(loginForm);
	    }
}
