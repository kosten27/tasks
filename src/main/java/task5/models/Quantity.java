package task5.models;

public class Quantity {
    private final String name;
    private final String nameGenitive;
    private final String nameGenitivePlural;
    private final Genus genus;

    Quantity(String name, String nameGenitive, String nameGenitivePlural, Genus genus) {
        this.name = name;
        this.nameGenitive = nameGenitive;
        this.nameGenitivePlural = nameGenitivePlural;
        this.genus = genus;
    }

    public String getName() {
        return name;
    }

    public String getNameGenitive() {
        return nameGenitive;
    }

    public String getNameGenitivePlural() {
        return nameGenitivePlural;
    }

    public Genus getGenus() {
        return genus;
    }
}
