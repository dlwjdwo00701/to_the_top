import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class test {

	private static final String Login_URL = 
			"https://myclass.ssu.ac.kr/login/index.php";
	private static final String smart_campus_URL = 
			"http://myclass.ssu.ac.kr/";
	
	private static Map<String,String> cookies;
	
	
	public static void main(String[] args) throws IOException {
		/*
		Scanner scanner = new Scanner (System.in);
		System.out.println("ID를 입력하시오");
		String ID = scanner.next();
		System.out.println("PW를 입력하시오");
		String PW = scanner.next();
		*/
		String ID_m = "20190511";
		String PW_m = "qwert101806!";
		
		
		
		//1.login
		Response loginResponse = (Response)Jsoup.connect(Login_URL)
				.data("username", ID_m)
				.data("password" , PW_m)
				.method(Method.POST)
				.execute();
		
		//System.out.println("  - PAGE STATUS CODE : " +loginResponse.statusCode() );
		Document doc = loginResponse.parse();
		//System.out.println("" + doc.toString());
		
		//2.Session 정보 얻기.
		cookies = loginResponse.cookies();

		//3. 날 접근	
		Document doc1 = Jsoup.connect(smart_campus_URL)
				.cookies(cookies)
				.get();
//		System.out.println("=========================================\n");
//		System.out.println("SmartCampus Link\n");
//		System.out.println(""+doc1.toString());
//		System.out.println("=========================================\n");
		String docu = doc1.toString();
		
		int count = 1;
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
//		System.out.println(""+count);
		
		int [] startIdx_array = new int [count];
		int [] endIdx_array = new int [count];
		String [] subject_title = new String [count];
		String [] subject_link = new String [count];
		HashMap<String,String> index_subject_link = new HashMap<>() ;
		
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
//			System.out.println(""+docu.substring(startIdx_array[i]+48,endIdx_array[i]));
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
//			System.out.println(""+docu.substring(startIdx_array[i]+48,endIdx_array[i]));
			subject_link[i] = docu.substring(startIdx_array[i]+48,endIdx_array[i]);
		}
		
		
//		System.out.println("=========================================\n");
//		System.out.println("수강하는 과목명과 해당 링크\n");
		for (int i = 0 ; i < startIdx_array.length ; i++)
			index_subject_link.put(subject_title[i] , subject_link[i]);
		
		
		
		
		//4. 해당 링크에 들어가서 주요 정보 (달 별 해야할 문서와 과제 강의들을 크롤링해옴)
		//array_subject_link[강의 인덱스][달][자료]
		String[][][] array_subject_link = new String [count][16][15];
		
		for (int section = 0 ; section < count ; section++)
		{
			System.out.println("\n============================================================================");
			System.out.println(section+"번 강의명 " + subject_title[section]);
			System.out.println("============================================================================\n");
			//링크의 과제 수업 분할
			Document doc_link = Jsoup.connect(subject_link[section])
					.cookies(cookies)
					.get();
			String doc_link_string = doc_link.toString(); 

			// 1~15달까지이며 , 0번째 달은 컴퓨터구조 같이 맨 앞에 엤는 assignment를 담는 용도
//			String[][] week_things = new String[16][15];
			int first = doc_link_string.indexOf("<h2 class=\"main\">주차 별 학습 활동<span class=\"icons\"></span></h2>");
			int startIdxLink = 0;
			int endIdxLink = 0;
			String len = "<li id=\\\"section-\"+sen+\"\\\" class=\\\"section main clearfix\\\" role=\\\"region\\\" aria-label=";
			String sen = "0";
			int first_index = 0;
			//1~16주차 강의까지 작업
			for (int k = 1 ; k < 16 ; k++)
			{
				sen = Integer.toString(k+1);
				//1주차는 예외로 하나 빼줌 (first변수 부터 시작해야되기 때문)
				if (k == 1)
				{
					startIdxLink = doc_link_string.indexOf("<h3 class=\"sectionname\"><span>",first);
					endIdxLink = doc_link_string.indexOf("<li id=\"section-"+sen+"\" class=\"section main clearfix\" role=\"region\" aria-label=",first);
					System.out.println("==========================================================================");
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
							first_index = lecture_start;
						}
						else
						{
							lecture_start = doc_link_string.indexOf("<span class=\"instancename\">", lecture_end);
							lecture_end = doc_link_string.indexOf("</div>", lecture_start + len_start.length());
						}
						if(lecture_start == -1 || lecture_start < startIdxLink || lecture_end > endIdxLink)
							break;
//						week_things[k][count2] = doc_link_string.substring(lecture_start+len_start.length(),lecture_end);
//						System.out.println("count = "+count2+"\n"+week_things[k][count2]);
						
						array_subject_link[section][k][count2] = doc_link_string.substring(lecture_start+len_start.length(),lecture_end);
						System.out.println("count = "+count2+"\n"+array_subject_link[section][k][count2]);
						count2++;
					}
					System.out.println("==========================================================================");
				}
				else
				{
					System.out.println("k = "+ k+"주차");
					
					startIdxLink = doc_link_string.indexOf("<h3 class=\"sectionname\"><span>",endIdxLink);
					endIdxLink = doc_link_string.indexOf("<li id=\"section-"+sen+"\" class=\"section main clearfix\" role=\"region\" aria-label=",endIdxLink+len.length());
					
					System.out.println("==========================================================================");
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
						if(lecture_start == -1 || lecture_start == first_index ||lecture_end > endIdxLink)
							break;
//						week_things[k][count2] = doc_link_string.substring(lecture_start+len_start.length(),lecture_end);
//						System.out.println("count = "+count2+"\n"+week_things[k][count2]);
						
						array_subject_link[section][k][count2] = doc_link_string.substring(lecture_start+len_start.length(),lecture_end);
						System.out.println("count = "+count2+"\n"+array_subject_link[section][k][count2]);
						count2++;
					}
					System.out.println("==========================================================================");
				}

			}
		}

	}

}
