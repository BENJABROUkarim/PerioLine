package fr.adservio.test;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private PatientRepository patientRepository;

	@GetMapping(value = "/patients")
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	@GetMapping("/patients/{patientId}")
	public Optional<Patient> getPatient(@PathVariable int patientId) {

		return patientRepository.findById(patientId);
	}

	@DeleteMapping("/patients/{patientId}")
	public void deletePatient(@PathVariable int patientId) {

		patientRepository.deleteById(patientId);
	}
}
