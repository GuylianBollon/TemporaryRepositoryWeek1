package domein;

import java.util.*;
import persistentie.SessieMapper;

public class ActiviteitenRepository implements Overzicht {
        private SessieMapper sm;

    public ActiviteitenRepository() {
        sm = new SessieMapper();
    }

        @Override
	public List<Sessie> getOverzichten() {
		return sm.geefSessies();
	}

}