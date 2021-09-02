package loveproject.admin.service;

import javafx.scene.Parent;
import loveproject.admin.dao.AdminMatchingDAO;
import loveproject.commonService.CommonService;


public class MatchingService {
	
	public void MatchingCancle(Parent matchingForm) {
		CommonService.WindowClose(matchingForm);
	}

}
