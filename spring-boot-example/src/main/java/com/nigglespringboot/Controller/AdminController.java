package com.nigglespringboot.Controller;

import com.nigglespringboot.Entity.AppointmentEntity;
import com.nigglespringboot.Entity.DoctorEntity;
import com.nigglespringboot.Entity.PatientEntity;
import com.nigglespringboot.Entity.ReceptionEntity;
import com.nigglespringboot.Service.IAppointmentService;
import com.nigglespringboot.Service.IDoctorService;
import com.nigglespringboot.Service.IPatientService;
import com.nigglespringboot.Service.IReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final IDoctorService doctorService;
    private final IReceptionService receptionService;
    private final IPatientService patientService;
    private final IAppointmentService appointmentService;

    public AdminController(IDoctorService doctorService, IReceptionService receptionService, IPatientService patientService, IAppointmentService appointmentService) {
        this.doctorService = doctorService;
        this.receptionService = receptionService;
        this.patientService = patientService;
        this.appointmentService = appointmentService;
    }

    @PostMapping("/doctors")
    public ResponseEntity<DoctorEntity> createDoctor(@RequestBody DoctorEntity doctorEntity) {
        return ResponseEntity.ok(doctorService.saveDoctor(doctorEntity));
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorEntity>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<DoctorEntity> getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/reception")
    public ResponseEntity<ReceptionEntity> saveReception(@RequestBody ReceptionEntity receptionEntity){
        return ResponseEntity.ok(receptionService.saveReception(receptionEntity));
    }

    @GetMapping("/getallreceptionsfrmadmin")
    public List<ReceptionEntity> getAllReceptions(){
        List<ReceptionEntity> list = receptionService.getAllReceptions();
        return list;
    }

    @GetMapping("/getreceptiobyidfrmadmin/{id}")
    public ResponseEntity<ReceptionEntity> getReceptionById(@PathVariable Integer id){
        ReceptionEntity re = receptionService.getReceptionById(id);
        return ResponseEntity.ok(re);
    }

    @PostMapping("/savepatientfrmadmin")
    public PatientEntity savePatient(@RequestBody PatientEntity patientEntity){
        PatientEntity pe = patientService.savePatient(patientEntity);
        return pe;
    }

    @GetMapping("getallpatientsfrmadmin")
    public List<PatientEntity> getAllPatients(){
        List<PatientEntity> list = patientService.getAllPatients();
        return list;
    }

    @GetMapping("getpatientbyidfrmadmin/{id}")
    public ResponseEntity<PatientEntity> getPatientById(@PathVariable Integer id){
        PatientEntity pe = patientService.getPatientById(id);
        return ResponseEntity.ok(pe);
    }

    @PostMapping("saveappointmentfrmadmin")
    public AppointmentEntity saveAppointment(@RequestBody AppointmentEntity appointmentEntity) {
        AppointmentEntity ae = appointmentService.saveAppointment(appointmentEntity);
        return ae;
    }

    @GetMapping("getallappointmentsfrmadmin")
    public List<AppointmentEntity> getAllAppointments(){
        List<AppointmentEntity> list = appointmentService.getAllAppointments();
        return list;
    }

    @GetMapping("getappointmentbyidfrmadmin/{id}")
    public ResponseEntity<AppointmentEntity> getAppointmentById(@PathVariable Integer id){
        AppointmentEntity ae = appointmentService.getAppointmentById(id);
                return ResponseEntity.ok(ae);
    }
}
