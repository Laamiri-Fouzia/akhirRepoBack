package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.helper.ExcelHelper;
import com.bezkoder.springjwt.models.TestExcel;
import com.bezkoder.springjwt.repository.TestExcelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class TestExcelService {


    public int save (TestExcel testExcel){
            testExcelDao.save(testExcel);
            return 1;
    }


    public List<TestExcel> findAll() {
        return testExcelDao.findAll();
    }

    public TestExcel findByTitle(String title) {
        return testExcelDao.findByTitle(title);
    }

    @Autowired
    TestExcelDao testExcelDao;
    public ByteArrayInputStream load() {
        List<TestExcel> tutorials = testExcelDao.findAll();
        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
        return in;
    }
}
