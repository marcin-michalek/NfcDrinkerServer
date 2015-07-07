/**
 * Created by Marcin Michałek on 2015-01-02.
 *
 */
package pl.michalek.marcin.nfcdrinkerserver.model;

import pl.michalek.marcin.nfcdrinkerserver.config.DrinkingConstants;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * TODO Add class description...
 *
 * @author Marcin Michałek
 */

public class Drinker implements Serializable, Comparable<Drinker> {
    private String name;
    private double age;
    private double weight;
    private double height;
    private String stomach;
    private String gender;
    private String alcoholKind;
    private double alcoholVoltage;
    private double shotCapacity;
    private double currentSimpleMethodPromile;
    private DrinkingParameters drinkingParameters;

    @Override
    public int hashCode() {
        return new HashCodeBuilder(1, 11)
                .append(name)
                .append(age)
                .append(weight)
                .append(height)
                .append(stomach)
                .append(gender)
                .append(alcoholKind)
                .append(alcoholVoltage)
                .append(shotCapacity)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Drinker))
            return false;
        if (obj == this)
            return true;

        Drinker drinker = (Drinker) obj;
        return new EqualsBuilder()
                .append(name, drinker.name)
                .append(age, drinker.age)
                .append(weight, drinker.weight)
                .append(height, drinker.height)
                .append(stomach, drinker.stomach)
                .append(gender, drinker.gender)
                .append(alcoholKind, drinker.alcoholKind)
                .append(alcoholVoltage, drinker.alcoholVoltage)
                .append(shotCapacity, drinker.shotCapacity)
                .isEquals();
    }

    public void calculateCurrentPromilsSimpleMethod(){
        currentSimpleMethodPromile = (shotCapacity * (alcoholVoltage/100) * DrinkingConstants.ALCOHOL_DENSITY_GRAM_PER_MILLILITER)
                / weight * DrinkingConstants.WATER_IN_BODY_PERCENTAGE.get(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getStomach() {
        return stomach;
    }

    public void setStomach(String stomach) {
        this.stomach = stomach;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAlcoholKind() {
        return alcoholKind;
    }

    public void setAlcoholKind(String alcoholKind) {
        this.alcoholKind = alcoholKind;
    }

    public double getAlcoholVoltage() {
        return alcoholVoltage;
    }

    public void setAlcoholVoltage(double alcoholVoltage) {
        this.alcoholVoltage = alcoholVoltage;
    }

    public DrinkingParameters getDrinkingParameters() {
        drinkingParameters.updateMinutesFromFirstDrink();
        return drinkingParameters;
    }

    public void setDrinkingParameters(DrinkingParameters drinkingParameters) {
        this.drinkingParameters = drinkingParameters;
    }

    @Override
    public int compareTo( Drinker o) {
        return Integer.compare(o.getDrinkingParameters().getRounds(), this.getDrinkingParameters().getRounds());
    }

    public double getShotCapacity() {
        return shotCapacity;
    }

    public void setShotCapacity(double shotCapacity) {
        this.shotCapacity = shotCapacity;
    }

    public double getCurrentSimpleMethodPromile() {
        return currentSimpleMethodPromile;
    }

    public void setCurrentSimpleMethodPromile(double currentSimpleMethodPromile) {
        this.currentSimpleMethodPromile = currentSimpleMethodPromile;
    }
}
