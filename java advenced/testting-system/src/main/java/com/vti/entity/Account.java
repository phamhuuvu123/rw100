package com.vti.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="account")// mapping den bang database
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name="account_id")
    private Integer id;
    @Column(name="username",nullable = false,unique = true,length = 100)
    private String username;
    @Column(name="email",nullable = false,unique = true,length = 100)
    private String email;
    @Column(name="full_name",nullable = false,unique = true,length = 100)
    private String fullName;
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;
    @Column(name = "create_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name="position_id")
    private Position position;
}
