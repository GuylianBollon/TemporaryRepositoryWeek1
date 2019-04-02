package domein;

import java.util.Date;

public class Sessie {

	private int id;
	private String naam;
	private String beschrijving;
	private Date datum;
	private boolean gestart;

    public Sessie(int id, String naam, String beschrijving, Date datum, boolean gestart) {
        this.id = id;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.datum = datum;
        this.gestart = gestart;
    }

}