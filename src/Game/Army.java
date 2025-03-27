package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Represents an army with attributes strength, defense, health, and size.
 * The army can receive upgrades, heal, and take damage.
 */

public class Army {

    private int size;
    private double lostHealth = 0.0;
    private double maxHealth;
    private double defense;
    private double strenght;

    public Army() {
        setMaxHealth();
        setDefense();
        setStrenght();
    }

    /**
     * Loads the starting army size from the "army.txt" file and initializes the map.
     *
     * @return true if the map was loaded successfully, false otherwise.
     */
    public boolean loadArmy(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("army.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                size = Integer.parseInt(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    /**
     * Checks the army's health status. If health reaches zero, the game ends.
     */
    public void controlHealtEnding() {
        if (((maxHealth+defense) - lostHealth) <= 0) {
            System.out.println("Armada nemá životy. Tvá cesta je u konce.");
            System.exit(0);
        }
    }

    // upgrades

    /**
     * Increases the army's defense by a given multiplier.
     *
     * @param multiplier The multiplier to apply to the defense.
     */
    public void bonusDefense(double multiplier) {
        defense = defense * multiplier;
    }

    /**
     * Heals the army by a specified amount.
     *
     * @param add The amount of health to restore.
     */
    public void healing(double add) {
        if (((maxHealth - lostHealth) + add) > maxHealth) {
            lostHealth -= add;
        } else {
            lostHealth = 0;
        }
    }

    /**
     * Increases the army's strength by a given multiplier.
     *
     * @param multiplier The multiplier to apply to the strength.
     */
    public void bonusStrenght(double multiplier) {
        strenght = strenght * multiplier;
    }

    /**
     * Increases the army's maximum health by a given multiplier.
     *
     * @param multiplier The multiplier to apply to the max health.
     */
    public void bonusMaxHealth(double multiplier) {
        maxHealth = maxHealth * multiplier;
    }

    /**
     * Changes the size of the army by a given amount.
     *
     * @param add The amount to increase or decrease the army size.
     */
    public void changeSize(int add) {
        size = size + add;
    }

    /**
     * Increases the lost health (damage taken) by a given amount.
     *
     * @param add The amount of health lost.
     */
    public void changeLostHealth(double add){
       lostHealth = lostHealth + add;
    }

    // setters

    /**
     * Sets the army's strength based on size.
     */
    public void setStrenght() {
        this.strenght = size * 10;
    }

    /**
     * Sets the army's max health based on size.
     */
    public void setMaxHealth() {
        this.maxHealth = size * 15;
    }

    /**
     * Sets the army's defense based on size.
     */
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
