package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.PatientEntity;
import com.nigglespringboot.Repository.PatientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Override
    public PatientEntity savePatient(PatientEntity patientEntity) {
        log.info("Saving new patient: {}", patientEntity);
        PatientEntity savedPatient = patientRepo.save(patientEntity);
        log.debug("Patient saved successfully with ID: {}", savedPatient.getId());
        return savedPatient;
    }

    @Override
    public List<PatientEntity> getAllPatients() {
        log.info("Fetching all patients");
        List<PatientEntity> patients = patientRepo.findAll();
        log.debug("Total patients found: {}", patients.size());
        return patients;
    }

    @Override
    public Optional<PatientEntity> getPatientById(Integer id) {
        log.info("Fetching patient by ID: {}", id);
        Optional<PatientEntity> patient = patientRepo.findById(id);

        if (patient.isPresent()) {
            log.debug("Patient found: {}", patient.get());
        } else {
            log.warn("No patient found with ID: {}", id);
        }

        return patient;
    }
}
