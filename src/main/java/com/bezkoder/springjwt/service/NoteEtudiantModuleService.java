package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.EtatValidation;
import com.bezkoder.springjwt.models.InscriptionEtudiantModule;
import com.bezkoder.springjwt.models.NoteEtudiantModule;
import com.bezkoder.springjwt.models.NoteEtudiantSemestre;
import com.bezkoder.springjwt.repository.NoteEtudiantModuleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class NoteEtudiantModuleService {
    @Autowired
    private NoteEtudiantModuleDao noteEtudiantModuleDao;
    @Autowired
    private ModuleSemestreOptionService moduleSemestreOptionService;
    @Autowired
    private EtudiantOptionService etudiantOptionService;
    @Autowired
    private EtatValidationService etatValidationService;
    @Autowired
    private SemestreService semestreService;
    @Autowired
    private InscriptionEtudiantModuleService inscriptionEtudiantModuleService;
    @Autowired
    private NoteEtudiantSemestreService noteEtudiantSemestreService;
    private NoteEtudiantModule noteEtudiantModule;

    public List<NoteEtudiantModule> findAll() {
        return noteEtudiantModuleDao.findAll();
    }

    public List<NoteEtudiantModule> findByEtudiantCne(String cne) {
        return noteEtudiantModuleDao.findByEtudiantCne(cne);
    }

    public List<NoteEtudiantModule> findByEtudiantCneAndModuleSemestreOptionAnneeUniversitaireLibelle(String cne, String libelle) {
        return noteEtudiantModuleDao.findByEtudiantCneAndModuleSemestreOptionAnneeUniversitaireLibelle(cne, libelle);
    }

    public List<NoteEtudiantModule> findByModuleSemestreOptionMyModuleCodeAndEtudiantCne(String code, String cne) {
        return noteEtudiantModuleDao.findByModuleSemestreOptionMyModuleCodeAndEtudiantCne(code, cne);
    }

    public List<NoteEtudiantModule> findByEtudiantCneAndModuleSemestreOptionSemestreCode(String cne, int code) {
        return noteEtudiantModuleDao.findByEtudiantCneAndModuleSemestreOptionSemestreCode(cne, code);
    }

    /*public List<NoteEtudiantModule> findNotes(String codeModule) {
        List<NoteEtudiantModule> res=noteEtudiantModuleDao.findByModuleSemestreOptionCode(codeModule);
        if(res.size()!=0){
            return res;
        }
        else{
            List<InscriptionEtudiantModule> etudiants=inscriptionEtudiantModuleService.findByModuleSemestreOptionCode(codeModule);

            for (InscriptionEtudiantModule etudiant : etudiants) {
                NoteEtudiantModule noteEtudiantModule=new NoteEtudiantModule();

                noteEtudiantModule.setEtudiant(etudiant.getEtudiant());
                noteEtudiantModule.setNoteModuleNormal(BigDecimal.ZERO);
                noteEtudiantModule.setNoteModuleRat(BigDecimal.ZERO);
                noteEtudiantModule.setNoteGlobale(BigDecimal.ZERO);
                noteEtudiantModule.setNoteContinue(BigDecimal.ZERO);
                noteEtudiantModule.setNoteFinalApresRat(BigDecimal.ZERO);
                noteEtudiantModule.setNoteFinalAvRat(BigDecimal.ZERO);
                noteEtudiantModule.setEtatValidation(etatValidationService.findByCode("R"));
                noteEtudiantModule.setModuleSemestreOption(moduleSemestreOptionService.findByCode(codeModule));

                NoteEtudiantSemestre noteEtudiantSemestre= noteEtudiantSemestreService.findByCode(etudiant.getEtudiant().getCne()+noteEtudiantModule.getModuleSemestreOption().getSemestre().getCode());

                if(noteEtudiantSemestre==null){
                    noteEtudiantSemestre=new NoteEtudiantSemestre();
                    noteEtudiantSemestre.setEtudiant(etudiant.getEtudiant());
                    noteEtudiantSemestre.setNoteSemestre(BigDecimal.ZERO);
                    noteEtudiantSemestre.setCode(etudiant.getEtudiant().getCne()+noteEtudiantModule.getModuleSemestreOption().getSemestre().getCode());
                    noteEtudiantSemestre.setSemestre(semestreService.findByCode(noteEtudiantModule.getModuleSemestreOption().getSemestre().getCode()));
                    noteEtudiantSemestreService.save(noteEtudiantSemestre);
                }

                noteEtudiantModule.setNoteEtudiantSemestre(noteEtudiantSemestre);
                noteEtudiantModuleDao.save(noteEtudiantModule);
                res.add(noteEtudiantModule);

            }
            return res;
        }
    }*/
    public List<NoteEtudiantModule> findNotes(String codeModule) {
        List<InscriptionEtudiantModule> etudiants = inscriptionEtudiantModuleService.findByModuleSemestreOptionCode(codeModule);

        List<NoteEtudiantModule> res = noteEtudiantModuleDao.findByModuleSemestreOptionCode(codeModule);

        if (res.size() != 0) {
            for (InscriptionEtudiantModule etudiant : etudiants) {
                int trouve=0;
                for (NoteEtudiantModule noteEtudiant : res) {
                    if(noteEtudiant.getEtudiant().getCne().equals(etudiant.getEtudiant().getCne())){
                        trouve=1;
                        break;
                    }
                }
                if(trouve==0){
                    NoteEtudiantModule noteEtudiantModule = new NoteEtudiantModule();

                    noteEtudiantModule.setEtudiant(etudiant.getEtudiant());
                    noteEtudiantModule.setNoteModuleNormal(BigDecimal.ZERO);
                    noteEtudiantModule.setNoteModuleRat(BigDecimal.ZERO);
                    noteEtudiantModule.setNoteGlobale(BigDecimal.ZERO);
                    noteEtudiantModule.setNoteContinue(BigDecimal.ZERO);
                    noteEtudiantModule.setNoteFinalApresRat(BigDecimal.ZERO);
                    noteEtudiantModule.setNoteFinalAvRat(BigDecimal.ZERO);
                    noteEtudiantModule.setEtatValidation(etatValidationService.findByCode("R"));
                    noteEtudiantModule.setModuleSemestreOption(moduleSemestreOptionService.findByCode(codeModule));
                    noteEtudiantModuleDao.save(noteEtudiantModule);
                    res.add(noteEtudiantModule);
                }

            }

        } else {
            for (InscriptionEtudiantModule etudiant : etudiants) {
                NoteEtudiantModule noteEtudiantModule = new NoteEtudiantModule();

                noteEtudiantModule.setEtudiant(etudiant.getEtudiant());
                noteEtudiantModule.setNoteModuleNormal(BigDecimal.ZERO);
                noteEtudiantModule.setNoteModuleRat(BigDecimal.ZERO);
                noteEtudiantModule.setNoteGlobale(BigDecimal.ZERO);
                noteEtudiantModule.setNoteContinue(BigDecimal.ZERO);
                noteEtudiantModule.setNoteFinalApresRat(BigDecimal.ZERO);
                noteEtudiantModule.setNoteFinalAvRat(BigDecimal.ZERO);
                noteEtudiantModule.setEtatValidation(etatValidationService.findByCode("R"));
                noteEtudiantModule.setModuleSemestreOption(moduleSemestreOptionService.findByCode(codeModule));

                NoteEtudiantSemestre noteEtudiantSemestre = noteEtudiantSemestreService.findByCode(etudiant.getEtudiant().getCne() + noteEtudiantModule.getModuleSemestreOption().getSemestre().getCode());

                if (noteEtudiantSemestre == null) {
                    noteEtudiantSemestre = new NoteEtudiantSemestre();
                    noteEtudiantSemestre.setEtudiant(etudiant.getEtudiant());
                    noteEtudiantSemestre.setNoteSemestre(BigDecimal.ZERO);
                    noteEtudiantSemestre.setCode(etudiant.getEtudiant().getCne() + noteEtudiantModule.getModuleSemestreOption().getSemestre().getCode());
                    noteEtudiantSemestre.setSemestre(semestreService.findByCode(noteEtudiantModule.getModuleSemestreOption().getSemestre().getCode()));
                    noteEtudiantSemestreService.save(noteEtudiantSemestre);
                }

                noteEtudiantModule.setNoteEtudiantSemestre(noteEtudiantSemestre);
                noteEtudiantModuleDao.save(noteEtudiantModule);
                res.add(noteEtudiantModule);

            }

        }
        return res;
    }

    public void updateNormal(NoteEtudiantModule noteEtudiantModule) {
        NoteEtudiantModule noteEtudiantModule1 = findByEtudiantCneAndModuleSemestreOptionCode(noteEtudiantModule.getEtudiant().getCne(), noteEtudiantModule.getModuleSemestreOption().getCode());
        EtatValidation etatValidation = etatValidationService.findByLibelle(noteEtudiantModule.getEtatValidation().getLibelle());
        BigDecimal noteModuleNormal = noteEtudiantModule.getNoteModuleNormal();
        BigDecimal noteContinue = noteEtudiantModule.getNoteContinue();
        BigDecimal noteGlobale = noteEtudiantModule.getNoteGlobale();
        BigDecimal noteFinalAvRat = noteEtudiantModule.getNoteFinalAvRat();

        noteEtudiantModule1.setEtatValidation(etatValidation);
        noteEtudiantModule1.setNoteModuleNormal(noteModuleNormal);
        noteEtudiantModule1.setNoteContinue(noteContinue);
        noteEtudiantModule1.setNoteGlobale(noteGlobale);
        noteEtudiantModule1.setNoteFinalAvRat(noteFinalAvRat);
        noteEtudiantModuleDao.save(noteEtudiantModule1);
    }

    public void updateRat(NoteEtudiantModule noteEtudiantModule) {
        NoteEtudiantModule noteEtudiantModule1 = findByEtudiantCneAndModuleSemestreOptionCode(noteEtudiantModule.getEtudiant().getCne(), noteEtudiantModule.getModuleSemestreOption().getCode());

        EtatValidation etatValidation = etatValidationService.findByLibelle(noteEtudiantModule.getEtatValidation().getLibelle());
        BigDecimal noteModuleRat = noteEtudiantModule.getNoteModuleRat();
        BigDecimal noteFinalApresRat = noteEtudiantModule.getNoteFinalApresRat();
        BigDecimal noteGlobale = noteEtudiantModule.getNoteGlobale();

        noteEtudiantModule1.setEtatValidation(etatValidation);
        noteEtudiantModule1.setNoteModuleRat(noteModuleRat);
        noteEtudiantModule1.setNoteFinalApresRat(noteFinalApresRat);
        noteEtudiantModule1.setNoteGlobale(noteGlobale);
        noteEtudiantModuleDao.save(noteEtudiantModule1);
    }

    public List<NoteEtudiantModule> findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnneeUniversitaireAnneeOneAndEtudiantCne(int codeSemestre, Long annee, String cne) {
        return noteEtudiantModuleDao.findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnneeUniversitaireAnneeOneAndEtudiantCne(codeSemestre, annee, cne);
    }

    public List<NoteEtudiantModule> findByEtatValidationCode(String code) {
        return noteEtudiantModuleDao.findByEtatValidationCode(code);
    }

    public List<NoteEtudiantModule> findByModuleSemestreOptionCodeAndEtatValidationCode(String code, String codeEtat) {
        return noteEtudiantModuleDao.findByModuleSemestreOptionCodeAndEtatValidationCode(code, codeEtat);
    }

    public List<NoteEtudiantModule> findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnnéeUniversitaireAnnee1AndEtudiantCne(int codeSemestre, Long anne, String cne) {
        return noteEtudiantModuleDao.findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnneeUniversitaireAnneeOneAndEtudiantCne(codeSemestre, anne, cne);
    }

    public NoteEtudiantModule findByEtudiantCneAndModuleSemestreOptionCode(String cne, String code) {
        return noteEtudiantModuleDao.findByEtudiantCneAndModuleSemestreOptionCode(cne, code);
    }
}
