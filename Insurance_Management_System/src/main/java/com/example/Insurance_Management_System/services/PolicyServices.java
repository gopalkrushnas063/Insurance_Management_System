package com.example.Insurance_Management_System.services;

import com.example.Insurance_Management_System.exception.PolicyException;
import com.example.Insurance_Management_System.model.InsurancePolicy;

public interface PolicyServices {
    public InsurancePolicy addNewPolicy(InsurancePolicy policy) throws PolicyException;
}
