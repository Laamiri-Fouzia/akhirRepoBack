package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.models.AnneeUniversitaire;
import com.bezkoder.springjwt.repository.AnneeUniversitaireDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnneeUniversitaireService {
    @Autowired
    private AnneeUniversitaireDao anneeUniversitaireDao;

    public List<AnneeUniversitaire> findAll() {
        return anneeUniversitaireDao.findAll();
    }

    public AnneeUniversitaire findByLibelle(String libelle) {
        return anneeUniversitaireDao.findByLibelle(libelle);
    }

    public AnneeUniversitaire findByAnneeOne(Long annee1) {
        return anneeUniversitaireDao.findByAnneeOne(annee1);
    }
}
