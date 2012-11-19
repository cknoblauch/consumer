package com.ftp.server;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.impl.DefaultFtpServer;
import org.apache.ftpserver.impl.FtpServerContext;

public class TestServer {
	public static void main(String[] args) throws Exception {
		// int maxLogins = 10;
		// boolean anonymousLoginEnabled = true;
		// int maxAnonymousLogins = 10;
		// int maxLoginFailures = 3;
		// int loginFailureDelay = 500;
		// int maxThreads = 0;

		// ListenerFactory listenerFactory = new ListenerFactory();
		// listenerFactory.setPort(20);
		// listenerFactory.setServerAddress("localhost");
		//
		// Listener listener = listenerFactory.createListener();

		FtpServerContext serverContext = new CustomFtpServerContext();

		// Listener listener = context.getListener("default");
		//
		// Map<String, Listener> listeners = context.getListeners();
		// Set<Entry<String, Listener>> entrySet = listeners.entrySet();
		// for (Entry<String, Listener> entry : entrySet) {
		// System.out.println(entry.getKey() + ": " + entry.getValue());
		// }

		// ConnectionConfig connectionConfig = new DefaultConnectionConfig(anonymousLoginEnabled, loginFailureDelay,
		// maxLogins, maxAnonymousLogins, maxLoginFailures, maxThreads);

		FtpServer ftpServer = new DefaultFtpServer(serverContext);
		ftpServer.start();

	}
}
