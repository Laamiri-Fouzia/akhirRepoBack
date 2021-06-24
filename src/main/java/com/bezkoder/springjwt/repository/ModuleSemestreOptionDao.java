package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.ModuleSemestreOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleSemestreOptionDao extends JpaRepository<ModuleSemestreOption,Long> {
    ModuleSemestreOption findByMyOptionCodeAndMyModuleCodeAndSemestreCode(String codeOp,String codeMod,int codeSeme);
    List<ModuleSemestreOption> findBySemestreCodeAndAnneeUniversitaireLibelleAndMyOptionCode(int codeSemestre, String annee, String cmyOption);
    List<ModuleSemestreOption> findBySemestreCodeAndMyOptionCode(int codeSem,String codeOpt);
    List<ModuleSemestreOption> findByMyOptionCode(String code);
    ModuleSemestreOption findByCode(String code);
    ModuleSemestreOption findBySemestreCodeAndAnneeUniversitaireAnneeOneAndMyOptionCodeAndMyModuleCode(int codeSemestre, Long annee, String cmyOption, String codeModule);
    List<ModuleSemestreOption> findBySemestreCodeAndAnneeUniversitaireAnneeOneAndMyOptionCode(int codeSemestre, Long annee, String cmyOption);
    int deleteByCode( String code);
    int deleteByMyOptionCode(String code);
    int deleteByMyModuleCode(String code);
}
