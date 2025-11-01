package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.DoctorEntity;

import java.util.List;
import java.util.Optional;

public interface IDoctorService {


    public DoctorEntity saveDoctor(DoctorEntity doctorEntity);

    public List<DoctorEntity> getAllDoctors();

    public Optional<DoctorEntity> getDoctorById(Integer id);
}
