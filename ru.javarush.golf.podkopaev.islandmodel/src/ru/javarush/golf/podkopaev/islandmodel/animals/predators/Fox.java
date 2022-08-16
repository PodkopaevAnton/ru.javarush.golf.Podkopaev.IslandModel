package ru.javarush.golf.podkopaev.islandmodel.animals.predators;
import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;
import ru.javarush.golf.podkopaev.islandmodel.animals.Bio;
import ru.javarush.golf.podkopaev.islandmodel.animals.herbivors.Caterpillar;
import ru.javarush.golf.podkopaev.islandmodel.util.Randomizer;

public class Fox extends Predator{

    int ProbabilityOfEatCaterpillar = 40;

    public Fox(int x, int y) {
        super(x, y);
        weight = 8;
        maxFullness = 2;
        speed = 2;
        ProbabilityOfEatHorse = 0;
        ProbabilityOfEatDeer = 0;
        ProbabilityOfEatRabbit = 70;
        ProbabilityOfEatMouse = 90;
        ProbabilityOfEatGoat = 0;
        ProbabilityOfEatSheep = 0;
        ProbabilityOfEatBoar = 0;
        ProbabilityOfEatBuffalo = 0;
        ProbabilityOfEatDuck = 60;
        fullness = maxFullness /4;
    }

    @Override
    public boolean eat(Bio bio) {
            if (bio instanceof Caterpillar) {
                if (Randomizer.getProbability(ProbabilityOfEatCaterpillar)) {
                    return true;
                }
            }
        return super.eat(bio);
    }

    @Override
    public Fox reproduce(Animal animal) {
        return new Fox(x,y);
    }

}
