package com.example.Insurance_Management_System.controller;


import com.example.Insurance_Management_System.exception.PolicyException;
import com.example.Insurance_Management_System.model.InsurancePolicy;
import com.example.Insurance_Management_System.services.PolicyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/")
    public ResponseEntity<List<InsurancePolicy>> getAllPoliciesHandler() throws PolicyException{
        List<InsurancePolicy> policies = policyServices.getAllPolicies();
        return new ResponseEntity<>(policies,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicy> getPolicyByIDHandler(@PathVariable("id") Long id) throws PolicyException{
        InsurancePolicy policies = policyServices.getPolicyByID(id);
        return new ResponseEntity<>(policies,HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<InsurancePolicy> updatePolicyByIDHandler(@PathVariable("id") Long id,InsurancePolicy policy) throws PolicyException{
        InsurancePolicy policies = policyServices.updatePolicyByID(id,policy);
        return new ResponseEntity<>(policies,HttpStatus.OK);
    }
}
