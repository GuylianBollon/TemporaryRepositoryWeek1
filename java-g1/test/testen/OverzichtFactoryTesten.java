/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testen;

import domein.ActiviteitenRepository;
import domein.Address;
import domein.InschrijvingenRepository;
import domein.LesMateriaal;
import domein.Lid;
import domein.OverzichtFactory;
import domein.OverzichtRaadplegingenRepository;
import domein.Overzichttype;
import domein.PrototypeRaadpleging;
import domein.Raadpleging;
import domein.Sessie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

/**
 *
 * @author Hp
 */
public class OverzichtFactoryTesten {
    private OverzichtFactory of;
    private ActiviteitenRepository ar;
    private OverzichtRaadplegingenRepository orr;
    private InschrijvingenRepository ir;
    private List<Sessie> sessies;
    private List<Lid> leden;
    private List<PrototypeRaadpleging> raadplegingen;
    
    @Before
    public void Before(){
        ar = Mockito.mock(ActiviteitenRepository.class);
        orr = Mockito.mock(OverzichtRaadplegingenRepository.class);
        ir = Mockito.mock(InschrijvingenRepository.class);
        sessies = new ArrayList<>();
        leden = new ArrayList<>();
        raadplegingen = new ArrayList<>();
        sessies.add(new Sessie(1,"az","azer",new Date(),true));
        leden.add(new Lid(new Address("Gent", "Emanuel Hieldstraat",9,9000,null),domein.Module.DIDO,"adf","Gedef","Pirene",new Date()));
        raadplegingen.add(new PrototypeRaadpleging(new Raadpleging(new Lid(new Address("Gent", "Emanuel Hieldstraat",9,9000,null),domein.Module.DIDO,"adf","Gedef","Pirene",new Date()),new LesMateriaal(14,"les","guylianbollon@gmail.com"),new Date())));
    }
    
    @Test
    public void maakLijstSessies(){
        Mockito.when(ar.getOverzichten()).thenReturn(sessies);
        Mockito.when(orr.getOverzichten()).thenReturn(raadplegingen);
        Mockito.when(ir.getOverzichten()).thenReturn(leden);
        List<?> overzichten = of.ontwikkelOverzicht(Overzichttype.ACTIVITEITEN);
        Assert.assertEquals(sessies,overzichten);
        Mockito.verify(ar).getOverzichten();
    }
    
    @Test
    public void maakLijstLeden(){
        Mockito.when(ar.getOverzichten()).thenReturn(sessies);
        Mockito.when(orr.getOverzichten()).thenReturn(raadplegingen);
        Mockito.when(ir.getOverzichten()).thenReturn(leden);
        List<?> overzichten = of.ontwikkelOverzicht(Overzichttype.INSCHRIJVINGEN);
        Assert.assertEquals(leden,overzichten);
        Mockito.verify(ir).getOverzichten();
    }
    
    @Test
    public void maakLijstRaadplegingen(){
        Mockito.when(ar.getOverzichten()).thenReturn(sessies);
        Mockito.when(orr.getOverzichten()).thenReturn(raadplegingen);
        Mockito.when(ir.getOverzichten()).thenReturn(leden);
        List<?> overzichten = of.ontwikkelOverzicht(Overzichttype.OVERZICHTRAADPLEGINGENLESMATERIAAL);
        Assert.assertEquals(raadplegingen,overzichten);
        Mockito.verify(orr).getOverzichten();
    }
}
