import java.net.*;
import java.io.*;
import java.util.LinkedList;
public class URLConnectionReader {
	String h;
	LinkedList<String> html;
    public URLConnectionReader(String www) throws Exception {
        URL website = new URL(www);
        URLConnection yc = website.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;
        String h ="";
        html = new LinkedList<String>();
        
        while ((inputLine = in.readLine()) != null) {
            //System.out.println(inputLine);
            html.addLast(inputLine);
        }
        in.close();    
    }
    public void printHTML()
    {
    	for(int i = 0;i<html.size();i++)
    	{
    		System.out.println(html.get(i).toString());
    	}
    }
    public String toString()
    {
    	String code="";
    	for(int i = 0;i<html.size();i++)
    	{
    		code+=html.get(i).toString();
    	}
    	return code;
    }
    
}