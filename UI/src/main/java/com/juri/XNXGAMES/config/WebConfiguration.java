package com.juri.XNXGAMES.config;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer, 
											WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/img/**",
                "/css/**",
                "/js/**",
                "/fonts/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/",
                        "classpath:/static/fonts/");
    }
	
	@Override
    public void customize(TomcatServletWebServerFactory factory) {
		factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
			@Override
			public void customize(Connector connector) {
				connector.setAttribute("relaxedQueryChars", "<>[\\]^`{|}");
				connector.setParseBodyMethods("POST,PUT,DELETE");
			}
		});
//        factory.addConnectorCustomizers((TomcatConnectorCustomizer)
//                connector -> connector.setAttribute("relaxedQueryChars", "<>[\\]^`{|}"));
//        factory.addConnectorCustomizers((TomcatConnectorCustomizer)
//                connector -> connector.setParseBodyMethods("POST,PUT,DELETE"));
    }
	
//	@Bean
//	public ServletWebServerFactory servletContainer() {
//		return new TomcatServletWebServerFactory() {
//			@Override
//			protected void customizeConnector(Connector connector) {
//	               super.customizeConnector(connector);
//	               connector.setParseBodyMethods("POST,PUT,DELETE");
//			}
//		};
//	}

}
