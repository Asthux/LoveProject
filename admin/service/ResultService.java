package loveproject.admin.service;

import javafx.scene.Parent;
import loveproject.admin.dao.AdminDAO;
import loveproject.commonService.CommonService;


public class ResultService {
	
	public void ResultCancle(Parent resultForm) {
		CommonService.WindowClose(resultForm);
	}

}
