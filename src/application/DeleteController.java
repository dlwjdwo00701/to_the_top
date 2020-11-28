package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DeleteController {
	@FXML Label TMP;
	
	@FXML protected void NO(ActionEvent on){  
		Stage stage = (Stage) TMP.getScene().getWindow();
		stage.close();
	}
	@FXML protected void DELETE(ActionEvent on){  
		if(CalendarController.click_check==2) {
			LodingController.subject_videoName[CalendarController.check_subject][CalendarController.check_week][CalendarController.check_count]=null;
			LodingController.subject_videoPeriod[CalendarController.check_subject][CalendarController.check_week][CalendarController.check_count]=null;
			LodingController.subject_videoLength[CalendarController.check_subject][CalendarController.check_week][CalendarController.check_count]=null;
			LodingController.subject_videoLate[CalendarController.check_subject][CalendarController.check_week][CalendarController.check_count]=null;
		}
		else if(CalendarController.click_check==3) {
			
			LodingController.temp_subject_assignmentName[CalendarController.check_subject][CalendarController.check_count]=null;
			LodingController.temp_subject_assignmentPeriond[CalendarController.check_subject][CalendarController.check_count]=null;
		}
		else if(CalendarController.click_check==7) {
			CalendarController.date_U[CalendarController.check_subject][CalendarController.check_week][CalendarController.check_count]=null;
		}
		try {
			LodingController.save();
			CalendarController.save();
		} catch(IOException a) {
			
		}
		Stage stage = (Stage) TMP.getScene().getWindow();
		stage.close();
	}
	
}
