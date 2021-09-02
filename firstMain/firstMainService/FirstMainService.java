package loveproject.firstMain.firstMainService;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import loveproject.commonService.CommonService;
import loveproject.login.LoginController;
import loveproject.main.Controller;
import loveproject.register.RegisterController;

import java.io.IOException;

public class FirstMainService {
	private Controller ctrl;

    public void setController(Controller ctrl) {
        this.ctrl = ctrl;
    }

    public void registerOpenForm() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/register/RegisterForm.fxml"));
        Parent regForm;

        try {
            regForm = loader.load();

            ComboBox<String> areaCombo = (ComboBox<String>)regForm.lookup("#areaCombo");
            if(areaCombo != null) {
                areaCombo.getItems().addAll("강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","서대문구","마포구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구");
            }

            ComboBox<String> ageCombo = (ComboBox<String>)regForm.lookup("#ageCombo");
            if(ageCombo != null) {
                ageCombo.getItems().addAll("20세","21세","22세","23세","24세","25세","26세","27세","28세","29세","30세","31세","32세","33세","34세","35세","36세 이상");
            }

            ComboBox<String> drinkCombo = (ComboBox<String>)regForm.lookup("#drinkCombo");
            if (drinkCombo != null){
                drinkCombo.getItems().addAll("반병 미만", "반병~1병","1병~1병반","1병반~2병","2병~2병반","2병반~3병","3병 이상");
            }
            RegisterController regCtrl = loader.getController();
            regCtrl.setRegForm(regForm);

            Stage stage = new Stage();
            stage.setTitle("회원가입");
            stage.setScene(new Scene(regForm));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loginOpenForm() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/login/LoginForm.fxml"));
        Parent loginForm;

        try {
            loginForm = loader.load();
            LoginController loginCtrl = loader.getController();
            loginCtrl.setLoginForm(loginForm);

            Stage stage = new Stage();
            stage.setTitle("로그인");
            stage.setScene(new Scene(loginForm));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancleProc(Parent mainform){
        CommonService.WindowClose(mainform);
    }
}
