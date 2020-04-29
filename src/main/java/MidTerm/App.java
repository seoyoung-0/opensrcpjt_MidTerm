package MidTerm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String item ="";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the keyword you are looking for: ");
        item = in.next();
        boolean itemOk=true;
        
        JSONParser parser = new JSONParser();
        try {
        	  JSONObject jsonObject;

			try {
				jsonObject = (JSONObject) parser.parse(new FileReader("C:\\Users\\kdy03\\eclipse-space\\MidTerm\\midterm.json"));
				
				
				JSONArray itemArray = (JSONArray)jsonObject.get("poem");
				String eachString ="";
				 for(int i=0;i<itemArray.size();i++) {
			        	
			        	JSONObject itemObject = (JSONObject)itemArray.get(i);
			        	eachString = itemObject.toString();
			        	for(int j=0;j<eachString.length();j++) {
			        		if(eachString.contains(item)) {
			        			itemOk=true;
			        		}else {
			        			itemOk=false;
			        		}
				 }
			        	if(itemOk==true)
		        		{
		        			System.out.print("item"+i+":");
		        			System.out.println(eachString);
		        			}
		        		}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    }
}
}
