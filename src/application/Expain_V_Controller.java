package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Expain_V_Controller {
	
	@FXML Label NAME_V;
	@FXML Label PERIOD_V;
	@FXML Label LENGTH_V;
	@FXML Label LATE_V;
	
	@FXML Label name;
	@FXML Label period;
	@FXML Label length;
	@FXML Label late;
	
	@FXML protected void CHECKCHECK(ActionEvent on){  
		CalendarController.no_click=0;
		Stage stage = (Stage) NAME_V.getScene().getWindow();
		stage.close();
	}
	
	@FXML protected void PICKUP(ActionEvent on){  
		if(CalendarController.click_check==2) {
			name.setText("과목 이름");
			period.setText("강의 기한");
			length.setText("강의 길이");
			late.setText("지각 기한");
			
			NAME_V.setText(LodingController.subject_title[CalendarController.check_subject]);
			PERIOD_V.setText(LodingController.subject_videoPeriod[CalendarController.check_subject][CalendarController.check_week][CalendarController.check_count]);
			LENGTH_V.setText(LodingController.subject_videoLength[CalendarController.check_subject][CalendarController.check_week][CalendarController.check_count]);
			LATE_V.setText(LodingController.subject_videoLate[CalendarController.check_subject][CalendarController.check_week][CalendarController.check_count]);
		}
		else if(CalendarController.click_check==3) {
			name.setText("과목 이름");
			period.setText("과제 기한");
			
			NAME_V.setText(LodingController.subject_title[CalendarController.check_subject]);
			PERIOD_V.setText(LodingController.temp_subject_assignmentPeriond[CalendarController.check_subject][CalendarController.check_count]);
		}
		else if(CalendarController.click_check==4) {
			name.setText("과목 이름");
			period.setText("과제 기한");
			
			NAME_V.setText(LodingController.if_notPassed_AssignedSubject[CalendarController.check_subject]);
			PERIOD_V.setText(LodingController.if_notPassed_AssignedDate[CalendarController.check_subject]);
		}
		else if(CalendarController.click_check==5) {
			name.setText("과목 이름");
			period.setText("강의 기한");
			length.setText("강의 길이");
			late.setText("지각 기한");
			
			NAME_V.setText(LodingController.if_notattendent_week_videoSubject[CalendarController.check_subject]);
			PERIOD_V.setText(LodingController.if_notattendent_week_videoDate[CalendarController.check_subject]);
			LENGTH_V.setText(LodingController.if_notattendent_week_videoLength[CalendarController.check_subject]);
			LATE_V.setText(LodingController.if_notattendent_week_videoLate[CalendarController.check_subject]);
		}
	}
}
