package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController {

	@FXML TextField NAME;
	@FXML DatePicker DATE;
	
	@FXML protected void NO(ActionEvent on){  
		Stage stage = (Stage) NAME.getScene().getWindow();
		stage.close();
	}
	@FXML protected void PLUS(ActionEvent on){  
		String month_=null;
		String day_=null;
		
		if(!DATE.getEditor().getText().equals("")) {
			month_=DATE.getEditor().getText().split(" ")[1];
			month_=month_.substring(0,month_.length()-1);
			day_=DATE.getEditor().getText().split(" ")[2];
			day_=day_.substring(0,day_.length()-1);
			CalendarController.date_U[Integer.parseInt(month_)-1][Integer.parseInt(day_)-1+CalendarController.first_day-1][CalendarController.checking[Integer.parseInt(month_)-1][Integer.parseInt(day_)-1+CalendarController.first_day-1]]=NAME.getText();
		}
		CalendarController.checking[Integer.parseInt(month_)-1][Integer.parseInt(day_)-1+CalendarController.first_day-1]++;
		CalendarController.save();
		Stage stage = (Stage) NAME.getScene().getWindow();
		stage.close();
	}

}


