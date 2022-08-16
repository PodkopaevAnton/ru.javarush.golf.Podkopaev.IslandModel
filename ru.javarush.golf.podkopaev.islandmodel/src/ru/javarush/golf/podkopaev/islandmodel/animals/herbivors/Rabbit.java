package ru.javarush.golf.podkopaev.islandmodel.animals.herbivors;


import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;

public class Rabbit extends Herbivore{

    public Rabbit(int x, int y) {
        super(x, y);
        weight = 2;
        maxFullness = 0.45;
        speed = 2;
        fullness = maxFullness /4;
    }

    @Override
    public Rabbit reproduce(Animal animal) {
        return new Rabbit(x,y);
    }

}
