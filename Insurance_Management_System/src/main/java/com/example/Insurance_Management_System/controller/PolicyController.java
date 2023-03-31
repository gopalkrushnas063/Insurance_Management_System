package com.example.Insurance_Management_System.controller;


import com.example.Insurance_Management_System.exception.PolicyException;
import com.example.Insurance_Management_System.model.InsurancePolicy;
import com.example.Insurance_Management_System.services.PolicyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    @Autowired
    private PolicyServices policyServices;

    @PostMapping("/register")
    public ResponseEntity<InsurancePolicy> addNewPolicyHandler(@RequestBody InsurancePolicy policy) throws PolicyException{
        InsurancePolicy policy1 = policyServices.addNewPolicy(policy);
        return new ResponseEntity<>(policy1, HttpStatus.ACCEPTED);
    }
}
