package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static application.LoginController.ID_;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CalendarController {
	
	@FXML Label LABEL1;
	@FXML Label LABEL2;
	@FXML Label LABEL3;
	@FXML Label LABEL4;
	@FXML Label LABEL5;
	@FXML Label LABEL6;
	@FXML Label LABEL7;
	@FXML Label LABEL8;
	@FXML Label LABEL9;
	@FXML Label LABEL10;
	@FXML Label LABEL11;
	@FXML Label LABEL12;
	@FXML Label LABEL13;
	@FXML Label LABEL14;
	@FXML Label LABEL15;
	@FXML Label LABEL16;
	@FXML Label LABEL17;
	@FXML Label LABEL18;
	@FXML Label LABEL19;
	@FXML Label LABEL20;
	@FXML Label LABEL21;
	@FXML Label LABEL22;
	@FXML Label LABEL23;
	@FXML Label LABEL24;
	@FXML Label LABEL25;
	@FXML Label LABEL26;
	@FXML Label LABEL27;
	@FXML Label LABEL28;
	@FXML Label LABEL29;
	@FXML Label LABEL30;
	@FXML Label LABEL31;
	@FXML Label LABEL32;
	@FXML Label LABEL33;
	@FXML Label LABEL34;
	@FXML Label LABEL35;
	@FXML Label LABEL36;
	@FXML Label LABEL37;
	
	@FXML Button BUTTON1_;
	@FXML Button BUTTON2_;
	@FXML Button BUTTON3_;
	@FXML Button BUTTON4_;
	@FXML Button BUTTON5_;
	@FXML Button BUTTON6_;
	@FXML Button BUTTON7_;
	@FXML Button BUTTON8_;
	@FXML Button BUTTON9_;
	@FXML Button BUTTON10_;
	@FXML Button BUTTON11_;
	@FXML Button BUTTON12_;
	@FXML Button BUTTON13_;
	@FXML Button BUTTON14_;
	@FXML Button BUTTON15_;
	@FXML Button BUTTON16_;
	@FXML Button BUTTON17_;
	@FXML Button BUTTON18_;
	@FXML Button BUTTON19_;
	@FXML Button BUTTON20_;
	@FXML Button BUTTON21_;
	@FXML Button BUTTON22_;
	@FXML Button BUTTON23_;
	@FXML Button BUTTON24_;
	@FXML Button BUTTON25_;
	@FXML Button BUTTON26_;
	@FXML Button BUTTON27_;
	@FXML Button BUTTON28_;
	@FXML Button BUTTON29_;
	@FXML Button BUTTON30_;
	@FXML Button BUTTON31_;
	@FXML Button BUTTON32_;
	@FXML Button BUTTON33_;
	@FXML Button BUTTON34_;
	@FXML Button BUTTON35_;
	@FXML Button BUTTON36_;
	@FXML Button BUTTON37_;
	
	@FXML Label EXPLAIN;
	@FXML Label MONTH;
	@FXML ListView<String> MAINLIST;
	
	int M=0;
	static int page=0;
	
	static int check_subject=0;
	static int check_week=0;
	static int check_count=0;
	
	static int this_date=-1;
	
	static File DATE_U = new File("c://SmartCampas//"+ID_+"//date_u.txt");
	
	protected static String[][][] videoP = new String [LodingController.count][15][15];
	protected static String[][] assP = new String [LodingController.count][40];
	
	protected static String[][][][] date_V = new String [12][37][LodingController.count][40];
	protected static String[][][][] date_A = new String [12][37][LodingController.count][40];
	protected static String[][][] date_U = new String [12][37][40];
	
	protected static int[][] checking = new int [12][37];
	
	@FXML protected void LOAD(ActionEvent on){  
		if(page==0) {
			if(DATE_U.exists()) {
				load();
			}
			M=month(LodingController.current_time);
			MONTH.setText(Integer.toString(M)+"월");
			
			EXPLAIN.setText("");
			
			setting();
			
			
			int a, b, c,d=0;
			
			for(a=0;a<12;a++) {
				for(b=0;b<37;b++) {
					for(c=0;c<LodingController.count;c++) {
						for(d=0;d<40;d++) {
							date_V[a][b][c][d]=null;
							date_A[a][b][c][d]=null;
						}
					}
				}
			}
			d=0;
			for(a=0;a<LodingController.count;a++) {
				for(b=0;b<15;b++) {
					for(c=0;c<15;c++) {
						if(LodingController.subject_videoPeriod[a][b][c] != null) {
							videoP[a][b][c]=LodingController.subject_videoPeriod[a][b][c].split("~")[1].trim();
							date_V[month(videoP[a][b][c])-1][date(videoP[a][b][c])-1+first_day-1][a][d]=LodingController.subject_videoName[a][b][c];
							d++;
						}
					}
					d=0;
				}
			}
			
			for(a=0;a<LodingController.count;a++) {
				for(b=0;b<40;b++) {
					if(LodingController.temp_subject_assignmentPeriond[a][b] != null) {
						assP[a][b]=LodingController.temp_subject_assignmentPeriond[a][b];
						date_A[month(assP[a][b])-1][date(assP[a][b])-1+first_day-1][a][d]=LodingController.temp_subject_assignmentName[a][b];
						d++;
					}
				}
				d=0;
			}
			
			resetting_L();
			
			mainlist = FXCollections.observableArrayList();
			
			for(a=0;a<LodingController.count;a++) {
				mainlist.add(Integer.toString(a+1)+" "+LodingController.subject_title[a]);
			}
			
			MAINLIST.setItems(mainlist);
			page++;
			this_date=-1;
		}
		
	}
	
	static void save() {
		try {
			FileWriter DATE_U_= new FileWriter(DATE_U);
			int a,b,c;
			for(a=0;a<12;a++) {
				for(b=0;b<37;b++) {
					for(c=0;c<40;c++) {
						DATE_U_.write(date_U[a][b][c]+"\n");
						DATE_U_.flush();
					}
				}
			}
			DATE_U_.close();
		} catch(IOException a) {
		}
		
	}
	
	void load() {
		try {
			FileReader DATE_U_ = new FileReader(DATE_U);
			BufferedReader DATE_U__ = new BufferedReader(DATE_U_);
			
			int a,b,c;
			int tmp=0;
			for(a=0;a<12;a++) {
				for(b=0;b<37;b++) {
					for(c=0;c<40;c++) {
						date_U[a][b][c]=DATE_U__.readLine();
						if(date_U[a][b][c].equals("null")) {
							date_U[a][b][c]=null;
							if(tmp==0) {
								checking[a][b]=c;
								tmp++;
							}
						}
					}
					if(tmp==0) {
						checking[a][b]=0;
					}
					tmp=0;
				}
			}
			DATE_U_.close();
		} catch(IOException a) {
		}
	}
	
	void setting() {
		String a = getDayName(M,1);
		switch(a) {
		case "SUN":
			first_day=1;
			BUTTON1_.setText("1");
			
			BUTTON32_.setDisable(true);
			BUTTON32_.setVisible(false);
			LABEL32.setVisible(false);
			BUTTON33_.setDisable(true);
			BUTTON33_.setVisible(false);
			LABEL33.setVisible(false);
			BUTTON34_.setDisable(true);
			BUTTON34_.setVisible(false);
			LABEL34.setVisible(false);
			BUTTON35_.setDisable(true);
			BUTTON35_.setVisible(false);
			LABEL35.setVisible(false);
			BUTTON36_.setDisable(true);
			BUTTON36_.setVisible(false);
			LABEL36.setVisible(false);
			BUTTON37_.setDisable(true);
			BUTTON37_.setVisible(false);
			LABEL37.setVisible(false);
			
			if(month_day[M-1]==29) {
				resetting_B(1);
				BUTTON30_.setDisable(true);
				BUTTON30_.setVisible(false);
				LABEL30.setVisible(false);
				BUTTON31_.setDisable(true);
				BUTTON31_.setVisible(false);
				LABEL31.setVisible(false);
			}
			else if(month_day[M-1]==30) {
				resetting_B(first_day);
				BUTTON31_.setDisable(true);
				BUTTON31_.setVisible(false);
				LABEL31.setVisible(false);
			}
			else {
				resetting_B(first_day);
			}
			break;
		case "MON":
			first_day=2;
			BUTTON1_.setDisable(true);
			BUTTON1_.setVisible(false);
			LABEL1.setVisible(false);
			
			BUTTON2_.setText("1");
			
			BUTTON33_.setDisable(true);
			BUTTON33_.setVisible(false);
			LABEL33.setVisible(false);
			BUTTON34_.setDisable(true);
			BUTTON34_.setVisible(false);
			LABEL34.setVisible(false);
			BUTTON35_.setDisable(true);
			BUTTON35_.setVisible(false);
			LABEL35.setVisible(false);
			BUTTON36_.setDisable(true);
			BUTTON36_.setVisible(false);
			LABEL36.setVisible(false);
			BUTTON37_.setDisable(true);
			BUTTON37_.setVisible(false);
			LABEL37.setVisible(false);
			
			if(month_day[M-1]==29) {
				resetting_B(first_day);
				BUTTON31_.setDisable(true);
				BUTTON31_.setVisible(false);
				LABEL31.setVisible(false);
				BUTTON32_.setDisable(true);
				BUTTON32_.setVisible(false);
				LABEL32.setVisible(false);
			}
			else if(month_day[M-1]==30) {
				resetting_B(first_day);
				BUTTON32_.setDisable(true);
				BUTTON32_.setVisible(false);
				LABEL32.setVisible(false);
			}
			else {
				resetting_B(first_day);
			}
			break;
		case "TUE":
			first_day=3;
			BUTTON1_.setDisable(true);
			BUTTON1_.setVisible(false);
			LABEL1.setVisible(false);
			BUTTON2_.setDisable(true);
			BUTTON2_.setVisible(false);
			LABEL2.setVisible(false);
			
			BUTTON3_.setText("1");
			
			BUTTON34_.setDisable(true);
			BUTTON34_.setVisible(false);
			LABEL34.setVisible(false);
			BUTTON35_.setDisable(true);
			BUTTON35_.setVisible(false);
			LABEL35.setVisible(false);
			BUTTON36_.setDisable(true);
			BUTTON36_.setVisible(false);
			LABEL36.setVisible(false);
			BUTTON37_.setDisable(true);
			BUTTON37_.setVisible(false);
			LABEL37.setVisible(false);
			
			if(month_day[M-1]==29) {
				resetting_B(first_day);
				BUTTON32_.setDisable(true);
				BUTTON32_.setVisible(false);
				LABEL32.setVisible(false);
				BUTTON33_.setDisable(true);
				BUTTON33_.setVisible(false);
				LABEL33.setVisible(false);
			}
			else if(month_day[M-1]==30) {
				resetting_B(first_day);
				BUTTON33_.setDisable(true);
				BUTTON33_.setVisible(false);
				LABEL33.setVisible(false);
			}
			else {
				resetting_B(first_day);
			}
			break;
		case "WED":
			first_day=4;
			BUTTON1_.setDisable(true);
			BUTTON1_.setVisible(false);
			LABEL1.setVisible(false);
			BUTTON2_.setDisable(true);
			BUTTON2_.setVisible(false);
			LABEL2.setVisible(false);
			BUTTON3_.setDisable(true);
			BUTTON3_.setVisible(false);
			LABEL3.setVisible(false);
			
			BUTTON4_.setText("1");
			
			BUTTON35_.setDisable(true);
			BUTTON35_.setVisible(false);
			LABEL35.setVisible(false);
			BUTTON36_.setDisable(true);
			BUTTON36_.setVisible(false);
			LABEL36.setVisible(false);
			BUTTON37_.setDisable(true);
			BUTTON37_.setVisible(false);
			LABEL37.setVisible(false);
			
			if(month_day[M-1]==29) {
				resetting_B(first_day);
				BUTTON33_.setDisable(true);
				BUTTON33_.setVisible(false);
				LABEL33.setVisible(false);
				BUTTON34_.setDisable(true);
				BUTTON34_.setVisible(false);
				LABEL34.setVisible(false);
			}
			else if(month_day[M-1]==30) {
				resetting_B(first_day);
				BUTTON34_.setDisable(true);
				BUTTON34_.setVisible(false);
				LABEL34.setVisible(false);
			}
			else {
				resetting_B(first_day);
			}
			break;
		case "THU":
			first_day=5;
			BUTTON1_.setDisable(true);
			BUTTON1_.setVisible(false);
			LABEL1.setVisible(false);
			BUTTON2_.setDisable(true);
			BUTTON2_.setVisible(false);
			LABEL2.setVisible(false);
			BUTTON3_.setDisable(true);
			BUTTON3_.setVisible(false);
			LABEL3.setVisible(false);
			BUTTON4_.setDisable(true);
			BUTTON4_.setVisible(false);
			LABEL4.setVisible(false);
			
			BUTTON5_.setText("1");
			
			BUTTON36_.setDisable(true);
			BUTTON36_.setVisible(false);
			LABEL36.setVisible(false);
			BUTTON37_.setDisable(true);
			BUTTON37_.setVisible(false);
			LABEL37.setVisible(false);
			
			if(month_day[M-1]==29) {
				resetting_B(first_day);
				BUTTON34_.setDisable(true);
				BUTTON34_.setVisible(false);
				LABEL34.setVisible(false);
				BUTTON35_.setDisable(true);
				BUTTON35_.setVisible(false);
				LABEL35.setVisible(false);
			}
			else if(month_day[M-1]==30) {
				resetting_B(first_day);
				BUTTON35_.setDisable(true);
				BUTTON35_.setVisible(false);
				LABEL35.setVisible(false);
			}
			else {
				resetting_B(first_day);
			}
			break;
		case "FRI":
			first_day=6;
			BUTTON1_.setDisable(true);
			BUTTON1_.setVisible(false);
			LABEL1.setVisible(false);
			BUTTON2_.setDisable(true);
			BUTTON2_.setVisible(false);
			LABEL2.setVisible(false);
			BUTTON3_.setDisable(true);
			BUTTON3_.setVisible(false);
			LABEL3.setVisible(false);
			BUTTON4_.setDisable(true);
			BUTTON4_.setVisible(false);
			LABEL4.setVisible(false);
			BUTTON5_.setDisable(true);
			BUTTON5_.setVisible(false);
			LABEL5.setVisible(false);
			
			BUTTON6_.setText("1");
			
			BUTTON37_.setDisable(true);
			BUTTON37_.setVisible(false);
			LABEL37.setVisible(false);
			
			if(month_day[M-1]==29) {
				resetting_B(first_day);
				BUTTON35_.setDisable(true);
				BUTTON35_.setVisible(false);
				LABEL35.setVisible(false);
				BUTTON36_.setDisable(true);
				BUTTON36_.setVisible(false);
				LABEL36.setVisible(false);
			}
			else if(month_day[M-1]==30) {
				resetting_B(first_day);
				BUTTON36_.setDisable(true);
				BUTTON36_.setVisible(false);
				LABEL36.setVisible(false);
			}
			else {
				resetting_B(first_day);
			}
			break;
		case "SAT":
			first_day=7;
			BUTTON1_.setDisable(true);
			BUTTON1_.setVisible(false);
			LABEL1.setVisible(false);
			BUTTON2_.setDisable(true);
			BUTTON2_.setVisible(false);
			LABEL2.setVisible(false);
			BUTTON3_.setDisable(true);
			BUTTON3_.setVisible(false);
			LABEL3.setVisible(false);
			BUTTON4_.setDisable(true);
			BUTTON4_.setVisible(false);
			LABEL4.setVisible(false);
			BUTTON5_.setDisable(true);
			BUTTON5_.setVisible(false);
			LABEL5.setVisible(false);
			BUTTON6_.setDisable(true);
			BUTTON6_.setVisible(false);
			LABEL6.setVisible(false);
			
			BUTTON7_.setText("1");
			
			if(month_day[M-1]==29) {
				resetting_B(first_day);
				BUTTON36_.setDisable(true);
				BUTTON36_.setVisible(false);
				LABEL36.setVisible(false);
				BUTTON37_.setDisable(true);
				BUTTON37_.setVisible(false);
				LABEL37.setVisible(false);
			}
			else if(month_day[M-1]==30) {
				resetting_B(first_day);
				BUTTON37_.setDisable(true);
				BUTTON37_.setVisible(false);
				LABEL37.setVisible(false);
			}
			else {
				resetting_B(first_day);
			}
			break;
		}	
	}
	
	String str_day[] = {"WED", "THU", "FRI", "SAT", "SUN", "MON", "TUE"};
	int month_day[] = { 31,29,31,30,31,30,31,31,30,31,30,31 };
	 
	String getDayName(int month, int day)
	{
		  String week_day = "";
		    int total_day = 0;
		    
		    for (int i=0;i<month-1;i++) {
		    	total_day += month_day[i];
		    }
		    
		    total_day += day - 1;
		    week_day = str_day[total_day%7];
		    
		    return week_day;
	}
	
	protected static int first_day;
	
	public void resetting_B(int firstday) {
		BUTTON2_.setText(Integer.toString(3-firstday));
		BUTTON3_.setText(Integer.toString(4-firstday));
		BUTTON4_.setText(Integer.toString(5-firstday));
		BUTTON5_.setText(Integer.toString(6-firstday));
		BUTTON6_.setText(Integer.toString(7-firstday));
		BUTTON7_.setText(Integer.toString(8-firstday));
		BUTTON8_.setText(Integer.toString(9-firstday));
		BUTTON9_.setText(Integer.toString(10-firstday));
		BUTTON10_.setText(Integer.toString(11-firstday));
		BUTTON11_.setText(Integer.toString(12-firstday));
		BUTTON12_.setText(Integer.toString(13-firstday));
		BUTTON13_.setText(Integer.toString(14-firstday));
		BUTTON14_.setText(Integer.toString(15-firstday));
		BUTTON15_.setText(Integer.toString(16-firstday));
		BUTTON16_.setText(Integer.toString(17-firstday));
		BUTTON17_.setText(Integer.toString(18-firstday));
		BUTTON18_.setText(Integer.toString(19-firstday));
		BUTTON19_.setText(Integer.toString(20-firstday));
		BUTTON20_.setText(Integer.toString(21-firstday));
		BUTTON21_.setText(Integer.toString(22-firstday));
		BUTTON22_.setText(Integer.toString(23-firstday));
		BUTTON23_.setText(Integer.toString(24-firstday));
		BUTTON24_.setText(Integer.toString(25-firstday));
		BUTTON25_.setText(Integer.toString(26-firstday));
		BUTTON26_.setText(Integer.toString(27-firstday));
		BUTTON27_.setText(Integer.toString(28-firstday));
		BUTTON28_.setText(Integer.toString(29-firstday));
		BUTTON29_.setText(Integer.toString(30-firstday));
		BUTTON30_.setText(Integer.toString(31-firstday));
		BUTTON31_.setText(Integer.toString(32-firstday));
		BUTTON32_.setText(Integer.toString(33-firstday));
		BUTTON33_.setText(Integer.toString(34-firstday));
		BUTTON34_.setText(Integer.toString(35-firstday));
		BUTTON35_.setText(Integer.toString(36-firstday));
		BUTTON36_.setText(Integer.toString(37-firstday));
		BUTTON37_.setText(Integer.toString(38-firstday));
	}
	
	public String is_here(int month, int date) {
		String tmp="";
		int a,b,c=0;
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date-first_day>=0) {
					if(date_V[month-1][date-first_day][a][b]!=null||date_A[month-1][date-first_day][a][b]!=null) {
						c++;
					}
				}
				if(c==1) {
					c++;
					tmp=tmp+Integer.toString(a+1);
				}
			}
			c=0;
		}
		for(a=0;a<40;a++) {
			if(date-first_day>=0) {
				if(date_U[month-1][date-first_day][a]!=null) {
					tmp=tmp+"*";
				}
			}
		}
		
		return tmp;
	}
	
	public void resetting_L() {
		String tmp;
		
		tmp=is_here(M,1);
		LABEL1.setText(tmp);
		tmp=is_here(M,2);
		LABEL2.setText(tmp);
		tmp=is_here(M,3);
		LABEL3.setText(tmp);
		tmp=is_here(M,4);
		LABEL4.setText(tmp);
		tmp=is_here(M,5);
		LABEL5.setText(tmp);
		tmp=is_here(M,6);
		LABEL6.setText(tmp);
		tmp=is_here(M,7);
		LABEL7.setText(tmp);
		tmp=is_here(M,8);
		LABEL8.setText(tmp);
		tmp=is_here(M,9);
		LABEL9.setText(tmp);
		tmp=is_here(M,10);
		LABEL10.setText(tmp);
		tmp=is_here(M,11);
		LABEL11.setText(tmp);
		tmp=is_here(M,12);
		LABEL12.setText(tmp);
		tmp=is_here(M,13);
		LABEL13.setText(tmp);
		tmp=is_here(M,14);
		LABEL14.setText(tmp);
		tmp=is_here(M,15);
		LABEL15.setText(tmp);
		tmp=is_here(M,16);
		LABEL16.setText(tmp);
		tmp=is_here(M,17);
		LABEL17.setText(tmp);
		tmp=is_here(M,18);
		LABEL18.setText(tmp);
		tmp=is_here(M,19);
		LABEL19.setText(tmp);
		tmp=is_here(M,20);
		LABEL20.setText(tmp);
		tmp=is_here(M,21);
		LABEL21.setText(tmp);
		tmp=is_here(M,22);
		LABEL22.setText(tmp);
		tmp=is_here(M,23);
		LABEL23.setText(tmp);
		tmp=is_here(M,24);
		LABEL24.setText(tmp);
		tmp=is_here(M,25);
		LABEL25.setText(tmp);
		tmp=is_here(M,26);
		LABEL26.setText(tmp);
		tmp=is_here(M,27);
		LABEL27.setText(tmp);
		tmp=is_here(M,28);
		LABEL28.setText(tmp);
		tmp=is_here(M,29);
		LABEL29.setText(tmp);
		tmp=is_here(M,30);
		LABEL30.setText(tmp);
		tmp=is_here(M,31);
		LABEL31.setText(tmp);
		tmp=is_here(M,32);
		LABEL32.setText(tmp);
		tmp=is_here(M,33);
		LABEL33.setText(tmp);
		tmp=is_here(M,34);
		LABEL34.setText(tmp);
		tmp=is_here(M,35);
		LABEL35.setText(tmp);
		tmp=is_here(M,36);
		LABEL36.setText(tmp);
		tmp=is_here(M,37);
		LABEL37.setText(tmp);
	}
	
	public void all_see() {
		BUTTON1_.setDisable(false);
		BUTTON1_.setVisible(true);
		LABEL1.setVisible(true);
		
		BUTTON2_.setDisable(false);
		BUTTON2_.setVisible(true);
		LABEL2.setVisible(true);
		
		BUTTON3_.setDisable(false);
		BUTTON3_.setVisible(true);
		LABEL3.setVisible(true);
		
		BUTTON4_.setDisable(false);
		BUTTON4_.setVisible(true);
		LABEL4.setVisible(true);
		
		BUTTON5_.setDisable(false);
		BUTTON5_.setVisible(true);
		LABEL5.setVisible(true);
		
		BUTTON6_.setDisable(false);
		BUTTON6_.setVisible(true);
		LABEL6.setVisible(true);
		
		BUTTON31_.setDisable(false);
		BUTTON31_.setVisible(true);
		LABEL31.setVisible(true);
		
		BUTTON32_.setDisable(false);
		BUTTON32_.setVisible(true);
		LABEL32.setVisible(true);
		
		BUTTON33_.setDisable(false);
		BUTTON33_.setVisible(true);
		LABEL33.setVisible(true);
		
		BUTTON34_.setDisable(false);
		BUTTON34_.setVisible(true);
		LABEL34.setVisible(true);
		
		BUTTON35_.setDisable(false);
		BUTTON35_.setVisible(true);
		LABEL35.setVisible(true);
		
		BUTTON36_.setDisable(false);
		BUTTON36_.setVisible(true);
		LABEL36.setVisible(true);
		
		BUTTON37_.setDisable(false);
		BUTTON37_.setVisible(true);
		LABEL37.setVisible(true);
	}
	
	public static int year(String time_obj)
	{
		int year = Integer.parseInt(time_obj.split(" ")[0].split("-")[0]);
		return year;
	}
	
	public static int month(String time_obj)
	{
		int year = Integer.parseInt(time_obj.split(" ")[0].split("-")[1]);
		return year;
	}
	public static int date(String time_obj)
	{
		int year = Integer.parseInt(time_obj.split(" ")[0].split("-")[2]);
		return year;
	}
	public static int hour(String time_obj)
	{
		int year = Integer.parseInt(time_obj.split(" ")[1].split(":")[0]);
		return year;
	}
	public static int minute(String time_obj)
	{
		int year = Integer.parseInt(time_obj.split(" ")[1].split(":")[1]);
		return year;
	}
	public static int second(String time_obj)
	{
		int year = Integer.parseInt(time_obj.split(" ")[1].split(":")[2]);
		return year;
	}
	
	@FXML protected void RELOAD(ActionEvent on){  
		try {
			if(page>0) {
				Parent add = FXMLLoader.load(getClass().getResource("Loding.fxml"));
			    Scene scene = new Scene(add);
			    Stage plus = new  Stage(); // 현재 윈도우 가져오기
			    plus.getIcons().add(new Image("file:resources/icon/app.png"));
			    plus.setTitle("과탑을 향해서");
			    plus.setScene(scene);
			    plus.show();
			    EXPLAIN.setText("재갱신시 불러오기 버튼을 꼭 눌러주세요!");
			}
		    
		} catch(IOException a) {
			
		}
	}
	
	@FXML protected void PLUS(ActionEvent on){  
		try {
			if(page>0) {
				Parent add = FXMLLoader.load(getClass().getResource("Add.fxml"));
			    Scene scene = new Scene(add);
			    Stage plus = new  Stage(); // 현재 윈도우 가져오기
			    plus.getIcons().add(new Image("file:resources/icon/app.png"));
			    plus.setTitle("과탑을 향해서");
			    plus.setScene(scene);
			    plus.show();
			    page=0;
			    EXPLAIN.setText("추가시 불러오기 버튼을 꼭 눌러주세요!");
			}
		    
		} catch(IOException a) {
			
		}
		
	}
	
	int okok=0;
	@FXML protected void DELETE(ActionEvent on){  
		int a,b,c;
		
		if(page>0) {
			if(this_date!=-1) {
				for(a=0;a<12;a++) {
					for(b=0;b<37;b++) {
						for(c=0;c<40;c++) {
							if(date_U[a][b][c]!=null) {
								if(date_U[a][b][c].equals(MAINLIST.getSelectionModel().getSelectedItem().toString().replaceAll(">", ""))) {
									check_subject=a;
									check_week=b;
									check_count=c;
									click_check=7;
									okok++;
								}
							}
						}
					}
				}
				for(b=0;b<15;b++) {
					if(okok!=0) {
						break;
					}
					for(c=0;c<15;c++) {
						if(LodingController.subject_videoName[Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1][b][c]!=null) {
							if(LodingController.subject_videoName[Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1][b][c].equals(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[1])) {
								if(Integer.toString(date(LodingController.subject_videoPeriod[Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1][b][c].split("~")[1].trim())).equals(Integer.toString(this_date-first_day+2))) {
									check_subject=Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1;
									check_week=b;
									check_count=c;
									click_check=2;
								}
							}
						}
					}
				}
				for(a=0;a<40;a++) {
					if(okok!=0) {
						break;
					}
					if(LodingController.temp_subject_assignmentName[Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1][a]!=null) {
						if(LodingController.temp_subject_assignmentName[Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1][a].equals(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[1])) {
							if(Integer.toString(date(LodingController.temp_subject_assignmentPeriond[Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1][a].trim())).equals(Integer.toString(this_date-first_day+2))) {
								check_subject=Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1;
								check_count=a;
								click_check=3;
							}
						}
					}
				}
				okok=0;
				
				EXPLAIN.setText("삭제시 불러오기를 꼭 눌러주세요");
				page=0;
				try {
					Parent add = FXMLLoader.load(getClass().getResource("Delete.fxml"));
				    Scene scene = new Scene(add);
				    Stage plus = new  Stage(); 
				    plus.getIcons().add(new Image("file:resources/icon/app.png"));
			        plus.setTitle("과탑을 향해서");
				    plus.setScene(scene);
				    plus.show();
				} catch(IOException n) {
					
				}
				
			}
		}
	}
	@FXML protected void _MONTRH(ActionEvent on){  
		if(M==1){
			EXPLAIN.setText("1월이 끝입니다..!");
		}
		else {
			if(page>0) {
				EXPLAIN.setText("");
				all_see();
				M--;
				MONTH.setText(Integer.toString(M)+"월");
				setting();
				
				int a;
				
				resetting_L();
				
				mainlist = FXCollections.observableArrayList();
				
				for(a=0;a<LodingController.count;a++) {
					mainlist.add(Integer.toString(a+1)+" "+LodingController.subject_title[a]);
				}
				
				MAINLIST.setItems(mainlist);
				page++;
			}
		}
	}
	@FXML protected void MONTH_(ActionEvent on){
		if(M==12){
			EXPLAIN.setText("12월이 끝입니다..!");
		}
		else {
			if(page>0) {
				EXPLAIN.setText("");
				all_see();
				M++;
				MONTH.setText(Integer.toString(M)+"월");
				
				setting();
				
				int a;
				
				resetting_L();
				
				mainlist = FXCollections.observableArrayList();
				
				for(a=0;a<LodingController.count;a++) {
					mainlist.add(Integer.toString(a+1)+" "+LodingController.subject_title[a]);
				}
				
				MAINLIST.setItems(mainlist);
				page++;
			}
		}
}
	@FXML protected void checkA(ActionEvent on){  
		if(page>0) {
			int a,b,tmp=0;
			
			resetting_L();
			
			mainlist = FXCollections.observableArrayList();
			mainlist.add("요번주에 아직 제출하지 못한 과제");
			
			for(a=0;a<LodingController.if_notPassed_AssignedName.length;a++) {
				if(LodingController.if_notPassed_AssignedName[a]!=null) {
					for(b=0;b<LodingController.count;b++) {
						if(LodingController.subject_title[b].equals(LodingController.if_notPassed_AssignedSubject[a])) {
							tmp=b;
						}
					}
					mainlist.add(Integer.toString(tmp+1)+">"+LodingController.if_notPassed_AssignedName[a]);
				}
			}
			
			MAINLIST.setItems(mainlist);
		}
	}
	@FXML protected void checkV(ActionEvent on){  
		if(page>0) {
			int a,b,tmp=0;
			
			resetting_L();
			
			mainlist = FXCollections.observableArrayList();
			mainlist.add("요번주에 아직 수강하지 못한 강의");
			
			for(a=0;a<LodingController.if_notattendent_week_videoName.length;a++) {
				if(LodingController.if_notattendent_week_videoName[a]!=null) {
					for(b=0;b<LodingController.count;b++) {
						if(LodingController.subject_title[b].equals(LodingController.if_notattendent_week_videoSubject[a])) {
							tmp=b;
						}
					}
					mainlist.add(Integer.toString(tmp+1)+">"+LodingController.if_notattendent_week_videoName[a]);
				}
			}
			
			MAINLIST.setItems(mainlist);
		}
	}
	
	static int no_click=0;
	static int click_check=0;
	
	@FXML protected void CLICK(MouseEvent event){  
		try {
			if(no_click==0) {
				int a,b,c;
				for(b=0;b<LodingController.if_notPassed_AssignedDate.length;b++) {
						if(LodingController.if_notPassed_AssignedName[b]!=null) {
							if(LodingController.if_notPassed_AssignedName[b].equals(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[1])) {
								check_subject=b;
								click_check=4;
							}
						}
				}
				for(b=0;b<LodingController.if_notattendent_week_videoDate.length;b++) {
					if(no_click!=0) {
						break;
					}
					if(LodingController.if_notattendent_week_videoName[b]!=null) {
						if(LodingController.if_notattendent_week_videoName[b].equals(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[1])) {
							check_subject=b;
							click_check=5;
						}
					}
				}
				for(b=0;b<15;b++) {
					if(no_click!=0) {
						break;
					}
					for(c=0;c<15;c++) {
						if(LodingController.subject_videoName[Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1][b][c]!=null) {
							if(LodingController.subject_videoName[Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1][b][c].equals(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[1])) {
								if(Integer.toString(date(LodingController.subject_videoPeriod[Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1][b][c].split("~")[1].trim())).equals(Integer.toString(this_date-first_day+2))) {
									check_subject=Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1;
									check_week=b;
									check_count=c;
									click_check=2;
								}
							}
						}
					}
				}
				for(a=0;a<40;a++) {
					if(no_click!=0) {
						break;
					}
					if(LodingController.temp_subject_assignmentName[Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1][a]!=null) {
						if(LodingController.temp_subject_assignmentName[Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1][a].equals(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[1])) {
							if(Integer.toString(date(LodingController.temp_subject_assignmentPeriond[Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1][a].trim())).equals(Integer.toString(this_date-first_day+2))) {
								check_subject=Integer.parseInt(MAINLIST.getSelectionModel().getSelectedItem().toString().split(">")[0])-1;
								check_count=a;
								click_check=3;
							}
						}
					}
				}
			no_click++;
			Parent add = FXMLLoader.load(getClass().getResource("Explain_V.fxml"));
		    Scene scene = new Scene(add);
		    Stage plus = new  Stage(); 
		    plus.getIcons().add(new Image("file:resources/icon/app.png"));
	        plus.setTitle("과탑을 향해서");
		    plus.setScene(scene);
		    plus.show();
			}
		} catch(IOException a) {
			
		}
	}
	
	@FXML protected void NOTICE(ActionEvent on){  
		try {
			Parent add = FXMLLoader.load(getClass().getResource("Notice.fxml"));
		    Scene scene = new Scene(add);
		    Stage plus = new  Stage(); 
		    plus.getIcons().add(new Image("file:resources/icon/app.png"));
	        plus.setTitle("과탑을 향해서");
		    plus.setScene(scene);
		    plus.show();
			
		}catch(IOException a) {
			
		}
	}
	
	 private ObservableList<String> mainlist;  
	 
	
	@FXML protected void BUTTON1(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][0-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][0-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][0-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][0-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][0-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][0-first_day+1][a]);
			}
		}
		this_date=0;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON2(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][1-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][1-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][1-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][1-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][1-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][1-first_day+1][a]);
			}
		}
		this_date=1;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON3(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][2-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][2-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][2-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][2-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][2-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][2-first_day+1][a]);
			}
		}
		this_date=2;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON4(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][3-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][3-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][3-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][3-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][3-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][3-first_day+1][a]);
			}
		}
		this_date=3;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON5(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][4-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][4-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][4-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][4-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][4-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][4-first_day+1][a]);
			}
		}
		this_date=4;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON6(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][5-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][5-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][5-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][5-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][5-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][5-first_day+1][a]);
			}
		}
		this_date=5;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON7(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][6-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][6-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][6-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][6-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][6-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][6-first_day+1][a]);
			}
		}
		this_date=6;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON8(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][7-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][7-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][7-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][7-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][7-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][7-first_day+1][a]);
			}
		}
		this_date=7;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON9(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][8-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][8-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][8-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][8-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][8-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][8-first_day+1][a]);
			}
		}
		this_date=8;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON10(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][9-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][9-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][9-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][9-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][9-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][9-first_day+1][a]);
			}
		}
		this_date=9;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON11(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][10-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][10-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][10-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][10-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][10-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][10-first_day+1][a]);
			}
		}
		this_date=10;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON12(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][11-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][11-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][11-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][11-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][11-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][11-first_day+1][a]);
			}
		}
		this_date=11;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON13(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][12-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][12-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][12-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][12-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][12-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][12-first_day+1][a]);
			}
		}
		this_date=12;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON14(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][13-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][13-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][13-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][13-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][13-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][13-first_day+1][a]);
			}
		}
		this_date=13;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON15(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][14-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][14-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][14-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][14-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][14-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][14-first_day+1][a]);
			}
		}
		this_date=14;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON16(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][15-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][15-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][15-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][15-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][15-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][15-first_day+1][a]);
			}
		}
		this_date=15;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON17(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][16-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][16-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][16-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][16-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][16-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][16-first_day+1][a]);
			}
		}
		this_date=16;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON18(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][17-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][17-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][17-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][17-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][17-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][17-first_day+1][a]);
			}
		}
		this_date=17;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON19(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][18-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][18-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][18-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][18-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][18-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][18-first_day+1][a]);
			}
		}
		this_date=18;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON20(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][19-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][19-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][19-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][19-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][19-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][19-first_day+1][a]);
			}
		}
		this_date=19;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON21(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][20-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][20-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][20-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][20-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][20-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][20-first_day+1][a]);
			}
		}
		this_date=20;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON22(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][21-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][21-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][21-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][21-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][21-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][21-first_day+1][a]);
			}
		}
		this_date=21;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON23(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][22-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][22-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][22-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][22-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][22-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][22-first_day+1][a]);
			}
		}
		this_date=22;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON24(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][23-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][23-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][23-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][23-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][23-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][23-first_day+1][a]);
			}
		}
		this_date=23;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON25(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][24-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][24-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][24-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][24-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][24-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][24-first_day+1][a]);
			}
		}
		this_date=24;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON26(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][25-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][25-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][25-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][25-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][25-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][25-first_day+1][a]);
			}
		}
		this_date=25;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON27(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][26-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][26-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][26-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][26-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][26-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][26-first_day+1][a]);
			}
		}
		this_date=26;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON28(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][27-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][27-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][27-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][27-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][27-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][27-first_day+1][a]);
			}
		}
		this_date=27;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON29(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][28-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][28-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][28-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][28-first_day+1][a][b]);
				}
			}
		}

		for(a=0;a<40;a++) {
			if(date_U[M-1][28-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][28-first_day+1][a]);
			}
		}
		this_date=28;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON30(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][29-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][29-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][29-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][29-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][29-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][29-first_day+1][a]);
			}
		}
		this_date=29;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON31(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][30-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][30-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][30-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][30-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][30-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][30-first_day+1][a]);
			}
		}
		this_date=30;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON32(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][31-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][31-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][31-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][31-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][31-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][31-first_day+1][a]);
			}
		}
		this_date=31;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON33(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][32-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][32-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][32-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][32-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][32-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][32-first_day+1][a]);
			}
		}
		this_date=32;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON34(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][33-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][33-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][33-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][33-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][33-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][33-first_day+1][a]);
			}
		}
		this_date=33;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON35(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][34-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][34-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][34-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][34-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][34-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][34-first_day+1][a]);
			}
		}
		this_date=34;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON36(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][35-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][35-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][35-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][35-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][35-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][35-first_day+1][a]);
			}
		}
		this_date=35;
		MAINLIST.setItems(mainlist);
	}
	@FXML protected void BUTTON37(ActionEvent on){  
		mainlist = FXCollections.observableArrayList();
		int a,b;
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_V[M-1][36-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_V[M-1][36-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<LodingController.count;a++) {
			for(b=0;b<40;b++) {
				if(date_A[M-1][36-first_day+1][a][b]!=null) {
					mainlist.add(a+1+">"+date_A[M-1][36-first_day+1][a][b]);
				}
			}
		}
		
		for(a=0;a<40;a++) {
			if(date_U[M-1][36-first_day+1][a]!=null) {
				mainlist.add(">"+date_U[M-1][36-first_day+1][a]);
			}
		}
		this_date=36;
		MAINLIST.setItems(mainlist);
	}
	
}
