package ru.javarush.golf.podkopaev.islandmodel.animals.predators;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;

public class Wolf extends Predator{

    public Wolf(int x, int y){
        super(x,y);
        weight = 50;
        maxFullness = 8;
        speed = 3;
        ProbabilityOfEatHorse = 10;
        ProbabilityOfEatDeer = 15;
        ProbabilityOfEatRabbit = 60;
        ProbabilityOfEatMouse = 80;
        ProbabilityOfEatGoat = 60;
        ProbabilityOfEatSheep = 70;
        ProbabilityOfEatBoar = 15;
        ProbabilityOfEatBuffalo = 10;
        ProbabilityOfEatDuck = 40;
        fullness = maxFullness /4;
    }

    @Override
    public Wolf reproduce(Animal animal) {
        return new Wolf(x,y);
    }
}
