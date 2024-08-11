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

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private IDoctorService doctorService;

    @Autowired
    private IReceptionService receptionService;

    @Autowired
    private IPatientService patientService;

    @Autowired
    private IAppointmentService appointmentService;

    @PostMapping("/savedoctorfrmadmin")
    public DoctorEntity saveDoctor(@RequestBody DoctorEntity doctorEntity){
      DoctorEntity dt = doctorService.saveDoctor(doctorEntity);
      return dt;
    }

    @GetMapping("/viewdoctorfrmadmin")
    public List<DoctorEntity> getAllDoctors(){
        List<DoctorEntity> list = doctorService.getAllDoctors();
        return list;
    }

    @GetMapping("/getdoctorbyidfrmadmin/{id}")
        public ResponseEntity<DoctorEntity> getDoctorById(@PathVariable Integer id){
        DoctorEntity dt = doctorService.getDoctorById(id);
        return ResponseEntity.ok(dt);
    }


    @PostMapping("/addreceptitonfrmadmin")
    public ReceptionEntity saveReception(@RequestBody ReceptionEntity receptionEntity){
        ReceptionEntity re = receptionService.saveReception(receptionEntity);
        return re;
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
