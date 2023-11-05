package edu.metrostate.ics625.courses;

import org.springframework.beans.factory.annotation.Autowired;
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

/**
 *
 * @author Tom Coffee
 */
@EnableWs
@Configuration
public class WsConfig extends WsConfigurerAdapter {
  
  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatchServlet(
          @Autowired ApplicationContext ctx){
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(ctx);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<>(servlet, "/ws/*");
  }

  @Bean(name="courses")
  public DefaultWsdl11Definition defaultWsdl11Definition(@Autowired XsdSchema xsd){
    DefaultWsdl11Definition def = new DefaultWsdl11Definition();
    def.setPortTypeName("CoursePort");
    def.setLocationUri("/ws");
    def.setTargetNamespace(CourseEndpoint.NS);
    def.setSchema(xsd);
    return def;
  }
  
  @Bean
  public XsdSchema xsdSchema(){
    return new SimpleXsdSchema(new ClassPathResource("courses-service.xsd"));
  }
  
}
