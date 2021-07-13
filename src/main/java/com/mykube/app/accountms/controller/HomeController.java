package com.mykube.app.accountms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mykube.app.accountms.bean.Item;

@RestController
public class HomeController {

	@Autowired
	private RedisTemplate<String, Item> redisTemplate;
	public static final String KEY = "ITEM";
	@GetMapping("/home")
	public String getHome () {
		Item item = null;
		if (redisTemplate.opsForHash().hasKey(KEY, 1)) {
			item = (Item) redisTemplate.opsForHash().get(KEY, 1);
			item.setHits(item.getHits()+1);
		} else {
			item = new Item("Arun", 1, 1);
		}
		redisTemplate.opsForHash().put(KEY, item.getName(), item);
		return "HI. Hite:"+item.getHits();
	}
}
