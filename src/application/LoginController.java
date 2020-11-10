package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Map;



public class LoginController {
	private static Map<String,String> cookies;
	
	@FXML Label explain;
	@FXML TextField ID;
	@FXML TextField PASS;
	
	@FXML protected void LoginButton(ActionEvent on) {
		
		}
	
	@FXML protected void DeleteButton(ActionEvent on){
		ID.clear();
		PASS.clear();
		}

}
