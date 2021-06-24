package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.models.Semestre;
import com.bezkoder.springjwt.repository.SemestreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SemestreService {
    @Autowired
    private SemestreDao semestreDao;

    public Semestre findByCode(int code) {
        return semestreDao.findByCode(code);
    }

    public Semestre findByLibelle(String libelle) {
        return semestreDao.findByLibelle(libelle);
    }

    public int save (Semestre semestre){
        if(findByCode(semestre.getCode())!=null)
            return -1;
        else{
            semestreDao.save(semestre);
            return 1;
        }
    }

    @Transactional
    public int deleteByCode(int code) {
        return semestreDao.deleteByCode(code);
    }

    public List<Semestre> findAll() {
        return semestreDao.findAll();
    }
}
