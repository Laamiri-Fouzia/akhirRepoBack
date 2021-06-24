package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.TestExcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestExcelDao  extends JpaRepository<TestExcel, Long> {
    TestExcel findByTitle(String title);
}
