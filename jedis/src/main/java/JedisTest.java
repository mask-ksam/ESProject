import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author dhy
 * @create 2020-07-13 9:26 下午
 */
public class JedisTest {
    public static void main(String[] args){
        JedisPool jedisPool = new JedisPool("39.104.97.71", 6379);
        Jedis jedis = jedisPool.getResource();

        String ping = jedis.ping();
        System.out.println(ping);
        jedisPool.close();
    }
}
