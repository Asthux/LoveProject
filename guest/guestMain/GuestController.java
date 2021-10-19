package loveproject.guest.guestMain;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import loveproject.guest.guestMatching.profile.list.service.ListService;
import loveproject.guest.guestMain.service.GuestService;

import java.net.URL;
import java.util.ResourceBundle;


public class GuestController implements Initializable {
	private Parent guestMainForm;
	private GuestService guestSvc;
	private ListService listSvc = new ListService();
	private String loginid;
	private String guestGender;


	public void logoutProc() {guestSvc.cancelProc(guestMainForm);}

	public void reviewOpenProc() { guestSvc.reviewOpenForm();}

	public void modifyOpenProc(){ guestSvc.modifyLoginOpenForm();}

	public void matchingOpenProc(){ guestSvc.matchingOpenForm(); }

	public void setLoginId(String loginid) {
		this.loginid = loginid;
	}

    public void setGuestForm(Parent guestMainForm) {this.guestMainForm = guestMainForm;}

	@Override
	public void initialize(URL location, ResourceBundle resources) {guestSvc = new GuestService();}
}
