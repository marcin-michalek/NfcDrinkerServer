package pl.michalek.marcin.nfcdrinkerserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Marcin on 2015-01-03.
 */
public class DrinkingParameters implements Serializable {
    @JsonIgnore
    private long firstDrinkTimestamp;

    private double minutesFromFirstDrink;
    private int rounds;

    public DrinkingParameters() {
        firstDrinkTimestamp = new Date().getTime();
    }

    public void increaseRounds() {
        rounds++;
    }

    public void increaseRounds(int howMany) {
        rounds += howMany;
    }

    public void updateMinutesFromFirstDrink(){
        minutesFromFirstDrink = getMinutesFromFirstDrinkToNow();
    }

    public double getMinutesFromFirstDrinkToNow() {
        return (new Date().getTime() - firstDrinkTimestamp) / 60000;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public long getFirstDrinkTimestamp() {
        return firstDrinkTimestamp;
    }

    public void setFirstDrinkTimestamp(long firstDrinkTimestamp) {
        this.firstDrinkTimestamp = firstDrinkTimestamp;
    }

    public double getMinutesFromFirstDrink() {
        return minutesFromFirstDrink;
    }

    public void setMinutesFromFirstDrink(double minutesFromFirstDrink) {
        this.minutesFromFirstDrink = minutesFromFirstDrink;
    }
}
