package view;

import java.io.IOException;
import java.util.Scanner;

import java.util.Iterator;

import model.Quote;
import model.RedisConnector;
import model.ResponseQuote;

import com.google.gson.Gson;

import controller.Logger;
import controller.InvokerQuoteRequestor;
import controller.RedisConnectorPool;
import view.Menu;

public class YourDailyQuotesApplication {
	private static Logger logger = Logger.getInstance();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);
		String testID = "";
		String option="";
		String user="";
		String pwd="";
		
		
		while (!user.equals("demo") && !user.equals("pass")) {
			System.out.println("Enter username:"); 
			user = myObj.nextLine();
			System.out.println("Enter password:"); 
			pwd = myObj.nextLine();
		}
		
		while (!option.equals("4")) {
			Menu.printMainMenu();
			option = myObj.nextLine();
			logger.info("Selected option: " + option, " under menu selection", "YourDailyQuotesApplication");
			if (option.equals("1")) {				
				InvokerQuoteRequestor q = new InvokerQuoteRequestor();
				//attempt on command pattern applied here
				ResponseQuote responseQuote = q.execute();
				System.out.println(responseQuote.getQuote().toString());
				
				Menu.printSaveQuote();
				option = myObj.nextLine(); 
				
				if (option.equals("y")){
					RedisConnector rc = new RedisConnector();
					//commented out attempt on Object pool pattern
//					RedisConnectorPool pool = RedisConnectorPool.getInstance();
//					RedisConnector rc = pool.getResource();
					
					rc.connectRedis();
					rc.saveQuote(responseQuote.getQuote().getId(), responseQuote.getQuote().toString());
					rc.disconnectRedis();
				}
				
				logger.info("Selected option: " + option, " under menu 1 ", "YourDailyQuotesApplication");
			}
		
			else if(option.equals("2")) {
				System.out.println("Here are all the saved quotes: ");
				RedisConnector rc = new RedisConnector();
				rc.connectRedis();
				Iterator<String> iterator = rc.getAllKeys().iterator();
				while (iterator.hasNext()) {
					System.out.println("--------------------------------------");
					System.out.println(rc.getQuote(iterator.next())); 
					System.out.println("--------------------------------------");
				}
				System.out.println(rc.getAllKeys());
				rc.disconnectRedis();
			}
			else if(option.equals("3")) {
				
			}
			
			else if(!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4")){
				System.out.println("Invalid Selection");
				logger.error("Invalid Selection", " under main menu ", "YourDailyQuotesApplication");
			}
		}
		myObj.close();
		System.out.println("Thank you for using Your Daily Quote!"); 
		logger.info("END ", " under main menu ", "YourDailyQuotesApplication");
	}
	

	
	
}
