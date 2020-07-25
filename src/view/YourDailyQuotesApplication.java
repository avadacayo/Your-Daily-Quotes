package view;

import java.io.IOException;
import java.util.Scanner;
import connector.QuoteRequestor;
import connector.RedisConnector;

public class YourDailyQuotesApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);
		
		String option;
		System.out.println("Select one of the following options");
		System.out.println("1 - Get Quote..");
		System.out.println("2 - View Saved Quote");
		System.out.println("3 - Generate Report");
		
		System.out.println("Enter option below:"); 
		option = myObj.nextLine(); 
		//switch to logger later
		System.out.println("Selected option: " + option);
		
		if (option.equals("1")) {
			QuoteRequestor r = new QuoteRequestor();
			String returnCode;
			String quoteID;
			String quoteText;
			String quoteAuthor;
			String quoteGenre;
			
			try {
				r.fetchQuote();
				System.out.println(r.fetchQuote());
				
			} catch (IOException e) {
				// TODO Autos-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Save Quote? (y/n)");
			
			System.out.println("Enter option below:"); 
			option = myObj.nextLine(); 
			//switch to logger later
			System.out.println("Selected option: " + option);
			
			if (option.equals("y")){
				RedisConnector rc = new RedisConnector();
				rc.connectRedis();
				rc.saveQuote("1", "quote");
			}
		}
		
		else if(option.equals("2")) {
			RedisConnector rc = new RedisConnector();
			rc.connectRedis();
		}
		
		else if(option.equals("3")) {
			RedisConnector rc = new RedisConnector();
			rc.connectRedis();
			//rc.getQuote("1");
			//5eb17ab1b69dc744b4e7e2cf
			System.out.println(rc.getQuote("1"));
			
		}
		
	}

}
