package com.example.Insurance_Management_System.model;

public enum Policy_Type {
    General("General"),
    Life("Life"),
    Health("Health"),
    Motor("Motor");

    String value;

    Policy_Type(String value) {
        this.value =value;
    }
}
