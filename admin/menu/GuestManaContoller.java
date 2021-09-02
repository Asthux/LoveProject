package loveproject.admin.menu;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import loveproject.admin.service.GuestManagementService;


public class GuestManaContoller implements Initializable{    
	@FXML
    private Button reSelect;

    @FXML
    private Button delete;

    @FXML
    private Button cancel;

    private Parent guestManaForm;
    private GuestManagementService guestManaSvc;

    public Parent getGuestManaForm() {
	return guestManaForm;
    }

    public void setGuestManaForm(Parent guestManaForm) {
	this.guestManaForm = guestManaForm;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
	guestManaSvc = new GuestManagementService();
    }

    public void ReSelectProc() {
	guestManaSvc.reSelect(guestManaForm);
	
    }

    public void DeleteProc() {
	guestManaSvc.delete(guestManaForm);
	
    }

    public void GuestManaCancelProc() {
	guestManaSvc.GuestManaCancle(guestManaForm);
    }

}
