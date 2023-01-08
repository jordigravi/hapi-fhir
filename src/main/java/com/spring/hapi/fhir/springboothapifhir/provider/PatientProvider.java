package com.spring.hapi.fhir.springboothapifhir.provider;

import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Component;

import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.server.IResourceProvider;

@Component
public class PatientProvider implements IResourceProvider
{
  @Override
  public Class<? extends IBaseResource> getResourceType()
  {
    return Patient.class;
  }

  @Read()
  public Patient read(@IdParam IdType patientID)
  {
    Patient patient = new Patient();
    patient.setId("12345");
    patient.addIdentifier().setSystem("urn:mrns").setValue("12345");

    return patient;

  }

}
