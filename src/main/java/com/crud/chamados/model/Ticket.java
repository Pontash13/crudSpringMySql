package com.crud.chamados.model;


import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "tb_tickets")
public class Ticket
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    //1 - Aberto, 2 - Em andamento, 3 - Fechado
    private Integer status;
    //o chamado tem um um requerente
    @ManyToOne()
    @JoinColumn(name = "requester_id")
    private User requester;
}