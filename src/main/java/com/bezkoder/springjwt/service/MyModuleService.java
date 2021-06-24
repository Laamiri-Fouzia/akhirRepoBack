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

    public List<MyModule> findAll() {
        return myModuleDao.findAll();
    }


}
