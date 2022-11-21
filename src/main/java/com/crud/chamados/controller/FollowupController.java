package com.crud.chamados.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.crud.chamados.model.Followup;
import com.crud.chamados.repository.FollowupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/followups")
public class FollowupController
{
    @Autowired
    private FollowupRepository repository;

    @GetMapping("/all")
    public List<Followup> getAllFollowups()
    {
        return repository.findAll();
    }

    @GetMapping("ticket/{id}")
    public List<Followup> getFollowupsByTicketId(@PathVariable Long id)
    {
        return repository.findByTicketId(id);
    }

    //Retorna o um acompanhamento pelo ID
    @GetMapping("/{id}")
    public Followup getFollowupById(@PathVariable Long id)
    {
        //verifica se existe o followup
        if (repository.findById(id).isPresent())
        {
            return repository.findById(id).get();
        }
        return null;
    }

    //Cria o um acompanhamento
    @PostMapping("/create")
    public Followup createFollowup(@RequestBody Followup followup)
    {
        return repository.save(followup);
    }

    //Atualiza um acompanhamento
    @PutMapping("/update")
    public String updateFollowup(@RequestBody Followup followup)
    {
        //verifica se existe o followup
        if (repository.findById(followup.getId()).isPresent())
        {
            repository.save(followup);
            return "Followup atualizado com sucesso!";
        }
        return "Followup não encontrado!";
    }

    //Deleta um acompanhamento
    @DeleteMapping("/delete/{id}")
    public String deleteFollowup(@PathVariable Long id)
    {
        //verifica se existe o followup
        if (repository.findById(id).isPresent())
        {
            repository.deleteById(id);
            return "Followup deletado com sucesso!";
        }
        return "Followup não encontrado!";
    }
}
