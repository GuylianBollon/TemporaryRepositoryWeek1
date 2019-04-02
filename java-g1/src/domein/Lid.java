package domein;

import java.util.Date;

public class Lid {

	private Address adres;
	private Module mode;
	private String id;
	private String naam;
	private String voorNaam;
	private Date geboorteDatum;

	public String getId() {
		return this.id;
	}

    public Lid(Address adres, Module mode, String id, String naam, String voorNaam, Date geboorteDatum) {
        this.adres = adres;
        this.mode = mode;
        this.id = id;
        this.naam = naam;
        this.voorNaam = voorNaam;
        this.geboorteDatum = geboorteDatum;
    }

        
}