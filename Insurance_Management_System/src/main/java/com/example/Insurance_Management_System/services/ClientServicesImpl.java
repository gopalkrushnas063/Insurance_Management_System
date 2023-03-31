package com.example.Insurance_Management_System.services;

import com.example.Insurance_Management_System.exception.ClientException;
import com.example.Insurance_Management_System.model.Client;
import com.example.Insurance_Management_System.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServicesImpl implements ClientServices{

    @Autowired
    private ClientRepository clientRepo;


    @Override
    public Client registerClient(Client client) throws ClientException {
        Optional<Client> existingClient = clientRepo.findById(client.getId());

        if(existingClient != null){
            throw new ClientException("Client already registered with this Client ID : "+ client.getId());
        }

        return clientRepo.save(client);
    }
}
