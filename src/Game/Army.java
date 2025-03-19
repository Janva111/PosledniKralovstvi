package Game;

import Command.Others.Ukoncit;

public class Army {

    private int size = 100;
    private double lostHealth = 0.0;
    private double maxHealth;
    private double defense;
    private double strenght;

    public Army() {
        setMaxHealth();
        setDefense();
        setStrenght();
    }

    public void controlHealt() {
        if ((maxHealth - lostHealth) <= 0) {
            System.out.println("Armada nemá životy. Tvá cesta je u konce.");
            System.exit(0);
        }
    }

    // upgrades
    public void bonusDefense(double multiplier) {
        defense = defense * multiplier;
    }

    public void healing(double add) {
        if (((maxHealth - lostHealth) + add) > maxHealth) {
            lostHealth -= add;
        } else {
            lostHealth = 0;
        }
    }

    public void bonusStrenght(double multiplier) {
        strenght = strenght * multiplier;
    }

    public void bonusMaxHealth(double multiplier) {
        maxHealth = maxHealth * multiplier;
    }

    public void changeSize(int add) {
        size = size + add;
    }
    public void changeLostHealth(double add){
       lostHealth = lostHealth + add;
    }

    // setters


    public void setLostHealth(double lostHealth) {
        this.lostHealth += lostHealth;
    }

    public void setStrenght() {
        this.strenght = size * 10;
    }

    public void setMaxHealth() {
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

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getDefense() {
        return defense;
    }

    public double getLostHealth() {
        return lostHealth;
    }

    @Override
    public String toString() {
        return "{" +
                "velikost = " + size +
                ", síla = " + strenght +
                ", životy = " + (maxHealth - lostHealth) +"/"+maxHealth +
                ", obrana = " + defense +
                '}';
    }

}
