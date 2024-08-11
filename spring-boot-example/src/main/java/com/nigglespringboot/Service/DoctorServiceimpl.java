package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.DoctorEntity;
import com.nigglespringboot.Repository.DoctorRepo;
import com.nigglespringboot.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceimpl implements IDoctorService{

    @Autowired
    private DoctorRepo doctorRepo;

    public DoctorEntity saveDoctor(DoctorEntity doctorEntity){
        doctorRepo.save(doctorEntity);
        return doctorEntity;
    }

    public List<DoctorEntity> getAllDoctors(){
        doctorRepo.findAll();
        return doctorRepo.findAll();
    }

    public DoctorEntity getDoctorById(Integer id){
        Optional<DoctorEntity> optional = doctorRepo.findById(id);
        return optional.isPresent() ? optional.get():null;
    }



}

