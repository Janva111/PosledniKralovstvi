package Game;

public class Army {
    private int strenght;
    private int size;
    private int health;
    private int defense;

    public Army() {
        setStrenght();
        this.size = getSize();
        setHealth();
        setDefense(defense);
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght() {
        this.strenght = size*10;
    }

    public int getSize() {
        return size;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth() {
        this.health = size*15;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = size*5;
    }

    @Override
    public String toString() {
        return "Army{" +
                "strenght=" + strenght +
                ", size=" + size +
                ", health=" + health +
                ", defense=" + defense +
                '}';
    }
}
