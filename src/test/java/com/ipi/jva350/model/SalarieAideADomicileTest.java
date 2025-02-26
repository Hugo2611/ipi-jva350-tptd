package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;


@Component
class SalarieAideADomicileTest {

    @Test
    void testALegalementDroitADesCongesPayesDefaut() {
        //Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        //When
        boolean res = s.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(false, res);
    }

    @Test
    void testALegalementDroitADesCongesPayesTodo() {
        //Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        //When
        boolean res = s.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(true, res);
    }
    @Test
    void testALegalementDroitADesCongesPayeFalse() {
        //Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        //When
        boolean res = s.aLegalementDroitADesCongesPayes();
        s.setJoursTravaillesAnneeNMoins1(1);
        //Then
        // avec 1j de travaillé, il est tres peu probable d'avoir un jour de congés
        Assertions.assertFalse(res);
    }


    @Test
    void testALegalementDroitADesCongesPayeTrue() {
        //Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        //When
        boolean res = s.aLegalementDroitADesCongesPayes();
        s.setJoursTravaillesAnneeNMoins1(100);
        //Then
        // avec 100j de travaillé, il est obligé d'avoir un jour de congés
        Assertions.assertTrue(res);
    }

    @Test
    void testALegalementDroitADesCongesPayeTrueAuxLimites() {
        //Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        //When
        boolean res = s.aLegalementDroitADesCongesPayes();
        s.setJoursTravaillesAnneeNMoins1(10);
        //Then
        // avec 10j de travaillé, il est obligé d'avoir un jour de congés
        Assertions.assertTrue(res);
    }
}
