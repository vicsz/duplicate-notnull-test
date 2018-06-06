package com.example.duplicatenotnulltest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@RestController
public class SampleController {

    @RequestMapping()
    public String testNotBlank(){
        SampleDto sampleDto = new SampleDto();

        sampleDto.lastname = "";

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<SampleDto>> constraintViolations = validator.validate(sampleDto);

        if (constraintViolations.size() == 0)
            return "No constraint violations found! [ Things seem to be broken] ";

        ConstraintViolation<SampleDto> constraintViolation = constraintViolations.iterator().next();

        return "Constraint violation detected - " + constraintViolation.getMessage() + " [ Things seem to be working!!] ";
    }
}
