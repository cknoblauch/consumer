package com.ml.consumer

import com.ml.downloader.Downloader
import com.ml.downloader.FtpDownloader
import grails.spring.BeanBuilder
import org.springframework.context.ApplicationContext

class Consumer {

	static main(args) {
//		def config = new ConfigSlurper().parse(new File('src/main/resources/config.groovy').toURI().toURL())
//		println config.downloader.ftp.host
//		def ftpDownloader = new FtpDownloader()
//		ftpDownloader.download();

		def bb = new BeanBuilder()

		//beansBuilder.importBeans("resources.groovy");
		bb.loadBeans("classpath:*resources.groovy");

		ApplicationContext context = bb.createApplicationContext()

		context.getBean(FtpDownloader.class)



	}
}
