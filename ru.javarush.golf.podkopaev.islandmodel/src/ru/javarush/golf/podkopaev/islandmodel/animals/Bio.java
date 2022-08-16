package ru.javarush.golf.podkopaev.islandmodel.animals;

public class Bio {

    protected double weight;

    public double getWeight() {
        return weight;
    }

    public String getName(){
        return this.getClass().getSimpleName();
    }

}
