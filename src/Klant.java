public class Klant {

    private String naam;
    private String btwNummer;
    private BTW btw;

    public Klant (String naam, String btwNummer, BTW btw) {
        this.naam = naam;
        this.btwNummer = btwNummer;
        this.btw = btw;
    }

    public String getBtwNummer () {
        return btwNummer;
    }

    public double getBTWPercentage () {
        return btw.getBTWPercentage(this);
    }
}
