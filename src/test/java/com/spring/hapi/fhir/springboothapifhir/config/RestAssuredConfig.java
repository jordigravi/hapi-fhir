package com.spring.hapi.fhir.springboothapifhir.config;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestAssuredConfig
{
  protected static final String APPLICATION_FHIR_JSON_CHARSET_UTF_8 = "application/fhir+json;charset=UTF-8";
  private final FhirContext fhirContext = FhirContext.forR4();
  protected final IParser parser = fhirContext.newJsonParser();

  @LocalServerPort
  private int port;

  @BeforeEach
  public void configureRestAssured()
  {
    RestAssured.port = port;
    RestAssured.basePath = "fhir";
  }

}
