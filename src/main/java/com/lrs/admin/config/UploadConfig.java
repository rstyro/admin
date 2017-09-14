package com.lrs.admin.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadConfig {

	@Value("${upload.root.folder}")
	public String locatFolder;
	
	/**
	 * 这个bean是为了自定义上传路径
	 * @return
	 */
	@Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(locatFolder);
        return factory.createMultipartConfig();
    }
}
