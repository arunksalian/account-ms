package com.mykube.app.accountms.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.mykube.app.accountms.bean.Item;

@Configurable
public class AppConfig {

	@Value("${redis.hostname}")
    private String redisHostName;

    @Value("${redis.port}")
    private int redisPort;
    
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
		configuration.setHostName(redisHostName);
		configuration.setPort(redisPort);
		JedisConnectionFactory factory = new JedisConnectionFactory(configuration);
		
		return factory;
	}
	
	@Bean
	RedisTemplate<String, Item> redisTemplate(){
	    RedisTemplate<String,Item> redisTemplate = new RedisTemplate<String, Item>();
	    redisTemplate.setConnectionFactory(jedisConnectionFactory());
	    return redisTemplate;
	  }
}
