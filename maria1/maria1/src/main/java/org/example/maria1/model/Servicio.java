package org.example.maria1.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

private long id;
    private String LavadoSencillo;
private String LavadoGeneral;
private String LavadodeMotor;
    private String Encerada;
    private String Polichada;



}
