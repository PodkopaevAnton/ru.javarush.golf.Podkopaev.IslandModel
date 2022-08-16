package ru.javarush.golf.podkopaev.islandmodel.animals.herbivors;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;
import ru.javarush.golf.podkopaev.islandmodel.animals.Bio;
import ru.javarush.golf.podkopaev.islandmodel.util.Randomizer;

public class Boar extends Herbivore{

    int ProbabilityOfEatCaterpillar = 90;
    int ProbabilityOfEatMouse = 50;

    public Boar(int x, int y) {
        super(x, y);
        weight = 400;
        maxFullness = 50;
        speed = 2;
        fullness = maxFullness /4;
    }

    @Override
    public boolean eat(Bio bio) {
            if (bio instanceof Caterpillar) {
                if (Randomizer.getProbability(ProbabilityOfEatCaterpillar)) {
                    return true;
                }
            } else if (bio instanceof Mouse) {
                if (Randomizer.getProbability(ProbabilityOfEatMouse)) {
                    return true;
                }
            }
        return super.eat(bio);
    }

    @Override
    public Boar reproduce(Animal animal) {
        return new Boar(x,y);
    }
}
