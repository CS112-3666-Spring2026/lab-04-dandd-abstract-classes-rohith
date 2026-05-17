public abstract class GameCharacter {
    // CONSTANT VARIABLES
    public static final String DEFAULT_NAME = "Frodo", DEFAULT_CLASS_TYPE = "Bard", DEFAULT_ALIGNMENT = "Neutral";
    public static final int DEFAULT_GOLD = 100, DEFAULT_EXP_POINTS = 1, DEFAULT_HIT_POINTS = 0, DEFAULT_ARMOR_CLASS = 1;
    public static final Weapon DEFAULT_WEAPON1 = new Weapon(), DEFAULT_WEAPON2 = null;

    public static final String[] VALID_CLASS_TYPES = { "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk",
            "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard" };
    public static final String[] VALID_ALIGNMENTS = { "Lawful Good", "Neutral Good", "Chaotic Good",
            "Lawful Neutral", "Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil",
            "Unaligned" };

    // INSTANCE VARIABLES
    private String name, classType, alignment;
    private int gold, expPoints, hitPoints, armorClass;
    private Weapon weapon1, weapon2;

    //CONSTRUCTORS
    public GameCharacter(String name, String classType, String alignment, int gold, int expPoints,
            int hitPoints, int armorClass, Weapon weapon1, Weapon weapon2) {
        if (!setAll(name, classType, alignment, gold, expPoints, hitPoints, armorClass, weapon1, weapon2)) {
            System.out.println("Data given to constructor is invalid, shutting down the program.");
            System.exit(0);
        }
    }

    public GameCharacter() {
        this(DEFAULT_NAME, DEFAULT_CLASS_TYPE, DEFAULT_ALIGNMENT, DEFAULT_GOLD, DEFAULT_EXP_POINTS,
                DEFAULT_HIT_POINTS, DEFAULT_ARMOR_CLASS, DEFAULT_WEAPON1, DEFAULT_WEAPON2);
    }

    public GameCharacter(GameCharacter original) {
        if (original == null) {
            System.out.println("Data given to copy constructor is null, shutting down the program.");
            System.exit(0);
        } else {
            this.setAll(original.name, original.classType, original.alignment, original.gold, original.expPoints,
                    original.hitPoints, original.armorClass, original.weapon1, original.weapon2);
        }
    }

    // SETTERS
    public boolean setName(String name) {
        if (name != null && name.length() != 0) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    public boolean setClassType(String classType) {
        if (GameCharacter.isInArray(VALID_CLASS_TYPES, classType)) {
            this.classType = classType;
            return true;
        } else {
            return false;
        }
    }

    public boolean setAlignment(String alignment) {
        if (GameCharacter.isInArray(VALID_ALIGNMENTS, alignment)){
            this.alignment = alignment;
            return true;
        } else {
            return false;
        }
    }

    public boolean setExpPoint(int expPoints) {
        if (expPoints >= 0) {
            this.expPoints = expPoints;
            return true;
        } else {
            return false;
        }
    }

    public boolean setGold(int gold) {
        if (gold >= 0) {
            this.gold = gold;
            return true;
        } else {
            return false;
        }
    }

    public boolean setHitPoint(int hitPoints) {
        if (hitPoints >= 0) {
            this.hitPoints = hitPoints;
            return true;
        } else {
            return false;
        }
    }

    public boolean setArmorClass(int armorClass) {
        if (armorClass >= 0) {
            this.armorClass = armorClass;
            return true;
        } else {
            return false;
        }
    }

    public boolean setWeapon1(Weapon weapon) {
        if (weapon != null) {
            this.weapon1 = new Weapon(weapon);
            return true;
        } else {
            return false;
        }
    }

    public boolean setWeapon2(Weapon weapon) {
        if (weapon == null) {
            this.weapon2 = null;
        } else {
            this.weapon2 = new Weapon(weapon);
        }
        return true;
    }

    public boolean setAll(String name, String classType, String alignment, int gold, int expPoints, int hitPoint,
            int armorClass, Weapon weapon1, Weapon weapon2) {
        return setName(name) && setClassType(classType) && setAlignment(alignment) && setGold(gold)
                && setExpPoint(expPoints) && setHitPoint(hitPoint) && setArmorClass(armorClass) && setWeapon1(weapon1)
                && setWeapon2(weapon2);
    }

    //GETTERS
    public String getName() {
        return this.name;
    }

    public String getClassType() {
        return this.classType;
    }

    public String getAlignment() {
        return this.alignment;
    }

    public int getGold() {
        return this.gold;
    }

    public int getExpPoints() {
        return this.expPoints;
    }

    public int getHitPoint() {
        return this.hitPoints;
    }

    public int getArmorClass() {
        return this.armorClass;
    }

    public Weapon getWeapon1() {
        return new Weapon(this.weapon1);
    }

    public Weapon getWeapon2() {
        if (this.weapon2 == null) {
            return null;
        } else {
            return new Weapon(this.weapon2);
        }
    }

    //HELPER METHODS
    private static boolean isInArray(String[] values, String value) {
        if (values == null || value == null) {
            return false;
        }

        int location = 0;
        boolean isPresent = false;

        while (!isPresent && location < values.length) {
            isPresent = values[location].equals(value);
            location++;
        }

        return isPresent;
    }
}
