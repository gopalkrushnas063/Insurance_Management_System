package com.example.Insurance_Management_System.services;

import com.example.Insurance_Management_System.exception.ClientException;
import com.example.Insurance_Management_System.model.Client;

import java.util.List;

public interface ClientServices {
    public Client registerClient(Client client) throws ClientException;
    public List<Client> allClientList() throws ClientException;
    public Client getClientByID(Long client_ID) throws ClientException;
    public Client clientUpdateByID(Long client_ID,Client client) throws ClientException;
    public String deleteClientByID(Long client_ID) throws ClientException;
}
