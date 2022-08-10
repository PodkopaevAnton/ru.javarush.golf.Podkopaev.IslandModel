package ru.javarush.golf.Podkopaev.IslandModel.Animals.Herbivors;

import ru.javarush.golf.Podkopaev.IslandModel.Animals.Animal;
import ru.javarush.golf.Podkopaev.IslandModel.Plants.Plant;

public class Herbivore extends Animal {

    public Herbivore(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean eat(Object o) {
        return o instanceof Plant;
    }

}
