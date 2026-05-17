public class Main {
    public static void main(String[] args) {
        Dwarf bruenor = new Dwarf("Bruenor", "Barbarian", "Neutral", 1000000, 1, 10, 10, new Weapon("Axe", 3, 1, 4),
                null);
        System.out.println(bruenor);

        Dwarf gimli = new Dwarf();
        System.out.println(gimli);

        gimli.attack(bruenor);
    }
}