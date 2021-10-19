package loveproject.login.service;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import loveproject.commonService.CommonService;
import loveproject.guest.guestMain.GuestController;
import loveproject.login.dao.LoginDAO;
import loveproject.admin.AdminContoller;
import loveproject.register.dto.MemberDTO;


import java.io.IOException;

public class LoginServiceImpl implements LoginService{

private String id;
	
	@Override
    public MemberDTO loginProc(Parent loginForm) {
        TextField idText = (TextField) loginForm.lookup("#idText");
        PasswordField pwText = (PasswordField) loginForm.lookup("#pwText");
        id = idText.getText();

        LoginDAO dao = new LoginDAO();
        MemberDTO dto = dao.selectId(id);
        if (dto != null && dto.getPw().equals(pwText.getText())) {
            return dto;
        } else{
            CommonService.Msg("로그인 실패");
            return null;
        }
    }

   public void guestOpenForm(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loveproject/guest/guestMain/GuestMainForm.fxml"));
        Parent guestMainForm;
        LoginDAO dao = new LoginDAO();
       MemberDTO dto = dao.selectId(id);
        try {
            guestMainForm = loader.load();
            Label name = (Label)guestMainForm.lookup("#name");
            Label height = (Label)guestMainForm.lookup("#height");
            Label area = (Label)guestMainForm.lookup("#area");
            Label age = (Label)guestMainForm.lookup("#age");
            Label mbti = (Label)guestMainForm.lookup("#mbti");
            Label bloodType = (Label)guestMainForm.lookup("#bloodType");
            Label drink = (Label)guestMainForm.lookup("#drink");
            Label selfIntro = (Label)guestMainForm.lookup("#selfIntro");
            ImageView profile = (ImageView)guestMainForm.lookup("#profile");
            name.setText(dto.getName());
            height.setText(dto.getHeight());
            area.setText(dto.getArea());
            age.setText(dto.getAge());
            mbti.setText(dto.getMbti());
            bloodType.setText(dto.getBloodType());
            drink.setText(dto.getDrink());
            selfIntro.setText(dto.getSelfIntro());
            Image image = new Image(dto.getProfile());
            profile.setImage(image);
            GuestController guestCtrl = loader.getController();
            guestCtrl.setGuestForm(guestMainForm);
            guestCtrl.setLoginId(id);
            Stage stage = new Stage();
            stage.setTitle("Love Project");
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
            stage.setTitle("Love Project");
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
