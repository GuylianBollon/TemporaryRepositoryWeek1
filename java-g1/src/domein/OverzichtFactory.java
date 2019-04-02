package domein;

import java.util.List;

public class OverzichtFactory {

	private Overzicht overz;

	/**
	 * 
	 * @param oz
     * @return 
	 */
	public List<?> ontwikkelOverzicht(Overzichttype oz) {
		if(oz == Overzichttype.ACTIVITEITEN){
                    overz = new ActiviteitenRepository();
                }
                if(oz == Overzichttype.INSCHRIJVINGEN){
                    overz = new InschrijvingenRepository();
                }
                if(oz == Overzichttype.OVERZICHTRAADPLEGINGENLESMATERIAAL){
                    overz = new OverzichtRaadplegingenRepository();
                }
                return overz.getOverzichten();
	}

}