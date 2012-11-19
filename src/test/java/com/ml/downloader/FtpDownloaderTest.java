package com.ml.downloader;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.UserAccount;
import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;

public class FtpDownloaderTest {

	@Before
	public void setup() {
		String resources = new File("src/test/resources").getAbsolutePath();

		FakeFtpServer fakeFtpServer = new FakeFtpServer();
		fakeFtpServer.setServerControlPort(2121);
		fakeFtpServer.addUserAccount(new UserAccount("test", "test", resources));

		FileSystem fileSystem = new UnixFakeFileSystem();
		fileSystem.add(new DirectoryEntry(resources));
		fileSystem.add(new FileEntry(resources + "/config.xml"));
		fakeFtpServer.setFileSystem(fileSystem);

		fakeFtpServer.start();
	}

	@Test
	public void test() {
		FtpDownloader ftpDownloader = new FtpDownloader();
		// ftpDownloader.setRepository(new Queue());
		// ftpDownloader.setRepository(new Folder());
		// ftpDownloader.setRepository(new Folder());
		ftpDownloader.download();
	}

}
