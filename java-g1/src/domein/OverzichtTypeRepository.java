package domein;

import java.util.*;

public class OverzichtTypeRepository {

	public List<Overzichttype> geefOverzichttypes(){
            return new ArrayList<>(Arrays.asList(Overzichttype.values()));
	}

}