package com.vti.enitity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="use_groups")// mapping den bang database
@ToString
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name="group_id")
    private Integer groupId;
    @Column(name="group_name",nullable = false,unique = true,length = 100)
    private String groupName;
    @Column(name = "create_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createTime;
}
