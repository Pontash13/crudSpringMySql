package com.crud.chamados.repository;

import com.crud.chamados.model.Followup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowupRepository extends JpaRepository<Followup, Long>
{
    //create a method to find followups by ticket id
    List<Followup> findByTicketId(Long id);
}
