package ru.javarush.golf.Podkopaev.IslandModel.Animals.Predators;
import ru.javarush.golf.Podkopaev.IslandModel.Animals.Animal;

import ru.javarush.golf.Podkopaev.IslandModel.Animals.Herbivors.*;
import ru.javarush.golf.Podkopaev.IslandModel.util.Randomizer;


public class Predator extends Animal {
    int horse_ver;
    int deer_ver;
    int rabbit_ver;
    int mouse_ver;
    int goat_ver;
    int sheep_ver;
    int boar_ver;
    int buffalo_ver;
    int duck_ver;
    public Predator(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean eat(Object o) {
        int ver;
            if (o instanceof Horse) {
                ver = horse_ver;
            }else if (o instanceof Deer) {
                ver = deer_ver;
            }else if(o instanceof Rabbit) {
                ver = rabbit_ver;
            }else if(o instanceof Mouse) {
                ver = mouse_ver;
            }else if(o instanceof Goat) {
                ver = goat_ver;
            }else if(o instanceof Sheep) {
                ver = sheep_ver;
            }else if(o instanceof Boar) {
                ver = boar_ver;
            }else if(o instanceof Buffalo) {
                ver = buffalo_ver;
            }else if(o instanceof Duck) {
                ver = duck_ver;
            }else{return false;}
        return Randomizer.getProbability(ver);

    }

}
