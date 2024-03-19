package com.dsecurity.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.dsecurity.config.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "course_name")
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(max = 100, min = 6)
    private String courseName;

    @Column(name = "course_time")
    private int courseTime;
}
