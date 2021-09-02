package loveproject.guest.guestmodify;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import loveproject.guest.guestmodify.Service.ModifyService;

public class ModifyController implements Initializable{

	private Parent modifyForm;
	private ModifyService modifySvc;
	public void setModifyForm(Parent modifyForm) {
		this.modifyForm = modifyForm;
	}
	public Parent getModifyForm() {
		return modifyForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		modifySvc = new ModifyService();
		
	}
	
	public void cancelProc() {
		modifySvc.cancelProc(modifyForm);
	}
	public void modifyProc() {
		modifySvc.modifyService(modifyForm);
	}
	
	

}
