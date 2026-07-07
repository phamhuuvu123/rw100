package com.vti.entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="department")// mapping den bang database
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name="department_id")
    private Integer id;
    @Column(name="department_name",nullable = false,unique = true,length = 100)
    private String name;

}
