package loveproject.admin.menu;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import loveproject.admin.dao.AdminDAO;
import loveproject.admin.service.ResultService;
import loveproject.register.dto.MemberDTO;

public class ResultContoller implements Initializable{
	@FXML private PieChart gender;
	@FXML private BarChart age;
	
	private Parent resultForm;
	private ResultService resultSvc;
	private AdminDAO dao = new AdminDAO();
	private ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
	private int genderMan;
	private int genderWomen;
	private int genderTotal;
	private int Man20;
	private int Man30;
	private int Man40;
	private int Women20;
	private int Women30;
	private int Women40;
	private String data2;
	private int data;
	

	public Parent getResultForm() {
		return resultForm;
	}

	public void setResultForm(Parent resultForm) {
		this.resultForm = resultForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		resultSvc = new ResultService();
		
		list = dao.resultAll(dao, list);
		genderTotal--;
		
		for(MemberDTO dto : list) {
			genderTotal++;
			
			if(dto.getGender().equals("남")) {
				genderMan++;
				data2 = dto.getAge().substring(0, 2);
				int data = Integer.parseInt(data2);
				if(data >19 && data <30) {
					Man20++;
				}else if(data >29 && data <40) {
					Man30++;
				}else {
					Man40++;
				}
			}else if(dto.getGender().equals("여")) {
				genderWomen++;
				data2 = dto.getAge().substring(0, 2);
				int data = Integer.parseInt(data2);
				if(data >19 && data <30) {
					Women20++;
				}else if(data >29 && data <40) {
					Women30++;
				}else {
					Women40++;
				}
			}
		}
		
		
		gender.setData(FXCollections.observableArrayList( 
				new PieChart.Data("남성", (double)genderMan),
				new PieChart.Data("여성", (double)genderWomen)
				));
		
		XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
		series1.setName("남성");									
		series1.setData(FXCollections.observableArrayList(
				new XYChart.Data<String, Integer>("20대", Man20),
				new XYChart.Data<String, Integer>("30대", Man30),
				new XYChart.Data<String, Integer>("40대", Man40)
				));
			
		
		XYChart.Series<String, Integer> series2 = new XYChart.Series<String, Integer>();
		series2.setName("여성");
		series2.setData(FXCollections.observableArrayList(
				new XYChart.Data<String, Integer>("20대", Women20),
				new XYChart.Data<String, Integer>("30대", Women30),
				new XYChart.Data<String, Integer>("40대", Women40)
				));
		
		age.getData().addAll(series1, series2);
		
	}
}
