package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.AppointmentEntity;

import java.util.List;

public interface IAppointmentService {
    public AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity);
    public List<AppointmentEntity> getAllAppointments();
    public AppointmentEntity getAppointmentById(Integer id);
}
