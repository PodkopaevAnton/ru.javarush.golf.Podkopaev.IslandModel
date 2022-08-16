package ru.javarush.golf.podkopaev.islandmodel.animals.predators;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;
import ru.javarush.golf.podkopaev.islandmodel.animals.Bio;
import ru.javarush.golf.podkopaev.islandmodel.util.Randomizer;

public class Bear extends Predator{

    int ProbabilityOfEatBoa = 80;

    public Bear(int x, int y) {
        super(x, y);
        weight = 500;
        maxFullness = 80;
        speed = 2;
        ProbabilityOfEatHorse = 40;
        ProbabilityOfEatDeer = 80;
        ProbabilityOfEatRabbit = 80;
        ProbabilityOfEatMouse = 90;
        ProbabilityOfEatGoat = 70;
        ProbabilityOfEatSheep = 70;
        ProbabilityOfEatBoar = 50;
        ProbabilityOfEatBuffalo = 20;
        ProbabilityOfEatDuck = 10;
        fullness = maxFullness /4;
    }

    @Override
    public boolean eat(Bio bio) {
            if (bio instanceof Boa) {
                if (Randomizer.getProbability(ProbabilityOfEatBoa)) {
                    return true;
                }
            }
        return super.eat(bio);
    }

    @Override
    public Bear reproduce(Animal animal) {
        return new Bear(x,y);
    }

}
