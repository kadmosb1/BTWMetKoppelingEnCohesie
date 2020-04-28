public class BTW {

    private Wereld wereld;

    public BTW (Wereld wereld) {
        this.wereld = wereld;
    }

    public double getBTWPercentage (Klant klant) {
        return wereld.getBTWPercentage (klant);
    }
}
