package com.example.Insurance_Management_System.services;

import com.example.Insurance_Management_System.exception.PolicyException;
import com.example.Insurance_Management_System.model.InsurancePolicy;
import com.example.Insurance_Management_System.repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyServices{

    @Autowired
    private InsurancePolicyRepository policyRepo;


    @Override
    public InsurancePolicy addNewPolicy(InsurancePolicy policy) throws PolicyException {
        Optional<InsurancePolicy> existingPolicy = policyRepo.findById(policy.getId());
        if(existingPolicy.isPresent()){
            throw new PolicyException("Policy Already Exist With This Policy No. : "+policy.getPolicyNumber());
        }

        return policyRepo.save(policy);
    }

    @Override
    public List<InsurancePolicy> getAllPolicies() throws PolicyException {
        List<InsurancePolicy> policies = policyRepo.findAll();
        if(policies.isEmpty()){
            throw new PolicyException("No any records found");
        }
        return policies;
    }

    @Override
    public InsurancePolicy getPolicyByID(Long id) throws PolicyException {
        Optional<InsurancePolicy> insurancePolicy = policyRepo.findById(id);
        if(insurancePolicy.isPresent()){
            return insurancePolicy.get();
        }
        throw new PolicyException("Insurance does not exist with the Insurance ID : "+id);
    }

    @Override
    public InsurancePolicy updatePolicyByID(Long id, InsurancePolicy policy) throws PolicyException {
        InsurancePolicy policy1 = policyRepo.findById(id).get();
        policy1.setPolicyType(policy.getPolicyType());
        policy1.setPolicyNumber(policy.getPolicyNumber());
        policy1.setCoverageAmount(policy.getCoverageAmount());
        policy1.setPremium(policy.getPremium());
        policy1.setStartDate(policy.getStartDate());
        policy1.setEndDate(policy.getEndDate());
        if(policy1 != null){
            return policyRepo.save(policy1);
        }
        throw new PolicyException("Policy does not exist with the Policy ID : "+id);
    }
}
