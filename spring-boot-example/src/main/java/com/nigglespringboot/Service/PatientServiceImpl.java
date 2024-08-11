package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.PatientEntity;
import com.nigglespringboot.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements IPatientService {
    @Autowired
    private PatientRepo patientRepo;

    public PatientEntity savePatient(PatientEntity patientEntity){
        patientRepo.save(patientEntity);
        return patientEntity;
    }

    public List<PatientEntity> getAllPatients(){
       return patientRepo.findAll();
    }

    public PatientEntity getPatientById(Integer id){
        Optional<PatientEntity> optional = patientRepo.findById(id);
        return optional.isPresent() ? optional.get():null;
    }



}
