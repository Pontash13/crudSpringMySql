package com.crud.chamados.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "tb_followups")
public class Followup
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}