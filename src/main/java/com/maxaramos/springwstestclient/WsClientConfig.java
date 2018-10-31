package com.maxaramos.springwstestclient;

import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

@Configuration
public class WsClientConfig {

	@Bean
	public WebServiceTemplate webServiceTemplate(WebServiceTemplateBuilder builder) {
		return builder
			.setMarshaller(jaxb2Marshaller())
			.setUnmarshaller(jaxb2Marshaller())
			.setDefaultUri("http://localhost:8080/services")
			.interceptors(new ClientInterceptor[] { securityInterceptor() })
			.build();
	}

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPaths("com.maxaramos.springwstest.user", "com.maxaramos.springwstest.address");
		return jaxb2Marshaller;
	}

	@Bean
	public Wss4jSecurityInterceptor securityInterceptor() {
		Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
		securityInterceptor.setSecurementActions("UsernameToken");
		securityInterceptor.setSecurementUsername("mramos");
		securityInterceptor.setSecurementPassword("changeit");
		return securityInterceptor;
	}

	@Bean
	public com.maxaramos.springwstest.user.ObjectFactory userObjectFactory() {
		return new com.maxaramos.springwstest.user.ObjectFactory();
	}

	@Bean
	public com.maxaramos.springwstest.address.ObjectFactory addressObjectFactory() {
		return new com.maxaramos.springwstest.address.ObjectFactory();
	}

}
