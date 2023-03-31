package com.example.Insurance_Management_System.repository;

import com.example.Insurance_Management_System.model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Long> {
    Optional<InsurancePolicy> findByPolicyNumber(String policyNumber);
}
