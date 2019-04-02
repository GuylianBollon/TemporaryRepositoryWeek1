package domein;

import java.util.*;
import persistentie.OverzichtRaadplegingenMapper;

public class OverzichtRaadplegingenRepository implements Overzicht {
        private OverzichtRaadplegingenMapper orm;

    public OverzichtRaadplegingenRepository() {
        orm = new OverzichtRaadplegingenMapper();
    }

        
        @Override
	public List<PrototypeRaadpleging> getOverzichten() {
		return orm.geefAlleOverzichtenVanRaadplegingen();
	}

}