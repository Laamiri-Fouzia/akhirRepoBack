package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.TypeModule;
import com.bezkoder.springjwt.repository.TypeModuleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeModuleService {
    @Autowired
    private TypeModuleDao typeModuleDao;

    public TypeModule findByCode(String code) {
        return typeModuleDao.findByCode(code);
    }
    public int save(TypeModule typeModule) {
         if(findByCode(typeModule.getCode())!=null)
             return -1;
         else
         {
             typeModuleDao.save(typeModule);
             return 1;
         }
    }
}
