package com.crud.chamados.controller;

import java.util.List;

import com.crud.chamados.model.Ticket;
import com.crud.chamados.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController
{
    @Autowired
    private TicketRepository repository;

    @GetMapping("/all")
    public List<Ticket> getAllTickets()
    {
        return repository.findAll();
    }

    //Retorna o chamado pelo ID
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id)
    {
        //verifica se existe o chamado
        if (repository.findById(id).isPresent())
        {
            return repository.findById(id).get();
        }
        return null;
    }


    //Cria o chamado
    @PostMapping("/create")
    public Ticket createTicket(@RequestBody Ticket ticket)
    {
        return repository.save(ticket);
    }

    //Atualiza o chamado
    @PutMapping("/update")
    public String updateTicket(@RequestBody Ticket ticket)
    {
        //verifica se existe o chamado
        if (repository.findById(ticket.getId()).isPresent())
        {
            repository.save(ticket);
            return "Chamado atualizado com sucesso!";
        }
        return "Chamado não encontrado!";
    }

    //Deleta o chamado
    @DeleteMapping("/delete/{id}")
    public String deleteTicket(@PathVariable Long id)
    {
        //verifica se existe o chamado
        if (repository.findById(id).isPresent())
        {
            repository.deleteById(id);
            return "Chamado deletado com sucesso!";
        }
        return "Chamado não encontrado!";
    }
}
