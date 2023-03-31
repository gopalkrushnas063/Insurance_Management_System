package com.example.Insurance_Management_System.services;

import com.example.Insurance_Management_System.exception.PolicyException;
import com.example.Insurance_Management_System.model.InsurancePolicy;
import com.example.Insurance_Management_System.repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
