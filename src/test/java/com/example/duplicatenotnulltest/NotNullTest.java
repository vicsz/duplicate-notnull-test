package com.example.duplicatenotnulltest;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class NotNullTest {

    @Test
    public void check_not_null_contraint(){

        SampleDto sampleDto = new SampleDto();

        sampleDto.lastname = "";

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<SampleDto>> constraintViolations = validator.validate(sampleDto);

        assertEquals(constraintViolations.size(),1);

        ConstraintViolation<SampleDto> constraintViolation = constraintViolations.iterator().next();

        assertEquals(constraintViolation.getMessage(),"may not be empty");

    }
}
