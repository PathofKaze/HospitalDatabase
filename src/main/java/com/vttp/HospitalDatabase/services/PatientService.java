package com.vttp.HospitalDatabase.services;

import java.util.List;
import java.util.Optional;

import com.vttp.HospitalDatabase.models.Patient;
import com.vttp.HospitalDatabase.repositories.PatientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    
    @Autowired
    private PatientRepo patientRepo;

    public void addNewPatient(Patient patient) throws PatientException {

        Optional<Patient> opt = patientRepo.findPatientByEmail(patient.getEmail());
        if (opt.isPresent())
            throw new PatientException("%s is already your patient".formatted(patient.getName()));

        if (!patientRepo.insertPatient(patient))
            throw new PatientException("Cannot add %s as patient. Please check with admin".formatted(patient.getEmail()));
    }

    public List<Patient> getAllPatients() {
        return patientRepo.selectAllPatients();
    }
    
}