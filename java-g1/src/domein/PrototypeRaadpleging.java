package domein;

import java.util.Date;

public class PrototypeRaadpleging {

	private LesMateriaal lesmateriaal;
	private String id;
	private Date datum;

	/**
	 * 
	 * @param r
	 */
	public PrototypeRaadpleging(Raadpleging r) {
		lesmateriaal = r.getLesMateriaal();
                id = r.getGeraadpleegdLid().getId();
                datum = r.getDatum();
	}

}