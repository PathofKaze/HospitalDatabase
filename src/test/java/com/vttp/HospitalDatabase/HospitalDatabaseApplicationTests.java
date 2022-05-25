package com.vttp.HospitalDatabase;

import java.util.Calendar;

import com.vttp.HospitalDatabase.models.Patient;
import com.vttp.HospitalDatabase.repositories.PatientRepo;
import com.vttp.HospitalDatabase.services.PatientException;
import com.vttp.HospitalDatabase.services.PatientService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalDatabaseApplicationTests {

	@Autowired
	private PatientService patientSvc;

	@Autowired
	private PatientRepo patientRepo;

	private Patient barney;

	public HospitalDatabaseApplicationTests() {
		barney = new Patient();
		barney.setName("barney");
		barney.setEmail("barney@gmail.com");
		barney.setPhone("555-12345");
		barney.setPrognosis("Leukemia");

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.YEAR, 1970);
		barney.setDob(cal.getTime());
	}

	@BeforeEach
	public void setup() {
		patientRepo.insertPatient(barney);
	}

	@AfterEach
	public void tearDown() {
		patientRepo.deletePatientByEmail(barney.getEmail());
	}

	@Test
	void insertBarneyShouldFail() {
		try {
			patientSvc.addNewPatient(barney);
		} catch (PatientException ex) {
			assertTrue(true);
			return;
		}

		fail("Did not throw PatientException when email exists");
	}
}