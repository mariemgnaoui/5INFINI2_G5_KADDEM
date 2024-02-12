package tn.esprit.spring.kaddem.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UniversiteServicelmpTest {

    @Mock
    UniversiteRepository universiteRepository;


    @InjectMocks
    UniversiteServiceImpl universiteService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testRetrieveAllUniversites() {
        List<Universite> mockUniversites = new ArrayList<>();
        mockUniversites.add(new Universite(1, "Universite 1"));
        mockUniversites.add(new Universite(2, "Universite 2"));

        when(universiteRepository.findAll()).thenReturn(mockUniversites);

        List<Universite> universites = universiteService.retrieveAllUniversites();

        assertNotNull(universites);
        assertEquals(2, universites.size());
        verify(universiteRepository, times(1)).findAll();
    }

    @Test
    public void testAddUniversite() {
        Universite universiteToAdd = new Universite("New Universite");
        Universite savedUniversite = new Universite(1, "New Universite");

        when(universiteRepository.save(any(Universite.class))).thenReturn(savedUniversite);

        Universite result = universiteService.addUniversite(universiteToAdd);

        assertNotNull(result);
        assertEquals(savedUniversite.getIdUniv(), result.getIdUniv());
        assertEquals(savedUniversite.getNomUniv(), result.getNomUniv());
        verify(universiteRepository, times(1)).save(universiteToAdd);
    }

    @Test
    public void testUpdateUniversite() {
        Universite existingUniversite = new Universite(1, "Existing Universite");
        Universite updatedUniversite = new Universite(1, "Updated Universite");

        when(universiteRepository.save(any(Universite.class))).thenReturn(updatedUniversite);

        Universite result = universiteService.updateUniversite(existingUniversite);

        assertNotNull(result);
        assertEquals(updatedUniversite.getIdUniv(), result.getIdUniv());
        assertEquals(updatedUniversite.getNomUniv(), result.getNomUniv());
        verify(universiteRepository, times(1)).save(existingUniversite);
    }



    @Test
    public void testDeleteUniversite() {
        Integer universiteIdToDelete = 1;
        Universite universiteToDelete = new Universite(1, "Universite To Delete");

        when(universiteRepository.findById(universiteIdToDelete)).thenReturn(Optional.of(universiteToDelete));
        doNothing().when(universiteRepository).delete(any(Universite.class));

        universiteService.deleteUniversite(universiteIdToDelete);

        verify(universiteRepository, times(1)).delete(universiteToDelete);
    }



}
