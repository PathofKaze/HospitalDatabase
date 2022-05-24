package com.vttp.HospitalDatabase.controllers.Database;

import com.vttp.HospitalDatabase.models.Patient;
import com.vttp.HospitalDatabase.services.PatientService;
import com.vttp.HospitalDatabase.services.PatientException;
import static com.vttp.HospitalDatabase.models.ConversionUtils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path={"/database", "/Database.html"})
public class DatabaseController {

    @Autowired
    private PatientService patientSvc;

    @PostMapping
    public ModelAndView postPatient(@RequestBody MultiValueMap<String, String> form) {

        Patient patient = convert(form);

        System.out.println(">>>>>> patient: " + patient);

        ModelAndView mvc = new ModelAndView();

        try {
            patientSvc.addNewPatient(patient);
            mvc.addObject("message", "%s has been added as one of your patients".formatted(patient.getName()));
            mvc.addObject("patients", patientSvc.getAllPatients());
        } catch (PatientException ex) {
            mvc.addObject("message", "Error: %s".formatted(ex.getReason()));
            mvc.setStatus(HttpStatus.BAD_REQUEST);
            ex.printStackTrace();
        }

        mvc.setViewName("database");

        return mvc;
    }
}