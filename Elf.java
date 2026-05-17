public class Elf extends GameCharacter {
    //CONSTANT VARIABLES
    public static final String DEFAULT_NAME = "Legolas", DEFAULT_CLASS_TYPE = "Druid", DEFAULT_ALIGNMENT = "Neutral";
    public static final int DEFAULT_GOLD = 1000000, DEFAULT_EXP_POINTS = 1, DEFAULT_HIT_POINTS = 0, DEFAULT_ARMOR_CLASS = 1;
    public static final Weapon DEFAULT_WEAPON1 = new Weapon("Crossbow", 6, 30, 3), DEFAULT_WEAPON2 = new Weapon();

    //CONSTRUCTORS
    public Elf(String name, String classType, String alignment, int gold, int expPoints,
            int hitPoint, int armorClass, Weapon weapon1, Weapon weapon2) {
            super(name, classType, alignment, gold, expPoints, hitPoint, armorClass, weapon1, weapon2);
    }

    public Elf() {
        this(Elf.DEFAULT_NAME, Elf.DEFAULT_CLASS_TYPE, Elf.DEFAULT_ALIGNMENT, Elf.DEFAULT_GOLD, Elf.DEFAULT_EXP_POINTS,
                Elf.DEFAULT_HIT_POINTS, Elf.DEFAULT_ARMOR_CLASS, Elf.DEFAULT_WEAPON1, Elf.DEFAULT_WEAPON2);
    }

    public Elf(Elf original) {
        super(original);
    }

    @Override
    public void assist(GameCharacter other) {
        if (other instanceof Elf) {
            int healed = other.getHitPoint() + 10;
            other.setHitPoint(healed);
            System.out.println("Healed ally by 10 points!");
        } else {
            int goldUpdated = other.getGold() + 5;
            other.setGold(goldUpdated);
            System.out.println("Gave ally 5 gold!");
        }
    }

    @Override
    public boolean attack(GameCharacter other) {
        int attackDamage = this.getExpPoints() / other.getArmorClass();
        int updatedHitPoints = other.getHitPoint();

        if (attackDamage >= updatedHitPoints) {
            other.setHitPoint(0);
            System.out.println("Opponent is KO'd!");
            return true; //function only returns true if opponent is KO'd.
        } else {
            updatedHitPoints = updatedHitPoints - attackDamage;
            other.setHitPoint(updatedHitPoints);
            System.out.println("Did " + attackDamage + " points of damage.");
            return false; //function returns false if opponent survived the attack.
        }
    }
}
