package com.nigglespringboot.Controller;

import com.nigglespringboot.Entity.AppointmentEntity;
import com.nigglespringboot.Entity.DoctorEntity;
import com.nigglespringboot.Entity.PatientEntity;
import com.nigglespringboot.Entity.ReceptionEntity;
import com.nigglespringboot.Service.IAppointmentService;
import com.nigglespringboot.Service.IDoctorService;
import com.nigglespringboot.Service.IPatientService;
import com.nigglespringboot.Service.IReceptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final IDoctorService doctorService;
    private final IReceptionService receptionService;
    private final IPatientService patientService;
    private final IAppointmentService appointmentService;

    public AdminController(IAppointmentService appointmentService, IDoctorService doctorService, IReceptionService receptionService, IPatientService patientService) {
        this.appointmentService = appointmentService;
        this.doctorService = doctorService;
        this.receptionService = receptionService;
        this.patientService = patientService;
    }

    @PostMapping("/doctors")
    public ResponseEntity<DoctorEntity> createDoctor(@RequestBody DoctorEntity doctorEntity) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(doctorService.saveDoctor(doctorEntity));
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorEntity>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<DoctorEntity> getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/receptions")
    public ResponseEntity<ReceptionEntity> createReception(@RequestBody ReceptionEntity receptionEntity) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(receptionService.saveReception(receptionEntity));
    }

    @GetMapping("/receptions")
    public ResponseEntity<List<ReceptionEntity>> getAllReceptions() {
        return ResponseEntity.ok(receptionService.getAllReceptions());
    }

    @GetMapping("/receptions/{id}")
    public ResponseEntity<ReceptionEntity> getReceptionById(@PathVariable Integer id) {
        return receptionService.getReceptionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientEntity> createPatient(@RequestBody PatientEntity patientEntity) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(patientService.savePatient(patientEntity));
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientEntity>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientEntity> getPatientById(@PathVariable Integer id) {
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentEntity> createAppointment(@RequestBody AppointmentEntity appointmentEntity) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appointmentService.saveAppointment(appointmentEntity));
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentEntity>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<AppointmentEntity> getAppointmentById(@PathVariable Integer id) {
        return appointmentService.getAppointmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
