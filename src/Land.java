public class Land {

    private String naam;
    private String landcode;

    public Land (String naam, String landcode) {
        this.naam = naam;
        this.landcode = landcode;
    }

    public String getLandcode () {
        return landcode;
    }
}
