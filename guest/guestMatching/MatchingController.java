package loveproject.guest.guestMatching;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import loveproject.guest.guestMatching.service.MatchingService;


public class MatchingController implements Initializable{
	 
	private Parent matchingForm;
	private MatchingService matchingSvc;
	public void setIdealForm(Parent idealForm) {
		this.matchingForm = idealForm;
	}
	public Parent getIdealForm() {
		return matchingForm;
	}
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		matchingSvc = new MatchingService();
	}

	public void cancelProc() {
		matchingSvc.cancelProc(matchingForm);
	}
	public void selectProc() {matchingSvc.selectOpenForm();}
	public void randomSelectProc(){ matchingSvc.randomSelectOpenForm();}
	public void requestProc(){ matchingSvc.requestOpenForm();}

}
