package ru.javarush.golf.podkopaev.islandmodel.animals.herbivors;

import ru.javarush.golf.podkopaev.islandmodel.animals.Animal;
import ru.javarush.golf.podkopaev.islandmodel.animals.Bio;
import ru.javarush.golf.podkopaev.islandmodel.util.Randomizer;


public class Mouse extends Herbivore{

    int ProbabilityOfEatCaterpillar = 90;

    public Mouse(int x, int y) {
        super(x, y);
        weight = 0.05;
        maxFullness = 0.01;
        speed = 1;
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
    public Mouse reproduce(Animal animal) {
        return new Mouse(x,y);
    }
}
