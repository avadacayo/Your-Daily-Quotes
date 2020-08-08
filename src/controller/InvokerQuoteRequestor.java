package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import model.Command;
import model.ResponseQuote;

//this class handes the actual call for the api
// currently called by YourDailyQuotesApplication class, using fetchQuote()
public class InvokerQuoteRequestor implements Command {
	private static Logger logger = Logger.getInstance();

	    public static void main(String[] args) throws IOException {
	    	logger.info("New Request ", " under main ", "QuoteRequestor");
	    }
	    
	    public ResponseQuote execute() {
	    	ResponseQuote responseQuote = null;
	    	try {
		    	Gson gson = new Gson();
		    	responseQuote = gson.fromJson(fetchQuote(), ResponseQuote.class);
		    	//System.out.println(responseQuote.getQuote().toString());
		    	
	    	}
	    	catch(IOException e) {
	    		  e.printStackTrace();
	    	}
	    	return responseQuote;
	    }
	    
	    public static String fetchQuote() throws IOException {
	    	HttpURLConnection connector = null;
	        String url = "https://quote-garden.herokuapp.com/api/v2/quotes/random";

	        try {
	        	logger.info("calling api ", " under fetchQuote() ", "QuoteRequestor");
	            URL myurl = new URL(url);
	            connector = (HttpURLConnection) myurl.openConnection();

	            connector.setRequestMethod("GET");

	            StringBuilder content;

	            try (BufferedReader in = new BufferedReader(
	                    new InputStreamReader(connector.getInputStream()))) {

	                String line;
	                content = new StringBuilder();

	                while ((line = in.readLine()) != null) {

	                    content.append(line);
	                    content.append(System.lineSeparator());
	                }
	            }
	            return content.toString();
	        } 
	        finally {
	        	connector.disconnect();
		    }
	        
	        
	    }
}
