//package com.ad.springboot;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//
//import com.ad.springboot.util.filter.MyFilter;
//import com.ad.springboot.util.listener.MyListener;
//import com.ad.springboot.util.servlet.MyServlet;
//
///***
// * 实现Servlet,Filter,Listener的第一种方式
// * 
// * @author AD
// *
// */
//@SpringBootApplication
//public class SpringbootApplication03 {
//
//	@Bean
//	public ServletRegistrationBean<MyServlet> registerServlet() {
//		return new ServletRegistrationBean<MyServlet>(new MyServlet(), "/sunday");
//	}
//
//	@Bean
//	public FilterRegistrationBean<MyFilter> registerFilter() {
//		return new FilterRegistrationBean<MyFilter>(new MyFilter(), registerServlet());
//	}
//
//	@Bean
//	public ServletListenerRegistrationBean<MyListener> registerListener() {
//		return new ServletListenerRegistrationBean<MyListener>(new MyListener());
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringbootApplication03.class, args);
//	}
//}
