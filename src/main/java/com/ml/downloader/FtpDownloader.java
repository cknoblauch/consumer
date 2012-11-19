package com.ml.downloader;

import java.io.IOException;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FtpDownloader implements Downloader {
	private static final Logger log = LoggerFactory.getLogger(FtpDownloader.class);

	private String host = "localhost";

	private int port = 2121;

	private String username = "test";

	private String password = "test";

	@Override
	public void download() {

		try {
			FTPClient ftp = new FTPClient();
			ftp.connect(host, port);
			ftp.login(username, new String(password));
			FTPFile[] files = ftp.listFiles();

			for (FTPFile ftpFile : files) {
				log.debug(ftpFile.getName());

				ExecutorService executorService = Executors.newFixedThreadPool(10);
				executorService.execute(new Runnable() {
					@Override
					public void run() {
						// Sender.send(ftpFile, "cust_id", "date", "xxx");
					}
				});

			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
