package com.spring.hapi.fhir.springboothapifhir.provider;

import com.spring.hapi.fhir.springboothapifhir.config.RestAssuredConfig;

import org.hl7.fhir.r4.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class PatientProviderTest extends RestAssuredConfig
{

  @Test
  void testGetPatient()
  {
    String patientID = "12345";

    String response =
        given()
            .pathParam("patientID", patientID)
            .when()
            .get("Patient/{patientID}")
            .then()
            .statusCode(HttpStatus.OK.value())
            .extract().asString();

    Patient patient = parser.parseResource(Patient.class, response);
    Assertions.assertEquals("Patient/" + patientID, patient.getId(), "Patient ID");
  }

}
