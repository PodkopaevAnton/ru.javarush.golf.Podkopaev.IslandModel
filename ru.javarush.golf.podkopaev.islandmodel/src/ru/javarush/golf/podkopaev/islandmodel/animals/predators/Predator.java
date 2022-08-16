package ru.javarush.golf.podkopaev.islandmodel.animals.predators;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;
import ru.javarush.golf.podkopaev.islandmodel.animals.Bio;
import ru.javarush.golf.podkopaev.islandmodel.util.Randomizer;
import ru.javarush.golf.podkopaev.islandmodel.animals.herbivors.*;

public class Predator extends Animal {

    int ProbabilityOfEatHorse;
    int ProbabilityOfEatDeer;
    int ProbabilityOfEatRabbit;
    int ProbabilityOfEatMouse;
    int ProbabilityOfEatGoat;
    int ProbabilityOfEatSheep;
    int ProbabilityOfEatBoar;
    int ProbabilityOfEatBuffalo;
    int ProbabilityOfEatDuck;

    public Predator(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean eat(Bio bio) {
        int probability;
            if (bio instanceof Horse) {
                probability = ProbabilityOfEatHorse;
            }else if (bio instanceof Deer) {
                probability = ProbabilityOfEatDeer;
            }else if(bio instanceof Rabbit) {
                probability = ProbabilityOfEatRabbit;
            }else if(bio instanceof Mouse) {
                probability = ProbabilityOfEatMouse;
            }else if(bio instanceof Goat) {
                probability = ProbabilityOfEatGoat;
            }else if(bio instanceof Sheep) {
                probability = ProbabilityOfEatSheep;
            }else if(bio instanceof Boar) {
                probability = ProbabilityOfEatBoar;
            }else if(bio instanceof Buffalo) {
                probability = ProbabilityOfEatBuffalo;
            }else if(bio instanceof Duck) {
                probability = ProbabilityOfEatDuck;
            }else{return false;}
        return Randomizer.getProbability(probability);
    }

}
