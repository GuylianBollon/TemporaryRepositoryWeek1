package domein;

import java.util.List;

public class DomeinController {

	private OverzichtTypeRepository overzichtTypeRepos;
	private OverzichtFactory oz;
        
        public DomeinController(){
            overzichtTypeRepos = new OverzichtTypeRepository();
            oz = new OverzichtFactory();
        }

	public List<Overzichttype> geefOverzicht() {
		return overzichtTypeRepos.geefOverzichttypes();
	}

	/**
	 * 
	 * @param oz
     * @return 
	 */
	public List<?> maakOverzicht(Overzichttype oz) {
		return this.oz.ontwikkelOverzicht(oz);
	}

}