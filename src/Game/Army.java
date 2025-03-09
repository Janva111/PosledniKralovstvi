package Game;

public class Army {

    private int size = 0;
    private double health;
    private double maxHealth;
    private double defense;
    private double strenght;

    public Army() {
        setHealth();
        setDefense();
        setStrenght();
    }

    // upgrades
    public void bonusDefense(double multiplier) {
        defense = defense * multiplier;
    }

    public void healing(double add) {
        if ((health + add) > maxHealth) {
            health += add;
        } else {
            health = maxHealth;
        }
    }

    public void bonusStrenght(double multiplier) {
        strenght = strenght * multiplier;
    }

    public void biggerSize(int add) {
        size = size + add;
    }

    // setters

    public void setStrenght() {
        this.strenght = size*10;
    }

    public void setHealth() {
        this.health = size * 15;
        this.maxHealth = size * 15;
    }

    public void setDefense() {
        this.defense = size * 5;
    }

    // getters
    public double getStrenght() {
        return strenght;
    }

    public int getSize() {
        return size;
    }

    public double getHealth() {
        return health;
    }

    public double getDefense() {
        return defense;
    }

    @Override
    public String toString() {
        return "{" +
                ", velikost = " + size +
                "síla = " + strenght +
                ", životy = " + health +
                ", obrana = " + defense +
                '}';
    }
}
