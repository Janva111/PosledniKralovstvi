package City;

import java.util.ArrayList;

public abstract class City {

    protected String Name;
    protected ArrayList<String> legalMovement = new ArrayList<>();

    protected void setName (String name){
        this.Name = name;
    }

    public void setLegalMovement(String legalMovementCity) {
        legalMovement.add(legalMovementCity);
    }
}
