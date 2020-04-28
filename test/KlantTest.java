import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KlantTest {

    private Klant klant1;
    private Klant klant2;
    private Klant klant3;

    @Before
    public void init () {
        Wereld wereld = new Wereld ();
        wereld.addContinent ("Europa");
        wereld.addLand ("Europa", new Land ("Nederland", "NL"));
        wereld.addLand ("Europa", new Land ("België", "BE"));
        wereld.addLand ("Duitsland", new Land ("Duitsland", "DE"));
        wereld.addContinent ("Noord-Amerika");
        wereld.addLand ("Noord-Amerika", new Land ("Canada", "CA"));
        wereld.addLand ("Noord-Amerika", new Land ("Amerika", "US"));

        BTW btw = new BTW (wereld);
        klant1 = new Klant ("Kumbaya", "NL 983873927", btw);
        klant2 = new Klant ("Business School of Antwerp", "BE 762058163", btw);
        klant3 = new Klant ("Van Ostayen", "CA 610439260", btw);
    }

    @Test
    public void testBTWPercentages () {
        assertEquals (21.0, klant1.getBTWPercentage (), 0.1);
        assertEquals (0.0, klant2.getBTWPercentage (), 0.1);
        assertEquals (21.0, klant3.getBTWPercentage(), 0.1);
    }
}