package com.maxaramos.springwstestclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class WebServiceClientConfig {

	@Bean
	public WebServiceTemplate webServiceTemplate() {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		webServiceTemplate.setMarshaller(jaxb2Marshaller());
		webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
		webServiceTemplate.setDefaultUri("http://localhost:8080/services");
		return webServiceTemplate;
	}

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPaths("com.maxaramos.springwstest.user", "com.maxaramos.springwstest.address");
		return jaxb2Marshaller;
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
