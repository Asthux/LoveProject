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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import loveproject.admin.dao.AdminMatchingDAO;
import loveproject.admin.dto.AdminMatchingDTO;
import loveproject.admin.dto.MatchingModel;
import loveproject.admin.service.MatchingService;


public class MatchingContoller implements Initializable{
	@FXML
    private TableView<MatchingModel> matchingList;

    @FXML
    private TableColumn<MatchingModel, String> name1;

    @FXML
    private TableColumn<MatchingModel, String> name2;

    @FXML
    private TableColumn<MatchingModel, String> day;

    @FXML
    private TableColumn<MatchingModel, String> check1;

    
	private Parent matchingForm;
	private MatchingService matchingSvc;
	private AdminMatchingDAO dao = new AdminMatchingDAO();
	private ArrayList<AdminMatchingDTO> list2 = new ArrayList<AdminMatchingDTO>();
	private ObservableList<MatchingModel> tablelist;

	public Parent getMatchingForm() {
		return matchingForm;
	}

	public void setMatchingForm(Parent matchingForm) {
		this.matchingForm = matchingForm;
	}
	
	public void list2seting() {
			tablelist = FXCollections.observableArrayList();// ***** 리스트를 회원DB 전체를 가져와서 만들어지도록
			for(AdminMatchingDTO dto : list2) {
				tablelist.add(new MatchingModel(new SimpleStringProperty(dto.getName1()), new SimpleStringProperty(dto.getName2()), new SimpleStringProperty(dto.getDay()), new SimpleStringProperty(dto.getAccept())));
			}
		
		name1.setCellValueFactory(cellData -> cellData.getValue().getName1());
		name2.setCellValueFactory(cellData -> cellData.getValue().getName2());
		day.setCellValueFactory(cellData -> cellData.getValue().getDay());
		check1.setCellValueFactory(cellData -> cellData.getValue().getaccept());

}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		matchingSvc = new MatchingService();
		
		list2 = dao.matchingresult(dao, list2);
		
		list2seting();
	
		matchingList.setItems(tablelist);
		
	}
	
	public void MatchingCancelProc() {
		matchingSvc.MatchingCancle(matchingForm);
	}


}
