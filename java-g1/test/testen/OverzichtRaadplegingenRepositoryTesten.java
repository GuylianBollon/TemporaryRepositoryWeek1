/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testen;

import domein.Address;
import domein.LesMateriaal;
import domein.Lid;
import domein.OverzichtRaadplegingenRepository;
import domein.PrototypeRaadpleging;
import domein.Raadpleging;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import persistentie.OverzichtRaadplegingenMapper;

/**
 *
 * @author Hp
 */
public class OverzichtRaadplegingenRepositoryTesten {
    private OverzichtRaadplegingenRepository orr;
    private List<PrototypeRaadpleging> lr;
    private OverzichtRaadplegingenMapper orm;
    
    @Before
    public void before(){
        orr = new OverzichtRaadplegingenRepository();
        orm = Mockito.mock(OverzichtRaadplegingenMapper.class);
        lr = new ArrayList<>();
        Raadpleging r = new Raadpleging(new Lid(new Address("Gent", "Emanuel Hieldstraat",9,9000,null),domein.Module.DIDO,"adf","Gedef","Pirene",new Date()),new LesMateriaal(14,"les","guylianbollon@gmail.com"),new Date());
        lr.add(new PrototypeRaadpleging(r));
    }
    
    @Test
    public void test(){
        Mockito.when(orm.geefAlleOverzichtenVanRaadplegingen()).thenReturn(lr);
        List<PrototypeRaadpleging> lp = orr.getOverzichten();
        Assert.assertEquals(lr,lp);
        Mockito.verify(orm).geefAlleOverzichtenVanRaadplegingen();
    }
}
