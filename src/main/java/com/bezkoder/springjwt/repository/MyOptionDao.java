package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.MyOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyOptionDao extends JpaRepository<MyOption,Long> {
    MyOption findByCode(String code);
    List<MyOption> findByFilliereCode(String code);
    int deleteByCode(String code);
    int deleteByFilliereCode(String Code);

}