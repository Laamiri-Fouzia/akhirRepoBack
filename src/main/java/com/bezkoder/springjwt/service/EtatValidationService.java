package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.models.EtatValidation;
import com.bezkoder.springjwt.repository.EtatValidationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EtatValidationService {
    @Autowired
    private EtatValidationDao etatValidationDao;


    public EtatValidation findByCode(String code) {
        return etatValidationDao.findByCode(code);
    }

    public EtatValidation findByLibelle(String libelle) {
        return etatValidationDao.findByLibelle(libelle);
    }

    public int save (EtatValidation etatValidation){
        if(findByCode(etatValidation.getCode())!=null)
            return -1;
        else{
            etatValidationDao.save(etatValidation);
            return 1;
        }
    }
    @Transactional
    public int deleteByCode(String code) {
        return etatValidationDao.deleteByCode(code);
    }

    public List<EtatValidation> findAll() {
        return etatValidationDao.findAll();
    }
}
