package loveproject.guest.guestMatching.service;

import loveproject.commonService.CommonService;
import loveproject.guest.dao.GuestDAO;
import loveproject.guest.dto.GuestDTO;

import java.util.ArrayList;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class IdealService {

	public void cancelProc(Parent form) {
		CommonService.WindowClose(form);
		
	}
	//검증 선택후 db에 저장

	public void selectProc(Parent idealForm) {
		
		TextField heightText = (TextField)idealForm.lookup("#heightText");
		String height = heightText.getText();
		RadioButton manRadio = (RadioButton)idealForm.lookup("#manRadio");
        RadioButton womanRadio = (RadioButton)idealForm.lookup("#womanRadio");
        
        String gender = "";
        if(manRadio.isSelected())
            gender += "남";
        else if(womanRadio.isSelected())
            gender += "여";

        RadioButton smokingRadio = (RadioButton)idealForm.lookup("#smokingRadio");
        RadioButton nonSmokingRadio = (RadioButton)idealForm.lookup("#smokingRadio");

        String smoking = "";
        if (smokingRadio.isSelected())
            smoking += "흡연";
        else if(nonSmokingRadio.isSelected())
            smoking += "비흡연";

        RadioButton blood_a = (RadioButton)idealForm.lookup("#blood_a");
        RadioButton blood_b = (RadioButton)idealForm.lookup("#blood_b");
        RadioButton blood_ab = (RadioButton)idealForm.lookup("#blood_ab");
        RadioButton blood_o = (RadioButton)idealForm.lookup("#blood_o");

        String bloodType = "";
        if (blood_a.isSelected())
            bloodType += "A형";
        else if (blood_ab.isSelected())
            bloodType += "AB형";
        else if (blood_b.isSelected())
            bloodType += "B형";
        else if (blood_o.isSelected())
            bloodType += "O형";

        RadioButton mbti_i = (RadioButton)idealForm.lookup("#mbti_i");
        RadioButton mbti_e = (RadioButton)idealForm.lookup("#mbti_e");
        RadioButton mbti_n = (RadioButton)idealForm.lookup("#mbti_n");
        RadioButton mbti_s = (RadioButton)idealForm.lookup("#mbti_s");
        RadioButton mbti_f = (RadioButton)idealForm.lookup("#mbti_f");
        RadioButton mbti_t = (RadioButton)idealForm.lookup("#mbti_t");
        RadioButton mbti_p = (RadioButton)idealForm.lookup("#mbti_p");
        RadioButton mbti_j = (RadioButton)idealForm.lookup("#mbti_j");

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

        ComboBox<String> areaCombo = (ComboBox<String>)idealForm.lookup("#areaCombo");
        String area = "";
        if(areaCombo.getValue() != null) {
            area = areaCombo.getValue();
        }

        ComboBox<String> ageCombo = (ComboBox<String>)idealForm.lookup("#ageCombo");
        String age = "";
        if(ageCombo.getValue() != null) {
            age = ageCombo.getValue();
        }

        ComboBox<String> drinkCombo = (ComboBox<String>)idealForm.lookup("#drinkCombo");
        String drink = "";
        if(drinkCombo.getValue() != null) {
            drink = drinkCombo.getValue();
        }
		
		GuestDTO dto= new GuestDTO();
		GuestDAO dao = new GuestDAO();
		ArrayList<GuestDTO>list = new ArrayList<GuestDTO>();
		dto.setAge(age);
		dto.setArea(area);
		dto.setBloodType(bloodType);
		dto.setDrink(drink);
		dto.setGender(gender);
		dto.setHeight(height);
		dto.setMbti(mbti);
		dto.setSmoking(smoking);
		if(gender == "남") {
			dao.manInfo(dto, list);		
		}else {
			dao.womanInfo(dto, list);
		}
	
			CommonService.Msg("이상형 선택 완료");
			CommonService.WindowClose(idealForm);;
		}
}
