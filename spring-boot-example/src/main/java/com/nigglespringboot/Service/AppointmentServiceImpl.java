package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.AppointmentEntity;
import com.nigglespringboot.Repository.AppointmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AppointmentServiceImpl implements IAppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Override
    public AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity) {
        log.info("Saving new appointment: {}", appointmentEntity);
        AppointmentEntity saved = appointmentRepo.save(appointmentEntity);
        log.debug("Appointment saved successfully with ID: {}", saved.getId());
        return saved;
    }

    @Override
    public List<AppointmentEntity> getAllAppointments() {
        log.info("Fetching all appointments");
        List<AppointmentEntity> list = appointmentRepo.findAll();
        log.debug("Total appointments found: {}", list.size());
        return list;
    }

    @Override
    public Optional<AppointmentEntity> getAppointmentById(Integer id) {
        log.info("Fetching appointment by ID: {}", id);
        Optional<AppointmentEntity> appointment = appointmentRepo.findById(id);

        if (appointment.isPresent()) {
            log.debug("Appointment found: {}", appointment.get());
        } else {
            log.warn("No appointment found with ID: {}", id);
        }

        return appointment;
    }
}
