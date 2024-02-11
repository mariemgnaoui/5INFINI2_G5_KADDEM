package tn.esprit.spring.kaddem.service;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Etudiant;

import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EtudiantServiceImpTest {


    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EtudiantRepository etudiantRepository;

    @Mock
    private DepartementRepository departementRepository;

    @InjectMocks
    private EtudiantServiceImpl EtudiantService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllEtudiant() {
        List<Etudiant> Etudiants = new ArrayList<>();
        when(etudiantRepository.findAll()).thenReturn(Etudiants);

        List<Etudiant> result = EtudiantService.retrieveAllEtudiants();

        assertEquals(Etudiants, result);
    }

    @Test
    public void testAddEtudiant() {
        Etudiant Etudiant = new Etudiant();

        when(etudiantRepository.save(Etudiant)).thenReturn(Etudiant);

        assertEquals(Etudiant, EtudiantService.addEtudiant(Etudiant));
    }




    @Test
    public void testUpdateEtudiant() {

        Etudiant Etudiant = new Etudiant();
        Etudiant.setIdEtudiant(1);
        Etudiant.setNomE("test");

        String nouveauNom = "test2";
        Etudiant.setNomE(nouveauNom);

        // Def comportement du repos lors maj
        when(etudiantRepository.save(Etudiant)).thenReturn(Etudiant);

        // Appeler la méthode de mise à jour du service
        Etudiant EtudiantMiseAJour = EtudiantService.updateEtudiant(Etudiant);

        assertEquals(nouveauNom, EtudiantMiseAJour.getNomE());
    }


    public void testDeleteEtudiant() {
        Etudiant Etudiant = new Etudiant();
        Etudiant.setIdEtudiant(1);

        // Simuler la méthode findById pour retourner l'équipe
        when(etudiantRepository.findById(Etudiant.getIdEtudiant())).thenReturn(Optional.of(Etudiant));

        // Appeler la méthode de suppression du service
        EtudiantService.removeEtudiant(Etudiant.getIdEtudiant());

        // Vérifier que la méthode deleteById a été appelée avec le bon ID
        verify(etudiantRepository, times(1)).deleteById(Etudiant.getIdEtudiant());
    }























}




