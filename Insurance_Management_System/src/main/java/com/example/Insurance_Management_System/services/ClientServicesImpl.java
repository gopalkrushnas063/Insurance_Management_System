package com.example.Insurance_Management_System.services;

import com.example.Insurance_Management_System.exception.ClientException;
import com.example.Insurance_Management_System.model.Client;
import com.example.Insurance_Management_System.model.InsurancePolicy;
import com.example.Insurance_Management_System.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServicesImpl implements ClientServices{

    @Autowired
    private ClientRepository clientRepo;


    @Override
    public Client registerClient(Client client) throws ClientException {
        Optional<Client> existingClient = clientRepo.findById(client.getId());

        if(existingClient.isPresent()){
            throw new ClientException("Client already registered with this Client ID : "+ client.getId());
        }

        List<InsurancePolicy> policies = client.getPolicies();

        for(InsurancePolicy is : policies) {
            is.getClient().add(client);
        }

        return clientRepo.save(client);
    }

    @Override
    public List<Client> allClientList() throws ClientException {
        List<Client> optionalClients = clientRepo.findAll();
        if(optionalClients.isEmpty()){
            throw new ClientException("No any record found");
        }
        return optionalClients;
    }

    @Override
    public Client getClientByID(Long client_ID) throws ClientException {
        Optional<Client> optionalClient = clientRepo.findById(client_ID);
        if(optionalClient.isPresent()){
            return optionalClient.get();
        }
        throw new ClientException("Client does not exist with this Client ID : "+client_ID);
    }

    @Override
    public Client clientUpdateByID(Long client_ID,Client client) throws ClientException {
        Client optionalClient = clientRepo.findById(client_ID).get();
        optionalClient.setName(client.getName());
        optionalClient.setDob(client.getDob());
        optionalClient.setAddress(client.getAddress());
        optionalClient.setContactInfo(client.getContactInfo());
        optionalClient.setPolicies(client.getPolicies());
        if(optionalClient != null){
            return clientRepo.save(optionalClient);
        }
        throw new ClientException("Client does not exist with this Client ID : "+client_ID);
    }
}
