package loveproject.guest.profile.list;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import loveproject.guest.profile.dao.ProfileDAO;
import loveproject.guest.profile.dto.ProfileDTO;
import loveproject.guest.profile.list.service.ListService;

public class ListController implements Initializable{
	private Parent listForm;
	private ListService listSvc;
	private ProfileDAO dao = new ProfileDAO();
	private ArrayList<ProfileDTO> list = new ArrayList<ProfileDTO>();
	// 로그인된 아이디를 받아오면 "male1" 지울것. ListController 실행시킬 때 로그인한 아이디를 넘겨줘야함
	// setLoginId(String loginid)
	private String loginid;
	
	@FXML
	TableView<TableRowDataModel> table;
	@FXML
	TableColumn<TableRowDataModel, String> tableName;
	@FXML
	TableColumn<TableRowDataModel, String> tableAge;
	@FXML
	TableColumn<TableRowDataModel, String> tableHeight;
	@FXML
	TableColumn<TableRowDataModel, String> tableAddress;

	
	public void setListForm(Parent listForm) {
		this.listForm = listForm;
	}
	public Parent getListForm() {
		return listForm;
	}
	public void setLoginId(String loginid) {
		this.loginid = loginid;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listSvc = new ListService();
		listSvc.setListForm(listForm);
		list = dao.inputInfo(loginid, list);
		
		ObservableList<TableRowDataModel> tableList = FXCollections.observableArrayList();
		for(ProfileDTO dto : list) {
			tableList.add(new TableRowDataModel(dto.getId(), new SimpleStringProperty(dto.getName()), new SimpleStringProperty(dto.getAge()), new SimpleStringProperty(dto.getHeight()), new SimpleStringProperty(dto.getArea())));
		}

		tableName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		tableAge.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
		tableHeight.setCellValueFactory(cellData -> cellData.getValue().heightProperty());
		tableAddress.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
		table.setItems(tableList);
		
		table.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getClickCount() > 1) {
//					System.out.println(table.getSelectionModel().getSelectedItem().getid());
					String id = table.getSelectionModel().getSelectedItem().getid();
					selectOpenForm(loginid, id);
				}
			}
			
		});
	}
	


	public void selectOpenForm(String loginid, String id) {
		listSvc.selectOpenForm(loginid, id);
	}
	public void cancelBtn() {
		listSvc.cancelProc(listForm);
	}
}


