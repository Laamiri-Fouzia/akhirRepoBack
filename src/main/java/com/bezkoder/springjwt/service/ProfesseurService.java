package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.models.MyModule;
import com.bezkoder.springjwt.models.Professeur;
import com.bezkoder.springjwt.repository.ProfesseurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesseurService {
    @Autowired
    private ProfesseurDao professeurDao;
    @Autowired
    private MyModuleService myModuleService;


    public Professeur findByCin(String cin) {
        return professeurDao.findByCin(cin);
    }

    public Professeur findByCodeEmploye(String codeEmploye) {
        return professeurDao.findByCodeEmploye(codeEmploye);
    }

    public List<Professeur> findByNomAndPrenom(String nom, String prenon) {
        return professeurDao.findByNomAndPrenom(nom, prenon);
    }

    public int save (Professeur professeur){
        if(findByCin(professeur.getCin())!=null)
            return -1;
        else{
            professeurDao.save(professeur);
            return 1;
        }
    }

    @Transactional
    public int deleteByCodeEmploye(String codeEmploye) {
        return professeurDao.deleteByCodeEmploye(codeEmploye);
    }

    public List<Professeur> findAll() {
        return professeurDao.findAll();
    }

    public List<Professeur> findByEstCoordonateurModuleTrue() {
        return professeurDao.findByEstCoordonateurModuleTrue();
    }

    public void update(Professeur professeur) {
        Professeur prof=findByCin(professeur.getCin());
        List<MyModule> nvListe= new ArrayList<MyModule>();
        for (MyModule mod: professeur.getListeModules()){
            nvListe.add(myModuleService.findByCode(mod.getCode()));
        }
        prof.setListeModules(nvListe);
        professeurDao.save(prof);
    }
}
