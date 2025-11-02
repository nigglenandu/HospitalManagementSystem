package com.nigglespringboot.Controller;

import com.nigglespringboot.Entity.PatientEntity;
import com.nigglespringboot.Service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    private final IPatientService patientService;

    @Autowired
    public DoctorController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientEntity> createPatient(@RequestBody PatientEntity patientEntity) {
        PatientEntity savedPatient = patientService.savePatient(patientEntity);
        return ResponseEntity.ok(savedPatient);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientEntity>> getAllPatients() {
        List<PatientEntity> patients = patientService.getAllPatients();
        if (patients.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientEntity> getPatientById(@PathVariable Integer id) {
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
