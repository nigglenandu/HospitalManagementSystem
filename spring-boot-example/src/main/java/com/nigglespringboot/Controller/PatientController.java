package com.nigglespringboot.Controller;

import com.nigglespringboot.Entity.AppointmentEntity;
import com.nigglespringboot.Service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private IAppointmentService appointmentService;

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentEntity> saveAppointment(@RequestBody AppointmentEntity appointmentEntity) {
        AppointmentEntity savedAppointment = appointmentService.saveAppointment(appointmentEntity);
        return ResponseEntity.ok(savedAppointment);
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentEntity>> getAllAppointments() {
        List<AppointmentEntity> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<AppointmentEntity> getAppointmentById(@PathVariable Integer id) {
        return appointmentService.findAppointmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
