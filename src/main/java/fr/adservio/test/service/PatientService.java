package fr.adservio.test.service;

import java.util.List;

import fr.adservio.test.model.Patient;

public interface PatientService {
	List<Patient> getPatientByParam(String param);
	
	Object createPatient(Patient patient);
	
	Object modifyPatient(Patient patient);
}
