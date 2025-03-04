package Game;

public class Army {
    private int strenght;
    private int size;
    private int health;
    private int defense;

    public Army(int strenght, int size, int health, int defense) {
        this.strenght = strenght;
        this.size = size;
        this.health = health;
        this.defense = defense;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
