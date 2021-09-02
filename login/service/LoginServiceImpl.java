package loveproject.login.service;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import loveproject.commonService.CommonService;
import loveproject.guest.GuestController;
import loveproject.login.LoginController;
import loveproject.login.dao.LoginDAO;
import loveproject.login.dto.LoginDTO;
import loveproject.admin.AdminContoller;


import java.io.IOException;

public class LoginServiceImpl implements LoginService{

private String id;
	
	@Override
    public LoginDTO loginProc(Parent loginForm) {
        TextField idText = (TextField) loginForm.lookup("#idText");
        PasswordField pwText = (PasswordField) loginForm.lookup("#pwText");
        id = idText.getText();

        LoginDAO dao = new LoginDAO();
        LoginDTO dto = dao.selectId(id);
        if (dto != null && dto.getPw().equals(pwText.getText())) {
            return dto;
        } else{
            CommonService.Msg("로그인 실패");
            return null;
        }
    }

   public void guestOpenForm(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/guest/GuestMainForm.fxml"));
        Parent guestMainForm;

        try {
            guestMainForm = loader.load();
            GuestController guestCtrl = loader.getController();
            guestCtrl.setGuestForm(guestMainForm);
            guestCtrl.setLoginId(id);
            Stage stage = new Stage();
            stage.setTitle("회원 메인 페이지");
            stage.setScene(new Scene(guestMainForm));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public void adminOpenForm(){
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/admin/AdminMainForm.fxml"));
        Parent adminMainForm;

        try {
            adminMainForm = loader.load();
            AdminContoller adminCtrl = loader.getController();
            adminCtrl.setAdminForm(adminMainForm);

            Stage stage = new Stage();
            stage.setTitle("관리자 메인 페이지");
            stage.setScene(new Scene(adminMainForm));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}


    @Override
    public void cancelProc(Parent loginForm) {
        CommonService.WindowClose(loginForm);
    }

}
