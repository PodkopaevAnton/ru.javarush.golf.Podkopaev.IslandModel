package ru.javarush.golf.podkopaev.islandmodel.animals.predators;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;
import ru.javarush.golf.podkopaev.islandmodel.animals.Bio;
import ru.javarush.golf.podkopaev.islandmodel.util.Randomizer;


public class Eagle extends Predator{

    int ProbabilityOfEatFox = 10;

    public Eagle(int x, int y) {
        super(x, y);
        weight = 6;
        maxFullness = 1;
        speed = 3;
        ProbabilityOfEatHorse = 0;
        ProbabilityOfEatDeer = 0;
        ProbabilityOfEatRabbit = 90;
        ProbabilityOfEatMouse = 90;
        ProbabilityOfEatGoat = 0;
        ProbabilityOfEatSheep = 0;
        ProbabilityOfEatBoar = 0;
        ProbabilityOfEatBuffalo = 0;
        ProbabilityOfEatDuck = 80;
        fullness = maxFullness /4;
    }

    @Override
    public boolean eat(Bio bio) {
            if (bio instanceof Fox) {
                if (Randomizer.getProbability(ProbabilityOfEatFox)) {
                    return true;
                }
            }
        return super.eat(bio);
    }

    @Override
    public Eagle reproduce(Animal animal) {
        return new Eagle(x,y);
    }
}
