package com.example.Insurance_Management_System.services;

import com.example.Insurance_Management_System.exception.ClaimException;
import com.example.Insurance_Management_System.exception.ClientException;
import com.example.Insurance_Management_System.exception.PolicyException;
import com.example.Insurance_Management_System.model.Claim;
import com.example.Insurance_Management_System.model.Client;
import com.example.Insurance_Management_System.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClaimServicesImpl implements ClaimServices{

    @Autowired
    private ClaimRepository claimRepo;

    @Override
    public Claim registerClaim(Claim claim) throws ClaimException {
        Optional<Claim> optionalClaim = claimRepo.findById(claim.getId());

        if(optionalClaim.isPresent()){
            throw new ClaimException("Client has already claim with claim ID : "+claim.getId());
        }
        return claimRepo.save(claim);
    }

    @Override
    public List<Claim> getAllClaim() throws ClaimException {
        List<Claim> claims = claimRepo.findAll();
        if(claims.isEmpty()){
            throw new ClaimException("No any records found");
        }
        return claims;
    }

    @Override
    public Claim getClientByID(Long claim_ID) throws ClaimException {
        Optional<Claim> optionalClaim = claimRepo.findById(claim_ID);
        if(getAllClaim().isEmpty()){
            throw new ClaimException("Claim doesnot exist with Claim ID : "+claim_ID);
        }
        return optionalClaim.get();
    }

    @Override
    public Claim updateClaimByID(Long id, Claim claim) throws ClaimException {
        Claim existingClaim = claimRepo.findById(id).get();
        existingClaim.setClaimDate(claim.getClaimDate());
        existingClaim.setClaimStatus(claim.getClaimStatus());
        existingClaim.setClaimNumber(claim.getClaimNumber());
        existingClaim.setDescription(claim.getDescription());
        if(existingClaim != null){
            return claimRepo.save(existingClaim);
        }
        throw new ClaimException("Claim does not exist with claim ID : "+id);
    }

    @Override
    public String deleteClaimByID(Long id) throws ClaimException {
        Optional<Claim> optionalClaim = claimRepo.findById(id);
        if(optionalClaim.isPresent()){
            claimRepo.deleteById(id);
            return "Successfully deleted the Claim with the Client ID : "+id;
        }
        throw new ClaimException("Claim does not exist with the Claim ID : "+id);
    }
}
