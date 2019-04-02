package domein;

public class Address {

	private String stad;
	private String straat;
	private int huisnummer;
	private int postcode;
	private String toevoegingHuisnummer;

    public Address(String stad, String straat, int huisnummer, int postcode, String toevoegingHuisnummer) {
        this.stad = stad;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.toevoegingHuisnummer = toevoegingHuisnummer;
    }
}