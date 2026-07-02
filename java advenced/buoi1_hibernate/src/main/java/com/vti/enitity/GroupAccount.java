package com.vti.enitity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="group_account")// mapping den bang database
@ToString
public class GroupAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name ="account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;

    @Column(name = "join_create",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime joinDate;
}
