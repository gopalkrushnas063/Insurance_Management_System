package com.example.Insurance_Management_System.controller;

import com.example.Insurance_Management_System.exception.ClaimException;
import com.example.Insurance_Management_System.model.Claim;
import com.example.Insurance_Management_System.services.ClaimServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimServices claimServices;


    @PostMapping("/")
    public ResponseEntity<Claim> createClaimHandler(@RequestBody Claim claim) throws ClaimException{
        Claim claim1 = claimServices.registerClaim(claim);
        return new ResponseEntity<>(claim1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Claim>> getAllClaimHandler() throws ClaimException{
        List<Claim> claimList = claimServices.getAllClaim();
        return new ResponseEntity<>(claimList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimByIDHandler(@PathVariable("id") Long id) throws ClaimException{
        Claim claim = claimServices.getClientByID(id);
        return new ResponseEntity<>(claim, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Claim> updateClaimByIDHandler(@PathVariable("id") Long id,@RequestBody Claim claim) throws ClaimException{
        Claim claim1 = claimServices.updateClaimByID(id,claim);
        return new ResponseEntity<>(claim1, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClaimByIDHandler(@PathVariable("id") Long id) throws ClaimException{
        String res = claimServices.deleteClaimByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
