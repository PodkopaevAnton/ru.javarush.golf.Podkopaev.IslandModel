package ru.javarush.golf.podkopaev.islandmodel.animals.herbivors;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;

public class Horse extends Herbivore{

    public Horse(int x, int y){
        super(x,y);
        weight = 400;
        maxFullness = 60;
        speed = 4;
        fullness = maxFullness /4;
    }

    @Override
    public Horse reproduce(Animal animal) {
        return new Horse(x,y);
    }
}
