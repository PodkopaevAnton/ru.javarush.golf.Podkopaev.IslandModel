package ru.javarush.golf.podkopaev.islandmodel.animals.herbivors;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;

public class Caterpillar extends Herbivore{

    public Caterpillar(int x, int y) {
        super(x, y);
        weight = 0.01;
        maxFullness = 0.001;
        speed = 4;
        fullness = maxFullness /2;
    }

    @Override
    public Caterpillar reproduce(Animal animal) {
        return new Caterpillar(x,y);
    }
}
