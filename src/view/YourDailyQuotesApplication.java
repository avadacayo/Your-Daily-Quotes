package view;

import java.io.IOException;
import java.util.Scanner;

import java.util.Iterator;

import model.QuoteRequestor;
import model.RedisConnector;
import model.Quote;
import model.ResponseQuote;

import com.google.gson.Gson;

public class YourDailyQuotesApplication {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);
		String testID = "";
		String option="";
		while (!option.equals("4")) {
			printMainMenu();
			option = myObj.nextLine(); 
			//switch to logger later
			System.out.println("Selected option: " + option);
		
			if (option.equals("1")) {
				QuoteRequestor r = new QuoteRequestor();
							
				System.out.println(QuoteRequestor.fetchQuote());
				Gson gson = new Gson();
				String jsonString = QuoteRequestor.fetchQuote();
			    ResponseQuote responseQuote = gson.fromJson(jsonString, ResponseQuote.class);
				
				printSaveQuote();
				option = myObj.nextLine(); 
				//switch to logger later
				System.out.println("Selected option: " + option);
				
				if (option.equals("y")){
					RedisConnector rc = new RedisConnector();
					rc.connectRedis();
					System.out.println(responseQuote.getQuote());
					testID =responseQuote.getQuote().getId();
					rc.saveQuote(responseQuote.getQuote().getId(), responseQuote.getQuote().toString());
				}
			}
		
			else if(option.equals("2")) {
				RedisConnector rc = new RedisConnector();
				rc.connectRedis();
				System.out.println("\n\n" + rc.getQuote(testID) + "\n\n");
			}
			
			else if(option.equals("3")) {
				System.out.println("Here are all the saved quotes: ");
				RedisConnector rc = new RedisConnector();
				rc.connectRedis();
				Iterator<String> iterator = rc.getAllKeys().iterator();
				while (iterator.hasNext()) {
					System.out.println("\n\n" + rc.getQuote(iterator.next()) + "\n\n"); 
				}
				System.out.println(rc.getAllKeys());
				
			}
		}
		myObj.close();
		System.out.println("Thank you for using Your Daily Quote!"); 
	}
	
	static void printMainMenu() {
		System.out.println("--------------------------------------");
		System.out.println("Select one of the following options");
		System.out.println("1 - Get Quote");
		System.out.println("2 - View Saved Quote");
		System.out.println("3 - Generate Report");
		System.out.println("4 - Exit");
		System.out.println("--------------------------------------");
		System.out.println("Enter option below:"); 
		
	}
	
	static void printSaveQuote() {
		System.out.println("--------------------------------------");
		System.out.println("Save Quote? (y/n)");
		System.out.println("--------------------------------------");
		System.out.println("Enter option below:"); 
	}
	
	
}
