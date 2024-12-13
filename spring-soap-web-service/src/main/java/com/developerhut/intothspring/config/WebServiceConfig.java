package com.developerhut.intothspring.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageServletRegistrationBean(
			ApplicationContext applicationContext) {
		
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/calculatorws/*");
	}
	
	@Bean(name = "calculator")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema calculatorSchema) {
		
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setPortTypeName("CalculatorPort");
		defaultWsdl11Definition.setLocationUri("/calculatorws");
		defaultWsdl11Definition.setTargetNamespace("http://ws.intothespring.developerhut.com");
		defaultWsdl11Definition.setSchema(calculatorSchema);
		return defaultWsdl11Definition;
		
	}
	
	@Bean
	public XsdSchema calculatorSchema() {
		return new SimpleXsdSchema(new ClassPathResource("calculator.xsd"));
	}
	
}
