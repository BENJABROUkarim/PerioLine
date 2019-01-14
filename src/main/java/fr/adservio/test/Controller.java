package fr.adservio.test;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adservio.test.model.Patient;
import fr.adservio.test.repository.PatientRepository;
import fr.adservio.test.service.PatientService;

@RestController
public class Controller {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientService patientService;

	@GetMapping("/patients/{patientId}")
	public Optional<Patient> getPatient(@PathVariable String patientId) {

		return patientRepository.findById(patientId);
	}

	@DeleteMapping("/patients/{patientId}")
	public void deletePatient(@PathVariable String patientId) {

		patientRepository.deleteById(patientId);
	}

	@PostMapping("/patient")
	public Object createPatient(@RequestBody Patient patient) {
		return patientService.createPatient(patient);
	}

	@GetMapping("/patients")
	public List<Patient> getPatientByParam(@RequestParam(required = false) String param) {
		return patientService.getPatientByParam(param);
	}
	
}
