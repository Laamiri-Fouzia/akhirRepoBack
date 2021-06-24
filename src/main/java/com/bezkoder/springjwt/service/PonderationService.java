package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.models.Ponderation;
import com.bezkoder.springjwt.repository.PonderationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PonderationService {
    public Ponderation findByCode(String code) {
        return ponderationDao.findByCode(code);
    }

    public List<Ponderation> findByCoefContinueAndCoefFinale(BigDecimal coefContinue, BigDecimal coefFinale) {
        return ponderationDao.findByCoefContinueAndCoefFinale(coefContinue, coefFinale);
    }

    public List<Ponderation> findAll() {
        return ponderationDao.findAll();
    }
    public int save(Ponderation ponderation){
        if(findByCode(ponderation.getCode())!=null){
            return -1;
        }
        else{
            ponderationDao.save(ponderation);
            return 1;
        }
    }

    @Autowired
    private PonderationDao ponderationDao;
}
