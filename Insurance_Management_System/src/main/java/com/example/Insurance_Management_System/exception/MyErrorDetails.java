package com.example.Insurance_Management_System.exception;

import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MyErrorDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
}
