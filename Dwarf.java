public class Dwarf extends GameCharacter{
    //CONSTANT VARIABLES
    public static final String DEFAULT_NAME = "Gimli", DEFAULT_CLASS_TYPE = "Cleric", DEFAULT_ALIGNMENT = "Neutral";
    public static final int DEFAULT_GOLD = 1000000, DEFAULT_EXP_POINTS = 1, DEFAULT_HIT_POINTS = 1, DEFAULT_ARMOR_CLASS = 1;
    public static final Weapon DEFAULT_WEAPON1 = new Weapon("Hammer", 6, 1, 4), DEFAULT_WEAPON2 = new Weapon();

    //CONSTRUCTORS
    public Dwarf(String name, String classType, String alignment, int gold, int expPoints,
            int hitPoint, int armorClass, Weapon weapon1, Weapon weapon2) {
            super(name, classType, alignment, gold, expPoints, hitPoint, armorClass, weapon1, weapon2);
    }

    public Dwarf() {
        this(Dwarf.DEFAULT_NAME, Dwarf.DEFAULT_CLASS_TYPE, Dwarf.DEFAULT_ALIGNMENT, Dwarf.DEFAULT_GOLD, Dwarf.DEFAULT_EXP_POINTS,
                Dwarf.DEFAULT_HIT_POINTS, Dwarf.DEFAULT_ARMOR_CLASS, Dwarf.DEFAULT_WEAPON1, Dwarf.DEFAULT_WEAPON2);
    }

    public Dwarf(Dwarf original) {
        super(original);
    }

    @Override
    public void assist(GameCharacter other) {
        if (other instanceof Dwarf) {
            int armorUp = other.getArmorClass() + 10;
            other.setArmorClass(armorUp);
            System.out.println("Increased ally's armor class by 10 points!");
        } else {
            int goldUpdated = other.getGold() + 5;
            other.setGold(goldUpdated);
            System.out.println("Gave ally 5 gold!");
        }
    }

    @Override
    public boolean attack(GameCharacter other) {
        int attackDamage = this.getExpPoints() + this.getWeapon1().getDamage();
        int updatedHitPoints = other.getHitPoint();

        if (attackDamage >= updatedHitPoints) {
            other.setHitPoint(0);
            System.out.println("Opponent is KO'd!");
            return true; //function only returns true if opponent is KO'd.
        } else {
            updatedHitPoints = updatedHitPoints - attackDamage;
            other.setHitPoint(updatedHitPoints);
            System.out.println(this.getName() + " did " + attackDamage + " points of damage to " + other.getName() + ".");
            return false; //function returns false if opponent survived the attack.
        }
    }
}
