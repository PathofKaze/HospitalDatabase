package com.vttp.HospitalDatabase.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.util.MultiValueMap;

public class ConversionUtils {

    public static Patient convert(MultiValueMap<String, String> form) {
        Patient patient = new Patient();
        patient.setEmail(form.getFirst("email"));
        patient.setName(form.getFirst("name"));
        patient.setPhone(form.getFirst("phone"));
        patient.setPrognosis(form.getFirst("prognosis"));
        patient.setAddress(form.getFirst("address"));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dob = format.parse(form.getFirst("dob"));
            patient.setDob(dob);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return patient;
    }

    public static Patient convert(SqlRowSet rs) {
        Patient patient = new Patient();
        patient.setEmail(rs.getString("email"));
        patient.setName(rs.getString("name"));
        patient.setPhone(rs.getString("phone"));
        patient.setPrognosis(rs.getString("status"));
        patient.setDob(rs.getDate("dob"));
        return patient;
    }
    
}