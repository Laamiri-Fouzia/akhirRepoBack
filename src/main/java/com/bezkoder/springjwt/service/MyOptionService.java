package com.bezkoder.springjwt.service;



import com.bezkoder.springjwt.models.Filliere;
import com.bezkoder.springjwt.models.MyOption;
import com.bezkoder.springjwt.repository.MyOptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyOptionService {


    @Autowired
    private MyOptionDao myOptionDao;
    @Autowired
    private PonderationService ponderationService;
    @Autowired
    private FilliereService filliereService;
    @Autowired
    private ModuleSemestreOptionService moduleSemestreOptionService;


    public MyOption findByCode(String code) {
        return myOptionDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        int r1=moduleSemestreOptionService.deleteByMyOptionCode(code);
        int r2=myOptionDao.deleteByCode(code);
        return r1+r2;
    }

    public List<MyOption> findAll() {
        return myOptionDao.findAll();
    }

    public int save(MyOption myOption) {
        if(findByCode(myOption.getCode())!=null)
            return -1;
        else{
            Filliere filliere=filliereService.findByCode(myOption.getFilliere().getCode());
            myOption.setFilliere(filliere);
            myOptionDao.save(myOption);
            return 1;
        }
    }

    public List<MyOption> findByFilliereCode(String code) {

        return myOptionDao.findByFilliereCode(code);
    }
    public void update(MyOption myOption){
        MyOption newOption=myOptionDao.findByCode(myOption.getCode());
        newOption.setCoefContinue(myOption.getCoefContinue());
        newOption.setCoefFinale(myOption.getCoefFinale());
        myOptionDao.save(newOption);
    }

    @Transactional
    public int deleteByFilliereCode(String Code) {
        return myOptionDao.deleteByFilliereCode(Code);
    }
}
