package loveproject.admin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import loveproject.admin.service.AdminServiceImpl;

public class AdminContoller implements Initializable{
	private Parent adminForm;
	private AdminServiceImpl adminSvc;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		adminSvc = new AdminServiceImpl();
	}
	
	public void guestProc() {
		adminSvc.guestManagement(adminForm);
	}
	
	public void matchingProc() {
		adminSvc.matchingManagement(adminForm);
	}
	
	public void resultProc() {
		adminSvc.resultManagement(adminForm);
	}
	
	public void cancelProc() {
		adminSvc.cancelProc(adminForm);
	}

	public void setAdminForm(Parent adminForm) {
		this.adminForm = adminForm; 
	}

	public Parent getAdminForm() {
		return adminForm;
	}
	
}
