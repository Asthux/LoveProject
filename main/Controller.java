package loveproject.main;

import javafx.scene.Parent;
import loveproject.commonService.CommonService;
import loveproject.firstMain.FirstMainController;
import loveproject.firstMain.firstMainService.FirstMainService;

public class Controller {
	private FirstMainController firstMainCtrl;
    private FirstMainService mainSvc;
    private Parent mainForm;

    public Controller() {
        mainSvc = new FirstMainService();
    }

    public void setMainForm(Parent mainForm) {
        this.mainForm = mainForm;
    }

    public void setFirstMainCtrl(FirstMainController firstMainCtrl) {
        this.firstMainCtrl = firstMainCtrl;
        this.firstMainCtrl.setCtrl(this);
    }

    public FirstMainController getFirstMainCtrl() {
        return firstMainCtrl;
    }

    public void openForm(String name) {
        if(name.equals("로그인")) {
            mainSvc.setController(this);
            mainSvc.loginOpenForm();
        }
        if(name.equals("회원가입")) {
            mainSvc.setController(this);
            mainSvc.registerOpenForm();
        }
    }

}
