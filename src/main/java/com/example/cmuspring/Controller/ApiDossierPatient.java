package com.example.cmuspring.Controller;

import com.example.cmuspring.Dto.DossierPatientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.example.cmuspring.Utils.Constants.Api;

public interface ApiDossierPatient {

    @PostMapping(value = Api+"/creeDossier")
    DossierPatientDto ajouerDossierPatient(@RequestParam(required = false) String id, @RequestParam(required = false) String ville,
                                           @RequestParam(required = false) int age, @RequestParam(required = false) boolean masculin
                                            , @RequestParam(required = false) boolean feminin, @RequestParam(required = false) boolean enceinte);

    @GetMapping(value = Api+"/consulter",produces = MediaType.APPLICATION_JSON_VALUE)
    DossierPatientDto consulterDossierPatient(@RequestParam(required = false) String numeroCmu);

    @GetMapping(value = Api+"/modifier"
                ,produces = MediaType.APPLICATION_JSON_VALUE)
    DossierPatientDto modifierDossierPatient(@RequestParam(required = false) String numeroCmu,@RequestParam(required = false) String antecedentsMedicaux,
                                             @RequestParam(required = false) String historiqueVaccination,@RequestParam(required = false) String resumesMedicaux);

    @DeleteMapping(value = Api+"/supprimer")
    void supprimerDossierPatient(@RequestParam(required = false) String numeroCmu);
}
