package com.seatwatch.seatwatchapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.MapKeyType;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String originLocationCode;

    @Column
    @NotBlank
    private String destinationLocationCode;

    @Column
    @NotBlank
    private String date;

    @Column
    @NotBlank
    private String time;
}
