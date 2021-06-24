package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.models.Filliere;
import com.bezkoder.springjwt.repository.FilliereDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilliereService {
    @Autowired
    private FilliereDao filliereDao;
    @Autowired
    private MyOptionService myOptionService;


    public Filliere findByCode(String code) {
        return filliereDao.findByCode(code);
    }

    public Filliere findByLibelle(String libelle) {
        return filliereDao.findByLibelle(libelle);
    }


    public int save (Filliere filliere){
        if(findByCode(filliere.getCode())!=null)
            return -1;
        else{
            filliereDao.save(filliere);
            return 1;
        }
    }
    @Transactional
    public int deleteByCode(String code) {
        int r1= myOptionService.deleteByFilliereCode(code);
        int r2= filliereDao.deleteByCode(code);

        return r1+r2;
    }

    public List<Filliere> findAll() {
        return filliereDao.findAll();
    }
}
