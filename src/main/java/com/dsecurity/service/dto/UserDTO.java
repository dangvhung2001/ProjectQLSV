package com.dsecurity.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String username;

    private String email;

    private String fullName;

    private boolean status;

    private String password;

    private String avatar;

    private String phone;

    private Date createdAt;

    private Date updatedAt;

    private Set<Long> rolesId;
}
