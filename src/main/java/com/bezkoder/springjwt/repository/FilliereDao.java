package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Filliere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilliereDao extends JpaRepository<Filliere,Long> {
    Filliere findByCode(String code);
    Filliere findByLibelle( String libelle);
    int deleteByCode( String code);
}
