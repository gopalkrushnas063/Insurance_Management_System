package com.example.Insurance_Management_System.repository;

import com.example.Insurance_Management_System.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findById(Long id);
}
