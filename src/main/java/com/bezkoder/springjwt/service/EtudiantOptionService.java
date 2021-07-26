package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.repository.EtudiantOptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EtudiantOptionService {
    @Autowired
    private EtudiantOptionDao etudiantOptionDao;
    @Autowired
    private AnneeUniversitaireService anneeUniversitaireService;
    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private SemestreService semestreService;
    @Autowired
    private MyOptionService myOptionService;
    @Autowired
    private InscriptionEtudiantModuleService inscriptionEtudiantModuleService;
    @Autowired
    private ModuleSemestreOptionService moduleSemestreOptionService;
    @Autowired
    private NoteEtudiantSemestreService noteEtudiantSemestreService;
    @Autowired
    private NoteEtudiantModuleService noteEtudiantModuleService;

    public List<EtudiantOption> findByMyOptionCode(String code) {
        return etudiantOptionDao.findByMyOptionCode(code);
    }

    @Transactional
    public int deleteByEtudiantCne(String cne) {
        if (noteEtudiantModuleService.findByEtudiantCne(cne).size() != 0)
            return -7;
        int res = etudiantOptionDao.deleteByEtudiantCne(cne);
        res += inscriptionEtudiantModuleService.deleteByEtudiantCne(cne);
        return res + etudiantService.deleteByCne(cne);
    }

    @Transactional
    public int deleteByMyOptionCode(String code) {
        return etudiantOptionDao.deleteByMyOptionCode(code);
    }

    public List<EtudiantOption> findByMyOptionCodeAndAnneeUniversitaireLibelleAndSemestreCode(String codeOpt, String libelle, int codeSem) {
        return etudiantOptionDao.findByMyOptionCodeAndAnneeUniversitaireLibelleAndSemestreCode(codeOpt, libelle, codeSem);
    }

    public EtudiantOption findByEtudiantCneAndMyOptionCodeAndAnneeUniversitaireLibelleAndSemestreCode(String cne, String codeoption, String anne, int semstreCode) {
        return etudiantOptionDao.findByEtudiantCneAndMyOptionCodeAndAnneeUniversitaireLibelleAndSemestreCode(cne, codeoption, anne, semstreCode);
    }

    //save de etudiantOption
    public void saveEtudiantOption(String cetudiant, String cmyOption, String annee, int csemestre) {
        if (findByEtudiantCneAndMyOptionCodeAndAnnéeUniversitaireLibelleAndSemestreCode(cetudiant, cmyOption, annee, csemestre) == null) {

            Etudiant etudiant = etudiantService.findByCne(cetudiant);
            MyOption myOption = myOptionService.findByCode(cmyOption);
            Semestre semestre = semestreService.findByCode(csemestre);
            AnneeUniversitaire anneeUniversitaire = anneeUniversitaireService.findByLibelle(annee);
            EtudiantOption etudiantOption = new EtudiantOption();
            etudiantOption.setEtudiant(etudiant);
            etudiantOption.setMyOption(myOption);
            etudiantOption.setAnneeUniversitaire(anneeUniversitaire);
            etudiantOption.setSemestre(semestre);
            etudiantOptionDao.save(etudiantOption);
        }
    }

    //save de etudiantModule

    public void saveEtudiantModule(String cetudiant, int codesemestre1, int codeSemestre2, String annee, String cmyOption) {
        MyOption myOption = myOptionService.findByCode(cmyOption);
        Etudiant etudiant = etudiantService.findByCne(cetudiant);
        AnneeUniversitaire anneeUniversitaire = anneeUniversitaireService.findByLibelle(annee);

        List<ModuleSemestreOption> moduleSemestreOptions1 = moduleSemestreOptionService.findBySemestreCodeAndAnneeUniversitaireLibelleAndMyOptionCode(codesemestre1, annee, myOption.getCode());
        List<ModuleSemestreOption> moduleSemestreOptions2 = moduleSemestreOptionService.findBySemestreCodeAndAnneeUniversitaireLibelleAndMyOptionCode(codeSemestre2, annee, myOption.getCode());
        moduleSemestreOptions1.addAll(moduleSemestreOptions2);
        for (ModuleSemestreOption moduleSemestreOption : moduleSemestreOptions1) {
            InscriptionEtudiantModule inscriptionEtudiantModule = new InscriptionEtudiantModule();
            inscriptionEtudiantModule.setEtudiant(etudiant);
            inscriptionEtudiantModule.setModuleSemestreOption(moduleSemestreOption);
            inscriptionEtudiantModule.setCode(etudiant.getCne() + moduleSemestreOption.getCode());
            inscriptionEtudiantModuleService.save(inscriptionEtudiantModule);
        }
    }

    //save etudiant reinscrit
    public void saveEtudiantReinscrit(int codeSemsetre1, int codeSemestre2, String cetudiant, String cmyOption, AnneeUniversitaire anneeUniversitaire) {
        Etudiant etudiant = etudiantService.findByCne(cetudiant);
        MyOption myOption = myOptionService.findByCode(cmyOption);
        Long anneAvant = anneeUniversitaire.getAnneeOne() - 1;
        List<NoteEtudiantModule> noteEtudiantModules1 = noteEtudiantModuleService.findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnnéeUniversitaireAnnee1AndEtudiantCne(codeSemsetre1, anneAvant, etudiant.getCne());
        List<NoteEtudiantModule> noteEtudiantModules2 = noteEtudiantModuleService.findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnnéeUniversitaireAnnee1AndEtudiantCne(codeSemsetre1 - 1, anneAvant, etudiant.getCne());
        noteEtudiantModules1.addAll(noteEtudiantModules2);

        for (NoteEtudiantModule noteEtudiantModule : noteEtudiantModules1) {
            if (noteEtudiantModule.getEtatValidation().getCode().equals("NV")) {
                InscriptionEtudiantModule inscriptionEtudiantModule = new InscriptionEtudiantModule();
                inscriptionEtudiantModule.setEtudiant(etudiant);

                //KHESNA NHETO LIH LMMODULE DYAL HAD L3AM
                //Long anneeModule=noteEtudiantModule.getModuleSemestreOption().getAnneeUnvers();
                Long anneeModule = noteEtudiantModule.getModuleSemestreOption().getAnneeUniversitaire().getAnneeOne();
                int codeSemestre = noteEtudiantModule.getModuleSemestreOption().getSemestre().getCode();
                String codeModule = noteEtudiantModule.getModuleSemestreOption().getMyModule().getCode();
                ModuleSemestreOption nvModule = moduleSemestreOptionService.findBySemestreCodeAndAnneeUniversitaireAnneeOneAndMyOptionCodeAndMyModuleCode(codeSemestre, anneeModule + 1, cmyOption, codeModule);
                inscriptionEtudiantModule.setModuleSemestreOption(nvModule);
                inscriptionEtudiantModule.setCode(etudiant.getCne() + nvModule.getCode());
                inscriptionEtudiantModuleService.save(inscriptionEtudiantModule);
                if (findByEtudiantCneAndMyOptionCodeAndAnnéeUniversitaireLibelleAndSemestreCode(etudiant.getCne(), myOption.getCode(), anneeUniversitaire.getLibelle(), codeSemestre) == null) {
                    saveEtudiantOption(cetudiant, cmyOption, nvModule.getAnneeUniversitaire().getLibelle(), codeSemestre);
                }

            }
        }
    }

    public int save(EtudiantOption etudiantOption) {

        if (findByEtudiantCneAndMyOptionCodeAndAnnéeUniversitaireLibelleAndSemestreCode(etudiantOption.getEtudiant().getCne(), etudiantOption.getMyOption().getCode(), etudiantOption.getAnneeUniversitaire().getLibelle(), etudiantOption.getSemestre().getCode()) != null) {
            return -1;
        }
        Etudiant etudiant = etudiantService.findByCne(etudiantOption.getEtudiant().getCne());
        MyOption myOption = myOptionService.findByCode(etudiantOption.getMyOption().getCode());
        Semestre semestre = semestreService.findByCode(etudiantOption.getSemestre().getCode());
        AnneeUniversitaire anneeUniversitaire = anneeUniversitaireService.findByLibelle(etudiantOption.getAnneeUniversitaire().getLibelle());
        //Long annee=etudiantOption.getAnnee();
        String annee = etudiantOption.getAnneeUniversitaire().getLibelle();
        int codeSemestre = etudiantOption.getSemestre().getCode();

        if (codeSemestre == 3 || codeSemestre == 5) {
            if (etudiant != null) {
                //chercher les notes de semestre avant
                NoteEtudiantSemestre noteEtudiantSemestre1 = noteEtudiantSemestreService.findByEtudiantCneAndSemestreCode(etudiantOption.getEtudiant().getCne(), codeSemestre - 1);
                NoteEtudiantSemestre noteEtudiantSemestre2 = noteEtudiantSemestreService.findByEtudiantCneAndSemestreCode(etudiantOption.getEtudiant().getCne(), codeSemestre - 2);
                if (noteEtudiantSemestre1.getEtatValidation().getCode().equals("V") && noteEtudiantSemestre2.getEtatValidation().getCode().equals("V")) {
                    //premiere semsetre de l'annee suivant (s3,s5)
                    saveEtudiantOption(etudiant.getCne(), myOption.getCode(), annee, semestre.getCode());
                    //deuxieme semestre S4 S6
                    saveEtudiantOption(etudiant.getCne(), myOption.getCode(), annee, semestre.getCode() + 1);
                    //affecter modules:
                    saveEtudiantModule(etudiant.getCne(), codeSemestre, codeSemestre + 1, annee, myOption.getCode());
                } else if (noteEtudiantSemestre1.getEtatValidation().getCode().equals("V") && noteEtudiantSemestre2.getEtatValidation().getCode().equals("NV")) {
                    List<NoteEtudiantModule> noteEtudiantModules = noteEtudiantModuleService.findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnnéeUniversitaireAnnee1AndEtudiantCne(codeSemestre - 2, anneeUniversitaire.getAnneeOne() - 1, etudiant.getCne());
                    boolean valide = true;
                    for (NoteEtudiantModule notemodule : noteEtudiantModules) {
                        if (notemodule.getEtatValidation().getLibelle().equals("NV"))
                            valide = (notemodule.getModuleSemestreOption().getTypeModule().getCode().equals("complementaire") && notemodule.getNoteGlobale().compareTo(new BigDecimal(6)) == 1) || (notemodule.getModuleSemestreOption().getTypeModule().getCode().equals("majeur") && notemodule.getNoteGlobale().compareTo(new BigDecimal(8)) == 1);
                        if (!valide)
                            break;
                    }
                    if (valide) {
                        BigDecimal totale = noteEtudiantSemestre1.getNoteSemestre().add(noteEtudiantSemestre2.getNoteSemestre());
                        if (totale.compareTo(new BigDecimal(10)) == 1) {
                            saveEtudiantOption(etudiant.getCne(), myOption.getCode(), annee, semestre.getCode());
                            //deuxieme semestre S4 S6
                            saveEtudiantOption(etudiant.getCne(), myOption.getCode(), annee, semestre.getCode() + 1);
                            //affecter modules:
                            saveEtudiantModule(etudiant.getCne(), codeSemestre, codeSemestre + 1, annee, myOption.getCode());
                        }
                    } else {
                        saveEtudiantReinscrit(codeSemestre - 1, codeSemestre - 2, etudiant.getCne(), myOption.getCode(), anneeUniversitaire);
                    }

                } else if (noteEtudiantSemestre1.getEtatValidation().getCode().equals("NV") && noteEtudiantSemestre2.getEtatValidation().getCode().equals("V")) {
                    List<NoteEtudiantModule> noteEtudiantModules = noteEtudiantModuleService.findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnnéeUniversitaireAnnee1AndEtudiantCne(codeSemestre - 1, anneeUniversitaire.getAnneeOne() - 1, etudiant.getCne());
                    boolean valide = false;
                    for (NoteEtudiantModule notemodule : noteEtudiantModules) {
                        if (notemodule.getEtatValidation().getLibelle().equals("NV"))
                            valide = (notemodule.getModuleSemestreOption().getTypeModule().getCode().equals("complementaire") && notemodule.getNoteGlobale().compareTo(new BigDecimal(6)) == 1) || (notemodule.getModuleSemestreOption().getTypeModule().getCode().equals("majeur") && notemodule.getNoteGlobale().compareTo(new BigDecimal(8)) == 1);
                        if (!valide)
                            break;
                    }
                    if (valide) {
                        BigDecimal totale = noteEtudiantSemestre1.getNoteSemestre().add(noteEtudiantSemestre2.getNoteSemestre());
                        if (totale.compareTo(new BigDecimal(10)) == 1) {
                            saveEtudiantOption(etudiant.getCne(), myOption.getCode(), annee, semestre.getCode());
                            //deuxieme semestre S4 S6
                            saveEtudiantOption(etudiant.getCne(), myOption.getCode(), annee, semestre.getCode() + 1);
                            //affecter modules:
                            saveEtudiantModule(etudiant.getCne(), codeSemestre, codeSemestre + 1, annee, myOption.getCode());
                        }
                    } else {
                        saveEtudiantReinscrit(codeSemestre - 1, codeSemestre - 2, etudiant.getCne(), myOption.getCode(), anneeUniversitaire);
                    }

                } else
                    saveEtudiantReinscrit(codeSemestre - 1, codeSemestre - 2, etudiant.getCne(), myOption.getCode(), anneeUniversitaire);
            }

        }
        return 1;
    }


    public List<EtudiantOption> SearchAncienStudents(String code, Long annee, int codeSems) {

        List<EtudiantOption> res = etudiantOptionDao.findByMyOptionCodeAndAnneeUniversitaireAnneeOneAndSemestreCode(code, annee, codeSems);

        if (res.size() != 0) {
            return res;
        } else if (codeSems != 1) {
            List<EtudiantOption> etdudiants1 = etudiantOptionDao.findByMyOptionCodeAndAnneeUniversitaireAnneeOneAndSemestreCode(code, annee - 1, codeSems - 2);
            List<EtudiantOption> etdudiants2 = etudiantOptionDao.findByMyOptionCodeAndAnneeUniversitaireAnneeOneAndSemestreCode(code, annee - 1, codeSems - 1);
            etdudiants1.addAll(etdudiants2);
            for (EtudiantOption etudiantOption : etdudiants1) {
                EtudiantOption etudiantOption1 = new EtudiantOption();
                etudiantOption1.setSemestre(semestreService.findByCode(codeSems));
                etudiantOption1.setAnneeUniversitaire(anneeUniversitaireService.findByAnneeOne(annee));
                etudiantOption1.setEtudiant(etudiantOption.getEtudiant());
                etudiantOption1.setMyOption(etudiantOption.getMyOption());
                int result = this.save(etudiantOption1);
            }

        }

        return etudiantOptionDao.findByMyOptionCodeAndAnneeUniversitaireAnneeOneAndSemestreCode(code, annee, codeSems);

    }

    public int newEtudiant(EtudiantOption etudiantOption) {

        Etudiant etudiant = etudiantOption.getEtudiant();
        Etudiant etud = etudiantService.findByCne(etudiant.getCne());
        MyOption myOption = myOptionService.findByCode(etudiantOption.getMyOption().getCode());
        Semestre semestre = semestreService.findByCode(etudiantOption.getSemestre().getCode());
        AnneeUniversitaire anneeUniversitaire = anneeUniversitaireService.findByAnneeOne(etudiantOption.getAnneeUniversitaire().getAnneeOne());
        String libelleannee = anneeUniversitaire.getLibelle();

        if (etud == null) {
            //premiere semestre 2020
            etudiantService.save(etudiant);
            saveEtudiantOption(etudiant.getCne(), myOption.getCode(), libelleannee, 1);
            //deuxieme semstre 2021
            saveEtudiantOption(etudiant.getCne(), myOption.getCode(), libelleannee, 2);
            //affecter modules
            saveEtudiantModule(etudiant.getCne(), 1, 2, libelleannee, myOption.getCode());
            return 1;
        } else
            return -1;

    }


    public List<EtudiantOption> findByMyOptionCodeAndAnnéeUniversitaireAnnee1AndSemestreCode(String code, Long
            annee, int codeSems) {
        return etudiantOptionDao.findByMyOptionCodeAndAnneeUniversitaireAnneeOneAndSemestreCode(code, annee, codeSems);
    }

    public EtudiantOption findByEtudiantCneAndMyOptionCodeAndAnnéeUniversitaireLibelleAndSemestreCode(String
                                                                                                              cne, String codeoption, String anne, int semstreCode) {
        return etudiantOptionDao.findByEtudiantCneAndMyOptionCodeAndAnneeUniversitaireLibelleAndSemestreCode(cne, codeoption, anne, semstreCode);
    }

    public List<EtudiantOption> findByMyOptionCodeAndAnneeUniversitaireAnneeOneAndSemestreCode(String code, Long
            annee, int codeSems) {
        return etudiantOptionDao.findByMyOptionCodeAndAnneeUniversitaireAnneeOneAndSemestreCode(code, annee, codeSems);
    }
}


