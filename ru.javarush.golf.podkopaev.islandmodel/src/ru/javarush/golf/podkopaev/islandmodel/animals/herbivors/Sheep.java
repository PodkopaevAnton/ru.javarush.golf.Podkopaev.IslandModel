package ru.javarush.golf.podkopaev.islandmodel.animals.herbivors;


import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;

public class Sheep  extends Herbivore{

    public Sheep(int x, int y) {
        super(x, y);
        weight = 70;
        maxFullness = 15;
        speed = 3;
        fullness = maxFullness /4;
    }

    @Override
    public Sheep reproduce(Animal animal) {
        return new Sheep(x,y);
    }
}
