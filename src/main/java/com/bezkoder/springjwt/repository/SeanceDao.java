package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeanceDao extends JpaRepository<Seance,Long> {
     Seance findByLibelle(String libelle);
     List<Seance> findByModuleSemestreOptionCode(String code);

}
