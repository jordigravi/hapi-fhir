package com.spring.hapi.fhir.springboothapifhir.config;

import com.spring.hapi.fhir.springboothapifhir.provider.PatientProvider;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.server.RestfulServer;
import lombok.RequiredArgsConstructor;

@WebServlet(urlPatterns = { "/fhir/*" }, displayName = "FHIR Server")
@Configuration
@RequiredArgsConstructor
public class FhirRestfulServerConfig extends RestfulServer
{
  private final ApplicationContext applicationContext;

  @Override
  protected void initialize() throws ServletException
  {
    super.initialize();
    //create a context for the appropriate version
    setFhirContext(FhirContext.forR4());
    setDefaultPrettyPrint(true);
    //Register Resource Providers
    setResourceProviders(List.of(
        applicationContext.getBean(PatientProvider.class)));

  }

}
