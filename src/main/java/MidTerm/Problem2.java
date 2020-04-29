package MidTerm;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import midterm.problem2.RegularExpression;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String item ="";
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the keyword you are looking for: ");
        item = in.next();
 
        RegularExpression re = new RegularExpression();
        
        JSONParser parser = new JSONParser();
        try {
        	  JSONObject jsonObject;

			try {
				jsonObject = (JSONObject) parser.parse(new FileReader("C:\\Users\\kdy03\\eclipse-space\\MidTerm\\midterm.json"));
		
				JSONArray itemArray = (JSONArray)jsonObject.get("poem");
				String eachString ="";
				 for(int i=0;i<itemArray.size();i++) {
			        	
			        	JSONObject itemObject = (JSONObject)itemArray.get(i);
			        	eachString = itemObject.values().toString();
		
			        	if(re.check(eachString, item)) {
			       
			        		System.out.print("item "+i+":");
		        			System.out.println(eachString);
			        	}
				 }

			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
	}
}
