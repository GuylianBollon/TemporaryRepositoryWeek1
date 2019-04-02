/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testen;

import domein.Address;
import domein.InschrijvingenRepository;
import domein.Lid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import persistentie.LedenMapper;

/**
 *
 * @author Hp
 */
public class InschrijvingenRepositoryTest {
    private InschrijvingenRepository ir;
    private LedenMapper lm;
    private List<Lid> ll;
    @Before
    public void before(){
        ir = new InschrijvingenRepository();
        ll = new ArrayList<>();
        ll.add(new Lid(new Address("Gent", "Emanuel Hieldstraat",9,9000,null),domein.Module.DIDO,"adf","Gedef","Pirene",new Date()));
        lm = Mockito.mock(LedenMapper.class);
    }
    @Test
    public void test(){
        Mockito.when(lm.geefAlleLeden()).thenReturn(ll);
        List<Lid> leden = ir.getOverzichten();
        Assert.assertEquals(ll, leden);
        Mockito.verify(lm).geefAlleLeden();
    }
}
