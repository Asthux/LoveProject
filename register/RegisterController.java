package loveproject.register;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import loveproject.register.service.RegisterServiceImpl;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
	private Parent regForm;
    private RegisterServiceImpl regSvc;

    public void setRegForm(Parent regForm) {
            this.regForm = regForm;
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        regSvc = new RegisterServiceImpl();
    }
    public void insertProc() {
        regSvc.insertProc(regForm);
    }
    public void cancelProc() {
            regSvc.cancelProc(regForm);
    }
    public void setProfileProc(){
    	regSvc.setProfileProc(regForm);
    }
    public void idCheckProc() {
    	regSvc.idCheckProc(regForm);
    }
    public void openBrowserProc(){
    	regSvc.openBrowserProc();
    }

}
