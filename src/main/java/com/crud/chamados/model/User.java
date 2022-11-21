package com.crud.chamados.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "tb_users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String local;
}