/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testen;

import domein.OverzichtTypeRepository;
import domein.Overzichttype;
import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Hp
 */
public class OverzichtTypeRepositoryTest {
    private OverzichtTypeRepository otr;
    private ArrayList<Overzichttype> alo;
    
    @Before
    public void before(){
        alo = new ArrayList<>(Arrays.asList(Overzichttype.values()));
    }
    @Test
    public void test(){
        Assert.assertEquals(alo, otr.geefOverzichttypes());
    }
}
