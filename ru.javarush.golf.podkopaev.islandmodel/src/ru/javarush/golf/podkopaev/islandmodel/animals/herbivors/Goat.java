package ru.javarush.golf.podkopaev.islandmodel.animals.herbivors;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;

public class Goat extends Herbivore{

    public Goat(int x, int y) {
        super(x, y);
        weight = 60;
        maxFullness = 10;
        speed = 3;
        fullness = maxFullness /4;
    }

    @Override
    public Goat reproduce(Animal animal) {
        return new Goat(x,y);
    }

}
