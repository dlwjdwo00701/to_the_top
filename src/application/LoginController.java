package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;

import org.jsoup.*;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

public class LoginController {
	
	protected static int new_check;
	protected static Map<String,String> cookies;
	protected static String ID_;
	
	@FXML Label explain;   //FXML과 매핑시켜줌 
	@FXML TextField ID;
	@FXML TextField PASS;
	
	@FXML protected void LoginButton(ActionEvent on) { //해당 매핑된 버튼이 클릭 되었을때 
		try {
			
			Response loginResponse = (Response)Jsoup.connect("https://myclass.ssu.ac.kr/login/index.php")  //우선적으로는 로그인
					.data("username", ID.getText())
					.data("password" , PASS.getText())
					.method(Method.POST)
					.execute();
				
			cookies = loginResponse.cookies();
				
			Document login_check = Jsoup.connect("http://myclass.ssu.ac.kr/")   //해당 쿠키를 비교해줌
					.cookies(cookies)
					.get();
				
			String log = login_check.toString();   //비교비교
			String check_str =  "아이디 / 비밀번호 찾기";
			int check_str_index = log.indexOf(check_str);
			if(check_str_index == -1)  //맞으면 다음 창으로 씬을 갱신해주어서 넘어가줌
			{
				try{
					File SmartCampas = new File("c://SmartCampas");
					if(!SmartCampas.exists()){
						SmartCampas.mkdirs();
			        }
					File IMP = new File("c://SmartCampas//"+ID.getText());
					if(!IMP.exists()) {
						IMP.mkdirs();
						new_check=1;
					}
					else {
						new_check=0;
					}
					
					ID_=ID.getText();

				    Parent login = FXMLLoader.load(getClass().getResource("Loding.fxml"));
				    Scene scene = new Scene(login);
				    Stage primaryStage = (Stage)PASS.getScene().getWindow(); // 현재 윈도우 가져오기
				    primaryStage.setScene(scene);
				 } catch(Exception e){
					 
				}
			}
			else {
				explain.setLayoutY(180);   //레이블 위치 재조정과 해당 레이블 내용 갱신
				explain.setLayoutX(47);
				explain.setText("아이디와 비밀번호가 틀렸습니다. 확인해주세요.");
			}
			ID.clear();   //틀렸기에 입력되있는 아이디와 비번을 지워줌
			PASS.clear();
			
		}	catch(IOException a) {
			
		}
		}
	
	@FXML protected void DeleteButton(ActionEvent on){  //지우기 버튼을 눌렀을 때 텍스트 필드의 내용을 지워줌
		ID.clear();
		PASS.clear();
		}

}
