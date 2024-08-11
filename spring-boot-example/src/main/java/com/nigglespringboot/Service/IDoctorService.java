package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.DoctorEntity;

import java.util.List;

public interface IDoctorService {


    public DoctorEntity saveDoctor(DoctorEntity doctorEntity);

    public List<DoctorEntity> getAllDoctors();

    public DoctorEntity getDoctorById(Integer id);
}
