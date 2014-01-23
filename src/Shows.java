import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.*;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.*;

public class Shows {
	private static String timezone;
	private static String link = "http://www.tvguide.com/new-tonight/8000";
	private static URL url;
	private static BufferedReader reader;
	private static String line;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Please choose your timezone: Eastern, Central, Mountain, Pacific, Alaskan, or Hawaiian.");
		timezone = in.next();
		timezone.toLowerCase();
		if (timezone.equals("eastern")){
			link = link.concat("1");
		}
		else if (timezone.equals("central")){
			link = link.concat("2");
		}
		else if (timezone.equals("mountain")){
			link = link.concat("3");
		}
		else if (timezone.equals("pacific")){
			link = link.concat("4");
		}
		else if (timezone.equals("alaskan")){
			link = link.concat("5");
		}
		else {
			link = link.concat("6");
		}
		try {
		url = new URL(link);
		reader = new BufferedReader(new InputStreamReader(url.openStream()));
		line = reader.readLine();
		while (line != null){
			if (line.equals("                                <h3>")){
				line = reader.readLine();
				Document document = Jsoup.parse(line);
			    Elements headers = document.select("a");
			    for (Element header : headers) {
			        System.out.println(header.ownText());
			    }
			}
			line = reader.readLine();
		}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
}
