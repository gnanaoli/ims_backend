package com.fa.inventory.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.fa.inventory")
@Import({ SpringSecurityConfig.class, SpringConfig.class })
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.TEXT_HTML);
	}

	/*
	 * Configure ContentNegotiatingViewResolver
	 */
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
		resolvers.add(jspViewResolver());
		resolver.setViewResolvers(resolvers);
		return resolver;
	}

	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/app/js/**").addResourceLocations("/app/js/");
		registry.addResourceHandler("/resources/css/**").addResourceLocations("/resources/css/");
		registry.addResourceHandler("/resources/js/**").addResourceLocations("/resources/js/");
		registry.addResourceHandler("/resources/constant/**").addResourceLocations("/resources/constant/");
		registry.addResourceHandler("/resources/pages/**").addResourceLocations("/resources/pages/");
		registry.addResourceHandler("/resources/images/**").addResourceLocations("/resources/images/");
		registry.addResourceHandler("/resources/fonts/**").addResourceLocations("/resources/fonts/");
		registry.addResourceHandler("/resources/services/**").addResourceLocations("/resources/services/");
		registry.addResourceHandler("/resources/controllers/**").addResourceLocations("/resources/controllers/");
        registry.addResourceHandler("/resources/img/**").addResourceLocations("/resources/img/");
        
        registry.addResourceHandler("/resources/css1/**").addResourceLocations("/resources/css1/");
        registry.addResourceHandler("/resources/js1/**").addResourceLocations("/resources/js1/");
        registry.addResourceHandler("/resources/img1/**").addResourceLocations("/resources/img1/");
        registry.addResourceHandler("/resources/table1/**").addResourceLocations("/resources/table1/");
        registry.addResourceHandler("/resources/fonts1/**").addResourceLocations("/resources/fonts1/");
        registry.addResourceHandler("/resources/select/**").addResourceLocations("/resources/select/");
        registry.addResourceHandler("/resources/login/**").addResourceLocations("/resources/login/");
	}

}
