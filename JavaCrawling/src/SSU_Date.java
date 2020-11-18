
import java.io.IOException;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class SSU_Date extends SmartCampusTokenizer{
	protected static final String u_saint_Date_link 
	= "https://ssu.ac.kr/%ED%95%99%EC%82%AC/%ED%95%99%EC%82%AC%EC%9D%BC%EC%A0%95/?years=2020";
	protected static final String u_saint_Date_link2
	="https://ssu.ac.kr/%ED%95%99%EC%82%AC/%ED%95%99%EC%82%AC%EC%9D%BC%EC%A0%95/?years=2019";
	
	
	/*아래 두 배열은 날짜에 따른 스케쥴 일정을 저장함.*/
	protected static String[] usaint_date; // 크롤링 정보가 담긴 배열 (중요배열) usaint_date[날짜]
	protected static String[] usaint_schedule; //usaint_schedule[스케쥴 일정]
	private static int count_usaint_date;
	
	protected static String [][] usaint_date_token; //시작 그리고 끝 [0]:시작 ,[1]:끝
	
	
	
	
	//usaint 학사일정을 블럭단위로 긁어옴
	public static void u_saint_date_block_crawl() throws IOException
	{
		Document usaint_date_link = Jsoup.connect(u_saint_Date_link)
				.get();
//		System.out.println(usaint_date_link);
		String usaint_date_toString = usaint_date_link.toString();
//		String start_block = "<a href=\"?years="+Integer.toString(current_year)+"\" class=\"year-next\">";
		String start_block = "<h5 class=\"font-weight-light mb-0\"><strong>";
		String end_block = "<footer id=\"footer\" class=\"d-print-none\">";
		
		int start_block_index = usaint_date_toString.indexOf(start_block);
		int end_block_index = usaint_date_toString.indexOf(end_block);
//		System.out.println(usaint_date_toString.substring(start_block_index,end_block_index));
		String one_block = usaint_date_toString.substring(start_block_index,end_block_index);
		
		
		String one_block_start_str = "<div class=\"col-12 col-lg-4 col-xl-3 font-weight-normal text-primary\">";
		String one_block_end_str ="</div> </li>"; 
		
		int next = 0;
		count_usaint_date = 1;
		while(true)
		{
//			System.out.println("=========================================================================");
			int one_block_start_idx = one_block.indexOf(one_block_start_str,next);
			int one_block_end_idx = one_block.indexOf(one_block_end_str,one_block_start_idx);
			if(one_block_start_idx == -1)
				break;
//			System.out.println("=========================================================================");
			next = one_block_end_idx;
			count_usaint_date++;
		}
		
		
		next = 0;
		usaint_date = new String [count_usaint_date];
		usaint_schedule = new String [count_usaint_date]; 
		int count_array = 0;
		while(true)
		{
//			System.out.println("=========================================================================");
			int one_block_start_idx = one_block.indexOf(one_block_start_str,next);
			int one_block_end_idx = one_block.indexOf(one_block_end_str,one_block_start_idx);
			if(one_block_start_idx == -1)
				break;
			String one_block_date = one_block.substring(one_block_start_idx,one_block_end_idx);
//			System.out.println("=========================================================================");
			next = one_block_end_idx;
			
//			System.out.println(one_block_date);
			String date_start_str = "<div class=\"col-12 col-lg-4 col-xl-3 font-weight-normal text-primary\">";
			String date_end_str = "</div>";
			int date_start_idx = one_block_date.indexOf(date_start_str);
			int date_end_idx = one_block_date.indexOf(date_end_str);
//			System.out.println(one_block_date.substring(date_start_idx+date_start_str.length(),date_end_idx).trim());
			usaint_date[count_array] = one_block_date.substring(date_start_idx+date_start_str.length(),date_end_idx).trim();
			
			String date_start_str2 = "<div class=\"col-12 col-lg-8 col-xl-9\">";
			String date_end_str2 = "</div>";
			int date_start_idx2 = one_block_date.indexOf(date_start_str2);
			int date_end_idx2 = one_block_date.indexOf(date_end_str2,date_start_idx2);
//			System.out.println(one_block_date.substring(date_start_idx2+date_start_str2.length(),date_end_idx2).trim());
			usaint_schedule[count_array] = one_block_date.substring(date_start_idx2+date_start_str2.length(),date_end_idx2).trim();
			count_array++;
		}
	}
	
	
	//학사 일정 출력 함수
	public static void print_schedule_list()
	{
		
		for(int i = 0 ; i < count_usaint_date ; i++)
		{
			if(usaint_schedule[i] != null)
			{
				System.out.println("count = "+ (i+1));
				System.out.println("할 일 = "+usaint_schedule[i]);
//				System.out.println("학사 날짜  = "+usaint_date[i]);
				System.out.println("학사 날짜 (시작) = "+usaint_date_token[i][0]);
				System.out.println("학사 날짜 (끝) = "+usaint_date_token[i][1]);
				System.out.println();
			}
		}
	}
	
	
	// tokenzier : 01.13 (월) ~ 01.15 (수) 형식을 -> 2020-01-13 00:00:00 ~ 2020-01-15 00:00:00 형식으로 전환
	public static void usaint_date_tokenzier()
	{
		usaint_date_token = new String [count_usaint_date][2];
		//SmartCampusTokenizer의 current_time (현재시간)
		String current_time_temp = current_time;
		int current_year = year(current_time_temp);
		String current_year1 = Integer.toString(current_year)+"-";
		
		
		for(int  i = 0 ; i < count_usaint_date ; i++)
		{
			if(usaint_date[i] != null)
			{
				//~을 해서 있으면 끝 날짜가 있는 것이고, 없으면 하루만 일정이 잡혀있는 것임.
				int check_point = usaint_date[i].indexOf("~");
//				System.out.println("check = "+check_point);
				if(check_point != -1)
				{
					String[] split_format1 = usaint_date[i].trim().split(Pattern.quote("~"));
					int end2 = split_format1[0].indexOf("(");
					split_format1[0] = split_format1[0].substring(0,end2);
					split_format1[0] = split_format1[0].trim().replace(".","-");
//					System.out.println(test[0].trim());
					
					int end = split_format1[1].indexOf("(");
					split_format1[1] = split_format1[1].substring(0,end);
					split_format1[1] = split_format1[1].trim().replace(".","-");
//					System.out.println(test[1].trim());
					
					String start_date = current_year1+split_format1[0] + " 00:00:00";
					String end_date = current_year1+split_format1[1] + " 23:59:59";
//					System.out.println(start_date);
//					System.out.println(end_date);
//					System.out.println(" ");
					usaint_date_token[i][0] = start_date;
					usaint_date_token[i][1] = end_date;
					
					
				}
				else
				{
//					System.out.println(usaint_date[1]);
					String split_format2[] = usaint_date[i].split(" ");
//					System.out.println(split_format2[0]);
					split_format2[0] = split_format2[0].trim().replace(".","-");
					
					
					String start_date = current_year1+split_format2[0] + " 00:00:00";
					String end_date = current_year1+split_format2[0] + " 23:59:59";
//					System.out.println(start_date);
//					System.out.println(end_date);
//					System.out.println(" ");
					usaint_date_token[i][0] = start_date;
					usaint_date_token[i][1] = end_date;
				}
			}
			
		}
	}
	
	
	
	
	

	//실행 함수 (객체화)
	public static void execute_usaint() throws IOException
	{
		//현재 시간을 가져오는 함수 (올해가 무슨 연도인지 가져와야되기 때문)
		current_time();
		
		//유세인트 학사일정 크롤링 함수
		u_saint_date_block_crawl();
		
		//// tokenzier : 01.13 (월) ~ 01.15 (수) 형식을 -> 2020-01-13 00:00:00 ~ 2020-01-15 00:00:00 형식으로 전환
		usaint_date_tokenzier();
		
		System.out.println("=========================================================================");
		System.out.println("학사일정 출력 중...");
		print_schedule_list();
		System.out.println("=========================================================================");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		execute_usaint();
	}

}
