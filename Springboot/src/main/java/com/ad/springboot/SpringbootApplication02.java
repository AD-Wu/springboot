//package com.ad.springboot;
//
//import java.util.EnumSet;
//
//import javax.servlet.DispatcherType;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.ServletContextInitializer;
//
//import com.ad.springboot.util.filter.MyFilter;
//import com.ad.springboot.util.listener.MyListener;
//import com.ad.springboot.util.servlet.MyServlet;
//
///**
// * 实现Servlet,Filter,Listener的第二种方式
// * 
// * @author AD
// *
// */
//@SpringBootApplication
//public class SpringbootApplication02 implements ServletContextInitializer {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringbootApplication02.class, args);
//	}
//
//	@Override
//	public void onStartup(ServletContext context) throws ServletException {
//		context.addServlet("myServlet", new MyServlet()).addMapping("/sunday");
//		context.addFilter("myFilter", new MyFilter()).addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST),
//				true, "myServlet");
//		context.addListener(new MyListener());
//	}
//
//}
