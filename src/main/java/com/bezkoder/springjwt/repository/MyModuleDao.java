package com.bezkoder.springjwt.repository;
import com.bezkoder.springjwt.models.MyModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyModuleDao extends JpaRepository<MyModule,Long> {
    MyModule findByCode(String code);
    MyModule findByLibelle(String libelle);
    int deleteByCode( String code);
}
