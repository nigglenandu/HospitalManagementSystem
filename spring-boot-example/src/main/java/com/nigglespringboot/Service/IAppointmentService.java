package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.AppointmentEntity;

import java.util.List;
import java.util.Optional;

public interface IAppointmentService {
    public AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity);
    public List<AppointmentEntity> getAllAppointments();
    public Optional<AppointmentEntity> getAppointmentById(Integer id);
}
