package Game;

public class Army {
    private double strenght;
    private int size;
    private double health;
    private double maxHealth;
    private double defense;

    public Army() {
        setStrenght();
        this.size = 1;
        setHealth();
        setDefense();
    }

    // upgrades
    public void bonusDefense(double multiplier) {
        defense = defense * multiplier;
    }
    public void healing(double add) {
        if ((health + add) > maxHealth) {
            health +=  add;
        }else {
            health = maxHealth;
        }
    }
    public void bonusStrenght(double multiplier) {
        strenght = strenght * multiplier;
    }
    public void biggerSize(int add){
        size = size + add;
    }

    // setters
    public void setStrenght() {
        this.strenght = size*10;
    }

    public int getSize() {
        return size;
    }

    public void setHealth() {
        this.health = size*15;
        this.maxHealth = size*15;
    }

    public void setDefense() {
        this.defense = size*5;
    }
// getters
    public double getStrenght() {
        return strenght;
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
                "síla = " + strenght +
                ", velikost = " + size +
                ", životy = " + health +
                ", obrana = " + defense +
                '}';
    }
}
