package com.example.Insurance_Management_System.services;

import com.example.Insurance_Management_System.exception.ClaimException;
import com.example.Insurance_Management_System.exception.PolicyException;
import com.example.Insurance_Management_System.model.Claim;


import java.util.List;

public interface ClaimServices {
    public Claim registerClaim(Claim claim) throws ClaimException;
    public List<Claim> getAllClaim() throws ClaimException;
    public Claim getClientByID(Long claim_ID) throws ClaimException;
    public Claim updateClaimByID(Long id,Claim claim) throws ClaimException;
    public String deleteClaimByID(Long id) throws ClaimException;
}
