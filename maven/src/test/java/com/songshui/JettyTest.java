package com.songshui;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.songshui.handler.MyHandler;

public class JettyTest {
	public static void main(String[] args) throws Exception {
		// new ClassPathXmlApplicationContext("spring.xml");
		Server server = new Server();

		SelectChannelConnector connector = new SelectChannelConnector();
		connector.setPort(8080);
		server.addConnector(connector);

		WebAppContext context = new WebAppContext();

		// WebAppContext webContext = new WebAppContext("src/main/webapp", "/");
		// webContext.setDefaultsDescriptor("leopard-test/webdefault.xml");

		context.setContextPath("/");
		context.setDescriptor("WEB-INF/web.xml");
		context.setResourceBase("src/main/webapp");
		context.setConfigurationDiscovered(true);

		System.out.println(context.getContextPath());  
        System.out.println(context.getDescriptor());  
        System.out.println(context.getResourceBase());  
        System.out.println(context.getBaseResource());  
        System.out.println(context.getWar());  
        System.out.println(context.getDefaultsDescriptor());  
		// server.setHandler(new MyHandler());
		server.setHandler(context);
		server.start();
		server.join();
		//server.stop();
	}
}
