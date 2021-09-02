package loveproject.register.service;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import loveproject.commonService.CommonService;
import loveproject.register.dao.RegisterDAO;
import loveproject.register.dto.RegisterDTO;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class RegisterServiceImpl extends Application implements RegisterService {

	@Override
    public void insertProc(Parent regForm) {
    	TextField idText = (TextField)regForm.lookup("#idText");
        PasswordField pwText = (PasswordField)regForm.lookup("#pwText");
        PasswordField pwTextConfirm = (PasswordField)regForm.lookup("#pwTextConfirm");

        TextField nameText = (TextField)regForm.lookup("#nameText");
        TextField phoneText = (TextField)regForm.lookup("#phoneText");
        TextField heightText = (TextField)regForm.lookup("#heightText");
        Label profileLabel = (Label)regForm.lookup("#profileLabel");

        String profile = profileLabel.getText();
        String phone = phoneText.getText();
        String name = nameText.getText();
        String height = heightText.getText();
        String id = idText.getText();
        String pw = pwText.getText();
        String confirm = pwTextConfirm.getText();

        RadioButton manRadio = (RadioButton)regForm.lookup("#manRadio");
        RadioButton womanRadio = (RadioButton)regForm.lookup("#womanRadio");

        String gender = "";
        if(manRadio.isSelected())
            gender += "남";
        else if(womanRadio.isSelected())
            gender += "여";

        RadioButton smokingRadio = (RadioButton)regForm.lookup("#smokingRadio");
        RadioButton nonSmokingRadio = (RadioButton)regForm.lookup("#smokingRadio");

        String smoking = "";
        if (smokingRadio.isSelected())
            smoking += "흡연";
        else if(nonSmokingRadio.isSelected())
            smoking += "비흡연";

        RadioButton blood_a = (RadioButton)regForm.lookup("#blood_a");
        RadioButton blood_b = (RadioButton)regForm.lookup("#blood_b");
        RadioButton blood_ab = (RadioButton)regForm.lookup("#blood_ab");
        RadioButton blood_o = (RadioButton)regForm.lookup("#blood_o");

        String bloodType = "";
        if (blood_a.isSelected())
            bloodType += "A형";
        else if (blood_ab.isSelected())
            bloodType += "AB형";
        else if (blood_b.isSelected())
            bloodType += "B형";
        else if (blood_o.isSelected())
            bloodType += "O형";

        RadioButton mbti_i = (RadioButton)regForm.lookup("#mbti_i");
        RadioButton mbti_e = (RadioButton)regForm.lookup("#mbti_e");
        RadioButton mbti_n = (RadioButton)regForm.lookup("#mbti_n");
        RadioButton mbti_s = (RadioButton)regForm.lookup("#mbti_s");
        RadioButton mbti_f = (RadioButton)regForm.lookup("#mbti_f");
        RadioButton mbti_t = (RadioButton)regForm.lookup("#mbti_t");
        RadioButton mbti_p = (RadioButton)regForm.lookup("#mbti_p");
        RadioButton mbti_j = (RadioButton)regForm.lookup("#mbti_j");

        String mbti = "";
        if (mbti_i.isSelected())
            mbti += "I";
        else if (mbti_e.isSelected())
            mbti += "E";

        if (mbti_n.isSelected())
            mbti += "N";
        else if (mbti_s.isSelected())
            mbti += "S";

        if (mbti_f.isSelected())
            mbti += "F";
        else if (mbti_t.isSelected())
            mbti += "T";

        if (mbti_p.isSelected())
            mbti += "P";
        else if (mbti_j.isSelected())
            mbti += "J";

        ComboBox<String> areaCombo = (ComboBox<String>)regForm.lookup("#areaCombo");
        String area = "";
        if(areaCombo.getValue() != null) {
            area = areaCombo.getValue();
        }

        ComboBox<String> ageCombo = (ComboBox<String>)regForm.lookup("#ageCombo");
        String age = "";
        if(ageCombo.getValue() != null) {
            age = ageCombo.getValue();
        }

        ComboBox<String> drinkCombo = (ComboBox<String>)regForm.lookup("#drinkCombo");
        String drink = "";
        if(drinkCombo.getValue() != null) {
            drink = drinkCombo.getValue();
        }

        TextArea self_introArea = (TextArea)regForm.lookup("#self_introArea");
        String selfIntro = "";
        if (self_introArea.getText() != null)
            selfIntro = self_introArea.getText();

        if(  id.isEmpty() || name.isEmpty() || pw.isEmpty() || confirm.isEmpty() ) {
            CommonService.Msg("데이터를 모두 입력하세요.");
            return;
        }

        if(pw.equals(confirm)) {
            RegisterDAO dao = new RegisterDAO();
            RegisterDTO check = dao.selectId(id);
            if(check == null) {
                RegisterDTO dto = new RegisterDTO();
                dto.setName(name);
                dto.setId(id);
                dto.setPw(pw);
                dto.setPhone(phone);
                dto.setGender(gender);
                dto.setAge(age);
                dto.setArea(area);
                dto.setBloodType(bloodType);
                dto.setDrink(drink);
                dto.setSelfIntro(selfIntro);
                dto.setSmoking(smoking);
                dto.setMbti(mbti);
                dto.setProfile(profile);
                dto.setHeight(height);
                int success = dao.insert(dto);
                if(success == 1) {
                    CommonService.Msg(id + "를(을) 등록 완료 했습니다.");
                    CommonService.WindowClose(regForm);
                }else {
                    CommonService.Msg("에러가 발생했습니다.");
                }
            }else {
                CommonService.Msg(id + "는(은) 등록된 계정입니다.");
            }
        }else {
            CommonService.Msg("입력한 두 패스워드가 틀립니다.");
        }
    }

    public void idCheckProc(Parent regForm){
        TextField idText = (TextField)regForm.lookup("#idText");
        String id = idText.getText();
        RegisterDAO dao = new RegisterDAO();
        RegisterDTO check = dao.selectId(id);
        if (check == null && id.length()>=5){
            CommonService.Msg("사용가능한 ID 입니다");
        }
        else if (id.length()<5){
            CommonService.Msg("ID는 5자 이상 입력해주세요");
        }
        else {
            CommonService.Msg(id + "는(은) 등록된 계정입니다.");
        }
    }
    public void setProfileProc(Parent regForm){
        Label profileLabel = (Label)regForm.lookup("#profileLabel");
        ImageView imageView = (ImageView)regForm.lookup("#imageView");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("프로필 사진 선택");
        Stage stage = new Stage();

        File file = fileChooser.showOpenDialog(stage);
        if (file != null){
            String fileLocation = file.toURI().toString();
            profileLabel.setText(fileLocation);
            Image image = new Image(fileLocation);
            imageView.setImage(image);
        }
    }
    public void openBrowserProc(){
    	try {
            Desktop.getDesktop().browse(new URL(
                    "https://www.16personalities.com/" +
                            "ko/%EB%AC%B4%EB%A3%8C-" +
                            "%EC%84%B1%EA%B2%A9-%EC%9C%A0%ED%98%95-" +
                            "%EA%B2%80%EC%82%AC%22").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelProc(Parent regForm) {
        CommonService.WindowClose(regForm);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
