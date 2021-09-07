package loveproject.guest.guestMatching.guestIdeal;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import loveproject.guest.guestMatching.guestIdeal.service.IdealService;


public class IdealController implements Initializable{
	 
	private Parent idealForm;
	private IdealService idealSvc;
	public void setIdealForm(Parent idealForm) {
		this.idealForm = idealForm;
	}
	public Parent getIdealForm() {
		return idealForm;
	}
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		idealSvc = new IdealService();

	}

	public void cancelProc() {
		idealSvc.cancelProc(idealForm);
	}
	public void selectProc() {
		idealSvc.selectProc(idealForm);
	}

}
