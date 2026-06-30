package com.vti.enitity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="position_id")
    private Integer id;
    @Column(name="position_name",unique = true,nullable = false,length = 100)
    @Enumerated(EnumType.STRING)
    private position_name name;
}
