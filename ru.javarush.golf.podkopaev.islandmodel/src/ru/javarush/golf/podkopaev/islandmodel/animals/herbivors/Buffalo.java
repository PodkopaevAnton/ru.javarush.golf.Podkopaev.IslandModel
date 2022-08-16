package ru.javarush.golf.podkopaev.islandmodel.animals.herbivors;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;

public class Buffalo extends Herbivore{

    public Buffalo(int x, int y) {
        super(x, y);
        weight = 700;
        maxFullness = 100;
        speed = 3;
        fullness = maxFullness /4;
    }

    @Override
    public Buffalo reproduce(Animal animal) {
        return new Buffalo(x,y);
    }
}
