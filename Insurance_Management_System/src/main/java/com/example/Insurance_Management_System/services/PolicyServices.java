package com.example.Insurance_Management_System.services;

import com.example.Insurance_Management_System.exception.PolicyException;
import com.example.Insurance_Management_System.model.InsurancePolicy;

import java.util.List;

public interface PolicyServices {
    public InsurancePolicy addNewPolicy(InsurancePolicy policy) throws PolicyException;
    public List<InsurancePolicy> getAllPolicies() throws PolicyException;
    public InsurancePolicy getPolicyByID(Long id) throws PolicyException;
    public InsurancePolicy updatePolicyByID(Long id,InsurancePolicy policy) throws PolicyException;
    public String deletePolicyByID(Long id) throws PolicyException;
}
