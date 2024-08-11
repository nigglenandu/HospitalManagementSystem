package com.nigglespringboot.Service;


import com.nigglespringboot.Entity.PatientEntity;

import java.util.List;

public interface IPatientService {
    public PatientEntity savePatient(PatientEntity patient);
    public List<PatientEntity> getAllPatients();
    public PatientEntity getPatientById(Integer id);
}
