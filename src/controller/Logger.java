package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private final String logFile = "YourDailyQuotesLogs.txt";
    private PrintWriter writer;
    private static Logger instance;
    
    private Logger() {
        try {
            FileWriter fw = new FileWriter(logFile);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {
        	System.err.println("ERROR: Could not write to log file");
        }
    }

    public void logAction (String action, String method) {
    		writer.println(action + "[" + method+ "]");
    }
    
    public void info (String action, String method, String ourclass) {
		writer.println("INFO: " + action + " " + method + "...... [" + ourclass + "]");
    }

    public void error (String action, String method, String ourclass) {
		writer.println("ERROR: " + action + " " +  method + "...... [" + ourclass + "]");
    }
    
    public static Logger getInstance(){
    	if (instance==null) 
    		instance = new Logger(); 
        return instance; 
	}
}
