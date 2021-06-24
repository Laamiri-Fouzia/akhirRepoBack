package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.models.Etudiant;
import com.bezkoder.springjwt.repository.EtudiantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantDao etudiantDao;
    @Autowired
    private MyOptionService myOptionService;

    public Etudiant findByCne(String cne) {
        return etudiantDao.findByCne(cne);
    }

    public List<Etudiant> findByNomAndPrenom(String nom, String prenon) {
        return etudiantDao.findByNomAndPrenom(nom, prenon);
    }
    @Transactional
    public int deleteByCne(String cne) {
        return etudiantDao.deleteByCne(cne);
    }

    public List<Etudiant> findAll() {
        return etudiantDao.findAll();
    }

    public int save(Etudiant etudiant){
        if(findByCne(etudiant.getCne())!=null){
            return -1;
        }
        else{
           etudiantDao.save(etudiant);
           return 1;
        }
    }


    public int update (Etudiant etudiant){
        Etudiant etudiantdata=etudiantDao.getOne(etudiant.getId());
        if(etudiantdata==null){
            return -1;
        }
        etudiantdata.setCne(etudiant.getCne());
        etudiantdata.setNom(etudiant.getNom());
        etudiantdata.setPrenom(etudiant.getPrenom());
        etudiantdata.setCin(etudiant.getCin());
        etudiantdata.setDateNaissance(etudiant.getDateNaissance());
        etudiantDao.save(etudiantdata);
        return 1;
    }


    }



