package application;

import java.io.Serializable;

/**
 * Created by Marcin on 2015-01-03.
 */
public class DrinkingParameters implements Serializable {
    private int rounds;

    public void increaseRounds(){
        rounds++;
    }

    public void increaseRounds(int howMany){
        rounds += howMany;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
}
