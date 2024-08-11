package com.nigglespringboot.Controller;

import com.nigglespringboot.Entity.DoctorEntity;
import com.nigglespringboot.Entity.PatientEntity;
import com.nigglespringboot.Service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    private IPatientService patientService;

    @PostMapping("savepatient")
    public PatientEntity savepatient(@RequestBody PatientEntity patientEntity){
        PatientEntity pe = patientService.savePatient(patientEntity);
        return pe;
    }

   @GetMapping("getpatients")
    public List<PatientEntity> getAllPatients(PatientEntity patientEntity){
       List<PatientEntity> list = patientService.getAllPatients();
       return list;
   }

   @GetMapping("/getpatientbyid/{id}")
    public ResponseEntity<PatientEntity> getPatientById(@PathVariable Integer id){
       PatientEntity pe = patientService.getPatientById(id);
       return ResponseEntity.ok(pe);
   }


}
