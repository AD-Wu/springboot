package com.ad.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 实现Servlet,Filter,Listener的第三种方式
 * 
 * 通过@ServletComponentScan,@WebServlet,@WebListener,@WebFilter实现，推荐使用
 * 
 * MyFilter 中并没有做拦截路径的配置，这种方式把所有请求都拦截了
 * 
 * @author AD
 *
 */

//@ServletComponentScan
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
