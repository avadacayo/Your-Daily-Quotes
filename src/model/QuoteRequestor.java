package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class QuoteRequestor {
	 

	    public static void main(String[] args) throws IOException {
			//switch to logger later
			System.out.println("New Request");	
	    }
	    
	    public static String fetchQuote() throws IOException {
	    	HttpURLConnection connector = null;
	        String url = "https://quote-garden.herokuapp.com/api/v2/quotes/random";

	        try {

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
	            
	            //System.out.println(content.toString());
	            return content.toString();

		        } finally {
	
		            connector.disconnect();
		        }
	        
	        
	    }
}
