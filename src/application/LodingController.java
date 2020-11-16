package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import static application.LoginController.cookies;
import static application.LoginController.new_check;
import static application.LoginController.ID_;

public class LodingController {
	
	static int count;
	static String [] subject_title;
	
 	static String [] subject_link;
 	static String[][][] array_subject_link;
	static String[] check_video_link; 
	static String[] check_assignment_link;
	
	protected static String[][][] subject_videoName;
	protected static String[][][] subject_videoPeriod;
	protected static String[][][] subject_videoLength;
	protected static String[][][] subject_videoLate;
	
	protected static String[][][] check_video;
	protected static String[][] check_assignment;
	
	protected static String[][] temp_subject_assignmentName;
	protected static String[][] temp_subject_assignmentPeriond;
	
	@FXML Label ONE;
	@FXML Label TWO;
	@FXML Label THREE;
	@FXML Label FOUR;
	@FXML Label FIVE;
	@FXML Label SIX;
	@FXML Label SEVEN;
	@FXML Label EIGHT;
	@FXML Label NINE;
	@FXML Label explain;
	
	int check=0;
	
	File SUBJECT_TITLE = new File("c://SmartCampas//"+ID_+"//subject_title.txt");
	File SUBJECT_VIDEONAME = new File("c://SmartCampas//"+ID_+"//subject_videoName.txt");
	File SUBJECT_VIDEOPERIOD = new File("c://SmartCampas//"+ID_+"//subject_videoPeriod.txt;");
	File SUBJECT_VIDEOLENGTH = new File("c://SmartCampas//"+ID_+"//subject_videoLength.txt");
	File SUBJECT_VIDEOLATE = new File("c://SmartCampas//"+ID_+"//subject_videoLate.txt");
	File CHECK_VIDEO = new File("c://SmartCampas//"+ID_+"//check_video.txt");
	File CHECK_ASSIGNMENT = new File("c://SmartCampas//"+ID_+"//check_assignment.txt");
	File TEMP_SUBJECT_ASSIGNMENTNAME = new File("c://SmartCampas//"+ID_+"//temp_subject_assignmentName.txt");
	File TEMP_SUBJECT_ASSIGNMENTPERIOD = new File("c://SmartCampas//"+ID_+"//temp_subject_assignmentPeriond.txt");
	
	@FXML protected void CRAWLING(ActionEvent on){  
		if(new_check==0) {
			check=1;
			explain.setText("저장 정보를 불러왔습니다! 맞다면 확인 버튼을 눌러주세요!");
		}
		if(check==0) {
			try {
//				FileWriter SUBJECT_TITLE_= new FileWriter(SUBJECT_TITLE);
//				FileWriter SUBJECT_VIDEONAME_= new FileWriter(SUBJECT_VIDEONAME);
//				FileWriter SUBJECT_VIDEOPERIOD_= new FileWriter(SUBJECT_VIDEOPERIOD);
//				FileWriter SUBJECT_VIDEOLENGTH_= new FileWriter(SUBJECT_VIDEOLENGTH);
//				FileWriter SUBJECT_VIDEOLATE_= new FileWriter(SUBJECT_VIDEOLATE);
//				FileWriter CHECK_VIDEO_= new FileWriter(CHECK_VIDEO);
//				FileWriter CHECK_ASSIGNMENT_= new FileWriter(CHECK_ASSIGNMENT);
//				FileWriter TEMP_SUBJECT_ASSIGNMENTNAME_= new FileWriter(TEMP_SUBJECT_ASSIGNMENTNAME);
//				FileWriter TEMP_SUBJECT_ASSIGNMENTPERIOD_= new FileWriter(TEMP_SUBJECT_ASSIGNMENTPERIOD);
				this.access_lecture_index();
				this.execution_crawling();
				this.video_assignment_divide();
				explain.setLayoutX(45);
				explain.setText("수강하시는 강의가 맞나요? 맞으면 확인 버튼을 눌러주세요!");
				check++;		
			}	catch(IOException a){
				
			}
		}	
		}
	
	@FXML protected void OK(ActionEvent on){  
			if(check==1) {
				try{
				    Parent login = FXMLLoader.load(getClass().getResource("Calendar.fxml"));
				    Scene scene = new Scene(login);
				    Stage primaryStage = (Stage)NINE.getScene().getWindow(); // 현재 윈도우 가져오기
				    primaryStage.setScene(scene);
				 } catch(Exception e){
					 
				}
			}
		}
	
	public void access_lecture_index() throws IOException
	{
		Document doc1 = Jsoup.connect("http://myclass.ssu.ac.kr/")
				.cookies(cookies)
				.get();
		
		String docu = doc1.toString();
		
		int startIdxCount = 0;
		int endIdxCount =0;
		
		while (true)
		{
			if(count == 1)
			{
				endIdxCount = docu.indexOf("<span style=\"color:#999;\">");
				startIdxCount = docu.indexOf("<div class=\"course-title\">");
				++count;
			}
			else
			{
				endIdxCount = docu.indexOf("<span style=\"color:#999;\">",endIdxCount+50);
				startIdxCount = docu.indexOf("<div class=\"course-title\">",endIdxCount);
				if(startIdxCount == -1)
					break;
				++count;
			}
		}
		
		subject_title = new String [count];
		subject_link = new String [count];
		
		int [] startIdx_array = new int [count];
		int [] endIdx_array = new int [count];
		
		for (int i = 0; i < startIdx_array.length ; i++)
		{
			if(i == 0)
			{
				endIdx_array[i] = docu.indexOf("<span style=\"color:#999;\">");
				startIdx_array[i] = docu.indexOf("<div class=\"course-title\">");
			}
			else
			{
				endIdx_array[i] = docu.indexOf("<span style=\"color:#999;\">",endIdx_array[i-1]+50);
				startIdx_array[i] = docu.indexOf("<div class=\"course-title\">",endIdx_array[i-1]);
			}
			
			subject_title[i] = docu.substring(startIdx_array[i]+48,endIdx_array[i]);
		}
		for (int i = 0; i < startIdx_array.length ; i++)
		{
			if(i == 0)
			{
				endIdx_array[i] = docu.indexOf("\" class=\"course_link\">");
				startIdx_array[i] = docu.indexOf("<div class=\"course_box\">");
			}
			else
			{
				endIdx_array[i] = docu.indexOf("\" class=\"course_link\">",endIdx_array[i-1]+50);
				startIdx_array[i] = docu.indexOf("<div class=\"course_box\">",endIdx_array[i-1]);
			}

			subject_link[i] = docu.substring(startIdx_array[i]+48,endIdx_array[i]);
		}
	}
	
	public void execution_crawling() throws IOException
	{
		//array_subject_link[강의 인덱스][달][자료]
		array_subject_link = new String [count][16][15];
		check_video_link = new String [count];
		check_assignment_link = new String [count];
		
		for (int section = 0 ; section < count ; section++)
		{
			Document doc_link = Jsoup.connect(subject_link[section])
					.cookies(cookies)
					.get();
			String doc_link_string = doc_link.toString();
				
			setup_0_index(doc_link_string, section);
			setup_other_index(doc_link_string,section);

		}
	}
	
	public void setup_0_index(String doc_link_string , int section) throws IOException
	{
		
		String start_index_0 = "<h3 class=\"sectionname accesshide\"><span>강의 개요</span></h3>";
		String end_index_0 = "<div class=\"course_box course_box_current\">";
		int index_0_start = doc_link_string.indexOf(start_index_0);
		int index_0_end = doc_link_string.indexOf(end_index_0);
		int index0_count = 0;
		int start_point = 0;
		int end_point = 0;
		int start_assignmentName = 0;
		int end_assignmentName = 0;
		int index0_point = 0;
		while(true)
		{
			String assignment_point = "<a class=\"\" onclick=\"\" href=\"http://myclass.ssu.ac.kr/mod/assign/";
			String assignment_URL = "<a class=\"\" onclick=\"\" ";
			
			String assignment_name = "alt=\"과제\" class=\"activityicon\"><span class=\"instancename\">";
			
			if(index0_count == 0)
			{
				start_point = doc_link_string.indexOf(assignment_point, index_0_start);
				end_point = doc_link_string.indexOf("\"><img src=\"http://myclass.ssu.ac.kr/local/ubion/pix/course_format/mod_icon/assign.png\"",index_0_start);
				
				start_assignmentName = doc_link_string.indexOf(assignment_name, index_0_start);
				end_assignmentName = doc_link_string.indexOf("<span class=\"accesshide \"> 과제</span></span></a>", index_0_start);
				
				index0_point = start_point;
			}
			else
			{
				start_point = doc_link_string.indexOf(assignment_point, end_point);
				end_point = doc_link_string.indexOf("\"><img src=\"http://myclass.ssu.ac.kr/local/ubion/pix/course_format/mod_icon/assign.png\"",end_point+1);
				
				start_assignmentName = doc_link_string.indexOf(assignment_name, end_assignmentName);
				end_assignmentName = doc_link_string.indexOf("<span class=\"accesshide \"> 과제</span></span></a>", end_assignmentName+1);
			}
			
			if(index0_count == 0)
			{
				if(end_point>index_0_end || start_point == -1 || end_point == -1)
					break;
			}
			else
			{
				if(end_point>index_0_end || start_point == -1 || end_point == -1 || start_point == index0_point)
					break;
			}
			
			
			array_subject_link[section][0][index0_count] = doc_link_string.substring(start_assignmentName+assignment_name.length(),end_assignmentName)+","+doc_link_string.substring(start_point+assignment_URL.length(),end_point);
			index0_count++;
		}
	}
	
	public void setup_other_index(String doc_link_string , int section) throws IOException
	{
		// 1~15달까지이며 , 0번째 달은 컴퓨터구조 같이 맨 앞에 엤는 assignment를 담는 용도
		// String[][] week_things = new String[16][15];
		int first = doc_link_string.indexOf("<h2 class=\"main\">주차 별 학습 활동<span class=\"icons\"></span></h2>");
		int startIdxLink = 0;
		int endIdxLink = 0;
		String len = "<li id=\\\"section-\"+sen+\"\\\" class=\\\"section main clearfix\\\" role=\\\"region\\\" aria-label=";
		String sen = "0";
		int first_index = 0;
		
		for (int k = 1 ; k < 16 ; k++)
		{
			
			sen = Integer.toString(k+1);
			if (k == 1)
			{
				startIdxLink = doc_link_string.indexOf("<h3 class=\"sectionname\"><span>",first);
				endIdxLink = doc_link_string.indexOf("<li id=\"section-"+sen+"\" class=\"section main clearfix",first);
				first_index = doc_link_string.indexOf("<span class=\"instancename\">", startIdxLink);
			}
			else 
			{
				startIdxLink = doc_link_string.indexOf("<h3 class=\"sectionname\"><span>",endIdxLink);
				endIdxLink = doc_link_string.indexOf("<li id=\"section-"+sen+"\" class=\"section main clearfix",endIdxLink+len.length());
		
				if(Integer.parseInt(sen) == 16)
				{
					startIdxLink = doc_link_string.indexOf("<h3 class=\"sectionname\"><span>15주차",endIdxLink);
					endIdxLink = doc_link_string.indexOf("<div class=\"coursemos-course-menu-expand\">",endIdxLink+len.length());
				}
			}
			//강의를 추가하는 코드 (달 별로 있는 것들 모두 가져옴 단, 1번째 달부터 시작함, 0번째 인덱스에는 컴퓨터구조와 같이 맨 앞에 띄운 과제를 담을 것임.
			int count2 = 0;
			int lecture_start = 0;
			int lecture_end = 0;
			
			while(true)
			{
				String len_start = "<span class=\"instancename\">";
				if (count2 == 0)
				{
					lecture_start = doc_link_string.indexOf("<span class=\"instancename\">", startIdxLink);
					lecture_end = doc_link_string.indexOf("</div>", lecture_start + len_start.length());
				}
				else
				{
					lecture_start = doc_link_string.indexOf("<span class=\"instancename\">", lecture_end);
					lecture_end = doc_link_string.indexOf("</div>", lecture_start + len_start.length());
				}
				
				//현재 주차가 맨 앞으로 가서 되돌아가는 현상 때문에 lecture_start == first_index  삽입하였음
				if(k == 1)
				{
					if(lecture_start == -1 || lecture_start < startIdxLink || lecture_end > endIdxLink)
						break;
				}
				else
				{
					if(lecture_start == -1 || lecture_start == first_index ||lecture_end > endIdxLink)
						break;
				}
				array_subject_link[section][k][count2] = doc_link_string.substring(lecture_start+len_start.length(),lecture_end);
				count2++;
			}
		}
	}
	
	public void video_assignment_divide() throws IOException
	{
		subject_videoName = new String [count][15][15];
		subject_videoPeriod = new String [count][15][15];
		subject_videoLength = new String [count][15][15];
		subject_videoLate = new String[count][15][15];
		
		/*2020.11.05 추가된 과제,영상 시청 현황 체크 필드 생성자 */
		check_video = new String [count][16][15];
		//과제 방식 좋은 아이디어가 떠오름 
		check_assignment = new String [count][40];
		temp_subject_assignmentName = new String [count][40];
		temp_subject_assignmentPeriond = new String [count][40];
		
		//1~15주차 데이터 (강의와 과제 구분)
		for(int count_sub = 0 ; count_sub < count ; count_sub++)
		{
			int tmp=count_sub;
			switch(tmp) {
			case 0:
				ONE.setText(subject_title[count_sub]);
				break;
			case 1:
				TWO.setText(subject_title[count_sub]);
				break;
			case 2:
				THREE.setText(subject_title[count_sub]);
				break;
			case 3:
				FOUR.setText(subject_title[count_sub]);
				break;
			case 4:
				FIVE.setText(subject_title[count_sub]);
				break;
			case 5:
				SIX.setText(subject_title[count_sub]);
				break;
			case 6:
				SEVEN.setText(subject_title[count_sub]);
				break;
			case 7:
				EIGHT.setText(subject_title[count_sub]);
				break;
			case 8:
				NINE.setText(subject_title[count_sub]);
				break;
				
			}
			//체크 인덱스SS
			check_assignment(count_sub);
			Document doc_video_check = Jsoup.connect(check_video_link[count_sub])
					.cookies(cookies)
					.get();
			Document doc_assignment_check = Jsoup.connect(check_assignment_link[count_sub])
					.cookies(cookies)
					.get();
			
			
			assignment_check_function(doc_assignment_check ,count_sub);
			
			int count_video_check = 0;
			
			for(int week = 1 ; week <= 15 ; week++)
			{
				//동영상 진도현황 확인
				count_video_check = video_check_function(doc_video_check ,count_sub, count_video_check,week);
				
				int week_video_count = 0;
				for (int data = 0 ; data < 15 ; data++)
				{
					if(judgeFunction(array_subject_link[count_sub][week][data]).equals("video"))
					{ 	
						subject_videoName[count_sub][week][week_video_count] = video_name(array_subject_link[count_sub][week][data]);
						subject_videoPeriod[count_sub][week][week_video_count] = video_period(array_subject_link[count_sub][week][data]);
						subject_videoLength[count_sub][week][week_video_count] = video_length(array_subject_link[count_sub][week][data]);
						subject_videoLate[count_sub][week][week_video_count] = video_late(subject_videoPeriod[count_sub][week][week_video_count]);
						if(subject_videoLate[count_sub][week][week_video_count] != null)
						{
							subject_videoPeriod[count_sub][week][week_video_count] = video_period2(array_subject_link[count_sub][week][data]);
						}
						week_video_count++;
						
					}
					
				}
			}
		}
	}
	
	public static void check_assignment(int section) throws IOException 
	{
		/*과제 얻는 방식 수정 하겠음 */
		String link_id = "http://myclass.ssu.ac.kr/course/view.php";
		String id = crawl_end(subject_link[section],link_id);
		//ID 방식으로 링크 얻어오기 (개선된 방법)
		String video_link ="http://myclass.ssu.ac.kr/report/ubcompletion/progress.php"+id;
		check_video_link[section] = video_link;
		
		String assign_link = "http://myclass.ssu.ac.kr/mod/assign/index.php"+id;
		check_assignment_link[section] = assign_link;
		
		
	}
	
	//동영상 진도현황 체크 함수
			public static int video_check_function(Document doc_video_check ,int section, int length , int k) throws IOException
			{
				/*동영상 링크에서 동영상 진도현황 체크*/
				
				String doc_video_check_string = doc_video_check.toString();				
				//대면인 경우
				String check_video_offline_block_open = "<div class=\"sectiontitle\" title=\"";
				String check_video_offline_block_close = "class=\"vmiddle text-center\">";
				int offline_check_previous_count = doc_video_check_string.indexOf(check_video_offline_block_close);
				
				
				//비대면인 경우
				String check_video_online_block_open = "<td class=\"text-center\">"+Integer.toString(k)+"</td>";
				int online_check_previous_count00 = doc_video_check_string.indexOf(check_video_online_block_open,length);
				String check_video_online_block_middle = "</tr>";
				int online_check_previous_count0 = doc_video_check_string.indexOf(check_video_online_block_middle,online_check_previous_count00);
				String check_video_online_block_close = "<td class=\"text-center\" rowspan=";
				int online_check_previous_count = doc_video_check_string.indexOf(check_video_online_block_close,online_check_previous_count0);
				
				if (online_check_previous_count00 != -1)
				{
					online_check_previous_count = online_check_previous_count0;
				}
				else
				{
					check_video_online_block_open = "<td class=\"text-center\" rowspan=";
					online_check_previous_count00 = doc_video_check_string.indexOf(check_video_online_block_open,length);
					if(online_check_previous_count00 == -1 && offline_check_previous_count == -1)
					{
						return doc_video_check_string.length();
					}
					check_video_online_block_middle = "</tr>";
					online_check_previous_count0 = doc_video_check_string.indexOf(check_video_online_block_middle,online_check_previous_count00);
					check_video_online_block_close = "<td class=\"text-center\" rowspan=";
					online_check_previous_count = doc_video_check_string.indexOf(check_video_online_block_close,online_check_previous_count0);
					
					//현재 주차인 경우 다음 주차에 rowsapn이 없기 때문에 체킹이 힘들어서 사용
					String if_check_video_online_overWeek = "<td class=\"text-center\">"+Integer.toString(k+1)+"</td>";
					int online_check_previous_count1 = doc_video_check_string.indexOf(if_check_video_online_overWeek,online_check_previous_count00);
					
					if(online_check_previous_count1 != -1 && offline_check_previous_count == -1)
					{
						online_check_previous_count = online_check_previous_count1;
					}
					else if(online_check_previous_count == -1 && offline_check_previous_count == -1)
					{
						online_check_previous_count = online_check_previous_count0;
					}
				}			
				if(offline_check_previous_count != -1)
				{
					
//					System.out.println("OffLine");
					//대면수업과 비대면 수업 방식이 달라서 체킹해주기 바랆.
					//return 값이고 밑의 crawl_middle()에 넣어지는 값임.
//					int length = check_video_offline_block_close.length();

					
					int offline_check_start = doc_video_check_string.indexOf(check_video_offline_block_open,length);
					int offline_check_end = doc_video_check_string.indexOf(check_video_offline_block_close,offline_check_start);
					if(offline_check_end == -1)
						return doc_video_check_string.length();
					
					//실제로 리턴해야하는 값.
					int length_offline = offline_check_end;
					
					String check_video_offline_block = doc_video_check_string.substring(offline_check_start,offline_check_end);

					
					String len_offline = "</button></td>";
					int next_value = check_video_offline_block.indexOf(len_offline);
					int count_offline = 1;
					int index_start = 0;
					int check_recursive = 0;
					int index_end = 0;
					while(true)
					{
						String check_video_offline_start = "<td class=\"text-center\">";
						String check_video_offline_end = "%";
						int length2 = check_video_offline_start.length();
						int length3 = check_video_offline_end.length();
						index_start = check_video_offline_block.indexOf(check_video_offline_start,next_value);
						index_end = check_video_offline_block.indexOf(check_video_offline_end,next_value);


						if(index_start == -1 || index_end==-1 || index_start>index_end || (check_recursive > index_start && count_offline != 1))
							break;
						next_value = check_video_offline_block.indexOf("</button></td>",index_end+length3);
						check_video[section][k][count_offline-1] = check_video_offline_block.substring(index_start+length2,index_end+1);
						count_offline++;
						check_recursive = index_start;
					}
					return length_offline ;
				}
				else
				{
					
					int online_check_start = online_check_previous_count00;
					int online_check_end = online_check_previous_count;
					
					//실제로 리턴해야하는 값
					int length_online = online_check_end;
					String check_video_online_block = doc_video_check_string.substring(online_check_start,online_check_end);
					
					String len_online = "</button></td>";
					int next_value = check_video_online_block.indexOf(len_online);
					String len_online2 = "</tr>";
					int next_value_total = 0;
					
					int count_online = 1;
					int index_start_O = 0;
					int index_start_X = 0;
					int index_start_another = 0;
				
					while(true)
					{
						String length_cal = "<td class=\"text-center\">";
						String check_video_online_check_point_O =  "<td class=\"text-center\">O</td>"; 
						String check_video_online_check_point_X =  "<td class=\"text-center\">X</td>"; 
						String check_video_online_check_point_another =  "<td class=\"text-center\">▲</td>"; 
						
						index_start_O = check_video_online_block.indexOf(check_video_online_check_point_O,next_value_total);
						index_start_X = check_video_online_block.indexOf(check_video_online_check_point_X,next_value_total);
						index_start_another = check_video_online_block.indexOf(check_video_online_check_point_another,next_value_total);
						
						int small_index = small_index_return (index_start_O , index_start_X , index_start_another);
						if(small_index == -1 || next_value_total == -1)
						{
							break;
						}
						else
						{
							next_value = check_video_online_block.indexOf(len_online2,small_index) + len_online2.length();
							check_video[section][k][count_online-1] = check_video_online_block.substring(small_index+length_cal.length(),small_index+length_cal.length()+1);
							count_online++;
							next_value_total = next_value;
						}
						
					}
					return length_online;
					
				}

			}
			
			public static void assignment_check_function (Document doc , int section) throws IOException
			{			
				String doc_assignment = doc.toString();
				String doc2 = "이 강좌에는 과제가 없습니다.";
				int check_assign = doc_assignment.indexOf(doc2);
				if(check_assign == -1)
				{
					
					//해당 과제 블럭
					String assign_check_block_open = "<tbody>";
					String assign_check_block_close = "</tbody>";
					String assign_check_block = crawl_middle(doc_assignment,assign_check_block_open,assign_check_block_close);
					
					//과제 이름 , 과제 기한 , 과제 제출 현황 긁어오기
					int start_point = 0;
					int count_assign = 0;
					while(true)
					{
						String assign_name_start = "<td class=\"cell c1\" style=\"text-align:left;\"><a href=\"http://myclass.ssu.ac.kr/mod/assign/view.php?id=";
						String assign_name_end = "</a></td>";
						int assign_name_start_index = assign_check_block.indexOf(assign_name_start,start_point) ;
						int assign_name_end_index = assign_check_block.indexOf(assign_name_end,assign_name_start_index) ;
						
						String assign_period_start = "<td class=\"cell c2\" style=\"text-align:center;\">";
						String assign_period_end = "</td>";
						int assign_period_start_index = assign_check_block.indexOf(assign_period_start,assign_name_end_index) ;
						int assign_period_end_index = assign_check_block.indexOf(assign_period_end,assign_period_start_index) ;
						
						String assign_check_start = "<td class=\"cell c3\" style=\"text-align:right;\">";
						String assign_check_end = "</td>";
						int assign_check_start_index = assign_check_block.indexOf(assign_check_start,assign_period_end_index) ;
						int assign_check_end_index = assign_check_block.indexOf(assign_check_end,assign_check_start_index) ;
						
						if(assign_name_start_index == -1 || ((start_point > assign_name_start_index) &&  assign_name_start_index != -1))
						{
							break;
						}
						
						String assign_name_unmodified = assign_check_block.substring(assign_name_start_index+assign_name_start.length(), assign_name_end_index);
						String assign_period = assign_check_block.substring(assign_period_start_index+assign_period_start.length() , assign_period_end_index);
						String assign_check = assign_check_block.substring(assign_check_start_index+assign_check_start.length() , assign_check_end_index);
						
						String modify_assign_name = ">";
						int modify_assign_name_index = assign_name_unmodified.indexOf(modify_assign_name);
						String assign_name = assign_name_unmodified.substring(modify_assign_name_index+modify_assign_name.length());
						
						
						temp_subject_assignmentName [section][count_assign] = assign_name;
						temp_subject_assignmentPeriond[section][count_assign] = assign_period;
						check_assignment [section][count_assign] = assign_check;
						
						start_point = assign_check_end_index+assign_check_end.length();
						
						

						count_assign++;
					}
				}

			}
	
	//Crawling 함수 (크롤링 전반 함수) -> 맨 앞의 줄에서 크롤링을 하는경우
			public static String crawl_start(String crawl_HTML , String end_string)
			{
				int end = crawl_HTML.indexOf(end_string);
				if(end == -1)//크롤링 데이터가 없는 경우.
					return "-1";
				return crawl_HTML.substring(0, end);
			}
			// 중간 부분 텍스트를 크롤링 하는 경우 , -1을 넣으면, 시작 인덱스 번호가 없음을 의미함.
			public static String crawl_middle(String crawl_HTML ,String start_string, String end_string)
			{
				int start_len = start_string.length();
				int start = crawl_HTML.indexOf(start_string);
				int end = crawl_HTML.indexOf(end_string,start);


				if(start == -1)
					return "Start can't be found";
				else if(end == -1)
					return "End can't be found";
				else if(start > end)
					return "start > end";
				return crawl_HTML.substring(start+start_len, end);
			}
			//마지막 부분을 크롤링 하는 경우
			public static String crawl_end(String crawl_HTML , String start_string)
			{
				int start_len = start_string.length();
				int start = crawl_HTML.indexOf(start_string);
				if (start == -1)
					return "-1";
				return crawl_HTML.substring(start+start_len);
			}
			
			//세모 , X , 중 가장 작은 인덱스 리턴
			public static int small_index_return(int value1 , int value2 , int value3)
			{
				if (value1 == -1 && value2 == -1 && value3 == -1)
					return -1;
				int va1 = value1;
				int va2 = value2;
				int va3 = value3;
				
				//매개변수를 바꾸면 인식 불가
				if(va1 == -1)
					va1 = 999999999;
				if(va2 == -1)
					va2 = 999999999;
				if(va3 == -1)
					va3 = 999999999;
				
				int small_est = va1;
				if(va2 < va1)
					small_est = va2;
				if(va3 < va2)
					small_est = va3;
				return small_est;
			}
	
	public String judgeFunction (String sentence) 
	{
		if(sentence == null)
			return "other";
		String start_len ="<span class=\"accesshide \"> ";
		String end_len = "</span></span>";
		String start_len2 = "</span>";
		String end_len_2 = "</span></a>";
		int video_start = sentence.indexOf(start_len);
		int video_end = sentence.indexOf(end_len);
		int assign_start = sentence.indexOf(start_len2);
		int assign_end = sentence.indexOf(end_len_2);
		
		if (assign_end- assign_start-start_len2.length()!= 0)
			return "assignment";
		else if (sentence.substring(video_start+start_len.length(), video_end).equals("Commons"))
			return "video";
		else
			return "other";
	}
	
	private static String video_name(String sentence)
	{
		int end = sentence.indexOf("<span class=\"accesshide \">");
		return sentence.substring(0, end);
	}
	
	private static String video_period(String sentence)
	{
		String video_period = "<span class=\"displayoptions\"><span class=\"text-ubstrap\">&nbsp;";
		int start = sentence.indexOf(video_period);
		int end = sentence.indexOf("</span></span><span class=\"text-info\">,"); 
		int end2 = sentence.indexOf("</span><span class=\"text-info\">,"); 
		if(end == -1)
		{
			if(end2 == -1)
				return "0000-00-00 00:00:00 ~ 0000-00-00 00:00:00";
			else
				return sentence.substring(start+video_period.length() , end2);
		}
		return sentence.substring(start+video_period.length() , end);
	}
	private static String video_period2 (String sentence)
	{
		String video_period2 = "<span class=\"displayoptions\"><span class=\"text-ubstrap\">&nbsp;";
		int start = sentence.indexOf(video_period2);
		int end = sentence.indexOf(" <span class=\"text-late\">");
		return sentence.substring(start+video_period2.length() , end);
	}
	
	
	private static String video_length(String sentence)
	{
		String video_length = "</span></span><span class=\"text-info\">, ";
		int start = sentence.indexOf(video_length);
		if (start == -1)
		{
			video_length = "</span><span class=\"text-info\">, ";
			start = sentence.indexOf(video_length);
		}
		int end = sentence.indexOf("</span></span>",start+video_length.length());
		return sentence.substring(start+video_length.length() , end);
	}
	
	//sentence에는 period가 들어가야됨.
	private static String video_late(String sentence)
	{
		String video_late_check = "<span class=\"text-late\">";
		String time_late = "2000-00-00 00:00:00";
		String late_format ="(Late : ";
		String late_format2 ="(지각 : ";
		
		int start = sentence.indexOf(video_late_check);
		int start2 = sentence.indexOf(late_format);
		int start3 = sentence.indexOf(late_format2);
		if(start == -1)
			return null;
		else
		{
			if(start2 != -1)
			{
				return sentence.substring(start2+late_format.length() , start2+late_format.length()+time_late.length());
			}
			else if (start3 != -1)
			{
				return sentence.substring(start3+late_format2.length() , start3+late_format2.length()+time_late.length());
			}
		}
		return null;
	}
	
}
