package ru.javarush.golf.podkopaev.islandmodel.animals.herbivors;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;

public class Deer extends Herbivore{

    public Deer(int x, int y) {
        super(x, y);
        weight = 400;
        maxFullness = 50;
        speed = 4;
        fullness = maxFullness /4;
    }

    @Override
    public Deer reproduce(Animal animal) {
        return new Deer(x,y);
    }
}
