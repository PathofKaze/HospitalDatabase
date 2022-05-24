package com.vttp.HospitalDatabase.services;

public class PatientException extends Exception {
    
    private String reason;

    public PatientException(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
    
}