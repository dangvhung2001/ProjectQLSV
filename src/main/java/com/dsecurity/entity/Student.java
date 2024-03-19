package com.dsecurity.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import com.dsecurity.config.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    @Pattern(regexp = Constants.EMAIL_REGEX)
    private String email;

    @Column(name = "fullname", length = 100, nullable = false)
    private String fullName;

    @Column(name = "status")
    private boolean status;

    @Column(name = "birthday")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date birthday;

    @Column(name = "phone", length = 15, unique = true)
    @Pattern(regexp = Constants.PHONE_REGEX)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "create_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date createdAt;

    @Column(name = "update_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Class aClass;
}

