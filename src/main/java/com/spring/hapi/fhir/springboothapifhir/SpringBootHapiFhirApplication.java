package com.spring.hapi.fhir.springboothapifhir;

import com.spring.hapi.fhir.springboothapifhir.config.FhirRestfulServerConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootHapiFhirApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(SpringBootHapiFhirApplication.class, args);
  }

  @Bean
  public ServletRegistrationBean<FhirRestfulServerConfig> servletRegistrationBean(ApplicationContext context)
  {
    ServletRegistrationBean<FhirRestfulServerConfig> registration = new ServletRegistrationBean<>(new FhirRestfulServerConfig(context), "/fhir/*");
    registration.setName("FhirServlet");
    return registration;
  }

}
