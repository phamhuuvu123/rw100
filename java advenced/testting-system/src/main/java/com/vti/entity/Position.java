package com.vti.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="position")// mapping den bang database
@ToString
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="position_id")
    private Integer id;
    @Column(name="position_name",nullable = false,length = 100)
    @Enumerated(EnumType.STRING)
    private positionName name;
}
