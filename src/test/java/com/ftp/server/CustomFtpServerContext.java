package com.ftp.server;

import org.apache.ftpserver.impl.DefaultFtpServerContext;
import org.apache.ftpserver.listener.ListenerFactory;

public class CustomFtpServerContext extends DefaultFtpServerContext {

	public CustomFtpServerContext() {
		ListenerFactory listenerFactory = new ListenerFactory();
		listenerFactory.setPort(9090);
		listenerFactory.setServerAddress("localhost");

		addListener("default", listenerFactory.createListener());
	}

}
