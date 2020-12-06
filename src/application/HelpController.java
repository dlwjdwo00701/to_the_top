package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelpController {
	@FXML TextField PASS;
	
	@FXML protected void NO(ActionEvent on){  
		Stage stage = (Stage) PASS.getScene().getWindow();
		stage.close();
	}
	
	@FXML protected void WHY(ActionEvent on){  
		try { 
			Desktop.getDesktop().browse(new URI("https://github.com/dlwjdwo00701/to_the_top"));
			  } catch (IOException e1) { 
			   
			  } catch (URISyntaxException e1) { 
			  
			  }
	}
	
	@FXML protected void DEL(ActionEvent on){  
		String tmp=PASS.getText();
		String path="c://SmartCampas";
		if(tmp.equals(LoginController.PASS_)) {
			deleteFile(path);
			CalendarController.del=1;
			Stage stage = (Stage) PASS.getScene().getWindow();
			stage.close();
		}
		else {
			PASS.clear();
		}
	}
	
	public static void deleteFile(String path) {
		File deleteFolder = new File(path);

		if(deleteFolder.exists()){
			File[] deleteFolderList = deleteFolder.listFiles();
			
			for (int i = 0; i < deleteFolderList.length; i++) {
				if(deleteFolderList[i].isFile()) {
					deleteFolderList[i].delete();
				}else {
					deleteFile(deleteFolderList[i].getPath());
				}
				deleteFolderList[i].delete(); 
			}
			deleteFolder.delete();
		}
	}
}
