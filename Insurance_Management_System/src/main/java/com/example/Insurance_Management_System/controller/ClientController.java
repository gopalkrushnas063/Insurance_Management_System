package com.example.Insurance_Management_System.controller;

import com.example.Insurance_Management_System.exception.ClientException;
import com.example.Insurance_Management_System.model.Client;
import com.example.Insurance_Management_System.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientServices clientServices;

    @PostMapping("/")
    public ResponseEntity<Client> registerClientHandler(@RequestBody Client client) throws ClientException{
        Client client1 = clientServices.registerClient(client);
        return new ResponseEntity<>(client1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> allClientListHandler() throws ClientException{
        List<Client> client1 = clientServices.allClientList();
        return new ResponseEntity<>(client1, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientByIDHandler(@PathVariable("id") Long id) throws ClientException{
        Client client = clientServices.getClientByID(id);
        return new ResponseEntity<>(client,HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClientByIDHandler(@PathVariable("id") Long cID ,@RequestBody Client client) throws ClientException{
        Client client1 = clientServices.clientUpdateByID(cID,client);
        return new ResponseEntity<>(client1,HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClientByIDHandler(@PathVariable("id") Long cID) throws ClientException{
        String res = clientServices.deleteClientByID(cID);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
