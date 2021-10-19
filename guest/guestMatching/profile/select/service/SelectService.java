package loveproject.guest.guestMatching.profile.select.service;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import loveproject.commonService.CommonService;
import loveproject.guest.guestMatching.profile.dao.ProfileDAO;
import loveproject.guest.guestMatching.profile.dto.ProfileDTO;

public class SelectService {
	
	// 프로필 정보를 가져오는 기능
		public void getinfoProc(Parent selectForm, String id) {
			
			ProfileDAO dao = new ProfileDAO();
			ProfileDTO dto = dao.selectId(id);
			
			Label name = (Label)selectForm.lookup("#name");
			Label age = (Label)selectForm.lookup("#age");
			Label height = (Label)selectForm.lookup("#height");
			Label address = (Label)selectForm.lookup("#address");
			Label bloodtype = (Label)selectForm.lookup("#bloodtype");
			Label mbti = (Label)selectForm.lookup("#mbti");
			Label drink = (Label)selectForm.lookup("#drink");
			Label smoking = (Label)selectForm.lookup("#smoking");
			Label introduce = (Label)selectForm.lookup("#introduce");
			
			name.setText(dto.getName());
			age.setText(dto.getAge());
			height.setText(dto.getHeight());
			address.setText(dto.getArea());
			bloodtype.setText(dto.getBloodType());
			mbti.setText(dto.getMbti());
			drink.setText(dto.getDrink());
			smoking.setText(dto.getSmoking());
			introduce.setText(dto.getSelfIntro());
		}
		
		// 매칭 요청
		public void matchingProc(String loginid, String id) {
			// matchingDAO로 matchingDB 연결
			// dao.matching() 으로 매칭요청이 있었는지 확인
			ProfileDAO dao = new ProfileDAO();
			CommonService.Msg(dao.matching(loginid, id));
		}
		
		// 매칭 취소를 눌렀을 때의 기능
		public void cencel(String loginid, String id) {
			ProfileDAO dao = new ProfileDAO();
			CommonService.Msg(dao.nomatch(loginid, id));
		}

}
