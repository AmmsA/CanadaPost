import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

	public static void main(String [] args)
	{
		
		welcome();
		String TrackingNumber ="LT630041402CA";
		String URL = "http://www.canadapost.ca/cpotools/apps/track/business/findByTrackNumber?trackingNumber="+TrackingNumber+"&amp;LOCALE=en";
		try {
			URLConnectionReader CanadaPost = new URLConnectionReader(URL);
			//CanadaPost.printHTML();
			String html = CanadaPost.toString();

			int from = html.indexOf("<!-- RESULT DETAILS -->");
			int till = html.lastIndexOf("<!-- OMNITURE FOR TRACKING NUMBER -->");
			html = html.substring(from, till);
			System.out.println("#############");

			html = html.replaceAll("<(\"[^\"]*\"|'[^']*'|[^'\">])*>", "");
			html = html.replaceAll("\t", " ");
			html = html.replaceAll("\\s{2,}", "#");
			Pattern pattern =Pattern.compile("#[a-zA-Z\\W]+([0-9]+[A-Z].)*");
			Matcher matcher = pattern.matcher(html);
			html = matcher.replaceAll("\n");
			html = html.replaceAll("#", "\n");
			html = html.replaceAll("^\\n", "");
			System.out.println(html);

			

			//System.out.println(html);
			System.out.println("#############");
		
			
		} catch (Exception e) {
			System.out.println("Error");
		}
		
		
	}
	
	public static void welcome(){
		System.out.println("                           x  x                            ");
		System.out.println("     C A N A D A        x  | \\   x       P O S T E S        _  _____ ____  / _ \\ <  /");
		System.out.println("=======================x   |___\\  x=======================  | |/ / -_) __/ / // / / / ");
		System.out.println("     P O S T            x /====/ x        C A N A D A       |___/\\__/_/    \\___(_)_/");
		System.out.println("                           x  x                            ");

	}
}

