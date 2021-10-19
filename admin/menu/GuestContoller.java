package loveproject.admin.menu;

import java.net.URL;
import java.util.ArrayList;

import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import loveproject.admin.dao.AdminDAO;
import loveproject.admin.dto.GuestModel;
import loveproject.admin.service.GuestManagementService;
import loveproject.admin.service.GuestService;
import loveproject.commonService.CommonService;
import loveproject.register.dto.MemberDTO;

public class GuestContoller implements Initializable{
	@FXML
    private TableView<GuestModel> guestList;

    @FXML
    private TableColumn<GuestModel, String> name;

    @FXML
    private TableColumn<GuestModel, String> age;

    @FXML
    private TableColumn<GuestModel, String> gender;

    @FXML
    private TableColumn<GuestModel, String> area;

    @FXML
    private TableColumn<GuestModel, String> blackList;
    
    @FXML
    private TableColumn<GuestModel, String> good;
    
    @FXML
    private Button reSelect;

    @FXML
    private Button delete;

    @FXML
    private Button cancel;

private Parent guestForm;
private GuestService guestSvc;
private AdminDAO dao = new AdminDAO();
private ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
private ObservableList<GuestModel> tablelist;

public Parent getGuestForm() {
	return guestForm;
}

public void setGuestForm(Parent guestForm) {
	this.guestForm = guestForm;
}

public void listseting() {
		tablelist = FXCollections.observableArrayList();// ***** 리스트를 회원DB 전체를 가져와서 만들어지도록
		for(MemberDTO dto : list) {
	 tablelist.add(new GuestModel(dto.getId(), new SimpleStringProperty(dto.getName()), new SimpleStringProperty(dto.getAge()), new SimpleStringProperty(dto.getGender()), new SimpleStringProperty(dto.getArea()), new SimpleStringProperty(dto.getBlacklist())));
		}
		
		name.setCellValueFactory(cellData -> cellData.getValue().getName());
		age.setCellValueFactory(cellData -> cellData.getValue().getAge());
		gender.setCellValueFactory(cellData -> cellData.getValue().getGender());
		area.setCellValueFactory(cellData -> cellData.getValue().getArea());
		blackList.setCellValueFactory(cellData -> cellData.getValue().getBlackList());
		good.setCellValueFactory(cellData -> cellData.getValue().getGood());
}


@Override
public void initialize(URL location, ResourceBundle resources) {
	guestSvc = new GuestService();
	list = dao.mainResult(dao, list);
	
	listseting();
	
	guestList.setItems(tablelist);
	
	guestList.setOnMouseClicked(event ->{
		String id = guestList.getSelectionModel().getSelectedItem().getId();
		GuestManagementService ManaSvc = new GuestManagementService();
		ManaSvc.setId(id);
		ManaSvc.guest(guestForm);
		CommonService.WindowClose(guestForm);
	});
	
}


public void GuestCancelProc() {
	guestSvc.GuestCancle(guestForm);
}
	
	

}
