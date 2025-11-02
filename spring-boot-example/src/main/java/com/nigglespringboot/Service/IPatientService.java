package com.nigglespringboot.Service;


import com.nigglespringboot.Entity.PatientEntity;

import java.util.List;
import java.util.Optional;

public interface IPatientService {
    public PatientEntity savePatient(PatientEntity patient);
    public List<PatientEntity> getAllPatients();
    public Optional<PatientEntity> getPatientById(Integer id);
}
