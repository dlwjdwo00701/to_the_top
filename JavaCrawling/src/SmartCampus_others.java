import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class SmartCampus_others extends SmartCampusTokenizer{
	protected static Map<String,String> cookies_SSU;
	protected static final String url_setting 
		= "https://scatch.ssu.ac.kr";
	
	public static void moveToSettingSubject () throws IOException
	{
		Response ssu_search = (Response)Jsoup.connect(Login_URL)
				.data("value", "¹èÁØÇü")
				.execute();
		Document doc = ssu_search.parse();
		System.out.println("" + doc.toString());
		System.out.println(ssu_search);
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)  throws IOException
	{
		// TODO Auto-generated method stub
		moveToSettingSubject();
	}

}
