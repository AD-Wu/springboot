package com.ad.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ad.springboot.controller.TestController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	private MockMvc mockMvc = null;

	@Before
	public void before() {
		mockMvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
	}

	@Test
	public void contextLoads() throws Exception {
		RequestBuilder req = get("/index");

		mockMvc.perform(req).andExpect(status().isOk()).andExpect(content().string("HelloWorld"));
	}

}
