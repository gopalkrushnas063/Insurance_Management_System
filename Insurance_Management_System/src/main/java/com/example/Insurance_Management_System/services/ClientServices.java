package com.example.Insurance_Management_System.services;

import com.example.Insurance_Management_System.exception.ClientException;
import com.example.Insurance_Management_System.model.Client;

public interface ClientServices {
    public Client registerClient(Client client) throws ClientException;
}