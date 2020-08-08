package model;
import java.util.List;
import java.util.Set;

import controller.Logger;
import redis.clients.jedis.Jedis;

//contains the code for connecting to reddis
//currently implements the actions to retrieve and write to the db

public class RedisConnector {
	Jedis jedis = new Jedis("redis-12146.c13.us-east-1-3.ec2.cloud.redislabs.com", 12146);
	private static Logger logger = Logger.getInstance();
	
	public static void main(String[] args) throws Exception {
		logger.info("New RedisConnector ", " under main ", "RedisConnector");			
	  }
	
	public void connectRedis() {
	    jedis.auth("NZFpBd86ZCsDuDdWoWl1UejHyHrakD8t");
	    logger.info("Connected to Redis ", " under connectRedis() ", "RedisConnector");
	}
	
	public void saveQuote(String id, String string) {
		jedis.set(id, string.toString());
	    logger.info("Quote saved ", " under saveQuote() ", "RedisConnector");
	}
	
	public String getQuote(String id) {
		logger.info("Getting quote by id ", " under getQuote() ", "RedisConnector");
		return jedis.get(id);
	}
	
	public Set<String> getAllKeys() {
		logger.info("Getting all keys", " under getAllKeys() ", "RedisConnector");
		return jedis.keys("*");
	}
	
	public void disconnectRedis() {
	    jedis.disconnect();
	}
}
