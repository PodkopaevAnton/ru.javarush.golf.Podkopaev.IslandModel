package ru.javarush.golf.podkopaev.islandmodel.animals.herbivors;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;
import ru.javarush.golf.podkopaev.islandmodel.animals.Bio;
import ru.javarush.golf.podkopaev.islandmodel.plants.Plant;

public class Herbivore extends Animal {

    public Herbivore(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean eat(Bio bio) {
        return bio instanceof Plant;
    }

}
