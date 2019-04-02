/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testen;

import domein.ActiviteitenRepository;
import domein.Sessie;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import persistentie.SessieMapper;

/**
 *
 * @author Hp
 */
public class ActiviteitenRepositoryTesten {
    private SessieMapper sm;
    private ActiviteitenRepository ar;
    private List<Sessie> sessieLijst;
    
    @Before
    public void before(){
        ar = new ActiviteitenRepository();
        sessieLijst = new ArrayList<>();
        sessieLijst.add(new Sessie(1,"az","azer",new Date(),true));
        sm = Mockito.mock(SessieMapper.class);
    }
    
    @Test
    public void vervolledig(){
        Mockito.when(sm.geefSessies()).thenReturn(sessieLijst);
        List<Sessie> ls = ar.getOverzichten();
        Assert.assertEquals(sessieLijst, ls);
        Mockito.verify(sm).geefSessies();
    }
}
