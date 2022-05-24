package com.vttp.HospitalDatabase.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.vttp.HospitalDatabase.models.Patient;
import static com.vttp.HospitalDatabase.models.ConversionUtils.*;
import static com.vttp.HospitalDatabase.repositories.Queries.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepo {
    
    @Autowired
    private JdbcTemplate template;

    public Optional<Patient> findPatientByEmail(String email) {
        final SqlRowSet rs = template.queryForRowSet(SQL_SELECT_PATIENT_BY_EMAIL, email);
        if (!rs.next())
            return Optional.empty();

        return Optional.of(convert(rs));
    }

    public boolean insertPatient(Patient patient) {
        int count = template.update(SQL_INSERT_PATIENT, patient.getEmail(), patient.getName()
                , patient.getPhone(), patient.getPrognosis(), patient.getAddress(), patient.getDob());
        return 1 == count;
    }

    public boolean deletePatientByEmail(String email) {
        int count = template.update(SQL_DELETE_PATIENT_BY_EMAIL, email);
        return 1 == count;
    }

    public List<Patient> selectAllPatients() {
        List<Patient> patients = new LinkedList<>();
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_ALL_PATIENT);
        while (rs.next()) {
            Patient patient = convert(rs);
            patients.add(patient);
        }
        return patients;
    }
}