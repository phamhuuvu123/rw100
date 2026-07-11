package com.vti.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Integer id;
    private String fullName;
    private String email;
    private String username;
    private String departmentName;
    private String positionName;
    private Integer positionId;
    private Integer departmentId;
}
