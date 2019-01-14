package fr.adservio.test.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adservio.test.exception.Exception;
import fr.adservio.test.model.Patient;
import fr.adservio.test.repository.PatientRepository;
import fr.adservio.test.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Patient> getPatientByParam(String param) {
		if (param == null)
			return patientRepository.findAll();
		else {

			List<Patient> filtredList = patientRepository.findAll().stream()
					.filter(patient -> patient.getAddress().contains(param) || patient.getPhoneNumber().contains(param)
							|| patient.getEmail().contains(param) || patient.getEmail().contains(param)
							|| String.valueOf(patient.getAge()).contains(param))
					.collect(Collectors.toList());
			return filtredList;
		}
	}

	@Override
	public Object createPatient(Patient patient) {
		if (patientRepository.findByFirstNameAndLastNameAndBirthDate(patient.getFirstName(), patient.getLastName(),
				patient.getBirthDate()).size() != 0) {
			return new Exception("Ce patient existe déjà");

		} else {
			if (patient.getCivility() == null || patient.getFirstName() == null || patient.getLastName() == null
					|| patient.getBirthDate() == null) {
				return new Exception("Vous devez remplir tous les champs obligatoires");
			}
			Long age = ChronoUnit.YEARS.between(patient.getBirthDate(), LocalDate.now());
			patient.setAge(age.intValue());
			return patientRepository.save(patient);
		}

	}

	@Override
	public Object modifyPatient(Patient patient) {
		return null;
	}

}
