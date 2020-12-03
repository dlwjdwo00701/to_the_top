package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class WarnController implements Initializable{
	@FXML ListView<String> LIST;
	private ObservableList<String> mainlist;  
	
	public void initialize(URL location, ResourceBundle resources) {
		mainlist = FXCollections.observableArrayList();
		mainlist.add("내일까지인 강의와 과제가 있어요!");
		
		int a,b,c;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<16;b++) {
				for(c=0;c<15;c++) {
					if(LodingController.subject_videoPeriod[a][b][c] != null) {
						if(LodingController.month(LodingController.subject_videoPeriod[a][b][c].split("~")[1].trim())==CalendarController.M&&LodingController.date(LodingController.subject_videoPeriod[a][b][c].split("~")[1].trim())==CalendarController.D+1) {
							mainlist.add(LodingController.subject_videoName[a][b][c]);
						}
					}
				}
			}
		}
		System.out.println(CalendarController.M);
		System.out.println(CalendarController.D);
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(LodingController.temp_subject_assignmentPeriond[a][b] != null) {
					if(LodingController.month(LodingController.temp_subject_assignmentPeriond[a][b])==CalendarController.M&&LodingController.date(LodingController.temp_subject_assignmentPeriond[a][b])==CalendarController.D+1) {
						mainlist.add(LodingController.temp_subject_assignmentName[a][b]);
					}
				}
			}
		}
		
		LIST.setItems(mainlist);
	}
	
	@FXML protected void OK(ActionEvent on){  
		Stage stage = (Stage) LIST.getScene().getWindow();
		stage.close();
	}
}
