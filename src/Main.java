import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
public class Main {

	public static void main(String [] args)
	{
		welcome();
		for(;;){
		
		String TrackingNumber = ask();
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
			System.out.println("Error, could not process your tracking number.");
		}
		
		if(again()==true){
				continue;
			}
			else{
				break;
			}
		}
		
	}
	
	public static void welcome()
	{
		System.out.println("                           x  x                            ");
		System.out.println("     C A N A D A        x  | \\   x       P O S T E S        _  _____ ____  / _ \\ <  /");
		System.out.println("=======================x   |___\\  x=======================  | |/ / -_) __/ / // / / / ");
		System.out.println("     P O S T            x /====/ x        C A N A D A       |___/\\__/_/    \\___(_)_/");
		System.out.println("                           x  x                            ");
		
	}
	
	public static String ask(){
		String TrackingNumber; // Declare a variable to hold the trackingNumber.
		Scanner in = new Scanner(System.in);

		System.out.println("Please enter your tracking number: ");
		TrackingNumber = in.nextLine(); // Read one line from the console.
		//in.close(); //Note 2
		
		return TrackingNumber;

	}
	public static boolean again(){
		
		String answer;
		for(;;){
		Scanner in2 = new Scanner(System.in);
		System.out.println("Do you want to track another shipment? [Y/N]");
		answer = in2.nextLine(); // Read one line from the console.
		//in2.close(); //Note 2
		if (answer.compareToIgnoreCase("Y")==0){
			return true;
		}
		else if (answer.compareToIgnoreCase("N")==0){
			return false;	
		}
		else{
			continue;
		}
		}
		

	}
	
	
}

