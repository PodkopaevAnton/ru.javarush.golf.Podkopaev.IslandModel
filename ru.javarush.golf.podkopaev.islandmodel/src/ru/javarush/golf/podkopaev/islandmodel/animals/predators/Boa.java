package ru.javarush.golf.podkopaev.islandmodel.animals.predators;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;
import ru.javarush.golf.podkopaev.islandmodel.animals.Bio;
import ru.javarush.golf.podkopaev.islandmodel.util.Randomizer;


public class Boa extends Predator {

    int ProbabilityOfEatFox = 15;

    public Boa(int x, int y) {
        super(x, y);
        weight = 15;
        maxFullness = 3;
        speed = 1;
        ProbabilityOfEatHorse = 0;
        ProbabilityOfEatDeer = 0;
        ProbabilityOfEatRabbit = 20;
        ProbabilityOfEatMouse = 40;
        ProbabilityOfEatGoat = 0;
        ProbabilityOfEatSheep = 0;
        ProbabilityOfEatBoar = 0;
        ProbabilityOfEatBuffalo = 0;
        ProbabilityOfEatDuck = 10;
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
    public Boa reproduce(Animal animal) {
        return new Boa(x,y);
    }

}
