package connector;
import redis.clients.jedis.Jedis;

public class RedisConnector {
	Jedis jedis = new Jedis("redis-12146.c13.us-east-1-3.ec2.cloud.redislabs.com", 12146);
	public static void main(String[] args) throws Exception {
		//switch to logger later
			System.out.println("New RedisConnector");	
			
	  }
	
	public void connectRedis() {
	    jedis.auth("NZFpBd86ZCsDuDdWoWl1UejHyHrakD8t");
	    System.out.println("Connected to Redis");
	}
	
	public void saveQuote(String id, String quote) {
		jedis.set(id, quote);
	}
	
	public String getQuote(String id) {
		return jedis.get(id);
	}
}
