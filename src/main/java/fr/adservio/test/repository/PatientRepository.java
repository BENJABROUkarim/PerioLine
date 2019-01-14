package fr.adservio.test.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.adservio.test.model.Patient;

public interface PatientRepository extends MongoRepository<Patient, String> {
	
	List<Patient> findByFirstNameAndLastNameAndBirthDate(String firstName, String lastName, LocalDate birthDate);
}
