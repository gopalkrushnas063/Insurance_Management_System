package com.example.Insurance_Management_System.controller;

import com.example.Insurance_Management_System.exception.ClientException;
import com.example.Insurance_Management_System.model.Client;
import com.example.Insurance_Management_System.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientServices clientServices;

    @PostMapping("/register")
    public ResponseEntity<Client> registerClientHandler(Client client) throws ClientException{
        Client client1 = clientServices.registerClient(client);
        return new ResponseEntity<>(client1, HttpStatus.ACCEPTED);
    }
}
