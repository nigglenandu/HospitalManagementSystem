package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.AppointmentEntity;
import com.nigglespringboot.Repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements IAppointmentService{

    @Autowired
    AppointmentRepo appointmentRepo;

    public AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity){
        appointmentRepo.save(appointmentEntity);
        return appointmentEntity;
    }

    public List<AppointmentEntity> getAllAppointments(){
        return appointmentRepo.findAll();
    }

    public AppointmentEntity getAppointmentById(Integer id){
        Optional<AppointmentEntity> optional = appointmentRepo.findById(id);
        return optional.isPresent()?optional.get():null;
    }
}
