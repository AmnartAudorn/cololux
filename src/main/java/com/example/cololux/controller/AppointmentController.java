package com.example.cololux.controller;

import com.example.cololux.dto.AppointmentDto;
import com.example.cololux.entity.Appointment;
import com.example.cololux.respository.AppointmentRepository;
import com.example.cololux.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/get/appointment")
    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }
    @PostMapping("/create/appointment")
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        AppointmentDto aDto = appointmentService.saveAppointment(appointmentDto);
        return new ResponseEntity<>(aDto, HttpStatus.OK);
    }
}
