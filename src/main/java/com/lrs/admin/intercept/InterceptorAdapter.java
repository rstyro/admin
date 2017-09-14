package com.lrs.admin.intercept;


import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorAdapter extends WebMvcConfigurerAdapter {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("拦截");
		registry.addInterceptor(new UrlInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("/","/login","/logout","/toLogin","/error/**","/upload/show/**");
		super.addInterceptors(registry);
	}
}
