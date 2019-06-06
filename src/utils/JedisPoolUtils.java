package utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        InputStream properties = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis_properties");
        Properties pro = new Properties();
        try {
            pro.load(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

        jedisPool=new JedisPool(config,pro.getProperty("host"),Integer.parseInt(pro.getProperty("port")) );
    }

    public static Jedis getJrdis(){
        return jedisPool.getResource();

    }
}
