package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class NoticeController {
	@FXML TextField WHAT;
	@FXML WebView WEB;
	WebEngine WEB_;
	
	@FXML protected void SEARCH(ActionEvent on){  
		WEB_ = WEB.getEngine();
		WEB_.load("https://scatch.ssu.ac.kr/?s="+WHAT.getText());
	}
	
	@FXML protected void CLOSE(ActionEvent on){  
		Stage stage = (Stage) WEB.getScene().getWindow();
		stage.close();
	}
	
	@FXML protected void DEFUALT(ActionEvent on){  
		WEB_ = WEB.getEngine();
		WEB_.load("https://scatch.ssu.ac.kr/%ea%b3%b5%ec%a7%80%ec%82%ac%ed%95%ad/");
	}
}
