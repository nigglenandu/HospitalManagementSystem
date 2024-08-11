package com.nigglespringboot.Controller;

import com.nigglespringboot.Entity.AppointmentEntity;
import com.nigglespringboot.Service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ReceptionController{

    @Autowired
    private IAppointmentService appointmentService;

    @PostMapping("saveappointment")
    public AppointmentEntity saveAppointment(@RequestBody AppointmentEntity appointmentEntity){
        AppointmentEntity ae = appointmentService.saveAppointment(appointmentEntity);
            return ae;
    }

    @GetMapping("getallappointments")
    public List<AppointmentEntity> getAllAppointments(){
        List<AppointmentEntity> list = appointmentService.getAllAppointments();
        return list;
    }

    @GetMapping("getappointmentbyid")
    public ResponseEntity<AppointmentEntity> getAppointmentById(@PathVariable Integer id){
        AppointmentEntity ae = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok(ae);
    }
}
