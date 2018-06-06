package com.example.duplicatenotnulltest;

import org.hibernate.validator.constraints.NotBlank;

public class SampleDto {

    @NotBlank
    String lastname;
}
