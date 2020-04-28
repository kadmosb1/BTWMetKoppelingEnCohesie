import java.util.ArrayList;

public class Wereld {

    public Wereld () {
        werelddelen = new ArrayList<> ();
    }

    /*
     * De wereld bestaat voor de BTW in Nederland uit drie delen:
     * - Nederland (waar klanten 21% BTW moeten betalen).
     * - Europa buiten Nederland (waar klanten vrijgesteld zijn van het betalen van BTW).
     * - Wereld buiten Europa (waar klanten weer 21% BTW moeten betalen).
     */
    private class Werelddeel {

        private String naam;
        private ArrayList<Land> landen;

        public Werelddeel(String naam) {
            this.naam = naam;
            landen = new ArrayList<>();
        }

        public String getNaam () {
            return naam;
        }

        public void addLand(Land land) {
            landen.add(land);
        }

        public Land getLand(Klant klant) {

            String landcode = klant.getBtwNummer().substring(0, 2);

            for (Land land : landen) {

                if (land.getLandcode ().equals (landcode)) {
                    return land;
                }
            }

            return null;
        }
    }

    private ArrayList<Werelddeel> werelddelen;

    /*
     * Ik wil het BTW-percentage berekenen op basis van Nederland (21%), Europa
     * buiten Nederland (0%) en wereld buiten Europa (21%).
     */
    public double getBTWPercentage (Klant klant) {

        for (Werelddeel werelddeel : werelddelen) {

            Land land = werelddeel.getLand (klant);

            /*
             * Als ik een land gevonden heb die hoort bij de klant, kijk
             * ik uit welk gebied de klant afkomstig is.
             */
            if (werelddeel.getLand (klant) != null) {

                if (werelddeel.getNaam ().equals ("Europa")) {

                    /*
                     * Nederland: 21%.
                     */
                    if (land.getLandcode().equals ("NL")) {
                        return 21.0;
                    }

                    /*
                     * Europa buiten Nederland: 0%.
                     */
                    else {
                        return 0.0;
                    }
                }

                /*
                 * Wereld buiten Europa: 21%
                 */
                else {
                    return 21.0;
                }
            }
        }

        /*
         * Als het land niet voorkomt in de wereld, wordt 21% in rekening gebracht.
         */
        return 21.0;
    }

    public void addContinent (String naam) {
        werelddelen.add (new Werelddeel (naam));
    }

    public void addLand (String naamWerelddeel, Land land) {

        for (Werelddeel werelddeel : werelddelen) {

            if (werelddeel.getNaam ().equals (naamWerelddeel)) {
                werelddeel.addLand (land);
            }
        }
    }
}