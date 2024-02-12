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
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UniversiteServicelmpTest {

    @Mock
    UniversiteRepository universiteRepository;
    @Mock
    DepartementRepository departementRepository;

    @InjectMocks
    UniversiteServiceImpl universiteService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test

    public void testretrieveAllUniversites(){
        List<Universite> universites= new ArrayList<>();

        when(universiteRepository.findAll()).thenReturn(universites);

        List<Universite> result= universiteService.retrieveAllUniversites();

        assertEquals(universites,result);
    }
      @Test
    public    void testaddUniversite (){
  Universite universite= new Universite();
  when(universiteRepository.save(universite)).thenReturn(universite);
       assertEquals(universite,universiteService.addUniversite(universite));
    }
   @Test
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


    @Test
    public  void testdeleteUniversite(){
        Universite universite= new Universite();
        universite.setIdUniv(1);
        when(universiteRepository.findById(universite.getIdUniv())).thenReturn(Optional.of(universite));
        universiteService.deleteUniversite(universite.getIdUniv());
        verify(universiteRepository,times(1)).deleteById(universite.getIdUniv());
    }



}
