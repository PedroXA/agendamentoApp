package com.agendamento.pedroreis.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "laboratorio")
@Table(name = "laboratorio")
@Getter
@Setter
public class Laboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Integer computerCount;
}
