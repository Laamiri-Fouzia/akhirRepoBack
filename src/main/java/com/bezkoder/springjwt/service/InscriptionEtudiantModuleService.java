package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.models.InscriptionEtudiantModule;
import com.bezkoder.springjwt.repository.InscriptionEtudiantModuleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InscriptionEtudiantModuleService {
    @Autowired
    private InscriptionEtudiantModuleDao inscriptionEtudiantModuleDao;

    public void save(InscriptionEtudiantModule inscriptionEtudiantModule){
        if(findByCode(inscriptionEtudiantModule.getCode())==null)
           inscriptionEtudiantModuleDao.save(inscriptionEtudiantModule);
    }

    public InscriptionEtudiantModule findByCode(String code) {
        return inscriptionEtudiantModuleDao.findByCode(code);
    }

    public List<InscriptionEtudiantModule> findByModuleSemestreOptionCode(String code) {
        return inscriptionEtudiantModuleDao.findByModuleSemestreOptionCode(code);
    }

    public int deleteByEtudiantCne(String cne) {
        return inscriptionEtudiantModuleDao.deleteByEtudiantCne(cne);
    }
}
