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

import org.mockito.internal.matchers.Null;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EquipeServiceImpTest {

    @Mock
    private EtudiantRepository etudiantRepository;

    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EquipeRepository equipeRepository;

    @Mock
    private DepartementRepository departementRepository;

    @InjectMocks
    private EquipeServiceImpl equipeService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllEquipe() {
        List<Equipe> equipes = new ArrayList<>();
        when(equipeRepository.findAll()).thenReturn(equipes);

        List<Equipe> result = equipeService.retrieveAllEquipes();

        assertEquals(equipes, result);
    }

    @Test
    public void testAddEquipe() {
        Equipe equipe = new Equipe();

        when(equipeRepository.save(equipe)).thenReturn(equipe);

        assertEquals(equipe, equipeService.addEquipe(equipe));
    }




    @Test
    public void testUpdateEquipe() {

        Equipe equipe = new Equipe();
        equipe.setIdEquipe(1);
        equipe.setNomEquipe("test");

        String nouveauNom = "test2";
        equipe.setNomEquipe(nouveauNom);

        // Def comportement du repos lors maj
        when(equipeRepository.save(equipe)).thenReturn(equipe);

        // Appeler la méthode de mise à jour du service
        Equipe equipeMiseAJour = equipeService.updateEquipe(equipe);

        assertEquals(nouveauNom, equipeMiseAJour.getNomEquipe());
    }


    public void testDeleteEquipe() {
        Equipe equipe = new Equipe();
        equipe.setIdEquipe(1);

        // Simuler la méthode findById pour retourner l'équipe
        when(equipeRepository.findById(equipe.getIdEquipe())).thenReturn(Optional.of(equipe));

        // Appeler la méthode de suppression du service
        equipeService.deleteEquipe(equipe.getIdEquipe());

        // Vérifier que la méthode deleteById a été appelée avec le bon ID
        verify(equipeRepository, times(1)).deleteById(equipe.getIdEquipe());
    }























}




