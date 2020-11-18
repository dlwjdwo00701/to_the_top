import java.io.IOException;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class SmartCampus_others extends SmartCampusTokenizer{
	
	protected static final String url_setting 
		= "http://myclass.ssu.ac.kr/local/ubion/user/mycourse_setting.php";
	
	public static void moveToSettingSubject () throws IOException
	{
		//일단 로그인
		is_login();
		Document setting_subject = Jsoup.connect(url_setting)
				.cookies(cookies)
				.get();
		System.out.println(setting_subject);
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)  throws IOException
	{
		// TODO Auto-generated method stub
		moveToSettingSubject();
	}

}
