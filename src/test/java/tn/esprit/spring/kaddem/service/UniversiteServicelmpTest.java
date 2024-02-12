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

    public    void testaddUniversite (){
  Universite universite= new Universite();
  when(universiteRepository.save(universite)).thenReturn(universite);
       assertEquals(universite,universiteService.addUniversite(universite));
    }

    public    void testupdateUniversite (){
       Universite universite= new Universite();
       universite.setIdUniv(1);
       universite.setNomUniv("test");
       String newName="test2";
       universite.setNomUniv(newName);
       when(universiteRepository.save(universite)).thenReturn(universite);
       Universite universiteUpdated = universiteService.updateUniversite(universite);
       assertEquals(newName,universiteUpdated.getNomUniv());

    }



    public  void testdeleteUniversite(){
        Universite universite= new Universite();
        universite.setIdUniv(1);
        when(universiteRepository.findById(universite.getIdUniv())).thenReturn(Optional.of(universite));
        universiteService.deleteUniversite(universite.getIdUniv());
        verify(universiteRepository,times(1)).deleteById(universite.getIdUniv());
    }



}
