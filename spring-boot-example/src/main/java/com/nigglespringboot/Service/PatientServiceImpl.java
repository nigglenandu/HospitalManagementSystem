package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.PatientEntity;
import com.nigglespringboot.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public Optional<PatientEntity> getPatientById(Integer id){
        return patientRepo.findById(id);
    }



}
