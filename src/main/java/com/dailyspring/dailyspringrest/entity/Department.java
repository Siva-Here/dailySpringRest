package com.dailyspring.dailyspringrest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "please add department name....kukka")
    private String departmentName;

    private String departmentAddress;
    private String departmentCode;
}


//hibernate validators
//@NotBlank
//@Length
//@Size
//@Email
//@Positive
//@Negative
//@PositiveOrZero
//@NegativeOrZero
//@Future
//@FutureOrPresent
//@Past
// @PastOrPresent