package com.dsecurity.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class StudentDTO {

    private Long id;
    private String email;
    private String fullName;
    private boolean status;
    private Date birthday;
    private String phone;
    private String address;
    private Date createdAt;
    private Date updatedAt;
    private Long classId;
    private ClassDTO classDTO;

    public StudentDTO() {
    }


}

