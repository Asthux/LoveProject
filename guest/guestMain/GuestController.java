package loveproject.guest;


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
import loveproject.guest.dao.GuestDAO;
import loveproject.guest.dto.GuestDTO;
import loveproject.guest.profile.list.TableRowDataModel;
import loveproject.guest.profile.list.service.ListService;
import loveproject.guest.service.GuestService;


public class GuestController implements Initializable{
	private Parent guestMainForm;
	private GuestService guestSvc;
	private ListService listSvc = new ListService();
	@FXML
	TableView<TableRowDataModel> table;
	@FXML
	TableColumn<TableRowDataModel, String> tableName;
	@FXML
	TableColumn<TableRowDataModel, String> tableAge;
	@FXML
	TableColumn<TableRowDataModel, String> tableHeight;
	@FXML
	TableColumn<TableRowDataModel, String> tableArea;
	@FXML 
	Button refreshButton;
	private GuestDAO dao = new GuestDAO();
	private GuestDTO dto = new GuestDTO();
	private ArrayList<GuestDTO>list = new ArrayList<GuestDTO>();
	private ArrayList<GuestDTO>list1 = new ArrayList<GuestDTO>();
	private String loginid;
	private String guestGender;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		guestSvc = new GuestService();

		list = dao.showInfo(dao, list);

		ObservableList<TableRowDataModel> tableList = FXCollections.observableArrayList();
		for (GuestDTO dto : list) {
			tableList.add(new TableRowDataModel(dto.getId(), new SimpleStringProperty(dto.getName()), new SimpleStringProperty(dto.getAge()), new SimpleStringProperty(dto.getHeight()), new SimpleStringProperty(dto.getArea())));
		}

		tableName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		tableAge.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
		tableHeight.setCellValueFactory(cellData -> cellData.getValue().heightProperty());
		tableArea.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
		table.setItems(tableList);

		table.setOnMouseClicked(event -> {
			if (event.getClickCount() > 1) {
//			System.out.println(table.getSelectionModel().getSelectedItem().getid());
				String id = table.getSelectionModel().getSelectedItem().getid();
				selectOpenForm(loginid, id);
			}
		});
	}
	public void idealProc() {
		guestSvc.idealOpenForm();
	}
	public void reviewProc() {
		guestSvc.reviewOpenForm();
	}
	public void logoutProc() {
		guestSvc.cancelProc(guestMainForm);
	}
	public void modifyProc() {
		guestSvc.modifyLoginOpenForm();
	}
	public void refreshProc() {
		if (guestGender.equals("여")) {
			guestSvc = new GuestService();


			list = dao.manInfo(dao, list);

			ObservableList<TableRowDataModel> tableList = FXCollections.observableArrayList();
			for (GuestDTO dto : list) {
				tableList.add(new TableRowDataModel(dto.getId(), new SimpleStringProperty(dto.getName()), new SimpleStringProperty(dto.getAge()), new SimpleStringProperty(dto.getHeight()), new SimpleStringProperty(dto.getArea())));
			}

			tableName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
			tableAge.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
			tableHeight.setCellValueFactory(cellData -> cellData.getValue().heightProperty());
			tableArea.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
			table.setItems(tableList);
		}
		if (guestGender.equals("남")) {
			guestSvc = new GuestService();


			list = dao.womanInfo(dao, list);

			ObservableList<TableRowDataModel> tableList = FXCollections.observableArrayList();
			for (GuestDTO dto : list) {
				tableList.add(new TableRowDataModel(dto.getId(), new SimpleStringProperty(dto.getName()), new SimpleStringProperty(dto.getAge()), new SimpleStringProperty(dto.getHeight()), new SimpleStringProperty(dto.getArea())));
			}

			tableName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
			tableAge.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
			tableHeight.setCellValueFactory(cellData -> cellData.getValue().heightProperty());
			tableArea.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
			table.setItems(tableList);
		}
	}
	public void matchingProc() {
		guestSvc.matchingService(loginid);
	}
	public void selectOpenForm(String loginid, String id) {
		listSvc.selectOpenForm(loginid, id);
	}

	public void setGuestForm(Parent guestMainForm) {this.guestMainForm = guestMainForm; }
	
	public void setLoginId(String loginid) {
		this.loginid = loginid;
	}
}
