package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;



public class LoginController {
	private static Map<String,String> cookies;
	
	@FXML Label explain;
	@FXML TextField ID;
	@FXML TextField PASS;
	
	@FXML protected void LoginButton(ActionEvent on) throws IOException{
		Response loginResponse = (Response)Jsoup.connect("https://myclass.ssu.ac.kr/login/index.php")
				.data("username", ID.getText())
				.data("password" ,PASS.getText())
				.method(Method.POST)
				.execute();
		
		cookies = loginResponse.cookies();
		}
	
	@FXML protected void DeleteButton(ActionEvent on){
		ID.clear();
		PASS.clear();
		}

}

class SmartCampus{
	private static Map<String,String> cookies;
	
	public static void login(String id, String pw) throws IOException{
		Response loginResponse = (Response)Jsoup.connect("https://myclass.ssu.ac.kr/login/index.php")
				.data("username", id)
				.data("password" , pw)
				.method(Method.POST)
				.execute();
		
		cookies = loginResponse.cookies();
	}
}
