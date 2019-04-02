package domein;

import java.util.*;
import persistentie.LedenMapper;

public class InschrijvingenRepository implements Overzicht {

        private LedenMapper lm;

    public InschrijvingenRepository() {
        lm = new LedenMapper();
    }
        

        @Override
	public List<Lid> getOverzichten() {
		return lm.geefAlleLeden();
	}

}