package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.repository.NoteEtudiantModuleDao;
import com.bezkoder.springjwt.repository.NoteEtudiantStageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class NoteEtudiantStageService {
    @Autowired
    private NoteEtudiantStageDao noteEtudiantStageDao;
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

    public List<NoteEtudiantStage> findNoteStage(String codeModule) {
        List<InscriptionEtudiantModule> etudiants = inscriptionEtudiantModuleService.findByModuleSemestreOptionCode(codeModule);

        List<NoteEtudiantStage> res = noteEtudiantStageDao.findByModuleSemestreOptionCode(codeModule);

        if (res.size() != 0) {
            for (InscriptionEtudiantModule etudiant : etudiants) {
                int trouve=0;
                for (NoteEtudiantStage noteEtudiant : res) {
                    if(noteEtudiant.getEtudiant().getCne().equals(etudiant.getEtudiant().getCne())){
                        trouve=1;
                        break;
                    }
                }
                if(trouve==0){
                    NoteEtudiantStage noteEtudiantStage = new NoteEtudiantStage();
                    noteEtudiantStage.setEtudiant(etudiant.getEtudiant());
                    noteEtudiantStage.setNoteStage(BigDecimal.ZERO);
                    noteEtudiantStage.setEtatValidation(etatValidationService.findByCode("R"));
                    noteEtudiantStage.setModuleSemestreOption(moduleSemestreOptionService.findByCode(codeModule));
                    noteEtudiantStageDao.save(noteEtudiantStage);
                    res.add(noteEtudiantStage);
                }

            }

        } else {
            for (InscriptionEtudiantModule etudiant : etudiants) {
                NoteEtudiantStage noteEtudiantStage = new NoteEtudiantStage();

                noteEtudiantStage.setEtudiant(etudiant.getEtudiant());
                noteEtudiantStage.setEtudiant(etudiant.getEtudiant());
                noteEtudiantStage.setNoteStage(BigDecimal.ZERO);
                noteEtudiantStage.setEtatValidation(etatValidationService.findByCode("R"));
                noteEtudiantStage.setModuleSemestreOption(moduleSemestreOptionService.findByCode(codeModule));

                NoteEtudiantSemestre noteEtudiantSemestre = noteEtudiantSemestreService.findByCode(etudiant.getEtudiant().getCne() + noteEtudiantStage.getModuleSemestreOption().getSemestre().getCode());

                if (noteEtudiantSemestre == null) {
                    noteEtudiantSemestre = new NoteEtudiantSemestre();
                    noteEtudiantSemestre.setEtudiant(etudiant.getEtudiant());
                    noteEtudiantSemestre.setNoteSemestre(BigDecimal.ZERO);
                    noteEtudiantSemestre.setCode(etudiant.getEtudiant().getCne() + noteEtudiantStage.getModuleSemestreOption().getSemestre().getCode());
                    noteEtudiantSemestre.setSemestre(semestreService.findByCode(noteEtudiantStage.getModuleSemestreOption().getSemestre().getCode()));
                    noteEtudiantSemestreService.save(noteEtudiantSemestre);
                }

                noteEtudiantStage.setNoteEtudiantSemestre(noteEtudiantSemestre);
                noteEtudiantStageDao.save(noteEtudiantStage);
                res.add(noteEtudiantStage);

            }

        }
        return res;
    }

    public void updateStage(NoteEtudiantStage noteEtudiantStage) {
        NoteEtudiantStage noteEtudiantModule1 = findByEtudiantCneAndModuleSemestreOptionCode(noteEtudiantStage.getEtudiant().getCne(), noteEtudiantStage.getModuleSemestreOption().getCode());
        EtatValidation etatValidation = etatValidationService.findByLibelle(noteEtudiantStage.getEtatValidation().getLibelle());
        BigDecimal noteStage = noteEtudiantStage.getNoteStage();

        noteEtudiantModule1.setEtatValidation(etatValidation);
        noteEtudiantModule1.setNoteStage(noteStage);
        noteEtudiantStageDao.save(noteEtudiantModule1);
    }

    public NoteEtudiantStage findByEtudiantCneAndModuleSemestreOptionCode(String cne, String code) {
        return noteEtudiantStageDao.findByEtudiantCneAndModuleSemestreOptionCode(cne, code);
    }


    public  NoteEtudiantStage  findByEtudiantCneAndModuleSemestreOptionSemestreCode(String cne, int codeSemestre) {
        return noteEtudiantStageDao.findByEtudiantCneAndModuleSemestreOptionSemestreCode(cne, codeSemestre);
    }
}
