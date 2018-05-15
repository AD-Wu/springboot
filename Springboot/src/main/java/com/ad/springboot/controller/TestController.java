package com.ad.springboot.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ad.springboot.bean.User;

@RestController
@RequestMapping(value = "/index")
public class TestController {

	@Value(value = "${random.string}")
	private String randomString;
	@Value(value = "${random.int}")
	private int randomNumber;
	@Value(value = "${ad.desc}")
	private String desc;

	// 一个类中只能有一个方法没有映射路径，否则启动时会发生bean异常（反射创建对象出错）
	@RequestMapping()
	public String index() {
		return "HelloWorld1";
	}

	@RequestMapping("/helloworld")
	public String helloWorld() {
		return "HelloWorld";
	}

	// 和上面的等效
	// @RequestMapping(value="helloworld")
	// public String helloWorld() {
	// return "HelloWorld";
	// }

	@RequestMapping(value = "get")
	public Map<String, Object> get(@RequestParam int id, @RequestParam String name) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("randomNumber", randomNumber);
		map.put("randomString", randomString);
		map.put("desc", desc);
		map.put("date", new Date());
		return map;
	}

	// 动态路径
	@RequestMapping("/user/{name}/{age}")
	public User getUser(@PathVariable String name,@PathVariable int age) {
		return new User.Builder(name,age).birthday(new Date()).tel("18606051513").build();
	}

}
