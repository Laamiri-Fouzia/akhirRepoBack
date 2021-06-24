package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.models.MyModule;
import com.bezkoder.springjwt.repository.MyModuleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyModuleService {

    @Autowired

    private MyModuleDao myModuleDao;


    @Autowired
    private ModuleSemestreOptionService moduleSemestreOptionService;
    /****************************************************/
    public MyModule findByCode(String code) {
        return myModuleDao.findByCode(code);
    }
    public List<MyModule> findAll() {
        return myModuleDao.findAll();
    }
    public MyModule findByLibelle(String libelle) {
        return myModuleDao.findByLibelle(libelle);
    }

    /****************************************************/

    public int  save (MyModule myModule){
        if(findByCode(myModule.getCode())!=null)
            return -1;
        else{
            myModuleDao.save(myModule);
            return 1;
        }
    }
    /****************************************************/
    public MyModule update (MyModule myModule){
        return myModuleDao.save(myModule);
    }

    /****************************************************/
    @Transactional
    public int deleteByCode(String code) {
        int r1=moduleSemestreOptionService.deleteByMyModuleCode(code);
        int r2=myModuleDao.deleteByCode(code);

        return r1+r2;
    }
    /****************************************************/

    @Transactional
    public int deleteByCode(List<MyModule> myModules){
        int sum=0;
        for(int i =0;i<myModules.size();i++){
            sum+=deleteByCode(myModules.get(i).getCode());
        }
        return sum;
    }

}
