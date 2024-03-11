package com.example.cololux.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "appointment_id", length = 32 ,nullable = false)
    private String appointmentId;

    @Column(name = "name", length = 255,nullable = false)
    private String name;

    @Column(name = "nick_name", length = 10 ,nullable = false)
    private String nickName;

    @Column(name = "email", length = 30,nullable = false)
    private String email;

    @Column(name = "phone", length = 10,nullable = false)
    private String phone;

    @Column(name = "details", length = 255,nullable = false)
    private String details;

}
