package com.vttp.HospitalDatabase.repositories;

public interface Queries {

    public static final String SQL_SELECT_PATIENT_BY_EMAIL = "select * from bff where email = ?";

    public static final String SQL_INSERT_PATIENT = 
        "insert into bff (email, name, phone, prognosis, address, dob) values (?, ?, ?, ?, sha1(?), ?)";

    public static final String SQL_SELECT_ALL_PATIENT = 
        "select email, name, phone, status, dob from patient order by name";

    public static final String SQL_DELETE_PATIENT_BY_EMAIL =
        "delete from patient where email = ?";

}