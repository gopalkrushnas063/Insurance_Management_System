package com.example.Insurance_Management_System.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.*;




@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "policy")
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Long id;

    @NotNull(message = "Policy number is required")
    private String policyNumber;

    @NotNull(message = "Policy type is required")
    @Enumerated(EnumType.STRING)
    private Policy_Type policyType;

    @NotNull(message = "Coverage amount is required")
    private Double coverageAmount;

    @NotNull(message = "Premium is required")
    private Double premium;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;


    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Client> client = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "policy")
    private List<Claim> claims;
}
