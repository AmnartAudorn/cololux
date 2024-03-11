package com.example.cololux.service;


import com.example.cololux.dto.AppointmentDto;
import com.example.cololux.entity.Appointment;
import com.example.cololux.respository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;
    public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        if(StringUtils.hasText(appointmentDto.getAppointmentId())){
            appointment = appointmentRepository.findById(appointmentDto.getAppointmentId()).orElse(appointment);
        }
        appointment.setName(appointmentDto.getName());
        appointment.setNickName(appointmentDto.getNickName());
        appointment.setEmail(appointmentDto.getEmail());
        appointment.setDetails(appointmentDto.getDetails());
        appointment.setPhone(appointmentDto.getPhone());
        appointment = appointmentRepository.save(appointment);
        appointmentDto.setAppointmentId(appointment.getAppointmentId());
        return appointmentDto;
    }
}
