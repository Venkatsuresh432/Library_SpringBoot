package com.Library.Mini.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	
	@Override
	public void addCorsMappings(CorsRegistry reg)
	{
		
//		reg.addMapping("/MemberList.html");
//		reg.addMapping("http://127.0.0.1:5500/");
		reg.addMapping("/**")
		.allowedOrigins("http://127.0.0.1:5500")
		.allowedMethods("GET","POST","PUT","DELETE")
		.allowedHeaders("*")
		.allowCredentials(true);
	}
}
