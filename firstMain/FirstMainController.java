package loveproject.firstMain;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import loveproject.firstMain.firstMainService.FirstMainService;
import loveproject.main.Controller;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstMainController implements Initializable {
	private Controller ctrl;
    private Parent mainForm;
    private FirstMainService mainSvc;

    public void setCtrl(Controller ctrl) {
        this.ctrl = ctrl;
    }
    public void setMainForm(Parent mainForm) {
        this.mainForm = mainForm;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainSvc = new FirstMainService();
    }

    public void regOpenProc() {
    	ctrl.openForm("회원가입");
    }
    public void loginOpenProc() {
    	ctrl.openForm("로그인");
    }

}
