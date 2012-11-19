import com.ml.downloader.FtpDownloader

beans = {
	
	downloader(FtpDownloader) {
		host = "localhost"
		port = 2121
		username = "test"
		password = "test"
	}
	
}