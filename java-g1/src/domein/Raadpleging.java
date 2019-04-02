package domein;

import java.util.Date;

public class Raadpleging {

	private Lid geraadpleegdLid;
	private LesMateriaal lesMateriaal;
	private Date datum;

    public Raadpleging(Lid geraadpleegdLid, LesMateriaal lesMateriaal, Date datum) {
        this.geraadpleegdLid = geraadpleegdLid;
        this.lesMateriaal = lesMateriaal;
        this.datum = datum;
    }

    public Lid getGeraadpleegdLid() {
        return geraadpleegdLid;
    }

    public LesMateriaal getLesMateriaal() {
        return lesMateriaal;
    }

    public Date getDatum() {
        return datum;
    }
    

}